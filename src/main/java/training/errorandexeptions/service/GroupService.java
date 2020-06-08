package training.errorandexeptions.service;

import training.errorandexeptions.entity.Group;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.repository.GroupRepository;

public class GroupService {
    private GroupRepository groupRepository = new GroupRepository();

    public Group getByName(String groupName) throws RepositoryException{
        Group[] groups = groupRepository.getByNames(groupName);
        if (groups.length == 0) {
            throw new RepositoryException("group with group name " + groupName + " not found");
        }
        return groups[0];
    }
}
