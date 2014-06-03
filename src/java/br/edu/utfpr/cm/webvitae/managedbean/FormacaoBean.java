/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoFormacao;
import br.edu.utfpr.cm.webvitae.login.LoginBean;
import br.edu.utfpr.cm.webvitae.model.Formacao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author eduardogreco
 */
@ManagedBean(name = "formacaoBean")
@RequestScoped
public class FormacaoBean implements Serializable {

    List formacoes = new ArrayList();
    private DaoFormacao daoFormacao = new DaoFormacao();
    private static Formacao formacao;
    private int idFormacao = 0;

    public FormacaoBean() {
        if (formacao == null) {
            formacao = new Formacao();
        }
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao e) {
        formacao = e;
    }

    public void addFormacao() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            formacao.setPessoa(LoginBean.usuario);
            daoFormacao.persistir(formacao);
            formacao = new Formacao();
            context.addMessage(null, new FacesMessage("Sucesso", "Formação foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o email."));
            e.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoFormacao == null) {
            daoFormacao = new DaoFormacao();
        }
        if (formacao.getId() == null) {
            idFormacao = (daoFormacao.obterUltimoId() + 1);
        } else {
            idFormacao = formacao.getId().intValue();
        }
    }

    public int getId() {
        return idFormacao;
    }

    public void setPrincipal() {
        int id = 0;
        if (formacao.getId() != null) {
            id = formacao.getId().intValue();
        }
        if (id == 0) {
            id = (daoFormacao.obterUltimoId() + 1);
        }

    }

    public void deleteFormacao() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DaoFormacao daoFormacao = new DaoFormacao();
            daoFormacao.remover(formacao);
            formacoes = new DaoFormacao().listar();
            formacao = new Formacao();
            context.addMessage(null, new FacesMessage("Sucesso", "Formação removida com sucesso."));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover o usuário."));
            ex.printStackTrace();
        }
    }

    public void alterar(ActionEvent actionEvent) {
        daoFormacao.alterar(formacao);
        formacoes = new DaoFormacao().listar();
        formacao = new Formacao();
    }

}
