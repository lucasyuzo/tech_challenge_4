start:
	mvn spring-boot:start

build:
	mvn compile

package:
	mvn package

unit-test:
	@echo "executando testes unitários"
	@mvn test

docker-build: package
	 docker build -t user_app:latest -f ./Dockerfile .
