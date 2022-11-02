import java.util.ArrayList;

public class Moto extends Veiculo {

    private String placaM;
    private int cilindrada;

    private static ArrayList<Moto> motos = new ArrayList<Moto>();
    
    public Moto( 
                 String  nome,
                 String  placaM,
                 int     cilindrada) 
        {
        super(GetId.getNextId(motos), nome);
        this.placaM = placaM;
        this.cilindrada = cilindrada;
        motos.add(this);

    }

    public String getPlaca() {
        return placaM;
    }
    public int getCilindrada() {
        return cilindrada;
    }

    public void setPlaca(String placaM) {
        this.placaM = placaM;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    

    public static ArrayList<Moto> getMotos() {
        return motos;
    }

    public static Moto getMoto(int id) throws Exception {
        for (Moto moto : motos) {
            if (moto.getId() == id) {
                return moto;
            }
        }
        throw new Exception("Moto não encontrada");   
}

    public static void removeMoto(int id) throws Exception {
        Moto moto = getMoto(id);
        motos.remove(moto);
    }

    @Override
    public String toString() {
        return super.toString()  + "Placa da Moto:" + placaM + "\n" +
                                   "Cilindrada da Moto:" + cilindrada + "\n" ;
}

}
