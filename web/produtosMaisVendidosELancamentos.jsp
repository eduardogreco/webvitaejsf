<%-- 
    Document   : listaProdutosUltimos
    Created on : 13/09/2013, 01:18:57
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <!-- Begin Products -->
        <ul>
            <li class="widget products-box">
                <h2>Mais vendidos</h2>
                <div class="widget-entry">
                    <ul>
                        <c:forEach items="${produtosMaisVendidos}" var="p" >
                            <li>
                                <a href="#content" onclick="atualizaDivContentPesqProdutoPorId(${p.id})" name="idProduto" title=${p.nome}>
                                    <img src="${p.uriImagem}" alt="Product Side Image 1" />
                                    <span class="info">
                                        <span class="number">${p.nome}</span>
                                        <span class="orders">${p.qtdeVendida}</span>
                                    </span>
                                    <span class="cl">&nbsp;</span>
                                </a>
                            </li>
                        </c:forEach>                                            
                    </ul>
                    <div class="cl">&nbsp;</div>
                </div>
            </li>
            <li class="widget products-box">
                <h2>Lançamentos</h2>
                <div class="widget-entry">
                    <ul>
                        <c:forEach items="${produtosUltimos}" var="p" begin="1" end="6" >
                            <li>
                                <a href="#content" onclick="atualizaDivContentPesqProdutoPorId(${p.id})" name="idProduto" title=${p.nome}>
                                    <img src="${p.uriImagem}" alt="Product Side Image 1" />
                                    <span class="info">
                                        <span class="number">${p.nome}</span>
                                        <span class="price"><span>Id </span>${p.id}</span>
                                    </span>
                                    <span class="cl">&nbsp;</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="cl">&nbsp;</div>
                </div>
            </li>
        </ul>
        <!-- End Products -->
    </body>
</html>
