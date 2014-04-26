<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : login
    Created on : 04/09/2013, 08:35:41
    Author     : alauber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div align="left"><h2>Login do Sistema</h2></div>
        <form>
                <table width="100" border="0" cellpadding="10" cellspacing="10" >
                    <tr>
                        <td width="80"><h3>Login:</h3></td>
                        <td>
                            <div id="loginDiv">
                                <div class="container">
                                    <input type="text" id="login" name="login" value="alauber"> 
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td width="80">
                            <h3>Senha:</h3></td>
                        <td>
                            <div id="loginDiv">
                                <div class="container">
                                    <input type="password" id="senha" name="senha" value="alauber"> 
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
                </br>
                <div id="loginDiv">
                    <a href="#content" onclick="validaLogin($('#login').val(), $('#senha').val())" class="login-button" >Entrar</a> 
                </div>
                </br>
                </br>
                </br>
                <h2>${requestScope.erroLogin}</h2>
        </form>
    </body>
</html>
