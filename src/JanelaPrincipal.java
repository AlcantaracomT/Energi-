import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JanelaPrincipal extends JFrame {

    private DefaultTableModel modelo;
    private DefaultTableModel modeloResumo; // Modelo para a tabela de resumo
    private JTable tabela;
    private JTable tabelaResumo; // Tabela de resumo
    private Map<String, Integer> diasParaColunas;
    private Map<String, Float> consumoPorDia; // Mapeia o total de consumo por dia

    public JanelaPrincipal() {
        // Inicializa as associações
        inicializarDiasParaColunas();
        consumoPorDia = new HashMap<>();
        inicializarConsumoPorDia();

        ArrayList<Equipa> listaEquipamentos = new ArrayList<>();

        setTitle("ENERGI+");
        getContentPane().setBackground(new Color(230, 230, 230));

        JLabel title = new JLabel("BEM VINDO AO SISTEMA!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(0, 20, 1100, 60);

        // Modelo da Tabela Principal
        String[] colunas = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        modelo = new DefaultTableModel(new Object[0][7], colunas);
        tabela = new JTable(modelo);
        configurarTabela(tabela);

        JScrollPane scrollPane = new JScrollPane(tabela);

        // Modelo da Tabela de Resumo
        String[] colunasResumo = {"Dia", "Consumo Total (W)"};
        modeloResumo = new DefaultTableModel(new Object[0][2], colunasResumo);
        tabelaResumo = new JTable(modeloResumo);
        configurarTabelaResumo();

        JScrollPane scrollPaneResumo = new JScrollPane(tabelaResumo);

        // Botões
        JButton equipamentos = criarBotao("EQUIPAMENTOS", new Color(70, 130, 180));
        JButton consumo = criarBotao("CONSUMO", new Color(34, 139, 34));

        consumo.addActionListener(e -> new Consumo(listaEquipamentos, this));
        equipamentos.addActionListener(e -> new Equipamentos(listaEquipamentos).exibir());

        // Adiciona os componentes na janela
        add(title);
        add(scrollPane);
        add(scrollPaneResumo);
        add(equipamentos);
        add(consumo);

        setBounds(400, 100, 1100, 900);
        scrollPane.setBounds(50, 140, 1000, 300);
        scrollPaneResumo.setBounds(50, 450, 400, 200); // Tabela de resumo
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

    private void inicializarConsumoPorDia() {
        for (String dia : diasParaColunas.keySet()) {
            consumoPorDia.put(dia, 0f);
        }
    }

    public void adicionarEquipamentoNaTabela(String dia, String equipamento, float consumo) {
        Integer coluna = diasParaColunas.get(dia.toLowerCase());
        if (coluna == null) {
            JOptionPane.showMessageDialog(this, "Dia inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, coluna) == null || modelo.getValueAt(i, coluna).toString().isEmpty()) {
                modelo.setValueAt(equipamento, i, coluna);
                atualizarConsumo(dia.toLowerCase(), consumo);
                return;
            }
        }

        Object[] novaLinha = new Object[7];
        novaLinha[coluna] = equipamento;
        modelo.addRow(novaLinha);
        atualizarConsumo(dia.toLowerCase(), consumo);
    }

    private void atualizarConsumo(String dia, float consumo) {
        float consumoAtual = consumoPorDia.getOrDefault(dia, 0f);
        consumoPorDia.put(dia, consumoAtual + consumo);
        atualizarTabelaResumo();
    }

    private void atualizarTabelaResumo() {
        modeloResumo.setRowCount(0);
        for (Map.Entry<String, Float> entry : consumoPorDia.entrySet()) {
            modeloResumo.addRow(new Object[]{capitalize(entry.getKey()), entry.getValue()});
        }
    }

    private void configurarTabela(JTable tabela) {
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tabela.getTableHeader().setBackground(new Color(70, 130, 180));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.setBackground(new Color(245, 245, 245));
        tabela.setRowHeight(30);
    }

    private void configurarTabelaResumo() {
        tabelaResumo.getTableHeader().setReorderingAllowed(false);
        tabelaResumo.setDefaultEditor(Object.class, null);
        tabelaResumo.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tabelaResumo.getTableHeader().setBackground(new Color(100, 100, 180));
        tabelaResumo.getTableHeader().setForeground(Color.WHITE);
        tabelaResumo.setBackground(new Color(245, 245, 245));
        tabelaResumo.setRowHeight(25);
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
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
