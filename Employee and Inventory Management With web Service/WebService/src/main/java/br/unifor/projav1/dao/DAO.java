package br.unifor.projav1.dao;

import br.unifor.projav1.entities.Entity;

import java.util.List;

public interface DAO<T extends Entity> {
    List<T> getAll();

    T findById(int id);

    void insert(T object);

    void update(T object);

    void delete(int id);

    int count();
}
