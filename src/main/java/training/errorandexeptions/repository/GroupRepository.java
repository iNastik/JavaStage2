package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {
    private Map<String, Group> groupMap;

    public GroupRepository() {
        groupMap = new HashMap<>();
    }

    public void addGroup(String groupNumber, Group group) {
        if (groupMap.containsKey(groupNumber)) {
            // TODO: 02.06.2020 throws exceptions
        }
        groupMap.put(groupNumber, group);
    }

    public void deleteGroup(String groupNumber) {
        groupMap.remove(groupNumber);
    }

    public Object[] getAllGroups() {
        return groupMap.values().toArray();
    }

    public Group[] getGroupsByNumbers(String... groupNumbers) {
        List<Group> groups = new ArrayList<>();
        for (String groupNumber : groupNumbers) {
            Group group = groupMap.get(groupNumber);
            if (group != null) {
                groups.add(group);
            }
        }
        return groups.toArray(new Group[0]);
    }
}
