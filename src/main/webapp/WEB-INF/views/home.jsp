<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />" />
	<title>To Do</title>
	<style>
		ul {
			list-style-type: none;
			padding-left: 0px;
			margin-top: 0px;
			text-align: left;
		}

		li {
			height: 50px;
			line-height: 50px;
			margin: 0.5rem 0;
			padding: 0 0.9rem;
			background: white;
			border-redius: 5px;
		}
	</style>
</head>
<body>
	<header>
		<h1>TODO it!</h1>
	</header>
	<form class="inputBox shadow" action="/todo/create">
		<input name="todo" placeholder="Type what you have to do" maxlength="20" required />
		<button>+</button>
	</form>
	<section>
		<ul>
			<c:forEach items="${todos}" var="todo">
				<li class="shadow">
					${todo}
				</li>
			</c:forEach>
		</ul>
	</section>
</body>
</html>