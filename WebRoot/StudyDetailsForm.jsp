<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>
			<h3>
				<bean:message key="study.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/addstudycenteraction" method="post">
				<table>
					<c:if test="${requestScope.message!='null'}">
						<tr>
							<td colspan='2'>
								<font color="green" size="3"> <c:out
										value="${requestScope.message}"></c:out> </font>
							</td>
						</tr>
					</c:if>
					<tr>
						<td>
							<bean:message key="study.name" />
						</td>
						<td>
							<html:text property="studyName" />
							<html:errors property="studyName" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="study.desc" />
						</td>
						<td>
							<html:textarea property="studyDesc" rows="2" cols="20" />
							<html:errors property="studyDesc" />
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
								<bean:message key="study.submit.value" />
							</html:submit>
							<html:reset>
								<bean:message key="register.reset.value" />
							</html:reset>
						</td>
					</tr>
				</table>
			</html:form>
		</center>
	</body>
</html>
