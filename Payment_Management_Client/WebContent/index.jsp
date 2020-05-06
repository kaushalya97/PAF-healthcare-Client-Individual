<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.healthcare.model.Payment" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
<meta charset="ISO-8859-1">
<title>Payment Management</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-8">

				<h1 class="m-3">Payment details</h1>

				<form id="formPayment" name="formPayment">
					Appointment ID: 
						<input id="paymentId" name="paymentId"
						type="text" class="form-control form-control-sm"> <br>
					Patient name: 
						<input id="patientName" name="patientName"
						type="text" class="form-control form-control-sm"> <br>
					Doctor Name: 
						<input id="doctorName" name="doctorName" type="text"
						class="form-control form-control-sm"> <br> 
					Hospital Name: 
						<input id="hospitalName" name="hospitalName" type="text"
						class="form-control form-control-sm"> <br> 
					Date:
						 <input id="date" name="date" type="text"
						class="form-control form-control-sm"> <br>
					Doctor Charges:
						 <input id="doctorCharges" name="doctorCharges" type="text"
						class="form-control form-control-sm"> <br> 
					Hospital Charges: 
						<input id="hospitalCharges" name="hospitalCharges" type="text"
						class="form-control form-control-sm"> <br>
					Total: 
						<input id="total" name="total" type="text"
						class="form-control form-control-sm"> <br>
						<input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidPaymentIDSave" name="hidPaymentIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

			</div>
		</div>
		<br> 
		<div id="divPaymentGrid"> 
		  <%
 		  	Payment payObj = new Payment(); 
 		   	out.print(payObj.readPayment());
 		  %>
		  </div> 
 

	</div>


</body>
</html>