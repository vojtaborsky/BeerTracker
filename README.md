### test DB běží přes docker
#### inicializace db
`docker pull mongo`
#### start db
`docker run --name mongodb -d -p 27017:27017 mongo`
#### reset db
`docker stop mongodb; docker rm mongodb; docker run --name mongodb -d -p 27017:27017 mongo`

#### run app with
`./gradlew bootRun`

#### zkouška přidání hodnocení přes curl (možnost změnit id piva)
```java
curl -X POST http://localhost:8080/beers/4849/ratings \
-H "Content-Type: application/json" \
-d '{
    "stars": 5,
    "description": "v pohodě pívo"
}'
```

#### změna hodnocení přes curl (potřeba doplnit id hodnocení)
```java
curl -X PUT http://localhost:8080/beers/ratings/<rating-id> \
-H "Content-Type: application/json" \
-d '{
    "stars": 2,
    "description": "dneska mi nechutnalo (moc sladké)"
}'
```

#### get všech piv
`curl -X GET http://localhost:8080/beers`

#### get hodnocení daného piva (možnost změnit id piva)
`curl -X GET http://localhost:8080/beers/4849/ratings`
