package dao;

import entity.Tasks;

import java.util.List;

public interface TasksDAO {
    //CREATE
    void add(Tasks tasks);

    //READ
    List<Tasks> getAll();

    Tasks getByID(long ID);

    //UPDATE
    void update(Tasks tasks);

    //DELETE
    void remove(Tasks tasks);
}
