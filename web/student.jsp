<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.student.job.utils.DBUtil" %>
<%@ page import="com.student.job.utils.JDBCUtil" %><%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/4
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>学生页面</title>
</head>
<body>
<h1>欢迎${s_name}！</h1>
<p>这是学生页面。</p>
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>邮箱</th>
        </tr>
        <%
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            conn= JDBCUtil.getConn();
            st = conn.createStatement();
            String sql ="select * from student";
            rs = st.executeQuery(sql);
            while (rs.next()){
        %>
        <tr>
            <td><%=rs.getString("s_id") %></td>
            <td><%=rs.getString("s_name") %></td>
            <td><%=rs.getString("s_gender") %></td>
            <td><%=rs.getInt("s_age") %></td>
            <td><%=rs.getString("s_phone") %></td>
            <td><%=rs.getString("s_email") %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

