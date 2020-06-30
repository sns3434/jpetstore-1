<%@ include file="IncludeTop.jsp"%>

<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'><b>
       <font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
    </td>
  </tr>
</table>

<div align="center">
	<c:if test="${!cc.equals(\"auction\")}">
  <b><font size="4"><c:out value="${product.name}" /></font></b> </c:if>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Item ID</b></td>
      <td><b>Product ID</b></td>
      <td><b>Description</b></td>
      <td><b>List Price</b></td>
      <td>&nbsp;</td>
    </tr>
    <c:forEach var="item" items="${itemList.pageList}">
      <tr bgcolor="#FFFF88">
     
        <td><b> 
          <a href='<c:url value="/shop/viewItem.do">
          
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>
            
              <c:out value="${item.itemId}" />
              
          </a></b></td>
        <td><c:out value="${item.productId}" /></td>
        <td>
          <c:out value="${item.attribute1}" /> 
          <c:out value="${item.attribute2}" /> 
          <c:out value="${item.attribute3}" /> 
          <c:out value="${item.attribute4}" /> 
          <c:out value="${item.attribute5}" /> 
          <c:out value="${product.name}" />
        </td>
      
        <td><fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" /></td>
        <c:if test="${!cc.equals(\"auction\")}">
        <td>
          <a href='<c:url value="/shop/addItemToCart.do">
            <c:param name="workingItemId" value="${item.itemId}"/></c:url>'>
              <img border="0" src="../images/button_add_to_cart.gif" alt="" />
          </a></td>
         </c:if>
           <td>
      </td>
      </tr>
    </c:forEach>
    <tr>
      <td>
        <c:if test="${!itemList.firstPage}">
        	<a href='<c:url value="/shop/viewProduct2.do?productId=auction">
               <c:param name="page" value="previous"/></c:url>'>
               	<font color="white"><B>&lt;&lt; Prev</B></font></a> 
        </c:if> 
        <c:if test="${!itemList.lastPage}">
        	<a href='<c:url value="/shop/viewProduct2.do?productId=auction">
               <c:param name="page" value="next"/></c:url>'>
               	<font color="white"><B>Next &gt;&gt;</B></font></a> 
        </c:if> 
      </td>
    </tr>
  </table>
</div>

<%@ include file="IncludeBottom.jsp"%>