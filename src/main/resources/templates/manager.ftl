<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>校友管理页面</title>
</head>
<body>
<a>Welcome, ${admin.username}</a>
<label>校友信息</label>
<form action="/alumni" method="get">
    <input type="hidden" id="username" name="username" value="${admin.username}">
    <button type="submit">查看校友
    </button>
</form>
<form action="/log" method="get">
    <input type="hidden" name="username" id="username" value="${admin.username}">
    <button type="submit">查看日志</button>
</form>
<form action="/logoff" method="post">
    <input type="hidden" id="username" name="username" value="${admin.username}">
    <button type="submit">管理员登出</button>
</form>
</body>
</html>