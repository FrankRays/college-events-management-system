<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<title>Style 12 (Teal) - Menu by Apycom.com</title>
		<link type="text/css" href="menu/menu.css" rel="stylesheet" />
		<script type="text/javascript" src="menu/jquery.js">
</script>
		<script type="text/javascript" src="menu/menu.js">
</script>
	</head>
	<body>

		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

div#menu {
	margin-left: 10px;
	position: relative;
	top: 05px;
}

div#copyright {
	display: none;
}
</style>

		<div id="menu">
			<ul class="menu">
				<li>
					<a href="index.jsp" class="parent"><span>Home</span> </a>

				</li>
				<li>
					<a href="#" class="parent"><span>Branch</span> </a>
					<div>
						<ul>
							<li>
								<a href="viewBranchesAction.do"><span>ViewBranches</span> </a>
							</li>


						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Events</span> </a>
					<div>
						<ul>
							<li>
								<a href="vieweventaction.do"><span>ViewEvents</span> </a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>News</span> </a>
					<div>
						<ul>
							<li>
								<a href="viewnewsaction.do"><span>ViewNews</span> </a>
							</li>
						</ul>
					</div>
				</li>

				<li>
					<a href="#" class="parent"><span>Gallery</span> </a>
					<div>
						<ul>
							<li>
								<a href="viewgallery.do"><span>ViewGallery</span> </a>
							</li>

						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Bix</span> </a>
					<div>
						<ul>
							<li>
								<a href="./viewbixdataaction.do"><span>bix</span> </a>
							</li>

						</ul>
					</div>
				</li>
				<li class="last">
					<a href="./home.do"><span>Login</span> </a>
				</li>
				<li>
					<a href="#"><span></span> </a>
				</li>
				<li>
					<a href="#"><span></span> </a>
				</li>
				<li>
					<a href="#"><span></span> </a>
				</li>



			</ul>
		</div>
		<div id="copyright">
			<a href="http://apycom.com/"></a>
		</div>
	</body>
</html>