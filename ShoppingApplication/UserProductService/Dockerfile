FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE="productdb"
ENV MONGO_URI="MONGODB://mongo-service1:27017/productdb"

ADD ./target/UserProductService-0.0.1-SNAPSHOT.jar /usr/lib/UserProductService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserProductService-0.0.1-SNAPSHOT.jar"]