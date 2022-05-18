package com.techreturners.movieapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.movieapi.model.Certification;
import com.techreturners.movieapi.model.MovieInfo;
import com.techreturners.movieapi.model.MovieRecommendations;
import com.techreturners.movieapi.service.CertificationCategoryLookupService;
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

@AutoConfigureMockMvc
@SpringBootTest
public class MovieSearchControllerByAgeTests {

    @Mock
    private static RestTemplate restTemplate;

    @Mock
    private MovieSearchService mockMovieSearchService;

    @Mock
    private CertificationCategoryLookupService mockCertificationLookupService;

    @InjectMocks
    private  MovieSearchController movieSearchController;

    @Autowired
    private  MockMvc mockMvcController;

    private   MockRestServiceServer mockServer;

    private  ObjectMapper mapper;

    @BeforeEach
    public   void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(movieSearchController).build();
        mockServer = MockRestServiceServer.createServer(restTemplate);
        mapper = new ObjectMapper();
    }


    @Test
    public void testGetListOfMoviesByAge() throws Exception {

        MovieInfo movieInfo = new MovieInfo(1L, "en", "2021-03-24", "Cars",
                "Disney pixar's Cars"
                        , 9.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "1",
                new MovieInfo[]{movieInfo},
                1,
                1L);

        when(mockCertificationLookupService.getCertification(5)).thenReturn(Certification.parental_guidance);

        when(mockMovieSearchService.getRecommendations(Certification.parental_guidance)).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/search?age=5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(1L));


    }
}
