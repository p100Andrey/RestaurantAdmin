<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit stock</title>
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
            <form action="mainPage" METHOD="POST">
                <table>
                    <tr>
                        <b>Delete or Edit</b>
                    </tr>

                    <br/>
                    <c:forEach var="ingradient" items="${ingredients}" varStatus="status">
                        <c:if test="${name.equals(ingradient.getName())}">
                            <tr>
                                <td>Ingredient ID - ${ingradient.getIdIngradient()},</td>
                                <td><input type="hidden" name="idingradienta" value="${ingradient.getIdIngradient()}">
                                </td>
                                <td>name ingredients - ${ingradient.getName()},</td>
                                <td><input type="hidden" name="nameingradienta" value="${ingradient.getName()}">
                                </td>
                                <td>quantity -</td>
                                <td><input type="text" name="quantity" value="${ingradient.getQuantity()}"
                                           size="10" align="left"></td>
                            <tr>
                                <td></td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>

                <table>
                    <tr>
                        <td><input TYPE="submit" name="editstock" value="Edit stock ingredient"
                                   style="background-color:#40c373;width:150px;height:20px">
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><input TYPE="submit" name="deletestock" value="Delete stock ingredient"
                                   style="background-color:#40c373;width:150px;height:20px">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
