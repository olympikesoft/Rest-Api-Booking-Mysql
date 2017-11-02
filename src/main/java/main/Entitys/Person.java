package main.java.main.Entitys;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	public Person() {

	}

	public Person(Integer id, String name, String sobrename, String country,
			String birthday, String email) {
		super();
		this.id = id;
		this.name = name;
		this.sobrename = sobrename;
		this.country = country;
		this.birthday = birthday;
		this.email = email;
	}

	private Integer id;

	private String name;

	private String sobrename;

	private String country;

	private String birthday;

	private String email;

	public Integer getId() {
		return id;
	}

	public String getSobrename() {
		return sobrename;
	}

	public void setSobrename(String sobrename) {
		this.sobrename = sobrename;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}