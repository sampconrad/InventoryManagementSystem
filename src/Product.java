public class Product {
  private String name;
  private double price;
  private String category;
  private boolean onSale;

  public Product(String name, double price, String category, boolean onSale) {
      this.name = name.toLowerCase();
      this.price = price;
      this.category = category.toLowerCase();
      this.onSale = onSale;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public double getPrice() {
      return price;
  }

  public void setPrice(double price) {
      this.price = price;
  }

  public String getCategory() {
      return category;
  }

  public void setCategory(String category) {
      this.category = category;
  }

  public boolean isOnSale() {
      return onSale;
  }

  public void setOnSale(boolean onSale) {
      this.onSale = onSale;
  }

  @Override
  public String toString() {
      return "Produto{" +
              "nome='" + name + '\'' +
              ", preco=" + price +
              ", categoria='" + category + '\'' +
              ", promocao=" + onSale +
              '}';
  }
}
