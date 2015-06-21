$(document).ready(function() {
	
	$("#applyBtn").on("click", function(){
		
		var data = {};
		
		var nameFilter = $("#name").val();
		var lastnameFilter = $("#lastname").val();
		var emailFilter = $("#email").val();
		
		data.name = _.isEmpty(nameFilter) ? null : nameFilter;
		data.lastname = _.isEmpty(lastnameFilter) ? null : lastnameFilter;
		data.email = _.isEmpty(emailFilter) ? null : emailFilter;
		
		$.ajax({
			data: JSON.stringify(data),
			type : 'POST',
		    contentType: 'application/json',
			url: "restApi/users/findUsersByFilter"
		}).done(function(users){
			
			var $tbody = $("tbody");
			
			$tbody.children().remove();
			
			for (var i = 0; i < users.length; i++) {
				
				var row = "<tr>";
				row += "<td>"+ users[i].name +"</td>";
				row += "<td>"+ users[i].lastname +"</td>";
				row += "<td>"+ users[i].email +"</td></tr>";
				
				$tbody.append($(row));
			}
			
		}).fail(function(){
			console.error("Error in request");
		});
		
	});
	
	// Initial trigger to populate all users
	$("#applyBtn").trigger("click");
	
});