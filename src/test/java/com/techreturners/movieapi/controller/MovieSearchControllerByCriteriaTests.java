package com.techreturners.movieapi.controller;

import com.techreturners.movieapi.model.Certification;
import com.techreturners.movieapi.model.Movie;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieSearchControllerByCriteriaTests {

    @Mock
    private MovieSearchService mockMovieSearchService;

    @Mock
    private CertificationCategoryLookupService mockCertificationLookupService;

    @InjectMocks
    private  MovieSearchController movieSearchController;

    @Autowired
    private  MockMvc mockMvcController;

    @BeforeEach
    public   void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(movieSearchController).build();
    }


    @Test
    public void testGetListOfMoviesByAge() throws Exception {

        Movie movieInfo = new Movie(1L, "en", "2021-03-24", "Cars",
                "Disney Pixar's Cars", 9.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "1",
                new Movie[]{movieInfo},
                1,
                1L);

        when(mockCertificationLookupService.getCertification(5)).thenReturn(Certification.parental_guidance);

        when(mockMovieSearchService.getRecommendations(Certification.parental_guidance,-1,0)).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/search?age=5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(1L));
    }

    @Test
    public void testGetListOfMoviesByReleaseYearAndAge() throws Exception {

        Movie movieInfo = new Movie(1L, "en", "2021-03-24", "Cars",
                "Disney Pixar's Cars", 9.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "1",
                new Movie[]{movieInfo},
                1,
                1L);

        when(mockCertificationLookupService.getCertification(5)).thenReturn(Certification.parental_guidance);

        when(mockMovieSearchService.getRecommendations(Certification.parental_guidance,2021,0)).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/search?age=5&release_year=2021"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(1L));
    }


    @Test
    public void testGetListOfMoviesByVoteAverage() throws Exception {

        Movie movieInfo = new Movie(1L, "en", "2021-03-24", "Cars",
                "Disney Pixar's Cars", 9.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "1",
                new Movie[]{movieInfo},
                1,
                1L);

        when(mockMovieSearchService.getRecommendations(null,-1,9.0F)).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                    MockMvcRequestBuilders.get("/search?vote_average=9.0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(1L));

    }

    @Test
    public void testGetListOfMoviesByTitle() throws Exception {

        Movie movieInfo = new Movie(1L, "en", "2021-03-24", "Cars",
                "Disney Pixar's Cars", 9.0F);

        MovieRecommendations movieRecommendations = new MovieRecommendations(
                "1",
                new Movie[]{movieInfo},
                1,
                1L);

        when(mockMovieSearchService.getRecommendations("Cars")).thenReturn(movieRecommendations);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/search?title=Cars"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_pages").value(1L));
    }

}
