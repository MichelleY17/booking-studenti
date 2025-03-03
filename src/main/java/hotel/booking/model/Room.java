package hotel.booking.model;

import java.math.BigDecimal;

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
public class Room{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "roomNumber")
	private String  roomNumber;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "price")
	private BigDecimal price;

    @Column(name = "is_available")
	private boolean is_available;

    public int getId() {
        return id;
    }
}
