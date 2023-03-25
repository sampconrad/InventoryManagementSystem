import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;


public class InventoryManagementSystem {
    private List<Product> products;
    private Scanner scanner;

    public InventoryManagementSystem() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // MENU
    public int printMenuAndGetChoice(Scanner scanner) {
        System.out.println("Bem vindo ao Sistema de Gerenciamento de Inventario");
        System.out.println("Selecione uma opcao:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Atualizar produto");
        System.out.println("3. Remover produto");
        System.out.println("4. Listar todos os produtos");
        System.out.println("5. Procurar produtos por nome");
        System.out.println("6. Procurar produtos por categoria");
        System.out.println("7. Procurar produtos por preco");
        System.out.println("8. Sair");
        System.out.print("Digite o numero da opcao: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    

    // CREATE
    public void addProductFromUserInput() {
        try {
            System.out.println("Adicionando novo produto ao estoque:");
            System.out.print("Nome (Ex: ThinkPad): ");
            String name = scanner.nextLine();
            System.out.print("Preco (Ex: 999): ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Categoria (Eletronicos, Alimentos, Vestuario): ");
            String category = scanner.nextLine();
            System.out.print("Promocao? (true/false): ");
            boolean isOnSale = scanner.nextBoolean();
            scanner.nextLine();
            String brand = "";
            int voltage = 0;
            String size = "";
            String material = "";
            String type = "";
            boolean isNatural = false;
            if (category.equalsIgnoreCase("Eletronicos")) {
                System.out.print("Fabricante (Ex: IBM): ");
                brand = scanner.nextLine();
                System.out.print("Voltagem (Ex: 220): ");
                voltage = scanner.nextInt();
                scanner.nextLine();
            } else if (category.equalsIgnoreCase("Vestuario")) {
                System.out.print("Tamanho (Ex: GG): ");
                size = scanner.nextLine();
                System.out.print("Material (Ex: Algodao): ");
                material = scanner.nextLine();
            } else if (category.equalsIgnoreCase("Alimentos")) {
                System.out.print("Tipo (Ex: Fruta): ");
                type = scanner.nextLine();
                System.out.print("Organico? (true/false): ");
                isNatural = scanner.nextBoolean();
                scanner.nextLine();
            } else {
                throw new IllegalArgumentException("Categoria" + category + "invalida.");
            }
            Product product;
            if (category.equalsIgnoreCase("Eletronicos")) {
                product = new Electronics(name, price, category, isOnSale, brand, voltage);
            } else if (category.equalsIgnoreCase("Vestuario")) {
                product = new Clothing(name, price, category, isOnSale, size, material);
            } else {
                product = new Food(name, price, category, isOnSale, type, isNatural);
            }
            if (isOnSale) {
                product.setPrice(product.getPrice() * 0.9);
                product.setOnSale(true);
            }
            products.add(product);
            System.out.println("Produto " + name +  " adicionado ao estoque.");
        } catch (InputMismatchException e) {
            System.out.println("Input invalido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE
    public void updateProductFromUserInput() {
        String tempName = "";
        try {
            System.out.println("Atualizar produto em estoque:");
            System.out.print("Nome do produto a ser atualizado: ");
            String name = scanner.nextLine();
            tempName = name;
            Product productToUpdate = getExactProductByName(name);
            if (productToUpdate == null) {
                System.out.println("Produto " + name + " nao encontrado.");
                return;
            }
            System.out.println("Informacoes atuais do produto:");
            System.out.println(productToUpdate.toString());
            System.out.println("Digite novas informacoes (Enter para manter o valor atual):");
            System.out.print("Nome [" + productToUpdate.getName() + "]: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                productToUpdate.setName(newName);
            }
            System.out.print("Preco [" + productToUpdate.getPrice() + "]: ");
            String newPriceString = scanner.nextLine();
            if (!newPriceString.isEmpty()) {
                double newPrice = Double.parseDouble(newPriceString);
                productToUpdate.setPrice(newPrice);
            }

            // TENTAR MUDAR A CATEGORIA DO PRODUTO QUEBRA TUDO! ESQUECE DISSO!!!
            // System.out.print("Enter product category [" + productToUpdate.getCategory() + "]: ");
            // String newCategory = scanner.nextLine();
            // if (!newCategory.isEmpty()) {
            //     productToUpdate.setCategory(newCategory);
            // }

            System.out.print("Promocao? [" + productToUpdate.isOnSale() + "]: ");
            String newOnSaleString = scanner.nextLine();
            if (!newOnSaleString.isEmpty()) {
                boolean newOnSale = Boolean.parseBoolean(newOnSaleString);
                productToUpdate.setOnSale(newOnSale);
                if (newOnSale) {
                    productToUpdate.setPrice(productToUpdate.getPrice() * 0.9);
                }
            }
            if (productToUpdate instanceof Electronics) {
                Electronics electronics = (Electronics) productToUpdate;
                System.out.print("Fabricante [" + electronics.getBrand() + "]: ");
                String newBrand = scanner.nextLine();
                if (!newBrand.isEmpty()) {
                    electronics.setBrand(newBrand);
                }
                System.out.print("Voltagem [" + electronics.getVoltage() + "]: ");
                String newVoltageString = scanner.nextLine();
                if (!newVoltageString.isEmpty()) {
                    int newVoltage = Integer.parseInt(newVoltageString);
                    electronics.setVoltage(newVoltage);
                }
            } else if (productToUpdate instanceof Clothing) {
                Clothing clothing = (Clothing) productToUpdate;
                System.out.print("Tamanho [" + clothing.getSize() + "]: ");
                String newSize = scanner.nextLine();
                if (!newSize.isEmpty()) {
                    clothing.setSize(newSize);
                }
                System.out.print("Material [" + clothing.getMaterial() + "]: ");
                String newMaterial = scanner.nextLine();
                if (!newMaterial.isEmpty()) {
                    clothing.setMaterial(newMaterial);
                }
            } else if (productToUpdate instanceof Food) {
                Food food = (Food) productToUpdate;
                System.out.print("Tipo [" + food.getType() + "]: ");
                String newType = scanner.nextLine();
                if (!newType.isEmpty()) {
                    food.setType(newType);
                }
                System.out.print("Organico? [" + food.isNatural() + "]: ");
                String newIsNaturalString = scanner.nextLine();
                if (!newIsNaturalString.isEmpty()) {
                    boolean newIsNatural = Boolean.parseBoolean(newIsNaturalString);
                    food.setNatural(newIsNatural);
                }
            }
        } catch (NumberFormatException e) {
        System.out.println("Input invalido. Digite um numero");
    } catch (NullPointerException e) {
        System.out.println("Produto " + tempName +  " nao encontrado");
    }
}

    // DELETE
    public void removeProductFromUserInput() {
        System.out.println("Remover produto do estoque:");
        System.out.print("Nome do produto a ser removido: ");
        String name = scanner.nextLine();
        Product productToRemove = getExactProductByName(name);
        if (productToRemove == null) {
            System.out.println("Produto " + name + " nao encontrado.");
            return;
        }
        products.remove(productToRemove);
        System.out.println("Produto " + name + " removido do estoque.");
    }

    // LISTAR TODOS OS PRODUTOS
    public void listProducts() {
        System.out.println("Lista de produtos em estoque:");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    // LISTAR POR NOME
    public void searchByNameFromUserInput() {
        System.out.println("Procurando produto por nome:");
        System.out.print("Nome do produto a procurar: ");
        String name = scanner.nextLine();
        List<Product> matchingProducts = getAllProductsContaining(name);
        if (matchingProducts.isEmpty()) {
            System.out.println("Produto " + name + " nao encontrado");
            return;
        }
        System.out.println("Produto encontrado:");
        for (Product product : matchingProducts) {
            System.out.println(product.toString());
        }
    }

    // LISTAR POR CATEGORIA
    public void searchByCategoryFromUserInput() {
        System.out.println("Procurando produto por categoria:");
        System.out.print("Nome da categoria a procurar (Eletronicos, Vestuario, Alimentos): ");
        String category = scanner.nextLine();
        if (!isValidCategory(category)) {
            System.out.println("Categoria " + category + " invalida");
            return;
        }
        List<Product> matchingProducts = getProductsByCategory(category);
        if (matchingProducts.isEmpty()) {
            System.out.println("Nenhum produto encontrado");
            return;
        }
        System.out.println("Produtos encontrados em " + category);
        for (Product product : matchingProducts) {
            System.out.println(product.toString());
        }
    }

    // LISTAR POR PREÇO
    public void searchByPriceFromUserInput() {
        double minPrice = 0;
        double maxPrice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Preco minimo: ");
                minPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Preco maximo: ");
                maxPrice = scanner.nextDouble();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input invalido. Digite um preco valido (Ex: 900)");
                scanner.nextLine(); // clear the scanner
            }
        }
        List<Product> productsInRange = getProductsByPriceRange(minPrice, maxPrice);
        if (productsInRange.isEmpty()) {
            System.out.println("Nenhum produto encontrado nessa faixa de preco" + "(" + minPrice + " - " + maxPrice + ")");
        } else {
            System.out.println("Produtos encontrados nessa faixa de preco" + "(" + minPrice + " - " + maxPrice + ")");
            for (Product product : productsInRange) {
                System.out.println(product.toString());
            }
        }
    }
    

    private List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> productsInRange = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                productsInRange.add(product);
            }
        }
        return productsInRange;
    }

    // CHECA SE A CATEGORIA É VALIDA
    private boolean isValidCategory(String category) {
        switch (category) {
            case "eletronicos":
            case "vestuario":
            case "alimentos":
                return true;
            default:
                return false;
        }
    }

    // PEGA TODOS OS PRODUTOS DE UMA CATEGORIA
    private List<Product> getProductsByCategory(String category) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    // PEGA TODOS OS PRODUTOS COM UM NOME
    private List<Product> getAllProductsContaining(String name) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    // PEGA O PRIMEIRO PRODUTO COM O NOME
    private Product getExactProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }


}



