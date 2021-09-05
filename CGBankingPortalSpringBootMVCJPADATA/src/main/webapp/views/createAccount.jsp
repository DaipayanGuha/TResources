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
<div align="center"><font size="20" style="italic">Create Account</font></div>
<form name="createAccountForm" action="create" method="post" >

<table >
<tr>
<td>Type of Account(Savings/Current): </td>
<td> <input type="text" name="accountType"></td>
</tr>
<tr>
<td>Initial Balance: </td>
<td> <input type="text" name="initialBalance"></td>
</tr>
<tr>
<td> <input type="submit" value="Submit"></td>
</tr>
</table>
</form>
</div>
</body>
</html>