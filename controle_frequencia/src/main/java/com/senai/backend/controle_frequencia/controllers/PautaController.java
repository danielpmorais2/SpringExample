package com.senai.backend.controle_frequencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.backend.controle_frequencia.models.Pauta;

import com.senai.backend.controle_frequencia.services.PautaService;

public class PautaController {
    @Autowired
    private PautaService pautaService;
    
    public Long contarPauta(){
        return pautaService.contarpauta();
    }
    @GetMapping("/buscar-pauta/(id)")
    public Pauta buscarPauta(@PathVariable Integer id){
        return pautaService.buscarpauta(id);
    }
    @GetMapping("/listar-pautas/")
    public List <Pauta> listarPauta(){
        return pautaService.listarpautas();
    }
    @DeleteMapping("/deletar-pauta/")
    public String deletarPauta(@PathVariable Integer id){
        if (pautaService.deletarpauta(id)) {
            return "Pauta excluída com sucesso";
        }
        return "Falha na exclusão da pauta";
    }
    @PostMapping("salvar-pasta")
    public Pauta cadastrarPauta(@RequestBody Pauta pauta){
        return pautaService.cadastrarpauta(pauta);
    }
     @PutMapping("/atualizar-pauta/(id)")

    public String atualizarPauta(@PathVariable Integer id, @RequestBody Pauta pauta){
        if (pautaService.atualizarpauta(id, pauta)!= null) {
            return "Pauta atualizado com sucesso";
        }
        return "Falha ao atualizar o pauta";
    }


}
