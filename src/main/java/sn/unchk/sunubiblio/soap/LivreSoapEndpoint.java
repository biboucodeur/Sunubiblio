package sn.unchk.sunubiblio.soap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import sn.unchk.sunubiblio.entity.Livre;
import sn.unchk.sunubiblio.entity.Reservation;
import sn.unchk.sunubiblio.service.LivreService;
import sn.unchk.sunubiblio.service.ReservationService;
import sn.unchk.sunubiblio.soap.dto.AjouterLivreRequest;
import sn.unchk.sunubiblio.soap.dto.AjouterLivreResponse;
import sn.unchk.sunubiblio.soap.dto.ModifierLivreRequest;
import sn.unchk.sunubiblio.soap.dto.ModifierLivreResponse;
import sn.unchk.sunubiblio.soap.dto.PreterLivreRequest;
import sn.unchk.sunubiblio.soap.dto.PreterLivreResponse;
import sn.unchk.sunubiblio.soap.dto.RetournerLivreRequest;
import sn.unchk.sunubiblio.soap.dto.RetournerLivreResponse;
import sn.unchk.sunubiblio.soap.dto.SupprimerLivreRequest;
import sn.unchk.sunubiblio.soap.dto.SupprimerLivreResponse;

@Endpoint
public class LivreSoapEndpoint {

    private static final String NAMESPACE_URI = "http://sunubiblio.sn/soap";

    @Autowired
    private LivreService livreService;

    @Autowired
    private ReservationService reservationService;

    //  Ajouter un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AjouterLivreRequest")
    @ResponsePayload
    public AjouterLivreResponse ajouterLivre(@RequestPayload AjouterLivreRequest request) {
        Livre livre = new Livre();
        livre.setTitre(request.getTitre());
        livre.setAuteur(request.getAuteur());
        livre.setDisponible(true);

        Livre savedLivre = livreService.saveLivre(livre);

        AjouterLivreResponse response = new AjouterLivreResponse();
        response.setId(savedLivre.getId());
        response.setTitre(savedLivre.getTitre());
        response.setAuteur(savedLivre.getAuteur());
        response.setDisponible(savedLivre.isDisponible());

        return response;
    }

    //  Modifier un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ModifierLivreRequest")
    @ResponsePayload
    public ModifierLivreResponse modifierLivre(@RequestPayload ModifierLivreRequest request) {
        ModifierLivreResponse response = new ModifierLivreResponse();

        Optional<Livre> optionalLivre = livreService.getLivreById(request.getId());
        if (optionalLivre.isPresent()) {
            Livre livre = optionalLivre.get();
            livre.setTitre(request.getTitre());
            livre.setAuteur(request.getAuteur());
            livreService.saveLivre(livre);
            response.setMessage("Livre modifié avec succès !");
        } else {
            response.setMessage("Livre non trouvé !");
        }
        return response;
    }

    //  Supprimer un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SupprimerLivreRequest")
    @ResponsePayload
    public SupprimerLivreResponse supprimerLivre(@RequestPayload SupprimerLivreRequest request) {
        SupprimerLivreResponse response = new SupprimerLivreResponse();

        Optional<Livre> optionalLivre = livreService.getLivreById(request.getId());
        if (optionalLivre.isPresent()) {
            livreService.deleteLivre(request.getId());
            response.setMessage("Livre supprimé avec succès !");
        } else {
            response.setMessage("Livre non trouvé !");
        }
        return response;
    }

    //  Prêter un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PreterLivreRequest")
    @ResponsePayload
    public PreterLivreResponse preterLivre(@RequestPayload PreterLivreRequest request) {
        PreterLivreResponse response = new PreterLivreResponse();

        try {
            Reservation reservation = reservationService.reserverLivre(request.getLivreId(), request.getNomClient());
            response.setMessage("Livre prêté avec succès à " + reservation.getNomClient());
        } catch (Exception e) {
            response.setMessage("Erreur lors du prêt : " + e.getMessage());
        }

        return response;
    }

    //  Retourner un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RetournerLivreRequest")
    @ResponsePayload
    public RetournerLivreResponse retournerLivre(@RequestPayload RetournerLivreRequest request) {
        RetournerLivreResponse response = new RetournerLivreResponse();

        Optional<Livre> optionalLivre = livreService.getLivreById(request.getLivreId());
        if (optionalLivre.isPresent()) {
            Livre livre = optionalLivre.get();
            livre.setDisponible(true);
            livreService.saveLivre(livre);
            response.setMessage("Livre retourné avec succès !");
        } else {
            response.setMessage("Livre non trouvé !");
        }
        return response;
    }
}
