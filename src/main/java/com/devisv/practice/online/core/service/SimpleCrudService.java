package com.devisv.practice.online.core.service;

import com.devisv.practice.online.core.keygenerator.PrimaryKeyGeneratorQualifier;
import com.devisv.practice.online.core.model.OnlinePractice;
import com.devisv.practice.online.core.repository.CrudRepository;
import java.util.List;

public abstract class SimpleCrudService<MODEL extends OnlinePractice, PK, SK> implements CrudService<MODEL, PK, SK> {

  protected final CrudRepository<MODEL, PK, SK> crudRepository;

  protected final PrimaryKeyGeneratorQualifier keyGeneratorQualifier;

  protected SimpleCrudService(CrudRepository crudRepository, PrimaryKeyGeneratorQualifier keyGeneratorQualifier) {
    this.crudRepository = crudRepository;
    this.keyGeneratorQualifier = keyGeneratorQualifier;
  }

  @Override
  public MODEL create(MODEL model) {

    return crudRepository.create((MODEL) keyGeneratorQualifier.getGenerator(model.getClass()).generate(model));
  }

  @Override
  public MODEL getById(PK pk, SK sk) {
    return crudRepository.getById(pk, sk)
        .orElseThrow(() -> new RuntimeException(String.format("Item with %s and %s wasn't found", pk, sk)));
  }

  @Override
  public List<MODEL> getAll(PK pk) {
    return crudRepository.getList(pk);
  }

  @Override
  public MODEL update(MODEL model, PK pk, SK sk) {
    return crudRepository.update((MODEL) keyGeneratorQualifier.getGenerator(model.getClass()).generate(model), pk, sk);
  }

  @Override
  public void delete(PK pk, SK sk) {
    crudRepository.delete(pk, sk);
  }
}
