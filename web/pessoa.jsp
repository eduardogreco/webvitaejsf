<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSIBay</title>
        <script src="resources/js/libs/twitter-bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <h2>Cadastro de pessoa</h2>
        <!-- Begin Cadastro -->
        <form class="pessoa" name="pessoa" action="PessoaCadastro"  method="POST" >
            <table width="500" border="0" cellpadding="10" cellspacing="10">
                <tr>
                    <td width="69" colspan="2">Dados pessoais</td>
                </tr>
                <tr>
                    <td width="69">Nome:</td>
                    <td width="546"><input name="nome" type="text" id="nome" size="70" maxlength="60" required=""/>
                </tr>

                <tr>
                    <td>CPF:</td>
                    <td><input name="cpf" type="text" id="cpf" size="20" maxlength="11" required=""/>
                </tr>

                <tr>
                    <td width="69" colspan="2">Acesso ao site</td>
                </tr>                
                <tr>
                    <td>Login:</td>
                    <td><input name="login" type="text" id="login" maxlength="12" required=""/>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input name="senha" type="password" id="senha" maxlength="12" required=""/>
                </tr>
                <tr>
                    <td colspan="2"><p>
                            <input name="cadastrar" type="submit" id="cadastrar" value="Concluir meu Cadastro!" />
                            <input name="limpar" type="reset" id="limpar" value="Limpar Campos preenchidos!" />
                    </td>
                </tr>
            </table>
        </form>
        <!-- End Cadastro -->
    </body>
</html>
