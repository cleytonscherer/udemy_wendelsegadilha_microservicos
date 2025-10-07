docker run -d --name mailhog -p 1025:1025 -p 8025:8025 mailhog/mailhog:latest

http://localhost:8025/

docker run -d --name postgres -p 5432:5432 -e POSTGRES_DB=udemi_pedidos-api -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres:14.18

docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13.7-management



