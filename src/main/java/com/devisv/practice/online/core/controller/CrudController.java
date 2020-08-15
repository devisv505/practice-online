package com.devisv.practice.online.core.controller;

import java.util.List;

public interface CrudController <DTO_INPUT, DTO_OUTPUT, SK> {

  DTO_OUTPUT post(DTO_INPUT createDto);

  DTO_OUTPUT get(SK sk);

  List<DTO_OUTPUT> get();

  DTO_OUTPUT put(DTO_INPUT updateDto, SK sk);

  void delete(SK sk);

}
