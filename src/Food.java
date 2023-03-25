public class Food extends Product {
  private String type;
  private boolean isNatural;

  public Food(String name, double price, String category, boolean onSale, String type, boolean isNatural) {
      super(name, price, category, onSale);
      this.type = type.toLowerCase();
      this.isNatural = isNatural;
  }

  public String getType() {
      return type;
  }

  public void setType(String type) {
      this.type = type;
  }

  public boolean isNatural() {
      return isNatural;
  }

  public void setNatural(boolean natural) {
      isNatural = natural;
  }

  @Override
  public String toString() {
      return "Alimentos{" +
              "nome='" + getName() + '\'' +
              ", preco=" + getPrice() +
              ", categoria='" + getCategory() + '\'' +
              ", promocao=" + isOnSale() +
              ", tipo='" + type + '\'' +
              ", organico=" + isNatural +
              '}';
  }
}
