/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.controller;


import br.edu.utfpr.cm.webvitae.daos.DaoPessoa;
import br.edu.utfpr.cm.webvitae.model.Pessoa;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


/**
 *
 * @author willian
 */
@ManagedBean
@ViewScoped
public class CadastroLoginBean {
    private Pessoa pessoa;
    private DaoPessoa daoPessoa = new DaoPessoa();


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa e) {
        pessoa = e;
    }

    public CadastroLoginBean() {
        pessoa = new Pessoa();
    }

    
    public void addPessoa() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            
            pessoa.setTipo("usuario");
            daoPessoa.persistir(pessoa);
            pessoa = new Pessoa();
            context.addMessage(null, new FacesMessage("Sucesso", "Cadastro realizado com sucesso!"));
            
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o cadastro."));
            e.printStackTrace();
        }
    }
}
