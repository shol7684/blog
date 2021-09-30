package com.blog.error;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ExcepHandler {

	public String noLogin(Model model,RedirectAttributes rttr,HttpServletRequest request) {
		return null;

	}
}
