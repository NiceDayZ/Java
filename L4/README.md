# Laboratorul 4 Tehnologii Java

## In acest laborator am abordat doar prima cerintele : 1, 2 si 4

### 1

pentru cerinta 1 am creat fisierele `page.xhtml`, `hearder.xhtml`, `menu.xhtml` si `footer.xhtml`. `page.xhtml` defineste structura paginii si utilizaaza restul de fisiere pentru templetizarea paginilor ce au sa implementeze `page.xhtml`. Au fost utilizate paginile create in laboratorul trecut pe post de dataView si dataEdit care 'implementeaza' `page.xhtml` schimband in genere doar partea de `content`.

### 2

pentru cerinta 2 a fost creat o componenta composite in directorul `webapp/resources/auto` care defineste o componenta de autocomplete din primefaces. Aceasta este implementata in `enrol.xhtml` iar componenta face autocomplete la numele cursului unde este inscris un student.

### 4

La cerinta 4 a fost necesara configurarea in panoul de administrare Payara un Connection pool si un Resource pentru conexiunea la baza de date tip PostgreSQL. Odata facuta conexiunea cu ajutorul unui obiect Singleton se poate accesa resursa cu numele ales din panoul administrativ, iar din resursa se poate obtine obiectul de tip conexiune.
