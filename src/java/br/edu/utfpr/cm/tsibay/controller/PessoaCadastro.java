/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.controller;

import br.edu.utfpr.cm.tsibay.daos.DaoEndereco;
import br.edu.utfpr.cm.tsibay.daos.DaoLocalidade;
import br.edu.utfpr.cm.tsibay.daos.DaoPessoa;
import br.edu.utfpr.cm.tsibay.daos.DaoTelefone;
import br.edu.utfpr.cm.tsibay.model.Endereco;
import br.edu.utfpr.cm.tsibay.model.Localidade;
import br.edu.utfpr.cm.tsibay.model.Pessoa;
import br.edu.utfpr.cm.tsibay.model.Telefone;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alauber
 */
@WebServlet(name = "PessoaCadastro", urlPatterns = {"/PessoaCadastro"})
public class PessoaCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            SimpleDateFormat outFmt = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat inFmt = new SimpleDateFormat("dd/MM/yyyy");
            HttpSession s = request.getSession();

            Localidade localidade = new Localidade();
            DaoLocalidade daoLocalidade = new DaoLocalidade();

            Endereco endereco = new Endereco();
            DaoEndereco daoEndereco = new DaoEndereco();

            Telefone telefone = new Telefone();
            DaoTelefone daoTelefone = new DaoTelefone();

            Pessoa pessoa = new Pessoa();
            DaoPessoa daoPessoa = new DaoPessoa();

            pessoa.setNome(request.getParameter("nome"));
            pessoa.setCpf(request.getParameter("cpf"));
            pessoa.setEmail(request.getParameter("email"));

            String teste = request.getParameter("dtNascimento");
            Date dtNasc = inFmt.parse(teste);
            pessoa.setDtNascimento(dtNasc);
            pessoa.setDtCadastro(new Date());
            pessoa.setLogin(request.getParameter("login"));
            pessoa.setSenha(request.getParameter("senha"));
            pessoa.setTipo("Usuario");
            daoPessoa.persistir(pessoa);

            localidade.setCidade(request.getParameter("cidade"));
            localidade.setEstado(request.getParameter("estado"));
            localidade.setPais(request.getParameter("pais"));
            daoLocalidade.persistir(localidade);

            endereco.setLogradouro(request.getParameter("logradouro"));
            endereco.setTipoLogradouro(request.getParameter("tipoLogradouro"));
            endereco.setNumero(request.getParameter("numero"));
            endereco.setComplemento(request.getParameter("complemento"));
            endereco.setBairro(request.getParameter("bairro"));
            endereco.setCep(request.getParameter("cep"));
            endereco.setLocal(localidade);
            endereco.setPessoa(pessoa);
            daoEndereco.persistir(endereco);

            telefone.setNumero(request.getParameter("ddd") + request.getParameter("telefone"));
            telefone.setTipo(request.getParameter("tipoTelefone"));
            telefone.setPessoa(pessoa);
            daoTelefone.persistir(telefone);

            response.sendRedirect("home.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(PessoaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
