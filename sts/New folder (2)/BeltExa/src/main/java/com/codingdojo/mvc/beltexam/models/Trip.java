package com.codingdojo.mvc.beltexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="trips")
public class Trip {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    
//    @NotEmpty(message="creatName is required!")
//    @Size(min=3, max=30, message="creatName must be between 3 and 30 characters")
    private String creatName;
    
    @NotEmpty(message="titel is required!")
    @Size(min=3, max=30, message="titel must be between 3 and 30 characters")
    private String titel;
    
    
    @NotEmpty(message="Description is required!")
    @Size(min=5, max=150, message="Description must be between 5 and 150 characters")
    private String Description;
    
    
    @NotNull(message="Capacity is required!")
    @Min(value=1, message="must be equal or greater than 1")  
    @Max(value=30, message="must be equal or less than 30")  
    private Integer Capacity;
    
    
////    @DateTimeFormat(pattern="EEEE")
//    @NotNull(message="gameDay is required!")
//    
//    private Date gameDay;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User user;


//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public String getCreatName() {
//		return creatName;
//	}
//	public void setCreatName(String creatName) {
//		this.creatName = creatName;
//	}
//	public String getTitel() {
//		return titel;
//	}
//	public void setTitel(String titel) {
//		this.titel = titel;
//	}
//	public Integer getSkillLevel() {
//		return skillLevel;
//	}
//	public void setSkillLevel(Integer skillLevel) {
//		this.skillLevel = skillLevel;
//	}
//	
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//	 public Trip() {
//		super();
//	}

	@ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(
         name = "Trip_players", 
         joinColumns = @JoinColumn(name = "Trip_id"), 
         inverseJoinColumns = @JoinColumn(name = "user_id")
     )     
    private List<User> users;
//
//
//	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//	public Date getGameDay() {
//		return gameDay;
//	}
//	public void setGameDay(Date gameDay) {
//		this.gameDay = gameDay;
//	}
//	 


	
	
	public Long getId() {
		return id;
	}
	public Trip() {
	super();
}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreatName() {
		return creatName;
	}
	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getCapacity() {
		return Capacity;
	}
	public void setCapacity(Integer Capacity) {
		this.Capacity = Capacity;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}


	
}
