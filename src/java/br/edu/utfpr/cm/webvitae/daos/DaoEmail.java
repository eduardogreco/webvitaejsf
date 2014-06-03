/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.daos;

import br.edu.utfpr.cm.webvitae.controller.TransactionManager;
import br.edu.utfpr.cm.webvitae.model.Email;
import br.edu.utfpr.cm.webvitae.model.Pessoa;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author eduardogreco
 */
public class DaoEmail extends DaoGenerics<Email> {

    protected Session session = TransactionManager.getCurrentSession();

    public DaoEmail() {
        super(Email.class);
    }

    public int obterUltimoId() {
        List<Email> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getId().intValue();
        }
        return 0;
    }

    public void alterar(Email email) {

        try {
            session.beginTransaction();
            session.saveOrUpdate(email);
            session.getTransaction().commit();
        } finally {
            session.close();

        }
    }

    @SuppressWarnings("unchecked")
    public List listar() {
        try {
            Criteria cri = session.createCriteria(Email.class);
            return cri.list();
        } finally {
            session.close();

        }
    }

    public void excluir(Email email) {

        try {
            session.beginTransaction();
            session.delete(email);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }

}
