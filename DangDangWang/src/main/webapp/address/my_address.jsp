<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>收获地址管理 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			我的收货地址：
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址编号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人姓名</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人地址</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货人联系方式</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>收货地址状态</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>操作</b>
					</td>
				</tr>
				<!-- 收货地址开始 -->
				<c:forEach var="address" items="${addressList}" varStatus="aa">
					<tr>
						<td valign="top">
							${aa.count}
						</td>
						<td valign="top">
							${address.id}
						</td>
						<td valign="top">
							${address.recvName}
						</td>
						<td valign="top">
							${address.adrs}
						</td>
						<td valign="top">
								${address.mobile}
						</td>
						<c:if test="${address.seleState == 0}">
							<td valign="top">
								<a href="${pageContext.request.contextPath}/address/updateSelState?address.id=${address.id}">设为默认地址</a>
							</td>
						</c:if>
						<c:if test="${address.seleState == 1}">
							<td valign="top">
								默认收货地址
							</td>
						</c:if>
						<td valign="top">
							<a  href="${pageContext.request.contextPath}/address/updateDelState?address.id=${address.id}">删除</a>
						</td>
					</tr>
				</c:forEach>


				<!--收货地址结束 -->
			</table>
			
			<div style="margin: 50px;text-align: center;">
				<a href="${pageContext.request.contextPath}/address/add_address.jsp">添加新的收货地址</a>
				<a href="${pageContext.request.contextPath}/main/main.jsp">
					<input 	class="button_1"  type="button" value="取消" />
				</a>  
	    	</div>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html> 
