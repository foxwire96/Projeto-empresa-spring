package com.example.Empresa.Service;

import com.example.Empresa.Entity.Empresa;
import com.example.Empresa.Repository.EmpresaRepository;
import com.example.Empresa.dto.EmpresaDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public EmpresaService(EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }


    @Transactional
    public Empresa create(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa();
        empresa.setNome(empresaDto.getNome());
        empresa.setCnpj(empresaDto.getCnpj());
        empresa.setEmail(empresaDto.getEmail());
        return empresaRepository.save(empresa);
    }

    public List<Empresa> list() {
        List<Empresa> lista= empresaRepository.findAll();

        return lista;
    }
    public Empresa create(Empresa empresa) {
        return empresaRepository.save (empresa);
    }

    public Empresa update(Empresa empresa) {

        return empresaRepository.save(empresa);
    }

    public void delete(Long id) {

        empresaRepository.deleteById(id);
    }

    public Optional<Empresa> findEmpresaById(int id) {
        return empresaRepository.findById((long) id);

    }



}
