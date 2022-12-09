package ru.rsreu.kibamba.clientserverapplw.repository;

import ru.rsreu.kibamba.clientserverapplw.models.Dorm;

import java.util.List;

public interface DormRepository {
    public List<Dorm> index();
    public Dorm getDormById(int dormId);
    public void updateDorm(int dormId, Dorm dorm);
    public void createDorm(Dorm dorm);
    public void deleteDormById(int dormId);
}
