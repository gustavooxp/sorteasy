package com.sorteasy.sorteasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorteasy.sorteasy.dto.ParticipanteDTO;
import com.sorteasy.sorteasy.dto.SorteioDTO;
import com.sorteasy.sorteasy.service.ParticipanteService;
import com.sorteasy.sorteasy.service.SorteioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sorteios")
public class SorteioController {
    @Autowired SorteioService service;

    @Autowired ParticipanteService participanteService;

    // listar todos os sorteios
    @GetMapping
    public List<SorteioDTO> findAll() {
        return service.findAll();
    }

    // criar um novo sorteio
    @PostMapping
    public SorteioDTO save(@RequestBody @Valid SorteioDTO dto) {
        return service.save(dto);
    }

    // excluir um sorteio
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    // realizar o sorteio e definir o ganhador aleatoriamente
    @GetMapping("/{id}/realizar")
    public ParticipanteDTO realizarSorteio(@PathVariable Long id) {
        ParticipanteDTO participante = service.realizarSorteio(id);
        return participante;
    }

    // listar sorteios que ainda nao foram finalizados
    @GetMapping("/ativos")
    public List<SorteioDTO> findAllAtivos() {
        return service.findAllAtivos();
    }


}
