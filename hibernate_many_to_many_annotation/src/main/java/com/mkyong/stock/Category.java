package com.mkyong.stock;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	@Id
//	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private Integer categoryId;
	
	@Column(name = "NAME", nullable = false, length = 10)	
	private String name;
	
	@Column(name = "DESCRIPTION", nullable = false)	
	private String desc;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")	
	private Set<Stock> stocks = new HashSet<Stock>(0);

	public Category() {
	}

	public Category(Integer categoryId, String name, String desc) {
		this.categoryId = categoryId;
		this.name = name;
		this.desc = desc;
	}

	public Category(String name, String desc, Set<Stock> stocks) {
		this.name = name;
		this.desc = desc;
		this.stocks = stocks;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

}