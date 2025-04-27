package sn.unchk.sunubiblio.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClient; // étudiant ou professeur
    private LocalDate dateReservation;
    
    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;

    public Reservation() {}

    public Reservation(String nomClient, LocalDate dateReservation, Livre livre) {
        this.nomClient = nomClient;
        this.dateReservation = dateReservation;
        this.livre = livre;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
