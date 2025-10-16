package com.sorteasy.sorteasy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sorteasy.sorteasy.entity.Sorteio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "O nome deve ser preenchido")
    @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres")
    private String nome;

    @NotBlank(message = "O email deve ser preenchido")
    @Email(message = "Email inválido")
    @Size(max = 50, message = "O email deve ter no máximo 50 caracteres")
    private String email;

    @NotNull(message = "O ID do sorteio deve ser preenchido")
    private Sorteio sorteio; 


}
