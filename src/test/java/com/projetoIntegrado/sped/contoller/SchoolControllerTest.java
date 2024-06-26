package com.projetoIntegrado.sped.contoller;

import com.projetoIntegrado.sped.school.SchoolRepository;
import com.projetoIntegrado.sped.school.SchoolRequestDTO;
import com.projetoIntegrado.sped.school.SchoolResponseDTO;
import com.projetoIntegrado.sped.school.Schools;
import com.projetoIntegrado.sped.visit.VisitRepository;
import com.projetoIntegrado.sped.visit.VisitRequestDTO;
import com.projetoIntegrado.sped.visit.Visits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SchoolControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SchoolRepository schoolRepository;

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private SchoolController schoolController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(schoolController).build();
    }

    @Test
    @DisplayName("should get all schools successfully")
    void testGetAll() throws Exception {
        Schools school = new Schools();
        school.setId(1L);
        school.setName("Test School");
        school.setUrgentCall(false);
        school.setSecurityLevel(3);
        school.setLatitude("12.3456");
        school.setLongitude("65.4321");
        school.setSelected(true);
        SchoolResponseDTO schoolResponseDTO = new SchoolResponseDTO(school);
        when(schoolRepository.findAll()).thenReturn(Collections.singletonList(new Schools()));

        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        verify(schoolRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("should save a school successfully")
    void testSaveSchool() throws Exception {
        Schools school = new Schools();
        school.setId(1L);
        school.setName("Test School");
        school.setUrgentCall(false);
        school.setSecurityLevel(3);
        school.setLatitude("12.3456");
        school.setLongitude("65.4321");
        school.setSelected(true);
        SchoolRequestDTO schoolRequestDTO = new SchoolRequestDTO(
                school.getName(),school.getUrgentCall(),
                school.getSecurityLevel(),school.getLatitude(),
                school.getLongitude(),school.getSelected());
        String jsonContent = "{ \"field1\": \"value1\", \"field2\": \"value2\" }";

        mockMvc.perform(post("/home")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk());

        verify(schoolRepository, times(1)).save(any(Schools.class));
    }

    @Test
    @DisplayName("should save visit by schools id successfully")
    void testModalSaveVisit() throws Exception {
        Visits visits = new Visits();
        visits.setId(1L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = sdf.parse("2024-05-15");
        visits.setVisitDate(data);
        visits.setVisitPeriod("afternoon");
        VisitRequestDTO visitRequestDTO = new VisitRequestDTO(visits.getVisitDate(),visits.getVisitPeriod());
        String jsonContent = "{ \"field1\": \"value1\", \"field2\": \"value2\" }"; // Altere conforme necessário

        mockMvc.perform(post("/home/visit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk());

        verify(visitRepository, times(1)).save(any(Visits.class));
    }
}