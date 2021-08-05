package controllers;

import java.util.List;

import dao.DAO;
import entities.Funcionario;

public class FuncionarioController implements CrudController<Funcionario> {
    DAO<Funcionario> funcionarioDAO;

    public FuncionarioController(DAO<Funcionario> funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    @Override
    public List<Funcionario> getAll() {
        return funcionarioDAO.getAll();
    }

    @Override
    public Funcionario findById(int id) {
        return funcionarioDAO.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return funcionarioDAO.findById(id) != null;
    }

    @Override
    public void insert(Funcionario funcionario) {
        funcionarioDAO.insert(funcionario);
    }

    @Override
    public void update(Funcionario funcionario) {
        funcionarioDAO.update(funcionario);
    }

    @Override
    public void delete(int id) {
        funcionarioDAO.delete(id);
    }

    @Override
    public int count() {
        return funcionarioDAO.count();
    }
}
