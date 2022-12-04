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
@Table(name="teams")
public class Team {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="teamName is required!")
    @Size(min=3, max=30, message="teamName must be between 3 and 30 characters")
    private String teamName;
    
    @Min(value=1, message="must be equal or greater than 1")  
    @Max(value=5, message="must be equal or less than 5")  
    private Integer skillLevel;
    
    
    @DateTimeFormat(pattern="EEEE")
    @NotNull(message="gameDay is required!")
    
    private Date gameDay;
    
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


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
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
	public Team() {
		
	}
    
	 @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(
         name = "team_players", 
         joinColumns = @JoinColumn(name = "team_id"), 
         inverseJoinColumns = @JoinColumn(name = "user_id")
     )     
    private List<User> users;


	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Date getGameDay() {
		return gameDay;
	}
	public void setGameDay(Date gameDay) {
		this.gameDay = gameDay;
	}
	 
    
}
