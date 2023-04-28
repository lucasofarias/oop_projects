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

            System.out.print("Selecione uma opção: ");
            menuOption = sc.next().charAt(0);

            Product product = new Product();

            switch (menuOption) {
                case '1':
                    product.setId(Long.valueOf(productList.size() + 1));

                    System.out.print("Entre com o nome do produto: ");
                    product.setName(sc.next());

                    System.out.print("Entre com o preço do produto: $");
                    product.setPrice(sc.nextFloat());

                    System.out.print("Entre com o estoque do produto: ");
                    product.setStock(sc.nextInt());

                    productList.add(product);
                    break;

                case '2':
                    if (productList.isEmpty()) {
                        System.out.println("Atenção: A lista de produtos está vazia.");
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
                    break;

                case '4':
                    break;

                case '5':
                    break;

                default:
                    break;
            }

        } while(menuOption != '9');
    }

}