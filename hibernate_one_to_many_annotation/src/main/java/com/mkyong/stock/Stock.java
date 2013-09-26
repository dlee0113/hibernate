package com.mkyong.stock;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {

	@Id
//	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	private Integer stockId;
	
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)	
	private String stockCode;
	
	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)	
	private String stockName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")	
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(String stockCode, String stockName,
			Set<StockDailyRecord> stockDailyRecords) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Set<StockDailyRecord> getStockDailyRecords() {
		return this.stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

	public String toString() {
		return "stockId: " + stockId + 
				", stockCode: " + stockCode + 
				", stockName: " + stockName + 
				", stockDailyRecords: " + stockDailyRecords;
	}
}
