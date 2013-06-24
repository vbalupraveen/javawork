<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
</head>

<body>
	<h1>Struts 2 Subset tag example</h1>
	<table border="1">
		<tr valign="top">
			<td>1. Display all numbers.
				<ol>
					<s:subset source="numbers">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:subset>
				</ol>
			</td>

			<td>2. Display all numbers in sorted order.
				<ol>
					<s:bean var="numberComparator"
						name="com.ulab.st.action.NumberComparator" />
					<s:sort source="numbers" comparator="numberComparator">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:sort>
				</ol>
			</td>

			<td>3. Display numbers , from #2 to #6
				<ol>
					<s:subset source="numbers" start="1" count="5">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:subset>
				</ol>
			</td>

			<td>4. Display numbers 5 only, with decider
				<ol>
					<!-- takes "numberDecider" from "getNumberDecider()" in Action -->
					<s:subset source="numbers" decider="numberDecider">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:subset>
				</ol>
			</td>
			<td>5. Merge <!-- merges between -->
				<ol>
					<s:merge id="allData">
						<s:param value="numbers" />
						<s:param value="values" />
					</s:merge>
					<s:subset source="allData">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:subset>
				</ol>
			</td>
			<td>6. Append <!-- appends at the end -->
				<ol>
					<s:append id="allData">
						<s:param value="numbers" />
						<s:param value="values" />
					</s:append>
					<s:subset source="allData">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:subset>
				</ol>
			</td>
			<td>7. Generator
				<ol>
					<s:generator val="%{'1,2,3,4,5'}" separator=",">
						<s:iterator>
							<li><s:property /></li>
						</s:iterator>
					</s:generator>
				</ol>
			</td>
		</tr>
	</table>
	-------------------------------<br/>
	Included "/book" action result: <br/>
	-------------------------------<br/>
	<s:action name="book" executeResult="true"></s:action>
</body>
</html>