package org.projeto.dell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
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

    private JTextField textComeco;
    private JTextField textDestino;
    private JTextField textCidade;
    private List<String> cidades;


    public static void main(String[] args) {
        IntefaceG tela = new IntefaceG();
    }

    public IntefaceG() {
        createFrame();
    }


    public void createFrame() {
        frame = new JFrame("Projeto Dell - Tiago Medeiros");
        frame.setSize(600, 400);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel painelE = new Panel();
        Panel painelD = new Panel();
        painelD.setBounds(221, 1, 400, 400);
        painelE.setBounds(1, 1, 220, 400);
        painelE.setBackground(Color.GRAY.darker());
        painelE.setLayout(null);
        painelD.setLayout(null);


        JButton buttonProximo = new JButton("Proximo");
        buttonProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonProximo.setBounds(10, 12, 200, 40);

// -------------------------------------------Consultar Trechos x Modalidade Page---------------------------------------------//
        JLabel labelConsulta = new JLabel("Consultar Trechos x Modalidade");
        labelConsulta.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelConsulta.setBounds(47, 8, 300, 50);

        JLabel labelCidade = new JLabel("Cidades");
        labelCidade.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelCidade.setBounds(150, 60, 60, 20);

        JLabel labelComeco = new JLabel("Inicio: ");
        labelComeco.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelComeco.setBounds(15, 100, 60, 20);

        JLabel labelDestino = new JLabel("Destino: ");
        labelDestino.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelDestino.setBounds(15, 160, 60, 20);

        JLabel labelModalidade = new JLabel("Modalidade");
        labelModalidade.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelModalidade.setBounds(139, 210, 100, 20);

        JLabel labelCaminhao = new JLabel("Caminhao: ");
        labelCaminhao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
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
                if (!cidadeC.equalsIgnoreCase(cidadeD)) {
                    if (programa.buscarIndexCidade(cidadeC) >= 0 && programa.buscarIndexCidade(cidadeD) >= 0) {
                        List<Double> results = programa.consultarTrechosxModalidade(cidadeC, cidadeD, cbMod.getSelectedIndex());
                        printTela("Distancia: " + results.get(0) + "\nCusto: " + results.get(1));
                    } else
                        printTela("ERRO: Uma ou mais cidades nao foram encontradas. ");
                } else
                    printTela("ERRO: Cidades iguais, por favor mudar.");
            }
        });


        JButton buttonConsulta = new JButton("1- Consultar trechos");
        buttonConsulta.setBounds(10, 12, 200, 50);
        buttonConsulta.setBackground(Color.GRAY);
        buttonConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setBounds(221, 1, 400, 400);

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
        labelCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelCadastrar.setBounds(100, 8, 300, 50);

        JLabel labelCidades = new JLabel("Cidades");
        labelCidades.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelCidades.setBounds(150, 60, 60, 20);

        JLabel labelItens = new JLabel("Itens");
        labelItens.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelItens.setBounds(160, 135, 60, 20);

        textCidade = new JTextField();
        textCidade.setBounds(15, 95, 230, 30);

        String[][] itens = {{"Celular", "0", "0.5"},
                {"Geladeira", "0", "60.0"},
                {"Freezer", "0", "100.0"},
                {"Cadeira", "0", "5.0"},
                {"Luminaria", "0", "0.8"},
                {"Lavadora", "0", "120.0"},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}};
        String[] coluna = {"Nome", "Quantidade", "Peso"};
        JTable tabelaItens = new JTable(itens, coluna);
        JScrollPane tabelaScroll = new JScrollPane(tabelaItens);
        tabelaScroll.setBounds(15, 170, 330, 117);

        cidades = new ArrayList<>();
        JButton addCidade = new JButton("Adicionar");
        addCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCidade = textCidade.getText();
                if (programa.buscarIndexCidade(nomeCidade) >= 0) {
                    if (cidades.size() > 0 && nomeCidade.equalsIgnoreCase(cidades.get(cidades.size() - 1)))
                        printTela("ERRO: Cidade anterior e igual a que esta sendo adicionada.");
                    else
                        cidades.add(nomeCidade);
                } else
                    printTela("ERRO: Cidade nao encontrada.");
                textCidade.setText("");
            }
        });
        addCidade.setBounds(250, 95, 100, 30);

        JButton confirmCadastro = new JButton("Confirmar");
        confirmCadastro.setBounds(108, 300, 150, 30);
        confirmCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int erro = 0;
                List<List<String>> listaItens = new ArrayList<>();
                for (int i = 0; i < tabelaItens.getRowCount(); i++) {
                    String nomeAtual = (String) tabelaItens.getValueAt(i, 0);
                    String quantidadeAtual = (String) tabelaItens.getValueAt(i, 1);
                    String pesoAtual = (String) tabelaItens.getValueAt(i, 2);
                    if (!nomeAtual.equals("")) {
                        if (!quantidadeAtual.equals("")) {
                            try {
                                int numero = Integer.parseInt(quantidadeAtual);
                                if (numero < 0)
                                    throw new Exception();
                            } catch (Exception o) {
                                erro += 1;
                                printTela("ERRO: Na coluna quantidade e necessario colocar um numero cardinal.");
                            }
                        } else {
                            erro += 1;
                            printTela("ERRO: Necessario colocar uma quantidade para o item, mesmo ser for 0.");
                        }

                        if (!pesoAtual.equals("")) {
                            try {
                                double numero = Double.parseDouble(pesoAtual);
                                if (numero <= 0.0)
                                    throw new Exception();
                            } catch (Exception o) {
                                erro += 1;
                                printTela("ERRO: Na coluna peso e necessario colocar um numero maior que 0.");
                            }
                        } else {
                            printTela("ERRO: Necessario colocar um peso para o item, mesmo ser for 0.1.");
                            erro += 1;
                        }
                        List<String> item = new ArrayList<>(Arrays.asList(nomeAtual, quantidadeAtual, pesoAtual));
                        listaItens.add(item);
                    }
                }

                if (erro == 0 && cidades.size() > 1) {
                    programa.cadastrarTransporte(cidades, listaItens);
                    cidades = new ArrayList<>();
                    printTela("Cadastro realizado com sucesso.");
                } else
                    printTela("ERRO: Cidades insuficiente, por favor adicionar mais uma.");
            }
        });

        JButton buttonCadastro = new JButton("2- Cadastrar Transporte");
        buttonCadastro.setBounds(10, 77, 200, 50);
        buttonCadastro.setBackground(Color.GRAY);
        buttonCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setLayout(null);
                newPainel.add(labelCadastrar);
                newPainel.add(labelCidades);
                newPainel.add(labelItens);

                newPainel.add(textCidade);
                newPainel.add(tabelaScroll);

                newPainel.add(addCidade);
                newPainel.add(confirmCadastro);
                newPainel.setBounds(221, 1, 400, 400);
                frame.getContentPane().remove(1);
                frame.getContentPane().add(newPainel);
            }
        });
