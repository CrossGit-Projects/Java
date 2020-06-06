<html lang=''>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/styles.css">
<link rel="stylesheet" href="/resources/css/style.css">

<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="/resources/js/script.js"></script>
<title>CSS MenuMaker</title>
</head>
<body>

<div id="cssmenu">
	<ul>
				<sec:authorize access="hasRole('ANONYMOUS')">
						<li><a class="active" href="/index"><s:message code="menu.mainPage"/></a></li>
						<li class="marginLeft"><a href="/login"><s:message code="menu.login"/></a></li>
						<li class="marginLeft"><a href="/register"><s:message code="menu.register"/></a></li>
						<a style="background-color: white" href="?lang=pl">pl</a> |
						<a style="background-color: white" href="?lang=en">en</a> | <a style="background-color: white" href="?lang=de">de</a>

				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
						<li><a class="active" href="/index1"><s:message code="menu.mainPage"/></a></li>
						<li class="marginLeft"><a href="/logout"><s:message code="menu.logout"/></a></li>
						<a style="background-color: white" href="?lang=pl">pl</a> |
						<a style="background-color: white" href="?lang=en">en</a> | <a style="background-color: white" href="?lang=de">de</a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="/admin/users/1"><s:message code="menu.adminPage"/></a></li>
						<li><a href="/"><s:message code="menu.karol"/></a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_DOCTOR')">
						<li><a href="/doctor/cardDoctor"><s:message code="menu.cardDoctor"/></a></li>
						<li><a href="/doctor/visitDoctor"><s:message code="menu.visitDoctor"/></a></li>
						<li><a href="/"><s:message code="menu.karol"/></a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_PATIENT')">
						<li><a href="/patient/cardPatient"><s:message code="menu.cardPatient"/></a></li>
						<li><a href="/patient/visitsPatient"><s:message code="menu.visitPatient"/></a></li>
						<li><a href="/patient/myVisits"><s:message code="menu.myVissits"/></a></li>
				</sec:authorize>


	</ul>
</div>

</body>
<html>