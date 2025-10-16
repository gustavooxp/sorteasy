package com.sorteasy.sorteasy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorteasy.sorteasy.dto.SorteioDTO;
import com.sorteasy.sorteasy.entity.Participante;
import com.sorteasy.sorteasy.entity.Sorteio;
import com.sorteasy.sorteasy.repository.SorteioRepository;

@Service
public class SorteioService {
    @Autowired
    SorteioRepository repository;

    // método para converter um sorteio para DTO
    public SorteioDTO toDto (Sorteio sorteio) {
        SorteioDTO dto = new SorteioDTO();
        BeanUtils.copyProperties(sorteio, dto);
        return dto;
    }

    // metodo para converter um DTO para sorteio Entity
    public Sorteio toEntity (SorteioDTO dto) {
        Sorteio sorteio = new Sorteio(); 
        BeanUtils.copyProperties(dto, sorteio);
        return sorteio;
    }

    // metodo para listar todos os sorteios 
    public List<SorteioDTO> findAll() {
        List<Sorteio> sorteios = repository.findAll();
        List<SorteioDTO> sorteiosDtos = new ArrayList<>();
        for (Sorteio sorteio : sorteios) {
            sorteiosDtos.add(toDto(sorteio));
        }
        return sorteiosDtos;
    }

    // metodo para criar um novo sorteio
    public SorteioDTO save(SorteioDTO dto) {
        Sorteio sorteio = toEntity(dto);
        sorteio = repository.save(sorteio);
        return toDto(sorteio);
    }

    // metodo para deletar um sorteio
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    // metodo para realizar o sorteio e definir o vencedor aleatoriamente
    public SorteioDTO realizarSorteio(Long id) {
        Sorteio sorteio = repository.findById(id).orElseThrow();
        
        List<Participante> participantes = sorteio.getListaParticipantes();
      
        int indiceSorteado = (int) (Math.random() * participantes.size());
        sorteio.setGanhador(participantes.get(indiceSorteado));
        sorteio.setFinalizado(true);
        
        repository.save(sorteio);

        return toDto(sorteio);
    }

    // metodo para listar sorteios que ainda nao foram finalizados
    public List<SorteioDTO> findAllAtivos() {
        List<Sorteio> sorteios = repository.findAllAtivos();
        List<SorteioDTO> sorteiosDtos = new ArrayList<>();
        for (Sorteio sorteio : sorteios) {
            sorteiosDtos.add(toDto(sorteio));
        }
        return sorteiosDtos;
    }



}
