package training.errorandexeptions.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private List<Group> groupList = new ArrayList<>();

    public Faculty(String name, Group... groups) {
        this.name = name;
        groupList.addAll(Arrays.asList(groups));
    }

    public Group[] getGroups() {
        return groupList.toArray(new Group[0]);
    }

    public Group getGroupByName(String name) {
        // TODO: 06.05.2020 check null 
        for (Group group : groupList) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null; // TODO: 06.05.2020 return exceptions 
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public void deleteGroup(Group group) {
        groupList.remove(group);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(groupList, faculty.groupList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groupList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}
