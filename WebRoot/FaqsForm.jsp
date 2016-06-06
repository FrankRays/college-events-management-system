<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#FAF0E6">
	
			
			
			
			<center>
		<hr />
	      <center>
	         <b><font color="skyblue" size="5">
				<bean:message key="faq.header" />
			</font></b>
			<hr />
			<html:form action="/addfaqaction.do" method="get">
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
							<bean:message key="events.name" />
						</b></font></td>
						<td>
							<html:select property="eventidref">
								<c:forEach var="data" items="${vEventsBeans}">


									<html:option value="${data.eventid}">
										${data.eventname}
									</html:option>
								</c:forEach>
							</html:select>
							<html:errors property="eventidref" />
						</td>
					</tr>
					<tr>
						<td ><font color="#003366" size=""><b>
							<bean:message key="faq.faq" />
						</b></font></td>
						<td>
							<html:text property="faq" />
							<html:errors property="faq" />
						</td>
					</tr>


					<tr>
						<td ><font color="#003366" size=""><b>
							<bean:message key="faq.answer" />
						</b></font></td>
						<td>
							<html:textarea property="answer" rows="4" cols="20" />
							<html:errors property="answer" />
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
								<bean:message key="faq.submit.value" />
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
