package app.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
class AutosysController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutosysController)

    @GetMapping("/Autosys/Landing")
    def method() {
        LOGGER.info "Autosys Landing Page"
        "app/autosys/Landing"
    }

}
