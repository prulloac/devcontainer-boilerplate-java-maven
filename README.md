# Devcontainer Boilerplate for Spring Boot 3 and PostgreSQL

This repository serves as a boilerplate to illustrate how to develop a Spring Boot 3 application with OpenAPI Swagger-UI, using Maven for compiling and dependency management. It integrates PostgreSQL with Testcontainers for local development and testing purposes. It's designed to be run in Visual Studio Code (VSCode) and GitHub Codespaces, providing a containerized development environment.

## Getting Started

### Running in VSCode

1. **Prerequisites**: Ensure you have [Docker](https://www.docker.com/products/docker-desktop) installed and running on your system. Also, install [Visual Studio Code](https://code.visualstudio.com/) with the [Remote - Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) extension.

2. **Open in Container**: Clone this repository and open it in VSCode. VSCode will prompt you to reopen the folder in a container. Select 'Reopen in Container' to start the containerized environment.

3. **Develop and Test**: Start developing the Spring Boot application and use Testcontainers for running database tests.

### Running in GitHub Codespaces

1. **Setup Codespaces**: Navigate to the GitHub repository and click on the 'Code' button. Select 'Open with Codespaces' and then 'New codespace'.

2. **Develop and Test**: Once the codespace is ready, you can start working on the Spring Boot application and run tests using Testcontainers within the codespace environment.

## Development Workflow

1. **Start Development**: Navigate to the project directory.
2. **Build the Project**: Run `mvn clean install` to build the project and run tests.
3. **Run the Application**: Execute `mvn spring-boot:run` to start the Spring Boot application.

> To properly run the application you must have a valid connection to a database, either external or local with Docker.\
> Conversely, you may run TestCrudRestApiDemoApplication.java so it autoconfigures a TestContainer to run locally.

4. **Access Swagger UI**: Once the application is running, access the Swagger UI at `http://localhost:8080/swagger-ui.html` to interact with the API.

## Testing with Testcontainers

1. **Write Tests**: Create test cases using JUnit and Testcontainers for integration testing with PostgreSQL.
2. **Run Tests**: Execute `mvn test` to run the integration tests.

## License

This project is licensed under the [MIT License](LICENSE).
