import java.util.HashMap;
import java.util.Map;

// Modificação da classe Equipa para incluir consumo diário
public class Equipa {
    private int id;
    private String nome;
    private String local;
    private float wats;  // Watts/h do equipamento
    private Map<String, Float> consumoDiario; // Consumo para cada dia da semana

    public Equipa(int id, String nome, String local, Float wats) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.wats = wats;
        this.consumoDiario = new HashMap<>();
    }

    public String getNomeLocal() {
        return nome + " - " + local;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public float getWats() {
        return wats;
    }

    public void setConsumo(String dia, float consumo) {
        consumoDiario.put(dia, consumo);
    }

    public Map<String, Float> getConsumoDiario() {
        return consumoDiario;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", wats=" + wats +
                '}';
    }
}
