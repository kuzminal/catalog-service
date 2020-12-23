# Getting Started

### Create and run PostgreSQL with Docker
Create:

docker run --name bookshop_catalogdb -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=bookshop_catalogdb -p 5432:5432 -d postgres:13

Check if it's running:

docker exec -it bookshop_catalogdb psql -U admin -d bookshop_catalogdb





