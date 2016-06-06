<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'RightPage.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<center>
			<table>
				<tr>
					<td width="100" align="center">
						<marquee behavior="scroll" direction="down" scrollamount="4">
							<img src="./eventimages/images.jpeg" align="top" height="150"
								width="170">

							<br>

							<img src="./eventimages/images2.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images3.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images4.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images5.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images6.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images8.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images9.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images10.jpeg" align="top" height="150"
								width="170">
							<br>

							<img src="./eventimages/images11.jpeg" align="top" height="150"
								width="170">

							<br>

						</marquee>
					</td>
				</tr>
			</table>
		</center>
		<br>
	</body>
</html>
