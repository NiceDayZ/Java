# Laboratorul 6 Tehnologii Java

## In acest laborator a fost abordata cerinta 1

### 1

Pentru aceasta cerinta a fost reciclat laboratorul 5 in care am creat 3 noi EJB-uri. `ResourceRepository` din `/com/business/repository` este un in memory database Singleton care la initializare adauga in memorie niste resurse intr-un datatype Map<ResourceType, Integer> semnificand o resursa si numarul disponibil. De asemenea, aceasta clasa manageriaza si ce resurse sunt folosite de fiecare examen prin datatype-ul Map<Integer, List<ResourceType>> semnificand id-ul unui examen si lista de resurse pe care acesta le detine.

Pentru gestionarea Resurselor a fost creata o structura de date tip Enum `ResourceType` in `com/business/util`.

Al doilea EJB creat este `AvailabilityService` in `com/business/service` de tip `Stateless` ce verifica daca o resursa este sau nu disponibila la momentul curent.

Al treilea EJB este `ResourceAssignmentService` in `com/business/service` de tip `Statefull` ce incearca sa atribuie resurse unui examen. Acesta foloseste `@TransactionAttribute`, ceea ce asigura ca daca este aruncata o eroare (cum se intampla in cazul in care una din resurse nu este valabila) restul de modificari sunt anulate.

A fost creata o noua pagina JSP `reservation.xhtml` in `webapp` ce reprezinta un form cu id-ul examenului si mai multe checkbox-uri reprezentand resursele necesare alocate.

# Laboratorul 7 Tehnologii Java

## In acest laborator a fost abordata cerinta 1 si partial cerinta 2

### 1

Pentru acest laborator a fost in continuare folosit acelasi sablon de laborator pe urmatoarea premisa. Exista 2 tipuri de utilizatori (Studenti, Profesori), Profesorii avand posibilitatea sa incarce documente unui examen (reprezentand subiectul examenului ? ). Studentii pot vedea lista cu examene si documentul atasat dupa caz. Doar profesorii pot adauga documente dupa cum urmeaza.

Au fost create 3 pagini JSP noi `login.xhtml`, `register.xhtml` si `file.xhtml`. Fiecarui utilizator ii este atribuit un rol ceea ce permite iar dupa completarea formularului de login, in obiectul SessionScoped `SessionRole` este tinut minte pe parcursul sesiunii rolul utilizatorului autentificat. Doar utilizatorii cu rol de Professor au drept de a incarca fisiere. A fost creata o entitate noua `Accounts` si stocata persistent in baza de date pentru a facilita stocarea persistenta a conturilor.

Fisierele sunt incarcate prin API-ul primefaces (`<p:uploadedFile>`) si descarcate ulterior de catre utilizatori. Fisierele incarcate sunt stocate intr-o baza de date in-memory asemenea resurselor alocate.

### 2

Pentru primul subpunct au fost utilizate adnotarile (@Inject) pentru a folosi entitatea de `SessionRole` care este SessionScoped si (@Transactional), mai exact (@TransactionAttribute) pentru asignarea atomica a resurselor in laboratorul precedent.
