public class Ingredient {

    int idIngradient;
    String name;
    int quantity;

    public Ingredient(int idIngradient, String name, int quantity) {
        this.idIngradient = idIngradient;
        this.name = name;
        this.quantity = quantity;
    }

    public String getIdIngradient() {
        return String.valueOf(idIngradient);
    }

    public void setIdIngradient(int idIngradient) {
        this.idIngradient = idIngradient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
