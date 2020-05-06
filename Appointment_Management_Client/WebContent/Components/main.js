$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});

// Save---------
$(document).on(
		"click",
		"#btnSave",
		function(event) {
			// Clear status messages---------------------
			$("#alertSuccess").text("");
			$("#alertSuccess").hide();
			$("#alertError").text("");
			$("#alertError").hide();

			// Form validation-------------------
			var status = validateAppointmentForm();

			// If not valid
			if (status != true) {
				$("#alertError").text(status);
				$("#alertError").show();
				return;
			}

			// If valid----------------------
			var appointment = getAppointmentrCard($("#txtName").val().trim(), 
												$("#txtName").val().trim(), 
												$("#txtName").val().trim(), 
												$("#txtName").val().trim(), 
												$("#txtName").val().trim(), 
												$("#txtName").val().trim(), 
												$("#txtName").val().trim());

			$("#colDoctors").append(appointment);
			$("#alertSuccess").text("Saved successfully.");
			$("#alertSuccess").show();
			$("#formAppointment")[0].reset();
		});

// REMOVE==========================================
$(document).on("click", ".remove", function(event) {
	$(this).closest(".appointment").remove();

	$("#alertSuccess").text("Removed successfully.");
	$("#alertSuccess").show();
});

// CLIENT-MODEL=================================================================
function validateAppointmentForm() {
	// Appointment ID
	if ($("#txtName").val().trim() == "") {
		return "Insert appointment id.";
	}
	// Patient Name
	if ($("#txtName").val().trim() == "") {
		return "Insert patient name.";
	}
	// Doctor Name
	if ($("#txtName").val().trim() == "") {
		return "Insert doctor name.";
	}
	// Hospital Name
	if ($("#txtName").val().trim() == "") {
		return "Insert hospital name.";
	}
	// Room No
	if ($("#txtName").val().trim() == "") {
		return "Insert room no.";
	}
	// Appointment No
	if ($("#txtName").val().trim() == "") {
		return "Insert appointment no.";
	}
	// Date
	if ($("#txtName").val().trim() == "") {
		return "Insert appointment date.";
	}

	
	return true;
}

function getStudentCard(name, gender, year) {
	var title = (gender == "Male") ? "Mr." : "Ms.";

	var yearNumber = "";

	var appointment = "";
	appointment += "<div class=\"student card bg-light m-2\"  "
			+ "style=\"max-width: 10rem; float: left;\">";
	appointment += "<div class=\"card-body\">";
	appointment += title + " " + name + ",";
	appointment += "<br>";
	appointment += yearNumber + " year";
	appointment += "</div>";
	appointment += "<input type=\"button\" value=\"Remove\"  class=\"btn btn-danger remove\">";
	appointment += "</div>";

	return appointment;

}
