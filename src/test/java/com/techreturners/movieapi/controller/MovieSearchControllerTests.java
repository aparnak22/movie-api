package com.techreturners.movieapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieapi.model.Genre;
import com.techreturners.movieapi.model.MovieInfo;
import com.techreturners.movieapi.model.MovieRecommendations;
import com.techreturners.movieapi.service.MovieSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieSearchControllerTests {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private MovieSearchService mockMovieSearchService;

    @InjectMocks
    private MovieSearchController movieSearchController;

    @Autowired
    private MockMvc mockMvcController;

    private MockRestServiceServer mockServer;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(movieSearchController).build();
        mockServer = MockRestServiceServer.createServer(restTemplate);
        mapper = new ObjectMapper();
    }

    @Test
    public void testGetListOfMovies() throws Exception {

        MovieInfo movieInfo = new MovieInfo(399566L, "en", "2021-03-24", "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong " +
                        "on a collision course that will see the two most powerful forces of nature on the planet collide " +
                        "in a spectacular battle for the ages.", 7.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "2",
                new MovieInfo[]{movieInfo},
                747L,
                14938L);

        when(mockMovieSearchService.getRecommendations()).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/search/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(747L));

        /* String url = "http://localhost:8080/search";
        mockServer.expect(ExpectedCount.once(),
                        requestTo(new URI(url)))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(movieRecommendations))
                        );
        */
    }
}
