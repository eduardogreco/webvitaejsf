/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoObjetivo;
import br.edu.utfpr.cm.webvitae.login.LoginBean;
import br.edu.utfpr.cm.webvitae.model.Objetivo;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author eduardogreco
 */
@ManagedBean(name = "objetivoBean")
@RequestScoped
public class ObjetivoBean implements Serializable {

    private DaoObjetivo daoObjetivo = new DaoObjetivo();
    private static Objetivo objetivo;
    private int idObjetivo = 0;

   public ObjetivoBean() {
        if (objetivo == null) {
            objetivo = new Objetivo();
        }
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo e) {
        objetivo = e;
    }

    public void addObjetivo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Long userLogado = LoginBean.usuario.getId();
            objetivo.setPessoa(LoginBean.usuario);
            daoObjetivo.persistir(objetivo);
            objetivo = new Objetivo();
            daoObjetivo.listarPorUsuario(userLogado);
            context.addMessage(null, new FacesMessage("Sucesso", "Formação foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o email."));
            e.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoObjetivo == null) {
            daoObjetivo = new DaoObjetivo();
        }
        if (objetivo.getId() == null) {
            idObjetivo = (daoObjetivo.obterUltimoId() + 1);
        } else {
            idObjetivo = objetivo.getId().intValue();
        }
    }

    public int getId() {
        return idObjetivo;
    }

    public void setPrincipal() {
        int id = 0;
        if (objetivo.getId() != null) {
            id = objetivo.getId().intValue();
        }
        if (id == 0) {
            id = (daoObjetivo.obterUltimoId() + 1);
        }

    }

}



