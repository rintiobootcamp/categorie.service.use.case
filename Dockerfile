FROM ibrahim/alpine
ADD target/uc_categorie.jar uc_categorie.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","uc_categorie.jar"]