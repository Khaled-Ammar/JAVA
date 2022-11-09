package com.khaled.SaveTravels.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="save")

public class Travelsmodel {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    @Size(min = 5, max = 200)
	    private String vendor;
	    @NotNull
	    @Size(min = 5, max = 200)
	    private String expense;
	    @NotNull
	    @Min(100)
	    private Integer amount;
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    public Travelsmodel() {
	    }
	    public Travelsmodel(String vendor, String expense, int amount ) {
	        this.vendor = vendor;
	        this.expense = expense;
	        this.amount = amount;
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		public String getExpense() {
			return expense;
		}
		public void setExpense(String expense) {
			this.expense = expense;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
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
		public Travelsmodel(Long id, @NotNull @Size(min = 5, max = 200) String vendor,
				@NotNull @Size(min = 5, max = 200) String expense, @NotNull @Min(100) Integer amount, Date createdAt,
				Date updatedAt) {
			super();
			this.id = id;
			this.vendor = vendor;
			this.expense = expense;
			this.amount = amount;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
	    }
	    
	 


