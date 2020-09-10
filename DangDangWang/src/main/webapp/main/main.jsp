<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div class="book_l_border1" id="__FenLeiLiuLan">
					<div class="book_sort_tushu">
						<h2>
							分类浏览
						</h2>
						<c:forEach var="categorie" items="${bookCategories}">
							<!--1级分类开始-->
							<div class="bg_old" onmouseover="this.className = 'bg_white';"
								 onmouseout="this.className = 'bg_old';">
								<h3>
									[<a href='${pageContext.request.contextPath}/category/book_list?parent_id=${categorie.category_id}'>${categorie.category_name}</a>]
								</h3>
								<ul class="ul_left_list">
									<c:forEach items="${categorie.bookCategories}" var="c">
										<!--2级分类开始-->
										<li>
											<a href='${pageContext.request.contextPath}/category/book_list?parent_id=${categorie.category_id}&category_id=${c.category_id}'>${c.category_name}</a>
										</li>
										<!--2级分类结束-->
									</c:forEach>
								</ul>
								<div class="empty_left">
								</div>
							</div>

							<div class="more2">
							</div>
							<!--1级分类结束-->
						</c:forEach>

				
				
						<div class="bg_old">
							<h3>
								&nbsp;
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
				<h2>
					编辑推荐
				</h2>
				<div id=__bianjituijian/danpin>
					<div class=second_c_02>
                        <!--编辑推荐开始-->
                        <c:forEach var="recomendBook" items="${recommendList}">
                            <div class=second_c_02_b1>
                                <div class=second_c_02_b1_1>
                                    <a href='${pageContext.request.contextPath}/book/selectDet?book_id=${recomendBook.book_id}' target='_blank'><img src="${pageContext.request.contextPath}/productImages/${recomendBook.product_image}" width=70 border=0 /> </a>
                                </div>
                                <div class=second_c_02_b1_2>
                                    <h3>
                                        <a href='${pageContext.request.contextPath}/book/selectDet?book_id=${recomendBook.book_id}' target='_blank' title='详情'>${recomendBook.book_name}</a>
                                    </h3>
                                    <h4>
                                        作者：${recomendBook.author}
                                        <br />
                                        出版社：×××&nbsp;&nbsp;&nbsp;&nbsp;出版时间：2006-7-1
                                    </h4>
                                    <h5>
                                        简介:${recomendBook.messages}
                                    </h5>
                                    <h6>
                                        定价：￥${recomendBook.book_price}&nbsp;&nbsp;当当价：￥${recomendBook.dangprice}
                                    </h6>
                                    <div class=line_xx></div>
                                </div>
                            </div>
                        </c:forEach>
					</div>
				</div>
				</div>
				<!--推荐图书结束-->
				<div class="book_c_border2" id="hot">
					<h2>
						<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
					</h2>
					<div class="book_c_04">

				<!--热销图书开始-->
				<c:forEach items="${hotSaleList}" var="hotBook">

							<!--热销图书A开始-->
							<div class="second_d_wai">
								<div class="img">
									<a href="${pageContext.request.contextPath}/book/selectDet?book_id=${hotBook.book_id}" target='_blank'><img
											src="${pageContext.request.contextPath}/productImages/${hotBook.product_image}" border=0 /> </a>
								</div>
								<div class="shuming">
									<a href="${pageContext.request.contextPath}/book/selectDet?book_id=${hotBook.book_id}" target="_blank">${hotBook.book_name}</a><a href="#" target="_blank"></a>
								</div>
								<div class="price">
									定价：￥${hotBook.book_price}
								</div>
								<div class="price">
									当当价：￥${hotBook.dangprice}
								</div>
							</div>
							<div class="book_c_xy_long"></div>
							<!--热销图书A结束-->


				</c:forEach>
			</div>
			<div class="clear"></div>
		</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<h2>
						<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
					</h2>
					<div class="book_c_04">
						<!--热销图书A开始-->
					<c:forEach var="newBook" items="${newList}">
						<div class="second_d_wai">
							<div class="img">
								<a href="${pageContext.request.contextPath}/book/selectDet?book_id=${newBook.book_id}" target='_blank'><img
										src="${pageContext.request.contextPath}/productImages/${newBook.product_image}" border=0 /> </a>
							</div>
							<div class="shuming">
								<a href="${pageContext.request.contextPath}/book/selectDet?book_id=${newBook.book_id}" target="_blank">${newBook.book_name}</a><a href="#" target="_blank"></a>
							</div>
							<div class="price">
								定价：￥${newBook.book_price}
							</div>
							<div class="price">
								当当价：￥${newBook.dangprice}
							</div>
						</div>
						<div class="book_c_xy_long"></div>
					</c:forEach>
						<!--热销图书A结束-->


					
					</div>
					<div class="clear"></div>
				
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<h2 class="t_xsrm">
							新书热卖榜
						</h2>
						<div id="NewProduct_1_o_t" onmouseover="">
							<ul>
								<c:forEach items="${hotAndNewList}" var="hnBook">
									<li><a href="${pageContext.request.contextPath}/book/selectDet?book_id=${hnBook.book_id}" target='_blank'>${hnBook.book_name}</a></li>
								</c:forEach>
							</ul>
							<h3 class="second">
								<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
