# Lab 8-9

## Lab 8

### 1

Pentru prima cerinta a laboratorului a fost creata Entitatea `entity/Document` peste care, cu ajutorul unei baze de date H2 in memory, au fost create operatiile CRUD. Baza de date este populata la initializare cu date generate aleator in `db/Database`. Datele sunt prelucrate de catre `repository/DocumentRepository` unde sunt efectuate operatiile persistente cu ajutorul tranzactiilor. Pentru aceasta cerinta specific urmatoarele endpoint-uri au fost expuse:

    GET /data/documents

Acest endpoint returneaza toate resursele de tip Document, sub DTO-ul `dto/GetDocumentDTO` pentru a nu ajunge la recursii daca un document are referinte circulare.

    GET /data/documents/{documentId}

Returneaza un singur document cu id-ul specificat

    POST /data/documents

Primeste ca body continut de tip JSON sub forma `dto/CreateDocumentDTO` si adauga in baza de date un document.

    PATCH /data/documents/{documentId}

Modifica un document existent cu id-ul specificat

    DELETE /data/documents/{documentId}

Sterge documentul cu id-ul specificat


### 2

Pentru cerinta 2, nu am reusit sa creez un filter de caching, dar deoarece am avut nevoie pentru punctul urmator, am implementat un filtru `/filter/CorsResponseFilter` pentru a putea da acces aplicatiilor externe sa faca apeluri asincrone catre API-ul implementat.


### 3

Pentru cerinta 3 am creat entitatile `graph/Graph` `graph/Node` si `graph/Edge` iar entitatii Document a fost adaugata o lista de referinte tip Document, fapt ce a necesitat o legatura de tip `@OneToMany` intre entitati implementata cu ajutorul structurii Set.

Clasa Graph primeste in constructor o lista de Documente si construieste graful orientat pe baza referintelor din document. O muchie intre doc1 si doc2 reprezinta faptul ca doc1 contine doc2 ca referinta. Functia `hasCycles` verifica daca graful creat contine sau nu cicluri intre referinte.

Pentru aceasta cerinta au mai fost create 2 endpoint-uri:

    GET /graph

Returneaza un obiect ce contine o lista de noduri si o lista de muchii

    GET /graph/cyclic

Returneaza daca graful dat are sau nu legaturi circulare

De asemenea pentru aceasta cerinta a fost creat si un vizualizator minimal in javascript care apeleaza extern API-ul si creaza un graf vizual al legaturilor dintre noduri. Codul sursa si modul de executie se pot regasi in `/example`.


## Lab 9

### 1 

Pentru aceasta parte din laborator am expus in alt microserviciu `service-b` un endpoint care este apelat de catre primul serviciu pentru a fi generat un token pe baza unei chei private si una publice.


### 2

Prima cerinta acopera partea de micro-servicii cu ajutorul Payara Micro. De asemenea un fisier de configurare al container-ului de docker a fost creat `docker-compose.yml`. Acesta creaza cele 2 imagini ale microserviciilor intr-un container de docker si expune porturile specifice fiecarei aplicatii.

Pentru a rula 

    docker-compose up -d

```yml
version: '3.3'

services:
  service_a:
    image: payara/micro
    working_dir: /Users/mihaicraciun/School/demo2
    command: java -Xmx2G -Xms1G -XX:+UseG1GC -Djava.net.preferIPv4Stack=true -jar service-a/target/demo-microbundle.jar
    container_name: service_a
    ports:
      - 8080:8080
    expose:
      - 8080
  service_b:
    image: payara/micro
    working_dir: /Users/mihaicraciun/School/demo2
    command: java -Xmx2G -Xms1G -XX:+UseG1GC -Djava.net.preferIPv4Stack=true -jar service-b/target/demo-microbundle.jar --port 8180
    container_name: service_b
    ports:
      - 8180:8180
    expose:
      - 8180
```

