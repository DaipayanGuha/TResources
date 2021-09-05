<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
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
<div>
<font color='green' size='5'>All Account Details are:-</font><br> 	

<s:forEach var="comm" items="${requestScope.allAccount}">
		${comm }<br>
</s:forEach>
</div>
<br><div align="center"><a href="bankIndex.jsp">Home</a></div>
</body>
</html>

		 
		 

