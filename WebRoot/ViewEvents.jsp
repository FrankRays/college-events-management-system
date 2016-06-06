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
				<b><font color="#003366" size="4"> <bean:message
							key="events.Vheader" /> </font> </b>
				<hr />



				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">

						<td width="70" align="center">
							<b><font color="#003366">EventId</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">EventName</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">EventDescription</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">EventOnCollege</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">CollegeAddresses</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">EventDate</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">EventTime</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">URL</font> </b>
						</td>
					</tr>


					<logic:iterate id="data" name="vEventsBeans"
						type="com.buzz.bean.EventsBean">

						<tr bgcolor="white">

							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">
										<!--<a
											href='./vieweventbyidaction.do?eventid=<bean:write name="data" property="eventid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="eventid" /> </a>
									-->
										<bean:write name="data" property="eventid" />
									</c:when>

									<c:otherwise>


										<bean:write name="data" property="eventid" />

									</c:otherwise>
								</c:choose>
							</td>



							<td width="250">
								<bean:write name="data" property="eventname" />
							</td>
							<td width="250">
								<bean:write name="data" property="eventdesc" />
							</td>
							<td width="250">
								<bean:write name="data" property="eventoncollege" />
							</td>
							<td width="250">
								<bean:write name="data" property="eventonaddress" />
							</td>
							<td width="250">
								<bean:write name="data" property="eventdate" />
							</td>
							<td width="250">
								<bean:write name="data" property="eventtime" />
							</td>
							<td width="250">
					<b><a href='http://<bean:write name="data" property="url" />'>			<bean:write name="data" property="url" />
							</a></td>
						</tr>
					</logic:iterate>
				</table>
				<br>
				<br>



			</center>
		</html:form>


	</body>
</html>
