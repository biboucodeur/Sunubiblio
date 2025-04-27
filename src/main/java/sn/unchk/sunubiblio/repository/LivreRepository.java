package sn.unchk.sunubiblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.unchk.sunubiblio.entity.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

    // Méthode pour trouver tous les livres disponibles
    List<Livre> findByDisponibleTrue();
}
