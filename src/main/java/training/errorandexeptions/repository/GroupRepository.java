package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Group;
import training.errorandexeptions.exception.RepositoryException;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository extends Repository {
    private static GroupRepository instance;
    private List<Group> entityList;

    private GroupRepository() {
        entityList = new ArrayList<>();
    }

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }

    public Group add(Group group) throws IllegalArgumentException {
        if (group == null) {
            throw new IllegalArgumentException("group can't be null");
        }

        group.setId(entityList.size());
        entityList.add(group);
        return group;
    }

    public void delete(int groupId) throws RepositoryException {
        if (!checkId(groupId)) {
            throw new RepositoryException("group with id " + groupId + " not found");
        }
        entityList.set(groupId, null);
    }

    public Group getById(int groupId) throws RepositoryException {
        if (!checkId(groupId)) {
            throw new RepositoryException("group with id " + groupId + " not found");
        }
        return entityList.get(groupId);
    }

    public Group[] getByIds(int... groupIds) throws RepositoryException {
        List<Group> groups = new ArrayList<>();
        for (int id : groupIds) {
            if (checkId(id)) {
                Group group = entityList.get(id);

                if (group != null) {
                    groups.add(group);
                }
            }
        }

        if (groups.isEmpty()) {
            throw new RepositoryException("such groups not found");
        }
        return groups.toArray(new Group[0]);
    }

    public Group[] getByFacultyId(int facultyId) {
        List<Group> groupList = new ArrayList<>();
        for (Group group : entityList) {
            if (group.getFacultyId() == facultyId) {
                groupList.add(group);
            }
        }
        return groupList.toArray(new Group[0]);
    }

    public void update(Group group) throws IllegalArgumentException, RepositoryException {
        if (group == null) {
            throw new IllegalArgumentException("group can't be null");
        }

        if (!checkId(group.getId())) {
            throw new RepositoryException("old group not found");
        }
        entityList.set(group.getId(), group);
    }
}
