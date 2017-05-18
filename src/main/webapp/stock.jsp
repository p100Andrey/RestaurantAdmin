<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingredient</title>
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
                    <td><a href="addstock.jsp"><input TYPE="submit" name="addstock" value="Add ingredient"
                                                      style="background-color:#40c373;width:150px;height:20px"></a>
                    </td>
                </tr>
            </table>
            <table>
                <b>Ingredients</b>
                <br/>
                <c:forEach var="ingradient" items="${ingredients}" varStatus="status">
                    <tr>
                        <td>ID - ${ingradient.getIdIngradient()};</td>
                        <td><a href="mainPage?nameingredient=${ingradient.getName()}"
                               name="nameingredient">Ingredient - ${ingradient.getName()},</a></td>
                        <td>quantity - ${ingradient.getQuantity()};</td>
                    </tr>
                </c:forEach>
            </table>
            <form method="post">
                <font color="red"><h5>${error}</h5></font>
                <table width="1200" border="0" cellpadding="5">
                    <tr>
                        <td><input TYPE="submit" name="search_ingredient" value="Search"
                                   style="background-color:#40c373; height:20px"></td>
                        <td><input type="text" name="search_text_ingredient" placeholder="Enter name of ingradient"
                                   size="106"
                                   align="left"></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>


</body>
</html>
