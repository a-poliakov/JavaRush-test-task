package javarush.test.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, K extends Serializable> {
    K save(T object);

    void update(T object);

    void saveOrUpdate(T object);

    void delete(T object);

    T getById(K key);

    List<T> getAll();
}
