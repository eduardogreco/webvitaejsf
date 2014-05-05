<%-- 
    Document   : home
    Created on : 11/09/2013, 20:59:31
    Author     : alauber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      dir="ltr">
    <head>
        <title>TSIBay - Aqui fica fácil de vender</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" href="resources/imagesSite/favicon.ico" />
        <link rel="stylesheet" href="resources/css/LayoutSite.css" type="text/css" media="all" />

        <script src="resources/js/jquery-1.6.2.min.js" type="text/javascript" charset="utf-8"></script>
        <!--[if IE 6]>
                <script src="js/DD_belatedPNG-min.js" type="text/javascript" charset="utf-8"></script>
        <![endif]-->
        <script src="resources/js/jquery.jcarousel.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="resources/js/functions.js" type="text/javascript" charset="utf-8"></script>

        <script type="text/javascript">

            function atualizaDivContentPesqProdutoPorId(id) {
                $.ajax({
                    url: "ProdutosPequisaPorId",
                    data: {
                        idProduto: id
                    },
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentPesqProdutoPorFamilia(id) {
                $.ajax({
                    url: "ProdutosPesquisaPorFamilia",
                    data: {
                        idFamilia: id
                    },
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentPesqProdutoPorDescricao(descricao) {
                $.ajax({
                    url: "ProdutosPesquisaPorDescricao",
                    data: {
                        descricaoProduto: descricao
                    },
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentLogin() {
                $.ajax({
                    url: "login.jsp",
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentTermos() {
                $.ajax({
                    url: "termos.jsp",
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function validaLogin(login, senha) {
                $.ajax({
                    type: 'POST',
                    url: "LoginController",
                    data: {
                        login: login, senha: senha
                    },
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentPessoa() {
                $.ajax({
                    url: "pessoa.jsp",
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentApresentacao() {
                $.ajax({
                    url: "apresentacao.jsp",
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentContato() {
                $.ajax({
                    url: "contato.jsp",
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentPrivacidade() {
                $.ajax({
                    url: "privacidade.jsp",
                    success: function(data) {
                        $('#content').html(data);
                    }
                });
            }

            function atualizaDivContentVenda(id, qtdeCompra, login_id) {
                $.ajax({
                    type: 'POST',
                    url: "ProdutoTransacao",
                    data: {
                        idProduto: id, qtdeCompra: qtdeCompra, idComprador: login_id
                    },
                    success: function(data) {
                        $('#content').html(data);
                    },
                    error: function(data) {
                        alert("Informe quantidade válida!");
                    }
                });
            }

        </script>
    </head>
    <body>
        <!-- Begin Wrapper -->
        <div id="wrapper">
            <!-- Begin Header -->
            <div id="header" class="shell">
                <h1 id="logo"><a class="notext" href="#" title="TSIBay">TSYBay</a></h1>
            </div>
            <!-- End Header -->
            <!-- Begin Navigation -->
            <div id="navigation">
                <div class="shell">
                    <ul>
                        <li><a href="#content" onclick="atualizaDivContentApresentacao()" title="Home">Home</a></li>
                        <li><a href="#content" onclick="atualizaDivContentLogin()" title="Login">Login</a></li>
                        <li><a href="#content" onclick="atualizaDivContentPessoa()" title="Cadastro">Cadastro</a></li>
                        <li><a href="faces/admin/login.xhtml" title="Administração" target="blank">Administração</a></li>
                        <li><a href="#content" onclick="atualizaDivContentContato()" title="Contato">Contato</a></li>
                        <li><a> Usuário logado: 
                                <c:if test="${comprador.login != ''}">
                                    ${comprador.nome}
                                </c:if>
                            </a>
                        </li>
                    </ul>
                    <div class="cl">&nbsp;</div>
                </div>
            </div>
            <!-- End Navigation -->
            <!-- Begin Search -->
            <div id="search">
                <div class="shell">
                    <form>
                        <div class="container">
                            <input type="text" id="descricao" title="Pesquisa..." class="blink" />
                        </div>
                        <a href="#content" onclick="atualizaDivContentPesqProdutoPorDescricao($('#descricao').val())" class="search-button" >Pesquisa</a> 
                        <div class="cl">&nbsp;</div>
                    </form>
                </div>
            </div>
            <!-- End Search -->
            <!-- Begin Main -->
            <div id="main">
                <!-- Begin Inner -->
                <div class="inner">
                    <div class="shell">
                        <!-- Begin Left Sidebar -->
                        <div id="left-sidebar" class="sidebar">
                            <ul>
                                <jsp:include page="familias.jsp" />
                                <li class="widget">
                                    <h2>Informações</h2>
                                    <div class="widget-entry">
                                        <ul>
                                            <li><a href="#content" onclick="atualizaDivContentApresentacao()" title="Empresa"><span>Empresa</span></a></li>
                                            <li><a href="#content" onclick="atualizaDivContentPrivacidade()" title="Termos &amp; Condi趥s"><span>Politica de Privacidade</span></a></li>
                                            <li><a href="#content" onclick="atualizaDivContentTermos()" title="Termos &amp; Condi趥s"><span>Termos &amp; Condições</span></a></li>
                                            <li><a href="#content" onclick="atualizaDivContentContato()" title="Contato"><span>Contato</span></a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!-- End Sidebar -->
                        <!-- Begin Content -->
                        <div id="content">
                            <jsp:include page="apresentacao.jsp" />
                        </div>
                        <!-- End Content -->
                        <!-- Begin Right Sidebar -->
                        <div id="right-sidebar" class="sidebar">
                            <jsp:include page="produtosMaisVendidosELancamentos.jsp" />
                        </div>
                        <!-- End Sidebar -->
                        <div class="cl">&nbsp;</div>
                    </div>
                </div>
                <!-- End Inner -->
            </div>
            <!-- End Main -->
            <!-- Begin Footer -->
            <div id="footer">
                <div class="shell">
                    <p class="bottom-menu"><a href="#" title="Home">Início</a><span>|</span><a href="#" title="Ofertas especiais">Ofertas especiais</a><span>|</span><a href="#" title="Login">Login</a><span>|</span><a href="#" title="Administração">Administração</a><span>|</span><a href="#" title="Checkout">Checkout</a><span>|</span><a href="#" title="Contato">Contato</a></p>
                    <p>Copyright &copy; TSYBay 2013. Design by: <a href="#" title="Junior Cesar de Olivera &amp; Alexsandro Lauber">Junior Cesar de Olivera &amp; Alexsandro Lauber</a>. Todos os direitos reservados. </p>
                    <div class="cl">&nbsp;</div>
                </div>
            </div>
            <!-- End Footer -->
        </div>
        <!-- End Wrapper -->
    </body>
</html>