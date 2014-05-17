package br.edu.utfpr.cm.webvitae.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pageManager")
@SessionScoped
public class PageManager implements Serializable {

    public PageManager() {
    }
    private String paginaAtiva = "./admin/home.xhtml";

    public String getPaginaAtiva() {
        return paginaAtiva;
    }

    public void setPaginaAtiva(String paginaAtiva) {
        this.paginaAtiva = paginaAtiva;
    }

    public void setPagFormacao() {
        this.paginaAtiva = "./admin/formacao.xhtml";
    }

    public void setPagCadastro() {
        this.paginaAtiva = "./admin/cadastro.xhtml";
    }
    
    public void setPagSenha() {
        this.paginaAtiva = "./admin/senha.xhtml";
    }

    public void setPagTelefone() {
        this.paginaAtiva = "./admin/telefone.xhtml";
    }

    public void setPagEndereco() {
        this.paginaAtiva = "./admin/endereco.xhtml";
    }

    public void setPagEmail() {
        this.paginaAtiva = "./admin/email.xhtml";
    }
    
    public void setPagObjetivos() {
        this.paginaAtiva = "./admin/objetivo.xhtml";
    }


    public void setPagPerfil() {
        this.paginaAtiva = "./admin/perfil.xhtml";
    }

    public void setPagExperiencia() {
        this.paginaAtiva = "./admin/experiencia.xhtml";
    }
    
     public void setPagListarVagas() {
        this.paginaAtiva = "./admin/listarVagas.xhtml";
    }

    public void setPesquisarCurriculo() {
        this.paginaAtiva = "./admin/pesquisarCurriculo.xhtml";
    }
    
    public void setgerenciarVagas() {
        this.paginaAtiva = "./admin/vagas.xhtml";
    }

}
