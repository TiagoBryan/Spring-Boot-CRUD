package com.atividade.api.controller;

import com.atividade.api.domain.Pessoa;
import com.atividade.api.dto.PessoaPutResponseDTO;
import com.atividade.api.dto.PessoaRequestDTO;
import com.atividade.api.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodas() {
        return ResponseEntity.ok(service.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody PessoaRequestDTO dto) {
        Pessoa pessoaCriada = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaPutResponseDTO> atualizar(@PathVariable UUID id, @RequestBody PessoaRequestDTO dto) {
        PessoaPutResponseDTO response = service.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.ok("Usuário "+id+" Deleteado");
    }
}