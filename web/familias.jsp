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
    <li class="widget">
        <h2>Categorias</h2>
        <div class="widget-entry">
            <ul>
                <c:forEach items="${familias}" var="f" >
                    <li>
                        <a href="#content" onclick="atualizaDivContentPesqProdutoPorFamilia(${f.id})" name="idFamilia" title="${f.nome}" ><span>${f.nome}</span>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </li>
</body>
</html>
