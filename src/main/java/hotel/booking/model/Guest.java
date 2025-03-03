package hotel.booking.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Guests")
public class Guest {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "province")
	private String province;

	@Column(name = "address")
	private String address;

	@Column(name = "birthDay")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDay;

	@Column(name = "identityCard")
	private String identityCard;

	// public int getId() {
	// 	return id;
	// }
	// public void setId(int id) {
	// 	this.id = id;
	// }
	// public String getFirstName() {
	// 	return firstName;
	// }
	// public void setFirstName(String firstName) {
	// 	this.firstName = firstName;
	// }
	// public String getLastName() {
	// 	return lastName;
	// }
	// public void setLastName(String lastName) {
	// 	this.lastName = lastName;
	// }
	
	// public String getPhone() {
	// 	return phone;
	// }
	// public void setPhone(String phone) {
	// 	this.phone = phone;
	// }
	// public String getNationality() {
	// 	return nationality;
	// }
	// public void setNationality(String nationality) {
	// 	this.nationality = nationality;
	// }
	// public String getEmail() {
	// 	return email;
	// }
	// public void setEmail(String email) {
	// 	this.email = email;
	// }
	// public String getCountry() {
	// 	return country;
	// }
	// public void setCountry(String country) {
	// 	this.country = country;
	// }
	// public String getCity() {
	// 	return city;
	// }
	// public void setCity(String city) {
	// 	this.city = city;
	// }
	// public String getState() {
	// 	return state;
	// }
	// public void setState(String state) {
	// 	this.state = state;
	// }
	// public String getProvince() {
	// 	return province;
	// }
	// public void setProvince(String province) {
	// 	this.province = province;
	// }
	// public String getAddress() {
	// 	return address;
	// }
	// public void setAddress(String address) {
	// 	this.address = address;
	// }
	// public LocalDate getBirthDay() {
	// 	return birthDay;
	// }
	// public void setBirthDay(LocalDate birthDay) {
	// 	this.birthDay = birthDay;
	// }
	// public String getIdentityCard() {
	// 	return identityCard;
	// }
	// public void setIdentityCard(String identityCard) {
	// 	this.identityCard = identityCard;
	// }
}

