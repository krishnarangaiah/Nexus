package app.controller

import app.AppFileUtil;
import app.controller.enums.AutosysAttribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class AutosysControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testAutosysLanding() throws Exception {
        mockMvc.perform(get("/Autosys/Landing"))
                .andExpect(status().isOk())
                .andExpect(view().name("app/autosys/AutosysDefinitionUploadForm"));
    }

    @Test
    void testUploadAutosysDefinitionFile() throws Exception {
        // Mock the file upload
        String fileContent = "insert_job: test_job\njob_type: c\ncommand: echo 'Hello World'\n";
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "test.jil",
                "text/plain",
                new ByteArrayInputStream(fileContent.getBytes())
        );

        // Mock the AppFileUtil behavior
        Path mockPath = Files.createTempFile("test", ".jil");
        AppFileUtil appFileUtilMock = mock(AppFileUtil.class);
        when(appFileUtilMock.getUserDir()).thenReturn(mockPath.getParent());

        // Perform the file upload
        mockMvc.perform(multipart("/Autosys/UploadDefinitionFile").file(mockFile))
                .andExpect(status().isOk())
                .andExpect(view().name("app/autosys/AutosysDefinitionUploadForm"));

        // Verify the file was saved
        verify(appFileUtilMock, times(1)).getUserDir();
        assertEquals("test.jil", mockPath.getFileName().toString());
    }
}
