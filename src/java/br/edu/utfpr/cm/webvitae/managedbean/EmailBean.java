/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoEmail;
import br.edu.utfpr.cm.webvitae.login.LoginBean;
import br.edu.utfpr.cm.webvitae.model.Email;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author eduardo
 */
@ManagedBean(name = "emailBean")
@RequestScoped
public class EmailBean implements Serializable {

    private DaoEmail daoEmail = new DaoEmail();
    private static Email email;
    private int idEmail = 0;

    public EmailBean() {
        if (email == null) {
            email = new Email();
        }
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email e) {
        email = e;
    }

    public void addEmail() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            email.setPessoa(LoginBean.usuario);
            daoEmail.persistir(email);
            email = new Email();
            context.addMessage(null, new FacesMessage("Sucesso", "O e-mail foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o email."));
            e.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoEmail == null) {
            daoEmail = new DaoEmail();
        }
        if (email.getId() == null) {
            idEmail = (daoEmail.obterUltimoId() + 1);
        } else {
            idEmail = email.getId().intValue();
        }
    }

    public int getId() {
        return idEmail;
    }

    public void setPrincipal() {
        int id = 0;
        if (email.getId() != null) {
            id = email.getId().intValue();
        }
        if (id == 0) {
            id = (daoEmail.obterUltimoId() + 1);
        }

    }

}
