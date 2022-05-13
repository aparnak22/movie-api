# MovieAPI
YRTT group project. 

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


