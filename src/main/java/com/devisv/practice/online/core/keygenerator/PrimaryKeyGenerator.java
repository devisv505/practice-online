package com.devisv.practice.online.core.keygenerator;

import com.devisv.practice.online.core.model.OnlinePractice;

public interface PrimaryKeyGenerator<MODEL extends OnlinePractice> {

  MODEL generate(MODEL model);

}
