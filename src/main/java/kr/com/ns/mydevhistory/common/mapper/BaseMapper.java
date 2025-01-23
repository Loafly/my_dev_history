package kr.com.ns.mydevhistory.common.mapper;

import org.modelmapper.ModelMapper;

public abstract class BaseMapper<E, D> {
    private final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    protected BaseMapper(ModelMapper mm, Class<E> eClass, Class<D> dClass) {
        this.modelMapper = mm;
        this.entityClass = eClass;
        this.dtoClass = dClass;
    }

    public D toDto(E entity) {
        return (entity == null) ? null : modelMapper.map(entity, dtoClass);
    }

    public E toEntity(D domain) {
        return (domain == null) ? null : modelMapper.map(domain, entityClass);
    }
}
