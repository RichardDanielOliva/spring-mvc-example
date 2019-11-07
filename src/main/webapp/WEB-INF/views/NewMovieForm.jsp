<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="./layout/header.jsp" %>
        
 
  <h2>New movie </h2> 
 
<%@ include file="feedbackMessage.jsp" %>

 <form:form class="form-horizontal" method="post" modelAttribute="movie">

  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Titulo:</label>
    <div class="col-sm-10">
      <form:input type="text" class="form-control"
      name="name"
      path="name" placeholder="Introduzca un titulo"/>
  	</div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="puntuacion">Puntuación:</label>
    <div class="col-sm-10">
      <form:input type="number" class="form-control"
      name="puntuacion"
      path="puntuacion" placeholder="Introduzca nueva puntuación"/> 
      <form:errors path="puntuacion" cssStyle="color: #ff0000;"/>
  	</div>
  	</div>
  	<div class="form-group">
  	 <label class="control-label col-sm-2" for="duracion">Duracion:</label>
    <div class="col-sm-10">
      <form:input type="number" class="form-control"
      name="duracion"
      path="duracion" placeholder="Introduzca la duración"/>
      <form:errors path="duracion" cssStyle="color: #ff0000;"/>
 	 </div>
 	 </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Submit</button>
	    </div>
	  </div>
	</form:form>
 
        
 <%@ include file="layout/footer.jsp" %>