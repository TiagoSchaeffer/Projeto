package org.projeto.dell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Classe que realiza os teste das funcionalidades do programa.
 *
 * @author Tiago M. Schaeffer S.
 */
public class IntefaceG {
    private JFrame frame;
    static ImageIcon iconDisplay = new ImageIcon();
    private Programa programa = new Programa();
    private Panel painelE;

    private JTextField textComeco;
    private JTextField textDestino;
    private JTextField textCidade;


    public static void main(String[] args) {
        IntefaceG tela = new IntefaceG();
    }
    public IntefaceG() {
        createFrame();
    }


    public void createFrame() {
        frame = new JFrame("Projeto Dell - Tiago Medeiros");
        frame.setSize(600,400);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelE = new Panel();
        Panel painelD = new Panel();
        painelD.setBounds(221,1,400,400);
        painelE.setBounds(1,1,220,400);
        painelE.setBackground(Color.GRAY.darker());
        painelE.setLayout(null);
        painelD.setLayout(null);


        JButton buttonProximo = new JButton("Proximo");
        buttonProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonProximo .setBounds(10,12,200,40);

// -------------------------------------------Consultar Trechos x Modalidade Page---------------------------------------------//
        JLabel labelConsulta = new JLabel("Consultar Trechos x Modalidade");
        labelConsulta.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelConsulta.setBounds(47, 8, 300, 50);

        JLabel labelCidade = new JLabel("Cidades");
        labelCidade.setFont(new Font("Times New Roman",Font.BOLD,16));
        labelCidade.setBounds(150, 60, 60, 20);

        JLabel labelComeco = new JLabel("Inicio: ");
        labelComeco.setFont(new Font("Times New Roman",Font.PLAIN,16));
        labelComeco.setBounds(15, 100, 60, 20);

        JLabel labelDestino = new JLabel("Destino: ");
        labelDestino.setFont(new Font("Times New Roman",Font.PLAIN,16));
        labelDestino.setBounds(15, 160, 60, 20);

        JLabel labelModalidade = new JLabel("Modalidade");
        labelModalidade.setFont(new Font("Times New Roman",Font.BOLD,16));
        labelModalidade.setBounds(139, 210, 100, 20);

        JLabel labelCaminhao = new JLabel("Caminhao: ");
        labelCaminhao.setFont(new Font("Times New Roman",Font.PLAIN,16));
        labelCaminhao.setBounds(15, 240, 100, 20);

        textComeco = new JTextField();
        textComeco.setBounds(100, 95, 230, 30);
        textDestino = new JTextField();
        textDestino.setBounds(100, 155, 230, 30);

        String[] modalidades = {"Pequeno", "Medio", "Grande"};
        JComboBox cbMod = new JComboBox(modalidades);
        cbMod.setBounds(100, 235, 230, 30);

        JButton confirmConsultar = new JButton("Confirmar");
        confirmConsultar.setBounds(108, 300, 150, 30);
        confirmConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cidadeC = removerAcento(textComeco.getText());
                String cidadeD = removerAcento(textDestino.getText());
                if (programa.buscarIndexCidade(cidadeC) >= 0 && programa.buscarIndexCidade(cidadeD) >= 0) {
                    List<Double> results = programa.consultarTrechosxModalidade(cidadeC, cidadeD, cbMod.getSelectedIndex());
                    printTela("Distancia: " + results.get(0) + "\nCusto: " + results.get(1));
                }
                else
                    printTela("ERRO: Uma ou mais cidades nao foram encontradas. ");
            }
        });


        JButton buttonConsulta = new JButton("1- Consultar trechos");
        buttonConsulta.setBounds(10, 12, 200, 50);
        buttonConsulta.setBackground(Color.GRAY);
        buttonConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setBounds(221,1,400,400);

                newPainel.setLayout(null);
                newPainel.add(labelConsulta);
                newPainel.add(labelCidade);
                newPainel.add(labelComeco);
                newPainel.add(labelDestino);
                newPainel.add(labelModalidade);
                newPainel.add(labelCaminhao);

                newPainel.add(textComeco);
                newPainel.add(textDestino);

                newPainel.add(confirmConsultar);
                newPainel.add(cbMod);
                frame.getContentPane().remove(1);
                frame.getContentPane().add(newPainel);
            }
        });
// --------------------------------------------Cadastrar Transporte----------------------------------------------------//
        JLabel labelCadastrar = new JLabel("Cadastrar Transporte");
        labelCadastrar.setFont(new Font("Times New Roman",Font.BOLD,18));
        labelCadastrar.setBounds(100, 8, 300, 50);

        JLabel labelCidades = new JLabel("Cidades");
        labelCidades.setFont(new Font("Times New Roman",Font.BOLD,16));
        labelCidades.setBounds(150, 60, 60, 20);

        JLabel labelItens = new JLabel("Itens");
        labelItens.setFont(new Font("Times New Roman",Font.BOLD,16));
        labelItens.setBounds(160, 150, 60, 20);

        textCidade = new JTextField();
        textCidade.setBounds(15, 95, 230, 30);

        String itens[][] = {{"Celular","", "0.5"},
                {"Geladeira","", "60.0"},
                {"Freezer","", "100.0"},
                {"Cadeira","", "5.0"},
                {"Luminaria","", "0.8"},
                {"Lavadora","", "120.0"},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""}};
        String coluna[] = {"Nome","Quantidade","Peso"};
        JTable tabelaItens = new JTable(itens,coluna);
        tabelaItens.setCellSelectionEnabled(true);
        JScrollPane tabelaScroll = new JScrollPane(tabelaItens);
        tabelaScroll.setBounds(15, 185, 330, 117);
        tabelaScroll.setVisible(true);


        JButton addCidade = new JButton("Adicionar");
        addCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tabelaItens.getColumnCount());
            }
        });
        addCidade.setBounds(250, 95, 100, 30);


        JButton buttonCadastro = new JButton("2- Cadastrar Transporte");
        buttonCadastro.setBounds(10,77,200,50);
        buttonCadastro.setBackground(Color.GRAY);
        buttonCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.add(labelCadastrar);
                newPainel.add(labelCidades);
                newPainel.add(labelItens);

                newPainel.add(textCidade);
                newPainel.add(tabelaScroll);

                newPainel.add(addCidade);
                newPainel.setBounds(221,1,400,400);
                frame.getContentPane().remove(1);
                frame.getContentPane().add(newPainel);
            }
        });
// ---------------------------------------------------------------------------------------------------------------//
        JButton buttonDados = new JButton("3- Dados estatisticos");
        buttonDados.setBounds(10,142,200,50);
        buttonDados.setBackground(Color.GRAY);
        buttonDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setBounds(221,1,400,400);
                frame.getContentPane().remove(1);
                frame.getContentPane().add(newPainel);
            }
        });

        JButton buttonFechar = new JButton("4- Fechar");
        buttonFechar.setBackground(Color.GRAY);
        buttonFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonFechar.setBounds(10,305,200,40);


        painelE.add(buttonConsulta);
        painelE.add(buttonCadastro);
        painelE.add(buttonFechar);
        painelE.add(buttonDados);

        frame.add(painelE);
        frame.getContentPane().add(painelD);
        frame.setVisible(true);
    }

    public void printTela(String string) {
        JOptionPane.showMessageDialog(null, string, "Transportes", JOptionPane.INFORMATION_MESSAGE, iconDisplay);
    }
    public static String removerAcento(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
}
