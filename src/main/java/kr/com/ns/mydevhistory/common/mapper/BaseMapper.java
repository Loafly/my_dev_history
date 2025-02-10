package kr.com.ns.mydevhistory.common.mapper;

import org.modelmapper.ModelMapper;

import java.util.*;

public abstract class BaseMapper<E, D> {
    private final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Map<Class<?>, List<Class<?>>> dtoMappings = new HashMap<>();

    protected BaseMapper(ModelMapper modelMapper, Class<E> entityClass) {
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
    }

    protected <D> void registerDtoMapping(Class<D> dtoClass) {
        dtoMappings.computeIfAbsent(entityClass, k -> new ArrayList<>()).add(dtoClass);
    }

    protected <D> D toDto(E entity, Class<D> dtoClass) {
        if (!dtoMappings.getOrDefault(entityClass, Collections.emptyList()).contains(dtoClass)) {
            throw new IllegalStateException("등록되지 않은 DTO 클래스입니다.");
        }
        return (entity == null) ? null : modelMapper.map(entity, dtoClass);
    }

    protected  <D> E toEntity(D dto) {
        return (dto == null) ? null : modelMapper.map(dto, entityClass);
    }
}
