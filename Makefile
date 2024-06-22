build-user:
	cd user_application; mvn compile; mvn package; docker build -t user_app:latest -f ./Dockerfile .

build-product:
	cd product_application; mvn compile; mvn package; docker build -t product_app:latest -f ./Dockerfile .

build: build-user build-product
	@echo "---| BUILT ALL APPLICATIONS |---"

run: build
	docker-compose up
