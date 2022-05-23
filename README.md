
# ![img.png](img.png) 
MovieAPI
YRTT group project.

## Introduction
Get movie recommendations based on inputted criteria, e.g.
year/genre/actor/ratings/certification. Add checks for the age of who will be watching using a Test-Driven Development approach.

### Pre-Requisites
- Java SE Development Kit 11
- Maven

### Technologies & Dependencies
- Spring Boot
- Spring Web
- H2 Database
- Lombok
- Spring Data JPA

### How to Get Started
- Fork this repo to your Github and then clone the forked version of this repo

### Main Entry Point
- The Main Entry Point for the application is: [MovieApiApplication.java](src/main/java/com/techreturners/movieapi/MovieApiApplication.java)

### Running the Unit Tests
- You can run the unit tests in IntelliJ, or you can go to your terminal and inside the root of this directory, run:

`mvn test`

### Tasks

Here are some tasks for you to work on:

📘 Requirement Analysis Task

### User Stories:
1. *As a user, I'd like to be able to see movie recommendations for a search criteria based on age.*
   - Features to implement:
      * Get all movies.
      * Get a list of movies by title.
      * Get a list of movies by language.
      * Get a list of movies by genre.
      * Get a list of movies by an actor.
      * Get a list of movies by year/age.
      * Get a list of movies by certification.
      * Get a movie by rating.
        so that I can decide which one to watch or save to my favourites

2. *As a user, I'd like to be able to search in my favourite movie list.*
   - Features to implement:
      * Get all movies.
      * Search by criteria
        so that I can select one to watch

3. *As a user, I'd like to be able to add a movie to my favourite movie list.*
   - Features to implement:
      * Create/Add a new movie in the user's favourites list.
        so that I can save it to watch later

4. *As a user, I'd like to be able to delete a movie from my favourite movie list.*
   - Features to implement:
      * Delete a movie in the user's favourites list if it exists.
         so that I can remove a movie from the list.
     
### Acceptance Criteria

We have listed the acceptance criteria in two formats to help with learning. 

------- as given when then -----

1. GIVEN a user wants a search for a movie
   WHEN they specify the search criteria and age of the viewer
   THEN the user is shown the list of movies matching the criteria

2. GIVEN a user with a list of favourite movies
   WHEN they choose the option to see the list of their favourites
   THEN the user is shown the list 

3. GIVEN a user wants to add a movie to their favourites
   WHEN they select a movie 
   THEN the movie is added to the list of favourites for the user.
 
4. GIVEN a user wants to remove a movie from their favourites
   WHEN they select a movie
   THEN that movie is removed from the list of favourites for the user.
 

---- As a feature list---
1. User can search for movies for the any of the following combination of criteria:
   language/genre/actor/year/certification + age
2. The user can view the list of their favourite movies
3. The user can search the list of their favourite movies based on a criteria
4. The user can add to their list of favourite movies
5. The user can delete from their list of favourites. 

📘  Extension Ideas:

Use the Twilio API (https://www.twilio.com/docs/sms) to send a text to the user with the returned
information.
Deploy your API onto a cloud service, such as AWS.


### Solution

### Database
The application needs a database in MySQL called 'movieapidb' . Once the database is created, 
hibernate will create the necessary tables the first time the application is run. 