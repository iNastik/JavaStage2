package training.errorandexeptions.service;

import training.errorandexeptions.entity.Group;
import training.errorandexeptions.exception.GroupsNotFoundException;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.repository.GroupRepository;

public class GroupService {
    private GroupRepository groupRepository = new GroupRepository();

    public Group add(Group group) {
        return groupRepository.add(group);
    }

    public Group getById(int groupId) throws RepositoryException {
        return groupRepository.getById(groupId);
    }

    public Group[] getByFacultyId(int facultyId) throws GroupsNotFoundException {
        Group[] groups = groupRepository.getByFacultyId(facultyId);

        if (groups.length == 0) {
            throw new GroupsNotFoundException("groups not found");
        }
        return groups;
    }
}
