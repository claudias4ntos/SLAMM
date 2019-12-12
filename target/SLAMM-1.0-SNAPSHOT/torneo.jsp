<%-- 
    Document   : torneo
    Created on : 12-02-2019, 10:42:24 AM
    Author     : claudia.santosusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include  file="Resources/navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-3">
                    <br><br>
                </div>
                
                
                <div class="col-6">
                    
                   <div class="p-3 mb-2 bg-info text-white">
                    
                     <h1>Insertar Nuevo Registro Torneo</h1>
                     
                </div>
                   <br><br>
                    
                </div>
                
  
                
                
            </div>
            <div class="row">
                

                <div class="col-4">
                                    </div>
                <div class="col-4">
                    
                   
                    <div>
                        
                        
                    <form  action="torneo?action=insertar" method="POST">
                        
                        <label > NOMBRE TORNEO </label>
                        <input name="nombre" class="form-control" required>


                        <label> PAIS </label>
                        <select class="form-control" name="id_pais" class="form-control" style="height: 40px;">
                            <c:forEach items="${listaPais}"  var="tbean"  >
                                <option value="${tbean.id_pais}">${tbean.nombre}</option>
                            </c:forEach>    
                        </select>

                        <label> CIUDAD </label>
                        <select class="form-control" name="id_ciudad" class="form-control" style="height: 40px;" >
                            <c:forEach items="${listaCiudad}"  var="tbean">
                                <option value="${tbean.id_ciudad}">${tbean.nombre}</option>
                            </c:forEach>   

                        </select>
                        <br>
                        <button class="btn btn-primary"> Guardar </button>
                    </form>

                    ${msg}
                    </div>


                </div>
                   

            </div>
                    
                    <br><br><br>
            <div class="row"> 
                 
                <table  class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Codigo</th>
                            <th scope="col">Nombre Torneo</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Pais</th>

                            <th scope="col">Ciudad</th>
                            <th scope="col">Aciones</th>


                        </tr>
                    </thead  >
                    <tbody>
                        <c:forEach items="${lista}" var="tbean">
                            <tr>

                                <td>${tbean.id_torneo}</td>
                                <td>${tbean.nombre}</td>
                                <td>${tbean.año}</td>
                                <td>${tbean.id_pais.nombre}</td>
                                <td>${tbean.id_ciudad.nombre}</td>

                                <td><a href="torneo?action=consultarById&id_torneo=${tbean.id_torneo}" class="btn btn-info">Editar</a></td>
                                <td><a href="torneo?action=eliminar&id_torneo=${tbean.id_torneo}" class="btn btn-danger">Eliminar</a></td>
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>



            </div>
        </div>


       
        
                    

        <%@include  file="Resources/libreria.jsp" %>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>
