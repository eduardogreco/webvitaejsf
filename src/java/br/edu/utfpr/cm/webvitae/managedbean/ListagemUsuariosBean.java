/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.managedbean;

import br.edu.utfpr.cm.webvitae.daos.DaoPessoa;
import br.edu.utfpr.cm.webvitae.model.Pessoa;
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
@ManagedBean(name = "listagemUsuariosBean")
@RequestScoped
public class ListagemUsuariosBean implements Serializable {

    private List<Pessoa> pessoas;
    private Pessoa selectedPessoa;
    private DaoPessoa daoPessoa = new DaoPessoa();
    private List<Pessoa> filteredPessoas;
    private SelectItem[] itens;

    public ListagemUsuariosBean() {
        pessoas = new ArrayList<Pessoa>();
        buscarUsuarios();
    }

    public Pessoa getSelectedPessoa() {
        return selectedPessoa;
    }

    public void setSelectedPessoa(Pessoa selectedPessoa) {
        this.selectedPessoa = selectedPessoa;
    }

    public List<Pessoa> getPessoas() {
        pessoas = daoPessoa.listar();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> disciplinas) {
        this.pessoas = disciplinas;
    }

    @PostConstruct
    public void construct() {
        setSelectedPessoa(new Pessoa());
    }

//    public String editPessoa() {
//        DaoPessoa daoPessoa = new DaoPessoa();
//        daoPessoa.persistir(this.selectedPessoa);
//
//        this.selectedPessoa = new Pessoa();
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        context.addMessage(null, new FacesMessage("Successful", "Pessoa Editada!"));
//        return "edit_subject";
////        context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));
//    }
    public void deletePessoa() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            daoPessoa.remover(this.selectedPessoa);
            this.selectedPessoa = new Pessoa();
            context.addMessage(null, new FacesMessage("Sucesso", "Usuário removido com sucesso."));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover o usuário."));
            ex.printStackTrace();
        }
    }

    public List<Pessoa> getFilteredPessoas() {
        return filteredPessoas;
    }

    public void setFilteredPessoas(List<Pessoa> filteredPessoas) {
        this.filteredPessoas = filteredPessoas;
    }

    public SelectItem[] getItens() {
        buscarUsuarios();
        return itens;
    }

    private void buscarUsuarios() {
        pessoas = daoPessoa.listar();
    }
}
