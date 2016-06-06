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
		<center>
			<h3>
				<bean:message key="branch.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/updateBranchbyidAction.do" method="get">
				<table>
					<c:if test="${requestScope.message!='null'}">
						<tr>
							<td colspan='2'>
								<c:out value="${requestScope.message}"></c:out>
							</td>
						</tr>
					</c:if>

					<tr>
						<td>
							<bean:message key="branch.branchname" />
						</td>
						<td>
							<html:text property="branchName" value='${branchBean.branchname}' />

							<html:errors property="branchName" />
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="branch.description" />
						</td>
						<td>
							<html:textarea property="branchDesc" rows="4" cols="20"
								value='${branchBean.branchdesc}' />
							<html:errors property="branchDesc" />
							<html:hidden property="branchid" value='${branchBean.branchid}' />
						</td>
					</tr>
					<tr>


					</tr>

					<tr>
						<td colspan="2" align="center">
							&nbsp; &nbsp; &nbsp;&nbsp;
							<html:submit>
								<bean:message key="register.submit.value" />
							</html:submit>
							<html:reset>
								<bean:message key="register.reset.value" />
							</html:reset>
						</td>
					</tr>
				</table>
			</html:form>
		</center>
		<br>
	</body>
</html>
