package ch.naturalaesthetics.service;

import ch.naturalaesthetics.domain.News;
import ch.naturalaesthetics.mapper.GenericMapper;
import ch.naturalaesthetics.mapper.IMapper;
import ch.naturalaesthetics.persistence.NewsEntity;

/**
 * Service providing CRUD access to all Employee (and subclasses) items on database
 *
 * @author Marc Baur [marc.baur@webdesign-baur.ch]
 */

public class NewsService extends AbstractService<News, NewsEntity> {

    private IMapper<News, NewsEntity> newsMapper;

    protected NewsService() {
        super(News.class, NewsEntity.class);

        newsMapper = new GenericMapper<News, NewsEntity>(News.class, NewsEntity.class);
    }

    protected IMapper<News, NewsEntity> getDefaultMapper() {
        return newsMapper;
    }
}