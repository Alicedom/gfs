package gfs.dao;

import gfs.model.Gfs025;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class Gfs025DaoImp implements Gfs025Dao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Gfs025 gfs025) {
        sessionFactory.getCurrentSession().save(gfs025);

    }

    @Override
    public List<Gfs025> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Gfs025> query = sessionFactory.getCurrentSession().createQuery("from GFS025_TBL");

        return query.getResultList();
    }
}
