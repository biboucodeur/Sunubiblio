package sn.unchk.sunubiblio.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "RetournerLivreRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetournerLivreRequest")
public class RetournerLivreRequest {

    private Long livreId;

    // Getter and Setter
    public Long getLivreId() {
        return livreId;
    }
    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }
}
