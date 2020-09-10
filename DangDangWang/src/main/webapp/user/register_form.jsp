<%@page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/user/register" id="f" onsubmit="return checkForm()">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail" class="text_input" onblur="checkEmail()"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="emailinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" onblur="checkNick()"/>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" onblur="checkPwd()"/>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input" onblur="checkRePwd()"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/user/createCode" />
							<input name="code" type="text" id="txtVerifyCode"
								class="yzm_input" onblur="checkCode()"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									<span id="number.info" style="color:red"></span>
									<a onclick="changeImg()" href="javascript:void(0)" >看不清楚？换个图片</a>
								</p>
							</div>
							<span id="codeinfo" style="color:red"></span>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
			//
			function changeImg() {
			    var a = 0;
				$("#imgVcode").prop("src","${pageContext.request.contextPath}/user/createCode?a="+Math.random())
            }
            //邮箱格式
			function checkEmail() {
                var reg=/\w+@\w+\.\w+/;
				var email = $("[name = 'user.email']").val();
				if (!reg.test(email)){
				    $("#emailinfo").html("请输入正确的邮箱格式")
					return false;
				}else{
                    $("#emailinfo").html("")
				    return true;
				}
            }
            //昵称判断  长度4－20个字符，一个汉字为两个字符。
			function checkNick() {
                var nickname = $("[name = 'user.nickname']").val();
                if (nickname.length <= 4 || nickname.length >= 20 ){
                    $("#nameinfo").html("请按提示输入正确的昵称格式")
                    return false;
                }else{
                    $("#nameinfo").html("")
                    return true;
                }
            }
            //密码   长度6－20位。
			function checkPwd() {
                var pwd = $("[name = 'user.password']").val();
                if (pwd.length < 6 || pwd.length >= 20 ){
                    $("#passwordinfo").html("请按提示输入正确的密码格式")
                    return false;
                }else{
                    $("#passwordinfo").html("")
                    return true;
                }
            }
            //两次密码判断
			function checkRePwd() {
                var pwd = $("[name = 'user.password']").val();
                var pwd1 = $("[name = 'password1']").val();
                if (pwd != pwd1){
                    $("#password1info").html("两次输入密码不一致")
                    return false;
                }else{
                    $("#password1info").html("")
                    return true;
                }
            }
			//检查验证码
			function checkCode() {
                var code = $("[name = code]").val();
                if (code == ""){
                    $("#codeinfo").html("验证码不能为空")
                    return false;
                }else{
                    $("#codeinfo").html("")
                    return true;
                }
            }
            //注册提交
			function checkForm() {
				var r = checkEmail()&checkNick()&checkPwd()&checkRePwd()&checkCode()
				if (r == 0){
				    return false;
				}
            }
		</script>
	</body>

</html>

