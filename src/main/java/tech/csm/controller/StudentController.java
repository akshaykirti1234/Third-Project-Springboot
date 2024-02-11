package tech.csm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.csm.model.Country;
import tech.csm.model.Department;
import tech.csm.model.District;
import tech.csm.model.State;
import tech.csm.model.Student;
import tech.csm.repo.CountryRepo;
import tech.csm.repo.DepartmentRepo;
import tech.csm.repo.DistrictRepo;
import tech.csm.repo.StateRepo;
import tech.csm.repo.StudentRepo;

@CrossOrigin
@RestController
@RequestMapping({ "/", "student" })
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	@Autowired
	DepartmentRepo departmentRepo;
	@Autowired
	CountryRepo countryRepo;
	@Autowired
	StateRepo stateRepo;
	@Autowired
	DistrictRepo districtRepo;

	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getMethodName() {
		List<Student> studentList = studentRepo.findAll();
		List<Department> departmentList = departmentRepo.findAll();
		List<Country> countryList = countryRepo.findAll();

		Map<Object, Object> response = new LinkedHashMap<>();
		response.put("studentList", studentList);
		response.put("departmentList", departmentList);
		response.put("countryList", countryList);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getStateByCountryId/{countryId}")
	public ResponseEntity<?> getStateByCountryId(@PathVariable Integer countryId) {
		List<State> stateList = stateRepo.getStateByCountryId(countryId);
		return new ResponseEntity<>(stateList, HttpStatus.OK);
	}

	@GetMapping("/getDistrictByStateId/{stateId}")
	public ResponseEntity<?> getDistrictByStateId(@PathVariable Integer stateId) {
		List<District> districtList = districtRepo.getStateByCountryId(stateId);
		return new ResponseEntity<>(districtList, HttpStatus.OK);
	}

	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		System.err.println(student);
		Student savedStudent = studentRepo.save(student);
		if (student.getStudentId() != null) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@PatchMapping("/editStudent/{studentId}")
	public ResponseEntity<?> editStudent(@PathVariable Integer studentId) {
		if (studentRepo.existsById(studentId)) {
			Student student = studentRepo.findById(studentId).get();
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
