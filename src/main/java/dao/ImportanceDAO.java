package dao;

import entity.Importance;

import java.util.List;

public interface ImportanceDAO {
    //CREATE
    void add(Importance tasks);

    //READ
    List<Importance> getAll();

    Importance getByID(long ID);

    //UPDATE
    void update(Importance tasks);

    //DELETE
    void remove(Importance tasks);
}
