package com.screenmatch.projeto.ProjetoSpring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverteDados implements InterfaceConverteDados{
    private ObjectMapper mapper = new ObjectMapper(); // converte json paara objeto

    @Override
    public <T> T obterDados(String json, Class<T> classe){
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
