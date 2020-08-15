package com.devisv.practice.online.core.keygenerator;

import com.devisv.practice.online.core.model.OnlinePractice;

public interface PrimaryKeyGeneratorQualifier {

  <MODEL extends OnlinePractice> PrimaryKeyGenerator getGenerator(Class<MODEL> clazz);

}
