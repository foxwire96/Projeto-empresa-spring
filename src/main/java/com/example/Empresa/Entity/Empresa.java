package com.example.Empresa.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="empresa_id")
    private long id;
    @Column(name="empresa_nome")
    private String nome;
    @Column(name="empresa_cnpj")
    private int cnpj;
    @Column(name="empresa_email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
