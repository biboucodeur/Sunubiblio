package sn.unchk.sunubiblio.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.unchk.sunubiblio.entity.Livre;
import sn.unchk.sunubiblio.service.LivreService;

@RestController
@RequestMapping("/api/livres")
public class LivreRestController {

    @Autowired
    private LivreService livreService;

    // Récupérer tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    // Récupérer un livre par ID
    @GetMapping("/{id}")
    public Optional<Livre> getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    // Récupérer tous les livres disponibles
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreService.getLivresDisponibles();
    }
}
