package com.example.gestao_vaga.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestao_vaga.exceptions.UserFoundExpection;
import com.example.gestao_vaga.modules.company.entities.CompanyEntitie;
import com.example.gestao_vaga.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntitie execute(CompanyEntitie companyEntitie) {
        this.companyRepository.findByUsernameOrEmail(companyEntitie.getUsername(), companyEntitie.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundExpection();
        });

        return this.companyRepository.save(companyEntitie);
    }
}
