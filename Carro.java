import java.util.ArrayList;

public class Carro extends Veiculo  {
    
    private String placa; 
    private String cor;


    private static ArrayList<Carro> carros = new ArrayList<>();
    public Carro(
        
        String  nome,
        String  placa,
        String  cor)
        {
        super(GetId.getNextId(carros), nome);
            this.placa = placa;
            this.cor = cor;
            carros.add(this);
}

    public String GetPlaca(){
        return this.placa;
    }
    public String GetCor(){
        return this.cor;
    }
    public void SetPlaca(String placa)  {
        this.placa = placa;
    }
    public void SetCor(String cor)  {
        this.cor = cor;
    }

    public static ArrayList<Carro> getCarros(){
        return carros;
    }

    public static Carro getCarro(int id) throws Exception {
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        throw new Exception("Carro não encontrado");
}

    public static void removeCarro(int id) throws Exception {
        Carro carro = getCarro(id);
        carros.remove(carro);
    }

    @Override
    public String toString() {
        return super.toString() + "Placa do Carro:" + placa + "\n" +
                                  "Cor do Carro:" + cor + "\n" ;

}
}
