package jp.ac.ohara.address.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="addresses")

public class AddressBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column (length=32,nullable=false)
	private String name;
	
	@Column (length=16, nullable=false)
	private String phone;
	
	@Column (length=64, nullable=false)
	private String mailAddress;
	
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	public String getPhone() {
		return mailAddress;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
