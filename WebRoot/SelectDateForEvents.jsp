

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>


		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>

		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/adi.js">
</script>
		<script type="text/javascript" src="scripts/form_validation.js">
</script>
		<script language="JavaScript" src="scripts/javascripts.js">
</script>
		<script language="JavaScript" src="scripts/pop-closeup.js">
</script>




		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
		<body>

			<form action="./ViewDateEvents.do" method="post" name='eventdateform'>

				<center>
					<table>
						<tr>
							<td align='center' colspan=2>
								<h2>
									Select Date On Events
								</h2>
							</td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td>

								Event Date :

							</td>
							<td>
								<input type="text" name="eventdate" value="" size="20"
									readonly="readonly" />
								<a
									href="javascript:show_calendar('document.eventdateform.eventdate', document.eventdateform.eventdate.value);">
									<img src="images/cal.gif" alt="a" width="18" height="18"
										border="0" /> </a>
							</td>

						</tr>
						<tr>
							<td colspan='2' align='center'>
								<input type='submit' value='submit'>
							</td>
						</tr>
					</table>
				</center>
			</form>
			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("eventdateform");

frmvalidator.addValidation("eventdate", "req", "Please Select EventDate");
</script>

		</body>
</html>
