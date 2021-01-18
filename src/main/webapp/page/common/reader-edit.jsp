<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>修改书籍数据</legend>
</fieldset>

<div class="layui-form">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">读者名字</label>
            <div class="layui-input-inline">
                <label>
                    <input id="readerName" type="text" required name="readerName" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <label>
                    <input id="sex" type="text" name="sex" class="layui-input">
                </label>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <label>
                    <input id="birth" type="date" name="birth" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline">
                <label>
                    <input id="address" name="address" class="layui-input">
                </label>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <label>
                    <input id="phone" name="phone" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="password" name="password" class="layui-input">
                    </label>
                </div>
        </div>
    </div>

    <div class="layui-form-item layui-hide">
        <button type="button" lay-submit="" lay-filter="user-add-save" id="user-add-save" class="layui-btn">
            确认
        </button>
    </div>

</div>
</div>
<script src="../../lib/layui-v2.5.5/layui.all.js"></script>
</body>
</html>