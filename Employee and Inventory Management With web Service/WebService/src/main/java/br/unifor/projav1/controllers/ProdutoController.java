package br.unifor.projav1.controllers;

import br.unifor.projav1.dao.DAO;
import br.unifor.projav1.entities.Produto;

import java.util.List;

public class ProdutoController implements CrudController<Produto> {
    DAO<Produto> dao;

    public ProdutoController(DAO<Produto> dao) {
        this.dao = dao;
    }

    @Override
    public List<Produto> getAll() {
        return dao.getAll();
    }

    @Override
    public Produto findById(int id) {
        return dao.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return dao.findById(id) != null;
    }

    @Override
    public void insert(Produto funcionario) {
        dao.insert(funcionario);
    }

    @Override
    public void update(Produto produto) {
        dao.update(produto);
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
