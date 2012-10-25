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
						$("#loginFrm").hide();
						var imageObj = new Image();
						imageObj.onload = function() {
							drawImage(this);
						};
						imageObj.src = '/img/parcare.png';
					}
				}
			});
		});
	});
	
	
	
    function drawImage(imageObj) {
        var stage = new Kinetic.Stage({
          container: "container",
          width: 800,
          height: 1712
        });
        var layer = new Kinetic.Layer();

        var backgroundImg = new Kinetic.Image({
          image: imageObj,
          x: 0,
          y: 0,
          width: 800,
          height: 1712
        });

        layer.add(backgroundImg);
        stage.add(layer);
      }
})(jQuery);
