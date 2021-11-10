# Laboratorul 5 Tehnologii Java

## In acest laborator a fost abordata cerinta 1

### 1

Pentru aceasta cerinta am reciclat din laboratorul 4 data source-ul configurat ca un JDBC Resource, dar de data aceasta am configurat un persistance unit. Configurarea se poate gasi in fisierul `persistence.xml` ce contine:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.2">
    <persistence-unit name="TestJava" transaction-type="JTA">
        <jta-data-source>java3</jta-data-source>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>
    </persistence-unit>
</persistence>
```

In continuare am transformat toate modelele utilizate in laboratorul trecut in Enitati cu ajutorul adnotarii `@Entity`, iar relatia cu baza de deta utilizand adnotarile `@Table` sau `@Column`. Entitatile pot fi gasite in directorul `src/main/java/com/business/model`.

Service-urile sunt folosite pentru business logic, aceastea folosint un `EntityManager` cu ajutorul carora se face comunicarea cu baza de date. Acestea sunt injectate in bean-uri cu ajutorul adnotarii `@Inject` si utilizate de acestea pentru comunicarea interfetei cu aplicatia.
