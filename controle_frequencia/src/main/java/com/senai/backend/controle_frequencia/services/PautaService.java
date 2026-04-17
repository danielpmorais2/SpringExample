package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.backend.controle_frequencia.models.Pauta;
import com.senai.backend.controle_frequencia.repositories.PautaRepository;

public class PautaService {
     @Autowired
    private PautaRepository pautaRepository;

    public Long contarpauta(){
        return pautaRepository.count();
    }

    public Pauta buscarpauta(Integer id){
        return pautaRepository.findById(id).get();

    }
    public List<Pauta> listarpautas(){
        return pautaRepository.findAll();
    }
    public Boolean deletarpauta(Integer id){
        if (pautaRepository.existsById(id)){
            pautaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Pauta cadastrarpauta(Pauta pauta){
        return pautaRepository.save(pauta);
    }
    public Pauta atualizarpauta(Integer id, Pauta pauta){
        Pauta pautaRecuperado = buscarpauta(id);
        if (pautaRecuperado != null) {
            pautaRecuperado.setId(id);

            if (pauta.getPauta()!= null) {
                pautaRecuperado.setPauta(pauta.getPauta());
            }
            
            return pautaRepository.save(pautaRecuperado);
         }
         return null;
    }

}

