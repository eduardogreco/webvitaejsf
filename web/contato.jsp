<%-- 
    Document   : pessoa
    Created on : 23/09/2013, 19:06:10
    Author     : alauber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSIBay</title>
        <script src="resources/js/libs/twitter-bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <h2>Contato</h2>
        <!-- Begin Cadastro -->
        <form class="pessoa" name="pessoa" >
            <table width="500" border="0" cellpadding="10" cellspacing="10">
                <tr>
                    <td width="69">Nome:</td>
                    <td width="546"><input name="nome" type="text" id="nome" size="70" maxlength="60" required=""/>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input name="email" type="text" id="email" size="70" maxlength="60" required=""/>
                </tr>
                <tr>
                    <td>
                        <label>Digite sua mensagem a seguir:</label>
                    </td>
                    <td>
                        <textarea cols="70" rows="5" id="mensagem"></textarea>
                    </td>
                </tr>						
                <tr>
                    <td colspan="2"><input name="news" type="checkbox" id="news" value="ATIVO" checked="checked" />
                        Desejo receber novidades e informações sobre o conteúdo deste site. </td>
                </tr>
                <tr>
                    <td colspan="2"><p>
                            <input name="enviar" type="reset" id="enviar" value="Enviar!" />
                    </td>
                </tr>
            </table>
        </form>
        <!-- End Cadastro -->
    </body>
</html>
