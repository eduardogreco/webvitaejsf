/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoEndereco;
import br.edu.utfpr.cm.webvitae.login.LoginBean;
import br.edu.utfpr.cm.webvitae.model.Endereco;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author eduardogreco
 */
@ManagedBean(name = "enderecoBean")
@RequestScoped
public class EnderecoBean implements Serializable {

    private DaoEndereco daoEndereco = new DaoEndereco();
    private static Endereco endereco;
    private int idEndereco = 0;

    public EnderecoBean() {
        if (endereco == null) {
            endereco = new Endereco();
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco e) {
        endereco = e;
    }

    public void addEndereco() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            endereco.setPessoa(LoginBean.usuario);
            daoEndereco.persistir(endereco);
            endereco = new Endereco();
            context.addMessage(null, new FacesMessage("Sucesso", "O e-mail foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o email."));
            e.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoEndereco == null) {
            daoEndereco = new DaoEndereco();
        }
        if (endereco.getId() == null) {
            idEndereco = (daoEndereco.obterUltimoId() + 1);
        } else {
            idEndereco = endereco.getId().intValue();
        }
    }

    public int getId() {
        return idEndereco;
    }

    public void setPrincipal() {
        int id = 0;
        if (endereco.getId() != null) {
            id = endereco.getId().intValue();
        }
        if (id == 0) {
            id = (daoEndereco.obterUltimoId() + 1);
        }

    }

}