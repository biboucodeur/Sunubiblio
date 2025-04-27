package sn.unchk.sunubiblio.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.unchk.sunubiblio.entity.Reservation;
import sn.unchk.sunubiblio.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    //  Créer une réservation
    @PostMapping
    public Reservation reserverLivre(@RequestParam Long livreId, @RequestParam String nomClient) throws Exception {
        return reservationService.reserverLivre(livreId, nomClient);
    }

    //  Suivre une réservation par ID
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }
}
