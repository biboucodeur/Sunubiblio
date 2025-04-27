package sn.unchk.sunubiblio.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PreterLivreRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreterLivreRequest")
public class PreterLivreRequest {

    private Long livreId;
    private String nomClient;

    // Getters and Setters
    public Long getLivreId() {
        return livreId;
    }
    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }
    public String getNomClient() {
        return nomClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
}
