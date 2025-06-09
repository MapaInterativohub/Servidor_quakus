package com.example.dto;

// Classe que representa os dados de disponibilidade de veículos e motoristas.
// Esse DTO é usado como resposta da API de frotas e também interpretado pela API de entregas.
public class DisponibilidadeDTO {

    // Indica se há pelo menos um veículo disponível no sistema de frotas
    public boolean veiculoDisponivel;

    // Indica se há pelo menos um motorista disponível no sistema de frotas
    public boolean motoristaDisponivel;

    // Construtor padrão vazio (necessário para frameworks de serialização como Jackson)
    public DisponibilidadeDTO() {}

    // Construtor que permite criar o objeto já com os dois valores de disponibilidade definidos
    public DisponibilidadeDTO(boolean veiculoDisponivel, boolean motoristaDisponivel) {
        this.veiculoDisponivel = veiculoDisponivel;
        this.motoristaDisponivel = motoristaDisponivel;
    }

    // Método auxiliar que retorna true somente se ambos veículo e motorista estiverem disponíveis
    public boolean isDisponivel() {
        return veiculoDisponivel && motoristaDisponivel;
    }
}
