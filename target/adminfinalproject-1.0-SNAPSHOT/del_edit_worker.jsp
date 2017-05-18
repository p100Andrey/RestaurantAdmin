<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <c:forEach var="sotrudnik" items="${sotrudniki}" varStatus="status">
                    <c:if test="${idworker.equals(sotrudnik.getIdSotrudnika())}">
                        <tr>
                            <td>Worker ID - ${sotrudnik.getIdSotrudnika()}</td>
                            <td><input type="hidden" name="idsotrudnika" value="${sotrudnik.getIdSotrudnika()}"></td>
                        </tr>
                        <tr>
                            <td>&emsp;Last name - </td>
                            <td><input type="text" name="familiya" value="${sotrudnik.getFamiliya()}"
                                       size="50" align="left"></td>
                        </tr>
                        <tr>
                            <td>&emsp;First name - </td>
                            <td><input type="text" name="imya" value="${sotrudnik.getImya()}"
                                       size="50" align="left"></td>
                        </tr>
                        <tr>
                            <td>&emsp;Birthday - </td>
                            <td><input type="text" name="datarojdeniya" value="${sotrudnik.getDatarojdeniya()}"
                                       size="50" align="left"></td>
                        </tr>
                        <tr>
                            <td>&emsp;Telephone - </td>
                            <td><input type="text" name="telefon" value="${sotrudnik.getTelefon()}"
                                       size="50" align="left"></td>
                        </tr>
                        <tr>
                            <td>&emsp;Position - </td>
                            <td><input type="text" name="doljnosty" value="${sotrudnik.getDoljnosty()}"
                                       size="50" align="left"></td>
                        </tr>
                        <tr>
                            <td>&emsp;Salary - </td>
                            <td><input type="text" name="oklad" value="${sotrudnik.getOklad()}"
                                       size="50" align="left"></td>
                        </tr>
                        <tr>
                            <td></td>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>

            <table>
                <tr>
                    <td><input TYPE="submit" name="editworker" value="Edit worker"
                               style="background-color:#40c373;width:150px;height:20px">
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><input TYPE="submit" name="deleteworker" value="Delete worker"
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
