package com.devisv.practice.online.core.convertor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

@Service
public class SimpleConverterQualifier implements ConverterQualifier {

  private final Map<ConverterId, Converter> converters = new HashMap<>();

  public SimpleConverterQualifier(List<Converter> converters) {
    for (Converter converter : converters) {
      ResolvableType resolvableType = ResolvableType.forClass(converter.getClass()).as(Converter.class);

      this.converters.put(
          new ConverterId(
              resolvableType.getGeneric(0).toClass(),
              resolvableType.getGeneric(1).toClass()
          ),
          converter
      );
    }
  }

  @Override
  public Converter getConverter(Class input, Class output) {
    return
        Optional.ofNullable(
            converters.get(
                new ConverterId(input, output)
            )
        )
        .orElseThrow(
            () -> new RuntimeException(String.format("Converter %s->%s wasn't found", input.getSimpleName(), output.getSimpleName()))
        );
  }
}
