/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.daos;

import br.edu.utfpr.cm.webvitae.model.Endereco;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author eduardo
 */
public class DaoEndereco extends DaoGenerics<Endereco> {

    public DaoEndereco() {
        super(Endereco.class);
    }

    public int obterUltimoId() {
        List<Endereco> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getId().intValue();
        }
        return 0;
    }
    
    public void alterar(Endereco endereco) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(endereco);
            session.getTransaction().commit();
        } finally {
            session.close();

        }
    }
}
