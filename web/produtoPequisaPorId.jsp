<%-- 
    Document   : produto
    Created on : 20/09/2013, 10:16:59
    Author     : alauber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Begin Post -->
        <div class="post">
            <h2>Bem vindo à nossa loja<span class="title-bottom">&nbsp;</span></h2>
            <p>Confira os produtos oferecidos logo abaixo.</p>
        </div>
        <!-- Begin Products -->
        <h2>Produto selecionado<span class="title-bottom">&nbsp;</span></h2>
        <div id="products">
            <div class="productselect">
                <span class="title">${produtoPesquisa.familia.nome}</span>
                <img src="${produtoPesquisa.uriImagem}" alt=${produtoPesquisa.nome} " Image 1" />
                <span class="number">${produtoPesquisa.nome} </span>
                <span class="price"><fmt:formatNumber value="${produtoPesquisa.precoVenda}" pattern="R$ #,##0.00"/></span>
                </br>
                <c:if test="${produtoPesquisa.qtdeDisponivel == '0'}">
                    <span class="price">Produto esgotado!</span>
                </c:if>
                <c:if test="${produtoPesquisa.qtdeDisponivel != '0'}">                
                    <span class="price">Quantidade <input type="text" name="qtdeCompra" id="qtdeCompra" required=""/></span>
                    <a href="#content" class="comprar" title="Comprar" onclick="atualizaDivContentVenda(${produtoPesquisa.id}, $('#qtdeCompra').val(), ${login_id})"></a>
                </c:if>
                </br>
                <p>Fabricante: ${produtoPesquisa.fabricante}</p>
                </br>
                <p>${produtoPesquisa.descricao}</p>
                </br>
                <p>Vendido(s): ${produtoPesquisa.qtdeVendida} - Disponível(is): ${produtoPesquisa.qtdeDisponivel}</p>
                </br>
                <p>Vendedor: ${produtoPesquisa.pessoa.nome}</p>
                </br>
            </div>
        </div>
    </div>
    <!-- End Products -->
</body>
</html>
