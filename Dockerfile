# Commencez avec une image de base contenant le runtime Java (Ici, nous utilisons une image de base Maven)
FROM maven:3.6.3-openjdk-17

# Créez un répertoire dans l'image Docker pour les fichiers de l'application
RUN mkdir -p /app

# Définissez l'emplacement de l'application
WORKDIR /app

# Copiez le code source local dans l'image Docker
COPY . /app

# Construisez l'application à l'intérieur de l'image Docker
RUN mvn clean package -DskipTests

# Utilisez l'image openjdk pour exécuter le jar
FROM openjdk:17-jdk-alpine

# Copiez le fichier jar construit dans la première étape
COPY --from=0 /app/target/house-SNAPSHOT.jar /usr/local/app/app.jar

# Définissez la commande de démarrage pour exécuter votre binaire
ENTRYPOINT ["java","-jar","/usr/local/app/app.jar"]



