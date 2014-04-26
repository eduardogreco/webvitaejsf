<%-- 
    Document   : produtosUltimos
    Created on : 20/09/2013, 10:25:00
    Author     : alauber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <c:forEach items="${produtosPrincipal}" var="p" >
                <div class="product">
                    <a href="#" title=${p.nome}>
                        <span class="title">${p.familia.nome}</span>
                        <img src="${p.uriImagem}" alt=${p.nome} " Image 1" />
                        <span class="number">${p.nome} </span>
                        <span class="price"><span>R$</span>${p.precoVenda}</span>
                    </a>
                </div>
            </c:forEach>
        </div>
        <!-- End Products -->
    </body>
</html>
