import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    InventoryManagementSystem system = new InventoryManagementSystem();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
      // Print menu and get user choice
      int choice = system.printMenuAndGetChoice(scanner);

      // Handle user choice
      switch (choice) {
        case 1:
          system.addProductFromUserInput();
          break;
        case 2:
          system.updateProductFromUserInput();
          break;
        case 3:
          system.removeProductFromUserInput();
          break;
        case 4:
          system.listProducts();
          break;
        case 5:
          system.searchByNameFromUserInput();
          break;
        case 6:
          system.searchByCategoryFromUserInput();
          break;
        case 7:
          system.searchByPriceFromUserInput();
          break;
        case 8:
          System.out.println("Encerrando...");
          exit = true;
          break;
        default:
          System.out.println("Opcao invalida. Tente novamente.");
          break;
      }
    }

    scanner.close();
  }
    
}
