/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.daos;

import br.edu.utfpr.cm.tsibay.model.Pessoa;
import br.edu.utfpr.cm.tsibay.model.Produto;
import br.edu.utfpr.cm.tsibay.model.Status;
import br.edu.utfpr.cm.tsibay.model.Transacao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Alex
 */
public class DaoTransacao extends DaoGenerics<Transacao> {

    public DaoTransacao() {
        super(Transacao.class);
    }

    public List<Transacao> listarVendasEmAndamento(Pessoa pessoa) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE vendedor.id = " + pessoa.getId().intValue() + " AND status = '" + Status.EM_ANDAMENTO.getStatus() + "'");
        return query.list();
    }

    public List<Transacao> listarComprasEmAndamento(Pessoa pessoa) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE comprador.id = " + pessoa.getId().intValue() + " AND status = '" + Status.EM_ANDAMENTO.getStatus() + "'");
        return query.list();
    }
    public List<Transacao> listarTransacoesEmAndamento() {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE status = '" + Status.EM_ANDAMENTO.getStatus() + "'");
        return query.list();
    }

    public List<Transacao> listarTotalVendas(Pessoa pessoa) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE vendedor.id = " + pessoa.getId().intValue());
        return query.list();
    }

    public List<Transacao> listarTotalCompras(Pessoa pessoa) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE comprador.id = " + pessoa.getId().intValue());
        return query.list();
    }
    public boolean verificaDependencias(Produto produto) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE produto.id = " + produto.getId().intValue());
        return query.list().isEmpty();
    }
}