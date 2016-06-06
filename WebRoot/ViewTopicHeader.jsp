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
		<html:form action="/deleteBranchesAction.do" method="get">
			<hr />
			<center>
				<b><font color="#003366" size="4">VIEW TOPIC HEADERS</font> </b>
				<hr />



				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">

						<td width="70" align="center">
							<b><font color="#003366">TopicHeaderID</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">TopicHeaderName</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">TopicImageFile</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">TopicDate</font> </b>
						</td>
					</tr>


					<logic:iterate id="data" name="vTopicHeaderBeans"
						type="com.buzz.bean.TopicHeaderBean">

						<tr bgcolor="white">

							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">

										<!--<a
											href='./viewBranchByid.do?topicheaderid=<bean:write name="data" property="topicheaderid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="topicheaderid" /> </a>
									-->
										<bean:write name="data" property="topicheaderid" />
									</c:when>

									<c:otherwise>

										<bean:write name="data" property="topicheaderid" />
									</c:otherwise>
								</c:choose>
							</td>

							<td width="250">
								<bean:write name="data" property="topicheadername" />
							</td>
							<td width="150" align="center">
								<img src='<bean:write name="data" property="filepath" />'
									height="100" width="100">

							</td>
							<td width="250">
								<bean:write name="data" property="topicdate" />
							</td>
						</tr>
					</logic:iterate>
				</table>
				<br>
				<br>



			</center>
		</html:form>


	</body>
</html>
