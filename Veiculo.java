import java.util.ArrayList;

public abstract class Veiculo implements GetId {

    private int id;
    private String nome;
    private ArrayList<Locacao> locacoes;

    protected Veiculo(int id, String nome )
    {
        this.id = id;
        this.nome = nome;
        this.locacoes = new ArrayList<>();

 

    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(Locacao locacoes) {
        this.locacoes.add(locacoes);
    }

    @Override
    public String toString() {
        return "Id=" + id + "\n"
              + "Nome=" + nome + "\n";
        
    }
    

}