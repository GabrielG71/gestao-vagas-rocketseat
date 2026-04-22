package com.example.gestao_vaga.modules.candidates.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestao_vaga.exceptions.UserFoundExpection;
import com.example.gestao_vaga.modules.candidates.CandidateEntity;
import com.example.gestao_vaga.modules.candidates.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundExpection();
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
