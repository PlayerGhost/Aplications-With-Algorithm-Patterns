package views;

import java.util.Scanner;

import controllers.LoginController;
import entities.Login;

public class LoginView implements View {
  private Scanner input;
  private LoginController controller;

  public LoginView(Scanner input, LoginController loginController) {
    this.input = input;
    this.controller = loginController;
  }

  @Override
  public void run() {
    String cpf = null;
    String password = null;

    System.out.println("|Fazer Login como Administrador|");
    boolean loginSuccess = false;
    while (!loginSuccess) {
      System.out.println("Informe seu cpf:");
      cpf = input.next();

      System.out.println("Informe sua senha:");
      password = input.next();

      Login admin = controller.login(cpf, password);
      if (admin == null) {
        System.out.println("CPF ou Senha estão incorretos.");
      } else {
        System.out.println("Login efetuado com sucesso!");
        loginSuccess = true;
      }
    }
  }
}
