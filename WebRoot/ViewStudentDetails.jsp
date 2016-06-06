<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
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
		<!--
		<html:form action="/deleteBranchesAction.do" method="get">
			-->

		<hr />
		<center>
			<b><font color="#003366" size="4"> <bean:message
						key="org.vheader" /> </font> </b>
			<hr />

			<table align="center" border="" width="640" bordercolor="black">
				<tr bgcolor="white" align="center">
					<td width="70">
						<b><font color="#003366">S.No.</font> </b>
					</td>
					<td width="100" align="center">
						<b><font color="#003366"> S_Name</font> </b>
					</td>
					<td width="60" align="center">
						<b><font color="#003366">B_Name</font> </b>
					</td>
					<td width="40" align="center">
						<b><font color="#003366">year</font> </b>
					</td>
					<td width="100" align="center">
						<b><font color="#003366">Date</font> </b>
					</td>
				</tr>
				<logic:iterate id="data" name="vStudentDetailsBeans"
					type="com.buzz.bean.StudentDetailsBean">
					<tr bgcolor="white">

						<td width="100" align="center">

							<bean:write name="data" property="studentid" />
						</td>


						<td width="70" align="center">
							<bean:write name="data" property="studentname" />
						</td>
						<td width="70" align="center">
							<bean:write name="data" property="branch.branchname" />
						</td>
						<td width="100" align="center">
							<bean:write name="data" property="studentyear" />
						</td>

						<td width="100" align="center">
							<bean:write name="data" property="studentdate" />
						</td>
					</tr>
				</logic:iterate>
			</table>
			<br>
			<br>




			<!--<html:submit>
				<bean:message key="delete.submit.value" />
			</html:submit>
			<br>
		</html:form>
	-->
	</body>
</html>
