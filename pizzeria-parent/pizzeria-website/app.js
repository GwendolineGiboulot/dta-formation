$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8080/pizzeria-admin-app/api/pizzas"
	}).then(function(data) {



		data.sort(function(a, b){return a.categorie.localeCompare(b.categorie);});



		var lines = data.map(function(pizza){
			var linePizza ="";
			linePizza += "<tr>";

			linePizza += "<td>" + pizza.code  + "</td>";
			linePizza += "<td>" + pizza.nom + "</td>";
			linePizza += "<td>" + pizza.prix + "</td>";
			linePizza += "<td>" + pizza.categorie + "</td>";

			linePizza += "</tr>";


			return linePizza;

		});

/*		for (i = 0; i < data.length; i++) {

			html += "<tr>";

			html += "<td>" + data[i].code  + "</td>";
			html += "<td>" + data[i].nom + "</td>";
			html += "<td>" + data[i].prix + "</td>";
			html += "<td>" + data[i].categorie + "</td>";

			html += "</tr>";
		}
*/


		$('.pizza').html(lines);


	});
});