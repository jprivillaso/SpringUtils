$(document).ready(function() {

	$.ajax({
		type : 'GET',
		url: "restApi/users/findAll"
	}).done(function(users){
		
		var $tbody = $("tbody");
		
		for (var i = 0; i < users.length; i++) {
			
			var row = "<tr>";
			row += "<td>"+ users[i].name +"</td>";
			row += "<td>"+ users[i].lastName +"</td>";
			row += "<td>"+ users[i].email +"</td></tr>";
			
			$tbody.append($(row));
		}
		
	}).fail(function(){
		console.error("Error in request");
	});
	
});