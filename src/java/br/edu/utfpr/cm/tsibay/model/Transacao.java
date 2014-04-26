/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.model;

import br.edu.utfpr.cm.tsibay.daos.DaoComissao;
import br.edu.utfpr.cm.tsibay.util.Moeda;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author junior
 */
@Entity
@Table(name = "TRANSACAO")
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10, nullable = false, unique = true)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private int qtdeProduto;
    private Double valorUnitario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date prazoValidade;
    private String tpPagamento;
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa comprador;
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa vendedor;
    private String frete;
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;
    private String status;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public String getValorUnitarioFormatado() {
        return Moeda.mascaraDinheiro(valorUnitario, Moeda.DINHEIRO_REAL);
    }

    public String getValorTotalFormatado() {
        return Moeda.mascaraDinheiro((valorUnitario * qtdeProduto), Moeda.DINHEIRO_REAL);

    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Date getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(Date prazoValidade) {
        this.prazoValidade = prazoValidade;
    }

    public String getTpPagamento() {
        return tpPagamento;
    }

    public void setTpPagamento(String tpPagamento) {
        this.tpPagamento = tpPagamento;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public Pessoa getVendedor() {
        return vendedor;
    }

    public void setVendedor(Pessoa vendedor) {
        this.vendedor = vendedor;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return (valorUnitario * qtdeProduto);
    }

    public String getCalculoComissao() {
        DaoComissao daoComissao = new DaoComissao();
        Double total = (getValorTotal() * (daoComissao.obterComissaoAtual()/100));
        return Moeda.mascaraDinheiro(total, Moeda.DINHEIRO_REAL);
    }
}
