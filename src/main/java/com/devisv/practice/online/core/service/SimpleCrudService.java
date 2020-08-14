package com.devisv.practice.online.core.service;

import java.util.List;

public abstract class SimpleCrudService<MODEL, PK, SK> implements CrudService<MODEL, PK, SK> {

  @Override
  public MODEL create(MODEL model) {
    return null;
  }

  @Override
  public MODEL getById(PK pk, SK sk) {
    return null;
  }

  @Override
  public List<MODEL> getAll() {
    return null;
  }

  @Override
  public MODEL update(MODEL model, PK pk, SK sk) {
    return null;
  }

  @Override
  public void delete(PK pk, SK sk) {

  }
}
