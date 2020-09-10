<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(${pageContext.request.contextPath}/images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
				
			</h1>
			<span><font color="#cccccc">丛书名：${book.book_name}</font></span>
			<hr />
			<div>
				<div style="float: left;width:20%;">
					<img src="${pageContext.request.contextPath}/productImages/${book.product_image}"  border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：${book.author}</li>
						<li>出版社：</li>
						<li style="float:left;width:50%;">出版时间：</li>
						<li style="float:left;width:50%;">字数：</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">版次：</li>
						<li style="float:left;width:50%;">页数：</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印刷时间：</li>
						<li style="float:left;width:50%;">开本：	</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">印次：</li>
						<li style="float:left;width:50%;">纸张：</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">ISBN：</li>
						<li style="float:left;width:50%;">包装：</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='${pageContext.request.contextPath}/main'>当当图书</a> &gt;&gt;
								<font style='color: #cc3300'> 
									<strong>
										${book.parent_category_name}
									</strong>
								</font>
								&gt;&gt;
								<font style='color: #cc3300'>
									<strong>
										${book.category_name}
									</strong>
								</font>
							</div>
						</li>
						<li>定价：￥&nbsp;&nbsp;${book.book_price}
							当当价：￥&nbsp;&nbsp; ${book.dangprice}节省：￥${book.book_price - book.dangprice}</li>
						<li><a href="javascript:void(0)" id="goumai" onclick="goumai()"> <img
								src='${pageContext.request.contextPath}/images/buttom_goumai.gif' class="abc" id="buy"
								<%--onclick="addCart(20)" --%>
                        />
						</a></li>
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		<%--function goumai() {--%>
			<%--$("#buy20").prop("src","${pageContext.request.contextPath}/cart/addCart?book_id=${book.book_id}&a="+Math.random())--%>
		<%--}--%>
        /* 购买时，点击添加进入订单项 传入一个bookid */
        function goumai() {
            //转圈
            $("#buy").prop("src","${pageContext.request.contextPath}/images/load.gif");
            //ajax请求
			$.ajax({
				type:"post",
				data:"book_id=${book.book_id}",
				url:"${pageContext.request.contextPath}/cart/addCart",
				success:function(data) {
				    console.log(data)
					if (data == "1") {
                        $("#buy").prop("src","${pageContext.request.contextPath}/images/label3.gif");
                        setTimeout(function () {
                            $("#buy").prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
                        },1000)

                    }else {
					    alert("添加失败！！！")
                        $("#buy").prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
                    }
                }
			})
			//添加成功 出现对勾图片  失败---》弹窗提示

            <%--$("#buy").prop("src","${pageContext.request.contextPath}/cart/addCart?book_id=${book.book_id}&date="+Math.random())--%>
            <%--setTimeout("t1()",10);--%>
            <%--setTimeout("t2()",1000);--%>
            <%--setTimeout("t3()",1500);--%>
        }
        /*0秒   从点击购买小图标               1秒  到反应小图标      1.5秒 到购买成功的对勾小图标*/
        function t1() {
            $("#buy").prop("src","${pageContext.request.contextPath}/images/load.gif");
        }
        function t2() {
            $("#buy").prop("src","${pageContext.request.contextPath}/images/label3.gif");
        }
        function t3() {
            $("#buy").prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
        }
	</script>
</body>
</html>