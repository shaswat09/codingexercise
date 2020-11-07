package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

private String name;

	private String authors;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_ID")
	private User checkedOutBy;

	
	public Integer getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((checkedOutBy == null) ? 0 : checkedOutBy.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (checkedOutBy == null) {
			if (other.checkedOutBy != null)
				return false;
		} else if (!checkedOutBy.equals(other.checkedOutBy))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public User getCheckedOutBy() {
		return checkedOutBy;
	}
	public void setCheckedOutBy(User checkedOutBy) {
		this.checkedOutBy = checkedOutBy;
	}
	public Book(Integer id, String name, String authors, User checkedOutBy) {
		super();
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.checkedOutBy = checkedOutBy;
	}
	public Book() {
		
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
