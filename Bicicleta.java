import java.util.ArrayList;

public class Bicicleta extends Veiculo {

    private String marca;
    private String corB;

    private static ArrayList<Bicicleta> bicicletas = new ArrayList<>();

    public Bicicleta(
        
        String nome, 
        String marca,
        String corB)
        {
        super(GetId.getNextId(bicicletas), nome);
            this.marca = marca;
            this.corB = corB;
            bicicletas.add(this);
}

    public String getMarca(){
        return marca;
    }

    public String getCor(){
        return corB;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setCor(String corB) {
        this.corB = corB;
    }
    public static ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public static Bicicleta getBicicleta(int id) throws Exception {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getId() == id) {
                return bicicleta;
            }
        }
        throw new Exception(" bicicleta não encontrada");
    }

    public static void removeBicicleta(int id) throws Exception {
        Bicicleta bicicleta = getBicicleta(id);
        bicicletas.remove(bicicleta);
    }

    @Override
    public String toString() {
        return super.toString()  + "Marca da Bike:" + marca + "\n" + 
                                "Cor da Bike:" + corB + "\n"; 
}
}
