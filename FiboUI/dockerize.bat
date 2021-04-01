.\mvnw.cmd package

docker build --build-arg JAR_FILE=target/*.jar -t fibo/ui:dev .