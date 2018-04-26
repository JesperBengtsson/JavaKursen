public class Item {

    private String artNumber;
    private int price;
    private String description;

    public Item(String artNumber, int price, String description) {
        this.artNumber = artNumber;
        this.price = price;
        this.description = description;
    }
    public String getArtNumber() {
        return artNumber;
    }
    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString () {
        return ("Art.nr: " + artNumber + "\n" + "Price: " + price + "kr" + "\n" + "Description: " + description + "\n");
    }
}