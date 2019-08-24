$(document).ready( function() {
	initialize();


	function initialize() {

		upDate();

		$("#table").DataTable();
	}

	$("#emailServlet").on("click", (function(event) {

		event.preventDefault();
		$.ajax({
			url: '/JerseyEmberBsDwrSendgrid_war_exploded/emailservice',
			type: 'post', success:function () {
				counter();
			}
		});

	}));

});


function upDate() {
	JavaDate.toLocaleString(function (data) {
		$('.loadTime').text('').append(data);
	})
}

function counter() {
	let counter = $("#counter");
	counter.text(parseInt(counter.text()) + 1);
}
