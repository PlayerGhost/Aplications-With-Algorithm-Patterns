package projav1;

import java.util.Scanner;

import controllers.FuncionarioController;
import controllers.LoginController;
import controllers.ProdutoController;
import dao.FuncionarioDAO;
import dao.LoginDAO;
import dao.ProdutoDAO;
import entities.Login;
import views.CLI;

public class ProjAv2 {
    public static void main(String[] args) {
        LoginDAO loginDao = new LoginDAO();
        loginDao.insert(new Login(1, "12345678910", "123456"));
        loginDao.insert(new Login(2, "123", "123"));
        LoginController loginController = new LoginController(loginDao);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioDAO);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        ProdutoController produtoController = new ProdutoController(produtoDAO);

        Scanner input = new Scanner(System.in);
        CLI cli = new CLI(input, loginController, funcionarioController, produtoController);
        cli.run();
    }
}
