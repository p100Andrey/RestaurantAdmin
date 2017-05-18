import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnection {


    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/Restaurant";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "31388";

    public static List<Blydo> dbUpdate() {
        List<Blydo> listBlyd = new ArrayList<>();

        Connection dbConnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Statement stmt = null;
        Statement stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            System.out.println("Creating statement...");
            stmt = dbConnection.createStatement();
            stmt1 = dbConnection.createStatement();
            stmt2 = dbConnection.createStatement();
            String sqlListBlyd;
            sqlListBlyd = "SELECT * FROM blydo";
            rs = stmt.executeQuery(sqlListBlyd);

            String sqlSpisokIdIngradientov;
            sqlSpisokIdIngradientov = "SELECT * FROM ingradienti_blyda";

            String sqlSpisokIngradientov;
            sqlSpisokIngradientov = "SELECT * FROM ingradient";

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("idBlydo");
                String nazvanie = rs.getString("nazvanie");
                String kategoriya = rs.getString("kategoriya");
                double stoimost = rs.getDouble("stoimost");
                double ves = rs.getDouble("ves");

                Blydo blydo = new Blydo(id, nazvanie, kategoriya, stoimost, ves);

                List<Integer> idIngradientovBlyda = new ArrayList<>();
                rs1 = stmt1.executeQuery(sqlSpisokIdIngradientov);
                while (rs1.next()) {
                    if (rs1.getInt("idBlydo") == id) {
                        idIngradientovBlyda.add(rs1.getInt("idIngradienta"));
                    }
                }

                if (!idIngradientovBlyda.isEmpty()) {
                    rs2 = stmt2.executeQuery(sqlSpisokIngradientov);
                    while (rs2.next()) {
                        for (Integer idIngradient : idIngradientovBlyda) {
                            if (rs2.getInt("idIngradient") == idIngradient) {
                                blydo.setSpisokIngradientov(blydo.getSpisokIngradientov()
                                        + rs2.getString("nazvanieIngradient") + ", ");
                            }
                        }
                    }
                    blydo.setSpisokIngradientov(blydo.getSpisokIngradientov().
                            substring(0, (blydo.getSpisokIngradientov().length() - 2)));
                }
                listBlyd.add(blydo);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (stmt1 != null) {
                    stmt1.close();
                }
                if (stmt2 != null) {
                    stmt2.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listBlyd;
    }

    public static List<Sotrudnik> getStaff() {
        List<Sotrudnik> listSotrudnikov = new ArrayList<>();

        Connection dbConnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Statement stmt3 = null;
        ResultSet rs3 = null;

        try {
            stmt3 = dbConnection.createStatement();
            String sqlSotrudniki = "SELECT * FROM sotrudnik";
            rs3 = stmt3.executeQuery(sqlSotrudniki);
            while (rs3.next()) {
                //Retrieve by column name
                int idSotrudnika = rs3.getInt("idSotrudnik");
                String familiya = rs3.getString("familiya");
                String imya = rs3.getString("imya");
                Date datarojdeniya = rs3.getDate("daterojdeniya");
                int telefon = rs3.getInt("telefon");
                String doljnosty = rs3.getString("doljnosty");
                int oklad = rs3.getInt("oklad");
                Sotrudnik sotrudnik = new Sotrudnik(idSotrudnika, familiya, imya, datarojdeniya, telefon, doljnosty, oklad);
                listSotrudnikov.add(sotrudnik);
            }

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {//Handle errors for Class.forName
            e.printStackTrace();
        } finally {//finally block used to close resources
            try {
                if (rs3 != null) {
                    rs3.close();
                }
                if (stmt3 != null) {
                    stmt3.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listSotrudnikov;
    }

    public static List<Ingredient> getStock() {
        List<Ingredient> listIngredient = new ArrayList<>();
        Map<Integer, String> nazvaniya = new HashMap<>();

        Connection dbConnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Statement stmt = null;
        ResultSet rs = null;

        Statement stmt3 = null;
        ResultSet rs3 = null;

        try {
            stmt = dbConnection.createStatement();
            String sqlIngredient = "SELECT * FROM ingradient";
            rs = stmt.executeQuery(sqlIngredient);
            while (rs.next()) {
                //Retrieve by column name
                int ingradientID = rs.getInt("idIngradient");
                String nazvanie = rs.getString("nazvanieIngradient");
                nazvaniya.put(ingradientID, nazvanie);
            }


            stmt3 = dbConnection.createStatement();
            String sqlStock = "SELECT * FROM sklad";
            rs3 = stmt3.executeQuery(sqlStock);
            while (rs3.next()) {
                //Retrieve by column name
                int ingradientID = rs3.getInt("ingradient");
                int kolichestvo = rs3.getInt("kolichestvo");
                String nazvanie = new String();
                for (Map.Entry<Integer, String> ingradient : nazvaniya.entrySet()) {
                    if (ingradient.getKey() == ingradientID) {
                        nazvanie = ingradient.getValue();
                    }
                }
                Ingredient ingr = new Ingredient(ingradientID, nazvanie, kolichestvo);
                listIngredient.add(ingr);
            }

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {//Handle errors for Class.forName
            e.printStackTrace();
        } finally {//finally block used to close resources
            try {
                if (rs3 != null) {
                    rs3.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (stmt3 != null) {
                    stmt3.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listIngredient;
    }

    public static List<Order> getOrderHistory() {
        List<Order> listOrders = new ArrayList<>();
        Map<Integer, String> waiters = new HashMap<>();

        Connection dbConnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Statement stmt = null;
        ResultSet rs = null;

        Statement stmt3 = null;
        ResultSet rs3 = null;

        try {
            stmt = dbConnection.createStatement();
            String sqlWaiters = "SELECT * FROM sotrudnik";
            rs = stmt.executeQuery(sqlWaiters);
            while (rs.next()) {
                //Retrieve by column name
                int sotrudnikID = rs.getInt("idSotrudnik");
                String familiya = rs.getString("familiya");
                String imya = rs.getString("imya");
                waiters.put(sotrudnikID, familiya + " " + imya);
            }


            stmt3 = dbConnection.createStatement();
            String sqlZakaz = "SELECT * FROM zakaz";
            rs3 = stmt3.executeQuery(sqlZakaz);
            while (rs3.next()) {
                //Retrieve by column name
                int zakazID = rs3.getInt("idZakaz");
                int oficiant = rs3.getInt("oficiant");
                int stolik = rs3.getInt("stolik");
                Date date = rs3.getDate("data");
                String name = new String();
                for (Map.Entry<Integer, String> zakaz : waiters.entrySet()) {
                    if (zakaz.getKey() == oficiant) {
                        name = zakaz.getValue();
                    }
                }
                Order order = new Order(zakazID, name, stolik, date);
                listOrders.add(order);
            }

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {//Handle errors for Class.forName
            e.printStackTrace();
        } finally {//finally block used to close resources
            try {
                if (rs3 != null) {
                    rs3.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (stmt3 != null) {
                    stmt3.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listOrders;
    }

    public static void updateSotrudnik(Sotrudnik s) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlSotrudniki = "UPDATE sotrudnik SET familiya ='" + s.familiya +
                    "', imya ='" + s.imya + "', daterojdeniya ='" + s.datarojdeniya + "', telefon =" + s.telefon +
                    ", doljnosty ='" + s.doljnosty + "', oklad =" + s.oklad + " WHERE idsotrudnik = " + s.idSotrudnika;
            statement.execute(sqlSotrudniki);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void deleteSotrudnik(int idSotrudnika) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlSotrudnik = "DELETE FROM sotrudnik WHERE idsotrudnik = " + idSotrudnika;
            statement.execute(sqlSotrudnik);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void createSotrudnik(Sotrudnik sotrudnik) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlSotrudnik = "INSERT INTO sotrudnik " +
                    "VALUES ('" + sotrudnik.idSotrudnika + "', '" + sotrudnik.familiya + "', '" + sotrudnik.imya + "', '" + sotrudnik.datarojdeniya +
                    "', " + sotrudnik.telefon + ", '" + sotrudnik.doljnosty + "', " + sotrudnik.oklad + ")";
            statement.execute(sqlSotrudnik);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void deleteDish(int iddish) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlDish = "DELETE FROM ingradienti_blyda WHERE idblydo = " + iddish;
            statement.execute(sqlDish);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlDish = "DELETE FROM blydo WHERE idblydo = " + iddish;
            statement.execute(sqlDish);

//            String sqlDish = "DELETE FROM blydo bl USING ingradienti_blyda ibl" +
//                    " WHERE bl.idblydo = ibl.idblydo AND ibl.idblydo = " + iddish;

//            String sqlIngradientDish = "DELETE FROM ingradienti_blyda WHERE idblyda = " + iddish;
//            statement1.execute(sqlIngradientDish);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void createDish(Blydo blydo) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlBlydo = "INSERT INTO blydo " +
                    "VALUES (" + blydo.idBlydo + ", '" + blydo.nazvanie + "', '" + blydo.kategoriya +
                    "', " + blydo.stoimost + ", " + blydo.ves + ")";
            statement.execute(sqlBlydo);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
        updateDish(blydo);
    }

    public static void updateDish(Blydo b) {
        Map<Integer, String> ingredients = new HashMap<>();
        Map<Integer, String> newIngradients = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlBlydo = "UPDATE blydo SET nazvanie ='" + b.nazvanie + "', kategoriya ='" + b.kategoriya +
                    "', stoimost =" + b.stoimost + ", ves =" + b.ves + " WHERE idblydo = " + b.idBlydo;
            statement.execute(sqlBlydo);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            String sqlSelectIngradient = "SELECT * FROM ingradient";
            try (ResultSet rs = statement.executeQuery(sqlSelectIngradient);) {
                while (rs.next()) {
                    //Retrieve by column name
                    int ingradientID = rs.getInt("idIngradient");
                    String nazvanie = rs.getString("nazvanieIngradient");
                    ingredients.put(ingradientID, nazvanie);
                }
            }
        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }

        List<String> spisokNazvaniy = new ArrayList<>();
        for (int i = 0; i < b.getSpisokIngradientov().length(); i++) {
            if (!(b.getSpisokIngradientov().toLowerCase().charAt(i) >= 'a' &&
                    b.getSpisokIngradientov().toLowerCase().charAt(i) <= 'z')) {
                continue;
            }
            String temp = "";
            while (i < b.getSpisokIngradientov().length() && b.getSpisokIngradientov().toLowerCase().charAt(i) >= 'a' &&
                    b.getSpisokIngradientov().toLowerCase().charAt(i) <= 'z') {
                temp = temp + b.getSpisokIngradientov().toLowerCase().charAt(i);
                i++;
            }
            spisokNazvaniy.add(temp);
        }
        int idValue = ingredients.size();
        for (String nazvanie : spisokNazvaniy) {
            boolean flag = true;
            for (Map.Entry<Integer, String> ingredient : ingredients.entrySet()) {
                if (nazvanie.toLowerCase().equals(ingredient.getValue().toLowerCase())) {
                    flag = false;
                }
            }
            if (flag) {
                idValue++;
                newIngradients.put(idValue, nazvanie);
            }
        }
        for (Map.Entry<Integer, String> ingredient : newIngradients.entrySet()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement statement = connection.createStatement()) {
                String sqlInsertNewIngradients = "INSERT INTO ingradient VALUES (" + ingredient.getKey() + ", '" +
                        ingredient.getValue().toLowerCase() + "')";
                statement.execute(sqlInsertNewIngradients);
            } catch (SQLException se) {//Handle errors for JDBC
                se.printStackTrace();
            }
        }

        List<IngradientBlyda> ingradientsBlyda = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            String sqlSelectIngradient = "SELECT * FROM ingradienti_blyda";
            try (ResultSet rs = statement.executeQuery(sqlSelectIngradient);) {
                while (rs.next()) {
                    //Retrieve by column name
                    int idBlyda = rs.getInt("idblydo");
                    int idIngradienta = rs.getInt("idingradienta");
                    int idIngradientBlyda = rs.getInt("idingradientblyda");
                    IngradientBlyda ingradientBlyda = new IngradientBlyda(idBlyda, idIngradienta, idIngradientBlyda);
                    ingradientsBlyda.add(ingradientBlyda);
                }
            }
        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }

        int idIngradientBlyda = ingradientsBlyda.size();
        for (String ingredient : spisokNazvaniy) {
            boolean flag = true;
            String ingradientName = null;
            for (IngradientBlyda ingradientBlyda : ingradientsBlyda) {
                for (Map.Entry<Integer, String> oldIngredient : ingredients.entrySet()) {
                    if (ingradientBlyda.idIngradienta == oldIngredient.getKey()) {
                        ingradientName = oldIngredient.getValue();
                    }
                }
                for (Map.Entry<Integer, String> newIngredient : newIngradients.entrySet()) {
                    if (ingradientBlyda.idIngradienta == newIngredient.getKey()) {
                        ingradientName = newIngredient.getValue();
                    }
                }
                if (ingredient.toLowerCase().equals(ingradientName.toLowerCase())
                        && b.getIdBlydo() == ingradientBlyda.idBlyda) {
                    flag = false;
                }
            }
            if (flag) {
                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                     Statement statement = connection.createStatement()) {
                    idIngradientBlyda++;
                    int idIngradienta = -1;
                    for (Map.Entry<Integer, String> oldIngredient : ingredients.entrySet()) {
                        if (ingredient.toLowerCase().equals(oldIngredient.getValue().toLowerCase())) {
                            idIngradienta = oldIngredient.getKey();
                        }
                    }
                    for (Map.Entry<Integer, String> newIngredient : newIngradients.entrySet()) {
                        if (ingredient.toLowerCase().equals(newIngredient.getValue().toLowerCase())) {
                            idIngradienta = newIngredient.getKey();
                        }
                    }
                    String sqlInsertNewIngradient = "INSERT INTO ingradienti_blyda VALUES (" + b.getIdBlydo() +
                            ", " + idIngradienta + ", " + idIngradientBlyda + ")";
                    statement.execute(sqlInsertNewIngradient);
                } catch (SQLException se) {//Handle errors for JDBC
                    se.printStackTrace();
                }
            }
        }
    }

    public static void deleteStock(int idIngradient, String name) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            List<Blydo> listBlyd = dbUpdate();
            boolean flag = true;
            for (Blydo blydo : listBlyd) {
                if (blydo.getSpisokIngradientov().toLowerCase().contains(name.toLowerCase())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                String sqlStock = "DELETE FROM sklad WHERE ingradient = " + idIngradient;
                statement.execute(sqlStock);
                String sglIng = "DELETE FROM ingradient WHERE idingradient = " + idIngradient;
                statement.execute(sglIng);
            } else {
                String sqlStock = "UPDATE sklad SET kolichestvo = 0" +
                        " WHERE ingradient = " + idIngradient;
                statement.execute(sqlStock);
            }
        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public static void updateStock(Ingredient ingredient) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            String sqlStock = "UPDATE sklad SET kolichestvo =" + ingredient.quantity +
                    " WHERE ingradient = " + ingredient.idIngradient;
            statement.execute(sqlStock);

        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }
    }


    public static void addStock(Ingredient ingredient) {
        Map<Integer, String> ingredients = new HashMap<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            String sqlSelectIngradient = "SELECT * FROM ingradient";
            try (ResultSet rs = statement.executeQuery(sqlSelectIngradient);) {
                while (rs.next()) {
                    //Retrieve by column name
                    Integer idIngr = Integer.valueOf(rs.getString("idingradient"));
                    String nameIngr = rs.getString("nazvanieingradient");
                    ingredients.put(idIngr, nameIngr);
                }
            }
        } catch (SQLException se) {//Handle errors for JDBC
            se.printStackTrace();
        }

        if (ingredients.get(ingredient.idIngradient) == null) {
            for (Map.Entry<Integer, String> element : ingredients.entrySet()) {
                if (element.getValue().equals(ingredient.name)) {
                    return;
                }
            }
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement statement = connection.createStatement()) {

                String sqlAddNewIngredient = "INSERT INTO ingradient " +
                        "VALUES (" + ingredient.idIngradient
                        + ", '" + ingredient.name + "')";
                statement.execute(sqlAddNewIngredient);

            } catch (SQLException se) {//Handle errors for JDBC
                se.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement statement = connection.createStatement()) {

                String sqlStock = "INSERT INTO sklad " +
                        "VALUES (" + ingredient.idIngradient
                        + ", " + ingredient.quantity + ")";
                statement.execute(sqlStock);

            } catch (SQLException se) {//Handle errors for JDBC
                se.printStackTrace();
            }
        }
    }
}