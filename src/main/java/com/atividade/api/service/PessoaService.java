package com.atividade.api.service;

import com.atividade.api.domain.Pessoa;
import com.atividade.api.dto.PessoaPutResponseDTO;
import com.atividade.api.dto.PessoaRequestDTO;
import com.atividade.api.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Pessoa> buscarTodas() {
        return repository.findAll();
    }

    @Transactional
    public Pessoa criar(PessoaRequestDTO dto) {
        Pessoa pessoa = Pessoa.builder()
                .nome(dto.nome())
                .telefone(dto.telefone())
                .endereco(dto.endereco())
                .build();
        return repository.save(pessoa);
    }

    @Transactional
    public PessoaPutResponseDTO atualizar(UUID id, PessoaRequestDTO dto) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

        pessoa.setNome(dto.nome());
        pessoa.setTelefone(dto.telefone());
        pessoa.setEndereco(dto.endereco());
        
        repository.save(pessoa);

        return new PessoaPutResponseDTO(pessoa.getId(), pessoa.getNome());
    }

    @Transactional
    public void deletar(UUID id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
        repository.delete(pessoa);
    }
}