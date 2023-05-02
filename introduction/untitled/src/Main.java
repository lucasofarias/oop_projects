import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Product> productList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char menuOption;

        do {
            Product product = new Product();

            menuOption = showMenuAndSelectOption();

            switch (menuOption) {
                case '1' -> {
                    product.setId(generateId());

                    System.out.print("Entre com o nome do produto: ");
                    product.setName(sc.next());

                    System.out.print("Entre com o preço do produto: $");
                    product.setPrice(sc.nextFloat());

                    System.out.print("Entre com o estoque do produto: ");
                    product.setStock(sc.nextInt());

                    System.out.println("Produto ativo?");
                    System.out.println("1) Sim");
                    System.out.println("2) Não");
                    System.out.print("-> ");

                    char isProductActive = enterConfirmCharacter();

                    product.setActive(isProductActive == '1');

                    productList.add(product);
                }

                case '2' -> listProducts();

                case '3' -> {
                    if (isProductListEmpty()) {
                        System.out.println("Atenção: não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Visualização de um produto");
                    System.out.println("--------------------------");
                    System.out.println();

                    System.out.print("Entre com o ID do produto: ");
                    Integer productId = sc.nextInt();

                    product = getProduct(productId);

                    if (product == null) {
                        System.out.println("O produto com o ID " + productId + " não foi encontrado.");
                        break;
                    }

                    System.out.println(product);
                }

                case '4' -> {
                    if (isProductListEmpty()) {
                        System.out.println("Atenção: Não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Alterar de um produto");
                    System.out.println("--------------------------");
                    System.out.println();

                    System.out.print("Entre com o ID do produto: ");
                    Integer productId = sc.nextInt();

                    product = getProduct(productId);

                    if (product == null) {
                        System.out.println("O produto com o ID " + productId + " não foi encontrado.");
                        break;
                    }

                    System.out.println(product.toString());

                    updateProduct(product);

                    System.out.println("O produto foi alterado com sucesso!");
                }

                case '5' -> {
                    if (isProductListEmpty()) {
                        System.out.println("Atenção: Não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Deletar de um produto");
                    System.out.println("--------------------------");
                    System.out.println();

                    System.out.print("Entre com o ID do produto: ");
                    Integer productId = sc.nextInt();

                    product = getProduct(productId);

                    if (product == null) {
                        System.out.println("O produto com ID " + productId + " não foi encontrado.");
                        break;
                    }

                    char deleteProductQuestion = enterConfirmCharacter();

                    if (deleteProductQuestion == '1') {
                        productList.remove(product);
                        System.out.println("O produto foi deletado com sucesso!");
                    }
                }

                case 9 -> System.out.println("Saindo do sistema...");

                default -> {
                    System.out.println();
                    System.out.println("Atenção: A opção que você tentou entrar não existe.");
                    System.out.println();
                }
            }

        } while(menuOption != '9');
    }

    public static char showMenuAndSelectOption() {
        System.out.println("Gerenciamento de Produtos");
        System.out.println("-------------------------");
        System.out.println();

        System.out.println("1) Adicionar um produto");
        System.out.println("2) Listar seus produtos");
        System.out.println("3) Visualizar um produto");
        System.out.println("4) Alterar um produto");
        System.out.println("5) Excluir um produto");
        System.out.println("9) Sair");
        System.out.println();

        System.out.print("-> ");
        char menuOption = sc.next().charAt(0);

        return menuOption;
    }

    public static char enterConfirmCharacter() {
        char character = sc.next().charAt(0);

        while (character != '1' && character != '2') {
            System.out.println("Atenção: entre apenas com os caracteres '1' para sim ou '2' para não.");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("-> ");

            character = sc.next().charAt(0);
        }

        return character;
    }

    public static Integer generateId() {
        if (isProductListEmpty()) {
            return 1;
        }

        return productList.get(productList.size() - 1).getId() + 1;
    }

    public static boolean isProductListEmpty() {
        return productList.isEmpty();
    }

    public static void listProducts() {
        if (productList.isEmpty()) {
            System.out.println("Atenção: Não há produtos cadastrados no sistema.");
        }

        else {
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
    }

    public static Product getProduct(Integer productId) {
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                System.out.println("Produto encontrado:");
                System.out.println();

                return product;
            }
        }

        return null;
    }

    public static void updateProduct(Product product) {
        System.out.print("Entre com o nome do produto: ");
        product.setName(sc.next());

        System.out.print("Entre com o preço do produto: $");
        product.setPrice(sc.nextFloat());

        System.out.print("Entre com o estoque do produto: ");
        product.setStock(sc.nextInt());

        System.out.println("Produto ativo?");
        System.out.println("1) Sim");
        System.out.println("2) Não");
        System.out.print("-> ");

        char isProductActive = sc.next().charAt(0);

        while (isProductActive != '1' && isProductActive != '2') {
            System.out.println();
            System.out.println("Atenção: entre apenas com os caracteres '1' para sim ou '2' para não.");
            System.out.println();

            System.out.println("Produto ativo?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("-> ");

            isProductActive = sc.next().charAt(0);
        }

        product.setActive(isProductActive == '1');
    }

}