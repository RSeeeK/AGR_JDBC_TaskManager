package dao;

import entity.Reminders;

import java.util.List;

public interface RemindersDAO {
    //CREATE
    void add(Reminders tasks);

    //READ
    List<Reminders> getAll();

    Reminders getByID(long ID);

    //UPDATE
    void update(Reminders tasks);

    //DELETE
    void remove(Reminders tasks);
}
