package javarush.test.dao;


import javarush.test.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
    int NEWS_ON_PAGE_COUNT = 10;

    User getByName(String fio);
    int getAllUsersCount();
    int getUserPagesCount();
    List<User> getUsersOnPage(int pageNumber);
}
