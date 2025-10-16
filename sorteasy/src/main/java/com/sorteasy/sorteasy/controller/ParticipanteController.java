package com.sorteasy.sorteasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorteasy.sorteasy.dto.ParticipanteDTO;
import com.sorteasy.sorteasy.service.ParticipanteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/participantes")
public class ParticipanteController {
    @Autowired ParticipanteService service;

    // inscrever um participante em um sorteio 
    @PostMapping
    public ParticipanteDTO save(@RequestBody @Valid ParticipanteDTO dto) {
        return service.inscreverParticipante(dto);
    }

    // listar todos os participantes de um sorteio
    @GetMapping("/sorteio/{id}")
    public List<ParticipanteDTO> getBySorteio(@PathVariable("id") Long sorteioId) {
        return service.listaParticipantesPorSorteio(sorteioId);
    }

    // listar todos os vencedores
    @GetMapping("/vencedores")
    public List<ParticipanteDTO> getWinners() {
        return service.findAllWinners();
    }

}
