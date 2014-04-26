/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.test;

import br.edu.utfpr.cm.tsibay.daos.DaoPessoa;
import br.edu.utfpr.cm.tsibay.daos.DaoTransacao;
import br.edu.utfpr.cm.tsibay.model.Transacao;
import java.util.List;

/**
 *
 * @author alauber
 */
public class Teste {

    public static void main(String[] args) {
//        DaoTransacao d = new DaoTransacao();
//        List<Transacao> listarVendasEmAndamento = d.listarVendasEmAndamento(new DaoPessoa().obterPorId(1));
//        
//        System.out.println(listarVendasEmAndamento.size());
//        for (Transacao transacao : listarVendasEmAndamento) {
//            System.out.println(transacao.getId());
//        }
        String nome = "12454-545453.png";
        nome = nome.substring(nome.lastIndexOf("-"), nome.lastIndexOf("."));
        nome = nome.replace("-", "");
       int v =  Integer.valueOf(nome);

        System.out.println(v+1);
    }
}
