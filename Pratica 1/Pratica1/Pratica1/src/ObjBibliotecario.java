import java.util.List;

public abstract class ObjBibliotecario implements ObjBiblioInterface{
    private String titulo;
    private int ano;

    ObjBibliotecario(String tituloIn,int anoIn) throws Exception{
        titulo = tituloIn;
        if(titulo.isBlank()){
            throw new Exception("Null Field");
        }

        try{
            ano = anoIn;
        }
        catch(NumberFormatException e){
            throw new Exception("Not a number");
        }
    }

    public void incluir(List<ObjBibliotecario> dados){
        dados.add(this);
    }

    public int getAno() {
        return ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String print(){
        return ano+" "+titulo;
    }
}
