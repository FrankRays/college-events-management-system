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
							key="branch.Vheader" /> </font> </b>
				<hr />



				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">

						<td width="70" align="center">
							<b><font color="#003366">BranchId</font> </b>
						</td>
						<td width="150" align="center">
							<b> <b><font color="#003366">BarnchName</font> </b>
						</td>
						<td width="350" align="center">
							<b> <font color="#003366">Description</font> </b>
						</td>
					</tr>


					<logic:iterate id="data" name="vBranchBeans"
						type="com.buzz.bean.BranchBean">

						<tr bgcolor="white">
							<!--<td width="30" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">
										<input type=checkbox name=branchid
											value='<bean:write name="data" property="branchid" />' />
									</c:when>

									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</td>
							-->
							<td width="70" align="center">
								<c:choose>
									<c:when test="${sessionScope.logintype eq 'admin'}">
										<!--<a
											href='./viewBranchByid.do?branchid=<bean:write name="data" property="branchid" />'
											style="text-decoration: none;"> <bean:write name="data"
												property="branchid" /> </a>
									-->
										<bean:write name="data" property="branchid" />
									</c:when>

									<c:otherwise>

										<bean:write name="data" property="branchid" />
									</c:otherwise>
								</c:choose>
							</td>
							<td width="150" align="center">
								<bean:write name="data" property="branchname" />
							</td>
							<td width="250">
								<bean:write name="data" property="branchdesc" />
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
