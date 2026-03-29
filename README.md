# Music API i Web Service
### Opis:
Proste REST API do zarządzania bazą muzyczną (Artyści, albumy oraz utwory). Projekt demonstruje implementację logiki biznesowej w oparciu o architekturę warstwową, obsługę relacyjnych baz danych oraz konteneryzację.

### Technologie:
* **Język:** Java 17
* **Framework:** Spring Boot (Spring Data JPA, Spring Web)
* **Baza danych:** MySQL
* **Infrastruktura:** Docker, Docker Compose.
* **Narzędzia:** Maven, i18n (Pl, EN, IT)

### Jak uruchomić:
1. **Sklonuj repozytorium:**
```
git clone https://github.com/PatKowal/MusicApp
```
2. **Uruchom bazę danych (Docker):**
Projekt wykorzystuje MySQL w kontenerze.  Upewnij się, że masz zainstalowanego Dockera i uruchom go komendą:
```
docker-compose up -d
```
3. **Zbuduj i uruchom aplikację:**
Aplikacja korzysta z narzędzia Maven. Możesz ją uruchomić bezpośrednio z poziomu IntelliJ IDEA lub za pomocą terminala:
```
./mvnw spring-boot:run
```
4. **Testowanie i dostęp (Web i API):**
**Interfejs Web:** Po uruchomieniu, aplikacja jest dostępna pod adresem http://localhost:8080. Możesz przeglądać katalog artystów, albumów i utworów bezpośrednio w przeglądarce dzięki dynamicznym widokom.
**Testowanie API:** Uruchom music.http znajdujący się z głównym folderze projektu, aby przetestować endpointy bez konieczności korzystania z zewnętrznych narzędzi typu Postman.
