/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.daos;

import br.edu.utfpr.cm.tsibay.model.Comissao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author junior
 */
public class DaoComissao extends DaoGenerics<Comissao> {

    public DaoComissao() {
        super(Comissao.class);
    }

    public Double obterComissaoAtual() {
        List<Comissao> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getPorcentagem();
        }
        return 0D;
    }
}
