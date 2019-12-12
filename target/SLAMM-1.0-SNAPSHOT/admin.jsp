<%-- 
    Document   : index
    Created on : 11-29-2019, 11:31:46 AM
    Author     : claudia.santosusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    

        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar bg-dark sticky-top navbar-expand-lg">
            <a class="navbar-brand text-white" href="">

            </a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="index.jsp"><i class="fa fa-home">&nbsp;</i>Inicio <span class="sr-only">(current)</span></a>
                    </li>


                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                 <div class="col-md-3"> 

                <div class="panel panel-primary class">
                    <div class="panel-heading">PAIS</div>
                    <div class="panel-body">
                        <img src="imagenes/Paises.jpg" height="100" width="200"  />
                        <br><br>
                         <a  href="pais?action=insertar"  type="button" class="btn btn-primary ">PAIS</a>
                        
                        
                    </div>
                </div>    

            </div>
            <div class="col-md-3"> 
                <div class="panel panel-primary class">
                    <div class="panel-heading">CIUDAD</div>
                    <div class="panel-body">
                        <img src="imagenes/ciudad.jpg" height="100" width="200"  alt=""/>
                        <br><br>
                         <a  href="ciudad?action=insertar"  type="button" class="btn btn-primary ">CIUDAD</a>
                    </div>
                </div>    

            </div>
            <div class="col-md-3"> 
                <div class="panel panel-primary class">
                    <div class="panel-heading">TORNEOS</div>
                    <div class="panel-body">
                       
                        <img  src="imagenes/tenis.png" height="100" width="200"      alt=""/>
                         <br><br>
                        <a  href="torneo?action=llenar"  type="button" class="btn btn-primary ">TORNEOS</a>
                       
                       
                        
                    </div>
                </div>    
            </div>

            <div class="col-md-3"> 
                <div class="panel panel-primary class">
                    <div class="panel-heading">PARTIDOS</div>
                    <div class="panel-body">
                        <img src=" imagenes/partidos.jpg " height="100" width="200"  alt=""/>
                        <br> <br>
                        <a  href="torneo?action=llenar"  type="button" class="btn btn-primary ">PARTIDOS</a>
                    </div>
                </div>    
            </div>
                
                
            </div>
           <div class="row">
                 <div class="col-md-3"> 

                <div class="panel panel-primary class">
                    <div class="panel-heading">ARBITROS</div>
                    <div class="panel-body">
                        <img src="imagenes/arbitros.png" height="100" width="200"  />
                       
                        <br><br>
                         <a  href="torneo?action=llenar"  type="button" class="btn btn-primary ">ARBITROS</a>
                        
                        
                    </div>
                </div>    

            </div>
            <div class="col-md-3"> 
                <div class="panel panel-primary class">
                    <div class="panel-heading">MODALIDAD</div>
                    <div class="panel-body">
                        <img src="imagenes/IMAGEN.jpg" height="100" width="200"  alt=""/>
                        
                        <br><br>
                         <a  href="ModalidadServlet?action=insertar"  type="button" class="btn btn-primary ">MODALIDAD</a>
                    </div>
                </div>    

            </div>
            <div class="col-md-3"> 
                <div class="panel panel-primary class">
                    <div class="panel-heading">JUGADOR</div>
                    <div class="panel-body">
                       
                        <img  src="imagenes/nueva.jpg" height="100" width="200"      alt=""/>
                        
                         <br><br>
                        <a  href="torneo?action=llenar"  type="button" class="btn btn-primary ">JUGADOR</a>
                       
                       
                        
                    </div>
                </div>    
            </div>

            <div class="col-md-3"> 
                <div class="panel panel-primary class">
                    <div class="panel-heading">PREMIO </div>
                    <div class="panel-body">
                        <img src= "imagenes/JUGADOR.png"  height="100" width="200"  alt=""/>
                        <br> <br>
                        <a  href="torneo?action=llenar"  type="button" class="btn btn-primary ">PREMIOS</a>
                        
                    </div>
                </div>    
            </div>
                
                
            </div>
            
            
        </div>

        <%@include  file="Resources/libreria.jsp" %>

    </body>
</html>
