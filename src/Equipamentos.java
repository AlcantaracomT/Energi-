import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Equipamentos extends JFrame {
  public Equipamentos() {
    int widthTela = 1000;
    Font headeFont = new Font("Arial", Font.BOLD, 18);
    Font labelFont = new Font("Arial", Font.BOLD, 15);
    Color headerColor = new Color(70, 130, 180);
    
    // Criando Header
    JLabel titleHeader = new JLabel("Equipamentos", SwingConstants.CENTER);
    titleHeader.setFont(headeFont);
    titleHeader.setBackground(headerColor);
    titleHeader.setOpaque(true);
    titleHeader.setForeground(Color.WHITE);

    // Criado a div Adicionar
    JPanel divAdd = new JPanel(null);
    divAdd.setBackground(new Color(211, 211, 211));

    // Adicionando componenets na div

    JLabel title = new JLabel("Adicionar equipamento", SwingConstants.CENTER);
    title.setFont(headeFont);
    title.setOpaque(true);
    title.setBackground(headerColor);
    title.setForeground(Color.WHITE);

    JLabel labelNome = new JLabel("Nome do equipamento", SwingConstants.CENTER);
    labelNome.setFont(labelFont);
    JTextField inputNome = new JTextField();

    JLabel labelLocal = new JLabel("Local do Equipamento", SwingConstants.CENTER);
    labelLocal.setFont(labelFont);
    JTextField inputLocal = new JTextField();

    JLabel labelWatts = new JLabel("Digite os watts/h", SwingConstants.CENTER);
    labelWatts.setFont(labelFont);
    JTextField inputWatts = new JTextField();

    JButton addEquipamento = new JButton("Adicionar");
    addEquipamento.setBackground(headerColor);
    addEquipamento.setFont(headeFont);
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
    tabela.getTableHeader().setFont(labelFont);
    tabela.getTableHeader().setBackground(headerColor);
    tabela.getTableHeader().setForeground(Color.WHITE);
    tabela.setBackground(new Color(245, 245, 245));
    tabela.setRowHeight(30);

    // Remover equipamento
    JLabel headerRemove = new JLabel("Remover equipamento pelo ID", SwingConstants.CENTER);
    headerRemove.setFont(headeFont);
    JTextField idEquipamento = new JTextField();
    idEquipamento.setFont(labelFont);
    JButton buttonRemove = new JButton("Remover");
    buttonRemove.setFont(headeFont);
    buttonRemove.setBackground(Color.RED);
    buttonRemove.setForeground(Color.WHITE);

    divAdd.add(title);
    divAdd.add(labelNome);
    divAdd.add(inputNome);
    divAdd.add(labelLocal);
    divAdd.add(inputLocal);
    divAdd.add(labelWatts);
    divAdd.add(inputWatts);
    divAdd.add(addEquipamento);
    divAdd.add(scrollPane);

    // Adicionando 
    add(titleHeader);
    add(divAdd);
    add(scrollPane);
    add(headerRemove);
    add(idEquipamento);
    add(buttonRemove);

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

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    setBounds(800, 100, widthTela, 600);
    setVisible(true);
  }
}