// --------------------------------------------Dados estatisticos--------------------------------------------------//
        JLabel labelDados = new JLabel("Dados estatisticos");
        labelDados.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelDados.setBounds(115, 8, 300, 50);

        JLabel labelTransporte = new JLabel("Transporte (1/" + programa.cadastrosTransportes.size() + ")");
        labelTransporte.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelTransporte.setBounds(120, 50, 300, 20);

        JLabel labelCTotal = new JLabel("Custo total: ");
        labelCTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCTotal.setBounds(15, 80, 200, 20);

        JLabel labelCMKm = new JLabel("Custo medio por Km: ");
        labelCMKm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMKm.setBounds(15, 100, 200, 20);

        JLabel labelCMT = new JLabel("Custo medio p/ tipo: ");
        labelCMT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMT.setBounds(15, 120, 200, 20);

        JLabel labelCMCP = new JLabel("Custo medio caminhao pequeno: ");
        labelCMCP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCP.setBounds(15, 140, 200, 20);

        JLabel labelCMCM = new JLabel("Custo medio caminhao medio: ");
        labelCMCM.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCM.setBounds(15, 160, 200, 20);

        JLabel labelCMCG = new JLabel("Custo medio caminhao grande: ");
        labelCMCG.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCG.setBounds(15, 180, 200, 20);

        JLabel labelTVeiculos = new JLabel("Numero total veiculos: ");
        labelTVeiculos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelTVeiculos.setBounds(15, 200, 200, 20);

        JLabel labelTItens = new JLabel("Numero total de itens: ");
        labelTItens.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelTItens.setBounds(15, 220,200, 20);

        JLabel labelTrechos = new JLabel("Trechos");
        labelTrechos.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelTrechos.setBounds(150, 240, 200, 20);

        Panel painelTrecho = new Panel();
        JScrollPane painelScholl = new JScrollPane(painelTrecho);
        painelScholl.setBounds(10, 270, 342, 70);
        painelScholl.setVisible(true);

        JButton anteriorT = new JButton("Anterior");
        anteriorT.setBounds(10,30, 90, 40);

        JButton proximoT = new JButton("Proximo");
        proximoT.setBounds(265,30, 90, 40);

        JButton buttonDados = new JButton("3- Dados estatisticos");
        buttonDados.setBounds(10, 142, 200, 50);
        buttonDados.setBackground(Color.GRAY);
        buttonDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel newPainel = new Panel();
                newPainel.setLayout(null);
                newPainel.setBounds(221, 1, 400, 400);
                newPainel.add(labelDados);
                newPainel.add(labelTransporte);
                newPainel.add(labelCTotal);
                newPainel.add(labelCMT);
                newPainel.add(labelCMKm);
                newPainel.add(labelCMCP);
                newPainel.add(labelCMCM);
                newPainel.add(labelCMCG);
                newPainel.add(labelTVeiculos);
                newPainel.add(labelTrechos);
                newPainel.add(labelTItens);
                newPainel.add(anteriorT);
                newPainel.add(proximoT);
                newPainel.add(painelScholl);

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
        buttonFechar.setBounds(10, 305, 200, 40);


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

    public void criarPanelDados(int index) {
        Transporte t = programa.cadastrosTransportes.get(index);
        List<Double> listaDados = programa.dadosEstatisticos(t);

        JLabel labelDados = new JLabel("Dados estatisticos");
        labelDados.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelDados.setBounds(115, 8, 300, 50);

        JLabel labelTransporte = new JLabel("Transporte (1/" + programa.cadastrosTransportes.size() + ")");
        labelTransporte.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelTransporte.setBounds(120, 50, 300, 20);

        JLabel labelCTotal = new JLabel("Custo total: " + programa.cadastrosTransportes.get(index).getCustoTotal());
        labelCTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCTotal.setBounds(15, 80, 200, 20);

        JLabel labelCMKm = new JLabel("Custo medio por Km: " + listaDados.get(0));
        labelCMKm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMKm.setBounds(15, 100, 200, 20);

        JLabel labelCMT = new JLabel("Custo medio p/ tipo: " + listaDados.get(1));
        labelCMT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMT.setBounds(15, 120, 200, 20);

        double mediaPequeno = t.getCustoTotalPCaminhao().get(0)/t.getQuantCaminhao().get(0);
        double mediaMedia = t.getCustoTotalPCaminhao().get(1)/t.getQuantCaminhao().get(1);
        double mediaGrande = t.getCustoTotalPCaminhao().get(2)/t.getQuantCaminhao().get(2);
        List<Integer> listaCaminhao = t.getQuantCaminhao();
        int totalVeiculos = listaCaminhao.get(0) + listaCaminhao.get(1) + listaCaminhao.get(2);
        JLabel labelCMCP = new JLabel("Custo medio caminhao pequeno: " + mediaPequeno);
        labelCMCP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCP.setBounds(15, 140, 200, 20);

        JLabel labelCMCM = new JLabel("Custo medio caminhao medio: " + mediaMedia);
        labelCMCM.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCM.setBounds(15, 160, 200, 20);

        JLabel labelCMCG = new JLabel("Custo medio caminhao grande: " + mediaGrande);
        labelCMCG.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCG.setBounds(15, 180, 200, 20);

        JLabel labelTVeiculos = new JLabel("Numero total veiculos: " + totalVeiculos);
        labelTVeiculos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelTVeiculos.setBounds(15, 200, 200, 20);

        JLabel labelTItens = new JLabel("Numero total de itens: " + listaDados.get(2));
        labelTItens.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelTItens.setBounds(15, 220,200, 20);

        JLabel labelTrechos = new JLabel("Trechos");
        labelTrechos.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelTrechos.setBounds(150, 240, 200, 20);

        Panel painelTrecho = new Panel();
        JScrollPane painelScholl = new JScrollPane(painelTrecho);
        painelScholl.setBounds(10, 270, 342, 70);
        painelScholl.setVisible(true);


        JButton anteriorT = new JButton("Anterior");
        anteriorT.setBounds(10,30, 90, 40);

        JButton proximoT = new JButton("Proximo");
        proximoT.setBounds(265,30, 90, 40);

        Panel newPainel = new Panel();
        newPainel.setLayout(null);
        newPainel.setBounds(221, 1, 400, 400);
        newPainel.add(labelDados);
        newPainel.add(labelTransporte);
        newPainel.add(labelCTotal);
        newPainel.add(labelCMT);
        newPainel.add(labelCMKm);
        newPainel.add(labelCMCP);
        newPainel.add(labelCMCM);
        newPainel.add(labelCMCG);
        newPainel.add(labelTVeiculos);
        newPainel.add(labelTrechos);
        newPainel.add(labelTItens);
        newPainel.add(anteriorT);
        newPainel.add(proximoT);
        newPainel.add(painelScholl);

        frame.getContentPane().remove(1);
        frame.getContentPane().add(newPainel);
    }
}
