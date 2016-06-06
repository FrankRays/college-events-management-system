<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		
			
			
			
			
			
			<center>
	
			<hr />
	      <center>
	         <b><font color="skyblue" size="5">
				<bean:message key="news.header" />
			</font></b>
			<hr />
			
			<html:form action="/addnewsaction" method="post">
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
							<bean:message key="news.newsHeader" />
						</b></font></td>
						<td>
							<html:text property="newsHeader" size="50"/>
							<html:errors property="newsHeader" />
						</td>
					</tr>

<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
					<tr>
						<td ><font color="#003366" size=""><b>
							<bean:message key="news.newsDesc" />
						</b></font></td>
						<td>
							<html:textarea property="newsDesc" rows="8" cols="40" />
							<html:errors property="newsDesc" />
						</td>
					</tr>
                      <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
					
					<tr>
				<tr>
						<td colspan="2" align="center">
							&nbsp; &nbsp; &nbsp;&nbsp;
							<html:submit>
								<bean:message key="news.submit.value" />
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
