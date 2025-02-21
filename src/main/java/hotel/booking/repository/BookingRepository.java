package hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hotel.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
