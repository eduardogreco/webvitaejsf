/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoPessoa;
import br.edu.utfpr.cm.webvitae.daos.DaoVaga;
import br.edu.utfpr.cm.webvitae.model.Pessoa;
import br.edu.utfpr.cm.webvitae.model.Vagas;
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
@ManagedBean(name = "vagasBean")
@RequestScoped
public class VagasBean implements Serializable {

    private DaoVaga daoVaga = new DaoVaga();
    private static Vagas vaga;
    public static Pessoa usuario;
    private static DaoPessoa daoPessoa = new DaoPessoa();
    private int idVaga = 0;

    public VagasBean() {
        if (vaga == null) {
            vaga = new Vagas();
        }
    }

    public Vagas getVagas() {
        return vaga;
    }

    public void setVagas(Vagas e) {
        vaga = e;
    }

    public void addVagas() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            daoVaga.persistir(vaga);
            vaga = new Vagas();
            context.addMessage(null, new FacesMessage("Sucesso", "O Telefone foi inserido com sucesso!"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o telefone."));
            e.printStackTrace();
        }
    }

    public void deleteTelefone(int id_tel) {
        vaga = daoVaga.obterPorId(id_tel);
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            daoVaga.remover(vaga);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover o usuário."));
            ex.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoVaga == null) {
            daoVaga = new DaoVaga();
        }
        if (vaga.getId() == null) {
            idVaga = (daoVaga.obterUltimoId() + 1);
        } else {
            idVaga = vaga.getId().intValue();
        }
    }

    public int getId() {
        return idVaga;
    }

    public void setPrincipal() {
        int id = 0;
        if (vaga.getId() != null) {
            id = vaga.getId().intValue();
        }
        if (id == 0) {
            id = (daoVaga.obterUltimoId() + 1);
        }

    }

}
