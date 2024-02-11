package tech.csm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
