package com.screenmatch.projeto.ProjetoSpring.principal;

import com.screenmatch.projeto.ProjetoSpring.DadosEpisodio;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numeroDoEp;
    private Double avaliacao;
    private LocalDate dataDeLancamento;

    public Episodio(Integer numeroDoEp, String titulo, Double avaliacao, LocalDate dataDeLancamento) {
        this.numeroDoEp = numeroDoEp;
        this.titulo = titulo;
        this.avaliacao = avaliacao;
        this.dataDeLancamento = dataDeLancamento;

    }

    public Episodio(Integer numeroDaTemp, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroDaTemp;
        this.titulo = dadosEpisodio.titulo();
        this.numeroDoEp = dadosEpisodio.numeroEps();

        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch (NumberFormatException e) {
            this.avaliacao = 0.0;
        }

        try {
            this.dataDeLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        } catch (DateTimeParseException e){
            this.dataDeLancamento = null;
        }
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroDoEp() {
        return numeroDoEp;
    }

    public void setNumeroDoEp(Integer numeroDoEp) {
        this.numeroDoEp = numeroDoEp;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }


    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }


    @Override
    public String toString() {
        return "temporada" + this.temporada
                + "titulo" + this.titulo
                + "numeroDoEp" + this.numeroDoEp
                + "avaliacao" + this.avaliacao
                + "dataDeLancamento" + this.dataDeLancamento;

    }


}
