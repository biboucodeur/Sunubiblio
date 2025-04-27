package sn.unchk.sunubiblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.unchk.sunubiblio.entity.Livre;
import sn.unchk.sunubiblio.repository.LivreRepository;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    // Récupérer tous les livres
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Récupérer un livre par son ID
    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    // Récupérer tous les livres disponibles
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }

    // Ajouter ou mettre à jour un livre
    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    // Supprimer un livre
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
