package com.screenmatch.projeto.ProjetoSpring;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // ignora o que voce nao encontrar
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons") Integer totalTemps,
                         @JsonAlias("imdbRating") String avaliacao) {
}
