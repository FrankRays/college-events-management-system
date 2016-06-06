<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<body bgcolor="#FAF0E6">
		<center>

			
			<h3>
				<bean:message key="news.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/addNews" method="post">
				<table>
					
					<tr>
						<td>
							<bean:message key="news.newsHeader" />
						</td>
						<td>
							<html:password property="newsHeader" />
						</td>
					</tr>


					<tr>
						<td>
							<bean:message key="news.newsDesc" />
						</td>
						<td>
							<html:textarea property="newsDesc" rows="4" cols="20" />
						</td>
					</tr>
                       <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
					
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
