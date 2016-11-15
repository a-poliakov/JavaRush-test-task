package javarush.test.dao;


import javarush.test.entity.User;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
    int NEWS_ON_PAGE_COUNT = 10;

    List<User> getByName(String fio) throws UnsupportedEncodingException;
    int getAllUsersCount();
    int getUserPagesCount();
    int getUserPagesCount(int countOfElements);
    List<User> getUsersOnPage(int pageNumber);
}
