<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
</head>
<body>
<div class="layui-container">
    <blockquote class="layui-elem-quote layui-text">
        学生详情：
    </blockquote>

    <div class="layui-form" action="">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">书籍名称</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="bookName" type="text" readonly="bookName" class="layui-input">
                    </label>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">作者</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="author" type="text" readonly name="author" class="layui-input">
                    </label>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">出版社</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="publish" name="publish" readonly class="layui-input">
                    </label>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">ISBN</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="isbn" name="isbn" readonly class="layui-input">
                    </label>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">语言</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="language" type="text" readonly name="language" class="layui-input">
                    </label>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">价格</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="price" name="price" readonly class="layui-input">
                    </label>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">类型</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="type" type="text" readonly name="type" class="layui-input">
                    </label>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">数量</label>
                <div class="layui-input-inline">
                    <label>
                        <input id="number" name="number" readonly class="layui-input">
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
