<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/main'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${parent_name}</strong> </font>
			<c:if test="${category_name != null}">
				&gt;&gt;
				<font style='color: #cc3300'><strong>${category_name}</strong> </font>
			</c:if>

		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
								<li>
									<div>
										<div class=second_fenlei>
											&middot;全部&nbsp;(<span id="zongshuliang"></span>)
										</div>
									</div>
								</li>
								<div class="clear"></div>

								<!--2级分类开始-->
								<c:forEach var="ccategory" items="${bookCategories}">
									<li>
										<div>
											<div class=second_fenlei>
												&middot;
											</div>
											<div class=second_fenlei>
												<a href="${pageContext.request.contextPath}/category/book_list?parent_id=${parent_id}&category_id=${ccategory.category_id}">${ccategory.category_name}&nbsp;(<span class="shuliang">${ccategory.bookNum}</span>)</a>
											</div>
										</div>
									</li>
									<div class="clear"></div>
								</c:forEach>
								<!--2级分类结束-->

								<li>
									<div></div>
								</li>

						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<c:if test="${pi.pageNum > 1}">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
									   href="${pageContext.request.contextPath}/category/book_list?parent_id=${parent_id}&category_id=${category_id}&pageNum=${pi.pageNum-1}">
										<img src='${pageContext.request.contextPath}/images/page_up.gif' /> </a>
								</div>
							</c:if>
							<c:if test="${pi.pageNum == 1}">
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath}/images/page_up_gray.gif' />
								</div>
							</c:if>
							<div class='list_r_title_text3b'>
								第${pi.pageNum}页/共${pi.pages}页
							</div>
							<c:if test="${pi.pageNum < pi.pages}">
								<div class='list_r_title_text3a'>
									<a name=link_page_next
									   href="${pageContext.request.contextPath}/category/book_list?parent_id=${parent_id}&category_id=${category_id}&pageNum=${pi.pageNum+1}">
										<img src='${pageContext.request.contextPath}/images/page_down.gif' /> </a>
								</div>
							</c:if>
							<c:if test="${pi.pageNum == pi.pages}">
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath}/images/page_down_gray.gif' />
								</div>
							</c:if>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<c:forEach items="${pi.list}" var="book">
								<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='${pageContext.request.contextPath}/book/selectDet?book_id=${book.book_id}'>
								<img src="${pageContext.request.contextPath}/productImages/${book.product_image}" /> </a> </span>
									<h2>
										<a name="link_prd_name" href='${pageContext.request.contextPath}/book/selectDet?book_id=${book.book_id}'>${book.book_name}</a>
									</h2>
									<h3>
										顾客评分：100
									</h3>
									<h4 class="list_r_list_h4">
										作 者:
										<a href='#' name='作者'>${book.author}</a>
									</h4>
									<h4>
										出版社：
										<a href='#' name='出版社'>人民邮电出版社</a>
									</h4>
									<h4>
										出版时间：2009-01-01
									</h4>
									<h5>
										${book.messages}
									</h5>
									<div class="clear"></div>
									<h6>
										<span class="del">￥${book.book_price}</span>
										<span class="red">￥${book.dangprice}</span>
										节省：￥${book.book_price-book.dangprice}
									</h6>
									<span class="list_r_list_button">
							<a href="javascript:void(0)" onclick="addCart(${book.book_id})">
							<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' id="addCart${book.book_id}"/>
							</a>
							<span id="cartinfo"></span>
								</div>
								<div class="clear"></div>
						</c:forEach>

						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>



	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>

	<script type="text/javascript">
		var allsum = 0;
        $(".shuliang").each(function (i,obj) {
            allsum = allsum + parseInt($(obj).html())
        })
		$("#zongshuliang").html(allsum)

		function addCart(id) {
			$("#addCart"+id).prop("src","${pageContext.request.contextPath}/cart/addCart?book_id="+id+"&date="+Math.random())
			setTimeout(function () {
                $("#addCart"+id).prop("src","${pageContext.request.contextPath}/images/load.gif")
            },10)
            setTimeout(function () {
                $("#addCart"+id).prop("src","${pageContext.request.contextPath}/images/label3.gif")
            },1000)
            setTimeout(function () {
                $("#addCart"+id).prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif")
            },1500)
        }
	</script>
</html>
