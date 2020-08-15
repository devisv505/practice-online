package com.devisv.practice.online.core.keygenerator;

import com.devisv.practice.online.core.model.OnlinePractice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

@Service
public class SimplePrimaryKeyGeneratorQualifier implements PrimaryKeyGeneratorQualifier {

  private final Map<Class, PrimaryKeyGenerator> primaryKeyGenerators = new HashMap<>();

  public SimplePrimaryKeyGeneratorQualifier(List<PrimaryKeyGenerator> primaryKeyGenerators) {
    for (PrimaryKeyGenerator generator : primaryKeyGenerators) {
      ResolvableType resolvableType = ResolvableType.forClass(generator.getClass()).as(PrimaryKeyGenerator.class);

      this.primaryKeyGenerators.put(resolvableType.getGeneric(0).toClass(), generator);
    }
  }

  @Override
  public <MODEL extends OnlinePractice> PrimaryKeyGenerator getGenerator(Class<MODEL> clazz) {
    return Optional
            .ofNullable(primaryKeyGenerators.get(clazz))
            .orElseThrow(
                () -> new RuntimeException(String.format("Primary Key Generator %s wasn't found", clazz))
            );
  }
}
