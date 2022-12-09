package ru.rsreu.kibamba.clientserverapplw.repository;

import ru.rsreu.kibamba.clientserverapplw.models.Dorm;

import java.util.List;

public interface DormRepository {
    List<Dorm> getAllDorm();
    Dorm getDormById(int dormId);
    void updateDorm(int dormId, Dorm dorm);
    void createDorm(Dorm dorm);
    void deleteDormById(int dormId);
}
