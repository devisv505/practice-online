package com.devisv.practice.online.core.controller;

import java.util.List;

public interface CrudController <DTO_INPUT, DTO_OUTPUT, PK, SK> {

  DTO_OUTPUT post(DTO_INPUT createDto);

  DTO_OUTPUT get(PK pk, SK sk);

  List<DTO_OUTPUT> get();

  DTO_OUTPUT put(DTO_INPUT updateDto, PK pk, SK sk);

  void delete(PK pk, SK sk);

}
