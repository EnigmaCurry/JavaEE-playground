package com.enigmacurry.hr.model;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="getAllNonDeleted",
		query="SELECT e from Employee e WHERE e.deleted = false"),
	@NamedQuery(name="getNonDeletedById", 
		query="SELECT e from Employee e WHERE e.deleted = false AND e.id = :id")})
public class Employee {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	private String phoneNumber;
	private Long salary;
	@Column(nullable = false, columnDefinition = "boolean DEFAULT false")
	private boolean deleted;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	/** bean setter is protected so as to prevent modification from JSON service layer */
	protected void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	protected boolean isDeleted() {
		return deleted;
	}
	
	protected void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	protected Date getDeletedDate() {
		return deletedDate;
	}

	public void delete(){
		setDeleted(true);
		setDeletedDate(new Date());
	}

}
