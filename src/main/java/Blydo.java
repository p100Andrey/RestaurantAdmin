public class Blydo {

    int idBlydo;
    String nazvanie;
    String kategoriya;
    double stoimost;
    double ves;
    String spisokIngradientov = new String("");

    public Blydo(int idBlydo, String nazvanie, String kategoriya, double stoimost, double ves, String spisokIngradientov) {
        this.idBlydo = idBlydo;
        this.nazvanie = nazvanie;
        this.kategoriya = kategoriya;
        this.stoimost = stoimost;
        this.ves = ves;
        this.spisokIngradientov = spisokIngradientov;
    }

    public Blydo(int idBlydo, String nazvanie, String kategoriya, double stoimost, double ves) {
        this.idBlydo = idBlydo;
        this.nazvanie = nazvanie;
        this.kategoriya = kategoriya;
        this.stoimost = stoimost;
        this.ves = ves;
    }

    public Blydo(String nazvanie, String kategoriya, double stoimost, double ves) {
        this.idBlydo = idBlydo;
        this.nazvanie = nazvanie;
        this.kategoriya = kategoriya;
        this.stoimost = stoimost;
        this.ves = ves;
    }

    public String getSpisokIngradientov() {
        return spisokIngradientov;
    }

    public void setSpisokIngradientov(String spisokIngradientov) {
        this.spisokIngradientov = spisokIngradientov;
    }

    public int getIdBlydo() {
        return idBlydo;
    }

    public void setIdBlydo(int idBlydo) {
        this.idBlydo = idBlydo;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getKategoriya() {
        return kategoriya;
    }

    public void setKategoriya(String kategoriya) {
        this.kategoriya = kategoriya;
    }

    public double getStoimost() {
        return stoimost;
    }

    public void setStoimost(double stoimost) {
        this.stoimost = stoimost;
    }

    public double getVes() {
        return ves;
    }

    public void setVes(double ves) {
        this.ves = ves;
    }
}