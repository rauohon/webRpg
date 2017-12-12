<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!--<link rel="shortcut icon" href="/images/favicon.png" type="image/png">-->

<title>Web style RPG</title>

<link rel="stylesheet" href="lib/Hover/hover.css">
<link rel="stylesheet" href="lib/fontawesome/css/font-awesome.css">
<link rel="stylesheet" href="lib/weather-icons/css/weather-icons.css">
<link rel="stylesheet" href="lib/ionicons/css/ionicons.css">
<link rel="stylesheet" href="lib/jquery-toggles/toggles-full.css">
<link rel="stylesheet" href="lib/morrisjs/morris.css">

<link rel="stylesheet" type="text/css" href="css/quirk.css">

<script src="/lib/modernizr/modernizr.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="/lib/html5shiv/html5shiv.js"></script>
<script src="/lib/respond/respond.src.js"></script>
<![endif]-->

<script>
	var header = {
		pageSubmitFn : function(pageName) {
			$("#pageName").val(pageName);

			if (pageName == "main") {
				$("#frm").attr("action", "main");
			}else if (pageName == "signInPage") {
				$("#frm").attr("action", "signInPage");
			}else if (pageName == "signIn") {
				$("#frm").attr("action", "signIn");
			}else if (pageName == "signUp") {
				$("#frm").attr("action", "signUp");
			}

			$("#frm").submit();
		}
	}
</script>