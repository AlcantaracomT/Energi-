class Equipa {
    private int id;
    private String nome;
    private String local;
    private float wats;

    public Equipa(int id, String nome, String local, Float wats) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.wats = wats;
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

    @Override
    public String toString() {
        return "Equipamentos{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", local=" + local +
                '}';
    }
}