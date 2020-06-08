package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Group;

import java.util.*;

public class GroupRepository {
    private Map<String, Group> groupMap;

    public GroupRepository() {
        groupMap = new HashMap<>();
    }

    public void add(Group group) throws IllegalArgumentException, NoSuchElementException {
        if (group == null) {
            throw new IllegalArgumentException("group can't be null");
        }
        String groupName = group.getName();
        if (!groupMap.containsKey(groupName)) {
            throw new NoSuchElementException("Map doesn't contain such group name");
        }
        groupMap.put(groupName, group);
    }

    public void delete(String groupName) {
        if (groupName != null && !groupName.isEmpty()) {
            groupMap.remove(groupName);
        }
    }

    public Group[] getAll() {
        return groupMap.values().toArray(new Group[0]);
    }

    public Group[] getByNames(String... groupNames) {
        List<Group> groups = new ArrayList<>();
        for (String groupName : groupNames) {
            Group group = groupMap.get(groupName);
            if (group != null) {
                groups.add(group);
            }
        }
        return groups.toArray(new Group[0]);
    }

    public void update(Group group) throws IllegalArgumentException, NoSuchElementException {
        if (group == null) {
            throw new IllegalArgumentException("group can't be null");
        }
        String groupName = group.getName();
        if (!groupMap.containsKey(groupName)) {
            throw new NoSuchElementException("Map doesn't contain such group name");
        }
        groupMap.put(groupName, group);
    }
}
