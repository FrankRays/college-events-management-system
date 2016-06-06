<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<body bgcolor='#0E89C7'>

		<c:choose>
			<c:when test="${sessionScope.logintype eq 'admin'}">
				<jsp:include page="AdminMenu.jsp" />
			</c:when>
			<c:when test="${sessionScope.logintype eq 'student'}">
				<jsp:include page="StudentMenu.jsp" />
			</c:when>

			<c:otherwise>
				<jsp:include page="HomeMenu.jsp" />
			</c:otherwise>
		</c:choose>
		<br />

	</body>
</html>