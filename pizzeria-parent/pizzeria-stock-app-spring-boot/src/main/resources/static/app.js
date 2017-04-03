$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8080/rest/ingredients"
	}).then(function(data) {



		var lines = data.map(function(ingredient){
			var linePizza ="";
			linePizza += "<tr>";

			linePizza += "<td>" + ingredient.id  + "</td>";
			linePizza += "<td>" + ingredient.nom + "</td>";
			linePizza += "<td>" + ingredient.prix + "</td>";
			linePizza += "<td>" + ingredient.quantite + "</td>";

			linePizza += "</tr>";


			return linePizza;

		});

		$('.pizza').html(lines);


	});
});

