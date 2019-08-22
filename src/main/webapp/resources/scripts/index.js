$(document).ready( function() {
	initialize();



	function initialize(){
		JavaDate.toLocaleString( function (data) {

			$('.loadTime').text('').append(data);


		});

		$("#table").DataTable();
	}
});