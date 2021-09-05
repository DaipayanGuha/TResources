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

tr{
align-self: center;
font-size: large;
font-family: cursive;
font-style: italic;}
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
<div align="center"><font size="10"><b><i>Account Details</i></b></font></div>
<form name="accountDetailsForm" action="accountDetails" method="post" >
<table>
<tr ><font color="black" size="10">Account Number:</font>
<td> <input type="text" name="accountNumber"></td>
</tr>
<tr>
<td> <input type="submit" value="Get Account Details"></td>
</tr>
</table>
</form>
</body>
</html>