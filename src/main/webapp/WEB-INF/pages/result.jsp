<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
     <h1><center> Result Page</center></h1>
<c:choose>
  <c:when test="${empList ne null}">
    <table border="1" >
       <tr> <th>EmpNo</th><th>EmpName</th><th>EmpJob</th><th>EmpSalary</th></tr>
        <c:forEach var="emp" items="${empList}">
          <tr>
             <td>${emp.empno}  </td>
             <td>${emp.ename}  </td>
             <td>${emp.job}  </td>
             <td>${emp.salary}  </td>
             </tr>
        </c:forEach>
    </table>
 </c:when>
 <c:otherwise>
     Records not Found
 </c:otherwise>
</c:choose>
<br>
<h3 style='color:red;text-align:center''><a href="home.htm">HOME</a></h3>


