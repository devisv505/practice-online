package com.devisv.practice.online.core.service;

import java.util.List;

public interface CrudService<MODEL, PK, SK> {

  MODEL create(MODEL model);

  MODEL getById(PK pk, SK sk);

  List<MODEL> getAll();

  MODEL update(MODEL model, PK pk, SK sk);

  void delete(PK pk, SK sk);

}
