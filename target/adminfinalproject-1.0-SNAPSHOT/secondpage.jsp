<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second page</title>
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

                <table>
                    <c:forEach var="blydo" items="${lb}" varStatus="status">
                        <c:if test="${result.toLowerCase().equals(blydo.getNazvanie().toLowerCase())}">
                            <tr>
                                <td>Dish ID - ${blydo.getIdBlydo()}</td>
                                <td><input type="hidden" name="idblydo" value="${blydo.getIdBlydo()}"></td>
                            </tr>
                            <tr>
                                <td> dish name -</td>
                                <td><input type="text" name="nazvanie" value="${blydo.getNazvanie()}"
                                           size="50" align="left"></td>
                            </tr>
                            <tr>
                                <td>category -</td>
                                <td><input type="text" name="kategoriya" value="${blydo.getKategoriya()}"
                                           size="50" align="left"></td>
                            </tr>
                            <tr>
                                <td>prise -</td>
                                <td><input type="text" name="stoimost" value="${blydo.getStoimost()}"
                                           size="50" align="left"></td>
                            </tr>
                            <tr>
                                <td>weight -</td>
                                <td><input type="text" name="ves" value="${blydo.getVes()}"
                                           size="50" align="left"></td>
                            </tr>
                            <tr>
                                <td>ingredients -</td>
                                <td><input type="text" name="ingradienti" value="${blydo.getSpisokIngradientov()}"
                                           size="50" align="left"></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>

                <table>
                    <tr>
                        <td><input TYPE="submit" name="editdish" value="Edit dish"
                                   style="background-color:#40c373;width:150px;height:20px">
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><input TYPE="submit" name="deletedish" value="Delete dish"
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
