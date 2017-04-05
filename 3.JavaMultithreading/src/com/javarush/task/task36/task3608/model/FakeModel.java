package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.Arrays;

public class FakeModel implements Model{
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(Arrays.asList(
                new User("One", 1, 7),
                new User("Bublebee", 2, 5),
                new User("Optimus", 3, 8)
        ));
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
