/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.daos;

import br.edu.utfpr.cm.webvitae.model.Telefone;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author eduardo
 */
public class DaoTelefone extends DaoGenerics<Telefone> {

    public DaoTelefone() {
        super(Telefone.class);
    }
    
       public int obterUltimoId() {
        List<Telefone> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getId().intValue();
        }
        return 0;
    }
}