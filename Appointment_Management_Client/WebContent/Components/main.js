$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

//Date Picker===================================================================

$( function() {
    $.datepicker.setDefaults({
        onClose:function(aDate, inst){
            $("#selectedDtaeVal").html(aDate);
        }
    });

    $( "#aDate" ).datepicker();
});



//SAVE & UPDATE ===================================================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	//Form validation-------------------
	 var status = validateAppointmentForm();
	
	
	if (status != true)
	{
		
		
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	var type = ($("#hidanoSave").val() == "") ? "POST" : "PUT"; 
	
	$.ajax(
			{
			 url : "AppointmentsAPI",
			 type : type,
			 data : $("#formAppointment").serialize(),
			 dataType : "text",
			 complete : function(response, status)
			 {
				 onAppointmentSaveComplete(response.responseText, status);
			 }
	 });
	
	
});

//DELETE ===============================================================================

$(document).on("click", ".btnRemove", function(event)
{
				 $.ajax(
				 {
					 url : "AppointmentsAPI",
					 type : "DELETE",
					 data : "ano=" + $(this).data("ano"),
					 dataType : "text",
					 complete : function(response, status)
					 {
						 onAppointmentDeleteComplete(response.responseText, status);
					 }
				 });
		});


//UPDATE==================================================================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidanoSave").val($(this).closest("tr").find('#hidanoUpdate').val());
	//$("#ano").val($(this).closest("tr").find('td:eq(0)').text());
	$("#aID").val($(this).closest("tr").find('td:eq(0)').text());
	$("#pName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#dName").val($(this).closest("tr").find('td:eq(2)').text());
	$("#hName").val($(this).closest("tr").find('td:eq(3)').text());
	$("#roomNO").val($(this).closest("tr").find('td:eq(4)').text());
	$("#appNO").val($(this).closest("tr").find('td:eq(5)').text());
	$("#aDate").val($(this).closest("tr").find('td:eq(6)').text());
	
}); 

function onAppointmentSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#divAppointmentGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidanoSave").val("");
	$("#formAppointment")[0].reset();
}

function onAppointmentDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			
			$("#divAppointmentGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}




   // CLIENT-MODEL=================================================================
	function validateAppointmentForm() {
	// Appointment ID
	if ($("#aID").val().trim() == "") {
		return "Insert appointment ID.";
	}
	if ($("#aID").val().trim().length != 4) {
		return "Insert valid appointment ID.";
	}
	// Patient Name
	if ($("#pName").val().trim() == "") {
		return "Insert patient name.";
	}
	// Doctor Name
	if ($("#dName").val().trim() == "") {
		return "Insert doctor name.";
	}
	// Hospital Name
	if ($("#hName").val().trim() == "") {
		return "Insert hospital name.";
	}
	// Room No

	if ($("#roomNO").val().trim() == "") {
		return "Insert room no.";
	}
	if ($("#roomNO").val().trim().length != 4) {
		return "Insert valid room no.";
	}
	// Appointment No
	if ($("#appNO").val().trim() == "") {
		return "Insert appointment no.";
	}
	if ($("#appNO").val().trim().length != 4) {
		return "Insert appointment no.";
	}
	// Date
	if ($("#aDate").val().trim() == "") {
		return "Insert appointment date.";
	}

	
	return true;


}


	
