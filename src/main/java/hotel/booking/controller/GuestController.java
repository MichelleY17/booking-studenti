package hotel.booking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.model.Guest;
import hotel.booking.repository.GuestRepository;


@Controller
@RequestMapping("/guests")
//  Mappa tutte le richieste HTTP che iniziano con /guests a questo controller.
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;
	//Inietta il repository degli ospiti."

	@GetMapping("/all")
	public String listGuests(Model model) {
		List<Guest> guests = guestRepository.findAll();
		model.addAttribute("guests", guests);
		// con model (interface) assegno dei attributi alla lista guests in questo caso è lattributo è "guests"
		return "guests";
		// restituisco la vista guests 
		//Carica tutti gli ospiti dal repository
		// "Ottiene tutti gli ospiti dal database e li memorizza nella lista 'guests'."
	}

	@GetMapping("/new")
	public String showNewGuestForm(Model model) {
		// in questa sezione del mapping si sta mostrando il form per inserire un guest
		model.addAttribute("guest", new Guest());
		return "newGuest";
	}

	@PostMapping("/ins")
	public String saveGuest(@ModelAttribute("guest") Guest guest) {
		// qui sto creando un metodo per inserire in guests un nuovo guest
		guestRepository.save(guest);
		// guestRepository.save(guest) sto inserendo guest nella repository
		return "redirect:/guests/all";
		//  reindirizzo alla lista di ospiti
	}

	@GetMapping("/edit/{id}")
	public String showEditGuestForm(@PathVariable("id") int id, Model model) {
		// sto creando un metodo showEditGuestForm per ottenere tramite id il guest modificato
		Guest guest = guestRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid guest Id:" + id));
		//  , se l'id non esiste mi da un errore:"Invalid guest Id:" + l'id inserito
		model.addAttribute("guest", guest);
		return "editGuest";
		// restiuisce la form editGuest
	}

	@PostMapping("/upd")
	public String updateGuest(@ModelAttribute("guest") Guest guest) {
		// con questo metodo posso aggiornare un ospite esistente
		guestRepository.save(guest);
		//  aggiorno i dati
		return "redirect:/guests/all";
		// rindirizzo alla lista.
	}

	@GetMapping("/delete/{id}")
	public String deleteGuest(@PathVariable("id") int id) {
		// con questo metodo tramite id elimino un ospite
		if(guestRepository.existsById(id)) 
		// se l'ospite esiste 
			guestRepository.deleteById(id);
			// elimina l'ospite
		return "redirect:/guests/all";
		// rindirizzo alla lista
	}

	
}
// Controller è un componente software responsabile di gestire le richieste degli utenti e di coordinare la logica dell'applicazione per produrre una risposta. Nel contesto di Spring MVC (Model-View-Controller), 
// un controller è un componente chiave che:

// Riceve le richieste: Ascolta le richieste HTTP (come GET, POST, PUT, DELETE) che arrivano dal client (browser, app, ecc.).
// Elabora la logica: Contiene la logica di business dell'applicazione. Ad esempio, può recuperare dati dal database, eseguire calcoli, o chiamare altri servizi.
// Restituisce una risposta: Prepara una risposta da inviare al client. Questa risposta può essere una pagina HTML, dati JSON, un file, o un altro tipo di contenuto.
// Media tra vista e modello: nel pattern MVC, il controller si occupa di collegare il modello (i dati) con la vista (la presentazione).
