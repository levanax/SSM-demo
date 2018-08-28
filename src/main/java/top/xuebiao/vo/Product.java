package top.xuebiao.vo;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;


public class Product {

	
	private Integer id;
	
	@NotBlank(message="name not allow null")
	@Length(max=10,message="name长度不能超过10")
	private String name;
	
	private String spec;
	private String weight;
	private String remark;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
