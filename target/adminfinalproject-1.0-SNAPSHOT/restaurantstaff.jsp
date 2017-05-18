<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant staff</title>
</head>

<style>
    a {
        text-decoration: none;
    }

    /* Убираем подчеркивание у ссылок */
    a:hover {
        text-decoration: underline;
    }

    /* Добавляем подчеркивание при наведении курсора мыши на ссылку */
</style>

<body>
<h1><big><big>&emsp;<a href="mainPage" title="Main page" style="background-color:#ffffff;
     font-family: 'Franklin Gothic Medium'; color:#0cc316; height:20px">ELF</a></big></big>
</h1>

<table bordercolor="white" border="10" cellpadding="5">
    <tr>
        <td>
            <h1>Restaurant: Kiev, str. Reitarska 5, t. 808880888 </h1>
            <hr width="80%" align="left">
            <form action="mainPage" METHOD="POST">
                <table>
                    <tr>
                        <td><input TYPE="submit" name="mainpage" value="Main Page"
                                   style="background-color:#40c373;width:150px;height:20px"></td>
                        <td><input TYPE="submit" name="restaurantstaff" value="Restaurant Staff"
                                   style="background-color:#40c373;width:150px;height:20px"></td>
                        <td><input TYPE="submit" name="stock" value="Stock"
                                   style="background-color:#40c373;width:150px;height:20px"></td>
                        <td><input TYPE="submit" name="ordershistory" value="Orders History"
                                   style="background-color:#40c373;width:150px;height:20px"></td>
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <td><a href="addworker.jsp"><input TYPE="submit" name="addworker" value="Add Worker"
                                                       style="background-color:#40c373;width:150px;height:20px"></a>
                    </td>
                </tr>
            </table>
            <%--<form action="mainPage" METHOD="POST">--%>
                <table>
                    <b>&emsp;Staff</b>
                    <br/>
                    <c:forEach var="sotrudnik" items="${sotrudniki}" varStatus="status">
                        <tr>
                            <td><a href="mainPage?idsotrudnika=${sotrudnik.getIdSotrudnika()}"
                                   name="idsotrudnika">Worker ID - ${sotrudnik.getIdSotrudnika()};</a></td>
                        </tr>
                        <tr>
                            <td>&emsp;Last name - ${sotrudnik.getFamiliya()};</td>
                        </tr>
                        <tr>
                            <td>&emsp;First name - ${sotrudnik.getImya()};</td>
                        </tr>
                        <tr>
                            <td>&emsp;Birthday - ${sotrudnik.getDatarojdeniya()};</td>
                        </tr>
                        <tr>
                            <td>&emsp;Telephone - ${sotrudnik.getTelefon()};</td>
                        </tr>
                        <tr>
                            <td>&emsp;Position - ${sotrudnik.getDoljnosty()};</td>
                        </tr>
                        <tr>
                            <td>&emsp;Salary - ${sotrudnik.getOklad()};</td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
            <%--</form>--%>
        </td>
    </tr>
</table>

</body>
</html>
