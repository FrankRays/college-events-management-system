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
				<b><font color="#003366" size="4"> View
						CoachingCenterDetails </font> </b>
				<hr />



				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">

						<td width="70" align="center">
							<b><font color="#003366">CoachingCenterID</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">StudyName</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">CoachingCenterName</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">CoachingCenterAddress</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">CoachingCenterDate</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">Contact</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">Description</font> </b>
						</td>


					</tr>


					<logic:iterate id="data" name="vCoachingCenterBeans"
						type="com.buzz.bean.CoachingcenterBean">

						<tr bgcolor="white">

							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">
										<!--<a
											href='./viewBranchByid.do?coachingcenterid=<bean:write name="data" property="coachingcenterid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="coachingcenterid" /> </a>
									-->
										<bean:write name="data" property="coachingcenterid" />
									</c:when>

									<c:otherwise>
										<bean:write name="data" property="coachingcenterid" />

									</c:otherwise>
								</c:choose>
							</td>
							<td width="250">
								<bean:write name="data" property="studydetails.studyname" />
							</td>
							<td width="150" align="center">
								<bean:write name="data" property="coachingcentername" />
							</td>
							<td width="250">
								<bean:write name="data" property="coachingaddresses" />
							</td>
							<td width="250">
								<bean:write name="data" property="coachingadddate" />
							</td>
							<td width="250">
								<bean:write name="data" property="coachingcontact" />
							</td>

							<td width="250">
								<bean:write name="data" property="coachingdesc" />
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
