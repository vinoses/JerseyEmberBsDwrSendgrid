$(document).ready( function() {
	initialize();


	function initialize() {

		upDate();

		datahandler.jsonPrettyString(function(data) {
			let jsonObj = JSON.parse(data);
			console.error(data);
			$('#table').DataTable( {
				data: jsonObj,
				"columns": [
					{ data: '#' },
					{ data: 'Product' },
					{ data: 'Payment Taken' },
					{ data: 'Status' }],
				"columnDefs": [ {
					"targets": 3,
				"createdCell": function (tr, cellData, rowData, row, col) {
					console.error(cellData);
					if ( cellData === 'Pending' ) {
						$(tr).parent().addClass('table-warning');
					} else if( cellData === 'Default'){
						$(tr).parent().addClass('table-primary');
					} else if( cellData === 'Declined'){
						$(tr).parent().addClass('table-danger');
					} else if( cellData === 'Call in to confirm'){
						$(tr).parent().addClass('table-info');
					} else if( cellData === 'Approved'){
						$(tr).parent().addClass('table-success')
					}
				}}]

			} );
		});

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
