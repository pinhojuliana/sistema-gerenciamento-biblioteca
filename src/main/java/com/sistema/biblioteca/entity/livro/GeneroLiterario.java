package com.sistema.biblioteca.entity.livro;

import lombok.Getter;

@Getter
public enum GeneroLiterario {
    ROMANCE ("Romance"),
    ROMANCE_POLICIAL("Romance policial"),
    FICCAO_CIENTIFICA("Ficção científica"),
    RELIGIOSO("Religioso"),
    INFANTIL("Infantil"),
    CIENCIA("Ciência"),
    DIDATICO("Didático"),
    FANTASIA("Fantasia"),
    QUADRINHOS("Quadrinhos"),
    TERROR("Terror"),
    POESIA("Poesia"),
    POLITICA("Política"),
    SUSPENSE("Suspense"),
    DRAMA("Drama"),
    DESENVOLVIMENTO_PESSOAL("Desenvolvimento pessoal"),
    CULINARIA("Culinária"),
    ARTE("Arte");

    private String nomeGeneroLiterario;

    private GeneroLiterario(String nomeGeneroLiterario){
        this.nomeGeneroLiterario = nomeGeneroLiterario;
    }

    public String getNomeGeneroLiterario(){
        return nomeGeneroLiterario;
    }

    public static GeneroLiterario verificarExistenciaGenero(String nomeGeneroLiterario){
       for(GeneroLiterario genero : GeneroLiterario.values()){
           if(genero.getNomeGeneroLiterario().equalsIgnoreCase(nomeGeneroLiterario)){
               return genero;
           }
       }
       return null;
    }

    public static String mostrarOpcoesGeneroLiterario(){
        return "-Romance\n-Romance policial\n-Ficção científica\n-Religioso\n-Infantil\n-Ciência\n-Didático\n-Fantasia\n-Quadrinhos\n-Terror\n-Poesia\n-Política\n-Suspense\n-Drama\n-Desenvolvimento pessoal\n-Culinária\n-Arte";
    }

}
