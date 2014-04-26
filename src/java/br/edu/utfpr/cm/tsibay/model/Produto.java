/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author junior
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @OneToOne(mappedBy = "produto")
    private Imagem imagem;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10, nullable = false, unique = true)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private String descricao;
    private String fabricante;
    private String nome;
    private Double precoVenda;
    private Integer qtdeVendida;
    private Integer quantidade;
    private Integer qtdeDisponivel;
    private String uriImagem;
    @ManyToOne(fetch = FetchType.EAGER)
    private Familia familia;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtLimiteVenda;
    private Boolean ofertado;
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa pessoa;
    private Integer prazo;
    private String frete;
    private boolean principal;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Imagem> imagens;

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }


    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(Integer qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    public void setQtdeDisponivel(Integer qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Date getDtLimiteVenda() {
        return dtLimiteVenda;
    }

    public void setDtLimiteVenda(Date dtLimiteVenda) {
        this.dtLimiteVenda = dtLimiteVenda;
    }

    public Boolean getOfertado() {
        return ofertado;
    }

    public void setOfertado(Boolean ofertado) {
        this.ofertado = ofertado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public String getUriImagem() {
        return uriImagem;
    }

    public void setUriImagem(String uriImagem) {
        this.uriImagem = uriImagem;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}
