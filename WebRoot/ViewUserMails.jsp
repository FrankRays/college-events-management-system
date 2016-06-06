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
		<form action="./deletedata.do">
		
		
		 <hr />
	      <center>
	          <b><font color="#003366" size="4">
				<bean:message key="mail.vheader" />
			</font></b>
			<hr />
	  
		 <table align="center" border="1" width="600" background="white">
		<tr bgcolor="white">
		<td width="30" align="center">
		<font color="#003366">Select</font>
		</td>
		<td width="70" align="center">
		<font color="#003366">SenderId</font>
		</td>
		<td width="70" align="center">
		<font color="#003366">ReceiverId</font>
		</td>
		<td width="100" align="center">
		
		<font color="#003366">Heading</font>
		
		</td>
		<td width="150" align="center">
		<font color="#003366">Body</font>
		</td>
		<td width="100" align="center">
		<font color="#003366">Date</font>
		</td>
		</tr>
		
			<logic:iterate id="data" name="vStudentInboxBeans"
				type="com.cems.bean.StudentInboxBean">
				
				<tr bgcolor="white">
				<td width="30" align="center">
				<input type=checkbox name=eventid
					value='<bean:write name="data" property="messageid" />' /></td>
				
				<td width="70" align="center"><bean:write name="data" property="logindetailsByTomailid.loginid" /></td>
				<td width="70" align="center"><bean:write name="data" property="logindetailsByFrommailid.loginid" /></td>
				
				<td width="100" align="center"><bean:write name="data" property="messageheader" /></td>
				<td width="150" align="center"><bean:write name="data" property="messagebody" /></td>
				<td width="100" align="center"><bean:write name="data" property="messageposteddate" /></td>
				</tr>
			</logic:iterate>
			</table>
			</br>
			<input type='hidden' value='mail' name='type' />
			<input type='submit' value='Delete' name='mail' />
			<br>
	</body>
</html>
