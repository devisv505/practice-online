package com.devisv.practice.online.core.repository;

import com.devisv.practice.online.core.model.OnlinePractice;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<MODEL extends OnlinePractice, PK, SK> {

  MODEL create(MODEL model);

  List<MODEL> getList(PK pk);

  Optional<MODEL> getById(PK pk, SK sk);

  MODEL update(MODEL model, PK pk, SK sk);

  void delete(PK pk, SK sk);

}
