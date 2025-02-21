package hotel.booking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hotel.booking.model.Guest;
import hotel.booking.repository.GuestRepository;
import java.util.List;

@Controller
// @RequestMapping("/")
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;

	@GetMapping("/guests")
	public String listGuests(Model model) {
		List<Guest> guests = guestRepository.findAll();
		model.addAttribute("guests", guests);
		return "guests";
	}

	@GetMapping("/guests/new")
	public String showNewGuestForm(Model model) {
		model.addAttribute("guest", new Guest());
		return "newGuest";
	}

	@PostMapping("/guests/ins")
	public String saveGuest(@ModelAttribute("guest") Guest guest) {
		guestRepository.save(guest);
		return "redirect:/guests";
	}

	@GetMapping("/guests/edit/{id}")
	public String showEditGuestForm(@PathVariable("id") int id, Model model) {
		Guest guest = guestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid guest Id:" + id));
		model.addAttribute("guest", guest);
		return "editGuest";
	}

	@PostMapping("/guests/upd")
	public String updateGuest(@ModelAttribute("guest") Guest guest) {
		guestRepository.save(guest);
		return "redirect:/guests";
	}

	@GetMapping("/guests/delete/{id}")
	public String deleteGuest(@PathVariable("id") int id) {
		// Guest guest = guestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid guest Id:" + id));
		if(guestRepository.existsById(id)) 
			guestRepository.deleteById(id);;
		return "redirect:/guests";
	}

	
	// Add more CRUD methods for each entity as needed
}
