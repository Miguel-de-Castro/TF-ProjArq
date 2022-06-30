package com.bcopstein.Adaptadores.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaFiscalController {
	public static int count = 0;
	@GetMapping("/NotasFiscais")
	public String findAll() {
		return null;
	}
}
