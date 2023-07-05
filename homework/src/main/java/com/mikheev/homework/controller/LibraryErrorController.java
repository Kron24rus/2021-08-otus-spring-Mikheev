package com.mikheev.homework.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

@Controller
public class LibraryErrorController extends AbstractErrorController {

    private final ErrorAttributes errorAttributes;

    public LibraryErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                Map<String, Object> attributesMap = errorAttributes
                        .getErrorAttributes(new ServletWebRequest(request),
                                ErrorAttributeOptions.defaults().including(ErrorAttributeOptions.Include.MESSAGE));
                model.mergeAttributes(attributesMap);
            } else {
                model.addAttribute("message", "Something went wrong, we are already working " +
                        "on resolution, please try again later");
            }
        }
        return "error";
    }
}
