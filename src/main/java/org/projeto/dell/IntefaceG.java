package org.projeto.dell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        labelCidade.setBounds(150, 70, 60, 20);

        JLabel labelComeco = new JLabel("Inicio: ");
        labelComeco.setFont(new Font("Times New Roman",Font.PLAIN,16));
        labelComeco.setBounds(15, 110, 60, 20);

        JLabel labelDestino = new JLabel("Destino: ");
        labelDestino.setFont(new Font("Times New Roman",Font.PLAIN,16));
        labelDestino.setBounds(15, 170, 60, 20);

        JLabel labelModalidade = new JLabel("Modalidade");
        labelModalidade.setFont(new Font("Times New Roman",Font.BOLD,16));
        labelModalidade.setBounds(139, 220, 100, 20);

        JLabel labelCaminhao = new JLabel("Caminhao: ");
        labelCaminhao.setFont(new Font("Times New Roman",Font.PLAIN,16));
        labelCaminhao.setBounds(15, 250, 100, 20);

        textComeco = new JTextField();
        textComeco.setBounds(100, 105, 230, 30);
        textDestino = new JTextField();
        textDestino.setBounds(100, 165, 230, 30);

        String[] modalidades = {"Pequeno", "Medio", "Grande"};
        JComboBox cbMod = new JComboBox(modalidades);
        cbMod.setBounds(100, 250, 230, 30);

        JButton confirmConsultar = new JButton("Confirmar");
        confirmConsultar.setBounds(108, 300, 150, 30);


        JButton buttonConsulta = new JButton("1- Consultar trechos");
        buttonConsulta.setBounds(10, 12, 200, 50);
        buttonConsulta.setBackground(Color.GRAY);
        buttonConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
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
                setPainelNovo(newPainel);
            }
        });
// ---------------------------------------------------------------------------------------------------------------//
        JButton buttonCadastro = new JButton("2- Cadastrar Transporte");
        buttonCadastro.setBounds(10,77,200,50);
        buttonCadastro.setBackground(Color.GRAY);
        buttonCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setLayout(null);
                setPainelNovo(newPainel);
            }
        });

        JButton buttonDados = new JButton("3- Dados estatisticos");
        buttonDados.setBounds(10,142,200,50);
        buttonDados.setBackground(Color.GRAY);
        buttonDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setLayout(null);
                setPainelNovo(newPainel);
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
        JSplitPane splitPainel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelE, painelD);
        splitPainel.setBounds(1,1,600,400);
        frame.getContentPane().add(splitPainel);

        frame.setVisible(true);
    }

    private void setPainelNovo(Panel painelD) {
        JSplitPane splitPainel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelE, painelD);
        splitPainel.setBounds(1,1,600,400);
        frame.setContentPane(splitPainel);
    }


}
