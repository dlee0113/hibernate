package com.mkyong.stock;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock_daily_record", uniqueConstraints = @UniqueConstraint(columnNames = "STOCK_DATE"))
public class StockDailyRecord implements java.io.Serializable {

	@Id
	@Column(name = "RECORD_ID", unique = true, nullable = false)
	private Integer recordId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCK_ID", nullable = false)	
	private Stock stock;
	
	@Column(name = "PRICE_OPEN", precision = 6)	
	private Float priceOpen;
	
	@Column(name = "PRICE_CLOSE", precision = 6)	
	private Float priceClose;
	
	@Column(name = "PRICE_CHANGE", precision = 6)
	private Float priceChange;
	
	@Column(name = "VOLUME")	
	private Long volume;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "STOCK_DATE", unique = true, nullable = false, length = 10)
	private Date date;

	public StockDailyRecord() {
	}

	public StockDailyRecord(Stock stock, Date date) {
		this.stock = stock;
		this.date = date;
	}

	public StockDailyRecord(Stock stock, Float priceOpen, Float priceClose,
			Float priceChange, Long volume, Date date) {
		this.stock = stock;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.volume = volume;
		this.date = date;
	}

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Float getPriceOpen() {
		return this.priceOpen;
	}

	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

	public Float getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

	public Float getPriceChange() {
		return this.priceChange;
	}

	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}

	public Long getVolume() {
		return this.volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return "stock ID: " + stock.getStockId() + 
				", priceOpen: " + priceOpen + 
				", priceClose: " + priceClose + 
				", priceChange: " + priceChange + 
				", volume: " + volume + 
				", date: " + new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
