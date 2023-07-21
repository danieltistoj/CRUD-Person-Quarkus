# API Documentation

# Índice

# Índice

- [Person Endpoints](#person-endpoints)
    - [Get One Person by ID](#get-one-person-by-id)
    - [Add New Person](#add-new-person)
    - [Update Person](#update-person)
    - [Get All Persons](#get-all-persons)
    - [Delete Person](#delete-person)

- [Pet Endpoints](#pet-endpoints)
    - [Get One Pet by ID](#get-one-pet-by-id)
    - [Add New Pet](#add-new-pet)
    - [Update Pet](#update-pet)
    - [Get All Pets](#get-all-pets)
    - [Delete Pet](#delete-pet)

- [User Endpoints](#user-endpoints)
    - [Sign In](#sign-in)
    - [Log In](#log-in)

- [Running the application in dev mode](#running-the-application-in-dev-mode)

- [Packaging and running the application](#packaging-and-running-the-application)

- [Creating a native executable](#creating-a-native-executable)

- [Related Guides](#related-guides)
    - [RESTEasy Reactive](#resteasy-reactive)
    - [Hibernate ORM with Panache](#hibernate-orm-with-panache)
    - [Agroal - Database connection pool](#agroal-database-connection-pool)
    - [JDBC Driver - PostgreSQL](#jdbc-driver-postgresql)
    

- [Provided Code](#provided-code)
    - [Hibernate ORM](#hibernate-orm)
    - [RESTEasy Reactive](#resteasy-reactive)

---

## Person Endpoints

### Get One Person by ID

- **URL**: `http://localhost:8080/person/OnePersonById/{{id}}`
- **Method**: GET
- **Description**: Gets information about a specific person by their ID.

### Add New Person

- **URL**: `http://localhost:8080/person/newPerson`
- **Method**: POST
- **Description**: Creates a new person with the provided details.
- **Body**:
```json
{    
    "name": "Juan",
    "date": "2000-01-2",
    "direction": "Avenida 5",
    "phone": "777777"
}
```

### Update Person

- **URL**: `http://localhost:8080/person/updatePerson/{{id}}`
- **Method**: PUT
- **Description**: Updates the information of an existing person based on their ID.
- **Body**:
```json
 {      
        "name": "Pablo",
        "date": "2000-01-2",
        "direction": "Avenida 5",
        "phone": "777777"
    }   
```
### Get All Persons

- **URL**: `http://localhost:8080/person/getAll`
- **Method**: GET
- **Description**: Retrieves information about all available persons.

### Delete Person

- **URL**: `http://localhost:8080/person/deletePerson/{{id}}`
- **Method**: DELETE
- **Description**: Deletes a person with the specified ID.

## Pet Endpoints

### Get One Pet by ID

- **URL**: `http://localhost:8080/pet/OnePetById/{{id}}`
- **Method**: GET
- **Description**: Gets information about a specific pet by their ID.

### Add New Pet

- **URL**: `http://localhost:8080/pet/newPet`
- **Method**: POST
- **Description**: Adds a new pet with the provided details.
- **Body**:
```json
{   
    "name": "rocky",
    "race": "pitbull",
    "age": 5

}
```

### Update Pet

- **URL**: `http://localhost:8080/pet/updatePet/{{id}}`
- **Method**: PUT
- **Description**: Updates the information of an existing pet based on their ID.
- **Body**:
```json    
 {      
    "name": "max 1",
    "race": "pastor alemean",
    "age": 10
 }    
```

### Get All Pets

- **URL**: `http://localhost:8080/pet/getAll`
- **Method**: GET
- **Description**: Retrieves information about all available pets.

### Delete Pet

- **URL**: `http://localhost:8080/pet/deletePet/{{id}}`
- **Method**: DELETE
- **Description**: Deletes a pet with the specified ID.

## User Endpoints

### Sign In

- **URL**: `http://localhost:8080/user/SignIn`
- **Method**: POST
- **Description**: Signs in the user with the provided credentials.
- **Body**:

```json
{
    "user_name": "jose",
    "password": "1234"
}
```

### Log In

- **URL**: `http://localhost:8080/user/LogIn`
- **Method**: POST
- **Description**: Logs in the user with the provided credentials.
- **Body**:

```json
{
    "user_name": "jose",
    "password": "1234"
}
```


# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework, and was developed using JDK 17 of Java.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
