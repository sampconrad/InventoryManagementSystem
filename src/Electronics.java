public class Electronics extends Product {
  private String brand;
  private int voltage;

  public Electronics(String name, double price, String category, boolean onSale, String brand, int voltage) {
      super(name, price, category, onSale);
      this.brand = brand.toLowerCase();
      this.voltage = voltage;
  }

  public String getBrand() {
      return brand;
  }

  public void setBrand(String brand) {
      this.brand = brand;
  }

  public int getVoltage() {
      return voltage;
  }

  public void setVoltage(int voltage) {
      this.voltage = voltage;
  }

  @Override
  public String toString() {
      return "Eletronicos{" +
              "nome='" + getName() + '\'' +
              ", preco=" + getPrice() +
              ", categoria='" + getCategory() + '\'' +
              ", promocao=" + isOnSale() +
              ", fabricante='" + brand + '\'' +
              ", voltagem=" + voltage +
              '}';
  }
}
