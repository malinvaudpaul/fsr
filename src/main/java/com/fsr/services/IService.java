package com.fsr.services;

import java.util.List;

public interface IService<T> {

  public void create(T entity);

  public T read(int id);

  public List<T> readAll();

  public void update(T entity);

  public void delete(int id);
}
