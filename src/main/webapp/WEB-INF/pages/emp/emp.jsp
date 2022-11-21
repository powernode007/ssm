<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugs.js"></script>
    <script>
        <%--$(function () {--%>
        <%--$("#delete").click(function () {--%>
        <%--var $empno = $("#empno");--%>
        <%--var empNo = $empno.innerHTML()--%>
        <%--alert(empNo)--%>
        <%--$.ajax({--%>
        <%--type: "get",--%>
        <%--url: "${pageContext.request.contextPath}/emp/delEmp.action",--%>
        <%----%>
        <%--success: function (message) {--%>
        <%--alert(message)--%>
        <%--}--%>

        <%--})--%>
        <%--})--%>
        <%--})--%>

    </script>
</head>
<body>

<div class="panel admin-panel" style="border: 1px solid #ddd;">
    <div class="panel-head"><span class="icon-magic"/> 员工管理<strong/></div>
    <div class="padding border-bottom">
        <style>
            ul li {
                display: inline;
            }
        </style>
        <ul class="search">
            <li>
                <a href="${pageContext.request.contextPath}/emp/toAddEmp.action" style="margin-top:10px ;"
                   class="btn btn-success" target="right">添加员工</a>
                <button style="margin-top:10px ;" class="btn btn-danger">批量删除</button>
            </li>

            <li>
                <form action="${pageContext.request.contextPath}/emp/toEmpByPage.action" method="post">


                    <div class="am-u-sm-12 am-u-md-3" style="position: absolute;right:10px;top:68px">
                        <div class="am-input-group am-input-group-sm">
                            <input class="am-form-field" placeholder="请输入员工姓名" name="likeName" type="text"
                                   value="${likeName}">
                            <span class="am-input-group-btn"/>
                            <button type="submit" class="btn btn-primary">查询</button>

                        </div>

                    </div>
                </form>
            </li>
        </ul>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th><input type="checkbox" name="id[]" value="1"/></th>
            <th>编号</th>
            <th>姓名</th>
            <th>工种</th>
            <th>月薪</th>
            <th>入职日期</th>
            <th>上级领导</th>
            <th>所在部门</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${allEmp}" var="emp">

        <tr>
            <td>
                <input type="checkbox" name="id[]" value="1"/>
            </td>
            <td id="empno">${emp.empNo}</td>
            <td>${emp.empName}</td>
            <td>${emp.empJob}</td>
            <td>${emp.empSal}</td>
            <td>${emp.empHiredate}</td>
            <td><img src="${pageContext.request.contextPath}/fileupload/${emp.empPhoto}" width="50px" height="50px">
            </td>
            <td>${emp.dname}</td>
            <td>
                <button class="btn btn-info" target="right" onclick="update(${emp.empNo})">修改</button>
                <button class="btn btn-warning" id="delete" onclick="del(${emp.empNo})">删除</button>
            </td>
        </tr>
        </c:forEach>

        <tr>
            <td colspan="8">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;上一页</span>
                            </a>
                        </li>
                        <c:forEach begin="${pageUtil.beginIndex}" end="${pageUtil.endIndex}" var="i">
                            <li>
                                <a href="${pageContext.request.contextPath}/emp/toEmpByPage.action?pageNum=${i}&likeName=${likeName}">${i}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">下一页&raquo;</span>
                            </a>
                        </li>
                        <li>
                            <a aria-label="Next">
                                <span aria-hidden="true">当前第${pageUtil.pageNum}/共${pageUtil.pages}</span>
                            </a>
                        </li>
                        <li>
                            <a aria-label="Next">
                                <span aria-hidden="true">共${pageUtil.total}个员工</span>
                            </a>
                        </li>
                    </ul>
                </nav>
</div>
</td>
</tr>
</table>
</div>

<script type="text/javascript">
    function del(id) {

        if (confirm("您确定要删除吗?")) {

            $.post("${pageContext.request.contextPath}/emp/delEmp.action", {"id": id}, function (message) {
                alert(message)
                window.location.href = window.location.href;
            }, "text")
        }

    }
    function update(id){
        $.post("${pageContext.request.contextPath}/emp/huixian.action", {"id2": id}, function (message) {
            window.location.href="${pageContext.request.contextPath}/emp/zhongzhuan.action"
        }, "text")
    }


    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }
</script>

</body>
</html>


