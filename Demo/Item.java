package Demo;

public class Item {

    private static Integer quantity; // Assign to either member or methods
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Integer getQuantity() {
        return quantity;
    }

    public static void setQuantity(Integer quantity) {
        Item.quantity = quantity;
    }
     
}
