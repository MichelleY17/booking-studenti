package hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.booking.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
