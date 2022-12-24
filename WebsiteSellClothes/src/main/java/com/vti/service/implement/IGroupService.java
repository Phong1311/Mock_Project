package com.vti.service.implement;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFormForUpdating;
import com.vti.form.filter.GroupFilter;
import com.vti.entity.Group;

public interface IGroupService {

	Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search);

	boolean isGroupExistsByName(String name);

	void createGroup(GroupFormForCreating form);

	Group getGroupByID(short id);

	void updateGroup(short id, GroupFormForUpdating form);

	void deleteGroups(List<Short> ids);

}
