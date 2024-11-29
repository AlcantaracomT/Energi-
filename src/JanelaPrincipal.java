import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JanelaPrincipal extends JFrame {

    private DefaultTableModel modelo;
    private JTable tabela;
    private Map<String, Integer> diasParaColunas;

    public JanelaPrincipal() {
        // Inicializa a associação entre dias e colunas
        inicializarDiasParaColunas();

        // Lista global de equipamentos
        ArrayList<Equipa> listaEquipamentos = new ArrayList<>();

        setTitle("ENERGI+");
        getContentPane().setBackground(new Color(230, 230, 230));

        JLabel title = new JLabel("BEM VINDO AO SISTEMA!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(0, 20, 1100, 60);

        // Modelo da Tabela
        String[] colunas = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        modelo = new DefaultTableModel(new Object[0][7], colunas);
        tabela = new JTable(modelo);

        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setDefaultEditor(Object.class, null); // Torna a tabela não-editável pelo usuário
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tabela.getTableHeader().setBackground(new Color(70, 130, 180));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.setBackground(new Color(245, 245, 245));
        tabela.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(tabela);

        // Botões
        JButton equipamentos = criarBotao("EQUIPAMENTOS", new Color(70, 130, 180));
        JButton consumo = criarBotao("CONSUMO", new Color(34, 139, 34));

        // Adicionando eventos aos botões
        consumo.addActionListener(e -> new Consumo(listaEquipamentos, this));
        equipamentos.addActionListener(e -> new Equipamentos(listaEquipamentos).exibir());

        // Adiciona os componentes na janela
        add(title);
        add(scrollPane);
        add(equipamentos);
        add(consumo);

        // Configurações de layout e tamanhos
        setBounds(400, 100, 1100, 800);
        scrollPane.setBounds(50, 140, 1000, 500);
        equipamentos.setBounds(50, 80, 200, 40);
        consumo.setBounds(260, 80, 200, 40);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void inicializarDiasParaColunas() {
        diasParaColunas = new HashMap<>();
        diasParaColunas.put("domingo", 0);
        diasParaColunas.put("segunda", 1);
        diasParaColunas.put("terça", 2);
        diasParaColunas.put("quarta", 3);
        diasParaColunas.put("quinta", 4);
        diasParaColunas.put("sexta", 5);
        diasParaColunas.put("sábado", 6);
    }

    public void adicionarEquipamentoNaTabela(String dia, String equipamento) {
        Integer coluna = diasParaColunas.get(dia.toLowerCase());
        if (coluna == null) {
            JOptionPane.showMessageDialog(this, "Dia inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Adiciona equipamento na primeira célula vazia ou cria uma nova linha
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, coluna) == null || modelo.getValueAt(i, coluna).toString().isEmpty()) {
                modelo.setValueAt(equipamento, i, coluna);
                return;
            }
        }

        // Caso todas as células da coluna estejam ocupadas, adiciona uma nova linha
        Object[] novaLinha = new Object[7];
        novaLinha[coluna] = equipamento;
        modelo.addRow(novaLinha);
    }

    private JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        return botao;
    }
}
