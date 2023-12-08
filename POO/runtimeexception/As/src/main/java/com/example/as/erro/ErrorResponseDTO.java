package com.example.as.erro;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponseDTO {

    private String mensagem;
    private List<String> erros;
    private LocalTime data = LocalTime.now();

    public ErrorResponseDTO(String mensagem, List<String> erros) {
        this.mensagem = mensagem;
        this.erros = erros;

    }
}
