package com.example.demo;

import java.util.List;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="admin")
public class AdministrationInfo {

	private String name;
	private String databaseName;
	private List<Menu> menus;
	private String email;
	private String phone;
	private String contactMe;
	private String profile;
	
	public String getName() {
		return name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContactMe() {
		return contactMe;
	}
	public void setContactMe(String contactMe) {
		this.contactMe = contactMe;
	}
	
	
	
}
