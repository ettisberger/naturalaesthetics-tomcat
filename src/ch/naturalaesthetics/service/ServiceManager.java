package ch.naturalaesthetics.service;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 16:19
 */
public class ServiceManager {


    private static NewsService newsService;

    public static NewsService getNewsService() {
        if (newsService == null) {
            newsService = new NewsService();
        }
        return newsService;
    }
}
