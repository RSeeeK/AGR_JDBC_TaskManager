package dao;

import java.util.List;

public interface Entity_CRUD<T> {
    void create(T object);

    List<T> getAll();

    T getByID(Long id);

    void update(T object);

    void delete(T object);
}
