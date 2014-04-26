<%-- 
    Document   : produtosUltimos
    Created on : 20/09/2013, 10:25:00
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
        <!-- End Post -->
        <!-- Begin Products -->
        <h2>Produtos selecionados<span class="title-bottom">&nbsp;</span></h2>
        <div id="products">
            <c:if test="${empty produtosPrincipal}">
                <p>Pesquisa não retornou registros!</p>
            </c:if>
            <c:if test="${not empty produtosPrincipal}">
                <c:forEach items="${produtosPrincipal}" var="p" >
                    <div class="product">
                        <a href="#content" onclick="atualizaDivContentPesqProdutoPorId(${p.id})" name="idProduto" title=${p.nome}>
                            <span class="title">${p.familia.nome}</span>
                            <img src="${p.uriImagem}" alt=${p.nome} " Image 1" />
                            <span class="number">${p.nome} </span>
                            <span class="price"><fmt:formatNumber value="${p.precoVenda}" pattern="R$ #,##0.00"/></span>
                        </a>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        <!-- End Products -->
    </body>
</html>
