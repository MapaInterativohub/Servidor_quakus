package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Informa ao JPA que esta classe representa uma tabela do banco de dados
@Table(name = "frota")

// name = Define o nome da coluna no banco de dados. Por padrão, é o nome do
// atributo.
// unique = Define se a coluna deve ter a restrição UNIQUE. Exemplo:
// @Column(unique = true).
// nullable = Define se a coluna pode aceitar NULL. Padrão é true.
// insertable = Indica se a coluna deve ser incluída nas instruções SQL de
// INSERT. Padrão é true.
// updatable = Indica se a coluna pode ser atualizada com instruções SQL de
// UPDATE. Padrão é true.
// columnDefinition = Permite definir diretamente o tipo da coluna, conforme a
// sintaxe do banco de dados.
// length = Define o tamanho da coluna para tipos String. Padrão é 255.
// precision = Define a precisão para tipos numéricos BigDecimal. Refere-se ao
// total de dígitos.
// scale = Define a escala para tipos numéricos BigDecimal. Refere-se ao número
// de dígitos à direita da vírgula.
// table = Especifica o nome da tabela secundária caso o campo pertença a outra
// tabela. Pouco usado.


public class Frota {
    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O valor é gerado automaticamente (auto-incremento)
    private long id;

    @Column(nullable = false) // Campo obrigatório (não pode ser nulo)
    private String modeloCaminhao; // Modelo do caminhão (ex: Volvo FH, Scania R)


    @Column(nullable = false, unique = true) // Campo obrigatório e único (placa não pode se repetir)
    private String placa; // Placa do veículo


    private int capacidadeDeCarga; // Capacidade de carga do caminhão, em kg ou toneladas


    private boolean disponivel = true; // Indica se a frota está disponível em geral (para uso)
    private boolean veiculoDisponivel = true; // Especificamente se o veículo está livre
    private boolean motoristaDisponivel = true; // Especificamente se há motorista disponível


      // ===== Getters e Setters =====
    
    // Retorna o ID do caminhão
    public long getId() {
        return id;
    }

    // Define o ID do caminhão
    public void setId(long id) {
        this.id = id;
    }

    // Retorna o modelo do caminhão
    public String getModeloCaminhao() {
        return modeloCaminhao;
    }

    // Define o modelo do caminhão
    public void setModeloCaminhao(String modeloCaminhao) {
        this.modeloCaminhao = modeloCaminhao;
    }

    // Retorna a placa do veículo
    public String getPlaca() {
        return placa;
    }

    // Define a placa do veículo
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Retorna a capacidade de carga
    public int getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    // Define a capacidade de carga
    public void setCapacidadeDeCarga(int capacidadeDeCarga) {
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    // Retorna se a frota está disponível
    public boolean isDisponivel() {
        return disponivel;
    }

    // Define a disponibilidade geral da frota
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Retorna se o veículo está disponível
    public boolean isVeiculoDisponivel() {
        return veiculoDisponivel;
    }

    // Define se o veículo está disponível
    public void setVeiculoDisponivel(boolean veiculoDisponivel) {
        this.veiculoDisponivel = veiculoDisponivel;
    }

    // Retorna se há motorista disponível
    public boolean isMotoristaDisponivel() {
        return motoristaDisponivel;
    }

    // Define se há motorista disponível
    public void setMotoristaDisponivel(boolean motoristaDisponivel) {
        this.motoristaDisponivel = motoristaDisponivel;
    }
}
