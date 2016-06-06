<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#FAF0E6">

		<center>

			<b><font color="skyblue" size="5"> <bean:message
						key="login.header" /> </font> </b>


			<html:form action="/login" method="post">

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
							<font color="#003366" size=""><b> <bean:message
										key="login.loginid" /> </b> </font>
						</td>
						<td>
							<html:text property="loginid" />
							<html:errors property="loginid" />

						</td>

					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>
							<font color="#003366" size=""><b> <bean:message
										key="login.password" /> </b> </font>
						</td>
						<td>
							<html:password property="password" />
							<html:errors property="password" />
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
								<bean:message key="login.submit.value" />
							</html:submit>
						</td>
					</tr>
				</table>
			</html:form>
		</center>


	</body>
</html>
