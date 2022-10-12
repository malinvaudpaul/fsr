# Installation 
### Pré-requis:
- avoir une base de données MySQL nommée fsr

### Édition:
- lignes 22 et 25 de src/main/resources/META-INF/persistence.xml, renseigner ses propres credentials
- faire de même avec les lignes 4 et 5 de src/main/resources/application.properties

# Exécution
```./gradlew clean bootRun```
Aller à  http://localhost:8081/addresses pour trouver la liste des adresses inscrites en base de données
