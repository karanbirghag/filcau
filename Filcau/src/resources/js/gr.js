$(function() {
	updatePlayerListRepeatadly();
});
function updatePlayerListRepeatadly() {
	updatePlayerList();
	setTimeout('updatePlayerListRepeatadly();', 10000);
};

function doDeleteGame() {
	$.post('/game', {op: "delete"}, function(data) {
		window.location.replace("/");
	});
};
function doLeaveGame(gameId) {
	$.post('/g', {op: "leave", id: gameId}, function(data) {
		window.location.replace("/");
	});
};

function updatePlayerList() {
	$.post('/g', {op: "check", id: $("#gameId").val()}, function(data) {
		if (data == "Game ended") {
			alert("The game was ended by the owner.");
			window.location.replace("/");
		}
		players = JSON.parse(data);
		var s = "";
		for (index in players) {
			s += "<p>" + players[index] + " <span class='small'>not ready</span>" + "</p>";
		} 
		$("#players").html(s);

		if (players.length == 4) {
			$("#status").text("Game room is full");
			$("#startGameBt").show();
		} else {
			$("#status").text("Waiting for players...");
			$("#startGameBt").hide();
		}
	});
};

function doJoin(team) {
	$.post('/g', {op: 'joinTeam', id: gameId, team: team}, function(data) {
		alert(data);
	});
};