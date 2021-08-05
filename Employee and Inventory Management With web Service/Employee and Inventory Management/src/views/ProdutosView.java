package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.ProdutoController;
import entities.Produto;

public class ProdutosView implements View {
  private Scanner input;
  private ProdutoController controller;

  public ProdutosView(Scanner input, ProdutoController controller) {
    this.input = input;
    this.controller = controller;
  }

  @Override
  public void run() {
    int option = -1;
    while (option != 0) {
      option = 0;

      System.out.println("");
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Listar produtos");
      System.out.println("2 - Cadastrar produto");
      System.out.println("3 - Editar produto");
      System.out.println("4 - Excluir produto");
      System.out.println("0 - Sair");

      boolean error = true;
      while (error) {
        try {
          option = input.nextInt();
          error = false;
        } catch (InputMismatchException e) {
          System.out.println("Opção inválida, tente novamente.");
          input.nextLine();
          error = true;
        }
      }

      switch (option) {
      case 0:
        break;
      case 1:
        listProdutos();
        break;
      case 2:
        insertProduto();
        break;
      case 3:
        editProduto();
        break;
      case 4:
        deleteProduto();
        break;
      default:
        System.out.println("Opção inválida, tente novamente.");
      }
    }
  }

  private void listProdutos() {
    System.out.println("Lista de produtos:");

    if (controller.count() <= 0) {
      System.out.println("Nenhum produto foi cadastrado.");
      return;
    }

    for (Produto produto : controller.getAll()) {
      System.out.println("------------------------");
      System.out.println("ID: " + produto.getID());
      System.out.println("Nome: " + produto.getNome());
      System.out.println("Quantidade: " + produto.getQuantidade());
      System.out.println("Preço: " + produto.getPreco());
    }
  }

  private void insertProduto() {
    String nome = "";
    int quantidade = 0;
    float preco = 0;

    input.nextLine();
    System.out.println("Informe o nome do produto");
    nome = input.nextLine();

    boolean errorQuantidade = true;
    while (errorQuantidade) {
      try {
        System.out.println("Informe a quantidade do produto");
        quantidade = input.nextInt();
        errorQuantidade = false;
      } catch (InputMismatchException e) {
        System.out.println("Valor não suportado, tente novamente.");
        input.nextLine();
        errorQuantidade = true;
      }
    };

    boolean errorPreco = true;
    while (errorPreco) {
      try {
        System.out.println("Informe o preco do produto");
        preco = input.nextFloat();
        errorPreco = false;
      } catch (InputMismatchException e) {
        System.out.println("Valor não suportado, tente novamente.");
        input.nextLine();
        errorPreco = true;
      }
    };

    controller.insert(new Produto(nome, quantidade, preco));
    System.out.println("Produto cadastrado com sucesso!");
  }

  private void editProduto() {
    if (controller.getAll().isEmpty()) {
      System.out.println("Nenhum produto foi cadastrado.");
      return;
    }

    Produto produto = pickProduto("editar");
    boolean errorQuantidade = true;
    while (errorQuantidade) {
      try {
        System.out.println("Informe a nova quantidade:");
        produto.setQuantidade(input.nextInt());
        errorQuantidade = false;
      } catch (InputMismatchException e) {
        System.out.println("Valor não suportado, tente novamente.");
        input.nextLine();
        errorQuantidade = true;
      }
    };

    boolean errorPreco = true;
    while (errorPreco) {
      try {
        System.out.println("Informe o novo preço:");
        produto.setPreco(input.nextFloat());
        errorPreco = false;
      } catch (InputMismatchException e) {
        System.out.println("Valor não suportado, tente novamente.");
        input.nextLine();
        errorPreco = true;
      }
    };

    controller.update(produto);
    System.out.println("Produto atualizado com sucesso!");
  }

  private void deleteProduto() {
    if (controller.getAll().isEmpty()) {
      System.out.println("Nenhum produto foi cadastrado.");
      return;
    }

    Produto produto = pickProduto("excluir");
    controller.delete(produto.getID());
    System.out.println("Produto excluído com sucesso!");
  }

  private Produto pickProduto(String action) {
    Produto produto = null;
    int id = 0;
    boolean produtoExists = false;
    while (!produtoExists) {
      boolean errorId = true;
      while (errorId) {
        try {
          System.out.println("Informe o ID do produto que deseja " + action + ":");
          id = input.nextInt();
          errorId = false;
          produto = controller.findById(id);

          if (produto == null) {
            errorId = true;
            System.out.println("Não foi encontrado um produto com este ID, tente novamente.");
            continue;
          }

          produtoExists = true;
        } catch (InputMismatchException e) {
          System.out.println("Valor não encontrado, tente novamente.");
          input.nextLine();
          errorId = true;
        }
      };
    }

    input.nextLine();
    return produto;
  }
}
