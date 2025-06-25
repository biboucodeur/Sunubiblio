# 📚 SunuBiblio - Gestion de bibliothèque universitaire (REST + SOAP)

## 🎯 Objectif
SunuBiblio est une application Spring Boot qui permet :
- aux étudiants et professeurs de **consulter** et **réserver** des livres via une **API REST**.
- aux bibliothécaires de **gérer les livres** et **effectuer les prêts/retours** via une **API SOAP**.

---

## 🛠️ Technologies utilisées
- Java 17
- Spring Boot 3
- Spring Web MVC (REST API)
- Spring Web Services (SOAP)
- Spring Data JPA
- H2 Database (mode fichier pour persistance)
- Swagger UI (pour documentation REST)
- SoapUI (pour tester SOAP)

---

## 📦 Fonctionnalités principales

### ✅ API REST (Consultation publique)
- `GET /api/livres` ➔ Liste de tous les livres
- `GET /api/livres/{id}` ➔ Détail d’un livre
- `GET /api/livres/disponibles` ➔ Liste des livres disponibles (non prêtés, non réservés)
- `POST /api/reservations` ➔ Réserver un livre
- `GET api/reservations/{id}` ➔ Consulter une réservation

### ✅ API SOAP (Gestion interne)
- `AjouterLivre(Livre livre)` ➔ Ajouter un livre
- `ModifierLivre(Long livreId, Livre livre)` ➔ Modifier un livre
- `SupprimerLivre(Long livreId)` ➔ Supprimer un livre
- `PreterLivre(Long userId, Long livreId)` ➔ Prêter un livre à un utilisateur
- `RetournerLivre(Long userId, Long livreId)` ➔ Retourner un livre

---

## 🛠️ Base de données
- H2 en mode **fichier** : les données sont persistées même après redémarrage.
- Console H2 disponible à : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🔗 Documentation API
- Swagger UI pour REST : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- WSDL pour SOAP : [http://localhost:8080/ws/livres.wsdl](http://localhost:8080/ws/livres.wsdl)

---

## ⚙️ Comment exécuter le projet

```bash
# Cloner le projet
git clone https://github.com/biboucodeur/sunubiblio.git

# Aller dans le dossier
cd sunubiblio

# Lancer le projet
./mvnw spring-boot:run
