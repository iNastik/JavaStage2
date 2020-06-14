package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Entity;

import java.util.List;

public abstract class Repository {
    protected List<Entity> entityList;

    boolean checkId(int id) {
        return id >= 0 && id < entityList.size();
    }
}
