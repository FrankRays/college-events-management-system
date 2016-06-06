<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#FAF0E6">
		<center>


			<h3>
				<bean:message key="events.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/updateeventbyidaction.do" method="post">
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
							<bean:message key="events.name" />
						</td>
						<td>
							<html:text property="eventName" value="${eventsBean.eventname}" />
							<html:errors property="eventName" />
						</td>
					</tr>


					<tr>
						<td>
							<bean:message key="events.desc" />
						</td>
						<td>
							<html:textarea property="eventDesc" rows="4" cols="20"
								value="${eventsBean.eventdesc}" />
							<html:errors property="eventDesc" />
						</td>
					</tr>


					<tr>
						<td>
							<bean:message key="events.EventOnCollege" />
						</td>
						<td>
							<html:text property="eventOnCollege"
								value="${eventsBean.eventoncollege}" />
							<html:errors property="eventOnCollege" />
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="events.EventOnAddresses" />
						</td>
						<td>
							<html:text property="eventonaddress"
								value="${eventsBean.eventonaddress}" />
							<html:errors property="eventOnAddresses" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="events.URL" />
						</td>
						<td>
							<html:text property="uRL" value="${eventsBean.url}" />
							<html:errors property="uRL" />
						</td>
					</tr>







					<tr>
						<td>
							<bean:message key="events.date" />

						</td>
						<td>
							<html:text property="eventDate" value="${eventsBean.eventdate}" />
							(dd-mmm-yyyy)
							<html:errors property="eventDate" />
						</td>
					</tr>




					<tr>
						<td>
							<bean:message key="events.time" />
						</td>
						<td>
							<html:text property="eventTime" value="${eventsBean.eventtime}" />
							(00:00 AM/PM)
							<html:errors property="eventTime" />
							<html:hidden property="eventid" value="${eventsBean.eventid}" />
						</td>
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
