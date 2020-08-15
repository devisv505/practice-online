package com.devisv.practice.online.core.service;

import com.devisv.practice.online.core.model.OnlinePractice;
import java.util.List;

public interface CrudService<MODEL extends OnlinePractice, PK, SK> {

  MODEL create(MODEL model);

  MODEL getById(PK pk, SK sk);

  List<MODEL> getAll(PK pk);

  MODEL update(MODEL model, PK pk, SK sk);

  void delete(PK pk, SK sk);

}
