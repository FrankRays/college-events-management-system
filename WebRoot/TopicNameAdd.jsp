<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>


			<h3>
				<bean:message key="coaching.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/addtopicnameaction.do" method="post">
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
						<td><!--
							<bean:message key="coaching.studyid" />
						-->TOPIC HEADER NAME :</td>
						<td>
							<html:select property="topicheaderid">
								<c:forEach var="data" items="${vTopicHeaderBeans}">
									<html:option value="${data.topicheaderid}">
										${data.topicheadername}
									</html:option>
								</c:forEach>
							</html:select>
							<html:errors property="topicheaderid" />
						</td>
					</tr>


					<tr>
						<td><!--
							<bean:message key="coaching.coachingname" />
						-->TOPIC NAME :</td>
						<td>
							<html:text property="topicName" />
							<html:errors property="topicName" />
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
