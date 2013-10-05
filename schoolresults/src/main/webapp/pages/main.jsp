<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<h1>Struts 2 Hello World Example</h1>

	<h2>Pinces School District</h2>

	<s:if test="results.size() > 0">
		<table border="1px" cellpadding="8px">
			<tr>
				<th>School</th>
				<th>Y3</th>
				<th>Y5</th>
				<th>Y7</th>
				<th>Y9</th>
				<th>Raw Gain Y3 to Y5</th>
				<th>factored Gain Y3 to Y5</th>
				<th>GLG% Y3 to Y5</th>
				<th>Gain in Gain Y3 to Y5</th>
			</tr>
			<s:iterator value="results">
				<tr>
					<td><s:property value="school.schoolName" /></td>
					<td><s:property value="latestY3" /></td>
					<td><s:property value="latestY5" /></td>
					<td><s:property value="latestY7" /></td>
					<td><s:property value="latestY9" /></td>
					<td><s:property value="rawGainY3Y5" /></td>
					<td><s:property value="factoredGainY3Y5" /></td>
					<td><s:property value="glgY3Y5" /></td>
					<td><s:property value="latestGainInGainY3Y5" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>