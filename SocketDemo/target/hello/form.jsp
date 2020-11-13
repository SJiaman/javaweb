<%--
  Created by IntelliJ IDEA.
  User: 世今
  Date: 2020/11/1
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<br />

<%--<form class="layui-form" action="form.jsp" method="get">--%>

<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">账号</label>--%>
<%--        <div class="layui-input-inline">--%>
<%--            <input type="password" name="uid" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="<%= request.getParameter("uid")%>">--%>
<%--        </div>--%>
<%--        <div class="layui-form-mid layui-word-aux">请输入账号</div>--%>
<%--    </div>--%>

<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">密码框</label>--%>
<%--        <div class="layui-input-inline">--%>
<%--            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="<%= request.getParameter("password")%>">--%>
<%--        </div>--%>
<%--        <div class="layui-form-mid layui-word-aux">请输入密码</div>--%>
<%--    </div>--%>

<%--    <div class="layui-form-item">--%>
<%--        <div class="layui-input-block">--%>
<%--            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>--%>
<%--            <button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</form>--%>


<form class="layui-form" action="form.jsp" method="post">

    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-inline">
            <input type="phone" name="uid" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input" value="<%= request.getParameter("uid")%>">
        </div>
        <div class="layui-form-mid layui-word-aux">请输入账号</div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-inline">
            <input type="password" name="password"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="<%= request.getParameter("password")%>">
        </div>
        <div class="layui-form-mid layui-word-aux">请输入密码</div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>

</body>
</html>