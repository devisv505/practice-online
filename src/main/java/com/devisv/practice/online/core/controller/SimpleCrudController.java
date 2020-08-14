package com.devisv.practice.online.core.controller;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.core.convertor.ConverterQualifier;
import com.devisv.practice.online.core.model.OnlinePractice;
import com.devisv.practice.online.core.service.CrudService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.ResolvableType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class SimpleCrudController<DTO_INPUT, DTO_OUTPUT, MODEL extends OnlinePractice, PK, SK>
    implements CrudController<DTO_INPUT, DTO_OUTPUT, PK, SK> {

  protected final CrudService<MODEL, PK, SK> crudService;

  protected final Converter<DTO_INPUT, MODEL> converterDtoToModel;

  protected final Converter<MODEL, DTO_OUTPUT> converterModelToDto;

  protected SimpleCrudController(CrudService crudService, ConverterQualifier converterQualifier) {
    this.crudService = crudService;

    ResolvableType resolvableType = ResolvableType.forClass(this.getClass()).as(SimpleCrudController.class);

    this.converterDtoToModel = converterQualifier.getConverter(
        resolvableType.getGeneric(0).toClass(),
        resolvableType.getGeneric(2).toClass()
    );

    this.converterModelToDto = converterQualifier.getConverter(
        resolvableType.getGeneric(2).toClass(),
        resolvableType.getGeneric(1).toClass()
    );
  }

  @GetMapping
  public List<DTO_OUTPUT> get() {
    return crudService.getAll()
        .stream()
        .map(converterModelToDto::convert)
        .collect(Collectors.toList());
  }

  public DTO_OUTPUT get(PK pk, SK sk) {
    return null;
  }

  @PostMapping
  public DTO_OUTPUT post(@RequestBody DTO_INPUT createDto) {
    return
        converterModelToDto.convert(
            crudService.create(
                converterDtoToModel.convert(createDto)
            )
        );
  }

  public DTO_OUTPUT put(DTO_INPUT updateDto, PK pk, SK sk) {
    return null;
  }

  public void delete(PK pk, SK sk) {

  }
}
