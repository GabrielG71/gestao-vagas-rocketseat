package com.example.gestao_vaga.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestao_vaga.modules.company.entities.CompanyEntitie;

public interface CompanyRepository extends JpaRepository<CompanyEntitie, UUID> {
    Optional<CompanyEntitie> findByUsernameOrEmail(String username, String email);
}
