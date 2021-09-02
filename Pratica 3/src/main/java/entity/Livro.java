package entity;


import interfaces.LivroRepository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_livro")
public class Livro extends ObjBibliotecario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String autor;
    protected String titulo;
    protected int ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Livro(String titulo, int ano, String autorIn) throws Exception{
        id = null;
        autor = autorIn;
        this.titulo = titulo;
        this.ano = ano;
        if(autorIn.isBlank()){
            throw new Exception("Null Field");
        }
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public void incluir(EntityManager entityManager) {
        LivroRepository livroRepository = new LivroRepository(entityManager);
        livroRepository.save(this);
    }

    @Override
    public String print() {
        return "Livro: " +ano+" "+titulo + " " + autor;
    }
}