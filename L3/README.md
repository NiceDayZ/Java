# Laboratorul 3 Tehnologii Java

## In acest laborator am abordat doar prima cerinta:

### 1

Pentru prima subcerinta am creat fisierele `students.xhtml` si `exams.xhtml`. Acestea 2 contin informatii despre studenti si respectiv examene aranjate in tabele. Paginile contin si un formular unde pot fi adaugate noi entitati in baza de date.
Baza de date folosita este o instanta de PostgreSQL, configuratia connection pool-ului fiind facuta in admin console a server-ului de Payara. Pentru comunicarea cu JSF-urile au fost create diverse Clase tip Bean in directorul main/business/beans.
Pentru o mai buna administrare a responsabilitatilor Bean-urile comunica cu Service-uri (main/business/service) ce se ocupa cu tot business logic si comunicarea cu repository-ul de postgresql. Ambele pagini contin si un switch al limbi, fiind oferit suport pentru limba engleza si limba franceza. Acest lucru a fost realizabil prin utilizarea unui Bean ce retine la nivel de sesiune limba dorita, iar prin configurarea in WEB-INF a fisierului `faces-config.xml` a fost posibila utilizarea la nivel de JSF a unei variabile de acces la liniile de text specifice limbii alese.
