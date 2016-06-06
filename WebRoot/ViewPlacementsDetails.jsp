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
				<b><font color="#003366" size="4"> <!--<bean:message
							key="branch.Vheader" /> --> VIEW PLACEMENT DETAILS</font> </b>
				<hr />



				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">

						<td width="70" align="center">
							<b><font color="#003366">PlacementID</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">PlaceMentName</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">PlacementDescription</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">PlacementDate</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">PlacementURL</font> </b>
						</td>
					</tr>


					<logic:iterate id="data" name="vPlacementInformationBeans"
						type="com.buzz.bean.PlacementinformationBean">

						<tr bgcolor="white">

							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">

										<!--<a
											href='./viewBranchByid.do?placementInfoId=<bean:write name="data" property="placementinfoid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="placementinfoid" /> </a>
									-->
										<bean:write name="data" property="placementinfoid" />
									</c:when>

									<c:otherwise>
										<!--<a
											href='./viewplacementsbyidaction.do?placementInfoId=<bean:write name="data" property="placementinfoid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="placementinfoid" /> </a>
									-->
										<bean:write name="data" property="placementinfoid" />
									</c:otherwise>
								</c:choose>
							</td>

							<td width="150" align="center">
								<bean:write name="data" property="placementcompnayname" />
							</td>
							<td width="250">
								<bean:write name="data" property="placementdescription" />
							</td>
							<td width="250">
								<bean:write name="data" property="placementdate" />
							</td>
							<td width="250">
								<a
									href='https:<bean:write name="data" property="placementurl" />'>

									<bean:write name="data" property="placementurl" />
								</a>
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
