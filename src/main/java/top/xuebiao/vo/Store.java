package top.xuebiao.vo;

import java.util.Date;

public class Store {

	private Integer id;
	private Integer productID;
	private String productName;
	private String productSpec;
	private Integer total;
	private String remark;
	private Date updateDate;

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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
}
