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
            <label class="layui-form-label">书籍名称</label>
            <div class="layui-input-inline">
                <label>
                    <input id="bookName" type="text" required name="bookName" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">作者</label>
            <div class="layui-input-inline">
                <label>
                    <input id="author" type="text" name="author" class="layui-input">
                </label>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">出版社</label>
            <div class="layui-input-inline">
                <label>
                    <input id="publish" name="publish" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">ISBN</label>
            <div class="layui-input-inline">
                <label>
                    <input id="isbn" name="isbn" class="layui-input">
                </label>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">语言</label>
            <div class="layui-input-inline">
                <label>
                    <input id="language" type="text" name="language" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-inline">
                <label>
                    <input id="price" name="price" class="layui-input">
                </label>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-inline">
                <label>
                    <input id="type" type="text" name="type" class="layui-input">
                </label>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-inline">
                <label>
                    <input id="number" name="number" class="layui-input">
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