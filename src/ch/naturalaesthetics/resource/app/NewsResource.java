package ch.naturalaesthetics.resource.app;

import ch.naturalaesthetics.domain.News;
import ch.naturalaesthetics.persistence.NewsEntity;
import ch.naturalaesthetics.service.ServiceManager;

import javax.ws.rs.Path;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
@Path("/news")
public class NewsResource extends AbstractResource<News, NewsEntity> {

    public NewsResource() {
        service = ServiceManager.getNewsService();
    }
}