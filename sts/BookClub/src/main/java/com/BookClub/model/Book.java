package com.BookClub.model;

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



@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String authorname;
	private String mythouths;
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
	
	public Book(Long id, String title, String authorname, String mythouths, boolean parow, Date createdAt,
			Date updatedAt, User user) {
		super();
		this.id = id;
		this.title = title;
		this.authorname = authorname;
		this.mythouths = mythouths;
		this.parow = parow;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}
	
	
	public User getUserprow() {
		return userprow;
	}
	public void setUserprow(User userprow) {
		this.userprow = userprow;
	}
	public Book(){
		
	}
	
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
	public String getMythouths() {
		return mythouths;
	}
	public void setMythouths(String mythouths) {
		this.mythouths = mythouths;
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
	
	
}

