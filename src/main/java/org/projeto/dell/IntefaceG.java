package org.projeto.dell;

import javax.swing.*;
import java.awt.*;
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
    private final Programa programa = new Programa();

    private JTextField textComeco;
    private JTextField textDestino;
    private JTextField textCidade;
    private List<String> cidades;

    /**
     * Atributo com o index atual nos dados estatisticos.
     */
    private int indexCadastro;

    /**
     * Método main que instância a interface.
     */
    public static void main(String[] args) {
        IntefaceG tela = new IntefaceG();
    }

    /**
     * Construtor da classe interface.
     */
    public IntefaceG() {
        createFrame();
    }

    /**
     * Método em que cria o frame, e todos os elementos dos paineis, e suas funções.
     */
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
        confirmConsultar.addActionListener(e -> {
            String cidadeC = removerAcento(textComeco.getText());
            String cidadeD = removerAcento(textDestino.getText());
            if (!cidadeC.equalsIgnoreCase(cidadeD)) {
                if (programa.buscarIndexCidade(cidadeC) >= 0 && programa.buscarIndexCidade(cidadeD) >= 0) {
                    List<Double> results = programa.consultarTrechosxModalidade(cidadeC, cidadeD, cbMod.getSelectedIndex());
                    printTela("Distancia: " + String.format("%.2f", results.get(0)) + "km, Custo: R$" + String.format("%.2f", results.get(1)), "Resultado");
                } else
                    printTela("ERRO: Uma ou mais cidades nao foram encontradas. ","ERRO");
            } else
                printTela("ERRO: Cidades iguais, por favor mudar.","ERRO");
        });

        JButton buttonConsulta = new JButton("1- Consultar trechos");
        buttonConsulta.setBounds(10, 12, 200, 50);
        buttonConsulta.setBackground(Color.GRAY);
        buttonConsulta.addActionListener(e -> {
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
        addCidade.addActionListener(e -> {
            String nomeCidade = removerAcento(textCidade.getText());
            if (programa.buscarIndexCidade(nomeCidade) >= 0) {
                if (cidades.size() > 0 && nomeCidade.equalsIgnoreCase(cidades.get(cidades.size() - 1)))
                    printTela("ERRO: Cidade anterior e igual a que esta sendo adicionada.","ERRO");
                else
                    cidades.add(nomeCidade);
            } else
                printTela("ERRO: Cidade nao encontrada.","ERRO");
            textCidade.setText("");
        });
        addCidade.setBounds(250, 95, 100, 30);

        JButton confirmCadastro = new JButton("Confirmar");
        confirmCadastro.setBounds(108, 300, 150, 30);
        confirmCadastro.addActionListener(e -> {
            int erro = 0;
            int quantZero = 0;
            int colunasPreenchidas = 0;
            List<List<String>> listaItens = new ArrayList<>();
            for (int i = 0; i < tabelaItens.getRowCount(); i++) {
                String nomeAtual = removerAcento((String) tabelaItens.getValueAt(i, 0));
                String quantidadeAtual = (String) tabelaItens.getValueAt(i, 1);
                String pesoAtual = (String) tabelaItens.getValueAt(i, 2);
                if (!nomeAtual.equals("")) {
                    if (!quantidadeAtual.equals("")) {
                        try {
                            int numero = Integer.parseInt(quantidadeAtual);
                            if (numero < 0) {
                                throw new Exception();
                            } else if (numero == 0) {
                                quantZero += 1;
                            }
                        } catch (Exception o) {
                            erro += 1;
                            printTela("ERRO: Na coluna quantidade e necessario colocar um numero cardinal.","ERRO");
                        }
                    } else {
                        erro += 1;
                        printTela("ERRO: Necessario colocar uma quantidade para o item, mesmo ser for 0.","ERRO");
                    }

                    if (!pesoAtual.equals("")) {
                        try {
                            double numero = Double.parseDouble(pesoAtual);
                            if (numero <= 0.0)
                                throw new Exception();
                        } catch (Exception o) {
                            erro += 1;
                            printTela("ERRO: Na coluna peso e necessario colocar um numero maior que 0.","ERRO");
                        }
                    } else {
                        printTela("ERRO: Necessario colocar um peso para o item, mesmo ser for 0.1.","ERRO");
                        erro += 1;
                    }
                    List<String> item = new ArrayList<>(Arrays.asList(nomeAtual, quantidadeAtual, pesoAtual));
                    listaItens.add(item);
                    colunasPreenchidas += 1;
                }
            }
            if (colunasPreenchidas == quantZero) {
                erro += 1;
                printTela("ERRO: Nenhuma quantidade de itens adicionada, porfavor adicionar pelo menos um item.", "ERRO");
            }
            if (erro == 0 && cidades.size() > 1) {
                programa.cadastrarTransporte(cidades, listaItens);
                cidades = new ArrayList<>();
                List<Transporte> cadastros = programa.cadastrosTransportes;
                Transporte cadastrosAtual = cadastros.get(cadastros.size()-1);
                String mensagemCadastro = "Cadastro realizado com sucesso: Distancia total do transporte de " + (int) cadastrosAtual.getDistanciaTotal() + "km, sera utilizado ";
                List<Integer> quantidadeCaminhao = programa.calQuantCaminhao(cadastrosAtual.getPesoTotal());
                if (quantidadeCaminhao.get(0) > 1)
                    mensagemCadastro += quantidadeCaminhao.get(0) + " caminhoes pequenos, ";
                else if (quantidadeCaminhao.get(0) > 0)
                    mensagemCadastro += quantidadeCaminhao.get(0) + " caminhao pequeno, ";

                if (quantidadeCaminhao.get(1) > 1)
                    mensagemCadastro += quantidadeCaminhao.get(1) + " caminhoes medios, ";
                else if (quantidadeCaminhao.get(1) > 0)
                    mensagemCadastro += quantidadeCaminhao.get(1) + " caminhao medio, ";

                if (quantidadeCaminhao.get(2) > 1)
                    mensagemCadastro += quantidadeCaminhao.get(2) + " caminhoes grandes, ";
                else if (quantidadeCaminhao.get(2) > 0)
                    mensagemCadastro += quantidadeCaminhao.get(2) + " caminhao grande, ";

                double custoMUnitario = cadastrosAtual.getCustoTotal()/programa.dadosEstatisticos(cadastrosAtual).get(2);
                mensagemCadastro += "com um custo unitario medio de R$" + String.format("%.2f", custoMUnitario) + ".";
                printTela(mensagemCadastro, "Sucesso");
            } else if (erro == 0) {
                printTela("ERRO: Cidades insuficiente, por favor adicionar mais uma.", "ERRO");
            }

        });

        JButton buttonCadastro = new JButton("2- Cadastrar Transporte");
        buttonCadastro.setBounds(10, 77, 200, 50);
        buttonCadastro.setBackground(Color.GRAY);
        buttonCadastro.addActionListener(e -> {
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
        });
// --------------------------------------------Dados estatisticos--------------------------------------------------//
        indexCadastro = 0;
        JButton buttonDados = new JButton("3- Dados estatisticos");
        buttonDados.setBounds(10, 142, 200, 50);
        buttonDados.setBackground(Color.GRAY);
        buttonDados.addActionListener(e -> {
            if (programa.cadastrosTransportes.size() > 0) {
                criarPanelDados(indexCadastro);
            } else {
                printTela("ERRO: Nenhum cadastro realizado no momento, porfavor cadastrar antes de acessar os dados.", "ERRO");
            }
        });
// ----------------------------------------------------------------------------------------------------------------//

        JButton buttonFechar = new JButton("4- Fechar");
        buttonFechar.setBackground(Color.GRAY);
        buttonFechar.addActionListener(e -> System.exit(0));
        buttonFechar.setBounds(10, 305, 200, 40);


        painelE.add(buttonConsulta);
        painelE.add(buttonCadastro);
        painelE.add(buttonFechar);
        painelE.add(buttonDados);

        frame.add(painelE);
        frame.getContentPane().add(painelD);
        frame.setVisible(true);
    }

    /**
     * Método que cria uma optionPane para mostrar informações.
     *
     * @param string Mensagem que será mostrada.
     * @param janela Nome da optionPane que será criada.
     */
    public void printTela(String string, String janela) {
        JOptionPane.showMessageDialog(null, string,janela, JOptionPane.INFORMATION_MESSAGE, iconDisplay);
    }

    /**
     * Método para remover acento de String.
     *
     * @param string String para remover acento.
     */
    public static String removerAcento(String string) {
        String normalizer = Normalizer.normalize(string, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }

    /**
     * Método para criar o painel dos dados estatísticos.
     *
     * @param index Index do transporte que será mostrado no painel.
     */
    public void criarPanelDados(int index) {
        Transporte t = programa.cadastrosTransportes.get(index);
        List<Double> listaDados = programa.dadosEstatisticos(t);

        JLabel labelDados = new JLabel("Dados estatisticos");
        labelDados.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelDados.setBounds(115, 8, 300, 50);

        JLabel labelTransporte = new JLabel("Transporte (" +(indexCadastro+1)+"/" + programa.cadastrosTransportes.size() + ")");
        labelTransporte.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelTransporte.setBounds(120, 60, 300, 20);

        JLabel labelCTotal = new JLabel("Custo total:    R$" + String.format("%.2f", programa.cadastrosTransportes.get(index).getCustoTotal()));
        labelCTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCTotal.setBounds(15, 90, 400, 20);

        JLabel labelCMKm = new JLabel("Custo medio por Km:    R$" + String.format("%.2f", listaDados.get(0)));
        labelCMKm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMKm.setBounds(15, 113, 400, 20);

        JLabel labelCMT = new JLabel("Custo medio p/ tipo:    R$" + String.format("%.2f", listaDados.get(1)));
        labelCMT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMT.setBounds(15, 136, 400, 20);

        List<Integer> listaCaminhao = programa.calQuantCaminhao(t.getPesoTotal());
        List<Double> listMTipo = programa.custoMedioPTipo(t.getCustoTotalPCaminhao(), listaCaminhao);
        int totalVeiculos = listaCaminhao.get(0) + listaCaminhao.get(1) + listaCaminhao.get(2);
        JLabel labelCMCP = new JLabel("Custo medio caminhao pequeno:    R$" + String.format("%.2f", listMTipo.get(0)));
        labelCMCP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCP.setBounds(15, 159, 400, 20);

        JLabel labelCMCM = new JLabel("Custo medio caminhao medio:    R$" + String.format("%.2f", listMTipo.get(1)));
        labelCMCM.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCM.setBounds(15, 182, 400, 20);

        JLabel labelCMCG = new JLabel("Custo medio caminhao grande:    R$" + String.format("%.2f", listMTipo.get(2)));
        labelCMCG.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelCMCG.setBounds(15, 205, 400, 20);

        JLabel labelTVeiculos = new JLabel("Numero total veiculos:    " + totalVeiculos);
        labelTVeiculos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelTVeiculos.setBounds(15, 228, 400, 20);

        JLabel labelTItens = new JLabel("Numero total de itens:    " + String.format("%.2f", listaDados.get(2)));
        labelTItens.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        labelTItens.setBounds(15, 251,400, 20);

        JButton trechosButton = new JButton("Dados Trechos");
        trechosButton.setBounds(40,280, 300, 40);
        trechosButton.addActionListener(e -> {
            List<Trecho> trechos = t.getTrechos();
            for (Trecho trecho : trechos) {
                printTela("O trecho de " + trecho.getCidadeI() + " ate " + trecho.getCidadeF() + " tem uma distancia de " + (int) trecho.getDistancia() + "km, e um custo de R$" + String.format("%.2f", trecho.getCusto()), trecho.getCidadeI() + " - " + trecho.getCidadeF());
            }
        });

        JButton anteriorT = new JButton("Anterior");
        anteriorT.setBounds(10,13, 90, 40);
        anteriorT.addActionListener(e -> {
            indexCadastro -= 1;
            criarPanelDados(indexCadastro);
        });

        JButton proximoT = new JButton("Proximo");
        proximoT.setBounds(265,13, 90, 40);
        proximoT.addActionListener(e -> {
            indexCadastro += 1;
            criarPanelDados(indexCadastro);
        });

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
        newPainel.add(labelTItens);
        if (indexCadastro > 0)
            newPainel.add(anteriorT);
        if (programa.cadastrosTransportes.size() > 1 && indexCadastro < programa.cadastrosTransportes.size()-1)
            newPainel.add(proximoT);
        newPainel.add(trechosButton);

        frame.getContentPane().remove(1);
        frame.getContentPane().add(newPainel);
    }
}
