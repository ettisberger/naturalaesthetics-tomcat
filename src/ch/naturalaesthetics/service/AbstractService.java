package ch.naturalaesthetics.service;

import ch.naturalaesthetics.mapper.IMapper;
import ch.naturalaesthetics.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */
public abstract class AbstractService<D, E> {

    private final Class<D> domainClass;
    private final Class<E> entityClass;

    AbstractService(Class<D> domainClass, Class<E> entityClass) {
        this.domainClass = domainClass;
        this.entityClass = entityClass;
    }

    protected abstract IMapper<D, E> getDefaultMapper();

    /**
     * Delete passed object from database
     *
     * @param id the domain item to delete
     */
    public void delete(final int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        D domainItem = findById(id);
        E entityItem = getDefaultMapper().getFacade().map(domainItem);
        session.delete(entityItem);

        transaction.commit();
        session.close();
    }

    /**
     * Find objects by given type in database
     *
     * @return domain items
     */
    public List<D> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        final Query query = session.createQuery("from " + entityClass.getSimpleName());
        List<E> entityItems = query.list();

        List<D> domainItems = new ArrayList<D>();
        for (E entityItem : entityItems) {
            D domainItem = getDefaultMapper().getFacade().mapReverse(entityItem);
            domainItems.add(domainItem);
        }

        transaction.commit();
        session.close();

        return domainItems;
    }


    /**
     * Find object by given ID in database
     *
     * @param id id of object to find
     * @return domain item
     */
    public D findById(final int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        E entityItem = (E) session.get(entityClass, id);
        D domainItem = getDefaultMapper().getFacade().mapReverse(entityItem);

        transaction.commit();
        session.close();

        return domainItem;
    }

    /**
     * Find all objects which match given criterias
     *
     * @param criterions
     * @return domain items
     */
    protected final List<D> findByRestrictions(final Criterion... criterions) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        final Criteria criteria = session.createCriteria(entityClass);
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        List<E> entityItems = criteria.list();

        List<D> domainItems = new ArrayList<D>();
        for (E entityItem : entityItems) {
            D domainItem = getDefaultMapper().getFacade().mapReverse(entityItem);
            domainItems.add(domainItem);
        }

        transaction.commit();
        session.close();

        return domainItems;
    }

    /**
     * Save passed object into database
     *
     * @param domainItem the domain item to save
     * @return saved domain item
     */
    public D save(final D domainItem) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        E entityItem = getDefaultMapper().getFacade().map(domainItem);
        session.saveOrUpdate(entityItem);

        transaction.commit();
        session.close();

        return domainItem;
    }

}
