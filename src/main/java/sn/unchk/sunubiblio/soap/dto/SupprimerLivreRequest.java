package sn.unchk.sunubiblio.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SupprimerLivreRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupprimerLivreRequest")
public class SupprimerLivreRequest {

    private Long id;

    // Getter and Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
