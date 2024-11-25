import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Consumo extends JFrame {
  public Consumo(ArrayList<Equipa> listaEquipamentos, JanelaPrincipal janelaPrincipal) {
    int widthTela = 600;

    // Criando Header
    JLabel titleHeader = new JLabel("CONSUMO", SwingConstants.CENTER);
    titleHeader.setFont(new Font("Arial", Font.BOLD, 20));
    titleHeader.setOpaque(true);// cor sim/não
    titleHeader.setBackground(new Color(70, 130, 80));
    titleHeader.setForeground(Color.WHITE);// cor da letra

    // Label e CheckBox DiasSemana
    JLabel labelDias = new JLabel("Selecione o dia da semana", SwingConstants.CENTER);
    labelDias.setFont(new Font("Arial", Font.BOLD, 18));
    String[] diasSemana = { "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" };
    JComboBox<String> comboBoxDias = new JComboBox<>(diasSemana);// caixa de seleção

    // Label e CheckBox Equipamentos já adicionados
    JLabel labelEquipamentos = new JLabel("Selecione o equipamento desejado", SwingConstants.CENTER);
    labelEquipamentos.setFont(new Font("Arial", Font.BOLD, 18));

    // Dados que virão do cadastro de equipamentos
    JComboBox<String> comboBoxEquipamentos = new JComboBox<>();
    for (Equipa e : listaEquipamentos) {
      String equipamento = e.getNomeLocal();
      comboBoxEquipamentos.addItem(equipamento);
    }

    // Componente de Horas
    JLabel labelHoras = new JLabel("Digite a quantidade de Horas Ligado", SwingConstants.CENTER);
    labelHoras.setFont(new Font("Arial", Font.BOLD, 18));
    JTextField horas = new JTextField();
    horas.setFont(new Font("Arial", Font.PLAIN, 15));

    // Botao de Adicionar
    JButton adicionar = new JButton("Adicionar");
    adicionar.setFont(new Font("Arial", Font.BOLD, 20));
    adicionar.setBackground(new Color(70, 130, 80));
    adicionar.setForeground(Color.WHITE);

    adicionar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String diaSelecionado = (String) comboBoxDias.getSelectedItem();
        String equipamentoSelecionado = (String) comboBoxEquipamentos.getSelectedItem();
        String horasTexto = horas.getText().trim();

        if (horasTexto.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Digite a quantidade de Horas Ligado.", "Erro",
              JOptionPane.ERROR_MESSAGE);
          return; // Interrompe a execução
        }

        if (equipamentoSelecionado == null || equipamentoSelecionado.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Selecione um equipamento.", "Erro", JOptionPane.ERROR_MESSAGE);
          return; // Interrompe a execução
        }

        int horasLigado = Integer.parseInt(horasTexto); // Converte para inteiro

        if (horasLigado <= 0) {
          JOptionPane.showMessageDialog(null, "Digite uma quantidade de Horas Ligado maior que zero.", "Erro",
              JOptionPane.ERROR_MESSAGE);
          return; // Interrompe a execução
        }

        // Busca o equipamento na lista
        Equipa equipaSelecionada = null;
        for (Equipa a : listaEquipamentos) {
          if (a.getNomeLocal().equals(equipamentoSelecionado)) {
            equipaSelecionada = a;
            break;
          }
        }

        if (equipaSelecionada == null) {
          JOptionPane.showMessageDialog(null, "Equipamento não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
          return; // Interrompe a execução
        }

        float consumoTotal = equipaSelecionada.getWats() * horasLigado;

        String html = "<html><b>" + equipamentoSelecionado + "</b><br>" + consumoTotal + "W</html>";

        janelaPrincipal.adicionarEquipamentoNaTabela(diaSelecionado, html);
        JOptionPane.showMessageDialog(null, "Equipamento adicionado com sucesso!", "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Fecha a janela de consumo
      }
    });

    // Adicionando componentes no JFrame
    add(titleHeader);
    add(labelDias);
    add(comboBoxDias);
    add(labelEquipamentos);
    add(comboBoxEquipamentos);
    add(labelHoras);
    add(horas);
    add(adicionar);

    // Tamanhos componentes
    titleHeader.setBounds(0, 0, widthTela, 60);
    labelDias.setBounds(0, 70, widthTela, 30);
    comboBoxDias.setBounds(widthTela / 5, 100, 350, 50);
    labelEquipamentos.setBounds(0, 170, widthTela, 30);
    comboBoxEquipamentos.setBounds(widthTela / 5, 200, 350, 50);
    labelHoras.setBounds(0, 270, widthTela, 30);
    horas.setBounds(widthTela / 5, 300, 350, 50);
    adicionar.setBounds(widthTela / 5, 370, 350, 50);
    setBounds(500, 100, widthTela, 500);

    // Configuracoes Jframe
    setLayout(null);// desativa o layout para posicionar manualmente
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// DISPOSE_ON_CLOSE fecha a janela, mas mantem a execução de
                                                      // outras
    setVisible(true);// exibir componentes
  }
}
