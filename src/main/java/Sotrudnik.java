import java.sql.Date;

public class Sotrudnik {

    int idSotrudnika;
    String familiya;
    String imya;
    Date datarojdeniya;
    int telefon;
    String doljnosty;
    int oklad;

    public Sotrudnik(int idSotrudnika, String familiya, String imya, Date datarojdeniya, int telefon, String doljnosty, int oklad) {
        this.idSotrudnika = idSotrudnika;
        this.familiya = familiya;
        this.imya = imya;
        this.datarojdeniya = datarojdeniya;
        this.telefon = telefon;
        this.doljnosty = doljnosty;
        this.oklad = oklad;
    }

    public Sotrudnik(String familiya, String imya, Date datarojdeniya, int telefon, String doljnosty, int oklad) {
        this.familiya = familiya;
        this.imya = imya;
        this.datarojdeniya = datarojdeniya;
        this.telefon = telefon;
        this.doljnosty = doljnosty;
        this.oklad = oklad;
    }

    public String getIdSotrudnika() {
        return String.valueOf(idSotrudnika);
    }

    public void setIdSotrudnika(int idSotrudnika) {
        this.idSotrudnika = idSotrudnika;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public Date getDatarojdeniya() {
        return datarojdeniya;
    }

    public void setDatarojdeniya(Date datarojdeniya) {
        this.datarojdeniya = datarojdeniya;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getDoljnosty() {
        return doljnosty;
    }

    public void setDoljnosty(String doljnosty) {
        this.doljnosty = doljnosty;
    }

    public int getOklad() {
        return oklad;
    }

    public void setOklad(int oklad) {
        this.oklad = oklad;
    }
}
