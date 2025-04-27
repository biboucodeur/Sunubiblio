package sn.unchk.sunubiblio.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SupprimerLivreResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupprimerLivreResponse")
public class SupprimerLivreResponse {

    private String message;

    // Getter and Setter
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
