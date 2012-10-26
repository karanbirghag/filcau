var mainStage;
var allCars;
var currentUser;
var stats;
var CAR_WIDTH = 48;
var CAR_HEIGHT = 100;

(function($) {

	//onReady
	$(function() {
		$("#submitBt").click(function() {
			$.ajax({
				type : 'POST',
				url : $("#loginFrm").attr("action"),
				data : "carNumber=" + $("#carNumber").val(),
				success : function(user) {
					if (user.error) {
						alert("Masina asta nu exista, mai incearca!");
					} else {
						currentUser = user;
						$("#loginFrm").hide();
						
				        var stage = new Kinetic.Stage({
				            container: "container",
				            width: 800,
				            height: 1712
				          });
				        
				        mainStage =stage;
						
						var backgroundObj = new Image();
						backgroundObj.onload = function() {
							drawImage(this, stage, 800, 1712, 0, 0);
							drawStats();
						};
						backgroundObj.src = '/img/parcare.png';

						
						$.ajax({
							type : 'GET',
							url : "/cars",							
							success : function(cars) {
								allCars = cars;
								var carImgs = new Object();
								for (var ci in cars) {
									var carObj = new Image();
									$(carObj).attr("index", ci);
									carObj.onload = function() {					
										var index = $(this).attr("index");
										drawImage(this, stage, allCars[index].x2 - allCars[index].x1, allCars[index].y2 - allCars[index].y1, allCars[index].x1, allCars[index].y1, true);
									};
									
									var width = allCars[ci].x2 - allCars[ci].x1;
									var height = allCars[ci].y2 - allCars[ci].y1;

									if (width < height) {
										carObj.src = '/img/carv.png';
									} else {
										carObj.src = '/img/car.png';
									}
									
									carImgs[ci] = carObj;
								}
							}
						});
					}
				}
			});
		});
	});
	
	function drawStats() {
		var layer = new Kinetic.Layer();
		var text = "";
		$.ajax({
			type : 'GET',
			url : "/statistics",							
			success : function(statsString) {
				stats = eval("[" + statsString + "]")[0];
				var complexText = new Kinetic.Text({
					x: 600,
					y: 10,
					stroke: '#555',
					strokeWidth: 5,
					fill: '#ddd',
					text: "FREE: " + stats.freeSpots + "\nOCCUPIED: " + stats.occupiedSpots + "\nBLOCKED: " + stats.blockedSpots + "\nBLOCKING: " + stats.blockingSpots,
					
					
					fontSize: 14,
					fontFamily: 'Calibri',
					textFill: '#555',
					width: 180,
					padding: 20,
					align: 'left',
					fontStyle: 'italic',
					shadow: {
						color: 'black',
						blur: 1,
						offset: [10, 10],
						opacity: 0.2
					},
					cornerRadius: 10
				});
				
				layer.add(complexText);
				mainStage.add(layer);
			}
		});
		
		
		
	}
	
    function drawImage(imageObj, stage, _w, _h, _x, _y, _d) {
        var layer = new Kinetic.Layer();

        var backgroundImg = new Kinetic.Image({
          image: imageObj,
          x: _x,
          y: _y,
          width: _w,
          height: _h,
          draggable: _d
        });
        
        backgroundImg.on("click", function(event) {
        
        	var x1 = event.pageX - CAR_WIDTH/2;
        	var y1 = event.pageY - CAR_HEIGHT/2;
        	var x2 = event.pageX + CAR_WIDTH/2;
        	var y2 = event.pageY + CAR_HEIGHT/2
        
        	var data = "OPERATION=CHECK_IN";
        	data += "&x1=" + x1;
        	data += "&y1=" + y1;
        	data += "&x2=" + x2;
        	data += "&y2=" + y2;
        	data += "&userKey=" + currentUser.key;
        	console.debug(data);
        	
        	$.ajax({
				type : 'GET',
				url : "/operation",
				data: data,							
				success : function(result) {
					if (result.error) {
						alert("Tocmai ai parcat intr-o alta masina. Mai incearca o data!");
					} else {
						var carObj = new Image();
						carObj.onload = function() {	
							var layer = new Kinetic.Layer();
							var carImg = new Kinetic.Image({
								image: carObj,
								x: x1,
								y: y1,
								width: x2-x1,
								height: y2-y1
							});
							carImg.on("click", function() {
								console.debug("click pe masina mea");
							});
							
							layer.add(carImg);
							mainStage.add(layer);
						}
						carObj.src = '/img/carv.png';
					}
				}
			});
        });

        layer.add(backgroundImg);
        stage.add(layer);
      }
})(jQuery);
