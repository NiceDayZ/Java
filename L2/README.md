# Laboratorul 1 Tehnologii Java

## In acest laborator am incercat sa ating toate cele 5 cerinte astfel:

### 1

Pentru cerinta 1 am creat cele 2 pagini jsp cerute ce se regasesc in directorul `src/main/webapp`. `input.jsp` este un formular de inserare de filme dupa nume, regizor si categorie. Categoriile sunt reprezentate de un `Enum` (`/src/main/java/com/business/util`) citite dinamic. `results.jsp` este o pagina ce afiseaza un tabel cu toate entitatile preluate dintr-o lista din serviciul static `RecordService`.

### 2

Pentru cerinta 2 am creat ambele filtre ce se regasesc in `src/main/java/com/business/filter`. WebFilter-ul `LogFilter` afiseaza diverse informatii despre request-urile din path-ul `/input` gestionat de `InputServlet`. Informatiile sunt adresa IP, URI-ul, protocolul si parametrii trimisi (cea din urma in special pentru debugging). WebFilter-ul `DecorateFilter` doar adauga un comentariu vizual paginii generate in logurile antetului si footer-ului pentru requestu-urile venite din orice path.

### 3

Pentru cerinta 3 a fost nevoie sa generez fisierul `web.xml` (deoarece Payara nu il genereaza automat pentru aplicatia default) in directorul `/WEB-INF` unde cu ajutorul documentatie am adaugat o variabila de context;

```xml
    <context-param>
        <param-name>category</param-name>
        <param-value>unknown</param-value>
    </context-param>
```

cu ajutorul WebListener-ului `AppContextListener` setam in Service-ul static `RecordService` o categorie default pe care o folosim in caz ca aceasta nu este precizata in formularul de adaugare a unui film.


### 4

Cu ajutorul variabilelor `response` si `request` setez si preiau obiectul de tip cookie si tabelul se populeaza in mod automat in functie de existenta acesteia.

### 5

Cerinta 5 a fost facuta prin adaugarea la formular a unui nou field la formularul de trimitere si generarea a 2 numere random intre 0 si 10. Raspunsul este validat in servlet iar daca raspunsul este incorect, cererea este refuzata.
