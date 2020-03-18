package com.br.finances.adapter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * DozerConverter
 */
public class DozerConverter {

  private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  public static <O, D> D parseObject(O origin, Class<D> dest) {
    return mapper.map(origin, dest);
  }

  public static <O, D> List<D> parseObject(List<O> origin, Class<D> dest) {
    List<D> destioObj = new ArrayList<D>();

    for (Object obj : origin) {
      destioObj.add(mapper.map(obj, dest));
    }
    return destioObj;
  }
  
}