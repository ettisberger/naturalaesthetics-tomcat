package ch.naturalaesthetics.mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
public class GenericMapper<D, E> implements IMapper<D, E> {

    private final Class<D> domainClass;
    private final Class<E> entityClass;
    private final MapperFactory mapperFactory;

    public GenericMapper(Class<D> domainClass, Class<E> entityClass) {
        this.domainClass = domainClass;
        this.entityClass = entityClass;
        this.mapperFactory = new DefaultMapperFactory.Builder().build();

        enrichWithCustomConverters();
    }

    private void enrichWithCustomConverters() {
        // add custom date converter
//        mapperFactory.getConverterFactory().registerConverter(new CUSTOMCONVERTER);
    }

    public BoundMapperFacade<D, E> getFacade() {
        return mapperFactory.getMapperFacade(domainClass, entityClass);
    }
}
