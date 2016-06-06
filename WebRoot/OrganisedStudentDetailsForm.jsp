<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#FAF0E6">
		<center>
			<hr />
			<center>
				<b><font color="skyblue" size="5"> <bean:message
							key="std.header" /> </font> </b>
				<hr />
				<html:form action="/organisedstudentregistraion.do" method="get">
					<table>




						<tr>
							<td>
								<font color="#003366" size=""><b> <bean:message
											key="events.name" /> </b> </font>
							</td>

							<td>
								<html:select property="studentOrgEventidref">
									<c:forEach var="data" items="${vEventsBeans}">
										<html:option value="${data.eventid}"> ${data.eventname}	</html:option>
									</c:forEach>
								</html:select>
								<html:errors property="studentOrgEventidref" />
							</td>
						</tr>
						<tr>
							<td>
								<font color="#003366" size=""><b> <bean:message
											key="branch.branchname" /> </b> </font>
							</td>
							<td>
								<html:select property="studentBranchidref">
									<c:forEach var="branch" items="${vBranchBeans}">
										<html:option value="${branch.branchid}"> ${branch.branchname}	</html:option>
									</c:forEach>
								</html:select>
								<html:errors property="studentBranchidref" />
							</td>
						</tr>
						<tr>
							<td>
								<font color="#003366" size=""><b> <bean:message
											key="branch.branchyear" /> </b> </font>
							</td>
							<td>
								<html:select property="branchyear">
									<html:option value="I">I</html:option>>
                                <html:option value="II">II</html:option>
									<html:option value="III">III</html:option>
									<html:option value="IV">IIII</html:option>
								</html:select>
								<html:errors property="branchyear" />
							</td>
						</tr>

						<tr>
							<td>
								<font color="#003366" size=""><b> <bean:message
											key="pts.studentname" /> </b> </font>
							</td>
							<td>
								<html:text property="studentName" />
								<html:errors property="studentName" />
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
									<bean:message key="pts.submit.value" />
								</html:submit>
								<html:reset>
									<bean:message key="register.reset.value" />
								</html:reset>


							</td>

						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>

						<c:if test="${requestScope.logindetailsBean != 'null'}">
							<tr>
								<td>
									<font color="#003366" size=""><b> USERID :</b> </font>

								</td>
								<td>
									<b> <font color="red" size="">${logindetailsBean.loginid}
									</font> </b>


								</td>
							</tr>
							<tr>

								<td>
									<font color="#003366" size=""><b> PASSWORD: </b> </font>

								</td>
								<td>
									<b><font color="red" size="">
											${logindetailsBean.password} </font> </b>


								</td>
							</tr>


						</c:if>

					</table>
				</html:form>
			</center>
	</body>
</html>
