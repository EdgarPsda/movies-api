
# Movie Pictures API

This project is a REST API developed with Spring Boot 3, designed to manage movie images. It allows users to list movie images, vote on them, and view them grouped by their release year. It uses PostgreSQL as the database management system and Swagger for API documentation. Special emphasis has been placed on testing and custom error handling to ensure the application's robustness.

## Technologies Used

- **Spring Boot 3**: For backend development and business logic.
- **PostgreSQL**: As the database for storing movie image information.
- **Swagger**: To document and test the API endpoints interactively.

## Getting Started

### Prerequisites

- JDK 11 or higher.
- Maven or Gradle.
- PostgreSQL.

### Installation

Clone the repository and set up the PostgreSQL connection in `application.properties` (Please make sure to add application.properties without _example word). 


### Database

To use the Movie Pictures API, you need to set up the `movie_pictures` table in your PostgreSQL database. You can use the following SQL script to create the table and insert some dummy data:

```bash
sql_script = """
CREATE TABLE IF NOT EXISTS movie_pictures (
    id SERIAL PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    favorites_count INT NOT NULL,
    movie_id INT NOT NULL,
    release_year INT NOT NULL
);

INSERT INTO movie_pictures (url, favorites_count, movie_id, release_year) VALUES
('http://example.com/movie1.jpg', 10, 1, 2022),
('http://example.com/movie2.jpg', 5, 2, 2022),
('http://example.com/movie3.jpg', 8, 3, 2021),
('http://example.com/movie4.jpg', 15, 4, 2021),
('http://example.com/movie5.jpg', 20, 5, 2020);
"""
```


Run the project with:

```bash
mvn spring-boot:run
```

## APIs

The API supports the following operations:

- **GET `/api/v1/movie-pictures`**: Lists all available movie images.

- **GET `/api/v1/movie-pictures/release-year/{releaseYear}`**: Lists movie images based on a specific release year.

- **GET `/api/v1/movie-pictures/grouped-by-release-year`**: Lists all movie images grouped by their release year.

- **POST `/api/v1/movie-pictures/vote-up/{id}/{vote}`**: Allows voting "up" or "down" for a specific movie image, identified by its ID. The `{vote}` parameter must be `up` for a positive vote or `down` for a negative vote.

## Custom Error Handling

The project implements custom error handling, ensuring that any errors are captured and returned in a coherent and understandable manner. This includes errors such as resources not found, data validation errors, and other application errors.

## Swagger Documentation

To access the interactive Swagger documentation and test the API endpoints, start the application and navigate to `http://localhost:8080/swagger-ui.html`.

## Tests

This project emphasizes the importance of testing, including unit and integration tests to ensure a high level of code coverage and application quality.

To run the tests:

```bash
mvn test
```

## Code Coverage

Code coverage is a measure of how much of your code is being tested by your test suite. It helps identify areas of your code that are not covered by tests, allowing you to improve the overall quality and reliability of your application.

In this project, code coverage is measured using JaCoCo, a popular code coverage tool for Java applications. The current code coverage percentage is 97%, indicating that the majority of the code is being tested.

To generate a code coverage report with JaCoCo, you can use the following command:

```bash
mvn clean verify
```

You can see the complete report in the following file:

`\target\site\jacoco\index.html`

## License

This project is licensed under the MIT License - see the `LICENSE.md` file for details.
