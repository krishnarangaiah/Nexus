package app.controller

import app.AppFileUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

@Controller
class AutosysController {

    private static final Logger LOGGER = LoggerFactory.getLogger AutosysController

    @GetMapping("/Autosys/Landing")
    def autosysLanding() {
        LOGGER.info "Autosys Landing Page"
        "app/autosys/AutosysDefinitionUploadForm"
    }

    @PostMapping("/Autosys/UploadDefinitionFile")
    def uploadAutosysDefinitionFile(@RequestParam("file") MultipartFile file) {
        Path filePath = AppFileUtil.getUserDir().resolve(file.getOriginalFilename())
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING)
        LOGGER.info "Uploading file: {}", filePath.toString()
        "app/autosys/AutosysDefinitionUploadForm"
    }

}
