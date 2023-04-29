import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();
        char menuOption;

        do {
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
            menuOption = sc.next().charAt(0);

            Product product = new Product();

            switch (menuOption) {
                case '1':
                    if (productList.isEmpty()) {
                        product.setId(productList.size() + 1);
                    }

                    else {
                        for (int i = 0; i < productList.size(); i++) {
                            if (i == productList.size() - 1) {
                                Product lastProductOnList = productList.get(i);

                                product.setId(lastProductOnList.getId() + 1);
                            }
                        }
                    }

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
                        System.out.println("Atenção: entre apenas com o caractere '1' para sim ou '2' para não.");
                        System.out.println();

                        System.out.println("Produto ativo?");
                        System.out.println("1) Sim");
                        System.out.println("2) Não");
                        System.out.print("-> ");

                        isProductActive = sc.next().charAt(0);
                    }

                    product.setActive(isProductActive == '1');

                    productList.add(product);
                break;

                case '2':
                    if (productList.isEmpty()) {
                        System.out.println("Atenção: Não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Lista de produtos cadastrados");
                    System.out.println("-----------------------------");
                    System.out.println();

                    for (Product productModel : productList) {
                        System.out.println(productModel.toString());
                    }
                break;

                case '3':
                    if (productList.isEmpty()) {
                        System.out.println("Atenção: Não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Visualização de um produto");
                    System.out.println("--------------------------");
                    System.out.println();

                    System.out.print("Entre com o ID do produto: ");
                    Integer productId = sc.nextInt();

                    boolean productWasFound = false;

                    for (Product productModel : productList) {
                        if (productModel.getId().equals(productId)) {
                            productWasFound = true;

                            System.out.println("Produto encontrado:");
                            System.out.println();

                            System.out.println(productModel.toString());
                            break;
                        }
                    }

                    if (!productWasFound) {
                        System.out.println("O produto com ID " + productId + " não foi encontrado.");
                    }
                break;

                case '4':
                    if (productList.isEmpty()) {
                        System.out.println("Atenção: Não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Alterar de um produto");
                    System.out.println("--------------------------");
                    System.out.println();

                    System.out.print("Entre com o ID do produto: ");
                    productId = sc.nextInt();

                    productWasFound = false;

                    for (Product productModel : productList) {
                        if (productModel.getId().equals(productId)) {
                            productWasFound = true;

                            System.out.println("Produto encontrado:");
                            System.out.println();

                            System.out.println(productModel.toString());

                            System.out.print("Entre com o nome do produto: ");
                            productModel.setName(sc.next());

                            System.out.print("Entre com o preço do produto: $");
                            productModel.setPrice(sc.nextFloat());

                            System.out.print("Entre com o estoque do produto: ");
                            productModel.setStock(sc.nextInt());

                            System.out.println("Produto ativo?");
                            System.out.println("1) Sim");
                            System.out.println("2) Não");
                            System.out.print("-> ");

                            isProductActive = sc.next().charAt(0);

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

                            productModel.setActive(isProductActive == '1');
                            break;
                        }
                    }

                    if (!productWasFound) {
                        System.out.println("O produto com ID " + productId + " não foi encontrado.");
                    }
                break;

                case '5':
                    if (productList.isEmpty()) {
                        System.out.println("Atenção: Não há produtos cadastrados no sistema.");
                        break;
                    }

                    System.out.println("Deletar de um produto");
                    System.out.println("--------------------------");
                    System.out.println();

                    System.out.print("Entre com o ID do produto: ");
                    productId = sc.nextInt();

                    productWasFound = false;

                    for (Product productModel : productList) {
                        if (productModel.getId().equals(productId)) {
                            productWasFound = true;

                            System.out.println("Produto encontrado:");
                            System.out.println();

                            System.out.println(productModel.toString());

                            System.out.println("Tem certeza de quer quer deletar esse produto?");
                            System.out.println("1) Sim");
                            System.out.println("2) Não");
                            System.out.print("-> ");

                            char deleteProductQuestion = sc.next().charAt(0);

                            while (deleteProductQuestion != '1' && deleteProductQuestion != '2') {
                                System.out.println("Atenção: entre apenas com os caracteres '1' para sim ou '2' para não.");
                                System.out.println("1) Sim");
                                System.out.println("2) Não");
                                System.out.print("-> ");

                                deleteProductQuestion = sc.next().charAt(0);
                            }

                            if (deleteProductQuestion == '1') {
                                productList.remove(productModel);
                                System.out.println("O produto foi deletado com sucesso!");

                                break;
                            }
                        }
                    }

                    if (!productWasFound) {
                        System.out.println("O produto com ID " + productId + " não foi encontrado.");
                    }
                break;

                default:
                    System.out.println();
                    System.out.println("Atenção: A opção que você tentou entrar não existe.");
                    System.out.println();
                break;
            }

        } while(menuOption != '9');

        sc.close();
    }

}