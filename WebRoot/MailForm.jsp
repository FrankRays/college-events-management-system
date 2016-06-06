<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#FAF0E6">
		<center>


			<hr />
	      <center>
	         <b><font color="skyblue" size="5">
				<bean:message key="mail.header" />
			</font></b>
			<hr />
			
			
			
			<html:form action="/sendmail.do" method="post">
				<table><c:if test="${requestScope.message!='null'}">
					<tr>
						<td colspan='2'>
							<font color="green" size="3"><c:out value="${requestScope.message}"></c:out></font>
						</td>
					</tr>
				</c:if>


				
					<tr>
						<td ><font color="#003366" size=""><b>

							<bean:message key="mail.tomailId" />

						</b></font></td>
						<td>
							<html:select property="tomailId">
								<c:forEach var="data" items="${vLogindetailsBeans}">


									<html:option value="${data.userid}">
										${data.loginid}
									</html:option>
								</c:forEach>
							</html:select>
							<html:errors property="tomailId" />
						</td>
					</tr>
					<tr>
					<td ><font color="#003366" size=""><b>
							<bean:message key="mail.messageHeader" />
						</b></font></td>
						<td>
							<html:text property="messageHeader" />
							<html:errors property="messageHeader" />
						</td>
					</tr>
					<tr>
						<td ><font color="#003366" size=""><b>
							<bean:message key="mail.messagebody" />
						</b></font></td>
						<td>
							<html:textarea property="messagebody" rows="4" cols="20" />
							<html:errors property="messagebody" />
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
								<bean:message key="mail.submit.value" />
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
