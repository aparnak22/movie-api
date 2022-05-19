package com.techreturners.movieapi.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieapi.model.Movie;
import com.techreturners.movieapi.model.MovieRecommendations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;



@RestClientTest(MovieSearchService.class)
public class MovieSearchServiceTest {



    @Autowired
    private MovieSearchService movieSearchService ;

    @Autowired
    private MockRestServiceServer mockServer;
    
    ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ObjectMapper();
    }


    @Test
    public void testSearchMethodIsCalled() throws Exception{

        String testURI=
                "https://api.themoviedb.org/3/discover/movie?api_key=70cb6bbe42e70d00630d60e98da21a75&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=2&with_genres=878&with_watch_monetization_types=flatrate";
        MovieRecommendations movieRecommendations ;
        Movie[] movieInfoArr = new Movie[1];

        movieInfoArr[0] = new Movie(399566L, "en", "2021-03-24", "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity's fight for its future sets Godzilla and Kong " +
                        "on a collision course that will see the two most powerful forces of nature on the planet collide " +
                        "in a spectacular battle for the ages.", 7.0F);

         movieRecommendations =  new MovieRecommendations(
                        "1",
                         movieInfoArr,
                        747L,
                        14938L);

        mockServer.expect(ExpectedCount.once(),
                        requestTo(testURI))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(movieRecommendations))
                );

        MovieRecommendations actual = movieSearchService.getRecommendations();
        assertEquals(movieRecommendations.getTotal_results(), actual.getTotal_results());
        assertEquals(movieRecommendations.getResults()[0].getTitle(), actual.getResults()[0].getTitle());
        mockServer.verify();
    }
}
