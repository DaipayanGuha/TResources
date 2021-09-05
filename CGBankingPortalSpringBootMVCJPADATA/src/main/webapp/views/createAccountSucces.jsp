<!DOCTYPE html>
<html>
<head>
<style>
body{
background-color: #D0D3D4 ;}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
td{
font-size: medium;
font-family: fantasy;
}

input[type=submit] {
  width: 100%;
  background-color: #070807;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: medium;
  font-family: inherit;
}

input[type=submit]:hover {
  background-color: #45a049;
}
a{
font-family: sans-serif;
font-size: medium;}
div {
  border-radius: 5px;
  background-color:#7F8C8D;
  padding: 20px;
}
</style>
</head>
<body>
<div>
<table>
<tr><th>Account Number</th>
	<th>Pin Number</th>
	<th>Account Type</th>
	<th>Account Status</th>
	<th>Account Balance</th>
</tr>
<tr><td>${requestScope.account.accountNo}</td>
	<td> ${requestScope.account.pinNumber}</td>
	<td>${requestScope.account.accountType}</td>
	<td>${requestScope.account.accountStatus}</td>
	<td>${requestScope.account.accountBalance}</td>
</tr>
</table>
</div>				  
<br><div align="center"><a href="bankIndex.jsp">Home</a></div>

</body>
</html>
