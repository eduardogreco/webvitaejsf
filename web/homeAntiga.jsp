<%-- 
    Document   : home
    Created on : 11/09/2013, 20:59:31
    Author     : alauber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    </head>
    <body>
        <!-- Begin Wrapper -->
        <div id="wrapper">
            <!-- Begin Search -->
            <div id="search">
                <div class="shell">
                    <form action="./ListasHomePesqProdutoNome" method="get" accept-charset="utf-8">
                        <div class="container">
                            <input type="text" name="pesqNomeProduto" title="Pesquisa..." class="blink" />
                        </div>
                        <input class="search-button" type="submit" value="Submit" />
                    </form>
                    <div class="cl">&nbsp;</div>
                </div>
            </div>
            <!-- End Search -->
            <!-- Begin Header -->
            <div id="header" class="shell">
                <h1 id="logo"><a class="notext" href="#" title="TSIBay">TSYBay</a></h1>
            </div>
            <!-- End Header -->
            <!-- Begin Navigation -->
            <div id="navigation">
                <div class="shell">
                    <ul>
                        <li><a href="#" title="Home">Home</a></li>
                        <li><a href="#" title="Ofertas especiais">Ofertas especiais</a></li>
                        <li><a href="#" title="Login">Login</a></li>
                        <li><a href="admin.xhtml" title="Administração"  target="blank">Administração</a></li>
                        <li><a href="#" title="Checkout">Checkout</a></li>
                        <li><a href="#" title="Contact">Contato</a></li>
                    </ul>
                    <div class="cl">&nbsp;</div>
                </div>
            </div>
            <!-- End Navigation -->
            <!-- Begin Slider -->
            <div id="slider">
                <div class="slider-outer">
                    <div class="slider-inner shell">
                        <!-- Begin Slider Items -->
                        <ul class="slider-items">
                            <c:forEach items="${produtosMaisVendidos}" var="p" begin="1" end="5" >
                                <li>
                                    <img src="resources/imagesSite/slide-img1.jpg" alt="Slide Image 1" />
                                    <div class="slide-entry">
                                        <h2>${p.familia.nome}</h2>
                                        <h3>${p.nome}</h3>
                                        <p>R$ ${p.precoVenda}
                                    </div>
                                    <a href="#" class="more" title="Veja mais">Veja mais</a>
                                </li>
                            </c:forEach>                                    
                        </ul>
                        <!-- End Slider Items -->
                        <div class="cl">&nbsp;</div>
                        <div class="slider-controls">

                        </div>
                    </div>
                </div>
                <div class="cl">&nbsp;</div>
            </div>
            <!-- End Slider -->
            <!-- Begin Main -->
            <div id="main">
                <!-- Begin Inner -->
                <div class="inner">
                    <div class="shell">
                        <!-- Begin Left Sidebar -->
                        <div id="left-sidebar" class="sidebar">
                            <ul>
                                <li class="widget">
                                    <h2>Categorias</h2>
                                    <div class="widget-entry">
                                        <ul>
                                            <c:forEach items="${familias}" var="f" >
                                                <li>
                                                    <a href=".\ListasHomePesqProdutoPorFamilia?id=${f.id}" name="id" title="${f.nome}" ><span>${f.nome}</span>
                                                    </a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </li>
                                <li class="widget">
                                    <h2>Informações</h2>
                                    <div class="widget-entry">
                                        <ul>
                                            <li><a href="#" title="Empresa"><span>Empresa</span></a></li>
                                            <li><a href="#" title="Politica de Privacidade"><span>Politica de Privacidade</span></a></li>
                                            <li><a href="#" title="Termos &amp; Condições"><span>Termos &amp; Condições</span></a></li>
                                            <li><a href="#" title="Contato"><span>Contato</span></a></li>
                                            <li class="last"><a href="#" title="Mapa do Site"><span>Mapa do Site</span></a></li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="widget select-widget">
                                    <h2>Brands</h2>
                                    <div class="widget-entry">
                                        <div class="selectbox">
                                            <span class="currentItem">--- <span>Please Select</span> ---</span>
                                            <div class="list">
                                                <ul>
                                                    <li class="active"><a href="#" title="Please Select">Please Select</a></li>
                                                    <li><a href="#" title="Brand 1">Brand 1</a></li>
                                                    <li><a href="#" title="Brand 2">Brand 2</a></li>
                                                    <li><a href="#" title="Brand 3">Brand 3</a></li>
                                                </ul>
                                            </div>
                                            <select>
                                                <option value="option" selected="selected">Please Select</option>
                                                <option value="option1">Brand 1</option>
                                                <option value="option2">Brand 2</option>
                                                <option value="option3">Brand 3</option>
                                            </select>
                                        </div>
                                        <div class="cl">&nbsp;</div>
                                    </div>
                                </li>
                                <li class="widget">
                                    <h2>Shopping Card</h2>
                                    <div class="widget-entry">
                                        <a href="#" class="items" title="Shopping Card Items">0 items</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!-- End Sidebar -->
                        <!-- Begin Content -->
                        <div id="content">
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
                                            <img src="resources/imagesSite/product-img1.jpg" alt=${p.nome} " Image 1" />
                                            <span class="number">${p.nome} </span>
                                            <span class="price"><span>R$</span>${p.precoVenda}</span>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- End Products -->
                        </div>
                        <!-- End Content -->
                        <!-- Begin Right Sidebar -->
                        <div id="right-sidebar" class="sidebar">
                            <!-- Begin Products -->
                            <ul>
                                <li class="widget products-box">
                                    <h2>Mais vendidos</h2>
                                    <div class="widget-entry">
                                        <ul>
                                            <c:forEach items="${produtosMaisVendidos}" var="p" >
                                                <li>
                                                    <a href="#" title=${p.nome}>
                                                        <img src="resources/imagesSite/side-img1.jpg" alt="Product Side Image 1" />
                                                        <span class="info">
                                                            <span class="title">${p.nome}</span>
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
                                                    <a href="#" title=${p.nome}>
                                                        <img src="resources/imagesSite/side-img1.jpg" alt="Product Side Image 1" />
                                                        <span class="info">
                                                            <span class="title">${p.nome}</span>
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
                    <p>Copyright &copy; TSYBay 2013. Design by: <a href="#" title="Junior Cesar de Olivera &amp; Alecsandro Lauber">Junior Cesar de Olivera &amp; Alexsandro Lauber</a>. Todos os direitos reservados. </p>
                    <div class="cl">&nbsp;</div>
                </div>
            </div>
            <!-- End Footer -->
        </div>
        <!-- End Wrapper -->
    </body>
</html>
