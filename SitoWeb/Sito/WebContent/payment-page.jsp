<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/untitled.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href="#">Event Manager</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <%if(session.getAttribute("client") == null) %><li class="nav-item" role="presentation"><a class="nav-link" href="index.html">Home</a></li>
                	<%if(session.getAttribute("client") != null) %> <li class="nav-item" role="presentation"><a class="nav-link" href="indexLog.jsp">Home</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="catalog-page.jsp">Catalog</a></li>
					<%if(session.getAttribute("client") != null) %><li class="nav-item" role="presentation"><a class="nav-link" href="StoricoUtente">Storico Utente</a></li>					
                    <%if(session.getAttribute("client") == null) %><li class="nav-item" role="presentation"><a class="nav-link" href="login.html">Login</a></li>
                    <%if(session.getAttribute("client") == null) %><li class="nav-item" role="presentation"><a class="nav-link" href="registration.html">Register</a></li>
                	<form name = "formRicerca" class="form-inline mr-auto" target="_self" action = "RicercaEvento" method = "GET">
    					<div class="form-group"><label for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field" type="search" name="search" id="search-field" /></div>
					</form>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page payment-page">
        <section class="clean-block payment-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Lista Ticket</h2>
                    <p>Lista ticket prenotati</p>
                </div>
                <form>
                	<%@page import = "Model.Acquisto, java.util.LinkedList, Model.Eventi"%>
                	<%
                	Eventi evento = new Eventi();
                	evento = (Eventi) session.getAttribute("ticketEventoAcquistare");
                	int numTicket = Integer.parseInt(request.getParameter("numeroTickets"));
                	double totale = numTicket * evento.getPrezzo();
                	session.setAttribute("numberTicket", numTicket);
                	%>
                    <div class="products">
                        <h3 class="title">Checkout</h3>
                        <div class="item"><span class="price">euro : <%out.println(evento.getPrezzo()); %></span>
                            <p class="item-name"><% out.println(evento.getNome()); %></p>
                            <p class="item-description"><% out.println(evento.getDescr()); %></p>
                            <p class="item-description">Numero biglietti : <% out.println(numTicket); %></p>
                        </div>                    
                        <div class="total"><span>Total</span><span class="price"><%out.println(totale); %></span></div>
                    </div>
                    <div class="card-details" align = "center">
	                        <div id="paypal-button-container"></div>
								<script src="https://www.paypalobjects.com/api/checkout.js"></script>
								<script>
									// Render the PayPal button
									paypal.Button.render({
									// Set your environment
									env: 'sandbox', // sandbox | production
									
									// Specify the style of the button
									style: {
									  layout: 'vertical',  // horizontal | vertical
									  size:   'medium',    // medium | large | responsive
									  shape:  'rect',      // pill | rect
									  color:  'gold'       // gold | blue | silver | white | black
									},
									
									// Specify allowed and disallowed funding sources
									//
									// Options:
									// - paypal.FUNDING.CARD
									// - paypal.FUNDING.CREDIT
									// - paypal.FUNDING.ELV
									funding: {
									  allowed: [
									    paypal.FUNDING.CARD,
									    paypal.FUNDING.CREDIT
									  ],
									  disallowed: []
									},
									
									// PayPal Client IDs - replace with your own
									// Create a PayPal app: https://developer.paypal.com/developer/applications/create
									client: {
									  sandbox: 'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R',
									  production: '<insert production client id>'
									},
									
									payment: function (data, actions) {
									  return actions.payment.create({
									    payment: {
									      transactions: [
									        {
									          amount: {
									            total: '0.01',
									            currency: 'USD'
									          }
									        }
									      ],
									  	redirect_urls: {
								        return_url: 'http://localhost:12553/Sito/TransazioneBiglietto.html',
								        cancel_url: 'index.html'
								        }
									    }
									  });
									},
									
									onAuthorize: function (data, actions) {
									  return actions.payment.execute()
									    .then(function () {
									      window.alert('Payment Complete!');
									      actions.redirect();
									    });
									}
									}, '#paypal-button-container');
						</script>    
                    </div>
                </form>
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
            <p>© 2018 Copyright Text</p>
        </div>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/theme.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>