package hotel.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Rooms")
public class Rooms {
	
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


}