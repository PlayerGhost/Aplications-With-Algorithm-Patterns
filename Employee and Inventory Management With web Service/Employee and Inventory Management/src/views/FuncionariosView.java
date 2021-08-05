package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.FuncionarioController;
import entities.Funcionario;

public class FuncionariosView implements View {
  private Scanner input;
  private FuncionarioController controller;

  public FuncionariosView(Scanner input, FuncionarioController funcionarioController) {
    this.input = input;
    this.controller = funcionarioController;
  }

  @Override
  public void run() {
    int option = -1;
    while (option != 0) {
      option = 0;

      System.out.println("");
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Listar funcionários");
      System.out.println("2 - Cadastrar funcionário");
      System.out.println("3 - Editar funcionário");
      System.out.println("4 - Excluir funcionário");
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
        listFuncionarios();
        break;
      case 2:
        insertFuncionario();
        break;
      case 3:
        editFuncionario();
        break;
      case 4:
        deleteFuncionario();
        break;
      default:
        System.out.println("Opção inválida, tente novamente.");
      }
    }
  }

  private void listFuncionarios() {
    System.out.println("Lista de funcioários:");

    if (controller.count() <= 0) {
      System.out.println("Nenhum funcionário foi cadastrado.");
      return;
    }

    for (Funcionario funcionario : controller.getAll()) {
      System.out.println("------------------------");
      System.out.println("ID: " + funcionario.getID());
      System.out.println("Nome: " + funcionario.getNome());
      System.out.println("CPF: " + funcionario.getCpf());
      System.out.println("Data de contratacao: " + funcionario.getDataContratacao());
      System.out.println("Salário: " + funcionario.getSalario());
    }
  }

  private void insertFuncionario() {
    String nome = "";
    String cpf = "";
    String data = "";
    float salario = 0;

    input.nextLine();
    System.out.println("Informe o nome do funcionario");
    nome = input.nextLine();

    System.out.println("Informe o CPF do funcionario");
    cpf = input.nextLine();

    System.out.println("Informe a data de contratação do funcionario");
    data = input.nextLine();

    boolean errorSalario = true;
    while (errorSalario) {
      try {
        System.out.println("Informe o salário do funcionario");
        salario = input.nextFloat();
        errorSalario = false;
      } catch (InputMismatchException e) {
        System.out.println("Valor não suportado, tente novamente.");
        input.nextLine();
        errorSalario = true;
      }
    };

    controller.insert(new Funcionario(nome, cpf, data, salario));
    System.out.println("Funcionário cadastrado com sucesso!");
  }

  private void editFuncionario() {
    if (controller.getAll().isEmpty()) {
      System.out.println("Nenhum funcionário foi cadastrado.");
      return;
    }

    
    Funcionario funcionario = pickFuncionario("editar");
    boolean errorSalario = true;
    while (errorSalario) {
      try {
        System.out.println("Informe o novo salário:");
        funcionario.setSalario(input.nextFloat());
        errorSalario = false;
      } catch (InputMismatchException e) {
        System.out.println("Valor não suportado, tente novamente.");
        input.nextLine();
        errorSalario = true;
      }
    };

    controller.update(funcionario);
    System.out.println("Salário atualizado com sucesso!");
  }

  private void deleteFuncionario() {
    if (controller.getAll().isEmpty()) {
      System.out.println("Nenhum funcionário foi cadastrado.");
      return;
    }

    Funcionario funcionario = pickFuncionario("excluir");
    controller.delete(funcionario.getID());
    System.out.println("Funcionário excluído com sucesso!");
  }

  private Funcionario pickFuncionario(String action) {
    Funcionario funcionario = null;
    int id = 0;
    boolean funcionarioExists = false;
    while (!funcionarioExists) {
      boolean errorId = true;
      while (errorId) {
        try {
          System.out.println("Informe o ID do funcionário que deseja " + action + ":");
          id = input.nextInt();
          errorId = false;
          funcionario = controller.findById(id);
          if (funcionario == null) {
            errorId = true;
          } else {
            funcionarioExists = true;
            break;
          }
        } catch (InputMismatchException e) {
          System.out.println("Valor não encontrado, tente novamente.");
          input.nextLine();
          errorId = true;
        }
      };
    }
    input.nextLine();
    return funcionario;
  }
}
