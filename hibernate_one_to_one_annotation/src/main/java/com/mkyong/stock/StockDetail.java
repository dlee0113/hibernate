package com.mkyong.stock;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "stock_detail")
public class StockDetail implements java.io.Serializable {
	@Id
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	@GeneratedValue(generator = "generator")	
	@GenericGenerator(
			name = "generator", 
			strategy = "foreign", 
			parameters = @Parameter(name = "property", value = "stock")
	)
	private Long stockId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "STOCK_ID", referencedColumnName = "STOCK_ID")
	private Stock stock;
	
	@Column(name = "COMP_NAME", nullable = false, length = 100)
	private String compName;
	
	@Column(name = "COMP_DESC", nullable = false)
	private String compDesc;
	
	@Column(name = "REMARK", nullable = false)
	private String remark;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LISTED_DATE", nullable = false, length = 10)
	private Date listedDate;

	public StockDetail() {
		
	}

	public StockDetail(Stock stock, String compName, String compDesc,
			String remark, Date listedDate) {
		this.stock = stock;
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}


	public Long getStockId() {
		return this.stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompDesc() {
		return this.compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getListedDate() {
		return this.listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	public String toString() {
		return "stockId: " + stockId + 
				", compName: " + compName + 
				", compDesc: " + compDesc + 
				", remark: " + remark + 
				", listedDate: " + new SimpleDateFormat("yyyy-MM-dd").format(listedDate);
	}
}
