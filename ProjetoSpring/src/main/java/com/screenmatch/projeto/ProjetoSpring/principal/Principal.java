package com.screenmatch.projeto.ProjetoSpring.principal;
import com.screenmatch.projeto.ProjetoSpring.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner sc;
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=e2c74e42";
    private ConverteDados conversor = new ConverteDados();
    private ConsumoApi consumoApi = new ConsumoApi();

    public void exiberMenu() {
        sc = new Scanner(System.in);
        System.out.println("Digite a serie:");
        var nomeSerie = sc.nextLine();

        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        var jsonString = json.toString();
        DadosSerie dados = conversor.obterDados(jsonString, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temps = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemps(); i++) {
            jsonString = String.valueOf(consumoApi.obterDados("http://www.omdbapi.com/?t=Gilmore+Girls&season=" + i + "&apikey=e2c74e42"));
            DadosTemporada temp = conversor.obterDados(jsonString, DadosTemporada.class);
            temps.add(temp);
        }
        temps.forEach(System.out::println);

        List<DadosEpisodio> dadosEpisodios = temps.stream()
                .flatMap(t -> t.eps().stream())
                .collect(Collectors.toList());

        System.out.println("Top 5 eps");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primeiro filtro(N/A): " + e))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .peek(e -> System.out.println("Ordenaçao: " + e))
                .limit(5) // funcao peek faz debug
                .peek(e -> System.out.println("Limite" + e))
                .map(e -> e.titulo().toUpperCase())
                .forEach(System.out::println);

        List<Episodio> episodios = temps.stream()
                .flatMap(t -> t.eps().stream().map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);
        System.out.println();
        System.out.println("A partir de que ano voce deseja ver os episodios");
        var ano = sc.nextInt();
        sc.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Episodio> episodiosFiltrados = episodios.stream()
        .filter(e -> e.getDataDeLancamento().isAfter(dataBusca))
        .collect(Collectors.toList());

        episodiosFiltrados.forEach(e -> System.out.println(
        "Temporada" + e.getTemporada()
        + "Episodio" + e.getNumeroDoEp()
        + "Ano" + e.getDataDeLancamento().format(formatador)
        ));
    }
}