package hotel.booking.repository;

// import java.util.List;
// Importa la classe List dal package java.util. Anche se non è usata direttamente in questa semplice repository, 
// è utile sapere che JpaRepository e I suoi metodi usano List per restituire liste di oggetti.

import org.springframework.data.jpa.repository.JpaRepository;
// Importa l'interfaccia JpaRepository da Spring Data JPA. 
// Questa è l'interfaccia chiave che fornisce i metodi per interagire con il database tramite JPA (Java Persistence API).

// import org.springframework.data.jpa.repository.NativeQuery;
// Importa l'annotazione NativeQuery. Anche se non è usata direttamente in questa semplice repository, è utile sapere che
//  questa annotazione viene usata quando si vuole eseguire una query SQL nativa.

import hotel.booking.model.Guest;
// Importa la classe Guest dal package hotel.booking.model. 
// Questa è l'entità JPA che rappresenta la tabella "guest" nel database.
public interface GuestRepository extends JpaRepository<Guest, Integer> {
// Definisce l'interfaccia GuestRepository.
// extends JpaRepository<Guest, Integer>: Questa è la parte cruciale. Indica che GuestRepository eredita tutti i metodi da JpaRepository.
// Guest: Il primo parametro generico specifica il tipo di entità gestita dalla repository (in questo caso, Guest).
// Integer: Il secondo parametro generico specifica il tipo della chiave primaria dell'entità Guest (in questo caso, Integer).
}
// nell'ambito dello sviluppo software, una repository è un componente che funge da intermediario tra 
// la tua applicazione e il sistema di persistenza dei dati (tipicamente un database). 
// Il suo scopo principale è quello di incapsulare le operazioni di accesso ai dati,
//  fornendo un'interfaccia pulita e semplice per interagire con il database.




