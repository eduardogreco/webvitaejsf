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
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author junior
 */
@ManagedBean(name = "listagemComprasBean")
@RequestScoped
public class listagemComprasBean implements Serializable {

    private List<Transacao> compras;
    private Transacao selectedCompra;
    private DaoTransacao daoCompra = new DaoTransacao();
    private List<Transacao> filteredTransacoes;
    private SelectItem[] itens;

    public Transacao getSelectedCompra() {
        return selectedCompra;
    }

    public void setSelectedCompra(Transacao selectedCompra) {
        this.selectedCompra = selectedCompra;
    }

    public List<Transacao> getComprasEmAndamento() {
        compras = daoCompra.listarComprasEmAndamento(LoginBean.usuario);
        return compras;
    }

    public String getValorTotalCompras() {
        Double valorTotal = 0D;
        for (Transacao transacao : compras) {
            valorTotal += transacao.getValorTotal();
        }
        return Moeda.mascaraDinheiro(valorTotal, Moeda.DINHEIRO_REAL);
    }

    public List<Transacao> getTotalCompras() {
        compras = daoCompra.listarTotalCompras(LoginBean.usuario);
        return compras;
    }

    public void setCompras(List<Transacao> Compras) {
        this.compras = Compras;
    }

    public void cancelarCompra() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (daoCompra == null) {
                daoCompra = new DaoTransacao();
            }
            if (selectedCompra != null) {
                selectedCompra.setStatus(Status.CANCELADO.getStatus());
                daoCompra.persistir(selectedCompra);
                context.addMessage(null, new FacesMessage("Sucesso", "Compra cancelada com sucesso."));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Selecione a compra para cancelar!"));
            }

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível cancelar a compra."));
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
        daoCompra = new DaoTransacao();
        compras = daoCompra.listar();
        return itens;
    }
}
