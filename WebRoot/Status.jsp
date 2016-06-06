<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>

			



					<c:if test="${requestScope.message!='null'}">
						
								<c:out value="${requestScope.message}"></c:out>
							
					</c:if>
			<br>
		</center>


	</body>
</html>