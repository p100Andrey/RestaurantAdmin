import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

@WebServlet("/s")
public class MainPage extends HttpServlet {
    List<Blydo> lb;
    List<Sotrudnik> sotrudniks;
    List<Ingredient> ingredienty;
    List<Order> orders;
    String emptyTextArea;
    String record;
    int id;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        record = null;

        if (request.getParameter("search") != null) {
            String text = request.getParameter("search_text");
            boolean flag = true;
            for (Blydo blydo : lb) {
                if (blydo.getNazvanie().toLowerCase().equals(text.toLowerCase())) {
                    flag = false;
                }
            }
            if (text.trim().equals("") || flag) {
                emptyTextArea = "Please fill the field correctly";
                request.setAttribute("error", emptyTextArea);
                pageRedirector("/mypage.jsp", request, response);
            } else {
                record = text;
                request.setAttribute("result", record);
                pageRedirector("/secondpage.jsp", request, response);
            }
        }
        if (request.getParameter("search_ingredient") != null) {
            String text = request.getParameter("search_text_ingredient");
            boolean flag = true;
            for (Ingredient ingr : ingredienty) {
                if (ingr.name.toLowerCase().equals(text.toLowerCase())) {
                    flag = false;
                }
            }
            if (text.trim().equals("") || flag) {
                emptyTextArea = "Please fill the field correctly";
                request.setAttribute("error", emptyTextArea);
                pageRedirector("/stock.jsp", request, response);
            } else {
                record = text;
                request.setAttribute("name", record);
                pageRedirector("/del_edit_stock.jsp", request, response);
            }
        }
        if (request.getParameter("mainpage") != null) {
            pageRedirector("/mypage.jsp", request, response);
        }
        if (request.getParameter("stock") != null) {
            HttpSession session = request.getSession();
            session.setAttribute("ingredients", ingredienty);
            pageRedirector("/stock.jsp", request, response);
        }
        if (request.getParameter("restaurantstaff") != null) {
            HttpSession session = request.getSession();
            session.setAttribute("sotrudniki", sotrudniks);
            pageRedirector("/restaurantstaff.jsp", request, response);
        }
        if (request.getParameter("ordershistory") != null) {
            HttpSession session = request.getSession();
            session.setAttribute("orders", orders);
            pageRedirector("/ordershistory.jsp", request, response);
        }
        if (request.getParameter("search_by") != null) {

            List<Order> searchedOrders = new ArrayList<>();
            boolean flag = true;
            if (!request.getParameter("searched_date").equals("")) {
                for (Order order : orders) {
                    if (Date.valueOf(request.getParameter("searched_date")).equals(order.getDate())) {
                        searchedOrders.add(order);
                        flag = false;
                    }
                }
            } else if (!request.getParameter("searched_waiter").equals("")) {
                for (Order order : orders) {
                    if (request.getParameter("searched_waiter").equals(order.getOficiant())) {
                        searchedOrders.add(order);
                        flag = false;
                    }
                }
            } else if (!request.getParameter("searched_table_number").equals("")) {
                for (Order order : orders) {
                    if (Integer.parseInt(request.getParameter("searched_table_number")) == (order.getStolik())) {
                        searchedOrders.add(order);
                        flag = false;
                    }
                }
            }

            if (flag) {
                emptyTextArea = "Please fill the field correctly";
                request.setAttribute("error", emptyTextArea);
                pageRedirector("/ordershistory.jsp", request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("orders", searchedOrders);
                pageRedirector("/ordershistory.jsp", request, response);
            }
        }
        if (request.getParameter("addworker") != null) {
            int idSotrudnika = Integer.parseInt(request.getParameter("id_worker"));
            String familiya = request.getParameter("last_name");
            String imya = request.getParameter("first_name");
            java.sql.Date datarojdeniya = Date.valueOf(request.getParameter("birthday"));
            int telefon = Integer.parseInt(request.getParameter("telephone"));
            String doljnosty = request.getParameter("position");
            int oklad = Integer.parseInt(request.getParameter("salary"));
            Sotrudnik sotrudnik = new Sotrudnik(idSotrudnika, familiya, imya, datarojdeniya, telefon, doljnosty, oklad);
            DBConnection.createSotrudnik(sotrudnik);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("sotrudniki", sotrudniks);
            pageRedirector("/restaurantstaff.jsp", request, response);
        }
        if (request.getParameter("editworker") != null) {
            int idSotrudnika = Integer.parseInt(request.getParameter("idsotrudnika"));
            String familiya = request.getParameter("familiya");
            String imya = request.getParameter("imya");
            java.sql.Date datarojdeniya = Date.valueOf(request.getParameter("datarojdeniya"));
            int telefon = Integer.parseInt(request.getParameter("telefon"));
            String doljnosty = request.getParameter("doljnosty");
            int oklad = Integer.parseInt(request.getParameter("oklad"));
            Sotrudnik sotrudnik = new Sotrudnik(idSotrudnika, familiya, imya, datarojdeniya, telefon, doljnosty, oklad);
            DBConnection.updateSotrudnik(sotrudnik);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("sotrudniki", sotrudniks);
            pageRedirector("/restaurantstaff.jsp", request, response);
        }
        if (request.getParameter("deleteworker") != null) {
            int idSotrudnika = Integer.parseInt(request.getParameter("idsotrudnika"));
            DBConnection.deleteSotrudnik(idSotrudnika);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("sotrudniki", sotrudniks);
            pageRedirector("/restaurantstaff.jsp", request, response);
        }
        if (request.getParameter("adddish") != null) {
            HttpSession session = request.getSession();
            String nextID = "" + (lb.size() + 1);
            session.setAttribute("nextID", nextID);
            pageRedirector("/adddish.jsp", request, response);
        }
        if (request.getParameter("add_dish") != null) {
            int iddish = Integer.parseInt(request.getParameter("id_dish"));
            String namedish = request.getParameter("name_dish");
            String category = request.getParameter("category");
            double cost = Double.parseDouble(request.getParameter("cost"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            String ingredientsList = request.getParameter("ingredients");
            Blydo blydo = new Blydo(iddish, namedish, category, cost, weight, ingredientsList);
            DBConnection.createDish(blydo);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("lb", lb);
            pageRedirector("/mypage.jsp", request, response);
        }
        if (request.getParameter("editdish") != null) {
            int iddish = Integer.parseInt(request.getParameter("idblydo"));
            String namedish = request.getParameter("nazvanie");
            String category = request.getParameter("kategoriya");
            double cost = Double.parseDouble(request.getParameter("stoimost"));
            double weight = Double.parseDouble(request.getParameter("ves"));
            String ingredientsList = request.getParameter("ingradienti");
            Blydo blydo = new Blydo(iddish, namedish, category, cost, weight, ingredientsList);
            DBConnection.updateDish(blydo);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("lb", lb);
            pageRedirector("/mypage.jsp", request, response);
        }
        if (request.getParameter("deletedish") != null) {
            int iddish = Integer.parseInt(request.getParameter("idblydo"));
            DBConnection.deleteDish(iddish);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("lb", lb);
            pageRedirector("/mypage.jsp", request, response);
        }
        if (request.getParameter("addstock") != null) {
            int idIngradient = Integer.parseInt(request.getParameter("idingradienta"));
            String nameIngradient = request.getParameter("nameingradienta");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Ingredient ingredient = new Ingredient(idIngradient, nameIngradient, quantity);
            DBConnection.addStock(ingredient);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("ingredients", ingredienty);
            pageRedirector("/stock.jsp", request, response);
        }
        if (request.getParameter("editstock") != null) {
            int idIngradient = Integer.parseInt(request.getParameter("idingradienta"));
            String nameIngradient = request.getParameter("nameingradienta");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Ingredient ingredient = new Ingredient(idIngradient, nameIngradient, quantity);
            DBConnection.updateStock(ingredient);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("ingredients", ingredienty);
            pageRedirector("/stock.jsp", request, response);
        }
        if (request.getParameter("deletestock") != null) {
            int idIngradient = Integer.parseInt(request.getParameter("idingradienta"));
            String name = request.getParameter("nameingradienta");
            DBConnection.deleteStock(idIngradient, name);
            init();
            HttpSession session = request.getSession();
            session.setAttribute("ingredients", ingredienty);
            pageRedirector("/stock.jsp", request, response);
        }
    }

    private void pageRedirector(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletContext servletContext = getServletContext();
        servletContext.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        record = null;
        if (request.getParameter("blydoname") != null || request.getParameter("idsotrudnika") != null
                || request.getParameter("nameingredient") != null) {
            if (request.getParameter("blydoname") != null) {
                String text1 = request.getParameter("blydoname");
                record = text1;
                request.setAttribute("result", record);
                pageRedirector("/secondpage.jsp", request, response);
            }
            if (request.getParameter("idsotrudnika") != null) {
                String text1 = request.getParameter("idsotrudnika");
                record = text1;
                request.setAttribute("idworker", record);
                pageRedirector("/del_edit_worker.jsp", request, response);
            }
            if (request.getParameter("nameingredient") != null) {
                String text1 = request.getParameter("nameingredient");
                record = text1;
                request.setAttribute("name", record);
                pageRedirector("/del_edit_stock.jsp", request, response);
            }
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("lb", lb);
            pageRedirector("/mypage.jsp", request, response);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        lb = DBConnection.dbUpdate();
        sotrudniks = DBConnection.getStaff();
        ingredienty = DBConnection.getStock();
        orders = DBConnection.getOrderHistory();
        emptyTextArea = new String();
        record = new String("");
    }
}
