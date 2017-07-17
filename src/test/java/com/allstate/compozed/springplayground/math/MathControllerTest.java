package com.allstate.compozed.springplayground.math;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void squareShouldReturn16() throws Exception {
        mockMvc.perform(get("/math/square/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.square", is(16)));
    }

    @Test
    public void squareShouldReturn25() throws Exception {
        mockMvc.perform(get("/math/square/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.square", is(25)));
    }

    @Test
    public void factorialShouldReturn1() throws Exception {
        mockMvc.perform(get("/math/factorial/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.factorial", is(1)));

    }

    @Test
    public void factorialShouldReturn2() throws Exception {
        mockMvc.perform(get("/math/factorial/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.factorial", is(2)));
    }

    @Test
    public void factorialShouldReturn20() throws Exception {
        mockMvc.perform(get("/math/factorial/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.factorial", is(120)));
    }

    @Test
    public void fibonacciShouldReturn1() throws Exception {
        mockMvc.perform(get("/math/fibonacci/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fibonacci", is(1)));
    }

    @Test
    public void fibonacciShouldReturn2() throws Exception{
        mockMvc.perform(get("/math/fibonacci/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fibonacci", is(1)));
    }
}