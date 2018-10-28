<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catalog - Brand</title>
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
                	<form name = "formRicerca" class="form-inline mr-auto" target="_self" action = "RicercaEvento" method = "GET">
    					<div class="form-group"><label for="search-field"><i class="fa fa-search"></i></label><input class="form-control search-field" type="search" name="search" id="search-field" /></div>
					</form>
                	<li class="nav-item" role="presentation">
                		<div class="btn-group"><button class="btn btn-primary" type="button">Categoria</button><button class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-expanded="false" type="button"></button>
    						<div class="dropdown-menu" role="menu">
    						<%int categoria; %>
    						<a class="dropdown-item" role="presentation" href="VisualizzaEventiMusica">Musica</a>
    						<a class="dropdown-item" role="presentation" href="VisualizzaEventiSport">Sport</a>
    						<a class="dropdown-item" role="presentation" href="VisualizzaEventiSpettacolo">Spettacolo</a></div>
						</div> 
					</li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page catalog-page">
        <div class="container">
            <h1>Storico Utente</h1>
        <table class="table"> 
		<thead>        
			<tr>            
				<th>Nome evento</th>       
				<th>Numero biglietti acquistati</th>
				<th>Spesa totale</th>
				<th>Biglietto digitale</th>
			</tr>
		</thead>
		
		<form method = 'GET' name = 'FormEventoSpettacolo' action = 'InfoEventi'>

		<tbody>
			<%@page import = "java.util.LinkedList"%>
			<%@page import =  "Model.AcquistoStorico"%>
		
			<%
			LinkedList<AcquistoStorico> lista = new LinkedList<>();
			lista = (LinkedList<AcquistoStorico>) request.getAttribute("storicoAcquisti");
			if(lista.size() == 0) System.out.println("is 0");
				for(AcquistoStorico i : lista) 
					out.println("<tr><td>"+i.getTitolo()+"</td><td>"+i.getNumeroTickets()+"</td><td>"+i.getSpesaTotale()+"</td><td><a href='"+i.getPathQRCode()+"' download = 'qrcode'><img src='"+i.getPathQRCode()+"'></a></td></tr>");
			%>
		</tbody>
	</form>
	</table>
	</div>
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