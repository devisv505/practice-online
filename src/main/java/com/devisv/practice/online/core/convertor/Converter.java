package com.devisv.practice.online.core.convertor;

public interface Converter<INPUT, OUTPUT> {

  OUTPUT convert(INPUT input);

}
