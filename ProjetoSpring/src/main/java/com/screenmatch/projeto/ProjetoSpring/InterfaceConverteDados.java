package com.screenmatch.projeto.ProjetoSpring;

public interface InterfaceConverteDados{
    <T> T obterDados(String json, Class<T> classe); // T e generico
}
