public class Revista extends ObjBibliotecario{
    protected String org;
    protected int vol;
    protected int nro;

    Revista(String titulo, int ano, String orgIn, int volIn, int nroIn) throws Exception{
        super(titulo,ano);
        org = orgIn;
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
    public String print(){
        return "Revista: " + this.getTitulo() + " " + this.getAno() +" "+ org +" "+ vol +" "+ nro;
    }
}
