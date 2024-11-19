import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class Equipamentos extends JFrame {
  public Equipamentos() {
    JFrame modalEquipamentos = new JFrame("EQUIPAMENTOS");
    int widthTela = 830;

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

    divAdd.add(title, BorderLayout.CENTER);
    divAdd.add(labelNome, BorderLayout.CENTER);
    divAdd.add(inputNome, BorderLayout.CENTER);
    divAdd.add(labelLocal, BorderLayout.CENTER);
    divAdd.add(inputLocal, BorderLayout.CENTER);
    divAdd.add(labelWatts, BorderLayout.CENTER);
    divAdd.add(inputWatts, BorderLayout.CENTER);
    divAdd.add(addEquipamento, BorderLayout.CENTER);

    // Adicionando no Jframe
    modalEquipamentos.add(titleHeader);
    modalEquipamentos.add(divAdd);

    // Aplicando Tamanhos
    titleHeader.setBounds(0, 0, widthTela, 60);
    divAdd.setBounds(20, 100, widthTela / 2, 400);
    title.setBounds(0, 0, widthTela / 2, 40);
    labelNome.setBounds(0, 60, widthTela / 2, 20);
    inputNome.setBounds(70, 90, widthTela / 3, 30);
    labelLocal.setBounds(0, 140, widthTela / 2, 20);
    inputLocal.setBounds(70, 170, widthTela / 3, 30);
    labelWatts.setBounds(0, 220, widthTela / 2, 20);
    inputWatts.setBounds(70, 250, widthTela / 3, 30);
    addEquipamento.setBounds(70, 300, widthTela / 3, 40);

    modalEquipamentos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    modalEquipamentos.setLayout(null);
    modalEquipamentos.setBounds(800, 100, widthTela, 800);
    modalEquipamentos.setVisible(true);
  }
}
