package edu.nazaryshyn.security25;

/*
  @author     toha0
  @project IntelliJ IDEA
  @class AccessTesys
  @version 1.0.0
  @since 13.04.2025 - 13.22
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeAll() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithAnonymousUser
    void whenAnonymousAccessAnyone_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/anyone"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymousAccessOnlyUser_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/only-user"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void whenUserAccessOnlyUser_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/only-user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void whenAdminAccessOnlyUser_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/only-user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void whenAdminAccessSuperadminAndAdmin_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/superadmin-and-admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"SUPERADMIN"})
    void whenSuperadminAccessSuperadminAndAdmin_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/superadmin-and-admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void whenUserAccessSuperadminAndAdmin_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/superadmin-and-admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"SUPERADMIN"})
    void whenSuperadminAccessOnlySuperadmin_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/only-superadmin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void whenAdminAccessOnlySuperadmin_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/only-superadmin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void whenUserAccessOnlySuperadmin_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/doctors/only-superadmin"))
                .andExpect(status().isForbidden());
    }
}
