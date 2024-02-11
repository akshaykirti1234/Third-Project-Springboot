package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
