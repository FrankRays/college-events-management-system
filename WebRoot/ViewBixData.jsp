
<%@page import="java.util.*"%><%@page
	import="com.buzz.bean.TopicnameBean"%>
<%@page import="java.util.Iterator"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int k = 0;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>

		<hr />
		<center>
			<b><font color="#003366" size="4"> Students Topics </font> </b>
			<hr />
			<table>
				<tr>
					<td>
						<%
							Map mMap = (HashMap) request.getAttribute("sortedMap");

							Iterator iter = mMap.entrySet().iterator();

							while (iter.hasNext()) {
								Map.Entry mEntry = (Map.Entry) iter.next();
						%>
						<table height="150" width="200">
							<tr>
								<td colspan='2' align='center'>
									<b><font color='red'><%=mEntry.getKey()%></font> </b>
								</td>
							</tr>
							<tr>

								<%
									Vector<TopicnameBean> vector = (Vector<TopicnameBean>) mEntry
												.getValue();
										Vector<TopicnameBean> vector1 = (Vector<TopicnameBean>) vector;
										String filepath = "";
										Iterator iterator = vector.iterator();
										Iterator iterator1 = vector1.iterator();
										while (iterator1.hasNext()) {
											TopicnameBean topicnameBean1 = (TopicnameBean) iterator1
													.next();
											filepath = topicnameBean1.getTopicfilepath();
										}
								%><td>
									<img src='<%=filepath%>' height='100' width='100'>
								</td>
								<td>
									<%
										int i = 0;

											while (iterator.hasNext()) {
												TopicnameBean topicnameBean = (TopicnameBean) iterator
														.next();
									%>

									<table>
										<tr>
											<td>
												<a
													href="./viewfiledataactionbyname.do?topicnameid=<%=topicnameBean.getTopicnameid()%>"
													style="text-decoration: none"><b><%=topicnameBean.getTopicname()%><b>
												</a>
											</td>
										</tr>
									</table>




									<%
										}
									%>
								</td>

							</tr>
						</table>
						<%
							k++;
								if (k == 2) {
									k = 0;
						%>
					</td>
				</tr>
				<tr>
					<td>
						<%
							} else {
						%>
					</td>
					<td>
						<%
							}
							}
						%>
					</td>
				</tr>
			</table>

		</center>


		<br>
		<br>
	</body>
</html>
