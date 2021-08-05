package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenuView implements View {
  private Scanner input;
  private FuncionariosView funcionariosView;
  private ProdutosView produtosView;

  public MainMenuView(Scanner input, FuncionariosView funcionariosView, ProdutosView produtosView) {
    this.input = input;
    this.funcionariosView = funcionariosView;
    this.produtosView = produtosView;
  }

  @Override
  public void run() {
    int option = -1;
    while (option != 0) {
      option = 0;

      System.out.println("");
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Funcionários");
      System.out.println("2 - Produtos");
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

      View view = null;
      switch (option) {
      case 0:
        break;
      case 1:
        view = this.funcionariosView;
        break;
      case 2:
        view = this.produtosView;
        break;
      default:
        System.out.println("Opção inválida, tente novamente.");
      }

      if (view != null) {
        view.run();
      }
    }
  }
}
