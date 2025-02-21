package hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.booking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
