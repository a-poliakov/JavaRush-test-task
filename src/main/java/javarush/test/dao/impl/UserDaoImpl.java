package javarush.test.dao.impl;

import javarush.test.dao.UserDao;
import javarush.test.entity.User;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByName(String name) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.like("name", "%" + name + "%"));
    }

    @Override
    public int getAllUsersCount() {
        return ((Number) getSession().createCriteria(User.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    @Override
    public int getUserPagesCount(){
        return getAllUsersCount() / NEWS_ON_PAGE_COUNT;
    }

    @Override
    public List<User> getUsersOnPage(int pageNumber){
        return getSession()
                .createCriteria(User.class)
                .setFirstResult(pageNumber * NEWS_ON_PAGE_COUNT)
                .setMaxResults(NEWS_ON_PAGE_COUNT).list();
    }
}
