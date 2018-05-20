<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="${pageContext.request.contextPath }/css/orders.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath }/css/header.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath }/css/footer.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath }/css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>

<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page= "left.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="${pageContext.request.contextPath }/user/showPersonInfo.do">我的信息</a></span>
            <span class="rs_header_active"><a href="${pageContext.request.contextPath }/user/showPassword.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span>
                <input type="password" id = "oldPassword"/>
                <span class="change_hint" id = "oldPwdSpan"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span>
                <input type="password" id = "newPassword"/>
                <span class="change_hint" id = "newPwdSpan"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span>
                <input type="password" id="confirmPassword"/>
                <span class="confirm_hint" id = "confirmPwdSpan"></span>
            </div>
            <div class="save_password">
                保存更改
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="${pageContext.request.contextPath }/images/footer/icon1.png" alt="hello" />

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="${pageContext.request.contextPath }/images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="${pageContext.request.contextPath }/images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="${pageContext.request.contextPath }/images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="${pageContext.request.contextPath }/images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="${pageContext.request.contextPath }/images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="${pageContext.request.contextPath }/images/footer/wechat.png" alt=""/>
                    <img src="${pageContext.request.contextPath }/images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="${pageContext.request.contextPath }/images/footer/ios.png" class="lf">
            <img src="${pageContext.request.contextPath }/images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="${pageContext.request.contextPath }/images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/index.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/orders.js"></script>
<script type="text/javascript">
		//验证密码长度
		function checkPasswordLength(pwd){
			console.log(pwd)
			return pwd.length>=6 && pwd.length<=9;
		}
		//验证新密码和确认密码是否一致
		function checkPasswordEquals(){
			var confirmPassword = $("#confirmPassword").val();
			var newPassword = $("#newPassword").val();
			return confirmPassword == newPassword;
		};
		
		function regVal(dom,show,reg){
			dom.blur(function(){
				if(checkPasswordLength($(this).val())){
					/*如果有第三个参数 ，则要进行密码一致性检测 */
					if(reg){
						if(!checkPasswordEquals()){
							show.html("两次密码输入不正确").css("color","red");
							return false;
						}else{
							show.html("密码格式正确").css("color","green");
							return true;
						}
					}else{
						show.html("密码格式正确").css("color","green");
						return true;
					}
				}else{
					show.html("密码格式错误，长度6-9位").css("color","red");
					return false;
				}
			})
		}
		//添加表单输入长度验证
		regVal($("#oldPassword"),$("#oldPwdSpan"));
		regVal($("#newPassword"),$("#newPwdSpan"));
		regVal($("#confirmPwdSpan"),$("#confirmPwdSpan"),"两次密码一致性检测");
		
			$(".save_password").click(function(){
				
				if(	checkPasswordLength($("#oldPassword").val()) &&
						checkPasswordLength($("#newPassword").val()) &&
						checkPasswordLength($("#confirmPassword").val()) &&
						checkPasswordEquals()
						){
					$.ajax({
						url:"modifyPassword.do",
						data:{
							newPassword:$("#newPassword").val(),
							oldPassword:$("#oldPassword").val()
						},
						success:function(data){
							console.log(data);
							if(data.state == 1){
								alert("修改成功");
								$("#newPassword").val("");
								$("#oldPassword").val("");
								$("#confirmPassword").val("");
							}
						}
					});
				}
				
			});
			$(function(){
				//所有的dd隐藏
				 $("#leftsidebar_box dd").hide();
				//让账号管理显示
				 $("#leftsidebar_box .count_managment dd").show();
				//所有的自定义列表的标题后边的图片 myOrder2.png
				$("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
			    //设置账号管理的图片和其他的三个不相同
				$("#leftsidebar_box .count_managment").find('img').attr("src","../images/myOrder/myOrder1.png");
			     
			});
</script>
</html>