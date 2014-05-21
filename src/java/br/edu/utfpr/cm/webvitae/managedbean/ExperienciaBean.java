/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoExperiencia;
import br.edu.utfpr.cm.webvitae.login.LoginBean;
import br.edu.utfpr.cm.webvitae.model.Experiencia;
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
@ManagedBean(name = "experienciaBean")
@RequestScoped
public class ExperienciaBean implements Serializable {

    List experiencias = new ArrayList();
    private DaoExperiencia daoExperiencia = new DaoExperiencia();
    private static Experiencia experiencia;
    private int idExperiencia = 0;

    public ExperienciaBean() {
        if (experiencia == null) {
            experiencia = new Experiencia();
        }
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia e) {
        experiencia = e;
    }

    public void addExperiencia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            experiencia.setPessoa(LoginBean.usuario);
            daoExperiencia.persistir(experiencia);
            experiencia = new Experiencia();
            context.addMessage(null, new FacesMessage("Sucesso", "Experiência foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o email."));
            e.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoExperiencia == null) {
            daoExperiencia = new DaoExperiencia();
        }
        if (experiencia.getId() == null) {
            idExperiencia = (daoExperiencia.obterUltimoId() + 1);
        } else {
            idExperiencia = experiencia.getId().intValue();
        }
    }

    public int getId() {
        return idExperiencia;
    }

    public void setPrincipal() {
        int id = 0;
        if (experiencia.getId() != null) {
            id = experiencia.getId().intValue();
        }
        if (id == 0) {
            id = (daoExperiencia.obterUltimoId() + 1);
        }

    }

    public void alterar(ActionEvent actionEvent) {
        daoExperiencia.alterar(experiencia);
        experiencias = new DaoExperiencia().listar();
        experiencia = new Experiencia();
    }
    
      public void deleteExperiencia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DaoExperiencia daoExperiencia = new DaoExperiencia();
            daoExperiencia.remover(experiencia);
            experiencias = new DaoExperiencia().listar();
            experiencia = new Experiencia();
            context.addMessage(null, new FacesMessage("Sucesso", "Experiencia removido com sucesso."));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover o usuário."));
            ex.printStackTrace();
        }
    }

}
