<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/address.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		 
	})
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 ><span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
		 <c:if test=""></c:if>
		 <form action="${pageContext.request.contextPath}/order/addOrder" method="post">
			 <div class="address-wrap">
				<ul class="address-list">
					<c:forEach var="address" items="${addressList}">
						<li
								<c:if test="${address.seleState == 1}">class="address-wrap selected" </c:if>
								<c:if test="${address.seleState != 1}">class="address-wrap" </c:if>
								id="address-wrap${address.id}" name="address-wrap">
							<div class="addressBox">
								<span class="marker-tip" name="marker-tip" id="marker-tip${address.id}">
									<c:if test="${address.seleState == 1}">寄送至 </c:if>
								<c:if test="${address.seleState != 1}"></c:if>
								</span>
							</div>
							<label class="addressInfo" onclick="selectAddress2(this)">
								<input type="radio" name="addrId" value="${address.id}" <c:if test="${address.seleState == 1}">checked="checked"</c:if> onclick="selectAddress(${address.id})"/>
								<span class="user-address"
									  <%--onclick="selectAddress(${address.id})"--%>
								>
									<span >${address.adrs}</span>
									<span>文化路82号硅谷广场A座13A16(14层)百知教育</span>
									<span>（</span>
									<span>${address.recvName}</span>
									<span> 收）</span>
									<em>${address.mobile}</em>
								</span>
							</label>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="login_in">
				<input
					id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="下一步" />
			</div>
			
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
        // 寄送至
		// selected
		// function selectAddress(id) {
		// 	$("[name=address-wrap]").each(function () {
		// 		$(this).prop("class","address-wrap")
        //     })
        //     $("[name=marker-tip]").each(function () {
        //         $(this).html("")
        //     })
		// 	$("#address-wrap"+id).prop("class","address-wrap selected")
		// 	$("#marker-tip"+id).html("寄送至")
        // }
        function selectAddress2(obj) {
            //
            $(obj).parent().prepend($("div.addressBox"))
			//
			$("li").removeClass("selected")
			$(obj).parent().addClass("selected")
        }
	</script>
</body>
</html>

