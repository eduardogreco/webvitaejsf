/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.daos;

import br.edu.utfpr.cm.webvitae.model.Pessoa;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author eduardo
 */
public class DaoPessoa extends DaoGenerics<Pessoa> {

    public DaoPessoa() {
        super(Pessoa.class);
    }

    public Pessoa obterPorLogin(String login) {
        List<Pessoa> pessoas = null;
        Query query = session.createQuery("FROM " + alvo.getSimpleName()
                + " WHERE login LIKE '" + login + "'");
        pessoas = query.list();
        if (!pessoas.isEmpty()) {
            return pessoas.get(0);
        }
        return null;
    }

    public Pessoa getLogin(String login, String senha) {

        List<Pessoa> pessoas = this.listar();

        for (Pessoa p : pessoas) {
            if (p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                return p;
            }
        }

        return null;
    }
}
