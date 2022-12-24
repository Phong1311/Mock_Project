package com.vti.service;

import java.util.List;

import com.vti.service.implement.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFormForUpdating;
import com.vti.form.filter.GroupFilter;
import com.vti.entity.Group;
import com.vti.repository.GroupRepository;
import com.vti.specification.GroupSpecificationBuilder;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private GroupRepository repository;

	public Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search) {

		GroupSpecificationBuilder specification = new GroupSpecificationBuilder(filter, search);

		return repository.findAll(specification.build(), pageable);
	}

	public boolean isGroupExistsByName(String name) {
		return repository.existsByName(name);
	}

	public void createGroup(GroupFormForCreating form) {
		repository.save(form.toEntity());
	}

	public Group getGroupByID(short id) {
		return repository.findById(id).get();
	}

	public void updateGroup(short id, GroupFormForUpdating form) {
		Group entity = repository.findById(id).get();
		entity.setName(form.getName());
		entity.setTotalMember(form.getTotalMember());
		repository.save(entity);
	}

	@Transactional
	public void deleteGroups(List<Short> ids) {
		repository.deleteByIdIn(ids);
	}

}
//	public List<Department> getAllDepartments() {
//		return repository.findAll();
//	}
//
//	public Department getDepartmentByID(int id) {
//		return repository.findById(id).get();
//	}
//
//	public void createDepartment(Department department) {
//		repository.save(department);
//	}
//
//	public void updateDepartment(Department department) {
//		repository.save(department);
//	}
//
//	public void deleteDepartment(int id) {
//		repository.deleteById(id);
//	}
