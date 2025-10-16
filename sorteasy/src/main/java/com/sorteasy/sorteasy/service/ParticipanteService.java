package com.sorteasy.sorteasy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorteasy.sorteasy.dto.ParticipanteDTO;
import com.sorteasy.sorteasy.dto.SorteioDTO;
import com.sorteasy.sorteasy.entity.Participante;
import com.sorteasy.sorteasy.entity.Sorteio;
import com.sorteasy.sorteasy.repository.ParticipanteRepository;

import jakarta.transaction.Transactional;

@Service
public class ParticipanteService {
    @Autowired
    ParticipanteRepository repository;

    // metodo para converter um participante para DTO
    public ParticipanteDTO toDto(Participante participante) {
        ParticipanteDTO dto = new ParticipanteDTO();
        BeanUtils.copyProperties(participante, dto);
        return dto;
    }

    // metodo para converter um DTO para participante Entity
    public Participante toEntity(ParticipanteDTO dto) {
        Participante participante = new Participante();
        BeanUtils.copyProperties(dto, participante);
        return participante;
    }

    // inscrever um participante em um sorteio
    public ParticipanteDTO inscreverParticipante(ParticipanteDTO dto) {
        Participante participante = toEntity(dto);
        participante = repository.save(participante);
        return toDto(participante);
    }
    
    // listar participantes de um sorteio especifico 
    public List<ParticipanteDTO> listaParticipantesPorSorteio(Long sorteioId) {
        List<Participante> participantes = repository.listarParticipantesPorSorteio(sorteioId);
        return participantes.stream().map(this::toDto).toList();
    }

    // exibir historico de vencedores
    public List<ParticipanteDTO> findAllWinners() {
        List<Participante> vencedores = repository.findAllWinners();
        List<ParticipanteDTO> vencedoresDto = new ArrayList<>();

        for (Participante participante : vencedores) {
            vencedoresDto.add(toDto(participante));
        }
        return vencedoresDto;
    }

    // listar historico de vencedores
    public List<ParticipanteDTO> listarHistoricoVencedores() {
        List<Participante> vencedores = repository.findAllWinners();
        return vencedores.stream().map(this::toDto).toList();
    }
    

}
