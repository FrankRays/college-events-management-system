<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>





		<hr />
		<center>
			<b><font color="#003366" size="4"> <bean:message
						key="news.vheader" /> </font> </b>
			<hr />
		



			<table>
				<c:set var="i" value="0" scope="request" />
				<logic:iterate id="data" name="vGaleryBeans"
					type="com.buzz.bean.GaleryBean">
					<c:choose>
						<c:when test="${requestScope.i eq '0'}">
							<tr>
								<td align="center">
						</c:when>
						<c:otherwise>
							<td align="center">
						</c:otherwise>

					</c:choose>
					<embed src="<bean:write name="data" property="filepath" />" height="200" width="150"></embed>
					<br>
					<bean:write name="data" property="galerydate" />
					<c:choose>
						<c:when test="${requestScope.i < 4}">
							<c:set var="i" value="${i+2}" scope="request" />
							</td>
						</c:when>
						<c:otherwise>
							<c:set var="i" value="0" scope="request" />
							</tr>
						</c:otherwise>

					</c:choose>


				</logic:iterate>




			</table>








			<br>
	</body>
</html>
