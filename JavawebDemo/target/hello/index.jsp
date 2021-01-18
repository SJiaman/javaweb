<%@page contentType="text/html" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>慧科教育</title>
    <link rel="stylesheet" type="text/css" href="static/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/index.css">
    <link rel="stylesheet" type="text/css" href="static/layui/css/layui.css">
    <link rel="icon" href="static/imgs/huike.jpg">
</head>
<body>

<jsp:include page="header.jsp" flush="true" />
<jsp:include page="main.jsp" flush="true" />
<jsp:include page="footer.jsp" flush="true" />

<script type="text/javascript" src="static/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="static/js/jquery.terseBanner.min.js"></script>
<script type="text/javascript" src="static/layui/layui.js"></script>
<script type="text/javascript" src="static/layui/layui.all.js"></script>
<script type="text/javascript" src="static/layui/lay/modules/form.js"></script>
<script type="text/javascript" src="static/js/wow.min.js"></script>

<script type="text/javascript">
    $('.banner').terseBanner();
    // 这个是用在动画
    if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
        new WOW({'offset': 180}).init();
    }
</script>

</body>
</html>