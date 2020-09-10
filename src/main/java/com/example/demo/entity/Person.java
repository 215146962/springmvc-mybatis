package com.example.demo.entity;

public class Person {

	private String id;
	private String name;
	private String idCard;
	private String phone;
	private String address;

	public Person(String id, String name, String idCard, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.idCard = idCard;
		this.phone = phone;
		this.address = address;
	}
	
	public Person() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person[id="+id+",name="+name+",idCard="+idCard+",phone="+phone+",address="+address+"]";
	}

}
