/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.cm.webvitae.daos;

import br.edu.utfpr.cm.webvitae.model.Objetivo;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author eduardogreco
 */
public class DaoObjetivo  extends DaoGenerics<Objetivo>  {

    public DaoObjetivo() {
        super(Objetivo.class);
    }
    
       public int obterUltimoId() {
        List<Objetivo> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getId().intValue();
        }
        return 0;
    }
       
       public List<Objetivo> listarPorUsuario(Long id) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " p WHERE pessoa_id = " + id.intValue() + "");
        return query.list();
    }
    
}
