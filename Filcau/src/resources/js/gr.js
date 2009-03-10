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
		response = JSON.parse(data);
		players = response["players"];
		var s = "";
		for (index in players) {
			s += "<p><label>" + players[index] + "</label> <span class='small valid'>NOT READY</span>" + "</p>";
		} 
		$("#players").html(s);

		displayTeams(response["teams"]);
		if (players.length == 4) {
			$("#status").text("Game room is full");
			if ($(".invalid").size() == 0) {
				$("#startGameBt").show();
			} else {
				$("#startGameBt").hide();
			}
		} else {
			$("#status").text("Waiting for players...");
			$("#startGameBt").hide();
		}
	});
};

function doJoin(team) {
	$("#teams a.join").addClass("hidden");
	$("#team" + team + " a.leave").removeClass("hidden");
	$.post('/g', {op: 'joinTeam', id: gameId, team: team}, loadTeams);
};
function doLeaveTeam(team) {
	$("#teams a.join").removeClass("hidden");
	$("#team" + team + " a.leave").addClass("hidden");
	$.post('/g', {op: 'leaveTeam', id: gameId, team: team}, loadTeams);
};
function loadTeams(data) {
		teams = JSON.parse(data);
		displayTeams(teams);
};
function displayTeams(teams) {
	for (index in teams) {
		var player = $("#player" + index);		
		if (teams[index] == null) {
			player.removeClass("active");
		} else {
			player.text(teams[index]);
			player.addClass("active");
		}
	}
	updatePlayerStatus();
};

function updatePlayerStatus() {
	var players = new Array(); 
	$("#teams div.player.active").each(function() {
		players.push($(this).text());
	});
	$("#players p").each(function()  {
	    jThis = $(this);
	    if (jQuery.inArray(jThis.find("label").text(), players) == -1) {
	        jThis.find("span").text("NOT READY").attr("class", "small invalid");
	    } else {
	    	jThis.find("span").text("READY").attr("class", "small valid");
	    }
	});
};