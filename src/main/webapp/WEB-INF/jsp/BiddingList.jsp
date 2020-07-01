<%@ include file="IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<div align="center">
  <p>
    <font size="4"><b>Bidding List</b></font>
  </p>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Item ID</b></td> 
      <td><b>Auction ID</b></td> 
      <td><b>Bidding Date</b></td> 
      <td><b>Bidding Price</b></td> 
      <td><b>Progress</b></td> 
    </tr>
    <c:forEach var="bid" items="${BiddingList}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><a href='<c:url value="/shop/viewItem.do">
              <c:param name="itemId" value="${bid.itemId}"/></c:url>'>
              <font color="black"><c:out value="${bid.itemId}" /></font>
            </a></b></td>
       <td>
          <b><c:out value="${bid.auctionId}"/>
            </b></td>
         <td><fmt:formatDate value="${bid.biddingDate}" 
            pattern="yyyy/MM/dd" /></td>
         <td><fmt:formatNumber value="${bid.biddingPrice}"
            pattern="$#,##0.00" /></td>
        
        <c:if test="${bid.isSuccessful == 1}">
        <td>       
          <b><a href='<c:url value="/shop/checkout2.do?auctionId=auctionId">
        	<c:param name="auctionId" value="${bid.auctionId}"/></c:url>'>
        	낙찰
        	<%-- <script>
			var result = confirm("낙찰 결제하시겠습니까?");
	
			if(result)
				alert("낙찰 결제 완료되었습니다.");		

			</script>
			<jsp:forward page = "/BiddingList.jsp"/>; --%>
        	</a></b></td>
        </c:if> 
        
        <c:if test="${bid.isSuccessful == 0}">
        <c:if test="${bid.timeStatus.equals(\"OPEN\")}">
        <td>진행중</td>
        </c:if> 
        </c:if>
        
        <c:if test="${bid.isSuccessful == 0}">
        <c:if test="${bid.timeStatus.equals(\"CLOSE\")}">
        <td>환불</td> <!-- 환불하시겠습니까? 폼 만들기 -->
        </c:if> 
        </c:if>     
        
      </tr>
    </c:forEach>
  </table>
</div>

<%@ include file="IncludeBottom.jsp"%>
