<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add dish</title>
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
                        <b>Fill in the fields to add a new dish!</b>
                    </tr>
                    <br/><br/>
                    <tr><input type="hidden" name="id_dish" value="${nextID}" size="50" align="left">
                        <b>ID - ${nextID};</b>
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="name_dish" placeholder="Dish name" size="50" align="left">
                    </tr>
                    <br/><br/>
                    <tr><input list="category" placeholder="Chose category" size="50" align="left">
                        <datalist id="category">
                            <option>Zakuski</option>
                            <option>Pervie Blyuda</option>
                            <option>Vtorie Blyuda</option>
                            <option>Desert</option>
                        </datalist>
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="cost" placeholder="Cost" size="50" align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="weight" placeholder="Weight" size="50" align="left">
                    </tr>
                    <br/><br/>
                    <tr><input type="text" name="ingredients" placeholder="ingredient name №1,ingredient name №2, ..."
                               size="50" align="left">
                    </tr>
                    <br/><br/>
                    <tr><input TYPE="submit" name="add_dish" value="Add Dish" style="background-color:#40c373;width:150px;height:20px">
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
