<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>
		<hr />
	      <center>
	         <b><font color="skyblue" size="5">
				<bean:message key="branch.header" />
			</font></b>
			<hr />
			<html:form action="/addBranchAction" method="get">
				<table>



					<c:if test="${requestScope.message!='null'}">
						<tr>
							<td colspan='2'>
							<font color="green" size="3">	<c:out value="${requestScope.message}"></c:out></font>
							</td>
						</tr>
					</c:if>

					<tr>
						<td ><font color="#003366" size=""><b>
							<bean:message key="branch.branchname" />
						</b></font></td>
						<td>
							<html:text property="branchName" />
							
							<html:errors property="branchName" />
						</td>
					</tr>
<tr>

<td></td>
					</tr>
					<tr>
						<td><font color="#003366" size=""><b>
							<bean:message key="branch.description" />
						</b></font></td>
						<td>
							<html:textarea property="branchDesc" rows="4" cols="20" />
							<html:errors property="branchDesc" />
						</td>
					</tr>

					<tr>

<td></td>
					</tr>
					<tr>

<td></td>
					</tr>
					<tr>

<td></td>
					</tr>
					<tr>

<td></td>
					</tr>

					<tr>
						<td colspan="2" align="center">
							&nbsp; &nbsp; &nbsp;&nbsp;
							<html:submit>
								<bean:message key="register.submit.value" />
							</html:submit>
							


						</td>

					</tr>
				</table>
			</html:form>
		</center>


	</body>
</html>
