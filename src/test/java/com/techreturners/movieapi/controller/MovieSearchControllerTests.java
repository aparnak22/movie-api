package com.techreturners.movieapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieapi.model.Movie;
import com.techreturners.movieapi.model.MovieRecommendations;
import com.techreturners.movieapi.service.MovieSearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

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

        Movie movieInfo = new Movie(399566L, "en", "2021-03-24", "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong " +
                        "on a collision course that will see the two most powerful forces of nature on the planet collide " +
                        "in a spectacular battle for the ages.", 7.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "2",
                new Movie[]{movieInfo},
                747L,
                14938L);

        when(mockMovieSearchService.getRecommendations(null,-1,0)).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/search"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(747L));


    }
}
