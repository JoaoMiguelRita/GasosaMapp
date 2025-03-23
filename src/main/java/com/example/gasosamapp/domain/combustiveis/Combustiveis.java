package com.example.gasosamapp.domain.combustiveis;

import jakarta.persistence.*;

@Table(name="combustiveis")
@Entity(name="combustiveis")
public class Combustiveis{

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String nome;
    @Column(name="price")
    private Double preco;
    @Column(name="active")
    private Boolean ativo;

    public Combustiveis() {
    }

    public Combustiveis(RequestCombustivelDTO requestCombustivelDTO){
        this.nome = requestCombustivelDTO.nome();
        this.preco = requestCombustivelDTO.preco();
        this.ativo = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
