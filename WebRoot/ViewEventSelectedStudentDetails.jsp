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
			<form action='./parstueventelegibleaction.do'>
				<b><font color="#003366" size="4"> <bean:message
							key="sevents.vheader" /> </font> </b>
				<hr />

				<table align="center" border="1" width="600" background="white">
					<tr bgcolor="white">
						<td width="100" align="center">
							<b><font color="#003366">ID</font> </b>
						</td>
						<td width="100" align="center">
							<b><font color="#003366">StudentName</font> </b>
						</td>


						<td width="150" align="center">
							<b><font color="#003366">Events</font> </b>
						</td>
						<td width=150 " align="center">
							<b><font color="#003366">Date</font> </b>
						</td>
					</tr>
					<logic:iterate id="data" name="vParticipationstudenteventregBeans"
						type="com.cems.bean.ParticipationstudenteventregBean">

						<tr bgcolor="white">
							<td width="100" align="center">
								<input type=checkbox name=userid
									value='<bean:write name="data" property="logindetails.userid" />' />

								<bean:write name="data" property="participantstudenteventid" />

							</td>
							<td width="100" align="center">
								<bean:write name="data" property="logindetails.loginid" />
							</td>
							<td width="150" align="center">
								<bean:write name="data" property="events.eventname" />
							</td>
							<td width="150" align="center">
								<bean:write name="data" property="studenteventregistereddate" />
							</td>
						</tr>
					</logic:iterate>
					<tr>
						<td colspan='4' align="center">
							<input type='submit' value='Select' />
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
