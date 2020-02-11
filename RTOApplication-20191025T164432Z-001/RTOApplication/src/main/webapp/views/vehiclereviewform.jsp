<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  
      <h1 style = "text-align: center;"> Your Application Detail</h1>

      <table align = "center">
       <tr>
       <td>your first name : </td>
       <td>${vehicleReview.firstName}</td>
       </tr>
       
       <tr>
       <td>your last name : </td>
       <td>${vehicleReview.lastName}</td>
       </tr>
       
       <tr>
       <td>Gender: </td>
       <td>${vehicleReview.gender}</td>
       </tr>
       
       <tr>
       <td>Email Id </td>
       <td>${vehicleReview.email}</td>
       </tr>
       
        <tr>
       <td>SSNO </td>
       <td>${vehicleReview.ssno}</td>
       </tr>
       
       
        <tr>
       <td>Hno </td>
       <td>${vehicleReview.hno}</td>
       </tr>
       
       <tr>
       <td>city </td>
       <td>${vehicleReview.city}</td>
       </tr>
       
       <tr>
       <td>zipcode </td>
       <td>${vehicleReview.zipcode}</td>
       </tr>
       
       <tr>
       <td>Registration Number </td>
       <td>${vehicleReview.registrationNo}</td>
       </tr>
       
       <tr>
       <td>Created Date </td>
       <td>${vehicleReview.createDate}</td>
       </tr>
       
       
        <tr>
       <td>Updated Date </td>
       <td>${vehicleReview.updateDate}</td>
       </tr>
       
       
      
      </table>
  
  
</body>
</html>