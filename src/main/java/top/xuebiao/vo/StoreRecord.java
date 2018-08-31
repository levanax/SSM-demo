package top.xuebiao.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StoreRecord {
	
	public static final String INSTRUCTIONS_IMPORT="import";
	public static final String INSTRUCTIONS_EXPORT="export";
	
	private Integer id;
	private Integer productID;
	private Integer userID;
	
	//入库/出库 import/export
	private String instructions;
	
	private Integer quantity;
	private double price;
	private String remark;
	
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateDate;
	
	private String productName;
	private String productSpec;
	
	public StoreRecord() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
