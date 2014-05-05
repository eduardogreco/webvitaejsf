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

    public void setPagProdutos() {
        this.paginaAtiva = "./admin/produtos.xhtml";
    }

    public void setPagCadastro() {
        this.paginaAtiva = "./admin/cadastro.xhtml";
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

    public void setPagComissoes() {
        this.paginaAtiva = "./admin/comissoes.xhtml";
    }

    public void setPagCompras() {
        this.paginaAtiva = "./admin/compras.xhtml";
    }

    public void setPagConsultarMovimentacoes() {
        this.paginaAtiva = "./admin/consultar_movimentacoes.xhtml";
    }

    public void setPagGerenciarComissoes() {
        this.paginaAtiva = "./admin/gerenciar_comissoes.xhtml";
    }

    public void setPagListarCompras() {
        this.paginaAtiva = "./admin/listar_compras.xhtml";
    }

    public void setPagListarProdutos() {
        this.paginaAtiva = "./admin/listar_produtos.xhtml";
    }

    public void setPagListarVendas() {
        this.paginaAtiva = "./admin/listar_vendas.xhtml";
    }

    public void setPagPerfil() {
        this.paginaAtiva = "./admin/perfil.xhtml";
    }

    public void setPagSenha() {
        this.paginaAtiva = "./admin/senha.xhtml";
    }

    public void setPagVendas() {
        this.paginaAtiva = "./admin/vendas.xhtml";
    }

    public void setGerenciarUsuarios() {
        this.paginaAtiva = "./admin/gerenciar_usuarios.xhtml";
    }

    public void setComissoesReceber() {
        this.paginaAtiva = "./admin/comissoes_receber.xhtml";
    }

    public void setPagListarVendedores() {
        this.paginaAtiva = "./admin/listar_vendedores.xhtml";
    }

    public void setPagListarTodosProdutos() {
        this.paginaAtiva = "./admin/listar_todos_produtos.xhtml";
    }
}
