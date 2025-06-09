package com.example.controllers;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.tags.Tag; // Anotação para documentação Swagger

import com.example.dto.DisponibilidadeDTO;
import com.example.models.Frota;
import com.example.repository.FrotaRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/frotas") // Define a URL base para todos os endpoints deste controller
@Produces(MediaType.APPLICATION_JSON) // Todos os métodos retornam JSON
@Consumes(MediaType.APPLICATION_JSON) // Todos os métodos esperam JSON no corpo da requisição
@Tag(name = "Frotas", description = "Operações para gerenciamento de Frotas") // Rótulo para documentação no Swagger
public class ControleDeFrota {

    @Inject
    FrotaRepository repositoriofrota; // Injeta o repositório que acessa a base de dados de Frotas

    // GET /api/frotas → Lista todas as frotas cadastradas no banco
    @GET
    public List<Frota> ListaFrotas() {
        return repositoriofrota.listAll();
    }

    // GET /api/frotas/{id} → Busca uma frota pelo seu ID
    @GET
    @Path("/{id}")
    public Response ListaEntrgas(@PathParam("id") long id) {
        Frota f = repositoriofrota.findById(id);
        if (f != null)
            return Response.ok().entity(f).build(); // Se encontrado, retorna com status 200 e objeto Frota
        else
            return Response.status(404).build(); // Se não encontrado, retorna 404
    }

    // POST /api/frotas → Cria uma nova frota
    @POST
    @Transactional // Necessário para persistência no banco com Panache
    public Response criarFrota(Frota frota) {
        try {
            repositoriofrota.persist(frota); // Salva a nova frota no banco
            return Response.status(201).build(); // Retorna status 201 Created
        } catch (Exception e) {
            return Response.serverError().entity(e).build(); // Em caso de erro, retorna 500 com o erro
        }
    }

    // GET /api/frotas/disponibilidade → Verifica se há veículos e motoristas disponíveis
    @GET
    @Path("/disponibilidade")
    public Response verificarDisponibilidade() {
        try {
            List<Frota> frotas = repositoriofrota.listAll(); // Lista todas as frotas

            // Verifica se há pelo menos um veículo e um motorista disponíveis
            boolean veiculoDisponivel = frotas.stream().anyMatch(Frota::isVeiculoDisponivel);
            boolean motoristaDisponivel = frotas.stream().anyMatch(Frota::isMotoristaDisponivel);

            // Cria o DTO de resposta com os dois valores
            DisponibilidadeDTO dto = new DisponibilidadeDTO(veiculoDisponivel, motoristaDisponivel);
            return Response.ok(dto).build(); // Retorna com status 200 e o JSON
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build(); // Em caso de erro, retorna 500
        }
    }

    // GET /api/frotas/disponiveis → Lista apenas as frotas totalmente disponíveis
    @GET
    @Path("/disponiveis")
    public List<Frota> listarDisponiveis() {
        // Retorna todas as frotas com veículo, motorista e disponibilidade geral igual a true
        return repositoriofrota.list("veiculoDisponivel = true and motoristaDisponivel = true and disponivel = true");
    }
}
