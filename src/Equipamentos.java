import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Equipamentos extends JFrame {
  public Equipamentos() {
    JFrame modalEquipamentos = new JFrame("EQUIPAMENTOS");
    int widthTela = 1000;

    // Criando Header
    JLabel titleHeader = new JLabel("Equipamentos", SwingConstants.CENTER);
    titleHeader.setFont(new Font("Arial", Font.BOLD, 18));
    titleHeader.setBackground(new Color(70, 130, 180));
    titleHeader.setOpaque(true);
    titleHeader.setForeground(Color.WHITE);

    // Criado a div Adicionar
    JPanel divAdd = new JPanel(null);
    divAdd.setBackground(new Color(211, 211, 211));

    // Adicionando componenets na div
    JLabel title = new JLabel("Adicionar equipamento", SwingConstants.CENTER);
    title.setFont(new Font("Arial", Font.BOLD, 18));
    title.setOpaque(true);
    title.setBackground(new Color(70, 130, 180));
    title.setForeground(Color.WHITE);

    JLabel labelNome = new JLabel("Nome do equipamento", SwingConstants.CENTER);
    labelNome.setFont(new Font("Arial", Font.BOLD, 15));
    JTextField inputNome = new JTextField();

    JLabel labelLocal = new JLabel("Local do Equipamento", SwingConstants.CENTER);
    labelLocal.setFont(new Font("Arial", Font.BOLD, 15));
    JTextField inputLocal = new JTextField();

    JLabel labelWatts = new JLabel("Digite os watts/h", SwingConstants.CENTER);
    labelWatts.setFont(new Font("Arial", Font.BOLD, 15));
    JTextField inputWatts = new JTextField();

    JButton addEquipamento = new JButton("Adicionar");
    addEquipamento.setBackground(new Color(70, 130, 180));
    addEquipamento.setFont(new Font("Arial", Font.BOLD, 18));
    addEquipamento.setForeground(Color.WHITE);

    // Criado listagem de Equipamentos
    String[] colunas = { "ID", "NOME", "LOCALIDADE" };
    Object[][] dados = { // Dados que virao ao cadastrar um equipamento
        { 1, "TV", "Sala" },
        { 2, "TV", "Sala" },
    };
    DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(modelo);
    tabela.setDefaultEditor(Object.class, null);
    tabela.getTableHeader().setReorderingAllowed(false);
    JScrollPane scrollPane = new JScrollPane(tabela);
    // estilos tabela
    tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
    tabela.getTableHeader().setBackground(new Color(70, 130, 180));
    tabela.getTableHeader().setForeground(Color.WHITE);
    tabela.setBackground(new Color(245, 245, 245));
    tabela.setRowHeight(30);

    // Remover equipamento
    JLabel headerRemove = new JLabel("Remover equipamento pelo ID", SwingConstants.CENTER);
    headerRemove.setFont(new Font("Arial", Font.BOLD, 18));
    JTextField idEquipamento = new JTextField();
    idEquipamento.setFont(new Font("Arial", Font.BOLD, 15));
    JButton buttonRemove = new JButton("Remover");
    buttonRemove.setFont(new Font("Arial", Font.BOLD, 18));
    buttonRemove.setBackground(Color.RED);
    buttonRemove.setForeground(Color.WHITE);

    divAdd.add(title, BorderLayout.CENTER);
    divAdd.add(labelNome, BorderLayout.CENTER);
    divAdd.add(inputNome, BorderLayout.CENTER);
    divAdd.add(labelLocal, BorderLayout.CENTER);
    divAdd.add(inputLocal, BorderLayout.CENTER);
    divAdd.add(labelWatts, BorderLayout.CENTER);
    divAdd.add(inputWatts, BorderLayout.CENTER);
    divAdd.add(addEquipamento, BorderLayout.CENTER);
    divAdd.add(scrollPane);

    // Adicionando no Jframe
    modalEquipamentos.add(titleHeader);
    modalEquipamentos.add(divAdd);
    modalEquipamentos.add(scrollPane);
    modalEquipamentos.add(headerRemove);
    modalEquipamentos.add(idEquipamento);
    modalEquipamentos.add(buttonRemove);

    // Aplicando Tamanhos
    titleHeader.setBounds(0, 0, widthTela, 60);
    divAdd.setBounds(20, 100, (int) (widthTela / 2.2f), 400);
    title.setBounds(0, 0, (int) (widthTela / 2.2f), 40);
    labelNome.setBounds(50, 60, widthTela / 3, 20);
    inputNome.setBounds(100, 90, widthTela / 4, 30);
    labelLocal.setBounds(50, 140, widthTela / 3, 20);
    inputLocal.setBounds(100, 170, widthTela / 4, 30);
    labelWatts.setBounds(50, 220, widthTela / 3, 20);
    inputWatts.setBounds(100, 250, widthTela / 4, 30);
    addEquipamento.setBounds(100, 300, widthTela / 4, 40);
    scrollPane.setBounds(520, 100, (int) (widthTela / 2.2f), 300);
    headerRemove.setBounds(520, 410, (int) (widthTela / 2.2f), 20);
    idEquipamento.setBounds(530, 440, 210, 40);
    buttonRemove.setBounds(750, 440, 210, 40);

    modalEquipamentos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    modalEquipamentos.setLayout(null);
    modalEquipamentos.setBounds(800, 100, widthTela, 600);
    modalEquipamentos.setVisible(true);
  }
}
