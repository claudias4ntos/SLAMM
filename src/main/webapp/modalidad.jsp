<%-- 
    Document   : modalidad
    Created on : 12-11-2019, 09:09:43 AM
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

                        <h1 class="text-center" >REGISTRO MODALIDAD</h1>

                    </div>
                    <br><br>

                </div>




            </div>
            <div class="row">


                <div class="col-4">
                </div>
                <div class="col-4">


                    <div>


                        <form  action="ModalidadServlet?action=insertar" method="POST">

                            <label> INGRESE EL NOMBRE  DE LA MODALIDAD </label>
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
                            <th scope="col"> Modalidad</th>
                            <th scope="col"> Acciones</th>
                            



                        </tr>
                    </thead  >
                    <tbody>
                    
                        <c:forEach items="${listaMod}" var="moda">
                            <tr>

                                <td>${moda.id_mod}</td>
                                <td>${moda.nombre}</td>


                                
                                <td><a href="ModalidadServlet?action=eliminar&id_mod=${moda.id_mod}" class="btn btn-danger">Eliminar</a></td>
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
