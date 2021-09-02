public class Livro extends ObjBibliotecario{
    protected String autor;
    
    Livro(String titulo, int ano, String autorIn) throws Exception{
        super(titulo, ano);
        autor = autorIn;
        if(autorIn.isBlank()){
            throw new Exception("Null Field");
        }
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String print() {
        return "Livro: " +super.print() + " " + autor;
    }
}
