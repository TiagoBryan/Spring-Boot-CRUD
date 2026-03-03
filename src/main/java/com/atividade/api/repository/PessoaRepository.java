package com.atividade.api.repository;

import com.atividade.api.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}