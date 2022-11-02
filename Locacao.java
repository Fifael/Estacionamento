import java.util.ArrayList;

public class Locacao implements GetId {

    private int id;
    private String data;
    private int idVeiculo;
    private Veiculo veiculo;
    private int idVaga;
    private Vaga vaga;

    public static ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

    public Locacao( String data,  Veiculo veiculo, Vaga vaga ) {
        this.id = GetId.getNextId(locacoes);
        this.idVeiculo = veiculo.getId();
        this.veiculo = veiculo;  
        this.idVaga = vaga.getId();
        this.vaga = vaga;    
        this.data = data;
        veiculo.setLocacoes(this);
        vaga.setLocacoes(this);
        locacoes.add(this);
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Veiculo GetVeiculo() {
        return veiculo;
    }

    public void SetVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.idVeiculo = veiculo.getId();
    }

    public Vaga GetVaga() {
        return vaga;
    }

    public void setVagas(Vaga vaga) {
        this.vaga = vaga;
        this.idVeiculo = veiculo.getId();
    }
    
    public static ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public static Locacao getLocacao(int id) throws Exception {
        for (Locacao locacao : locacoes) {
            if (locacao.getId() == id) {
                return locacao;
            }
        }
        throw new Exception("Locação não econtrada");

    }

    public static void removeLocacao(int id) throws Exception {
        Locacao locacao = getLocacao(id);
        locacoes.remove(locacao);
    }

    @Override
    public String toString() {
        return "Locacao id= " + id + "\n"
         + ", data= " + data + "\n"
         + "Veiculo= " + veiculo.getNome() + "\n"
         + ", vagas= " + vaga.getNumero() + "\n" + "]";
    }

}
