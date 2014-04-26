/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import br.edu.utfpr.cm.tsibay.daos.DaoComissao;
import br.edu.utfpr.cm.tsibay.daos.DaoTransacao;
import br.edu.utfpr.cm.tsibay.model.Transacao;
import br.edu.utfpr.cm.tsibay.util.Moeda;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author junior
 */
@ManagedBean(name = "listagemMovimentacoesBean")
@RequestScoped
public class listagemMovimentacoesBean implements Serializable {

    private List<Transacao> transacoes;
    private Transacao selectedTransacao;
    private DaoTransacao daoTransacao = new DaoTransacao();
    private List<Transacao> filteredTransacoes;
    private SelectItem[] itens;

    public List<Transacao> getTransacoes() {
        transacoes = daoTransacao.listar();
        return transacoes;
    }
    
     public List<Transacao> getTransacoesEmAndamento() {
        transacoes = daoTransacao.listarTransacoesEmAndamento();
        return transacoes;
    }

    public String getValorTotal() {
        Double valorTotal = 0D;
        for (Transacao transacao : transacoes) {
            valorTotal += transacao.getValorTotal();
        }
        return Moeda.mascaraDinheiro(valorTotal, Moeda.DINHEIRO_REAL);
    }

    public String getValorTotalComissao() {
        Double valorTotal = 0D;
        DaoComissao daoComissao = new DaoComissao();
        for (Transacao transacao : transacoes) {
            valorTotal += (transacao.getValorTotal() * (daoComissao.obterComissaoAtual() / 100));
      
        }
        return Moeda.mascaraDinheiro(valorTotal, Moeda.DINHEIRO_REAL);
    }

    public Transacao getSelectedTransacao() {
        return selectedTransacao;
    }

    public void setSelectedTransacao(Transacao selectedTransacao) {
        this.selectedTransacao = selectedTransacao;
    }

    public List<Transacao> getFilteredTransacoes() {
        return filteredTransacoes;
    }

    public void setFilteredTransacoes(List<Transacao> filteredTransacoes) {
        this.filteredTransacoes = filteredTransacoes;
    }

    public SelectItem[] getItens() {
        daoTransacao = new DaoTransacao();
        transacoes = daoTransacao.listar();
        return itens;
    }
}
