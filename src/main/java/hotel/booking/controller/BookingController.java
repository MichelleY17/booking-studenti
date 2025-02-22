package hotel.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import hotel.booking.repository.BookingRepository;
import hotel.booking.model.Booking;

@Controller
public class BookingController {
    
	@Autowired
	private BookingRepository bookingRepository;

    @GetMapping("/")
	public String viewHomePage(Model model) {
		List<Booking> bookings = bookingRepository.findAll();
		model.addAttribute("bookings", bookings);
		return "index";	
	}

	@GetMapping("/login")
	public String viewLogin() {
		
		return "login";	
	}

	@GetMapping("/bookings/new")
	public String showNewForm(Model model) {
		model.addAttribute("booking", new Booking());
		return "newBooking";
	}

	@PostMapping("/bookings/ins")
	public String save(@ModelAttribute("booking") Booking booking) {

		bookingRepository.save(booking);
		return "redirect:/";
	}

	@GetMapping("/bookings/edit/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		if(bookingRepository.existsById(id)) {
			Booking booking = bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid booking Id:" + id));
			model.addAttribute("booking", booking);
			return "editBooking";
		}
		else return "redirect:/";
		
	}

	@PostMapping("/bookings/upd")
	public String update(@ModelAttribute("booking") Booking booking) {
		bookingRepository.save(booking);
		return "redirect:/";
	}

	@GetMapping("/bookings/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		if(bookingRepository.existsById(id)) 
			bookingRepository.deleteById(id);;
		return "redirect:/";
	}

}
