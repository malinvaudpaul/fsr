package com.fsr.daos;

import java.util.List;

public interface IDAO<T> {

  public boolean create(T entity);

  public T read(int id);

  public List<T> readAll();

  public boolean update(T entity);

  public boolean delete(int id);
}
