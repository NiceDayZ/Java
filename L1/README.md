# Laboratorul 1 Tehnologii Java

## In acest laborator am incercat sa ating toate cele 3 cerinte astfel:

### 1

Pentru cerinta 1 am creat un servlet denumit `WebServlet` in care, prin ajutorul unui serviciu `RequestService` si a clasei `RequestType` procesez cererea de la client in functie de valorile trimise in query conform cerintei. Functia returneaza un raspuns de tip `text/html` ce reprezinta un tabel cu 2 coloane (key, timestamp)

### 2

Pentru cerinta 2 am creat un nou servlet denumit `BackServlet` care se foloseste de aceleasi clase ca in cerinta anterioara cu mentiunea ca raspunsul de aceasta data este de timp `application/json`. Acest servlet este apelat de catre un serviciu extern realizat in Node.js a carei sursa se afla in directorul /src/helper. Scriptul se ruleaza din linia de comanda `node index.js <comanda> <arg...>` si are 3 comenzi. `call` va cere toate argumentele (value, key, sync, mock), `random` va genera aceste argumente in mod aleator iar `stress` primeste ca argumente numarul de call-uri si modul de sincronizare, generand restul de argumente in mod aleator.

### 3

Folosind comanda `stress` din scriptul mentionat anterior se poate observa timpul de executie al cererilor trimise la server. Dupa mai multe incercari am observat ca limita de cereri simultane (in interval de 10-20ms) este de aprox. 200, restul de cereri fiind refuzate iar conexiunea pierduta.

