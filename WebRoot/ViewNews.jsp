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
		<html:form action="/deletenewsaction.do" method="get">
			<hr />
			<center>
				<b><font color="" size="4"> <bean:message
							key="news.vheader" /> </font> </b>
				<hr />
				<table align="center" border="0" width="640" background="white">

					<logic:iterate id="data" name="vNewsfeedBeans"
						type="com.buzz.bean.NewsfeedBean">
						<tr bgcolor="white">

							<td bgcolor="">

								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">

										<a
											href="./viewnewsbyid.do?newsid=<bean:write name="data" property="newsid" />"
											style="text-decoration: none;"><bean:write name="data"
												property="newsheader" /> </a>	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<bean:write name="data" property="newsdate" />

									</c:when>
									<c:otherwise>
										<bean:write name="data" property="newsheader" />	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<bean:write name="data" property="newsdate" />

									</c:otherwise>


								</c:choose>

							</td>
						</tr>
						<tr bgcolor="white">
							<td width="600" bgcolor="">
								<bean:write name="data" property="newsdesc" />
							</td>
						</tr>
						<tr>
							<td>
								<hr />
							</td>
						</tr>
					</logic:iterate>
				</table>
				<br>
			</center>
		</html:form>
	</body>
</html>
