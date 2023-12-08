package com.example.as.services;

import com.example.as.dtos.ClienteResponseDTO;
import com.example.as.entities.Cliente;
import com.example.as.exceptions.NotFoundClienteException;
import com.example.as.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }



    //retorna uma lista com todos os clientes
    public List<ClienteResponseDTO> getAllClients() {
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        List<Cliente> resultado = this.repository.findAll();




        for(int i = 0; i < resultado.size(); i++) {
            ClienteResponseDTO dto = new ClienteResponseDTO();

            dto.setNome(resultado.get(i).getNome());
            dto.setProfissao(resultado.get(i).getProfissao());
            dto.setIdade(resultado.get(i).getIdade());

            listaDeClientes.add(dto);
        }



        return listaDeClientes;
    }

    //adiciona um cliente
    public ClienteResponseDTO addClient(ClienteResponseDTO cliente) {
        Cliente clienteDtoToCliente = new Cliente(cliente.getNome(), cliente.getIdade(), cliente.getProfissao());
        Cliente resultadoSalvo = this.repository.save(clienteDtoToCliente);
        return new ClienteResponseDTO(resultadoSalvo.getNome(), resultadoSalvo.getIdade(), resultadoSalvo.getProfissao());
    }

    //atualiza o cliente com o ID fornecido
    public String updateClient(long id, Cliente updatedCliente) {
        Cliente atualizar = repository.findById(id).orElse(null);
        BeanUtils.copyProperties(updatedCliente, atualizar, "id");
        repository.save(atualizar);
        return "Atualizado com sucesso!!";
    }

    //deleta o cliente com o id fornecido
    public String deleteClient(long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        repository.delete(cliente);

        return "Cliente removido";
    }

    // retorna o cliente pelo id fornecido
    public List<ClienteResponseDTO> getClienteById(long id) {
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        List<Cliente> resultado = this.repository.findAll();


        for(int i = 0; i < resultado.size(); i++) {
            if(resultado.get(i).getId() == id) {
                ClienteResponseDTO dto = new ClienteResponseDTO();

                dto.setNome(resultado.get(i).getNome());
                dto.setProfissao(resultado.get(i).getProfissao());
                dto.setIdade(resultado.get(i).getIdade());

                listaDeClientes.add(dto);
            }
        }

        if(resultado.get(0) == null) {
            throw new NotFoundClienteException();
        }else {
        return listaDeClientes;
        }
    }

    //retorna um cliente com a idade fornecida
    public List<ClienteResponseDTO> getClientsByIdade(int idade) {
        List<ClienteResponseDTO> listaDeClientes = new ArrayList<>();
        List<Cliente> resultado = this.repository.findAll();


        for(int i = 0; i < resultado.size(); i++) {
            if(resultado.get(i).getIdade() == idade) {
                ClienteResponseDTO dto = new ClienteResponseDTO();

                dto.setNome(resultado.get(i).getNome());
                dto.setProfissao(resultado.get(i).getProfissao());
                dto.setIdade(resultado.get(i).getIdade());

                listaDeClientes.add(dto);
            }
        }
        return listaDeClientes;
    }



}
