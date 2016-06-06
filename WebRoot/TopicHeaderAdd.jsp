<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>
			<hr />
			<center>
				<b><font color="skyblue" size="5"> <bean:message
							key="galery.header" /> </font> </b>
				<hr />
				</br>
				<html:form action="/topicheaderupload" method="post"
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
							<td>
								<b>Topic Head : </b>
							</td>
							<td>
								<html:text property="topicName"></html:text>
								<html:errors property="topicName" />
							</td>
						</tr>
						<tr>
							<td align='center' colspan='2'>
								<b><font color=red><h3>
											Only Image Files
										</h3>
								</b>
							</td>
						</tr>
						<tr>
							<td>
								<b><bean:message key="upload.label" /> </b>
							</td>
							<td>
								<html:file property="topicImage"></html:file>
								<html:errors property="topicImage" />
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
