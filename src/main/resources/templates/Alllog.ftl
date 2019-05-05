<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查看所有日志</title>
</head>
<body>
<label>Welcome, ${username}</label>
<div>
    <label>用户日志</label>
    <table>
        <tr>
            <th>用户名</th>
            <th>操作</th>
            <th>时间</th>
        </tr>
        <#list userlog as ulog>
            <tr>
                <td>${ulog.username}</td>
                <td>${ulog.action}</td>
                <td>${ulog.time}</td>
            </tr>
        </#list>
    </table>
</div>

<form action="/getBack" method="get">
    <input hidden name="username" id="username" value="${username}">
    <button type="submit">返回管理界面</button>
</form>
</body>
</html>