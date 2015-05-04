package com.ccs.ems.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @Column(name="user_id")
    @GeneratedValue
	private Long userId;
	
	@Column(name="firstname")
	private String userFirstName;
	
	@Column(name="lastname")
	private String userLastName;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="user_roles", 
                joinColumns={@JoinColumn(name="user_ID")}, 
                inverseJoinColumns={@JoinColumn(name="role_ID")})
	Set<Roles> roleSet = new HashSet<Roles>();
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Set<Roles> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Roles> roleSet) {
		this.roleSet = roleSet;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userFirstName + userLastName + "]";
	}
	
	
}
