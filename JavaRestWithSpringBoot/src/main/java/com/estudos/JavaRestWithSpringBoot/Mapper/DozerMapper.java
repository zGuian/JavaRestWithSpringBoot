package com.estudos.JavaRestWithSpringBoot.Mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    // NÃO RECOMENDADO UTILIZAR DOZER. PESQUISAR PARA PROJETOS
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static<O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static<O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
