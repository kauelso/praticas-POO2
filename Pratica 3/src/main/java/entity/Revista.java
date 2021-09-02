package entity;

import interfaces.RevistaRepository;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "tbl_revista")
public class Revista extends ObjBibliotecario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String org;
    protected int vol;
    protected int nro;
    protected String titulo;
    protected int ano;

    public Revista(String titulo, int ano, String orgIn, int volIn, int nroIn) throws Exception{
        id = null;
        org = orgIn;
        this.titulo = titulo;
        this.ano = ano;
        if(orgIn.isBlank()){
            throw new Exception("Null Field");
        }
        try{
            vol = volIn;
            nro = nroIn;
        }
        catch(NumberFormatException e){
            throw new Exception("Not a number field");
        }
    }

    public int getNro() {
        return nro;
    }

    public String getOrg() {
        return org;
    }

    public int getVol() {
        return vol;
    }

    @Override
    public void incluir(EntityManager entityManager) {
        RevistaRepository revistaRepository = new RevistaRepository(entityManager);
        revistaRepository.save(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public void setNro(int nro) {
        this.nro = nro;
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

    @Override
    public String print(){
        return "Revista: " + this.getTitulo() + " " + this.getAno() +" "+ org +" "+ vol +" "+ nro;
    }
}
