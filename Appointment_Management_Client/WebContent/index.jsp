<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.healthcare.model.Appointment" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.3.1.min.js"></script>
<script src="Components/main.js"></script>
<script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Appointment Management</title>
</head>
<body style="background: #ccccff; border:1px ">
	<div class="container">

		<div class="row">
			<div class="col-8">

				<h1 class="m-3">Appointment details</h1>

				<form style="background: #6969ff; padding: 50px;"id="formAppointment" name="formAppointment">
					Appointment ID: <input id="aID" name="aID"
						type="text" class="form-control form-control-sm"> <br>
					Patient name: <input id="pName" name="pName"
						type="text" class="form-control form-control-sm"> <br>
					Doctor Name: <input id="dName" name="dName" type="text"
						class="form-control form-control-sm"> <br> Hospital
					Name: <input id="hName" name="hName" type="text"
						class="form-control form-control-sm"> <br> Room
					Number: <input id="roomNO" name="roomNO" type="text"
						class="form-control form-control-sm"> <br>
					Appointment Number: <input id="appNO"
						name="appNO" type="text"
						class="form-control form-control-sm"> <br> 
					Date: <input
						id="aDate" name="aDate" type="text"
						class="form-control form-control-sm"> <br>
						<input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidanoSave" name="hidanoSave" value="">
				</form>
				<br>
				<br>
				<br>
				<br>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

			</div>
		</div>
		<br>
		<br> 
		<br>
		<br> 
		<div id="divAppointmentGrid"> 
		  <%
 				Appointment appObj = new Appointment(); 
 				out.print(appObj.readAppointment()); 
 
			%>
		
		  </div> 
 
	</div>


</body>
</html>