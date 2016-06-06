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
		<html:form action="/deletestudyaction.do" method="get">
			<hr />
			<center>
				<b><font color="#003366" size="4"> <!--<bean:message
							key="branch.Vheader" /> --> VIEW STUDYDETAILS</font> </b>
				<hr />
				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">
						<td width="70" align="center">
							StudyID
						</td>
						<td width="70" align="center">
							<b><font color="#003366">StudyName</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">StudyDesc</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">Date</font> </b>
						</td>

					</tr>


					<logic:iterate id="data" name="vStudyDetailsBeans"
						type="com.buzz.bean.StudydetailsBean">

						<tr bgcolor="white">

							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">
										<!--

										<a
											href='./viewBranchByid.do?studyid=<bean:write name="data" property="studyid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="studyid" /> </a>
									-->
										<bean:write name="data" property="studyid" />
									</c:when>
									<c:otherwise>
										<!--<a
											href='./viewstudybyidaction.do?studyid=<bean:write name="data" property="studyid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="studyid" /> </a>
									-->
										<bean:write name="data" property="studyid" />
									</c:otherwise>
								</c:choose>
							</td>
							<td width="150" align="center">
								<bean:write name="data" property="studyname" />
							</td>
							<td width="250">
								<bean:write name="data" property="studydesc" />
							</td>
							<td width="250">
								<bean:write name="data" property="studydate" />
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
