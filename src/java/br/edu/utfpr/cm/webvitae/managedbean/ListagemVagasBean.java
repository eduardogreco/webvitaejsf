/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.controller.HibernateConfiguration;
import br.edu.utfpr.cm.webvitae.daos.DaoVaga;
import br.edu.utfpr.cm.webvitae.model.Vagas;
import static com.sun.faces.facelets.util.Path.context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author junior
 */
@ManagedBean(name = "listagemVagasBean")
@RequestScoped
public class ListagemVagasBean implements Serializable {

    private List<Vagas> vagas;
    private Vagas selectedVaga;
    private DaoVaga daoVaga = new DaoVaga();
    private List<Vagas> filteredVagas;
    private SelectItem[] itens;

    public ListagemVagasBean() {
        vagas = new ArrayList<Vagas>();
        buscarUsuarios();
    }

    public Vagas getSelectedVagas() {
        return selectedVaga;
    }

    public void setSelectedVagas(Vagas selectedVaga) {
        this.selectedVaga = selectedVaga;
    }

    public List<Vagas> getVagass() {
        vagas = daoVaga.listar();
        return vagas;
    }

    public void setVagas(List<Vagas> disciplinas) {
        this.vagas = disciplinas;
    }

    @PostConstruct
    public void construct() {
        setSelectedVagas(new Vagas());
    }

//    public String editVagas() {
//        DaoVagas daoVagas = new DaoVagas();
//        daoVagas.persistir(this.selectedVagas);
//
//        this.selectedVagas = new Vagas();
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        context.addMessage(null, new FacesMessage("Successful", "Vagas Editada!"));
//        return "edit_subject";
////        context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));
//    }
    public void deleteVagas() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
                daoVaga.remover(this.selectedVaga);
                this.selectedVaga = new Vagas();
                context.addMessage(null, new FacesMessage("Sucesso", "Usuário removido com sucesso."));
            }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover o usuário."));
            ex.printStackTrace();
        }
    }

    public List<Vagas> getFilteredVagass() {
        return filteredVagas;
    }

    public void setFilteredVagass(List<Vagas> filteredVagass) {
        this.filteredVagas = filteredVagass;
    }

    public SelectItem[] getItens() {
        buscarUsuarios();
        return itens;
    }

    private void buscarUsuarios() {
        vagas = daoVaga.listar();
    }
}
