package com.sistema.biblioteca.livro;

import com.sistema.biblioteca.autor.Autor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LivroService {
    private List<Livro> livros;

    public LivroService(){
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivrosPadrao(){
        cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        cadastrarLivro("Assassinato no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
        cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
        cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        cadastrarLivro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
        cadastrarLivro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);
    }

    public void cadastrarLivro(String titulo, Autor autor, GeneroLiterario generoLiterario){
        Livro livro = new Livro(titulo, autor, generoLiterario);
        livro.setDataAtualizacao(LocalDate.now());
        livros.add(livro);
    }

    public String mostrarLivrosDisponiveis(){
        if(livros.isEmpty() || livros.stream().noneMatch(Livro::isDisponivel)){
            return "Nenhum livro disponível";
        }

        return livros.stream()
                .filter(Livro::isDisponivel)
                .map(Livro::getTitulo)
                .collect(Collectors.joining("\n"));
    }


    public Livro verificarCadastroLivro(String titulo, Autor autor) throws LivroIndisponivelException {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo) && l.getAutor().equals(autor))
                .findFirst()
                .orElseThrow(LivroIndisponivelException::new);
    }

    public Livro pesquisarLivroTitulo(String tituloLivro) throws LivroIndisponivelException{
        //ajustar pois posso ter mais de um livro com o mesmo titulo, porem de diferentes autores
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(tituloLivro))
                .findFirst()
                .orElseThrow(LivroIndisponivelException::new);
    }

    public String pesquisarLivroGenero(GeneroLiterario generoLiterario){
       return  livros.stream()
                .filter(l -> l.getGeneroLiterario().equals(generoLiterario))
               .map(Livro::getTitulo)
                .collect(Collectors.joining("\n"));
    }
}
