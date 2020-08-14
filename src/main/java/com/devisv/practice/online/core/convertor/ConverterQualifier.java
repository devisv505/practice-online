package com.devisv.practice.online.core.convertor;

public interface ConverterQualifier {

  Converter getConverter(Class input, Class output);

}
