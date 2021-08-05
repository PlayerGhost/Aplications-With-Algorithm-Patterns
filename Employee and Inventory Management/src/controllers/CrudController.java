package controllers;

import java.util.List;

import entities.Entity;

public interface CrudController<T extends Entity> {
  public List<T> getAll();

  public T findById(int id);

  public boolean existsById(int id);

  public void insert(T object);

  public void update(T object);

  public void delete(int id);

  public int count();
}
