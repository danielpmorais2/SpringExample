package com.senai.backend.controle_frequencia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
@Autowired
    private UsuarioService usuarioService;
    
}
