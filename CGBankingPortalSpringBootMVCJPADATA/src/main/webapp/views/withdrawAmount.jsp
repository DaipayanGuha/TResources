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
  background-color: #4CAF50;
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
  background-color:#45a049;
  padding: 20px;
}
</style>
</head>
<body>
<div align="center"><font size="10"><b><i>Withdraw Amount</i></b></font></div>
<form name="withdrawAmount" action="withdraw" method="post" >
<table>
<tr>
<td>Account Number: </td>
<td> <input type="text" name="accountNumber"></td>
</tr>
<tr>
<td>Amount to be withdraw: </td>
<td> <input type="text" name="amount"></td>
</tr>
<tr>
<td>PIN Number: </td>
<td> <input type="text" name="pinNumber"></td>
</tr>
<tr>
<td> <input type="submit" value="Submit"></td>
</tr>
</table>
</form>
<br><div align="center"><a href="bankIndex.jsp">Home</a></div>
</body>
</html>