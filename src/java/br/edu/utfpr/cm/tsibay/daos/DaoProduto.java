/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.daos;

import br.edu.utfpr.cm.tsibay.model.Produto;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Alex
 */
public class DaoProduto extends DaoGenerics<Produto> {

    public DaoProduto() {
        super(Produto.class);
    }

    public List<Produto> listarProdutosPorFamilia(int idFamilia) {

        List<Produto> produtos = null;
        Query query = session.createQuery("FROM " + alvo.getSimpleName()
                + " WHERE ofertado = 0 AND familia_id = " + idFamilia);
        produtos = query.list();
        return produtos;
    }

    public List<Produto> listarProdutosUltimos() {
        List<Produto> produtos = null;
        Query query = session.createQuery("FROM " + alvo.getSimpleName()
                + " WHERE ofertado = 0 ORDER BY id DESC");
        query.setMaxResults(9);
        produtos = query.list();
        return produtos;
    }

    public List<Produto> listarProdutosPorDescricao(String pesquisa) {
        List<Produto> produtos = null;
        if (pesquisa != null) {
            Query query = session.createQuery("FROM " + alvo.getSimpleName()
                    + " WHERE nome LIKE '%" + pesquisa + "%'");
            produtos = query.list();
        }
        return produtos;
    }

    public List<Produto> listarProdutosMaisVendidos() {
        List<Produto> produtos = null;
        Query query = session.createQuery("FROM " + alvo.getSimpleName()
                + " WHERE ofertado = 0 ORDER BY qtdeVendida DESC");
        query.setMaxResults(6);
        produtos = query.list();
        return produtos;
    }

    public static void main(String[] args) {
        List<Produto> prod = new DaoProduto().listarProdutosMaisVendidos();
        for (Produto p : prod) {
            System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getQtdeVendida());
        }
    }

    public boolean verificaDependencias(Long id) {

        List<Produto> produtos = null;
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " p WHERE p.pessoa.id = " + id.intValue() + "");

        produtos = query.list();

        return !produtos.isEmpty();

    }

    public List<Produto> listarPorUsuario(Long id) {
        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " p WHERE p.pessoa.id = " + id.intValue() + "");
        return query.list();
    }
    
     public int obterUltimoId() {
        List<Produto> lista = null;

        Query query = session.createQuery("FROM " + alvo.getSimpleName() + " C WHERE C.id = (select  max(id) from " + alvo.getSimpleName() + ")");
        lista = query.list();
        if (!lista.isEmpty()) {
            return lista.get(0).getId().intValue();
        }
        return 0;
    }
}