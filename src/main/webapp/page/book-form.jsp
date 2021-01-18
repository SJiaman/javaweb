<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <table class="layui-hide" id="student" lay-filter="student_filter"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="borrow">借书</a>
        </script>

    </div>
</div>
<script src="../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../lib/layui-v2.5.5/layui.all.js"></script>
<script src="../lib/layui-v2.5.5/layui.js"></script>
<script>
    layui.use(['table', 'layer', 'form'], function () {
        const table = layui.table;
        const layer = layui.layer;
        const form = layui.form;
        const $ = layui.$;

        const tableIns = table.render({
            elem: '#student'
            , url: '/all/book'
            , page: true
            , cellMinWidth: 80
            , defaultToolbar: ['filter', 'print', 'exports']
            , toolbar: '#toolbarDemo'
            , response: {
                statusCode: 200
            }
            , cols: [[
                {field: 'bookId', width: 80, title: 'ID', sort: true},
                {field: 'bookName', width: 160, title: '书名'},
                {field: 'author', width: 150, title: '作者'},
                {field: 'publish', width: 150, title: '出版社'},
                {field: 'isbn', Width: 120, title: 'ISBN'},
                {field: 'language', width: 80, title: '语言'},
                {field: 'price', width: 80, title: '价格', sort: true},
                // {field: 'pubDate', width: 120, title: '出版时间'},
                {field: 'type', width: 80, title: '类型'},
                {field: 'number', width: 80, title: '数量', sort: true},
                {fixed: 'right', title: '操作', width: 250, align: 'center', toolbar: '#barDemo'}
            ]]
        });

        table.on('tool(student_filter)', function (obj) {
            const data = obj.data; //获得当前行数据
            const layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            if (layEvent === 'detail') {
                //查看
                layer.open({
                    type: 2,
                    content: 'common/book-detail.jsp',
                    area: ['700px', '400px'],
                    btn: '确认',
                    title: false,
                    yes: function (index, layero) {
                        layer.close(index);
                    },
                    success: function (layero, index) {
                        render_form(layero, index, data)
                    }
                });
            } else if (layEvent === 'borrow') { //编辑
                layer.open({
                    type: 2,
                    content: 'common/borrow-add.jsp',
                    area: ['700px', '400px'],
                    title: false,
                    btn: ['确定', "取消"],
                    yes: function (index, layero) {
                        const iframeWindow = window['layui-layer-iframe' + index]
                            , submitID = 'user-add-save'
                            , submit = layero.find('iframe').contents().find('#' + submitID);

                        //监听提交
                        iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                            const field = data.field; //获取提交的字段

                            $.ajax({
                                url: '/book/update',
                                type: 'POST',
                                data: JSON.stringify(field),
                                success: function (res) {
                                    if (res.code === 200) {
                                        tableIns.reload();
                                        layer.close(index);
                                        layer.msg('更新成功');
                                    } else {
                                        layer.msg('更新失败');
                                    }
                                },
                                error: function (error) {
                                    layer.msg('更新失败');
                                }
                            });
                        });

                        submit.trigger('click');
                    },
                    success: function (layero, index) {
                        render_form(layero, index, data)
                    }
                });
            }

            function render_form(layero, index, data) {
                const body = layer.getChildFrame('body', index);
                body.find('#bookId').val(data.bookId);
                body.find('#readerName').val(data.readerName);
                body.find('#author').val(data.author);
                body.find('#publish').val(data.publish);
                body.find('#isbn').val(data.isbn);
                body.find('#language').val(data.language);
                body.find('#price').val(data.price);
                body.find('#type').val(data.type);
                body.find('#number').val(data.number);
            }
        });
    });
</script>

</body>
</html>