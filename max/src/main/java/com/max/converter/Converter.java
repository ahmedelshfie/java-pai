package com.max.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class Converter {

  private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  public static <O, D> D parseObject(O origin, Class<D> destinationClass) {
      return mapper.map(origin, destinationClass);
  }

  public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destinationClass) {
    List<D> destinationList = new ArrayList<D>();
    for (Object obj: origin) {
      destinationList.add(mapper.map(obj, destinationClass));
    }
    return destinationList;
  }
}
