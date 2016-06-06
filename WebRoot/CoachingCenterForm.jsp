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
			<html:form action="/addcoachingcenteraction.do" method="post">
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
							<bean:message key="coaching.studyid" />
						</td>
						<td>
							<html:select property="studyid">
								<c:forEach var="data" items="${vStudyDetailsBeans}">
									<html:option value="${data.studyid}">
										${data.studyname}
									</html:option>
								</c:forEach>
							</html:select>
							<html:errors property="studyid" />
						</td>
					</tr>


					<tr>
						<td>
							<bean:message key="coaching.coachingname" />
						</td>
						<td>
							<html:text property="coachingcentername" />
							<html:errors property="coachingcentername" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="coaching.CoachingAddress" />
						</td>
						<td>

							<html:textarea property="coachingAddress" rows="3" cols="20" />
							<html:errors property="coachingAddress" />
						</td>
					</tr>

					<tr>
						<td>
							<bean:message key="coaching.CoachingContact" />
						</td>
						<td>
							<html:text property="coachingContact" />
							<html:errors property="coachingContact" />
						</td>
					</tr>


					<tr>
						<td>
							<bean:message key="coaching.CoachingDesc" />

						</td>
						<td>
							<html:textarea property="coachingDesc" rows="3" cols="20" />
							<html:errors property="coachingDesc" />
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
