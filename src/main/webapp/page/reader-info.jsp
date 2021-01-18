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
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="/stu/all/" method="get">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">学生学号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="stuNo" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">学生姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="stuName" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary" lay-submit
                                    lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加</button>
            </div>
        </script>

        <table class="layui-hide" id="student" lay-filter="student_filter"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
            , url: '/all/reader'
            , page: true
            , cellMinWidth: 80
            , defaultToolbar: ['filter', 'print', 'exports']
            , toolbar: '#toolbarDemo'
            , response: {
                statusCode: 200
            }
            , cols: [[
                {type: 'checkbox', fix: 'left'},
                {field: 'readerId', width: 80, title: 'ID', sort: true},
                {field: 'readerName', width: 120, title: '姓名'},
                {field: 'sex', width: 120, title: '性别'},
                {field: 'birth', width: 150, title: '生日'},
                {field: 'address', Width: 120, title: '地址'},
                {field: 'phone', width: 150, title: '电话'},
                {field: 'password', width: 150, title: '密码'},
                {fixed: 'right', title: '操作', width: 250, align: 'center', toolbar: '#barDemo'}
            ]]
        });

        table.on('tool(student_filter)', function (obj) {
            const data = obj.data; //获得当前行数据
            const layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            if (layEvent === 'del') { //删除
                layer.confirm('真的删除行么', function (index) {
                    // obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    //向服务端发送删除指令
                    $.ajax({
                        url: '/reader/del',
                        type: 'POST',
                        data: {'readerId': data.readerId},
                        success: function (res) {
                            console.log(res);
                            layer.close(index);
                            if (res.code === 200) {
                                layer.msg('删除成功');
                                tableIns.reload();
                            } else {
                                layer.msg('删除失败');
                            }
                        },
                        error: function (error) {
                            layer.close(index)
                            layer.msg('http请求错误')
                        }
                    });
                });
            } else if (layEvent === 'edit') { //编辑
                layer.open({
                    type: 2,
                    content: 'common/reader-edit.jsp',
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
                                url: '/reader/update',
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
                body.find('#readerId').val(data.readerId);
                body.find('#readerName').val(data.readerName);
                body.find('#sex').val(data.sex);
                body.find('#birth').val(data.birth);
                body.find('#address').val(data.address);
                body.find('#phone').val(data.phone);
                body.find('#password').val(data.password);
            }
        });

        table.on('toolbar(student_filter)', function (obj) {

            if (obj.event === 'add') {
                layer.open({
                    type: 2,
                    content: 'common/reader-add.jsp',
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
                                url: '/reader/add',
                                type: 'POST',
                                data: JSON.stringify(field),
                                success: function (res) {
                                    if (res.code === 200) {
                                        tableIns.reload();
                                        layer.close(index);
                                        layer.msg('添加成功');
                                    } else {
                                        layer.msg('添加失败');
                                    }
                                },
                                error: function (error) {
                                    layer.msg('添加失败');
                                }
                            });
                        });

                        submit.trigger('click');
                    }
                });
            }
        });

    });
</script>

</body>
</html>