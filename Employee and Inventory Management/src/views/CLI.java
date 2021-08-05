package views;

import java.util.Scanner;

import controllers.FuncionarioController;
import controllers.LoginController;
import controllers.ProdutoController;

public class CLI {
  private Scanner input;
  private LoginController loginController;
  private FuncionarioController funcionarioController;
  private ProdutoController produtoController;

  public CLI(Scanner input, LoginController loginController, FuncionarioController funcionarioController,
      ProdutoController produtoController) {
    this.input = input;
    this.loginController = loginController;
    this.funcionarioController = funcionarioController;
    this.produtoController = produtoController;
  }

  public void run() {
    new LoginView(this.input, this.loginController).run();

    FuncionariosView funcionariosView = new FuncionariosView(input, funcionarioController);
    ProdutosView produtosView = new ProdutosView(input, produtoController);
    new MainMenuView(this.input, funcionariosView, produtosView).run();
  }
}
