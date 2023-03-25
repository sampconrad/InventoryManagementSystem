public class Clothing extends Product {
  private String size;
  private String material;

  public Clothing(String name, double price, String category, boolean onSale, String size, String material) {
      super(name, price, category, onSale);
      this.size = size.toLowerCase();
      this.material = material.toLowerCase();
  }

  public String getSize() {
      return size;
  }

  public void setSize(String size) {
      this.size = size;
  }

  public String getMaterial() {
      return material;
  }

  public void setMaterial(String material) {
      this.material = material;
  }

  @Override
  public String toString() {
      return "Vestuario{" +
              "nome='" + getName() + '\'' +
              ", preco=" + getPrice() +
              ", categoria='" + getCategory() + '\'' +
              ", promocao=" + isOnSale() +
              ", tamanho='" + size + '\'' +
              ", material='" + material + '\'' +
              '}';
  }
}
