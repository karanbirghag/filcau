$(function() {
	$("ul.simpleList li").live("mouseover", function() {$(this).addClass("hover");});
	$("ul.simpleList li").live("mouseout", function() {$(this).removeClass("hover");}); 
	loadGamesRepetadly();
});

function loadGamesRepetadly() {
	loadGames();
	setTimeout('loadGamesRepetadly();', 30000);
};

function loadGames() {
	$.get('/game', function(data) {
		$("#gamesList li:not(.clean)").remove();
		objs = JSON.parse(data);
		for (i in objs) {
			obj = objs[i];
			$("#gamesList").prepend("<li><span class='first'>"
				+ obj.name + " (" + obj.len + "/4)" 
				+ "</span><span class='second'>"
				+ (obj.len == 4 ? "<a>game is full</a>" : "<a href='javascript:join(\"" + obj.id + "\")'>join game</a>")  
				+ "created by " + obj.creator + "</span"
				+ "</li>");
		}
	});
};


function join(gameId) {
	window.location.replace("/g?op=join&id=" + gameId);
};

function toggleElems(id1, id2) {
	$("#" + id1).toggle();
	$("#" + id2).toggle();
};