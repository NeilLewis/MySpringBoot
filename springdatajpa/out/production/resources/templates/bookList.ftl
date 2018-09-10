<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <a href="/bookAdd.html">添加</a>

    <form method="post" action="/book/list2">
        图书名称:<input type="text" name="name">&nbsp;&nbsp;
        图书作者:<input type="text" name="author">&nbsp;&nbsp;
        <input type="submit" value="搜索">
    </form>

    <table>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>作者</th>
            <th>操作</th>
        </tr>
        <#list bookList as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>
                <a href="/book/preUpdate/${book.id}">修改</a>
                <a href="/book/delete?id=${book.id}">删除</a>
            </td>
        </tr>
        </#list>
    </table>
</body>
</html>