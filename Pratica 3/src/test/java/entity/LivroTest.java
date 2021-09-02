package entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LivroTest {


    @Test
    void print() throws Exception {
        Livro livro = new Livro("title",2000,"author");
        Assertions.assertEquals("Livro: 2000 title author", livro.print());
        livro.setAutor("autor");
        livro.setTitulo("titulo");
        Assertions.assertEquals("Livro: 2000 titulo autor", livro.print());
    }
}