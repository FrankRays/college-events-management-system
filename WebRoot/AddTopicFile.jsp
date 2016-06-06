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
			<html:form action="/addtopicfileaction.do" method="post"
				enctype="multipart/form-data">
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
						--> <b>TOPIC HEADER NAME :</b> </td>
						<td>
							<html:select property="topicnameid">
								<c:forEach var="data" items="${vTopicNameBeans}">
									<html:option value="${data.topicnameid}">
										${data.topicname}
									</html:option>
								</c:forEach>
							</html:select>
							<html:errors property="topicnameid" />
						</td>
					</tr>


					<tr>
						<td>
							<b><!--<bean:message key="upload.label" /> </b>--> TOPIC FILE NAME :</b>
						</td>
						<td>
							<html:text property="topicfilename"></html:text>
							<html:errors property="topicfilename" />
						</td>
					</tr>






					<tr>
						<td>
							<b><!--<bean:message key="upload.label" /> </b>--> UPLOAD FILE :
						</td>
						<td>
							<html:file property="fileData"></html:file>
							<html:errors property="fileData" />
						</td>
					</tr>
					<tr>
						<td align='center' colspan='2'>
							<b><font color=red><h3>
										Any type of Files
									</h3>
							</b>
						</td>
					</tr>


					<tr>

						<td colspan="2" align="center">
							&nbsp; &nbsp; &nbsp;&nbsp;
							<html:submit>
								<bean:message key="upload.submit" />
							</html:submit>
						</td>
					</tr>
				</table>
			</html:form>
		</center>
	</body>
</html>
