package main.ch.naturalaesthetics.resource.app;

import main.ch.naturalaesthetics.domain.News;
import main.ch.naturalaesthetics.persistence.NewsEntity;
import main.ch.naturalaesthetics.service.ServiceManager;

import javax.ws.rs.Path;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
@Path("/news")
public class NewsResource extends AbstractAppResource<News, NewsEntity> {

    public NewsResource() {
        service = ServiceManager.getNewsService();
    }
}