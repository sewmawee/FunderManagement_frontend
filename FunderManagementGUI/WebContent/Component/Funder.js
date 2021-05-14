//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#hidIDSave").val("");
	$("#FUNDER")[0].reset();
});

$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
// If valid------------------------
   
	var type = ($("#funderID").val() == "") ? "POST" : "PUT";
	$.ajax({
		url : "funderAPI",
		type : type,
		data : $("#FUNDER").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

});

function onItemSaveComplete(response, status) {
	
	if (status == "success") {
		
		//console.log(response);
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#FunderGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error") {
		
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	
	$("#funderID").val("");
	$("#FUNDER")[0].reset();
}

$(document).on("click", ".btnRemove", function(event) {

	
	$.ajax({
		url : "funderAPI",
		type : "DELETE",
		data : "funderID=" + event.target.value,
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
			window.location.reload(true);
			
		}
	});
});

function onItemDeleteComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#FunderGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		
	} else if (status == "error") {
		
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
		{
		
			
			$("#funderID").val($(this).closest("tr").find('td:eq(0)').text());
			$("#funderCode").val($(this).closest("tr").find('td:eq(1)').text());
			$("#funderName").val($(this).closest("tr").find('td:eq(2)').text());
			$("#funderAddress").val($(this).closest("tr").find('td:eq(3)').text());
			$("#funderTel").val($(this).closest("tr").find('td:eq(4)').text());
			$("#funderEmail").val($(this).closest("tr").find('td:eq(5)').text());
			$("#funderGender").val($(this).closest("tr").find('td:eq(6)').text());
			$("#funderFund").val($(this).closest("tr").find('td:eq(7)').text());
			$("#funderTime").val($(this).closest("tr").find('td:eq(8)').text());
			$("#funderDes").val($(this).closest("tr").find('td:eq(9)').text());		
});


// CLIENTMODEL=========================================================================
function validateItemForm() {
	
	
	
	// code
	if ($("#funderCode").val().trim() == "") {
		return "Please enter code.";
	}
	
	// name
	if ($("#funderName").val().trim() == "") {
		return "Please enter name.";
	}

	// address
	if ($("#funderAddress").val().trim() == "") {
		return "Please enter address.";
	}
	
	// tel
	if ($("#funderTel").val().trim() == "") {
		return "Please enter telephone number.";
	}
	
	// email
	if ($("#funderEmail").val().trim() == "") {
		return "Please enter email.";
	}
	
	// gender
	if ($("#funderGender").val().trim() == "") {
		return "Please enter gender.";
	}
	
	// fund
	if ($("#funderFund").val().trim() == "") {
		return "Please enter fund.";
	}
	// Time
	if ($("#funderTime").val().trim() == "") {
		return "Please enter time.";
	}
	// Post Publish Time
	if ($("#funderDes").val().trim() == "") {
		return "Please enter description.";
	}
	
	return true;
}
	
	


	
	