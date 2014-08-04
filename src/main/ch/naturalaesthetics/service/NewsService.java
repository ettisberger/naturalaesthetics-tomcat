package main.ch.naturalaesthetics.service;

import main.ch.naturalaesthetics.domain.News;
import main.ch.naturalaesthetics.mapper.GenericMapper;
import main.ch.naturalaesthetics.mapper.IMapper;
import main.ch.naturalaesthetics.persistence.NewsEntity;

/**
 * Service providing CRUD access to all Employee (and subclasses) items on database
 *
 * @author Marc Baur [marc.baur@webdesign-baur.main.ch]
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