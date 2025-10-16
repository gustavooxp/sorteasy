package com.sorteasy.sorteasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sorteasy.sorteasy.entity.Participante;
import com.sorteasy.sorteasy.entity.Sorteio;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    
    // Exibir todos os participantes de um sorteio específico
    @Query("SELECT p FROM Participante p WHERE p.sorteio.id = :sorteioId")
    List<Participante> listarParticipantesPorSorteio(Long sorteioId);

    //Exibir historico de vencedores
    @Query("SELECT p FROM Participante p INNER JOIN Sorteio s ON p.id = s.ganhador.id")
    List<Participante> findAllWinners();

}
