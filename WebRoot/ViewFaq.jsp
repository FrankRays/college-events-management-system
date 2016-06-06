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
						key="faq.vheader" /> </font> </b>
			<hr />


			<table align="center" border="1" width="600" background="white">
				<tr bgcolor="white" align="center">
					<td width="50">
						<b><font color="#003366">ID</font> </b>
					</td>

					<td width="70" align="center">
						<b><font color="#003366">FAQ</font> </b>
					</td>
					<td width="250" align="center">

						<b><font color="#003366">Answer</font> </b>

					</td>
					<td width=100 " align="center">
						<b><font color="#003366">Post Date</font> </b>
					</td>
					<td width="30" align="center">
						<b><font color="#003366">Events</font> </b>
					</td>
				</tr>

				<logic:iterate id="data" name="vFaqsBeans"
					type="com.cems.bean.FaqsBean">

					<tr bgcolor="white">
						<!--<td width="50" align="center">
							<input type=checkbox name=faqid
								value='<bean:write name="data" property="faqid" />' />
							<a
								href="./viewfaqbyidaction.do?faqid=<bean:write name="data" property="faqid" />"
								style="text-decoration: none;"><bean:write name="data"
									property="faqid" /> </a>
						</td>
						-->
						<td width="50" align="center">
							<bean:write name="data" property="faqid" />
						</td>
						<td width="70" align="center">
							<bean:write name="data" property="faq" />
						</td>
						<td width="250" align="center">
							<bean:write name="data" property="answer" />
						</td>
						<td width="100" align="center">
							<bean:write name="data" property="posteddate" />
						</td>
						<td width="30" align="center">
							<bean:write name="data" property="eventidref" />
						</td>

					</tr>
				</logic:iterate>
			</table>
			<br>
			<br>

		</center>


	</body>
</html>
