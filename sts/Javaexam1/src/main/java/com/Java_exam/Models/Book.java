package com.Java_exam.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5 , max = 20,message="name  must be at least 5 characters.")
	private String title;
	@NotNull
	@Size(min = 3 , max = 10,message="day  must be at least 5 characters.")
	private String authorname;
//	@NotEmpty(message="Password is required!")
//	@Min(100)
	private Integer level;
	private boolean parow;
	
	public boolean isParow() {
		return parow;
	}
	public void setParow(boolean parow) {
		this.parow = parow;
	}
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userProw_id")
	private User userprow;
	
//	public Book(Long id, String title, String authorname, boolean parow, Date createdAt,
//			Date updatedAt, User user, Integer level) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.authorname = authorname;
//		this.level = level;
//		this.parow = parow;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.user = user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUserprow() {
		return userprow;
	}
	public void setUserprow(User userprow) {
		this.userprow = userprow;
	}
	
	
	public Book() {
		super();
	}
	public Book(Long id, String title, String authorname, Integer level, boolean parow, Date createdAt, Date updatedAt,
			User user, User userprow) {
		super();
		this.id = id;
		this.title = title;
		this.authorname = authorname;
		this.level = level;
		this.parow = parow;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.userprow = userprow;
	}
	
	
	
	
	
}
