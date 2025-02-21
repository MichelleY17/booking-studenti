package hotel.booking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hotel.booking.model.Room;
import hotel.booking.repository.RoomRepository;

import java.util.List;

@Controller
// @RequestMapping("/")
public class RoomController {

	
	@Autowired
	private RoomRepository roomRepository;


	@GetMapping("/rooms")
	public String listRooms(Model model) {
		List<Room> rooms = roomRepository.findAll();
		model.addAttribute("rooms", rooms);
		return "rooms";
	}

	@GetMapping("/rooms/new")
	public String showNewRoomForm(Model model) {
		model.addAttribute("room", new Room());
		return "newRoom";
	}

	@PostMapping("/rooms/ins")
	public String saveRoom(@ModelAttribute("room") Room room) {
		System.out.println("isAvailable: "+ room.getAvailable());
		roomRepository.save(room);
		return "redirect:/rooms";
	}

	@GetMapping("/rooms/edit/{id}")
	public String showEditRoomForm(@PathVariable("id") int id, Model model) {
		if(roomRepository.existsById(id)) {
			Room room = roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
			model.addAttribute("room", room);
			return "editRoom";
		}
		else return "redirect:/rooms";
		
	}

	@PostMapping("/rooms/upd")
	public String updateRoom(@ModelAttribute("room") Room room) {
		roomRepository.save(room);
		return "redirect:/rooms";
	}

	@GetMapping("/rooms/delete/{id}")
	public String deleteRoom(@PathVariable("id") int id) {
		if(roomRepository.existsById(id)) 
			roomRepository.deleteById(id);;
		return "redirect:/rooms";
	}


	// Add more CRUD methods for each entity as needed
}
