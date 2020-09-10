<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${pageContext.request.contextPath}/images/pic_myshopping.gif" />

		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>封面</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
                      <!-- 购物列表开始 -->
					<c:forEach var="buyBook" items="${cart.buyBooks}">
						<tr class='td_no_bord'>
							<td class="buy_td_6">
								<span ><img src="${pageContext.request.contextPath}/productImages/${buyBook.value.book.product_image}" height="50px" width="58px"/> </span>
							</td>
							<td>
								<span class="span_w1"><a href="${pageContext.request.contextPath}/book/selectDet?book_id=${buyBook.key}">${buyBook.value.book.book_name}</a></span>

							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥${buyBook.value.book.book_price}</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${buyBook.value.book.dangprice}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${buyBook.value.bookNum}
							</td>
							<td>
								<input class="del_num" id="change${buyBook.key}" type="text" size="3" maxlength="4"/>
								<a href="javascript:void(0)" onclick="changeNum(${buyBook.key})">变更</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart/changeSta?book_id=${buyBook.key}&status=1" onclick="removeBook()">删除</a>
							</td>
						</tr>
					</c:forEach>
					<!-- 购物列表结束 -->
				</table>
				<div id="div_no_choice" class="objhide">
					<div class="choice_title"></div>
					<div class="no_select">
						您还没有挑选商品
					</div>
				</div>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='${pageContext.request.contextPath}/main'> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${cart.saveprice}</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${cart.totalprice}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='javascript:void(0)' onclick="toOrder(this)">
								<img src="${pageContext.request.contextPath}/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 用户删除恢复区 -->


		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<tbody>

			<c:forEach var="nobuybook" items="${cart.noBuyBooks}">
				<tr>
					<td width="58" class=buy_td_6>
						<span><img src="${pageContext.request.contextPath}/productImages/${nobuybook.value.book.product_image}" height="50px" width="58px"/></span>
					</td>
					<td width="365" class=t2>
						<a href="#">${nobuybook.value.book.book_name}</a>
					</td>
					<td width="106" class=buy_td_5>
						￥${nobuybook.value.book.book_price}
					</td>
					<td width="134" class=buy_td_4>
						<span>￥${nobuybook.value.book.dangprice}</span>
					</td>
					<td width="56" class=buy_td_1>
						<a href="${pageContext.request.contextPath}/cart/changeSta?book_id=${nobuybook.key}&status=0">恢复</a>
					</td>
					<td width="16" class=objhide>
						&nbsp;
					</td>
				</tr>
			</c:forEach>




					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>


				</tbody>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
			function changeNum(obj) {
				var num = $("#change"+obj).val();
				console.log(num)
				if (!/^[1-9]\d*$/.test(num)){
					alert("请输入正确的数字");
				}else{
                    location="${pageContext.request.contextPath}/cart/changeNum?book_id="+obj+"&status="+num;
				}
            }
            function toOrder(obj) {
			    if (${cart.buyBooks.size()} != 0) {
                    $(obj).prop("href","${pageContext.request.contextPath}/order/order_info.jsp")
                }
            }
		</script>
	</body>
</html>



