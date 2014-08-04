package main.ch.naturalaesthetics.resource.admin;

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
public class NewsAdminResource extends AbstractAdminResource<News, NewsEntity> {

    public NewsAdminResource() {
        service = ServiceManager.getNewsService();
    }

}
