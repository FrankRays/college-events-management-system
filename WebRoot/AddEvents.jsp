<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>


			<h3>
				<bean:message key="events.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/addEvents.do" method="post">
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
							<bean:message key="events.name" />
						</td>
						<td>
							<html:text property="eventName" />
							<html:errors property="eventName" />
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="events.desc" />
						</td>
						<td>
							<html:textarea property="eventDesc" rows="2" cols="20" />
							<html:errors property="eventDesc" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="events.EventOnCollege" />
						</td>
						<td>
							<html:textarea property="eventOnCollege" rows="2" cols="20" />
							<html:errors property="eventOnCollege" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="events.EventOnAddresses" />
						</td>
						<td>
							<html:textarea property="eventOnAddresses" rows="4" cols="20" />
							<html:errors property="eventOnAddresses" />
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="events.date" />
						</td>
						<td>
							<html:text property="eventDate" />
							<html:errors property="eventDate" />(dd-mmm-yyyy)
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="events.time" />
						</td>
						<td>
							<html:text property="eventTime" />
							<html:errors property="eventTime" />(00:00 AM/PM)
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="events.URL" />
						</td>
						<td>
							<html:text property="uRL" />
							<html:errors property="uRL" />
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
						<td colspan="2" align="center">
							&nbsp; &nbsp; &nbsp;&nbsp;
							<html:submit>
								<bean:message key="event.submit.value" />
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
