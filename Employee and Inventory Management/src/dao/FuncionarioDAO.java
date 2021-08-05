package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Funcionario;

public class FuncionarioDAO implements DAO<Funcionario> {
    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    int lastID = 0;

    @Override
    public List<Funcionario> getAll() {
        return funcionarios;
    }

    @Override
    public Funcionario findById(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getID() == id) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public void insert(Funcionario funcionario) {
       
        funcionario.setID(lastID + 1);
        funcionarios.add(funcionario);
        lastID++;
    }

    @Override
    public void update(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getID() == funcionario.getID()) {
                f.setSalario(funcionario.getSalario());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getID() == id) {
                funcionarios.remove(i);
                break;
            }
        }
    }

    @Override
    public int count() {
        return this.funcionarios.size();
    }
}
