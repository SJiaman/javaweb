<%@ page contentType="text/html;charset=UTF-8" autoFlush="true" pageEncoding="utf-8" %>
<html lang="java">
<head>
  <meta charset="utf-8">
  <title>登入</title>
  <link rel="stylesheet" href="static/layui/css/layui.css">
  <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<div class="login-main">
  <header class="layui-elip">登录</header>
  <form class="layui-form" action="login" method="post">
    <div class="layui-input-inline">
      <label>
        <input type="text" name="username" required placeholder="用户名" class="layui-input">
      </label>
    </div>
    <div class="layui-input-inline">
      <label>
        <input type="password" name="password" required  placeholder="密码" class="layui-input">
      </label>
    </div>
    <div class="layui-input-inline login-btn">
      <button class="layui-btn">登录</button>
    </div>
    <hr/>
    <p><a href="" class="fl">立即注册</a><a href="" class="fr">忘记密码？</a></p>
  </form>
</div>


<script src="static/layui/layui.js"></script>
</body>
</html>
