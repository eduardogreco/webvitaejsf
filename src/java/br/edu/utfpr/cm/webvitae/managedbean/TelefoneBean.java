 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoPessoa;
import br.edu.utfpr.cm.webvitae.daos.DaoTelefone;
import br.edu.utfpr.cm.webvitae.login.LoginBean;
import br.edu.utfpr.cm.webvitae.model.Email;
import br.edu.utfpr.cm.webvitae.model.Pessoa;
import br.edu.utfpr.cm.webvitae.model.Telefone;
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
/**
 *
 * @author eduardo
 */
@ManagedBean(name = "telefoneBean")
@RequestScoped
public class TelefoneBean implements Serializable {

     List telefones = new ArrayList();
    private DaoTelefone daoTelefone = new DaoTelefone();
    private static Telefone telefone;
    public static Pessoa usuario;
    private static DaoPessoa daoPessoa = new DaoPessoa();
    private int idTelefone = 0;

    public TelefoneBean() {
        if (telefone == null) {
            telefone = new Telefone();
        }
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone e) {
        telefone = e;
    }

    public void addTelefone() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            telefone.setPessoa(LoginBean.usuario);
            daoTelefone.persistir(telefone);
            telefone = new Telefone();
            context.addMessage(null, new FacesMessage("Sucesso", "O Telefone foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o telefone."));
            e.printStackTrace();
        }
    }

     public void deleteTelefone() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DaoTelefone daoTelefone = new DaoTelefone();
            daoTelefone.remover(telefone);
            telefones = new DaoTelefone().listar();
            telefone = new Telefone();
            context.addMessage(null, new FacesMessage("Sucesso", "Telefone removido com sucesso."));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover o usuário."));
            ex.printStackTrace();
        }
    }

    public void alterar(ActionEvent actionEvent) {
        daoTelefone.alterar(telefone);
        telefones = new DaoTelefone().listar();
        telefone = new Telefone();
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoTelefone == null) {
            daoTelefone = new DaoTelefone();
        }
        if (telefone.getId() == null) {
            idTelefone = (daoTelefone.obterUltimoId() + 1);
        } else {
            idTelefone = telefone.getId().intValue();
        }
    }

    public int getId() {
        return idTelefone;
    }

    public void setPrincipal() {
        int id = 0;
        if (telefone.getId() != null) {
            id = telefone.getId().intValue();
        }
        if (id == 0) {
            id = (daoTelefone.obterUltimoId() + 1);
        }

    }

}
