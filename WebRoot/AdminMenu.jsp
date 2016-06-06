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
					<a href="#" class="parent"><span>Branch</span> </a>
					<div>
						<ul>
							<li>
								<a href="./branch.do"><span>AddBranch</span> </a>
							</li>


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
								<a href="./event.do"><span>AddEvents</span> </a>

							</li>

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
								<a href="news.do"><span>AddNews</span> </a>
							</li>

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
								<a href="gallery.do"><span>AddGalleryInfo</span> </a>
							</li>

							<li>
								<a href="viewgallery.do"><span>ViewGallery</span> </a>
							</li>

						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Student</span> </a>
					<div>
						<ul>
							<li>
								<a href="viewparbranchlist.do"><span>Registration</span> </a>
							</li>
							<li>
								<a href="viewstudents.do"><span>ViewStudent</span> </a>
							</li>



						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Placements</span> </a>
					<div>
						<ul>
							<li>
								<a href="./placements.do"><span>AddPlacement</span> </a>
							</li>
							<li>
								<a href="./viewplacementsaction.do"><span>ViewPlacement</span>
								</a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Study</span> </a>
					<div>
						<ul>
							<li>
								<a href="./study.do"><span>AddStudy</span> </a>
							</li>
							<li>
								<a href="./viewstudy.do"><span>ViewStudy</span> </a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>CoachingCenter</span> </a>
					<div>
						<ul>
							<li>
								<a href="./addcoachingcenterviewstudy.do"><span>AddCoachingCetners</span>
								</a>
							</li>
							<li>
								<a href="./viewcoachingcenteraction.do"><span>ViewCoachingCenters</span>
								</a>
							</li>
							<li>
								<a href="./viewbixdataaction.do"><span>bix</span> </a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Materials</span> </a>
					<div>
						<ul>
							<li>
								<a href="./topicheadadd.do"><span>AddTopicHead</span> </a>
							</li>
							<li>
								<a href="./viewtopicheaderaction.do"><span>viewTopicHead</span>
								</a>
							</li>
							<li>
								<a href="./addtopicnameviewtopicheaderlist.do"><span>AddTopicName</span>
								</a>
							</li>
							<li>
								<a href="./viewtopicnameaction.do"><span>viewTopicName</span>
								</a>
							</li>
							<li>
								<a href="./addtopicfileviewtopicnamelist.do"><span>AddTopicFile</span>
								</a>
							</li>
							<li>
								<a href="./viewtopicfiles.do"><span>ViewTopicFiles</span> </a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#" class="parent"><span>Security</span> </a>
					<div>
						<ul>
							<li>
								<a href="./changepassword.do"><span>ChangePassword</span> </a>
							</li>

						</ul>
					</div>
				</li>
				<li class="last">
					<a href="./logoutaction.do"><span>Logout</span> </a>
				</li>



			</ul>
		</div>
		<div id="copyright">
			<a href="http://apycom.com/"></a>
		</div>
	</body>
</html>