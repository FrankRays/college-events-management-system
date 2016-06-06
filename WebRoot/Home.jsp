<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<body bgcolor="white">
		<center>
			<table  width="100%" height="100%">
				<tr>
					<td colspan="3" width="100%">
						<tiles:insert attribute="header">
						</tiles:insert>
					</td>
				</tr>
				<tr>
					<td colspan="3" width="100%">
						<tiles:insert attribute="menu">
						</tiles:insert>
					</td>
				</tr>


				<tr>
					<td width="15%">
						<tiles:insert attribute="right">
						</tiles:insert>
					</td>

					<td width="70%">
						<tiles:insert attribute="body">
						</tiles:insert>
					</td>
					<td width="15%">
						<tiles:insert attribute="left">
						</tiles:insert>
					</td>
				</tr>


				<tr>
					<td colspan="3" width="100%">
						<tiles:insert attribute="footer">
						</tiles:insert>
					</td>
				</tr>

			</table>
		</center>
	</body>
</html>
