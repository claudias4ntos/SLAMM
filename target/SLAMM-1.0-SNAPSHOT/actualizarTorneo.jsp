<%-- 
    Document   : actualizarTorneo
    Created on : 12-05-2019, 04:27:27 PM
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
    <%@include  file="Resources/navbar.jsp" %>

    <body>
        <div class="container">
            <div class="col-4">

                <c:forEach items="${lista}" var="torneo">
                    
                    <form  action="torneo?action=actualizar" method="POST">


                        <input name="id_torneo"  type="hidden" class="form-control" value="${torneo.id_torneo}"> 
                        <label > NOMBRE TORNEO </label>
                        <input name="nombre" class="form-control" value="${torneo.nombre}">

                        <label > FECHA </label>
                        <input  name="anio" class="form-control" type="date" value="${torneo.año}">
                        
                        <label> PAIS </label>
                        <select class="form-control" name="id_pais" class="form-control" style="height: 40px;">
                            <c:forEach items="${listaPais}"  var="tbean"  >
                                <c:choose>
                                    <c:when test="${tbean.id_pais == torneo.id_pais.id_pais}">
                                        <option value="${tbean.id_pais}" selected="true">${tbean.nombre}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${tbean.id_pais}">${tbean.nombre}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>    
                        </select>

                        <label> CIUDAD </label>
                        <select class="form-control" name="id_ciudad" class="form-control" style="height: 40px;" >
                            <c:forEach items="${listaCiudad}"  var="tbean">
                                <c:choose>
                                    <c:when test="${torneo.id_ciudad.id_ciudad == tbean.id_ciudad}">
                                        <option value="${tbean.id_ciudad}" selected="true">${tbean.nombre}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${tbean.id_ciudad}">${tbean.nombre}</option>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>   

                        </select>
                        <br>
                        <button class="btn btn-primary"> Actualizar </button>
                    </form>     
                </c:forEach>  
            </div>
        </div>
        <label class="badge badge-light">${msg}</label>
    </body>
    <%@include  file="Resources/libreria.jsp" %>
</html>
