
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>


		<script type="text/javascript">
function validator() {

	document.getElementById("pass").innerHTML = "";

	if (document.getElementById("password").value == "") {

		document.getElementById("pass").innerHTML = "Plz Enter Old Password";
		return false;
	} else if (document.getElementById("changepassword").value == "") {
		document.getElementById("pass").innerHTML = "Plz Enter New Password";
		return false;
	} else if (document.getElementById("changepassword").value != document
			.getElementById("reenterpassword").value) {
		document.getElementById("pass").innerHTML = "Password Not Matched";
		return false;
	}

}
</script>


	</head>


	<body>


		<br />
		<br />
		<br />
		<br />
		<center>
			<span class=Title><h3>
					<font color="purple">Change Password Form</font>
				</h3> </span>
		</center>


		<form id="form3" name="newedesignation" method="post"
			action="./changepasswordaction.do" onsubmit="return validator();">


			<c:if test="${requestScope.message!='null'}">

				<c:out value="${requestScope.message}"></c:out>

			</c:if>

			<table border="0" align="center">
				<tr>
					<td>
						<span class=Title> Login Name : </span>
					</td>
					<td>
						<input type="text" name="loginid"
							value="<%=session.getAttribute("loginid")%>" readonly />
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> Old Password : </span>
					</td>
					<td>
						<input type="password" name="password" id="password" />
						<div id="pass"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> New Password :</span>
					</td>
					<td>
						<input type="password" name="changepassword" id="changepassword" />
						<div id="pass"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> ReEnter Password :</span>
					</td>
					<td>
						<input type="password" name="reenterpassword" id="reenterpassword" />
						<div id="pass"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<strong> <input type="submit" name="Submit"
									value="Change" /> </strong>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<br />
	</body>
</html>
