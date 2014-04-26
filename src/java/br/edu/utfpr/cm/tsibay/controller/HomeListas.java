/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.controller;

import br.edu.utfpr.cm.tsibay.daos.DaoFamilia;
import br.edu.utfpr.cm.tsibay.daos.DaoProduto;
import br.edu.utfpr.cm.tsibay.model.Familia;
import br.edu.utfpr.cm.tsibay.model.Produto;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "HomeListas", urlPatterns = {"/HomeListas"})
public class HomeListas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession s = request.getSession();
                
        DaoFamilia daoFamilia = new DaoFamilia();
        List<Familia> familias = null;

        DaoProduto daoProduto = new DaoProduto();
        List<Produto> produtoListas = null;

        familias = daoFamilia.listar();
        s.setAttribute("familias", familias);

        produtoListas = daoProduto.listarProdutosMaisVendidos();
        s.setAttribute("produtosMaisVendidos", produtoListas);

        produtoListas = daoProduto.listarProdutosUltimos();
        s.setAttribute("produtosUltimos", produtoListas);
        s.setAttribute("produtosPrincipal", produtoListas);
        
        response.sendRedirect("home.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
