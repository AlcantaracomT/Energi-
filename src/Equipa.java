class Equipa {
    private int id;
    private String nome;
    private String local;
  
    public Equipa(int id, String nome, String local) {
        this.id = id;
        this.nome = nome;
        this.local = local;
    }
  
    public int getId() {
        return id;
    }
  
    public String getNome() {
        return nome;
    }
  
    public String getlocal() {
        return local;
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