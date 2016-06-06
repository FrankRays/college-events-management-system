<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>
			<h3>
				<bean:message key="placement.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/addplacementsaction" method="post">
				<table>

					<c:if test="${requestScope.message!='null'}">
						<tr>
							<td colspan='2'>
								<font color="green" size="3"> <c:out
										value="${requestScope.message}"></c:out>
								</font>
							</td>
						</tr>
					</c:if>
					<tr>
						<td>
							<bean:message key="placement.CompanyName" />
						</td>
						<td>
							<html:text property="placementCompanyName" />
							<html:errors property="placementCompanyName" />
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="placement.Description" />
						</td>
						<td>
							<html:textarea property="placementDescription" rows="4" cols="20" />
							<html:errors property="placementDescription" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="placement.date" />
						</td>
						<td>
							<html:text property="placementDate" />
							<html:errors property="placementDate" />
							(dd-mmm-yyyy)
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="placement.url" />
						</td>
						<td>
							<html:text property="placementUrl" />
							<html:errors property="placementUrl" />
				
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
						<td colspan="2" align="center">
							&nbsp; &nbsp; &nbsp;&nbsp;
							<html:submit>
								<bean:message key="pts.submit.value" />
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
