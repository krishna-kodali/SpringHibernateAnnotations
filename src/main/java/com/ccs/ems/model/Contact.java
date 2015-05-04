package com.ccs.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {

	@Id
    @Column(name="contact_id")
    @GeneratedValue
	private Long contact_id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Lob
	@Column(name="photo", nullable=false, columnDefinition="mediumblob")
	private byte[] photo;

	public Long getContact_id() {
		return contact_id;
	}

	public void setContact_id(Long contact_id) {
		this.contact_id = contact_id;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
