import java.util.InputMismatchException;
import java.util.Scanner;
import utils.SoutUtils;

public class Main {
  public static void main(String[] args) {
    InventoryManagementSystem system = new InventoryManagementSystem();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    
    String red = SoutUtils.colorRed;
    String white = SoutUtils.resetColor;

    while (!exit) {
      try {
        int choice = system.printMenuAndGetChoice(scanner);

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
            System.out.println(red + "Encerrando..." + white);
            exit = true;
            break;
          default:
            System.out.println(red + "Opcao invalida. Tente novamente." + white);
            break;
        }
      } catch (InputMismatchException e) {
        scanner.next();
        System.out.println(red + "Opcao invalida. Tente novamente." + white);
      }
    }

    scanner.close();
  }
    
}
