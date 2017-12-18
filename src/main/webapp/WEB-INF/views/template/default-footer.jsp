<%@ page language="java" contentType="text/html; charset=UTF-8" %>  
<script src="lib/jquery/jquery.js"></script>
<script src="lib/jquery-ui/jquery-ui.js"></script>
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script src="lib/jquery-toggles/toggles.js"></script>

<script src="lib/raphael/raphael.js"></script>

<script src="lib/flot/jquery.flot.js"></script>
<script src="lib/flot/jquery.flot.resize.js"></script>
<script src="lib/flot-spline/jquery.flot.spline.js"></script>

<script src="lib/jquery-knob/jquery.knob.js"></script>

<script src="js/quirk.js"></script>

<form id="frm" name="frm">
	<input type="hidden" id="pageName"  	name="pageName" />
</form>

<script type="text/javascript">
$(document).ready(function() {
	var pageName = "${param.pageName}";
	if(pageName != ""){
		$('li').removeClass("active");
		
		$("#"+pageName).addClass("active");
	}
});
</script>

