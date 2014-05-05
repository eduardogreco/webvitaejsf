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
                    <td>Data Nasc.:</td>
                    <td><input name="dtNascimento" type="text" id="dtNascimento" size="20" maxlength="10" required=""/>
                </tr>                
                <tr>
                    <td>CPF:</td>
                    <td><input name="cpf" type="text" id="cpf" size="20" maxlength="11" required=""/>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input name="email" type="text" id="email" size="70" maxlength="60" required=""/>
                </tr>
                <tr>
                    <td>DDD:</td>
                    <td>
                        <input name="ddd" type="text" id="ddd" size="4" maxlength="2" required=""/>
                        Telefone:
                        <input name="telefone" type="text" id="telefone" required=""/>
                        Tipo:
                        <select name="tipoTelefone" id="tipoTelefone" required="" >
                            <option></option>
                            <option value="RESIDENCIAL">RESIDENCIAL</option>
                            <option value="CELULAR">CELULAR</option>
                            <option value="RESIDENCIAL">RESIDENCIAL</option>
                            <option value="RECADO">RECADO</option>
                            <option value="OUTRO">OUTRO</option>
                        </select>
                </tr>
                <tr>
                    <td width="69" colspan="2">Endereço</td>
                </tr>
                <tr>
                    <td>Tipo log.:</td>
                    <td><select name="tipoLogradouro" id="tipoLogradouro" required="">
                            <option></option>
                            <option value="RUA">RUA</option>
                            <option value="AVENIDA">AVENIDA</option>
                            <option value="TRAVESSA">TRAVESSA</option>
                            <option value="ALAMEDA">ALAMEDA</option>
                            <option value="OUTRO">OUTRO</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Logradouro</td>
                    <td><input name="logradouro" type="text" id="logradouro" size="50" maxlength="70" required=""/>
                        Número
                        <input name="numero" type="text" id="numero" size="8" maxlength="8" required=""/>
                    </td>
                </tr>
                <tr>
                    <td>Complemento:</td>
                    <td><input name="complemento" type="text" id="complemento" size="50" maxlength="70" />
                </tr>
                <tr>
                    <td>Bairro:</td>
                    <td><input name="bairro" type="text" id="bairro" size="50" maxlength="70" required=""/>
                </tr>
                <tr>
                    <td>CEP:</td>
                    <td><input name="cep" type="text" id="cep" size="20" maxlength="10" required=""/>
                </tr>                
                <tr>
                    <td>Cidade:</td>
                    <td><input name="cidade" type="text" id="cidade" size="50" maxlength="70" required=""/>
                </tr>
                <tr>
                    <td>Estado:</td>
                    <td><select name="estado" id="estado" required="">
                            <option></option>
                            <option value="AC">AC</option>
                            <option value="AL">AL</option>
                            <option value="AP">AP</option>
                            <option value="AM">AM</option>
                            <option value="BA">BA</option>
                            <option value="CE">CE</option>
                            <option value="ES">ES</option>
                            <option value="DF">DF</option>
                            <option value="MA">MA</option>
                            <option value="MT">MT</option>
                            <option value="MS">MS</option>
                            <option value="MG">MG</option>
                            <option value="PA">PA</option>
                            <option value="PB">PB</option>
                            <option value="PR">PR</option>
                            <option value="PE">PE</option>
                            <option value="PI">PI</option>
                            <option value="RJ">RJ</option>
                            <option value="RN">RN</option>
                            <option value="RS">RS</option>
                            <option value="RO">RO</option>
                            <option value="RR">RR</option>
                            <option value="SC">SC</option>
                            <option value="SP">SP</option>
                            <option value="SE">SE</option>
                            <option value="TO">TO</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>País</td>
                    <td><input name="pais" type="text" id="pais" maxlength="20" value="BRASIL" required=""/>
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
                    <td colspan="2"><input name="news" type="checkbox" id="news" value="ATIVO" checked="checked" />
                        Desejo receber novidades e informações sobre o conteúdo deste site. </td>
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
