$(document).ready( function() {
	initialize();


	function initialize() {

		counterSent();
		counterClicked();
		counterFailed();
		counterOpened();
		counterProcessed();
		upDate();

		// Create WebSocket connection.
		const clientSocket = new WebSocket('ws://localhost:8080/websocket');

		// Connection opened
		clientSocket.addEventListener('open', function (event) {
			clientSocket.send('Ready!');
		});

		// Listen for messages
		clientSocket.addEventListener('message', function (event) {
			let message = event.data;
			console.log('Message from server ', message);
			if(message === "update"){
				webhookCallbackUpdate();
			}
		});

		// // Create WebSocket connection.
		// const serverSocket = new WebSocket('ws://localhost:8080/webhooks');
		//
		// // Connection opened
		// serverSocket.addEventListener('open', function (event) {
		// 	serverSocket.send('Hello Server!');
		// });
		//
		// // Listen for messages
		// serverSocket.addEventListener('message', function (event) {
		// 	console.log('Message from server ', event.data);
		// });

		//Table Data
		datahandler.jsonPrettyString(function(data) {
			let jsonObj = JSON.parse(data);
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

	//Send Email
	$("#emailServlet").on("click", (function(event) {
		event.preventDefault();
		$.ajax({
			url: '/emailservice',
			type: 'post', success:function () {
				counterSent();
			}
		});
	}));

	//Retrieve Email Stats
	$("#emailStats").on("click", (function(event) {
		event.preventDefault();
		$.ajax({
			url: '/stats',
			type: 'post', success:function () {
				// backend not working yet
			}
		});
	}));

});

function upDate() {
	JavaDate.toLocaleString(function (data) {
		$('.loadTime').text('').append(data);
	})
}

function counterSent() {
	emailhandler.getEmailCountSent(function(count){
		let counter = $("#counterSent");
		counter.text(parseInt(count));
	});

}

function counterOpened() {
	emailhandler.getEmailCountOpened(function (count) {
		let counter = $("#counterOpened");
		counter.text(parseInt(count));
	});
}

function counterClicked() {
	emailhandler.getEmailCountClicked(function (count) {
		let counter = $("#counterClicked");
		counter.text(parseInt(count));
	});
}

function counterFailed() {
	emailhandler.getEmailCountFailed(function (count) {
		let counter = $("#counterFailed");
		counter.text(parseInt(count));
	});
}

function counterProcessed() {
	emailhandler.getEmailCountProcessed(function (count) {
		let counter = $("#counterProcessed");
		counter.text(parseInt(count));
	});
}

function webhookCallbackUpdate(){
	counterClicked();
	counterFailed();
	counterOpened();
	counterProcessed()
}