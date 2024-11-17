import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Consumo extends JFrame {
  public Consumo() {
    JFrame modalConsumo = new JFrame("CONSUMO APARELHO");
    int widthTela = 600;

    // Criando Header
    JLabel titleHeader = new JLabel("CONSUMO", SwingConstants.CENTER);
    titleHeader.setFont(new Font("Arial", Font.BOLD, 20));
    titleHeader.setBounds(0, 0, 0, 0);
    titleHeader.setOpaque(true);
    titleHeader.setBackground(new Color(70, 130, 180));
    titleHeader.setForeground(Color.WHITE);

    // Label e CheckBox DiasSemana
    JLabel labelDias = new JLabel("Selecione o dia da semana", SwingConstants.CENTER);
    labelDias.setFont(new Font("Arial", Font.BOLD, 18));
    String[] diasSemana = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" };
    JComboBox<String> comboBoxDias = new JComboBox<>(diasSemana);

    // Label e CheckBox Equipamentos
    JLabel labelEquipamentos = new JLabel("Selecione o equipamento desejado", SwingConstants.CENTER);
    labelEquipamentos.setFont(new Font("Arial", Font.BOLD, 18));
    // Dados que virão do cadastro de equipamentos
    String[] equipamentos = { "TV", "Ar-Condicionado", "Radio", "Chuveiro" };
    JComboBox<String> comboBoxEquipamentos = new JComboBox<>(equipamentos);

    // Componente de Horas
    JLabel labelHoras = new JLabel("Digite a quantidade de Horas Ligado", SwingConstants.CENTER);
    labelHoras.setFont(new Font("Arial", Font.BOLD, 18));
    JTextField horas = new JTextField();
    horas.setFont(new Font("Arial", Font.PLAIN, 15));

    // Botao de Adicionar
    JButton adicionar = new JButton("Adicionar");
    adicionar.setFont(new Font("Arial", Font.BOLD, 20));
    adicionar.setBackground(new Color(70, 130, 180));
    adicionar.setForeground(Color.WHITE);

    // Adicionando componentes no JFrame
    modalConsumo.add(titleHeader);
    modalConsumo.add(labelDias);
    modalConsumo.add(comboBoxDias);
    modalConsumo.add(labelEquipamentos);
    modalConsumo.add(comboBoxEquipamentos);
    modalConsumo.add(labelHoras);
    modalConsumo.add(horas);
    modalConsumo.add(adicionar);

    // Tamanhos componentes
    titleHeader.setBounds(0, 0, widthTela, 60);
    labelDias.setBounds(0, 70, widthTela, 30);
    comboBoxDias.setBounds(widthTela / 5, 100, 350, 50);
    labelEquipamentos.setBounds(0, 170, widthTela, 30);
    comboBoxEquipamentos.setBounds(widthTela / 5, 200, 350, 50);
    labelHoras.setBounds(0, 270, widthTela, 30);
    horas.setBounds(widthTela / 5, 300, 350, 50);
    adicionar.setBounds(widthTela / 5, 370, 350, 50);

    // Configuracoes Jframe
    modalConsumo.setLayout(null);
    modalConsumo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    modalConsumo.setBounds(500, 100, widthTela, 500);
    modalConsumo.setVisible(true);
  }
}
