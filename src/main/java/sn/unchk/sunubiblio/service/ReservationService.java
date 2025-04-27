package sn.unchk.sunubiblio.service;

import sn.unchk.sunubiblio.entity.Livre;
import sn.unchk.sunubiblio.entity.Reservation;
import sn.unchk.sunubiblio.repository.LivreRepository;
import sn.unchk.sunubiblio.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LivreRepository livreRepository;

    // Créer une réservation
    public Reservation reserverLivre(Long livreId, String nomClient) throws Exception {
        Optional<Livre> livreOpt = livreRepository.findById(livreId);
        
        if (livreOpt.isEmpty()) {
            throw new Exception("Livre non trouvé");
        }

        Livre livre = livreOpt.get();

        if (!livre.isDisponible()) {
            throw new Exception("Livre non disponible");
        }

        // Marquer le livre comme non disponible
        livre.setDisponible(false);
        livreRepository.save(livre);

        // Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setNomClient(nomClient);
        reservation.setDateReservation(LocalDate.now());
        reservation.setLivre(livre);

        return reservationRepository.save(reservation);
    }

    // Suivre une réservation par ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}
