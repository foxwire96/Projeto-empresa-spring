package com.example.Empresa.Controller;

import com.example.Empresa.Entity.Empresa;
import com.example.Empresa.Service.EmpresaService;
import com.example.Empresa.dto.EmpresaDto;
import com.rabbitmq.client.Return;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody EmpresaDto empresa) {
        return ResponseEntity.ok(empresaService.create((empresa)));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> list() {

        return ResponseEntity.ok(empresaService.list());
    }

    @PutMapping
    public ResponseEntity<Empresa> update(@RequestBody Empresa empresa) {
        return ResponseEntity.ok(empresaService.update(empresa));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        empresaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
