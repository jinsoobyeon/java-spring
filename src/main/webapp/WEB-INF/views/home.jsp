<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />" />
	<title>To Do</title>
</head>
<body>
	<header>
		<h1>TODO it!</h1>
	</header>
	<form class="inputBox shadow" action="/todo/create">
		<input name="todo" placeholder="Type what you have to do" maxlength="20" required />
		<button class="addBtn">+</button>
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
	<form>
		<button class="clearAllBtn">Clear All</button>
	</form>
</body>
</html>