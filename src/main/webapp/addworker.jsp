<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add worker</title>
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
                    <tr>
                        <b>Fill in the fields to add a new worker!</b>
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="id_worker" placeholder="Workers ID" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="last_name" placeholder="Last name" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="first_name" placeholder="First name" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="birthday" placeholder="Birthday" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="telephone" placeholder="Telephone" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="position" placeholder="Position" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="salary" placeholder="Salary" size="50"
                               align="left">
                    </tr>
                    <br/><br/>
                    <tr><input TYPE="submit" name="addworker" value="Add Worker"
                               style="background-color:#40c373;width:150px;height:20px">
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
