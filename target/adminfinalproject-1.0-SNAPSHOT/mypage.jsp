<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Create an ArrayList with test data
    ArrayList<String> list = new ArrayList();
    list.add("Zakuski");
    list.add("Pervie Blyuda");
    list.add("Vtorie Blyuda");
    list.add("Desert");
    pageContext.setAttribute("razdely", list);
%>

<html>

<head>
    <title>Main page</title>
</head>

<style>
    a {
        text-decoration: none;
        font-size: 30px;
        color: white;
        width: 600px;
    }

    /* Убираем подчеркивание у ссылок */
    a:hover {
        text-decoration: underline;
    }

    /* Добавляем подчеркивание при наведении курсора мыши на ссылку */
</style>

<body style="background: url(№1.jpg)">

<table style="background: white; width:1200px" align="center">
    <tr>
        <td>
            <h1 style="font-family: 'Franklin Gothic Medium'; color:#0cc316; height:130px">
                <big><big><big><big><big><big><big>ELF</big></big></big></big></big></big></big>
            </h1>
        </td>
        <td>
            <h3>&emsp;Restaurant: Kiev, str. Reitarska 5, t. 808880888 </h3>
            <hr width="100%" align="left">
            <form action="mainPage" METHOD="POST">
                <table>
                    <tr>
                        <td><input TYPE="submit" name="mainpage" value="Main Page"
                                   style="background-color:#0cc316;width:200px;height:30px;font-size:20px;color:white"></td>
                        <td><input TYPE="submit" name="restaurantstaff" value="Restaurant Staff"
                                   style="background-color:#0cc316;width:200px;height:30px;font-size:20px;color:white"></td>
                        <td><input TYPE="submit" name="stock" value="Stock"
                                   style="background-color:#0cc316;width:200px;height:30px;font-size:20px;color:white"></td>
                        <td><input TYPE="submit" name="ordershistory" value="Orders History"
                                   style="background-color:#0cc316;width:200px;height:30px;font-size:20px;color:white"></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>

<table style="background: url(texture3.jpg); width:1200px; color:white" align="center">
    <tr>
        <td>
            <br/>
            <table>

                <tr><h2>&emsp;&emsp;&emsp;Meny</h2></tr>
                <tr><h3>&emsp;&emsp;&emsp;dish name&emsp;&emsp;&emsp;-&emsp;&emsp;&emsp;weight&emsp;&emsp;&emsp;-&emsp;&emsp;&emsp;price</h3></tr>

                <tr><h2>&emsp;Zakuski</h2></tr>
                <c:forEach var="blydo" items="${lb}" varStatus="status">
                    <c:if test="${razdely.get(0).equals(blydo.getKategoriya())}">
                        <tr>
                            <td><a href="mainPage?blydoname=${blydo.getNazvanie()}"
                                   name="blydoname">&emsp;${blydo.getNazvanie()}</a></td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getVes()}</td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getStoimost()};</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

            <table>
                <br/>
                <tr><h2>&emsp;Pervie Blyuda</h2></tr>
                <c:forEach var="blydo" items="${lb}" varStatus="status">
                    <c:if test="${razdely.get(1).equals(blydo.getKategoriya())}">
                        <tr>
                            <td><a href="mainPage?blydoname=${blydo.getNazvanie()}"
                                   name="blydoname">&emsp;${blydo.getNazvanie()}</a></td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getVes()}</td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getStoimost()};</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

            <table>
                <br/>
                <tr><h2>&emsp;Vtorie Blyuda</h2></tr>
                <c:forEach var="blydo" items="${lb}" varStatus="status">
                    <c:if test="${razdely.get(2).equals(blydo.getKategoriya())}">
                        <tr>
                            <td><a href="mainPage?blydoname=${blydo.getNazvanie()}"
                                   name="blydoname">&emsp;${blydo.getNazvanie()}</a></td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getVes()}</td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getStoimost()};</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

            <table>
                <br/>
                <tr><h2>&emsp;Desert</h2></tr>
                <c:forEach var="blydo" items="${lb}" varStatus="status">
                    <c:if test="${razdely.get(3).equals(blydo.getKategoriya())}">
                        <tr>
                            <td><a href="mainPage?blydoname=${blydo.getNazvanie()}"
                                   name="blydoname">&emsp;${blydo.getNazvanie()}</a></td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getVes()}</td>
                            <td style="font-size:30px; color:white; width:150px">&emsp;- ${blydo.getStoimost()};</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

            <br/><br/>

        </td>
    </tr>
</table>

<table style="background: white; width:1200px" align="center">
    <tr>
        <td>
            <br/>

            <form METHOD="POST">

                <table>
                    <tr>
                        <td><a href="adddish.jsp"><input TYPE="submit" name="adddish" value="Add Dish"
                                                         style="background-color:#0cc316;width:150px;height:30px;font-size:20px;color:white"></a>
                        </td>
                    </tr>
                </table>

                <font color="red"><h5>${error}</h5></font>
                <table>
                    <tr>
                        <td><input TYPE="submit" name="search" value="Search"
                                   style="background-color:#0cc316;width:150px;height:30px;font-size:20px;color:white"></td>
                        <td>&emsp;&emsp;</td>
                        <td><input type="text" name="search_text" placeholder="Enter name of dish" size="60"
                                   align="left" style="height:30px"></td>
                    </tr>
                </table>
            </form>
            <%--<hr width="100%" align="left">--%>
        </td>
    </tr>
</table>
</body>
</html>