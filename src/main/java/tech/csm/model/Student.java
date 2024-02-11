package tech.csm.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_dob")
	private Date studentDob;

	@Column(name = "student_gender")
	private String studentGender;

	@Column(name = "student_mobile")
	private String studentMobile;

	@Column(name = "student_email")
	private String studentEmail;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "created_on", updatable = false)
	private Date createdOn;

	@CreationTimestamp
	@Column(name = "updated_on", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date updatedOn;

}
