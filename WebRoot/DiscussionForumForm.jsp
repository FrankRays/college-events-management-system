<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<body bgcolor="#FAF0E6">
		<center>


			<h3>
				<bean:message key="discussion.desc" />
			</h3>


			<form action="">
				<table>
					<logic:iterate id="data" name="vDiscussionforumBeans"
						type="com.cems.bean.DiscussionforumBean">
						<tr>
							<td align='center'>
								<!--
								<input type=checkbox name=forumid
									value='<bean:write name="data" property="forumid" />' />
								<a
									href="./viewnewsbyid.do?forumid=<bean:write name="data" property="forumid" />"><bean:write
										name="data" property="forumid" /> </a>
								-->
								Name :
								<bean:write name="data" property="logindetails.loginid" />
							</td>
							<td>
								Event :
								<bean:write name="data" property="events.eventname" />
							</td>
							<td>
								Date :
								<bean:write name="data" property="posteddate" />
							</td>

						</tr>
						<tr>
							<td colspan=3 align="center">
								<bean:write name="data" property="forumdesc" />
							</td>

						</tr>
					</logic:iterate>

				</table>
			</form>
			<html:form action="/addforum.do" method="post">
				<table>
					<tr>
						<td>
							<bean:message key="discussion.desc" />
						</td>
						<td>
							<html:textarea property="discussionDesc" rows="4" cols="20" />
							<html:errors property="discussionDesc" />
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
								<bean:message key="discussion.submit.value" />
							</html:submit>
							<html:reset>
								<bean:message key="discussion.reset.value" />
							</html:reset>


						</td>

					</tr>
				</table>
			</html:form>
		</center>


	</body>
</html>
