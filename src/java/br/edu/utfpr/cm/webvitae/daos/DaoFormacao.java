/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.daos;

import br.edu.utfpr.cm.webvitae.model.Formacao;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author eduardogreco
 */
public class DaoFormacao extends DaoGenerics<Formacao> {

    public DaoFormacao() {
        super(Formacao.class);
    }

    public int obterUltimoId() {
        List<Formacao> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getId().intValue();
        }
        return 0;
    }

    public void alterar(Formacao formacao) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(formacao);
            session.getTransaction().commit();
        } finally {
            session.close();

        }
    }
}
