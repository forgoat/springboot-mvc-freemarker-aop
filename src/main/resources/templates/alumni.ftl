<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有校友信息</title>
</head>
<body>
<div>
    <label>Welcome,${username}</label>
    <table>
        <tr>
            <th>校友姓名</th>
            <th>性别</th>
            <th>生日</th>
            <th>入学年份</th>
            <th>毕业年份</th>
            <th>工作地区</th>
            <th>职务</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>微信</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <#list alumnis as alumni>
            <tr>
                <td>${alumni.name?if_exists}</td>
                <td>${alumni.gender?if_exists}</td>
                <td>${alumni.birthday?if_exists}</td>
                <td>${alumni.enrollmentYear?if_exists}</td>
                <td>${alumni.graduatedYear?if_exists}</td>
                <td>${alumni.workingArea?if_exists}</td>
                <td>${alumni.position?if_exists}</td>
                <td>${alumni.smartphone?if_exists}</td>
                <td>${alumni.email?if_exists}</td>
                <td>${alumni.wechat?if_exists}</td>
                <td><form><button type="submit">修改</button></form></td>
                <td><form action="/deleteAlumni" method="post">
                        <input hidden name="id" id="id" value="${alumni.id}">
                        <button type="submit">删除</button></form></td>
            </tr>
        </#list>
    </table>
</div>
<div>
    <form action="/saveAlumni" method="post">
        <input type="text" name="name" id="name" placeholder="姓名">
        <input type="text" name="gender" id="gender" placeholder="性别">
        <input type="text" name="birthday" id="birthday">
        <input type="text" name="enrollmentYear" id="enrollmentYear">
        <input type="text" name="graduatedYear" id="graduatedYear">
        <input type="text" id="workingArea" name="workingArea">
        <input type="text" name="position" id="position">
        <input type="text" id="smartphone" name="smartphone">
        <input type="text" id="email" name="email">
        <input type="text" name="wechat" id="wechat">
        <button type="submit">新增校友</button>
    </form>
</div>
<form action="/getBack" method="get">
    <input hidden name="username" id="username" value="${username}">
    <button type="submit">返回管理界面</button>
</form>
</body>
</html>