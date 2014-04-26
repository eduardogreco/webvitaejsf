/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.daos;

import br.edu.utfpr.cm.tsibay.model.Familia;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Alex
 */
public class DaoFamilia extends DaoGenerics<Familia> {

    public DaoFamilia() {
        super(Familia.class);
    }

    public Familia obterFamilia(String filtro) {
        List<Familia> lista = null;
        if (filtro != null) {
            Query query = session.createQuery("FROM " + alvo.getSimpleName() + " WHERE nome LIKE '" + filtro + "'");
            lista = query.list();
        }
        return lista.get(0);
    }
}