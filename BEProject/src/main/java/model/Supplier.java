package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sId;
	@Column(name="SupplierName")
	@Size(min=2,max=10)
	@Pattern(regexp = "[^0-9]*",message="Should not start with a number")
	private String sName;
	@Future
	@Column(name="Date")
	private Date d;
	
	@Min(value=10)
	@Max(value=200)
	private int items;
	private String sAddress;
	@OneToOne(mappedBy="supplier")
	private Product product;
	
	
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Supplier(String sName, String sAddress) {
		this.sName = sName;
		this.sAddress = sAddress;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}	
}
