import java.sql.Date;

public class Order {

    int idZakaz;
    String oficiant;
    int stolik;
    Date date;

    public Order(int idZakaz, String oficiant, int stolik, Date date) {
        this.idZakaz = idZakaz;
        this.oficiant = oficiant;
        this.stolik = stolik;
        this.date = date;
    }

    public int getIdZakaz() {
        return idZakaz;
    }

    public void setIdZakaz(int idZakaz) {
        this.idZakaz = idZakaz;
    }

    public String getOficiant() {
        return oficiant;
    }

    public void setOficiant(String oficiant) {
        this.oficiant = oficiant;
    }

    public int getStolik() {
        return stolik;
    }

    public void setStolik(int stolik) {
        this.stolik = stolik;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
