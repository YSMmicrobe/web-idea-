<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单</title>
		<link rel="stylesheet"href="${pageContext.request.contextPath}/css/dingdan.css"type="text/css">
	</head>
	<body>
		<table class="table-head table-mod">
			<tbody>
				<tr>
					<th width="331px">宝贝</th>
					<th>单价</th>
					<th>数量</th>
					<th>实付款</th>
					<th>交易状态</th>
				</tr>
			</tbody>
		</table>
		<c:forEach items="${orders}" var="order">
			<div class="dom">
				<label>
				<span class="time">
					<input type="checkbox"/>
					<span class="time"><fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd"/></span>
				</span>
					<span>
					<span>订单号</span>
					<span>:</span>
					<span>${order.id}</span>
				</span>
				</label>
			</div>
			<table class="tb">

					<c:forEach var="orderItem" items="${order.orderItemList}" varStatus="aaa">
					<tr>


						<td width="330px">
							<div style="display: block;">
								<img src="${pageContext.request.contextPath}/productImages/${orderItem.book.product_image}" style="float: left;"/><br>
								<p style="width: 230px; margin-left:10px; float: left;">
									<a href="javascript:void(0)"><span class="sp">${orderItem.book.book_name}</span></a>
								</p>
							</div>
						</td>
						<td width="238px" align="center">
							<div>
								<p>$${orderItem.book.dangprice}</p>
							</div>
						</td>
						<td width="238px" align="center">${orderItem.count}</td>
						<c:if test="${aaa.count == 1}">
							<td class="boder" rowspan="${fn:length(order.orderItemList)}">${order.goodPrice}</td>
							<td class="boder" width="239px" rowspan="${fn:length(order.orderItemList)}">
								<div>
									<p>
										<c:if test="${order.orderState == 0}"> 已付款 </c:if>
										<c:if test="${order.orderState == 1}">
											<a href="${pageContext.request.contextPath}/order/alipay.trade.page.pay.jsp?WIDout_trade_no=${order.id}&WIDtotal_amount=${order.goodPrice}&WIDsubject=${order.id}&WIDbody=${order.goodPrice}">去付款</a>
										</c:if>
									</p>
									<%--<p><a href="">订单详情</a></p>--%>
								</div>
							</td>
						</c:if>

					</c:forEach>

				</tr>
			</table>
		</c:forEach>
		<div style="margin: 50px;text-align: center;">
				<a href="javascript:history.go(-1);">
				<input 	class="button_1"  type="button" value="取消" /></a>  
	    </div>
	</body>
</html>