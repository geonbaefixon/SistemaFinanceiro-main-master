package com.Projeto.SistemaFinanceiro.domain.cadastro;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
    @NotBlank(message = "Login é obrigatório!!!")
    String login,

    @NotBlank("Senha é obrigatória!!!")
    String senha
){

}