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

                        <h1 class="text-center" >REGISTRO CIUDAD</h1>

                    </div>
                    <br><br>

                </div>




            </div>
            <div class="row">


                <div class="col-4">
                </div>
                <div class="col-4">


                    <div>


                        <form  action="ciudad?action=insertar" method="POST">

                            <label> INGRESE EL NOMBRE  DE LA CIUDAD </label>
                            <input name="nombre" class="form-control" required>

                            <br>
                            <button class="btn btn-primary"> Guardar </button>
                        </form>

                        ${msg}
                    </div>


                </div>


            </div>

            <br><br><br>
            <div class="row"> 
                <div class="col-3"></div>
                <div class="col-6">
                    <table  class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Codigo</th>
                            <th scope="col"> Ciudad</th>
                            <th scope="col"> Acciones</th>
                            



                        </tr>
                    </thead  >
                    <tbody>
                        <c:forEach items="${listaCiudad}" var="cbean">
                            <tr>

                                <td>${cbean.id_ciudad}</td>
                                <td>${cbean.nombre}</td>


                                
                                <td><a href="ciudad?action=eliminar&id_ciudad=${cbean.id_ciudad}" class="btn btn-danger">Eliminar</a></td>
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>



                </div>


                
            </div>
        </div>






        <%@include  file="Resources/libreria.jsp" %>

        
    </body>
</html>
