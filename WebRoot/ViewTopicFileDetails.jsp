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
				<b><font color="#003366" size="4"> Related Topics </font> </b>
				<hr />



				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">

						<td width="70" align="center">
							<b><font color="#003366">TopicDataID</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">TopicName</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">TopicFileName</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">TopicDOC</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">TopicFileAddedDate</font> </b>
						</td>
					</tr>


					<logic:iterate id="data" name="vTopicFileBeans"
						type="com.buzz.bean.TopicfileBean">

						<tr bgcolor="white">

							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">

										<!--<a
											href='./viewBranchByid.do?topicdataid=<bean:write name="data" property="topicdataid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="topicdataid" /> </a>
									-->
										<bean:write name="data" property="topicdataid" />
									</c:when>

									<c:otherwise>

										<bean:write name="data" property="topicdataid" />
									</c:otherwise>
								</c:choose>
							</td>
							<td width="250" align="center">
								<bean:write name="data" property="topicfilename" />
							</td>

							<td width="250" align="center">
								<bean:write name="data" property="topicname.topicname" />
							</td>
							<td width="150" align="center">
								<a href="<bean:write name="data" property="filepath" />">DOWNLOAD\VIEW
								</a>
							</td>
							<td width="250" align="center">
								<bean:write name="data" property="fileadddate" />
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
