import java.util.ArrayList;

public class Vaga implements GetId {

    private int id;
    private int numero;
    private String tipo1;
    private String tamanho;
    private String preco;
    private ArrayList<Locacao> locacoes;


    private static ArrayList<Vaga> vagas = new ArrayList<Vaga>();

    public Vaga(int numero, String tipo1, String tamanho, String preco ) {
        this.id = GetId.getNextId(vagas);
        this.locacoes = new ArrayList<>();
        this.numero = numero;
        this.tipo1 = tipo1;
        this.tamanho = tamanho;
        this.preco = preco;
        vagas.add(this);

    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public String gettipo1() {
        return tipo1;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void settipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setLocacoes(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    public static ArrayList<Vaga> getVagas() {
        return vagas;
    }


    public static Vaga getVaga(int id) throws Exception {
        for (Vaga vaga : vagas) {
            if (vaga.getId() == id) {
                return vaga;
            }
        }
        throw new Exception("Vaga não encontrado");
    }

    public static void removeVaga(int id) throws Exception {
        Vaga vaga = getVaga(id);
        vagas.remove(vaga);
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "numero: " + numero + "\n" +
                "tipo1: " + tipo1 + "\n" +
                "tamanho: " + tamanho + "\n" +
                "preco: " + preco + "\n"  ;
    }

    
}