package controllers;

import java.util.List;

import dao.LoginDAO;
import entities.Login;

public class LoginController implements CrudController<Login> {
    private LoginDAO dao;

    public LoginController(LoginDAO dao) {
        this.dao = dao;
    }

    public Login login(String cpf, String password) {
        Login admin = dao.findByCpf(cpf);
        if (admin == null) {
            return null;
        }

        if (dao.checkPassword(admin, password)) {
            return admin;
        }
        return null;
    }

    @Override
    public List<Login> getAll() {
        return dao.getAll();
    }

    @Override
    public Login findById(int id) {
        return dao.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return dao.findById(id) != null;
    }

    @Override
    public void insert(Login login) {
        dao.insert(login);
    }

    @Override
    public void update(Login login) {
        dao.update(login);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public int count() {
        return dao.count();
    }
}
