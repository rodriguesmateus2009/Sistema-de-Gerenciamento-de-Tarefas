package com.treina.recife.sgp.service.impl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.treina.recife.sgp.model.Projeto;
import com.treina.recife.sgp.repository.ProjetoRepository;
import com.treina.recife.sgp.service.ProjetoService;
import jakarta.persistence.Id;

public class ProjetoServiceImpl implements ProjetoService{

    @Autowired
    ProjetoRepository projetoRepository;

    @Override
    public Page<Projeto> getProjetos(Pageable pageable) {
        return projetoRepository.findAll(pageable);
    }

    @Override
    public Optional<Projeto> getProjetoById(long projectId) {
        return projetoRepository.findById(projectId);
    }

    @Override
    public Projeto createProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto updateProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public void deleteProjeto(long projectId) {
        projetoRepository.deleteById(projectId);
    }

}
