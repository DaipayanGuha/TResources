<!DOCTYPE html>
<html>
<head>
<style>
a {
	color: #656565;
	text-decoration: none;
	font-size: x-large;
	color: navy;
}

h1 {
	color: purple;
}

a:hover {
	color: #abda0f;
	text-decoration: none;
}

body {
	background-image: url("123.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body bgcolor="dodgerblue">
	<div align="center" class=".content">
		<marquee>
			<h1>
				<font color="maroon" size=10><i><b>CG Banking System</b></i></font>
			</h1>
		</marquee>
		<h1>Select a suitable option</h1>
		<table>
			<tr>
				<td><a href="createAccount.jsp">1. Create a account</a></td>
			</tr>
			<tr>
				<td><a href="getAccountDetails.jsp">2. Get your account
						details</a></td>
			</tr>
			<tr>
				<td><a href="allAccountDetails.jsp">3. Get all account
						details</a></td>
			</tr>
			<tr>
				<td><a href="depositeAmount.jsp">4. Deposit Amount</a></td>
			</tr>
			<tr>
				<td><a href="withdrawAmount.jsp">5. Withdraw Amount</a></td>
			</tr>
			<tr>
				<td><a href="fundTransfer.jsp">6. Fund Transfer</a></td>
			</tr>
			<tr>
				<td><a href="transactions.jsp">7. Transactions</a></td>
			</tr>
		</table>
	</div>
</body>
</html>