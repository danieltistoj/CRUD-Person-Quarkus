<div>
  <h1>User API Endpoint Documentation</h1>

  <h2>Endpoint: <span style="color: blue;">GET</span> one person by id</h2>
  <p>Retrieves information about a specific person by their ID.</p>
  <h3>Request</h3>
  <pre><code><span style="color: green;">GET</span> http://localhost:8080/person/OnePersonById/52</code></pre>
  <p>Description: Gets information about the authenticated user.</p>

  <h3>Response</h3>
  <p><strong>Successful Response:</strong></p>
  <pre><code>Status: 200 OK
Content-Type: application/json

{
  "user": {
    "id": 12345678,
    "username": "taylor-lee",
    "email": "taylor.lee@example.com",
    "fullName": "Taylor Lee",
    "avatar": "https://example.com/user/r5u9qpvmujfjf6lbqmga.jpg",
    "isPublic": true
  },
  "operations": [
    {
      "name": "mock_usage",
      "limit": 1000000,
      "usage": 110276,
      "overage": 0
    },
    {
      "name": "monitor_request_runs",
      "limit": 10000000,
      "usage": 1141750,
      "overage": 0
    },
    {
      "name": "api_usage",
      "limit": 1000000,
      "usage": 16240,
      "overage": 0
    },
    {
      "name": "custom_domains",
      "limit": 25,
      "usage": 25,
      "overage": 0
    },
    {
      "name": "serverless_requests",
      "limit": 10000,
      "usage": 0,
      "overage": 0
    },
    {
      "name": "integrations",
      "limit": 5000,
      "usage": 1018,
      "overage": 0
    },
    {
      "name": "cloud_agent_requests",
      "limit": 1000000,
      "usage": 1615,
      "overage": 0
    }
  ]
}</code></pre>

  <p><strong>Rate Limit Exceeded Response:</strong></p>
  <pre><code>Status: 429 Too Many Requests
Content-Type: application/json

{
  "error": "rateLimited",
  "message": "Rate limit exceeded. Please retry after 1669048687"
}</code></pre>


  <h2>Endpoint: <span style="color: blue;">POST</span> new person</h2>
  <p>Creates a new person.</p>
  <h3>Request</h3>
  <pre><code><span style="color: green;">POST</span> http://localhost:8080/person/newPerson</code></pre>
  <p>Description: Provide the person information in the request body.</p>
  <p>Request Body:</p>
  <pre><code>{
    "name": "María",
    "date": "1998-02-02",
    "direction": "Avenida 2",
    "phone": "2222222"
}</code></pre>

  <h3>Response</h3>
  <p>No response specified.</p>


  <h2>Endpoint: <span style="color: blue;">PUT</span> update person</h2>
  <p>Updates information about a person.</p>
  <h3>Request</h3>
  <pre><code><span style="color: green;">PUT</span> http://localhost:8080/person/updatePerson/1</code></pre>
  <p>Description: Provide the updated person information in the request body.</p>
  <p>Request Body:</p>
  <pre><code>{
    "name": "juan luis",
    "date": "1999-04-22",
    "direction": "calle 3",
    "phone": "7777888"
}</code></pre>

  <h3>Response</h3>
  <p>No response specified.</p>


  <h2>Endpoint: <span style="color: blue;">GET</span> all person</h2>
  <p>Retrieves information about all persons.</p>
  <h3>Request</h3>
  <pre><code><span style="color: green;">GET</span> http://localhost:8080/person/getAll</code></pre>

  <h3>Response</h3>
  <p>No response specified.</p>


  <h2>Endpoint: <span style="color: blue;">DELETE</span> all person Copy</h2>
  <p>Deletes a person.</p>
  <h3>Request</h3>
  <pre><code><span style="color: green;">DELETE</span> http://localhost:8080/person/deletePerson/101</code></pre>

  <h3>Response</h3>
  <p>No response specified.</p>

</div>

# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

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
