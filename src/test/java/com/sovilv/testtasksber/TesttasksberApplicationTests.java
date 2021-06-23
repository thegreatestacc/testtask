package com.sovilv.testtasksber;

import com.sovilv.testtasksber.entity.Passport;
import com.sovilv.testtasksber.entity.Person;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TesttasksberApplicationTests {

    private MockMvc mvc;

    public TesttasksberApplicationTests(MockMvc mvc) {
        this.mvc = mvc;
    }

    @SneakyThrows
    @Test
    public void savePerson() {
        mvc.perform(MockMvcRequestBuilders
            .post("/person/add")
                .content(String.valueOf(new Person(UUID.randomUUID(),
                        "personId",
                        "name",
                        "date",
                        "phone",
                        new Passport()
                        )))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void contextLoads() {
    }

}
