/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import br.edu.utfpr.cm.tsibay.admin.login.LoginBean;
import br.edu.utfpr.cm.tsibay.daos.DaoTransacao;
import br.edu.utfpr.cm.tsibay.model.Status;
import br.edu.utfpr.cm.tsibay.model.Transacao;
import br.edu.utfpr.cm.tsibay.util.Moeda;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name = "comissaoPagarBean")
@RequestScoped
public class ComissoesPagarBean {
    
    private List<Transacao> vendas;
    private Transacao selectedVenda;
    private DaoTransacao daoVenda = new DaoTransacao();
    private List<Transacao> filteredTransacoes;
    private SelectItem[] itens;

    public Transacao getSelectedVenda() {
        return selectedVenda;
    }

    public void setSelectedVenda(Transacao selectedVenda) {
        this.selectedVenda = selectedVenda;
    }

    public List<Transacao> getVendasEmAndamento() {
        vendas = daoVenda.listarVendasEmAndamento(LoginBean.usuario);
        return vendas;
    }

    public String getValorTotalVendas() {
        Double valorTotal = 0D;
        for (Transacao transacao : vendas) {
            valorTotal += transacao.getValorTotal();
        }
        return Moeda.mascaraDinheiro(valorTotal, Moeda.DINHEIRO_REAL);
    }

    public List<Transacao> getTotalVendas() {
        vendas = daoVenda.listarTotalVendas(LoginBean.usuario);
        return vendas;
    }

    public void setVendas(List<Transacao> vendas) {
        this.vendas = vendas;
    }

    public void cancelarVenda() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (daoVenda == null) {
                daoVenda = new DaoTransacao();
            }
            if (selectedVenda != null) {
                selectedVenda.setStatus(Status.CANCELADO.getStatus());
                daoVenda.persistir(selectedVenda);
                context.addMessage(null, new FacesMessage("Sucesso", "Venda cancelada com sucesso."));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Selecione a venda para cancelar!"));
            }

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível cancelar a venda."));
            ex.printStackTrace();
        }
    }

    public void concluirVenda() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (daoVenda == null) {
                daoVenda = new DaoTransacao();
            }
            if (selectedVenda != null) {
                selectedVenda.setStatus(Status.CONCLUIDO.getStatus());
                daoVenda.persistir(selectedVenda);
                context.addMessage(null, new FacesMessage("Sucesso", "Venda conluída com sucesso."));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Selecione a venda para concluir!"));
            }

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível concluir a venda."));
            ex.printStackTrace();
        }
    }

    public List<Transacao> getFilteredTransacoes() {
        return filteredTransacoes;
    }

    public void setFilteredTransacoes(List<Transacao> filteredTransacoes) {
        this.filteredTransacoes = filteredTransacoes;
    }

    public SelectItem[] getItens() {
        daoVenda = new DaoTransacao();
        vendas = daoVenda.listar();
        return itens;
    }

}
