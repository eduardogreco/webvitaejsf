/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import br.edu.utfpr.cm.tsibay.admin.login.LoginBean;
import br.edu.utfpr.cm.tsibay.controller.UploadArquivo;
import br.edu.utfpr.cm.tsibay.daos.DaoFamilia;
import br.edu.utfpr.cm.tsibay.daos.DaoProduto;
import br.edu.utfpr.cm.tsibay.model.Familia;
import br.edu.utfpr.cm.tsibay.model.Imagem;
import br.edu.utfpr.cm.tsibay.model.Pessoa;
import br.edu.utfpr.cm.tsibay.model.Produto;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author junior
 */
@ManagedBean(name = "produtoBean")
@RequestScoped
public class ProdutoBean implements Serializable {

    private DaoProduto daoProduto = new DaoProduto();
    private static Produto produto;
    private Imagem selectedImagem;
    private UploadArquivo arquivo = new UploadArquivo();
    private static List<Imagem> imagens;
    private int idProduto = 0;

    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {
        if (produto == null) {
            produto = new Produto();
            imagens = new ArrayList<Imagem>();
        }
        produto.setData(new Date());
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto p) {
        produto = p;
    }

    public void addProduto() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (imagens != null && !imagens.isEmpty()) {
                if (produto.getFamilia() == null) {
                    Familia familia = new DaoFamilia().obterFamilia("Outros");
                    if (familia == null) {
                        familia = new Familia("Outros");
                    }
                    produto.setFamilia(familia);
                }
                for (Imagem imagem : imagens) {
                    imagem.setProduto(produto);
                }
                setPrincipal();
                if (produto.getQtdeVendida() != null) {
                    produto.setQtdeDisponivel(produto.getQuantidade() - produto.getQtdeVendida());
                } else {
                    produto.setQtdeDisponivel(produto.getQuantidade());
                }
                produto.setPessoa(LoginBean.usuario);
                produto.setImagens(imagens);

                daoProduto.persistir(produto);
                produto = new Produto();
                imagens = new ArrayList<Imagem>();
                context.addMessage(null, new FacesMessage("Sucesso", "O produto foi inserido com sucesso!"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "É necessário informar pelo menos uma imagem!"));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Erro", "Erro ao gravar o produto."));
            e.printStackTrace();
        }
    }

    public void uploadAction(FileUploadEvent event) {
        String nome = "";
        if (daoProduto == null) {
            daoProduto = new DaoProduto();
        }
        if (produto.getId() == null) {
            idProduto = (daoProduto.obterUltimoId() + 1);
        } else {
            idProduto = produto.getId().intValue();
        }
        if (imagens == null && produto.getImagens() == null) {
            imagens = new ArrayList<Imagem>();
        } else if (imagens == null) {
            imagens = produto.getImagens();
        }
        if (!imagens.isEmpty()) {
            nome = idProduto + "-" + getUltimoNome(imagens.get(imagens.size() - 1).getImagem()) + getExtensaoImagem(event.getFile().getFileName());
        } else {
            nome = idProduto + "-0" + getExtensaoImagem(event.getFile().getFileName());
        }

        imagens.add(new Imagem(nome));
        this.arquivo.fileUpload(event, getExtensaoImagem(nome), "/resources/produtos/" + idProduto + "/", nome);
        this.arquivo.gravar();
        arquivo = new UploadArquivo();
    }

    public String getExtensaoImagem(String nome) {
        return nome.substring(nome.lastIndexOf("."), nome.length());
    }

    public String getUltimoNome(String nome) {
        nome = nome.substring(nome.lastIndexOf("-"), nome.lastIndexOf("."));
        nome = nome.replace("-", "");
        Integer valor = Integer.valueOf(nome) + 1;
        return valor.toString();
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public int getId() {
        return idProduto;
    }

    public void setPrincipal() {
        int id = 0;
        if (produto.getId() != null) {
            id = produto.getId().intValue();
        }
        if (id == 0) {
            id = (daoProduto.obterUltimoId() + 1);
        }
        for (Imagem imagem : imagens) {
            if (imagem.getPrincipal()) {
                produto.setUriImagem("resources/produtos/" + id + "/" + imagem.getImagem());
                return;
            }
        }
        if (imagens != null) {
            produto.setUriImagem("resources/produtos/" + id + "/" + imagens.get(0).getImagem());
        }

    }

    public boolean verificaQuantidade() {
        if (imagens.size() >= 10) {
            return false;
        }
        return true;
    }

    public void imagemDelete() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            imagens.remove(selectedImagem);
            context.addMessage(null, new FacesMessage("Sucesso", "Imagem removida com sucesso."));

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível remover a imagem."));
            ex.printStackTrace();
        }
    }

    public Imagem getSelectedImagem() {
        return selectedImagem;
    }

    public void setSelectedImagem(Imagem selectedImagem) {
        this.selectedImagem = selectedImagem;
    }
    
    public List<String> getTiposPagamento(){
        List<String> tipos = new ArrayList<String>();
        tipos.add("À Combinar");
        tipos.add("Grátis");
        tipos.add("Por conta do comprador");
        return tipos;
    }
}
