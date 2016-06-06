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
		<hr />
		<center>
			<b><font color="#003366" size="4"> <bean:message
						key="org.pheader" /> </font> </b>
			<hr />

			<table align="center" border="" width="640" bgcolor="white">
				<tr>
					<td width="70" align="center">
						<b> <font color="#003366">S.No.</font>
						</b>
					</td>
					<td width="70">
						<b><font color="#003366">LoginId</font> </b>
					</td>
					<td width="60" align="center">

						<b><font color="#003366">B_Name</font> </b>

					</td>
					<td width="100" align="center">
						<b><font color="#003366"> S_Name</font> </b>
					</td>


					<td width="40">
						<b><font color="#003366">year</font> </b>
					</td>
					<td width="100">
						<b><font color="#003366">College</font> </b>
					</td>
					<td width="100" align="center">

						<b><font color="#003366">Address</font> </b>

					</td>
					<td width="100" align="center">
						<b><font color="#003366">Date</font> </b>
					</td>
				</tr>

				<logic:iterate id="data" name="vPraticipantStudentDetailsBeans"
					type="com.cems.bean.PraticipantStudentDetailsBean">

					<tr>
						<td width="100" align="center">
							<!--<input type=checkbox name=participantstudentid
								value='<bean:write name="data" property="participantstudentid" />' />

							<a
								href="./viewBranchByid.do?participantstudentid=<bean:write name="data" property="participantstudentid" />"
								style="text-decoration: none;"><bean:write name="data"
									property="participantstudentid" /> </a>
						-->
							<bean:write name="data" property="participantstudentid" />
						</td>
						<td width="70" align="center">
							<bean:write name="data" property="logindetails.loginid" />
						</td>
						<td width="70" align="center">
							<bean:write name="data" property="branch.branchname" />
						</td>
						<td width="70" align="center">
							<bean:write name="data" property="studentname" />
						</td>
						<td width="40" align="center">
							<bean:write name="data" property="branchyear" />
						</td>
						<td width="100" align="center">
							<bean:write name="data" property="studentcollege" />
						</td>
						<td width="100" align="center">
							<bean:write name="data" property="collegeaddress" />
						</td>
						<td width="100" align="center">
							<bean:write name="data" property="registereddate" />
						</td>
					</tr>
				</logic:iterate>
			</table>
			<br>
			<br>
	</body>
</html>
