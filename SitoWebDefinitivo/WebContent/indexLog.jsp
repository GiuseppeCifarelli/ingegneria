<!DOCTYPE html>
<html style="background-image:url(&quot;assets/img/logo.jpg&quot;);">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Event Manager</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
</head>

<body>
<%@page import =  "Model.Clienti"%>
<%
Clienti client = (Clienti) session.getAttribute("client");
%>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href="#">Event Manager</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation">Benvenuto <%out.println(client.getNome()); %></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="distruggiSessione">Logout</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="ListaEventi2">Catalog</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="StoricoUtente">Storico Utente</a></li>
                    <form name = "formRicerca" class="form-inline mr-auto" target="_self" action = "RicercaEvento" method = "GET">
    					<div class="form-group"><label for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field" type="search" name="search" id="search-field" /></div>
					</form>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page landing-page">
        <section class="clean-block clean-hero" style="background-image:url(&quot;assets/img/scenery/image1.jpg&quot;);color:rgba(9,196,255,0.04);">
            <div class="text">
                <h2 style="color:#4f1f4f;">Event Manager</h2>
                <p style="color:rgb(79,31,105);">Vendita biglietti per eventi sportivi, teatrali e concerti</p>
            </div>
        </section>
    </main>
    <footer class="page-footer dark">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <h5>Get started</h5>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Sign up</a></li>
                        <li><a href="#">Downloads</a></li>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h5>About us</h5>
                    <ul>
                        <li><a href="#">Company Information</a></li>
                        <li><a href="#">Contact us</a></li>
                        <li><a href="#">Reviews</a></li>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h5>Support</h5>
                    <ul>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Help desk</a></li>
                        <li><a href="#">Forums</a></li>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <h5>Legal</h5>
                    <ul>
                        <li><a href="#">Terms of Service</a></li>
                        <li><a href="#">Terms of Use</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-copyright">
            <p>� 2018 Copyright Text</p>
        </div>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

