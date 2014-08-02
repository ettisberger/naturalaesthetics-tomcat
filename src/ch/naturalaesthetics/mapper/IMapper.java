package ch.naturalaesthetics.mapper;

import ma.glasnost.orika.BoundMapperFacade;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
public interface IMapper<D, E> {

    /**
     * Returns BoundMapperFacade which provides map and mapRevert for given domain and entity items.
     *
     * @return BoundMapperFacade
     */
    public BoundMapperFacade<D, E> getFacade();

}
