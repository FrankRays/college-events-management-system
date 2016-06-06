<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body bgcolor="#F5FFFA">
		<center>
			<h3>
				<bean:message key="placement.header" />
			</h3>
			<hr />
			<hr />
			<html:form action="/updateplacementsbyidaction.do" method="post">
				<table>
					<tr>
						<td>
							<bean:message key="placement.CompanyName" />
						</td>
						<td>
							<html:text property="placementCompanyName"
								value='${PlacementInformationBean.placementCompanyName  }' />
							<html:errors property="placementCompanyName" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="placement.Description" />
						</td>
						<td>
							<html:textarea property="placementDescription" rows="4" cols="20"
								value='${PlacementInformationBean.placementDescription}' />
							<html:errors property="placementDescription" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="placement.date" />
						</td>
						<td>
							<html:text property="placementDate"
								value='${PlacementInformationBean.placementDate }' />
							<html:errors property="placementDate" />
						</td>
					</tr>
					<tr>
						<td>
							<bean:message key="placement.url" />
						</td>
						<td>
							<html:text property="placementUrl"
								value='${PlacementInformationBean.placementUrl }' />
							<html:errors property="placementUrl" />
							<html:hidden property="placementInfoId"
								value='${PlacementInformationBean.placementInfoId }' />

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
