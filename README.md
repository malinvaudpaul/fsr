# Installation 
### Pré-requis:
- avoir une base de données MySQL nommée fsr

### Édition:
- lignes 22 et 25 de src/main/resources/META-INF/persistence.xml, renseigner ses propres credentials
- faire de même avec les lignes 4 et 5 de src/main/resources/application.properties

# Exécution
```./gradlew clean bootRun```
Aller à  http://localhost:8081/addresses pour trouver la liste des adresses inscrites en base de données

# TODO
- [X] faire le projet avec gradle
- [ ] avoir des controllers fonctionnels -> faire du CRUD depuis Postman:
    - [X] Address
    - [ ] Contact 
    - [ ] ContactGroup
    - [ ] phoneNum
- [ ] résoudre le pb de _java.lang.IllegalStateException: Cannot begin Transaction on closed Session/EntityManager_
- [ ] injection de dépendances (@Autowired, etc..)
- [ ] BONUS: tests automatiques