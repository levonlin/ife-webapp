$(".note-category-showBtn").click(function(){
	$("#hover-content").css({ display: "block", position: "absolute", background: "#000", opacity:"0.6",
							  width: $(document).width(), height: $(document).height() });
    $(".note-category").fadeIn();
});

$("#hover-content").mousedown(function(e){
		$("#hover-content").css("display", "none");
		$(".note-category").fadeOut();
});

$(".note-category-backBtn").click(function(){
		$("#hover-content").css("display", "none");
	    $(".note-category").fadeOut();
});

$(".note-content-list ul li").click(function(){
	$(".note-content").hide();
    $(".note-detail").fadeIn("slow");
});

$(".note-detail-closeBtn").click(function(){
	$(".note-detail").hide();
    $(".note-content").fadeIn("slow");
});