package dao;

import entities.Login;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO implements DAO<Login> {
    ArrayList<Login> admins = new ArrayList<Login>();

    public Login findByCpf(String cpf) {
        for (Login admin : admins) {
            if (admin.getCpf().equals(cpf)) {
                return admin;
            }
        }
        return null;
    }

    public boolean checkPassword(Login admin, String password) {
        if (admin.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int count() {
        return admins.size();
    }

    @Override
    public List<Login> getAll() {
        return admins;
    }

    @Override
    public Login findById(int id) {
        for (Login a : admins) {
            if (a.getID() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void insert(Login admin) {
        admins.add(admin);
    }

    @Override
    public void update(Login admin) {
        // for (Admin a : admins) {
        //     if (a.getID() == admin.getID()) {
        //         // Call setters on a
        //         break;
        //     }
        // }
    }

    @Override
    public void delete(int id) {
        for (Login a : admins) {
            if (a.getID() == id) {
                int index = admins.indexOf(a);
                admins.remove(index);
                break;
            }
        }
    }
}
