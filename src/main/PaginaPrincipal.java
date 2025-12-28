package main;

import javax.swing.*;

import bean.Cliente;
import bean.Emprestimo;
import bean.Exemplar;
import bean.Fisico;
import bean.Funcionario;
import bean.GerenciadorGeneros;
import dao.ClienteDAO;
import dao.ConsultaDAO;
import dao.EmprestimoDAO;
import dao.ExemplarDAO;
import dao.FisicoDAO;
import dao.PessoaDAO;
import dao.FuncionarioDAO;
import dao.LivroDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

public class PaginaPrincipal extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel Menu;
    private JPanel CadastroCliente;
    private JTextField textFieldNomeCC;
    private JTextField textFieldCPFCC;
    private JDateChooser dateChooserDataNascCC;
    private Date dataNascCC;
    private JTextField textFieldLogradouroCC;
    private JTextField textFieldCEPCC;
    private JTextField textFieldNumCC;
    private JTextField textFieldCidadeCC;
    private JTextField textFieldPaisCC;
    private JPanel BuscaEditaCliente;
    private JTextField textFieldCPFBEC;
    private JPanel EditaCliente;    
    private JTextField textFieldNomeEC;
    private JDateChooser dateChooserDataNascEC;
    private Date dataNascEC;
    private JTextField textFieldLogradouroEC;
    private JTextField textFieldNumEC;
    private JTextField textFieldCidadeEC;
    private JTextField textFieldCEPEC;
    private JTextField textFieldPaisEC;
    private JTextField textFieldCPFEC;
	private Date dataCadastroEC;
    private JPanel DeletaCliente;
    private JTextField textFieldCPFDC;
    private JPanel ListaCliente;
    private JTable table1LC;
    private JTable table2LC;
    private JPanel ListaTodosCliente;
    private JTable tableLTC;
    private JPanel CadastroFuncionario;
    private JTextField textFieldPaisCF;
    private JTextField textFieldCEPCF;
    private JTextField textFieldNumCF;
    private JTextField textFieldLogradouroCF;
    private JTextField textFieldCidadeCF;
    private JTextField textFieldCPFCF;
    private JTextField textFieldNomeCF;
    private JTextField textFieldCPFLC;
    private JTextField textFieldSalarioCF;
    private JDateChooser dateChooserDataNascCF;
    private Date dataNascCF;
    private JPanel BuscaEditaFuncionario;
    private JPanel EditaFuncionario;
    private JTextField textFieldNomeEF;
    private JDateChooser dateChooserDataNascEF;
    private Date dataNascEF;
    private JTextField textFieldSalarioEF;
    private JTextField textFieldLogradouroEF;
    private JTextField textFieldNumEF;
    private JTextField textFieldCidadeEF;
    private JTextField textFieldCPFEF;
    private JTextField textFieldCEPEF;
    private JTextField textFieldPaisEF;
    private JTextField textFieldCPFBEF;
	private Date dataAdmissaoEF;
    private JPanel DeletaFuncionario;
    private JTextField textFieldCPFDF;
    private JPanel ListaFuncionario;
	private JTable table1LF;
	private JTable table2LF;
	private JPanel ListaTodosFuncionario;
	private JTable tableLTF;
    private JTextField textFieldCPFLF;
    private JPanel CadastroFisico;
    private JTextField textFieldTituloLivroCFi;
    private JTextField textFieldISBNCFi;
    private JTextField textFieldAutorCFi;
    private JTextField textFieldValorCFi;
    private JPanel EditaFisico;
    private JTextField textFieldTituloLivroEFi;
    private JTextField textFieldValorEFi;
    private GerenciadorGeneros gSelecionadoEFi;
    private JTextField textFieldAutorEFi;
    private JTextArea textAreaListaAutorEFi;
    private ArrayList<String> autoresEFi;
    private JTextArea textAreaSinopseEFi;
    private JTextField textFieldISBNEFi;
	private Integer numCopiasDisponiveisEFi;
    private JPanel BuscaEditaFisico;
    private JTextField textFieldISBNBEFi;
    private JPanel DeletaFisico;
    private JTextField textFieldISBNDFi;
    private JPanel ListaFisico;
	private JTable table1LFi;
	private JTable table2LFi;
    private JTextField textFieldISBNBLFi;
	private JPanel ListaTodosFisico;
	private JTable tableLTFi;
    private JPanel CadastroExemplar;
    private JTextField textFieldISBNCEx;
    private JTextField textFieldNumeroCEx;
    private JTextField textFieldEdicaoCEx;
    private String estadoConservacaoCEx="";
    private JPanel EditaExemplar;
	private JTextField textFieldEdicaoEEx;
	private String estadoConservacaoEEx="";
	private JTextField textFieldISBNEEx;
	private JTextField textFieldNumeroEEx;
	private JPanel BuscaEditaExemplar;
	private JTextField textFieldISBNBEEx;
	private JTextField textFieldNumeroBEEx;
	private JPanel ListaExemplar;
	private JTable table1LEx;
	private JTable table2LEx;
	private JTextField textFieldNumeroLEx;
	private JTextField textFieldISBNLEx;
	private JPanel ListaTodosExemplar;
	private JTable tableLTEx;
	private JPanel DeletaExemplar;
	private JTextField textFieldISBNDEx;
	private JTextField textFieldNumeroDEx;
	private JPanel CadastroEmprestimo;
	private JTextField textFieldCPFClienteCE;
	private JTextField textFieldISBNLivroCE;
	private JTextField textFieldNumExemplarCE;
	private JTextField textFieldCPFFuncionarioCE;
	private JDateChooser dateChooserDataFimCE;
	private JPanel EditaEmprestimo;
	private JTextField textFieldCPFFuncEE;
	private JDateChooser dateChooserDataFimEE;
	private JPanel BuscaEditaEmprestimo;
	private JTextField textFieldCPFClienteBEE;
	private JTextField textFieldISBNLivroBEE;
	private JTextField textFieldNumeroExemplarBEE;
	private JDateChooser dateChooserDataBEE;
	private JTextField textFieldHoraBEE;
	private JPanel DeletaEmprestimo;
	private JTextField textFieldCPFClienteDE;
	private JTextField textFieldISBNLivroDE;
	private JTextField textFieldNumeroExemplarDE;
	private JDateChooser dateChooserDataDE;
	private JTextField textFieldHoraDE;
	private JPanel ListaEmprestimo;
	private JTextField textFieldCPFClienteLE;
	private JTextField textFieldISBNLivroLE;
	private JTextField textFieldNumeroExemplarLE;
	private JTextField textFieldHoraLE;
	private JTable tableLE;
	private JPanel ListaTodosEmprestimo;
	private JTable tableLTE;
	private JPanel ConsultaEF;
	private JTable tableCEF;
	private ArrayList <ArrayList<Object>> listaCEF=new ArrayList<>();
	private JPanel ConsultaEC;
	private JTable tableCEC;
	private ArrayList <ArrayList<Object>> listaCEC=new ArrayList<>();
	private JPanel ConsultaLG;
	private JTable tableCLG;
	private ArrayList <ArrayList<Object>> listaCLG=new ArrayList<>();
	private JPanel ConsultaEH;
	protected int totalEH;
	private String telaErro;
	private JPanel MensagemErro;
	private JTextArea txtAreaMsgErro;
	private JPanel MensagemSucesso;
	private JTextArea txtAreaMsgSucesso;
    
    @SuppressWarnings("serial")
	public PaginaPrincipal() {
    	
        setDefaultLookAndFeelDecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 814, 639);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);
        
        //Menu
        
        Menu = new JPanel();
        Menu.setBackground(new Color(255, 217, 220));
        contentPane.add(Menu, "Menu");
        Menu.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 800, 44);
        menuBar.setToolTipText("");
        menuBar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        menuBar.setBackground(new Color(255, 255, 255));
        Menu.add(menuBar);

        JMenu mnCliente = new JMenu("Cliente");
        mnCliente.setForeground(new Color(124, 3, 54));
        mnCliente.setFont(new Font("Sitka Small", Font.BOLD, 25));
        menuBar.add(mnCliente);

        JMenuItem mntmCadastroCliente = new JMenuItem("Cadastrar");
        mntmCadastroCliente.setBackground(new Color(242, 206, 216));
        mntmCadastroCliente.setForeground(new Color(124, 3, 54));
        mntmCadastroCliente.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnCliente.add(mntmCadastroCliente);

        mntmCadastroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "CadastroCliente");
            }
        });
        
        JMenuItem mntmListaCliente = new JMenuItem("Listar");
        mntmListaCliente.setBackground(new Color(242, 206, 216));
        mntmListaCliente.setForeground(new Color(124, 3, 54));
        mntmListaCliente.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnCliente.add(mntmListaCliente);

        mntmListaCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaCliente");
            }
        });
        
        JMenuItem mntmListaTodosCliente = new JMenuItem("Listar todos");
        mntmListaTodosCliente.setBackground(new Color(242, 206, 216));
        mntmListaTodosCliente.setForeground(new Color(124, 3, 54));
        mntmListaTodosCliente.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnCliente.add(mntmListaTodosCliente);

        mntmListaTodosCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaTodosCliente");
            }
        });
        
        JMenuItem mntmEditaCliente = new JMenuItem("Editar");
        mntmEditaCliente.setBackground(new Color(242, 206, 216));
        mntmEditaCliente.setForeground(new Color(124, 3, 54));
        mntmEditaCliente.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnCliente.add(mntmEditaCliente);

        mntmEditaCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BuscaEditaCliente");
            }
        });
        
        JMenuItem mntmDeletaCliente = new JMenuItem("Deletar");
        mntmDeletaCliente.setBackground(new Color(242, 206, 216));
        mntmDeletaCliente.setForeground(new Color(124, 3, 54));
        mntmDeletaCliente.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnCliente.add(mntmDeletaCliente);

        mntmDeletaCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "DeletaCliente");
            }
        });
        
        JMenu mnFuncionario = new JMenu("Funcionário");
        mnFuncionario.setForeground(new Color(124, 3, 54));
		mnFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 25));
		menuBar.add(mnFuncionario);
		
		JMenuItem mntmCadastroFuncionario = new JMenuItem("Cadastrar");
		mntmCadastroFuncionario.setBackground(new Color(242, 206, 216));
		mntmCadastroFuncionario.setForeground(new Color(124, 3, 54));
		mntmCadastroFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnFuncionario.add(mntmCadastroFuncionario);
		
		mntmCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "CadastroFuncionario");
			}
		});
		
		JMenuItem mntmListaFuncionario = new JMenuItem("Listar");
		mntmListaFuncionario.setBackground(new Color(242, 206, 216));
		mntmListaFuncionario.setForeground(new Color(124, 3, 54));
		mntmListaFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnFuncionario.add(mntmListaFuncionario);
		
		mntmListaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "ListaFuncionario");
			}
		});
		
		JMenuItem mntmListaTodosFuncionario = new JMenuItem("Listar todos");
		mntmListaTodosFuncionario.setBackground(new Color(242, 206, 216));
		mntmListaTodosFuncionario.setForeground(new Color(124, 3, 54));
		mntmListaTodosFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnFuncionario.add(mntmListaTodosFuncionario);
		
		mntmListaTodosFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "ListaTodosFuncionario");
	        }
	    });

		JMenuItem mntmEditaFuncionario = new JMenuItem("Editar");
		mntmEditaFuncionario.setBackground(new Color(242, 206, 216));
		mntmEditaFuncionario.setForeground(new Color(124, 3, 54));
		mntmEditaFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnFuncionario.add(mntmEditaFuncionario);
		
		mntmEditaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "BuscaEditaFuncionario");
			}
		});
		
		JMenuItem mntmDeletaFuncionario = new JMenuItem("Deletar");
		mntmDeletaFuncionario.setBackground(new Color(242, 206, 216));
		mntmDeletaFuncionario.setForeground(new Color(124, 3, 54));
		mntmDeletaFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnFuncionario.add(mntmDeletaFuncionario);
		
		mntmDeletaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "DeletaFuncionario");
			}
		});
		
        JMenu mnLivro = new JMenu("Livro");
        mnLivro.setForeground(new Color(124, 3, 54));
		mnLivro.setFont(new Font("Sitka Small", Font.BOLD, 25));
		menuBar.add(mnLivro);
		
		JMenu smnFisico = new JMenu("Físico");
		smnFisico.setForeground(new Color(124, 3, 54));
		smnFisico.setFont(new Font("Sitka Small", Font.BOLD, 24));
		mnLivro.add(smnFisico);
		
		JMenuItem mntmCadastroFisico = new JMenuItem("Cadastrar");
		mntmCadastroFisico.setForeground(new Color(124, 3, 54));
		mntmCadastroFisico.setBackground(new Color(242, 206, 216));
		mntmCadastroFisico.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnFisico.add(mntmCadastroFisico);
		
		mntmCadastroFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "CadastroFisico");
            }
        });
        
		JMenuItem mntmListaFisico = new JMenuItem("Listar");
		mntmListaFisico.setBackground(new Color(242, 206, 216));
		mntmListaFisico.setForeground(new Color(124, 3, 54));
		mntmListaFisico.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnFisico.add(mntmListaFisico);
		
		mntmListaFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaFisico");
            }
        });
		
		JMenuItem mntmListaTodosFisico = new JMenuItem("Listar Todos");
		mntmListaTodosFisico.setBackground(new Color(242, 206, 216));
		mntmListaTodosFisico.setForeground(new Color(124, 3, 54));
		mntmListaTodosFisico.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnFisico.add(mntmListaTodosFisico);
		
		mntmListaTodosFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaTodosFisico");
            }
        });

		JMenuItem mntmEditaFisico = new JMenuItem("Editar");
		mntmEditaFisico.setBackground(new Color(242, 206, 216));
		mntmEditaFisico.setForeground(new Color(124, 3, 54));
		mntmEditaFisico.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnFisico.add(mntmEditaFisico);
		
		mntmEditaFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BuscaEditaFisico");
            }
        });
		
		JMenuItem mntmDeletaFisico = new JMenuItem("Deletar");
		mntmDeletaFisico.setForeground(new Color(124, 3, 54));
		mntmDeletaFisico.setBackground(new Color(242, 206, 216));
		mntmDeletaFisico.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        smnFisico.add(mntmDeletaFisico);
        
        mntmDeletaFisico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "DeletaFisico");
            }
        });
        
        JMenu smnExemplar = new JMenu("Exemplar");
        smnExemplar.setForeground(new Color(124, 3, 54));
        smnExemplar.setFont(new Font("Sitka Small", Font.BOLD, 25));
        smnFisico.add(smnExemplar);
		
		JMenuItem mntmCadastroExemplar = new JMenuItem("Cadastrar");
		mntmCadastroExemplar.setBackground(new Color(242, 206, 216));
		mntmCadastroExemplar.setForeground(new Color(124, 3, 54));
		mntmCadastroExemplar.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnExemplar.add(mntmCadastroExemplar);
		
		mntmCadastroExemplar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "CadastroExemplar");
            }
        });
		
		JMenuItem mntmListaExemplar = new JMenuItem("Listar");
		mntmListaExemplar.setForeground(new Color(124, 3, 54));
		mntmListaExemplar.setBackground(new Color(242, 206, 216));
		mntmListaExemplar.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnExemplar.add(mntmListaExemplar);
		
		mntmListaExemplar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaExemplar");
            }
        });
		
		JMenuItem mntmListaTodosExemplar = new JMenuItem("Listar todos");
		mntmListaTodosExemplar.setBackground(new Color(242, 206, 216));
		mntmListaTodosExemplar.setForeground(new Color(124, 3, 54));
		mntmListaTodosExemplar.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnExemplar.add(mntmListaTodosExemplar);
		
		mntmListaTodosExemplar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaTodosExemplar");
            }
        });
		
		JMenuItem mntmEditaExemplar = new JMenuItem("Editar/Devolução");
		mntmEditaExemplar.setBackground(new Color(242, 206, 216));
		mntmEditaExemplar.setForeground(new Color(124, 3, 54));
		mntmEditaExemplar.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnExemplar.add(mntmEditaExemplar);
		
		mntmEditaExemplar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BuscaEditaExemplar");
            }
        });
		
		JMenuItem mntmDeletaExemplar = new JMenuItem("Deletar");
		mntmDeletaExemplar.setForeground(new Color(124, 3, 54));
		mntmDeletaExemplar.setBackground(new Color(242, 206, 216));
		mntmDeletaExemplar.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnExemplar.add(mntmDeletaExemplar);
		
		mntmDeletaExemplar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "DeletaExemplar");
            }
        });
		
        JMenu smnDigital = new JMenu("Digital");
        smnDigital.setForeground(new Color(124, 3, 54));
        smnDigital.setFont(new Font("Sitka Small", Font.BOLD, 25));
        mnLivro.add(smnDigital);
        
		JMenuItem mntmIndisponivelDigital = new JMenuItem("Ainda não disponível...");
		mntmIndisponivelDigital.setBackground(new Color(242, 206, 216));
		mntmIndisponivelDigital.setForeground(new Color(124, 3, 54));
		mntmIndisponivelDigital.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		smnDigital.add(mntmIndisponivelDigital);
        
		JMenu mnEmprestimo = new JMenu("Empréstimo");
		mnEmprestimo.setForeground(new Color(124, 3, 54));
		mnEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 25));
		menuBar.add(mnEmprestimo);
		
		JMenuItem mntmCadastroEmprestimo = new JMenuItem("Cadastrar");
		mntmCadastroEmprestimo.setBackground(new Color(242, 206, 216));
		mntmCadastroEmprestimo.setForeground(new Color(124, 3, 54));
		mntmCadastroEmprestimo.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnEmprestimo.add(mntmCadastroEmprestimo);

        mntmCadastroEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "CadastroEmprestimo");
            }
        });
        
        JMenuItem mntmListaEmprestimo = new JMenuItem("Listar");
        mntmListaEmprestimo.setBackground(new Color(242, 206, 216));
        mntmListaEmprestimo.setForeground(new Color(124, 3, 54));
        mntmListaEmprestimo.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnEmprestimo.add(mntmListaEmprestimo);

        mntmListaEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaEmprestimo");
            }
        });
        
        JMenuItem mntmListaTodosEmprestimo = new JMenuItem("Listar todos");
        mntmListaTodosEmprestimo.setBackground(new Color(242, 206, 216));
        mntmListaTodosEmprestimo.setForeground(new Color(124, 3, 54));
        mntmListaTodosEmprestimo.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnEmprestimo.add(mntmListaTodosEmprestimo);

        mntmListaTodosEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "ListaTodosEmprestimo");
            }
        });
        
        JMenuItem mntmEditaEmprestimo = new JMenuItem("Editar");
        mntmEditaEmprestimo.setBackground(new Color(242, 206, 216));
        mntmEditaEmprestimo.setForeground(new Color(124, 3, 54));
        mntmEditaEmprestimo.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnEmprestimo.add(mntmEditaEmprestimo);

        mntmEditaEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BuscaEditaEmprestimo");
            }
        });
        
        JMenuItem mntmDeletaEmprestimo = new JMenuItem("Deletar");
        mntmDeletaEmprestimo.setBackground(new Color(242, 206, 216));
        mntmDeletaEmprestimo.setForeground(new Color(124, 3, 54));
        mntmDeletaEmprestimo.setFont(new Font("Sitka Small", Font.PLAIN, 24));
        mnEmprestimo.add(mntmDeletaEmprestimo);

        mntmDeletaEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "DeletaEmprestimo");
            }
        });
		
		JMenu mnCompra = new JMenu("Compra");
		mnCompra.setForeground(new Color(124, 3, 54));
		mnCompra.setFont(new Font("Sitka Small", Font.BOLD, 25));
		menuBar.add(mnCompra);
		
		JMenuItem mntmIndisponivelCompra = new JMenuItem("Ainda não disponível...");
		mntmIndisponivelCompra.setBackground(new Color(242, 206, 216));
		mntmIndisponivelCompra.setForeground(new Color(124, 3, 54));
		mntmIndisponivelCompra.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnCompra.add(mntmIndisponivelCompra);
		
		JMenu mnRelatorio = new JMenu("Relatório");
		mnRelatorio.setForeground(new Color(124, 3, 54));
		mnRelatorio.setFont(new Font("Sitka Small", Font.BOLD, 25));
		menuBar.add(mnRelatorio);
		
		JMenuItem mntmTotalEmpF = new JMenuItem("Empréstimos por funcionário");
		mntmTotalEmpF.setForeground(new Color(124, 3, 54));
		mntmTotalEmpF.setBackground(new Color(242, 206, 216));
		mntmTotalEmpF.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnRelatorio.add(mntmTotalEmpF);
		
		mntmTotalEmpF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "ConsultaEF");
			}
		});
		
		JMenuItem mntmTotalEmpC = new JMenuItem("Empréstimos por cliente");
		mntmTotalEmpC.setForeground(new Color(124, 3, 54));
		mntmTotalEmpC.setBackground(new Color(242, 206, 216));
		mntmTotalEmpC.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnRelatorio.add(mntmTotalEmpC);
		
		mntmTotalEmpC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "ConsultaEC");
			}
		});
		
		JMenuItem mntmTotalLivroFG = new JMenuItem("Livros físicos por gênero");
		mntmTotalLivroFG.setForeground(new Color(124, 3, 54));
		mntmTotalLivroFG.setBackground(new Color(242, 206, 216));
		mntmTotalLivroFG.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnRelatorio.add(mntmTotalLivroFG);
		
		mntmTotalLivroFG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "ConsultaLG");
			}
		});
		
		JMenuItem mntmTotalEmprestimosHoje = new JMenuItem("Total de empréstimos de hoje");
		mntmTotalEmprestimosHoje.setForeground(new Color(124, 3, 54));
		mntmTotalEmprestimosHoje.setBackground(new Color(242, 206, 216));
		mntmTotalEmprestimosHoje.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		mnRelatorio.add(mntmTotalEmprestimosHoje);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Pagina Inicial.png")));
		lblMenu.setBounds(0, 0, 798, 600);
		Menu.add(lblMenu);
		
		mntmTotalEmprestimosHoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "ConsultaEH");
			}
		});
		
        //        <<<<<<<<<<MENSAGENS>>>>>>>>>>
        
        //MensagemErro
        
        MensagemErro = new JPanel();
        MensagemErro.setBackground(new Color(255, 217, 220));
        contentPane.add(MensagemErro, "MensagemErro");
        MensagemErro.setLayout(null);
        
        txtAreaMsgErro = new JTextArea();
        txtAreaMsgErro.setOpaque(false);
        txtAreaMsgErro.setWrapStyleWord(true);
        txtAreaMsgErro.setFont(new Font("Sitka Small", Font.PLAIN, 20));
        txtAreaMsgErro.setLineWrap(true);
        txtAreaMsgErro.setBackground(new Color(255, 255, 255));
        txtAreaMsgErro.setBounds(99, 256, 610, 264);
        MensagemErro.add(txtAreaMsgErro);
        
        JButton btnOkMsgErro = new JButton("Ok");
        btnOkMsgErro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, telaErro);
			}
		});
        btnOkMsgErro.setForeground(new Color(145, 6, 79));
        btnOkMsgErro.setFont(new Font("Sitka Small", Font.PLAIN, 30));
        btnOkMsgErro.setBackground(new Color(241, 180, 181));
        btnOkMsgErro.setBounds(317, 513, 147, 41);
        MensagemErro.add(btnOkMsgErro);
        
        JLabel lblNewLabel_34 = new JLabel("New label");
        lblNewLabel_34.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Pagina Erro.png")));
        lblNewLabel_34.setBounds(0, 0, 798, 600);
        MensagemErro.add(lblNewLabel_34);
        Menu.setLayout(null);
        
        //MensagemSucesso

        MensagemSucesso = new JPanel();
        MensagemSucesso.setBackground(new Color(255, 217, 220));
        contentPane.add(MensagemSucesso, "MensagemSucesso");
        MensagemSucesso.setLayout(null);
        
        txtAreaMsgSucesso = new JTextArea();
        txtAreaMsgSucesso.setOpaque(false);
        txtAreaMsgSucesso.setWrapStyleWord(true);
        txtAreaMsgSucesso.setFont(new Font("Sitka Small", Font.PLAIN, 20));
        txtAreaMsgSucesso.setLineWrap(true);
        txtAreaMsgSucesso.setBackground(new Color(255, 255, 255));
        txtAreaMsgSucesso.setBounds(99, 315, 610, 177);
        MensagemSucesso.add(txtAreaMsgSucesso);
        
        JButton btnOkMsgSucesso = new JButton("Ok");
        btnOkMsgSucesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "Menu");
			}
		});
        btnOkMsgSucesso.setForeground(new Color(145, 6, 79));
        btnOkMsgSucesso.setFont(new Font("Sitka Small", Font.PLAIN, 30));
        btnOkMsgSucesso.setBackground(new Color(241, 180, 181));
        btnOkMsgSucesso.setBounds(318, 514, 147, 41);
        MensagemSucesso.add(btnOkMsgSucesso);
        
        JLabel lblNewLabel_35 = new JLabel("New label");
        lblNewLabel_35.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Pagina Sucesso.png")));
        lblNewLabel_35.setBounds(0, 0, 798, 600);
        MensagemSucesso.add(lblNewLabel_35);
		
        //    <<<<<<<<<<<<<CLIENTE>>>>>>>>>>>>>
        
        //CadastroCliente
        
        CadastroCliente = new JPanel();
        CadastroCliente.setBackground(new Color(255, 221, 222));
        contentPane.add(CadastroCliente, "CadastroCliente");
        CadastroCliente.setLayout(null);
        
        JLabel lblCCliente = new JLabel("Cadastrar Cliente");
        lblCCliente.setBounds(264, 60, 288, 50);
        lblCCliente.setForeground(new Color(255, 255, 255));
        lblCCliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        CadastroCliente.add(lblCCliente);
        
        JButton btnVoltarCC = new JButton("");
        btnVoltarCC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCC.setBounds(10, 11, 78, 35);
        btnVoltarCC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        		//limparInfoCC();
        	}
        });
        
        btnVoltarCC.setBackground(new Color(241, 180, 181));
        btnVoltarCC.setForeground(new Color(145, 6, 79));
        btnVoltarCC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        CadastroCliente.add(btnVoltarCC);
        
        JLabel lblNomeCC = new JLabel("Nome:");
        lblNomeCC.setBounds(32, 148, 90, 35);
        lblNomeCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblNomeCC);
        
        textFieldNomeCC = new JTextField();
        textFieldNomeCC.setBounds(122, 145, 412, 30);
        textFieldNomeCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblNomeCC.setLabelFor(textFieldNomeCC);
        CadastroCliente.add(textFieldNomeCC);
        
        textFieldNomeCC.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldNomeCC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCPFCC = new JLabel("CPF:");
        lblCPFCC.setBounds(32, 188, 90, 30);
        lblCPFCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblCPFCC);
        
        textFieldCPFCC = new JTextField();
        textFieldCPFCC.setBounds(99, 183, 235, 30);
        textFieldCPFCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblCPFCC.setLabelFor(textFieldCPFCC);
        textFieldCPFCC.setColumns(10);
        CadastroCliente.add(textFieldCPFCC);
        
        textFieldCPFCC.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFCC.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        JLabel lblDataNascCC = new JLabel("Data de nascimento:");
        lblDataNascCC.setBounds(32, 217, 275, 50);
        lblDataNascCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblDataNascCC);
        
        dateChooserDataNascCC = new JDateChooser();
        dateChooserDataNascCC.setBounds(299, 220, 211, 35);
        CadastroCliente.add(dateChooserDataNascCC);
        
        JLabel lblEnderecoCC = new JLabel("Endereço:");
        lblEnderecoCC.setBounds(32, 259, 177, 50);
        lblEnderecoCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblEnderecoCC);
        
        textFieldLogradouroCC = new JTextField();
        textFieldLogradouroCC.setBounds(195, 306, 377, 30);
        textFieldLogradouroCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblEnderecoCC.setLabelFor(textFieldLogradouroCC);
        textFieldLogradouroCC.setColumns(10);
        CadastroCliente.add(textFieldLogradouroCC);
        
        textFieldLogradouroCC.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldLogradouroCC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCEPCC = new JLabel("CEP:");
        lblCEPCC.setBounds(32, 350, 90, 50);
        lblCEPCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblCEPCC);
        
        textFieldCEPCC = new JTextField();
        textFieldCEPCC.setBounds(99, 355, 177, 30);
        textFieldCEPCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblCEPCC.setLabelFor(textFieldCEPCC);
        textFieldCEPCC.setColumns(10);
        CadastroCliente.add(textFieldCEPCC);
        
        textFieldCEPCC.addKeyListener(new KeyListener() {
            final int maxCharacters=8;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCEPCC.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumCC = new JLabel("Nº:");
        lblNumCC.setBounds(577, 301, 50, 50);
        lblNumCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblNumCC);
        
        textFieldNumCC = new JTextField();
        textFieldNumCC.setBounds(627, 306, 114, 30);
        textFieldNumCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblNumCC.setLabelFor(textFieldNumCC);
        textFieldNumCC.setColumns(10);
        CadastroCliente.add(textFieldNumCC);
        
        textFieldNumCC.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCidadeCC = new JLabel("Cidade:");
        lblCidadeCC.setBounds(32, 393, 124, 50);
        lblCidadeCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblCidadeCC);
        
        textFieldCidadeCC = new JTextField();
        textFieldCidadeCC.setBounds(139, 398, 275, 30);
        textFieldCidadeCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblCidadeCC.setLabelFor(textFieldCidadeCC);
        textFieldCidadeCC.setColumns(10);
        CadastroCliente.add(textFieldCidadeCC);
        
        textFieldCidadeCC.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCidadeCC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblPaisCC = new JLabel("País:");
        lblPaisCC.setBounds(286, 350, 90, 50);
        lblPaisCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroCliente.add(lblPaisCC);
        
        textFieldPaisCC = new JTextField();
        textFieldPaisCC.setBounds(352, 355, 275, 30);
        textFieldPaisCC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPaisCC.setLabelFor(textFieldPaisCC);
        textFieldPaisCC.setColumns(10);
        CadastroCliente.add(textFieldPaisCC);
        
        textFieldPaisCC.addKeyListener(new KeyListener() {
            final int maxCharacters=40;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldPaisCC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnCadastrarCliente = new JButton("Cadastrar");
        btnCadastrarCliente.setBounds(591, 476, 197, 50);
        btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFCC.getText();
        		String nome = textFieldNomeCC.getText();
        		dataNascCC = dateChooserDataNascCC.getDate();
        		String logradouro = textFieldLogradouroCC.getText();
	            String numero = textFieldNumCC.getText();
	            String CEP = textFieldCEPCC.getText();
	            String cidade = textFieldCidadeCC.getText();
	            String pais = textFieldPaisCC.getText();
	            ArrayList<String> val=valParametrosCliente(cpf, nome, dataNascCC, logradouro, numero, CEP, cidade, pais);
        		if(val.isEmpty()) {
        			ClienteDAO cDAO = new ClienteDAO();
    				Cliente cb = cDAO.buscaCPF(cpf);
    				if(cb==null) {
        	            Cliente c = new Cliente(cpf, nome, dataNascCC, logradouro, numero, CEP, cidade, pais, new Date());
        	            PessoaDAO pDAO = new PessoaDAO();
        	            int inseriuPessoa = pDAO.inserirC(c);
        	            int inseriuCliente = cDAO.inserir(c);
        	            if(inseriuPessoa==1 && inseriuCliente==1){
        	            	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("O cliente foi cadastrado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
        	            }else {
        	            	txtAreaMsgErro.setText("");
                	        txtAreaMsgErro.append("Não inseriu, houve algum erro!" + "\n");
                			telaErro="CadastroCliente";
                    		cardLayout.show(contentPane, "MensagemErro");
        	            }
    				}else {
    					txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Já existe um cliente cadastrado com esse CPF!" + "\n");
            			telaErro="CadastroCliente";
                		cardLayout.show(contentPane, "MensagemErro");
    				}
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
        	            txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="CadastroCliente";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnCadastrarCliente.setBackground(new Color(217, 180, 190));
        btnCadastrarCliente.setForeground(new Color(115, 38, 52));
        btnCadastrarCliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        CadastroCliente.add(btnCadastrarCliente);
        
        JLabel lblLogradouroCC = new JLabel("Logradouro:");
        lblLogradouroCC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblLogradouroCC.setBounds(32, 301, 177, 50);
        CadastroCliente.add(lblLogradouroCC);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel.setBounds(0, 0, 798, 600);
        CadastroCliente.add(lblNewLabel);
        
        //ListaCliente
        
        ListaCliente = new JPanel();
        ListaCliente.setBackground(new Color(255, 221, 222));
        contentPane.add(ListaCliente, "ListaCliente");
        ListaCliente.setLayout(null);
        
        JLabel lblListarCliente = new JLabel("Listar Cliente");
        lblListarCliente.setForeground(Color.WHITE);
        lblListarCliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarCliente.setBounds(296, 62, 229, 50);
        ListaCliente.add(lblListarCliente);
        
        JButton btnVoltarLC = new JButton("");
        btnVoltarLC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLC.setForeground(new Color(145, 6, 79));
        btnVoltarLC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLC.setBackground(new Color(241, 180, 181));
        btnVoltarLC.setBounds(10, 11, 69, 30);
        ListaCliente.add(btnVoltarLC);
        
        JLabel lblCPFLC = new JLabel("CPF do Cliente:");
        lblCPFLC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFLC.setBounds(166, 152, 207, 32);
        ListaCliente.add(lblCPFLC);
        
        textFieldCPFLC = new JTextField();
        textFieldCPFLC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCPFLC.setColumns(10);
        textFieldCPFLC.setBounds(367, 148, 235, 30);
        ListaCliente.add(textFieldCPFLC);   

        textFieldCPFLC.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFLC.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        table1LC=new JTable();
        table1LC.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        table1LC.setModel(new DefaultTableModel(
        	new Object[][] {
        		{" ", "  ", " ", " "},
        	},
        	new String[] {
        		"Nome", "CPF", "Data de nascimento", "Data de cadastro"
        	}
        ));
        table1LC.getColumnModel().getColumn(0).setPreferredWidth(180);
        table1LC.getColumnModel().getColumn(1).setPreferredWidth(50);
        table1LC.getColumnModel().getColumn(2).setPreferredWidth(140);
        table1LC.getColumnModel().getColumn(3).setPreferredWidth(110);
        JTableHeader header1LC=table1LC.getTableHeader();
        header1LC.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header1LC.setForeground(Color.WHITE);
        header1LC.setBackground(new Color(241, 180, 181));
        table1LC.setFont(new Font("Century Gothic", Font.PLAIN, 17));
       
        JScrollPane scrollPane1LC = new JScrollPane();
        scrollPane1LC.getViewport().setOpaque(false);
        scrollPane1LC.setOpaque(false);
        scrollPane1LC.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane1LC.setBounds(25, 242, 746, 71);
        scrollPane1LC.setViewportView(table1LC);
        ListaCliente.add(scrollPane1LC);
        
        table2LC=new JTable();
        table2LC.setModel(new DefaultTableModel(
        	new Object[][] {
          		{" ", "  ", " ", " "},
           	},
        	new String[] {
        		"Logradouro", "Nº", "Cidade", "CEP", "País"
        	}
        ));
        table2LC.getColumnModel().getColumn(0).setPreferredWidth(200);
        table2LC.getColumnModel().getColumn(1).setPreferredWidth(40);
        table2LC.getColumnModel().getColumn(2).setPreferredWidth(120);
        table2LC.getColumnModel().getColumn(3).setPreferredWidth(80);
        table2LC.getColumnModel().getColumn(4).setPreferredWidth(110);
        JTableHeader header2LC=table2LC.getTableHeader();
        header2LC.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header2LC.setForeground(Color.WHITE);
        header2LC.setBackground(new Color(241, 180, 181));
        table2LC.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        
        JScrollPane scrollPane2LC = new JScrollPane();
        scrollPane2LC.getViewport().setOpaque(false);
        scrollPane2LC.setOpaque(false);
        scrollPane2LC.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane2LC.setBounds(25, 345, 746, 71);
        scrollPane2LC.setViewportView(table2LC);
        ListaCliente.add(scrollPane2LC);
        
        JButton btnListarC = new JButton("Listar");
        btnListarC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFLC.getText();
        		if(cpf.matches("\\d+") && cpf.length()==11) {
            		ClienteDAO cDAO = new ClienteDAO();
            		Cliente cb = cDAO.buscaCPF(cpf);
            		if(cb!=null) {
            			DefaultTableModel model1LC=(DefaultTableModel) table1LC.getModel();
                        model1LC.setRowCount(0);
                        DefaultTableModel model2LC=(DefaultTableModel) table2LC.getModel();
                        model2LC.setRowCount(0);
                        model1LC.addRow(new Object[]{cb.getNome(), cb.getCPF(), cb.toStringData_nasc(), cb.toStringData_cadastro()});
                        model2LC.addRow(new Object[]{cb.getLogradouro(), cb.getNumero(), cb.getCidade(), cb.getCEP(), cb.getPais()});
            		}else {
            			DefaultTableModel model1LC=(DefaultTableModel) table1LC.getModel();
                        model1LC.setRowCount(0);
                        DefaultTableModel model2LC=(DefaultTableModel) table2LC.getModel();
                        model2LC.setRowCount(0);
    					txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não existe nenhum cliente cadastrado com esse CPF!" + "\n");
            			telaErro="ListaCliente";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			DefaultTableModel model1LC=(DefaultTableModel) table1LC.getModel();
                    model1LC.setRowCount(0);
                    DefaultTableModel model2LC=(DefaultTableModel) table2LC.getModel();
                    model2LC.setRowCount(0);
					txtAreaMsgErro.setText("");
        	        txtAreaMsgErro.append("CPF invalido!" + "\n");
        			telaErro="ListaCliente";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnListarC.setForeground(new Color(115, 38, 52));
        btnListarC.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarC.setBackground(new Color(217, 180, 190));
        btnListarC.setBounds(310, 489, 147, 41);
        ListaCliente.add(btnListarC);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_1.setBounds(0, 0, 798, 600);
        ListaCliente.add(lblNewLabel_1);
        
        //ListaTodosCliente
        
        ListaTodosCliente = new JPanel();
        ListaTodosCliente.setBackground(new Color(255, 221, 222));
        contentPane.add(ListaTodosCliente, "ListaTodosCliente");
        ListaTodosCliente.setLayout(null);

        JLabel lblListaTodosCliente = new JLabel("Lista todos os clientes");
        lblListaTodosCliente.setForeground(Color.WHITE);
        lblListaTodosCliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListaTodosCliente.setBounds(226, 64, 368, 38);
        ListaTodosCliente.add(lblListaTodosCliente);

        JButton btnVoltarLTC = new JButton("");
        btnVoltarLTC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLTC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu");
            }
        });
        btnVoltarLTC.setForeground(new Color(145, 6, 79));
        btnVoltarLTC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLTC.setBackground(new Color(241, 180, 181));
        btnVoltarLTC.setBounds(10, 11, 69, 30);
        
        ListaTodosCliente.add(btnVoltarLTC);
        tableLTC = new JTable();
        DefaultTableModel tableModelLTC = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome", "CPF", "D. Nascimento", "D. Cadastro", "Logradouro", "Nº", "Cidade", "CEP", "País"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableLTC.setModel(tableModelLTC);

        JTableHeader headerLTC = tableLTC.getTableHeader();
        headerLTC.setFont(new Font("Century Gothic", Font.BOLD, 18));
        headerLTC.setForeground(Color.WHITE);
        headerLTC.setBackground(new Color(241, 180, 181));
        tableLTC.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        JScrollPane scrollPaneLTC = new JScrollPane(tableLTC);
        scrollPaneLTC.setBounds(28, 209, 746, 313);
        scrollPaneLTC.setOpaque(false);
        scrollPaneLTC.getViewport().setOpaque(false);
        scrollPaneLTC.setBorder(new EmptyBorder(0, 0, 0, 0));
        ListaTodosCliente.add(scrollPaneLTC);

        JButton btnListarTC = new JButton("Listar");
        btnListarTC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteDAO cDAO = new ClienteDAO();
                ArrayList<Cliente> listaTodosC = cDAO.listarTodos();
                tableModelLTC.setRowCount(0);
                for (Cliente c : listaTodosC) {
                    tableModelLTC.addRow(new Object[]{c.getNome(), c.getCPF(), c.toStringData_nasc(), c.toStringData_cadastro(), c.getLogradouro(), c.getNumero(), c.getCidade(), c.getCEP(), c.getPais()});
                }
            }
        });
        btnListarTC.setForeground(new Color(115, 38, 52));
        btnListarTC.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarTC.setBackground(new Color(217, 180, 190));
        btnListarTC.setBounds(327, 548, 147, 41);
        ListaTodosCliente.add(btnListarTC);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_2.setBounds(0, 0, 798, 600);
        ListaTodosCliente.add(lblNewLabel_2);

        //EditaCliente
        
        EditaCliente = new JPanel();
        EditaCliente.setBackground(new Color(255, 221, 222));
        contentPane.add(EditaCliente, "EditaCliente");
        EditaCliente.setLayout(null);
        
        JLabel lblECliente = new JLabel("Editar Cliente");
        lblECliente.setForeground(Color.WHITE);
        lblECliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblECliente.setBounds(293, 61, 232, 50);
        EditaCliente.add(lblECliente);
        
        JButton btnVoltarEC = new JButton("");
        btnVoltarEC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarEC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarEC.setForeground(new Color(145, 6, 79));
        btnVoltarEC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarEC.setBackground(new Color(241, 180, 181));
        btnVoltarEC.setBounds(10, 11, 69, 30);
        EditaCliente.add(btnVoltarEC);
        
        JLabel lblNomeEC = new JLabel("Nome:");
        lblNomeEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNomeEC.setBounds(61, 161, 90, 50);
        EditaCliente.add(lblNomeEC);
        
        textFieldNomeEC = new JTextField();
        textFieldNomeEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNomeEC.setColumns(10);
        textFieldNomeEC.setBounds(153, 166, 412, 30);
        EditaCliente.add(textFieldNomeEC);
        
        textFieldNomeEC.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldNomeEC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataNascEC = new JLabel("Data de nascimento:");
        lblDataNascEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataNascEC.setBounds(61, 212, 275, 50);
        EditaCliente.add(lblDataNascEC);
        
        dateChooserDataNascEC = new JDateChooser();
        dateChooserDataNascEC.setBounds(330, 215, 211, 35);
        EditaCliente.add(dateChooserDataNascEC);
        
        JLabel lblLogradouroEC = new JLabel("Logradouro:");
        lblLogradouroEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblLogradouroEC.setBounds(61, 305, 275, 50);
        EditaCliente.add(lblLogradouroEC);
        
        textFieldLogradouroEC = new JTextField();
        textFieldLogradouroEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldLogradouroEC.setColumns(10);
        textFieldLogradouroEC.setBounds(228, 310, 299, 30);
        EditaCliente.add(textFieldLogradouroEC);
        
        textFieldLogradouroEC.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldLogradouroEC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumEC = new JLabel("Nº:");
        lblNumEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumEC.setBounds(546, 305, 50, 50);
        EditaCliente.add(lblNumEC);
        
        textFieldNumEC = new JTextField();
        textFieldNumEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNumEC.setColumns(10);
        textFieldNumEC.setBounds(595, 310, 114, 30);
        EditaCliente.add(textFieldNumEC);
        
        textFieldNumEC.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCidadeEC = new JLabel("Cidade:");
        lblCidadeEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCidadeEC.setBounds(61, 401, 124, 50);
        EditaCliente.add(lblCidadeEC);
        
        textFieldCidadeEC = new JTextField();
        textFieldCidadeEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCidadeEC.setColumns(10);
        textFieldCidadeEC.setBounds(168, 406, 275, 30);
        EditaCliente.add(textFieldCidadeEC);
        
        textFieldCidadeEC.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCidadeEC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCEPEC = new JLabel("CEP:");
        lblCEPEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCEPEC.setBounds(433, 357, 90, 50);
        EditaCliente.add(lblCEPEC);
        
        textFieldCEPEC = new JTextField();
        textFieldCEPEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCEPEC.setColumns(10);
        textFieldCEPEC.setBounds(506, 360, 177, 30);
        EditaCliente.add(textFieldCEPEC);
        
        textFieldCEPEC.addKeyListener(new KeyListener() {
            final int maxCharacters=8;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCEPEC.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblPaisEC = new JLabel("País:");
        lblPaisEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblPaisEC.setBounds(61, 355, 90, 50);
        EditaCliente.add(lblPaisEC);
        
        textFieldPaisEC = new JTextField();
        textFieldPaisEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldPaisEC.setColumns(10);
        textFieldPaisEC.setBounds(132, 360, 275, 30);
        EditaCliente.add(textFieldPaisEC);
        
        textFieldPaisEC.addKeyListener(new KeyListener() {
            final int maxCharacters=40;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldPaisEC.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        textFieldCPFEC = new JTextField();
        EditaCliente.add(textFieldCPFEC);
        textFieldCPFEC.setVisible(false);
        
        JButton btnEditarCliente = new JButton("Editar");
        btnEditarCliente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFEC.getText();
    			String nome = textFieldNomeEC.getText();
    			dataNascEC=dateChooserDataNascEC.getDate();
        		String logradouro = textFieldLogradouroEC.getText();
        	    String numero = textFieldNumEC.getText();
        	    String CEP = textFieldCEPEC.getText();
        	    String cidade = textFieldCidadeEC.getText();
        	    String pais = textFieldPaisEC.getText();
        	    ArrayList<String>  val=valParametrosCliente(cpf, nome, dataNascEC, logradouro, numero, CEP, cidade, pais);
        	    if(val.isEmpty()) {
        	    	Cliente c = new Cliente(cpf, nome, dataNascEC, logradouro, numero, CEP, cidade, pais, dataCadastroEC);
            	    PessoaDAO pDAO = new PessoaDAO();
            	    int editouPessoa = pDAO.editarC(c);          	                
                	if(editouPessoa>0){
    	            	txtAreaMsgSucesso.setText("");
            	        txtAreaMsgSucesso.append("Informações atualizadas com sucesso!" + "\n");
                		cardLayout.show(contentPane, "MensagemSucesso");
               	    }else {
               	    	txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não editou, houve algum erro!" + "\n");
            			telaErro="EditaCliente";
                		cardLayout.show(contentPane, "MensagemErro");
               	    }
        	    }else {
        	    	txtAreaMsgErro.setText("");
        			for(String msg:val) {
        	            txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="EditaCliente";
            		cardLayout.show(contentPane, "MensagemErro");
        	    }
        	}
        });
        btnEditarCliente.setForeground(new Color(115, 38, 52));
        btnEditarCliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnEditarCliente.setBackground(new Color(217, 180, 190));
        btnEditarCliente.setBounds(631, 477, 157, 50);
        EditaCliente.add(btnEditarCliente);
        
        //BuscaEditaCliente
        
        BuscaEditaCliente = new JPanel();
        BuscaEditaCliente.setBackground(new Color(255, 221, 222));
        contentPane.add(BuscaEditaCliente, "BuscaEditaCliente");
        BuscaEditaCliente.setLayout(null);
        
        JLabel lblBECliente = new JLabel("Editar Cliente");
        lblBECliente.setForeground(new Color(255, 255, 255));
        lblBECliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblBECliente.setBounds(297, 61, 235, 50);
        BuscaEditaCliente.add(lblBECliente);
        
        JButton btnVoltarBEC = new JButton("");
        btnVoltarBEC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarBEC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarBEC.setBackground(new Color(241, 180, 181));
        btnVoltarBEC.setForeground(new Color(145, 6, 79));
        btnVoltarBEC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarBEC.setBounds(10, 11, 69, 30);
        BuscaEditaCliente.add(btnVoltarBEC);
        
        textFieldCPFBEC = new JTextField();
        textFieldCPFBEC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCPFBEC.setColumns(10);
        textFieldCPFBEC.setBounds(356, 307, 235, 30);
        BuscaEditaCliente.add(textFieldCPFBEC);
        
        textFieldCPFBEC.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFBEC.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCPFBEC = new JLabel("CPF do Cliente:");
        lblCPFBEC.setLabelFor(textFieldCPFBEC);
        lblCPFBEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFBEC.setBounds(148, 311, 207, 32);
        BuscaEditaCliente.add(lblCPFBEC);
        
        JButton btnBuscarEC = new JButton("Buscar");
        btnBuscarEC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFBEC.getText();
        		if(cpf.matches("\\d+") && cpf.length()==11) {
        			ClienteDAO cDAO = new ClienteDAO();
        			Cliente cb=cDAO.buscaCPF(cpf);
        			if(cb!=null) {
        				textFieldNomeEC.setText(cb.getNome());
        				dateChooserDataNascEC.setDate(cb.getData_nasc());
        				dataNascEC=cb.getData_nasc();
        				textFieldLogradouroEC.setText(cb.getLogradouro());
        				textFieldNumEC.setText(cb.getNumero());
        				textFieldCidadeEC.setText(cb.getCidade());
        				textFieldCEPEC.setText(cb.getCEP());
        				textFieldPaisEC.setText(cb.getPais());
        				textFieldCPFEC.setText(cb.getCPF());
        				dataCadastroEC=cb.getData_nasc();
        				cardLayout.show(contentPane, "EditaCliente");
        			}else {
            			txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não existe nenhum cliente cadastrado com esse CPF!" + "\n");
            			telaErro="BuscaEditaCliente";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
        		}else {
        			txtAreaMsgErro.setText("");
        	        txtAreaMsgErro.append("CPF inválido!" + "\n");
        			telaErro="BuscaEditaCliente";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnBuscarEC.setForeground(new Color(115, 38, 52));
        btnBuscarEC.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarEC.setBackground(new Color(217, 180, 190));
        btnBuscarEC.setBounds(319, 483, 147, 41);
        BuscaEditaCliente.add(btnBuscarEC);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_4.setBounds(0, 0, 798, 600);
        BuscaEditaCliente.add(lblNewLabel_4);
        
        //DeletaCliiente
        
        DeletaCliente = new JPanel();
        DeletaCliente.setBackground(new Color(255, 221, 222));
        contentPane.add(DeletaCliente, "DeletaCliente");
        DeletaCliente.setLayout(null);
        
        JLabel lblDCliente = new JLabel("Deletar Cliente");
        lblDCliente.setForeground(new Color(255, 255, 255));
        lblDCliente.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblDCliente.setBounds(289, 63, 253, 50);
        DeletaCliente.add(lblDCliente);
        
        JButton btnVoltarDC = new JButton("");
        btnVoltarDC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarDC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarDC.setBackground(new Color(241, 180, 181));
        btnVoltarDC.setForeground(new Color(145, 6, 79));
        btnVoltarDC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarDC.setBounds(10, 11, 69, 30);
        DeletaCliente.add(btnVoltarDC);
        
        JLabel lblCPFDC = new JLabel("CPF do Cliente:");
        lblCPFDC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFDC.setBounds(195, 293, 207, 32);
        DeletaCliente.add(lblCPFDC);

        textFieldCPFDC = new JTextField();
        lblCPFDC.setLabelFor(textFieldCPFDC);
        textFieldCPFDC.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCPFDC.setColumns(10);
        textFieldCPFDC.setBounds(397, 289, 235, 30);
        DeletaCliente.add(textFieldCPFDC);
        
        textFieldCPFDC.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFDC.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnDeletarC = new JButton("Deletar");
        btnDeletarC.setBackground(new Color(217, 180, 190));
        btnDeletarC.setForeground(new Color(115, 38, 52));
        btnDeletarC.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnDeletarC.setBounds(314, 480, 170, 41);
        btnDeletarC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String cpf = textFieldCPFDC.getText();
        		
        		if(cpf.matches("\\d+") && cpf.length()==11) {
        			ClienteDAO cDAO = new ClienteDAO();
    				Cliente c = cDAO.buscaCPF(cpf);
    				
    				if(c!=null) {
    					int removeuCliente = cDAO.remover(c);
    					
    					PessoaDAO pDAO = new PessoaDAO();
    					int removeuPessoa = pDAO.removerC(c);
    					
    					if(removeuPessoa == 1 && removeuCliente == 1) {
        	            	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Cadastro deletado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
    					}else {
                			txtAreaMsgErro.setText("");
                	        txtAreaMsgErro.append("Não foi possível deletar o cadastro deste cliente!" + "\n");
                			telaErro="DeletaCliente";
                    		cardLayout.show(contentPane, "MensagemErro");
    					}
    					
    				}else {
            			txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não existe nenhum cliente com esse cpf!" + "\n");
            			telaErro="DeletaCliente";
                		cardLayout.show(contentPane, "MensagemErro");
    				}
        		}else {
        			txtAreaMsgErro.setText("");
        	        txtAreaMsgErro.append("CPF inválido!" + "\n");
        			telaErro="DeletaCliente";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        DeletaCliente.add(btnDeletarC);
        
        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_5.setBounds(0, 0, 798, 600);
        DeletaCliente.add(lblNewLabel_5);
        
        //      <<<<<<<<<<<<<FUNCIONARIO>>>>>>>>>>>>>
        
        //Cadastro Funcionário
        
        CadastroFuncionario= new JPanel();
        CadastroFuncionario.setBackground(new Color(255, 221, 222));
        contentPane.add(CadastroFuncionario, "CadastroFuncionario");
        CadastroFuncionario.setLayout(null);
        
        JLabel lblCadastrarFuncionario = new JLabel("Cadastrar Funcionário");
        lblCadastrarFuncionario.setForeground(Color.WHITE);
        lblCadastrarFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblCadastrarFuncionario.setBounds(224, 60, 373, 50);
        CadastroFuncionario.add(lblCadastrarFuncionario);
        
        JButton btnVoltarCF = new JButton("");
        btnVoltarCF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCF.setForeground(new Color(145, 6, 79));
        btnVoltarCF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCF.setBackground(new Color(241, 180, 181));
        btnVoltarCF.setBounds(10, 11, 69, 30);
        CadastroFuncionario.add(btnVoltarCF);
        
        JLabel lblNomeCF = new JLabel("Nome:");
        lblNomeCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNomeCF.setBounds(58, 167, 90, 50);
        CadastroFuncionario.add(lblNomeCF);
        
        textFieldNomeCF = new JTextField();
        lblNomeCF.setLabelFor(textFieldNomeCF);
        textFieldNomeCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNomeCF.setColumns(10);
        textFieldNomeCF.setBounds(152, 172, 412, 30);
        CadastroFuncionario.add(textFieldNomeCF);
        
        textFieldNomeCF.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldNomeCF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCPFCF = new JLabel("CPF:");
        lblCPFCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFCF.setBounds(58, 214, 90, 50);
        CadastroFuncionario.add(lblCPFCF);
        
        textFieldCPFCF = new JTextField();
        lblCPFCF.setLabelFor(textFieldCPFCF);
        textFieldCPFCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCPFCF.setColumns(10);
        textFieldCPFCF.setBounds(128, 219, 235, 30);
        CadastroFuncionario.add(textFieldCPFCF);
        
        textFieldCPFCF.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFCF.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataNascCF = new JLabel("Data de nascimento:");
        lblDataNascCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataNascCF.setBounds(58, 257, 260, 50);
        CadastroFuncionario.add(lblDataNascCF);
        
        dateChooserDataNascCF = new JDateChooser();
        dateChooserDataNascCF.setBounds(328, 260, 211, 35);
        CadastroFuncionario.add(dateChooserDataNascCF);
        
        JLabel lblSalarioCF = new JLabel("Salário:");
        lblSalarioCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblSalarioCF.setBounds(391, 214, 104, 50);
        CadastroFuncionario.add(lblSalarioCF);
        
        textFieldSalarioCF = new JTextField();
        textFieldSalarioCF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldSalarioCF.setColumns(10);
        textFieldSalarioCF.setBounds(505, 219, 140, 30);
        CadastroFuncionario.add(textFieldSalarioCF);
        
        JLabel lblLogradouroCF = new JLabel("Logradouro:");
        lblLogradouroCF.setLabelFor(textFieldLogradouroCF);
        lblLogradouroCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblLogradouroCF.setBounds(58, 348, 275, 50);
        CadastroFuncionario.add(lblLogradouroCF);
        
        textFieldLogradouroCF = new JTextField();
        textFieldLogradouroCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldLogradouroCF.setColumns(10);
        textFieldLogradouroCF.setBounds(224, 353, 299, 30);
        CadastroFuncionario.add(textFieldLogradouroCF);

        textFieldLogradouroCF.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldLogradouroCF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumCF = new JLabel("Nº:");
        lblNumCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumCF.setBounds(533, 348, 50, 50);
        CadastroFuncionario.add(lblNumCF);
        
        textFieldNumCF = new JTextField();
        lblNumCF.setLabelFor(textFieldNumCF);
        textFieldNumCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNumCF.setColumns(10);
        textFieldNumCF.setBounds(585, 353, 114, 30);
        CadastroFuncionario.add(textFieldNumCF);
        
        textFieldNumCF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCidadeCF = new JLabel("Cidade:");
        lblCidadeCF.setLabelFor(textFieldCidadeCF);
        lblCidadeCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCidadeCF.setBounds(55, 395, 124, 50);
        CadastroFuncionario.add(lblCidadeCF);
        
        textFieldCidadeCF = new JTextField();
        textFieldCidadeCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCidadeCF.setColumns(10);
        textFieldCidadeCF.setBounds(165, 400, 275, 30);
        CadastroFuncionario.add(textFieldCidadeCF);
        
        textFieldCidadeCF.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCidadeCF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCEPCF = new JLabel("CEP:");
        lblCEPCF.setLabelFor(textFieldCEPCF);
        lblCEPCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCEPCF.setBounds(463, 394, 90, 50);
        CadastroFuncionario.add(lblCEPCF);
        
        textFieldCEPCF = new JTextField();
        textFieldCEPCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldCEPCF.setColumns(10);
        textFieldCEPCF.setBounds(533, 400, 177, 30);
        CadastroFuncionario.add(textFieldCEPCF);

        textFieldCEPCF.addKeyListener(new KeyListener() {
            final int maxCharacters=8;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCEPCF.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblPaisCF = new JLabel("País:");
        lblPaisCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblPaisCF.setBounds(58, 436, 90, 50);
        CadastroFuncionario.add(lblPaisCF);
        
        textFieldPaisCF = new JTextField();
        lblPaisCF.setLabelFor(textFieldPaisCF);
        textFieldPaisCF.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldPaisCF.setColumns(10);
        textFieldPaisCF.setBounds(128, 441, 275, 30);
        CadastroFuncionario.add(textFieldPaisCF);
        
        textFieldPaisCF.addKeyListener(new KeyListener() {
            final int maxCharacters=40;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldPaisCF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnCadastrarFuncionario = new JButton("Cadastrar");
        btnCadastrarFuncionario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFCF.getText();
        		String nome = textFieldNomeCF.getText();
        		dataNascCF = dateChooserDataNascCF.getDate();
        		String salario = textFieldSalarioCF.getText();
				String logradouro = textFieldLogradouroCF.getText();
                String numero = textFieldNumCF.getText();
                String CEP = textFieldCEPCF.getText();
                String cidade = textFieldCidadeCF.getText();
                String pais = textFieldPaisCF.getText();
        		ArrayList<String> val=valParametrosFuncionario(cpf, nome, dataNascCF, logradouro, numero, CEP, cidade, pais, salario);
        		if(val.isEmpty()) {
        			FuncionarioDAO fDAO = new FuncionarioDAO();
    				Funcionario fb = fDAO.buscaCPF(cpf);
    				if(fb == null) {
    					Funcionario f = new Funcionario(cpf, nome, dataNascCF, logradouro, numero, CEP, cidade, pais, salario, new Date());
    	                PessoaDAO pDAO = new PessoaDAO();
    	                int inseriuPessoa = pDAO.inserirF(f);    	                
    	                int inseriuFuncionario = fDAO.inserir(f);    	                
    	                if(inseriuPessoa == 1 && inseriuFuncionario == 1){
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Funcionário cadastrado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
    	                }else {
        	            	txtAreaMsgErro.setText("");
                	        txtAreaMsgErro.append("Não inseriu, houve algum erro!" + "\n");
                			telaErro="CadastroFuncionario";
                    		cardLayout.show(contentPane, "MensagemErro");
        	            }
    				}else {
    					txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Já existe um funcionário cadastrado com esse CPF!" + "\n");
            			telaErro="CadastroFuncionario";
                		cardLayout.show(contentPane, "MensagemErro");
    				}
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
        	            txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="CadastroFuncionario";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        
        btnCadastrarFuncionario.setForeground(new Color(115, 38, 52));
        btnCadastrarFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnCadastrarFuncionario.setBackground(new Color(217, 180, 190));
        btnCadastrarFuncionario.setBounds(591, 476, 197, 50);
        CadastroFuncionario.add(btnCadastrarFuncionario);
        
        JLabel lblEnderecoCF = new JLabel("Endereço:");
        lblEnderecoCF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblEnderecoCF.setBounds(57, 303, 177, 50);
        CadastroFuncionario.add(lblEnderecoCF);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_6.setBounds(0, 0, 798, 600);
        CadastroFuncionario.add(lblNewLabel_6);
        
        // Lista Funcionário
        
        ListaFuncionario = new JPanel();
        ListaFuncionario.setBackground(new Color(255, 221, 222));
        contentPane.add(ListaFuncionario, "ListaFuncionario");
        ListaFuncionario.setLayout(null);
        
        JLabel lblListarFuncionario = new JLabel("Listar Funcionário");
        lblListarFuncionario.setForeground(Color.WHITE);
        lblListarFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarFuncionario.setBounds(250, 60, 311, 50);
        ListaFuncionario.add(lblListarFuncionario);
        
        JButton btnVoltarLF = new JButton("");
        btnVoltarLF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLF.setForeground(new Color(145, 6, 79));
        btnVoltarLF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLF.setBackground(new Color(241, 180, 181));
        btnVoltarLF.setBounds(10, 11, 69, 30);
        ListaFuncionario.add(btnVoltarLF);
        
        JLabel lblCPFLF = new JLabel("CPF do Funcionário:");
        lblCPFLF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFLF.setBounds(134, 219, 287, 32);
        ListaFuncionario.add(lblCPFLF);
        
        textFieldCPFLF = new JTextField();
        textFieldCPFLF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFLF.setColumns(10);
        textFieldCPFLF.setBounds(410, 215, 235, 30);
        ListaFuncionario.add(textFieldCPFLF);
        
        textFieldCPFLF.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFLF.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        table1LF=new JTable();
        table1LF.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        table1LF.setModel(new DefaultTableModel(
        	new Object[][] {
        		{" ", "  ", " ", " ", " "},
        	},
        	new String[] {
        		"Nome", "CPF", "Data de nascimento", "Data de admissão", "Salário"
        	}
        ));
        table1LF.getColumnModel().getColumn(0).setPreferredWidth(130);
        table1LF.getColumnModel().getColumn(1).setPreferredWidth(70);
        table1LF.getColumnModel().getColumn(2).setPreferredWidth(160);
        table1LF.getColumnModel().getColumn(3).setPreferredWidth(140);
        table1LF.getColumnModel().getColumn(4).setPreferredWidth(30);
        JTableHeader header1LF=table1LF.getTableHeader();
        header1LF.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header1LF.setForeground(Color.WHITE);
        header1LF.setBackground(new Color(241, 180, 181));
        table1LF.setFont(new Font("Century Gothic", Font.PLAIN, 17));
       
        JScrollPane scrollPane1LF = new JScrollPane();
        scrollPane1LF.getViewport().setOpaque(false);
        scrollPane1LF.setOpaque(false);
        scrollPane1LF.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane1LF.setBounds(25, 299, 746, 71);
        scrollPane1LF.setViewportView(table1LF);
        ListaFuncionario.add(scrollPane1LF);
        
        table2LF=new JTable();
        table2LF.setModel(new DefaultTableModel(
        	new Object[][] {
          		{" ", "  ", " ", " "},
           	},
        	new String[] {
        		"Logradouro", "Nº", "Cidade", "CEP", "País"
        	}
        ));
        table2LF.getColumnModel().getColumn(0).setPreferredWidth(200);
        table2LF.getColumnModel().getColumn(1).setPreferredWidth(40);
        table2LF.getColumnModel().getColumn(2).setPreferredWidth(120);
        table2LF.getColumnModel().getColumn(3).setPreferredWidth(80);
        table2LF.getColumnModel().getColumn(4).setPreferredWidth(110);
        JTableHeader header2LF=table2LF.getTableHeader();
        header2LF.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header2LF.setForeground(Color.WHITE);
        header2LF.setBackground(new Color(241, 180, 181));
        table2LF.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        
        JScrollPane scrollPane2LF = new JScrollPane();
        scrollPane2LF.getViewport().setOpaque(false);
        scrollPane2LF.setOpaque(false);
        scrollPane2LF.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane2LF.setBounds(25, 395, 746, 71);
        scrollPane2LF.setViewportView(table2LF);
        ListaFuncionario.add(scrollPane2LF);
        
        JButton btnListarF = new JButton("Listar");
        btnListarF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFLF.getText();
        		if(cpf.matches("\\d+") && cpf.length()==11) {
            		FuncionarioDAO fDAO = new FuncionarioDAO();
            		Funcionario fb = fDAO.buscaCPF(cpf);
            		if(fb!=null) {
            			DefaultTableModel model1LF=(DefaultTableModel) table1LF.getModel();
            			model1LF.setRowCount(0);
                        DefaultTableModel model2LF=(DefaultTableModel) table2LF.getModel();
                        model2LF.setRowCount(0);
                        model1LF.addRow(new Object[]{fb.getNome(), fb.getCPF(), fb.toStringData_nasc(), fb.toStringData_admissao(), fb.getSalario()});
                        model2LF.addRow(new Object[]{fb.getLogradouro(), fb.getNumero(), fb.getCidade(), fb.getCEP(), fb.getPais()});
            		}else {
            			DefaultTableModel model1LF=(DefaultTableModel) table1LF.getModel();
            			model1LF.setRowCount(0);
                        DefaultTableModel model2LF=(DefaultTableModel) table2LF.getModel();
                        model2LF.setRowCount(0);
    					txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não existe nenhum cliente cadastrado com esse CPF!" + "\n");
            			telaErro="ListaFuncionario";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			DefaultTableModel model1LF=(DefaultTableModel) table1LF.getModel();
        			model1LF.setRowCount(0);
                    DefaultTableModel model2LF=(DefaultTableModel) table2LF.getModel();
                    model2LF.setRowCount(0);
					txtAreaMsgErro.setText("");
        	        txtAreaMsgErro.append("CPF inválido!" + "\n");
        			telaErro="ListaFuncionario";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnListarF.setForeground(new Color(115, 38, 52));
        btnListarF.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarF.setBackground(new Color(217, 180, 190));
        btnListarF.setBounds(333, 487, 147, 41);
        ListaFuncionario.add(btnListarF);
        
        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_7.setBounds(0, 0, 798, 600);
        ListaFuncionario.add(lblNewLabel_7);
        
        //ListaTodosFuncionario
        
        ListaTodosFuncionario = new JPanel();
        ListaTodosFuncionario.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaTodosFuncionario, "ListaTodosFuncionario");
        ListaTodosFuncionario.setLayout(null);

        JLabel lblListaTodosFuncionario = new JLabel("Lista todos os Funcionários");
        lblListaTodosFuncionario.setForeground(Color.WHITE);
        lblListaTodosFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListaTodosFuncionario.setBounds(187, 64, 447, 38);
        ListaTodosFuncionario.add(lblListaTodosFuncionario);

        JButton btnVoltarLTF = new JButton("");
        btnVoltarLTF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu");
            }
        });
        btnVoltarLTF.setForeground(new Color(124, 3, 54));
        btnVoltarLTF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLTF.setBackground(new Color(235, 180, 181));
        btnVoltarLTF.setBounds(10, 5, 69, 30);
        ListaTodosFuncionario.add(btnVoltarLTF);
        
        tableLTF = new JTable();
        DefaultTableModel tableModelLTF = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome", "CPF", "D. Nascimento", "D. Admissao", "Salário", "Logradouro", "Nº", "Cidade", "CEP", "País"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableLTF.setModel(tableModelLTF);

        JTableHeader headerLTF = tableLTF.getTableHeader();
        headerLTF.setFont(new Font("Century Gothic", Font.BOLD, 18));
        headerLTF.setForeground(Color.WHITE);
        headerLTF.setBackground(new Color(241, 180, 181));
        tableLTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        JScrollPane scrollPaneLTF = new JScrollPane(tableLTF);
        scrollPaneLTF.setBounds(28, 209, 746, 313);
        scrollPaneLTF.setOpaque(false);
        scrollPaneLTF.getViewport().setOpaque(false);
        scrollPaneLTF.setBorder(new EmptyBorder(0, 0, 0, 0));
        ListaTodosFuncionario.add(scrollPaneLTF);

        JButton btnListarTF = new JButton("Listar");
        btnListarTF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FuncionarioDAO fDAO = new FuncionarioDAO();
                ArrayList<Funcionario> listaTodosF = fDAO.listarTodos();
                tableModelLTF.setRowCount(0);
                for (Funcionario f : listaTodosF) {
                    tableModelLTF.addRow(new Object[]{f.getNome(), f.getCPF(), f.toStringData_nasc(), f.toStringData_admissao(), f.getSalario(), f.getLogradouro(), f.getNumero(), f.getCidade(), f.getCEP(), f.getPais()});
                }
            }
        });
        btnListarTF.setForeground(new Color(115, 38, 52));
        btnListarTF.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarTF.setBackground(new Color(217, 180, 190));
        btnListarTF.setBounds(326, 548, 147, 41);
        ListaTodosFuncionario.add(btnListarTF);
        
        JLabel lblNewLabel_8 = new JLabel("New label");
        lblNewLabel_8.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_8.setBounds(0, 0, 798, 600);
        ListaTodosFuncionario.add(lblNewLabel_8);
        
        // Edita Funcionario
        
        EditaFuncionario = new JPanel();
        EditaFuncionario.setForeground(new Color(255, 255, 255));
        EditaFuncionario.setBackground(new Color(255, 217, 220));
        contentPane.add(EditaFuncionario, "EditaFuncionario");
        EditaFuncionario.setLayout(null);
        
        JLabel lblEditarFuncionario = new JLabel("Editar Funcionário");
        lblEditarFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblEditarFuncionario.setForeground(new Color(255, 255, 255));
        lblEditarFuncionario.setBounds(253, 60, 344, 43);
        EditaFuncionario.add(lblEditarFuncionario);
        
        JButton btnVoltarEF = new JButton("");
        btnVoltarEF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarEF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarEF.setForeground(new Color(124, 3, 54));
        btnVoltarEF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarEF.setBackground(new Color(235, 180, 181));
        btnVoltarEF.setBounds(10, 11, 69, 30);
        EditaFuncionario.add(btnVoltarEF);
        
        JLabel lblNomeEF = new JLabel("Nome:");
        lblNomeEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNomeEF.setBounds(65, 186, 90, 50);
        EditaFuncionario.add(lblNomeEF);
        
        textFieldNomeEF = new JTextField();
        textFieldNomeEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldNomeEF.setColumns(10);
        textFieldNomeEF.setBounds(156, 191, 412, 30);
        EditaFuncionario.add(textFieldNomeEF);
        
        textFieldNomeEF.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldNomeEF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataNascEF = new JLabel("Data de nascimento:");
        lblDataNascEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataNascEF.setBounds(65, 234, 275, 50);
        EditaFuncionario.add(lblDataNascEF);
        
        dateChooserDataNascEF = new JDateChooser();
        dateChooserDataNascEF.setBounds(330, 237, 211, 35);
        EditaFuncionario.add(dateChooserDataNascEF);
        
        JLabel lblSalarioEF = new JLabel("Salário:");
        lblSalarioEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblSalarioEF.setBounds(65, 281, 104, 50);
        EditaFuncionario.add(lblSalarioEF);
        
        textFieldSalarioEF = new JTextField();
        textFieldSalarioEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldSalarioEF.setColumns(10);
        textFieldSalarioEF.setBounds(175, 286, 224, 30);
        EditaFuncionario.add(textFieldSalarioEF);
        
        JLabel lblLogradouroEF = new JLabel("Logradouro:");
        lblLogradouroEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblLogradouroEF.setBounds(65, 374, 171, 50);
        EditaFuncionario.add(lblLogradouroEF);
        
        textFieldLogradouroEF = new JTextField();
        textFieldLogradouroEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldLogradouroEF.setColumns(10);
        textFieldLogradouroEF.setBounds(232, 379, 224, 30);
        EditaFuncionario.add(textFieldLogradouroEF);

        textFieldLogradouroEF.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldLogradouroEF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumEF = new JLabel("Nº:");
        lblNumEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumEF.setBounds(476, 374, 50, 50);
        EditaFuncionario.add(lblNumEF);
        
        textFieldNumEF = new JTextField();
        textFieldNumEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldNumEF.setColumns(10);
        textFieldNumEF.setBounds(534, 379, 192, 30);
        EditaFuncionario.add(textFieldNumEF);
        
        textFieldNumEF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCidadeEF = new JLabel("Cidade:");
        lblCidadeEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCidadeEF.setBounds(65, 419, 112, 50);
        EditaFuncionario.add(lblCidadeEF);
        
        textFieldCidadeEF = new JTextField();
        textFieldCidadeEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCidadeEF.setColumns(10);
        textFieldCidadeEF.setBounds(175, 424, 224, 30);
        EditaFuncionario.add(textFieldCidadeEF);
        
        textFieldCidadeEF.addKeyListener(new KeyListener() {
            final int maxCharacters=50;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCidadeEF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCEPEF = new JLabel("CEP:");
        lblCEPEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCEPEF.setBounds(425, 420, 75, 50);
        EditaFuncionario.add(lblCEPEF);
        
        textFieldCEPEF = new JTextField();
        textFieldCEPEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCEPEF.setColumns(10);
        textFieldCEPEF.setBounds(496, 424, 224, 30);
        EditaFuncionario.add(textFieldCEPEF);
        
        textFieldCEPEF.addKeyListener(new KeyListener() {
            final int maxCharacters=8;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCEPEF.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblPaisEF = new JLabel("País:");
        lblPaisEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblPaisEF.setBounds(65, 464, 90, 50);
        EditaFuncionario.add(lblPaisEF);
        
        textFieldPaisEF = new JTextField();
        textFieldPaisEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldPaisEF.setColumns(10);
        textFieldPaisEF.setBounds(135, 469, 224, 30);
        EditaFuncionario.add(textFieldPaisEF);
        
        textFieldPaisEF.addKeyListener(new KeyListener() {
            final int maxCharacters=40;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldPaisEF.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        textFieldCPFEF = new JTextField();
        EditaFuncionario.add(textFieldCPFEF);
        textFieldCPFEF.setVisible(false);
        
        JButton btnEditarFuncionario = new JButton("Editar");
        btnEditarFuncionario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFEF.getText();
    			String nome = textFieldNomeEF.getText();
        		dataNascEF = dateChooserDataNascEF.getDate();
                String salario = textFieldSalarioEF.getText();
    			String logradouro = textFieldLogradouroEF.getText();
    	        String numero = textFieldNumEF.getText();
    	        String CEP = textFieldCEPEF.getText();
    	        String cidade = textFieldCidadeEF.getText();
    	        String pais = textFieldPaisEF.getText();
        		ArrayList<String> val=valParametrosFuncionario(cpf, nome, dataNascEF, logradouro, numero, CEP, cidade, pais, salario);
        		if(val.isEmpty()) {
    	        	Funcionario f = new Funcionario(cpf, nome, dataNascEF, logradouro, numero, CEP, cidade, pais, salario, dataAdmissaoEF);
            	    PessoaDAO pDAO = new PessoaDAO();
            	    int editouPessoa = pDAO.editarF(f);
            	    FuncionarioDAO fDAO = new FuncionarioDAO();
            	    int editouFuncionario = fDAO.editar(f);
            	    if(editouPessoa > 0 && editouFuncionario > 0){
	                	txtAreaMsgSucesso.setText("");
            	        txtAreaMsgSucesso.append("Informações atualizadas com sucesso!" + "\n");
                		cardLayout.show(contentPane, "MensagemSucesso");
           	        }else {
               	    	txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não editou, houve algum erro!" + "\n");
            			telaErro="EditaFuncionario";
                		cardLayout.show(contentPane, "MensagemErro");
               	    }
        	    }else {
        	    	txtAreaMsgErro.setText("");
        			for(String msg:val) {
        	            txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="EditaFuncionario";
            		cardLayout.show(contentPane, "MensagemErro");
        	    }
        	}
        });
        
        btnEditarFuncionario.setForeground(new Color(115, 38, 52));
        btnEditarFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnEditarFuncionario.setBackground(new Color(217, 180, 190));
        btnEditarFuncionario.setBounds(591, 479, 197, 50);
        EditaFuncionario.add(btnEditarFuncionario);
        
        JLabel lblEnderecoEF = new JLabel("Endereço:");
        lblEnderecoEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblEnderecoEF.setBounds(65, 326, 171, 50);
        EditaFuncionario.add(lblEnderecoEF);
        
        JLabel lblNewLabel_9 = new JLabel("New label");
        lblNewLabel_9.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_9.setBounds(0, 0, 798, 600);
        EditaFuncionario.add(lblNewLabel_9);
        
        // Busca Edita Funcionario
        
        BuscaEditaFuncionario = new JPanel();
        BuscaEditaFuncionario.setBackground(new Color(255, 217, 220));
        contentPane.add(BuscaEditaFuncionario, "BuscaEditaFuncionario");
        BuscaEditaFuncionario.setLayout(null);
        
        JLabel lblBEFuncionario = new JLabel("Editar Funcionário");
        lblBEFuncionario.setForeground(Color.WHITE);
        lblBEFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblBEFuncionario.setBounds(255, 60, 322, 50);
        BuscaEditaFuncionario.add(lblBEFuncionario);
        JButton btnVoltarBEF = new JButton("");
        btnVoltarBEF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarBEF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarBEF.setForeground(new Color(124, 3, 54));
        btnVoltarBEF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarBEF.setBackground(new Color(235, 180, 181));
        btnVoltarBEF.setBounds(10, 11, 69, 30);
        BuscaEditaFuncionario.add(btnVoltarBEF);
        
        JLabel lblCPFBEF = new JLabel("CPF do Funcionário:");
        lblCPFBEF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFBEF.setBounds(147, 304, 267, 32);
        BuscaEditaFuncionario.add(lblCPFBEF);
        
        textFieldCPFBEF = new JTextField();
        textFieldCPFBEF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFBEF.setColumns(10);
        textFieldCPFBEF.setBounds(424, 300, 235, 30);
        BuscaEditaFuncionario.add(textFieldCPFBEF);
        
        textFieldCPFBEF.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFBEF.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnBuscarEF = new JButton("Buscar");
        btnBuscarEF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFBEF.getText();
        		if(cpf.matches("\\d+") && cpf.length() == 11) {
        			FuncionarioDAO fDAO = new FuncionarioDAO();
        			Funcionario fb = fDAO.buscaCPF(cpf);
        			if(fb != null) {
        				textFieldNomeEF.setText(fb.getNome());
        				dateChooserDataNascEF.setDate(fb.getData_nasc());
        				dataNascEF=fb.getData_nasc();
        				textFieldLogradouroEF.setText(fb.getLogradouro());
        				textFieldNumEF.setText(fb.getNumero());
        				textFieldCidadeEF.setText(fb.getCidade());
        				textFieldCEPEF.setText(fb.getCEP());
        				textFieldPaisEF.setText(fb.getPais());
        				textFieldCPFEF.setText(fb.getCPF());
        				textFieldSalarioEF.setText(fb.getSalario());
        				dataAdmissaoEF=fb.getData_admissao();
        				cardLayout.show(contentPane, "EditaFuncionario");
        			}else {
            	    	txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não existe nenhum funcionário cadastrado com esse CPF!" + "\n");
            			telaErro="BuscaEditaFuncionario";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
        		}else {
        			txtAreaMsgErro.setText("");
        	        txtAreaMsgErro.append("CPF inválido!" + "\n");
        			telaErro="BuscaEditaFuncionario";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        
        btnBuscarEF.setForeground(new Color(115, 38, 52));
        btnBuscarEF.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarEF.setBackground(new Color(217, 180, 190));
        btnBuscarEF.setBounds(327, 484, 147, 41);
        BuscaEditaFuncionario.add(btnBuscarEF);
        
        JLabel lblNewLabel_10 = new JLabel("New label");
        lblNewLabel_10.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_10.setBounds(0, 0, 798, 600);
        BuscaEditaFuncionario.add(lblNewLabel_10);
        
        // Deleta Funcionário 
        
        DeletaFuncionario = new JPanel();
        DeletaFuncionario.setBackground(new Color(255, 217, 220));
        contentPane.add(DeletaFuncionario, "DeletaFuncionario");
        DeletaFuncionario.setLayout(null);
        
        JLabel lblDFuncionario = new JLabel("Deletar Funcionário");
        lblDFuncionario.setForeground(Color.WHITE);
        lblDFuncionario.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblDFuncionario.setBounds(245, 57, 335, 50);
        DeletaFuncionario.add(lblDFuncionario);
        
        JButton btnVoltarDF = new JButton("");
        btnVoltarDF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarDF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarDF.setForeground(new Color(124, 3, 54));
        btnVoltarDF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarDF.setBackground(new Color(235, 180, 181));
        btnVoltarDF.setBounds(10, 11, 69, 30);
        DeletaFuncionario.add(btnVoltarDF);
        
        JLabel lblCPFDF = new JLabel("CPF do Funcionário:");
        lblCPFDF.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFDF.setBounds(144, 293, 289, 32);
        DeletaFuncionario.add(lblCPFDF);
        
        textFieldCPFDF = new JTextField();
        textFieldCPFDF.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFDF.setColumns(10);
        textFieldCPFDF.setBounds(413, 289, 235, 30);
        DeletaFuncionario.add(textFieldCPFDF);
        
        textFieldCPFDF.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFDF.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnDeletarF = new JButton("Deletar");
        btnDeletarF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf = textFieldCPFDF.getText();
        		if(cpf.matches("\\d+") && cpf.length() == 11) {
        			FuncionarioDAO fDAO = new FuncionarioDAO();
    				Funcionario f = fDAO.buscaCPF(cpf);
    				if(f != null) {
    					int removeuFuncionario = fDAO.remover(f);
    					PessoaDAO pDAO = new PessoaDAO();
    					int removeuPessoa = pDAO.removerF(f);
    					if(removeuPessoa == 1 && removeuFuncionario == 1) {
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Cadastro deletado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
        				}else {
    						txtAreaMsgErro.setText("");
                	        txtAreaMsgErro.append("Não foi possível deletar o cadastro deste funcionário!" + "\n");
                			telaErro="DeletaFuncionario";
                    		cardLayout.show(contentPane, "MensagemErro");
    					}
    				}else {
            			txtAreaMsgErro.setText("");
            	        txtAreaMsgErro.append("Não existe nenhum funcionário com esse cpf!" + "\n");
            			telaErro="DeletaFuncionario";
                		cardLayout.show(contentPane, "MensagemErro");
    				}
        		}else {
        			txtAreaMsgErro.setText("");
        	        txtAreaMsgErro.append("CPF inválido!" + "\n");
        			telaErro="DeletaFuncionario";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        
        btnDeletarF.setForeground(new Color(115, 38, 52));
        btnDeletarF.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnDeletarF.setBackground(new Color(217, 180, 190));
        btnDeletarF.setBounds(317, 484, 165, 41);
        DeletaFuncionario.add(btnDeletarF);
        
        JLabel lblNewLabel_11 = new JLabel("New label");
        lblNewLabel_11.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_11.setBounds(0, 0, 798, 600);
        DeletaFuncionario.add(lblNewLabel_11);
        
        //           <<<<<LIVRO>>>>>
        
        // Cadastro fisico
        
        CadastroFisico = new JPanel();
        CadastroFisico.setBackground(new Color(255, 217, 220));
        contentPane.add(CadastroFisico, "CadastroFisico");
        CadastroFisico.setLayout(null);
        
        JLabel lblCFisico = new JLabel("Cadastrar Livro Físico");
        lblCFisico.setBounds(226, 59, 369, 50);
        lblCFisico.setForeground(Color.WHITE);
        lblCFisico.setFont(new Font("Sitka Small", Font.BOLD, 30));
        CadastroFisico.add(lblCFisico);
        
        JButton btnVoltarCFi = new JButton("");
        btnVoltarCFi.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCFi.setBounds(10, 11, 69, 30);
        btnVoltarCFi.setForeground(new Color(124, 3, 54));
        btnVoltarCFi.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCFi.setBackground(new Color(235, 180, 181));
        CadastroFisico.add(btnVoltarCFi);
        
        JLabel lblTtuloLivroCFi = new JLabel("Título:");
        lblTtuloLivroCFi.setBounds(82, 160, 90, 50);
        lblTtuloLivroCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroFisico.add(lblTtuloLivroCFi);
        
        textFieldTituloLivroCFi = new JTextField();
        textFieldTituloLivroCFi.setBounds(182, 165, 516, 30);
        textFieldTituloLivroCFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldTituloLivroCFi.setColumns(10);
        CadastroFisico.add(textFieldTituloLivroCFi);

        textFieldTituloLivroCFi.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldTituloLivroCFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblISBNCFi = new JLabel("ISBN:");
        lblISBNCFi.setBounds(82, 204, 90, 50);
        lblISBNCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroFisico.add(lblISBNCFi);
        
        textFieldISBNCFi = new JTextField();
        textFieldISBNCFi.setBounds(161, 209, 423, 30);
        textFieldISBNCFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNCFi.setColumns(10);
        CadastroFisico.add(textFieldISBNCFi);
        
        textFieldISBNCFi.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNCFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblValorCFi = new JLabel("Valor:");
        lblValorCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblValorCFi.setBounds(82, 250, 90, 50);
        CadastroFisico.add(lblValorCFi);
        
        textFieldValorCFi = new JTextField();
        textFieldValorCFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldValorCFi.setColumns(10);
        textFieldValorCFi.setBounds(171, 255, 170, 30);
        CadastroFisico.add(textFieldValorCFi);
        
        JLabel lblGeneroCFi = new JLabel("Gênero:");
        lblGeneroCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblGeneroCFi.setBounds(351, 250, 116, 50);
        CadastroFisico.add(lblGeneroCFi);
        
        GerenciadorGeneros gSelecionadoCFi = new GerenciadorGeneros();
        
        JButton btnSelecionarGeneroCFi = new JButton("Selecionar");
        btnSelecionarGeneroCFi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popupMenuGenerosLCFi = new JPopupMenu("Gêneros de Livros");

                List<String> generosCFi = Arrays.asList("Romance", "Aventura", "Fantasia", "Suspense", "Terror", "Mistério", "Ficção Científica", "Ciência", "História", "Filosofia", "Época", "Policial", "Biografia", "Ficção", "Não ficção");

                for (String genero : generosCFi) {
                    JCheckBox checkBox = new JCheckBox(genero);
                    checkBox.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                    popupMenuGenerosLCFi.add(checkBox);
                    
                    if(gSelecionadoCFi.getGenerosSelecionados().contains(genero)) {
                    	checkBox.setSelected(true);
                    }

                    checkBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            boolean selected = checkBox.isSelected();
                            if (selected) {
                                gSelecionadoCFi.addGenero(genero);
                            } else {
                                gSelecionadoCFi.remGenero(genero);
                            }
                        }
                    });
                }

                popupMenuGenerosLCFi.show(btnSelecionarGeneroCFi, 0, btnSelecionarGeneroCFi.getHeight());
            }
        });
        btnSelecionarGeneroCFi.setBounds(465, 253, 199, 30);
        btnSelecionarGeneroCFi.setForeground(Color.WHITE);
        btnSelecionarGeneroCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        btnSelecionarGeneroCFi.setBackground(new Color(217, 180, 190));
        CadastroFisico.add(btnSelecionarGeneroCFi);

        JLabel lblAutorCFi = new JLabel("Autor:");
        lblAutorCFi.setBounds(82, 295, 90, 50);
        lblAutorCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroFisico.add(lblAutorCFi);
        
        textFieldAutorCFi = new JTextField();
        textFieldAutorCFi.setBounds(176, 300, 291, 30);
        textFieldAutorCFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldAutorCFi.setColumns(10);
        CadastroFisico.add(textFieldAutorCFi);
        
        textFieldAutorCFi.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldAutorCFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JScrollPane scrollPaneListaAutorCFi = new JScrollPane();
        scrollPaneListaAutorCFi.setBounds(82, 347, 602, 35);
        CadastroFisico.add(scrollPaneListaAutorCFi);
        
        JTextArea textAreaListaAutorCFi = new JTextArea();
        scrollPaneListaAutorCFi.setViewportView(textAreaListaAutorCFi);
        textAreaListaAutorCFi.setText("Lista: ");
        textAreaListaAutorCFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textAreaListaAutorCFi.setLineWrap(true);
        textAreaListaAutorCFi.setWrapStyleWord(true);
        textAreaListaAutorCFi.setEditable(false);
        
        ArrayList <String> autoresCFi = new ArrayList<String>();
        
        JButton btnAddAutorCFi = new JButton("Adicionar");
        btnAddAutorCFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nome=textFieldAutorCFi.getText();
        		if(!nome.isEmpty() && !autoresCFi.contains(nome)) {
        			autoresCFi.add(nome);
        			textAreaListaAutorCFi.setText(textAreaListaAutorCFi.getText()+nome+" - ");
        			textFieldAutorCFi.setText("");
        		}
        	}
        });
        btnAddAutorCFi.setForeground(Color.WHITE);
        btnAddAutorCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        btnAddAutorCFi.setBackground(new Color(217, 180, 190));
        btnAddAutorCFi.setBounds(487, 298, 196, 30);
        CadastroFisico.add(btnAddAutorCFi);
        
        JLabel lblSinopseCFi = new JLabel("Sinopse:");
        lblSinopseCFi.setBounds(82, 393, 116, 50);
        lblSinopseCFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroFisico.add(lblSinopseCFi);
        
        JScrollPane scrollPaneSinopseCFi = new JScrollPane();
        scrollPaneSinopseCFi.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        scrollPaneSinopseCFi.setBounds(197, 401, 493, 81);
        CadastroFisico.add(scrollPaneSinopseCFi);
        
        JTextArea textAreaSinopseCFi = new JTextArea();
        scrollPaneSinopseCFi.setViewportView(textAreaSinopseCFi);
        textAreaSinopseCFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textAreaSinopseCFi.setLineWrap(true);
        textAreaSinopseCFi.setWrapStyleWord(true);
        
        textAreaSinopseCFi.addKeyListener(new KeyListener() {
            final int maxCharacters = 500;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textAreaSinopseCFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        
        JButton btnCadastrarFi = new JButton("Cadastrar");
        btnCadastrarFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNCFi.getText();
        		String titulo=textFieldTituloLivroCFi.getText();
        		String valor=textFieldValorCFi.getText();
        		String sinopse=textAreaSinopseCFi.getText();
        		ArrayList<String> val=valParametrosFisico(ISBN, titulo, sinopse, valor, autoresCFi, gSelecionadoCFi.getGenerosSelecionados());
        		if(val.isEmpty()) {
        			FisicoDAO fiDAO=new FisicoDAO();
        			Fisico fib=fiDAO.buscaISBN(ISBN);
        			if(fib==null) {
                		Fisico fi=new Fisico(ISBN, titulo, sinopse, valor, autoresCFi, gSelecionadoCFi.getGenerosSelecionados(), 0);
                		LivroDAO lDAO=new LivroDAO();
                		int inseriuLivro=lDAO.inserirFi(fi);
                		int inseriuAutorLivro=lDAO.inserirAutorFi(fi);
                		int inseriuGeneroLivro=lDAO.inserirGeneroFi(fi);
                		int inseriuFisico=fiDAO.inserir(fi);
                		if((inseriuLivro==1 && inseriuFisico==1) || inseriuAutorLivro==1 || inseriuGeneroLivro==1){
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Livro físico cadastrado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
    	                }else {
                			txtAreaMsgErro.setText("");
                			txtAreaMsgErro.append("Não foi possível inserir este livro, houve algum erro!" + "\n");
                			telaErro="CadastroFisico";
                    		cardLayout.show(contentPane, "MensagemErro");
    	                }
        			}else {
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Já existe um livro cadastrado com esse ISBN!" + "\n");
            			telaErro="CadastroFisico";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="CadastroFisico";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        
        btnCadastrarFi.setBounds(589, 548, 199, 41);
        btnCadastrarFi.setForeground(new Color(115, 38, 52));
        btnCadastrarFi.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnCadastrarFi.setBackground(new Color(217, 180, 190));
        CadastroFisico.add(btnCadastrarFi);
        
        JLabel lblNewLabel_12 = new JLabel("New label");
        lblNewLabel_12.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_12.setBounds(0, 0, 798, 600);
        CadastroFisico.add(lblNewLabel_12);
        
        //Lista fisico
        
        ListaFisico = new JPanel();
        ListaFisico.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaFisico, "ListaFisico");
        ListaFisico.setLayout(null);
        
        JLabel lblListarFisico = new JLabel("Listar Livro Físico");
        lblListarFisico.setForeground(Color.WHITE);
        lblListarFisico.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarFisico.setBounds(257, 62, 306, 50);
        ListaFisico.add(lblListarFisico);
        
        JButton btnVoltarLFi = new JButton("");
        btnVoltarLFi.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLFi.setForeground(new Color(124, 3, 54));
        btnVoltarLFi.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLFi.setBackground(new Color(235, 180, 181));
        btnVoltarLFi.setBounds(10, 11, 69, 30);
        ListaFisico.add(btnVoltarLFi);
        
        JLabel lblISBNBLFi = new JLabel("ISBN do Livro:");
        lblISBNBLFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNBLFi.setBounds(179, 188, 207, 32);
        ListaFisico.add(lblISBNBLFi);
        
        textFieldISBNBLFi = new JTextField();
        textFieldISBNBLFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNBLFi.setColumns(10);
        textFieldISBNBLFi.setBounds(370, 184, 252, 30);
        ListaFisico.add(textFieldISBNBLFi);
        
        textFieldISBNBLFi.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNBLFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        table1LFi=new JTable();
        table1LFi.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        table1LFi.setModel(new DefaultTableModel(
        	new Object[][] {
        		{" ", " ", " "},
        	},
        	new String[] {
        		"Título", "ISBN", "Valor",  "Cópias disponíveis"
        	}
        ));
        table1LFi.getColumnModel().getColumn(0).setPreferredWidth(180);
        table1LFi.getColumnModel().getColumn(1).setPreferredWidth(70);
        table1LFi.getColumnModel().getColumn(2).setPreferredWidth(40);
        table1LFi.getColumnModel().getColumn(2).setPreferredWidth(90);
        JTableHeader header1LFi=table1LFi.getTableHeader();
        header1LFi.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header1LFi.setForeground(Color.WHITE);
        header1LFi.setBackground(new Color(241, 180, 181));
        table1LFi.setFont(new Font("Century Gothic", Font.PLAIN, 17));
       
        JScrollPane scrollPane1LFi = new JScrollPane();
        scrollPane1LFi.getViewport().setOpaque(false);
        scrollPane1LFi.setOpaque(false);
        scrollPane1LFi.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane1LFi.setBounds(25, 260, 746, 71);
        scrollPane1LFi.setViewportView(table1LFi);
        ListaFisico.add(scrollPane1LFi);
        
        table2LFi=new JTable();
        table2LFi.setModel(new DefaultTableModel(
        	new Object[][] {
          		{" ", " "},
           	},
        	new String[] {
        		"Autor", "Gênero"
        	}
        ));
        JTableHeader header2LFi=table2LFi.getTableHeader();
        header2LFi.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header2LFi.setForeground(Color.WHITE);
        header2LFi.setBackground(new Color(241, 180, 181));
        table2LFi.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        
        JScrollPane scrollPane2LFi = new JScrollPane();
        scrollPane2LFi.getViewport().setOpaque(false);
        scrollPane2LFi.setOpaque(false);
        scrollPane2LFi.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane2LFi.setBounds(25, 349, 746, 71);
        scrollPane2LFi.setViewportView(table2LFi);
        ListaFisico.add(scrollPane2LFi);

        JScrollPane scrollPaneSinopseLFi = new JScrollPane();
        scrollPaneSinopseLFi.setBounds(25, 430, 746, 93);
        ListaFisico.add(scrollPaneSinopseLFi);
        
        JTextArea textAreaSinopseLFi = new JTextArea("Sinopse: ");
        textAreaSinopseLFi.setLineWrap(true);
        textAreaSinopseLFi.setWrapStyleWord(true);
        textAreaSinopseLFi.setEditable(false);
        textAreaSinopseLFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        scrollPaneSinopseLFi.setViewportView(textAreaSinopseLFi);
        
        JButton btnListarFi = new JButton("Listar");
        btnListarFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNBLFi.getText();
        		if(ISBN.matches("\\d+") && ISBN.length()==13) {
            		FisicoDAO fiDAO = new FisicoDAO();
            		Fisico fib = fiDAO.buscaISBN(ISBN);
            		if(fib!=null) {
            			DefaultTableModel model1LFi=(DefaultTableModel) table1LFi.getModel();
            			model1LFi.setRowCount(0);
                        DefaultTableModel model2LFi=(DefaultTableModel) table2LFi.getModel();
                        model2LFi.setRowCount(0);
                        String autoresLFi="";
                        for(String a:fib.getAutor()) {
                        	autoresLFi=autoresLFi+a+"; ";
                        }
                        String generosLFi="";
                        for(String g:fib.getGenero()) {
                        	generosLFi=generosLFi+g+"; ";
                        }
                        model1LFi.addRow(new Object[]{fib.getTitulo(), fib.getISBN(), fib.getValor(), fib.getNum_copias_disponiveis()});
                        model2LFi.addRow(new Object[]{autoresLFi, generosLFi});
                        textAreaSinopseLFi.setText("Sinopse: "+fib.getSinopse());
            		}else {
            			DefaultTableModel model1LFi=(DefaultTableModel) table1LFi.getModel();
            			model1LFi.setRowCount(0);
                        DefaultTableModel model2LFi=(DefaultTableModel) table2LFi.getModel();
                        model2LFi.setRowCount(0);
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não existe nenhum livro físico cadastrado com este ISBN!" + "\n");
            			telaErro="ListaFisico";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			DefaultTableModel model1LFi=(DefaultTableModel) table1LFi.getModel();
        			model1LFi.setRowCount(0);
                    DefaultTableModel model2LFi=(DefaultTableModel) table2LFi.getModel();
                    model2LFi.setRowCount(0);
        			txtAreaMsgErro.setText("");
        			txtAreaMsgErro.append("ISBN inválido!" + "\n");
        			telaErro="ListaFisico";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnListarFi.setForeground(new Color(115, 38, 52));
        btnListarFi.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarFi.setBackground(new Color(217, 180, 190));
        btnListarFi.setBounds(317, 548, 147, 41);
        ListaFisico.add(btnListarFi);
        
        JLabel lblNewLabel_13 = new JLabel("New label");
        lblNewLabel_13.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_13.setBounds(0, 0, 798, 600);
        ListaFisico.add(lblNewLabel_13);

        //ListaTodosFisico
        
        ListaTodosFisico = new JPanel();
        ListaTodosFisico.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaTodosFisico, "ListaTodosFisico");
        ListaTodosFisico.setLayout(null);

        JLabel lblListaTodosFisico = new JLabel("Lista todos os Físicos");
        lblListaTodosFisico.setForeground(Color.WHITE);
        lblListaTodosFisico.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListaTodosFisico.setBounds(233, 62, 371, 38);
        ListaTodosFisico.add(lblListaTodosFisico);

        JButton btnVoltarLTFi = new JButton("");
        btnVoltarLTFi.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLTFi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu");
            }
        });
        btnVoltarLTFi.setForeground(new Color(124, 3, 54));
        btnVoltarLTFi.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLTFi.setBackground(new Color(235, 180, 181));
        btnVoltarLTFi.setBounds(10, 11, 69, 30);
        ListaTodosFisico.add(btnVoltarLTFi);
        
        tableLTFi = new JTable();
        DefaultTableModel tableModelLTFi = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Título", "ISBN", "Valor", "Autor", "Gênero", "Cópias disponíveis"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableLTFi.setModel(tableModelLTFi);

        JTableHeader headerLTFi = tableLTFi.getTableHeader();
        headerLTFi.setFont(new Font("Century Gothic", Font.BOLD, 18));
        headerLTFi.setForeground(Color.WHITE);
        headerLTFi.setBackground(new Color(241, 180, 181));
        tableLTFi.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        JScrollPane scrollPaneLTFi = new JScrollPane(tableLTFi);
        scrollPaneLTFi.setBounds(28, 209, 746, 309);
        scrollPaneLTFi.setOpaque(false);
        scrollPaneLTFi.getViewport().setOpaque(false);
        scrollPaneLTFi.setBorder(new EmptyBorder(0, 0, 0, 0));
        ListaTodosFisico.add(scrollPaneLTFi);

        JButton btnListarTFi = new JButton("Listar");
        btnListarTFi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FisicoDAO fiDAO = new FisicoDAO();
                ArrayList<Fisico> listaTodosFi = fiDAO.listarTodos();
                tableModelLTFi.setRowCount(0);
                for (Fisico fi : listaTodosFi) {
                	String autoresLTFi="";
                    for(String a:fi.getAutor()) {
                    	autoresLTFi=autoresLTFi+a+"; ";
                    }
                    String generosLTFi="";
                    for(String g:fi.getGenero()) {
                    	generosLTFi=generosLTFi+g+"; ";
                    }
                    tableModelLTFi.addRow(new Object[]{fi.getTitulo(), fi.getISBN(), fi.getValor(), autoresLTFi, generosLTFi, fi.getNum_copias_disponiveis()});
                }
            }
        });
        btnListarTFi.setForeground(new Color(115, 38, 52));
        btnListarTFi.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarTFi.setBackground(new Color(217, 180, 190));
        btnListarTFi.setBounds(327, 548, 147, 41);
        ListaTodosFisico.add(btnListarTFi);
        
        JLabel lblNewLabel_14 = new JLabel("New label");
        lblNewLabel_14.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_14.setBounds(0, 0, 798, 600);
        ListaTodosFisico.add(lblNewLabel_14);
        
        //Edita Fisico
        
        EditaFisico = new JPanel();
        EditaFisico.setBackground(new Color(255, 217, 220));
        contentPane.add(EditaFisico, "EditaFisico");
        EditaFisico.setLayout(null);
        
        JLabel lblEFisico = new JLabel("Editar Livro Físico");
        lblEFisico.setForeground(Color.WHITE);
        lblEFisico.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblEFisico.setBounds(258, 63, 322, 50);
        EditaFisico.add(lblEFisico);

        JButton btnVoltarEFi = new JButton("");
        btnVoltarEFi.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarEFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        		limparInfoEFi();
        	}
        });
        btnVoltarEFi.setForeground(new Color(163, 5, 65));
        btnVoltarEFi.setFont(new Font("Century Gothic", Font.BOLD, 20));
        btnVoltarEFi.setBackground(new Color(253, 181, 193));
        btnVoltarEFi.setBounds(10, 11, 69, 30);
        EditaFisico.add(btnVoltarEFi);
        
        JLabel lblTtuloLivroEFi = new JLabel("Título:");
        lblTtuloLivroEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblTtuloLivroEFi.setBounds(96, 166, 90, 50);
        EditaFisico.add(lblTtuloLivroEFi);
        
        textFieldTituloLivroEFi = new JTextField();
        textFieldTituloLivroEFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldTituloLivroEFi.setColumns(10);
        textFieldTituloLivroEFi.setBounds(188, 171, 516, 30);
        EditaFisico.add(textFieldTituloLivroEFi);
        
        textFieldTituloLivroEFi.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldTituloLivroEFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblValorEFi = new JLabel("Valor:");
        lblValorEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblValorEFi.setBounds(96, 208, 90, 50);
        EditaFisico.add(lblValorEFi);
        
        textFieldValorEFi = new JTextField();
        textFieldValorEFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldValorEFi.setColumns(10);
        textFieldValorEFi.setBounds(178, 213, 170, 30);
        EditaFisico.add(textFieldValorEFi);
        
        JLabel lblGeneroEFi = new JLabel("Gênero:");
        
        lblGeneroEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblGeneroEFi.setBounds(357, 208, 116, 50);
        EditaFisico.add(lblGeneroEFi);
        
        gSelecionadoEFi = new GerenciadorGeneros();
        
        JButton btnSelecionarGeneroEFi = new JButton("Selecionar");
        btnSelecionarGeneroEFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                JPopupMenu popupMenuGenerosLEFi = new JPopupMenu("Gêneros de Livros");

                List<String> generosEFi = Arrays.asList("Romance", "Aventura", "Fantasia", "Suspense", "Terror", "Mistério", "Ficção Científica", "Ciência", "História", "Filosofia", "Época", "Policial", "Biografia", "Ficção", "Não ficção");

                for (String genero : generosEFi) {
                    JCheckBox checkBox = new JCheckBox(genero);
                    checkBox.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                    popupMenuGenerosLEFi.add(checkBox);
                    
                    if(gSelecionadoEFi.getGenerosSelecionados().contains(genero)) {
                    	checkBox.setSelected(true);
                    }

                    checkBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            boolean selected = checkBox.isSelected();
                            if (selected) {
                            	gSelecionadoEFi.addGenero(genero);
                            } else {
                            	gSelecionadoEFi.remGenero(genero);
                            }
                        }
                    });
                }

                popupMenuGenerosLEFi.show(btnSelecionarGeneroEFi, 0, btnSelecionarGeneroEFi.getHeight());
        	}
        });
        btnSelecionarGeneroEFi.setForeground(Color.WHITE);
        btnSelecionarGeneroEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        btnSelecionarGeneroEFi.setBackground(new Color(217, 180, 190));
        btnSelecionarGeneroEFi.setBounds(466, 211, 199, 30);
        EditaFisico.add(btnSelecionarGeneroEFi);
        
        JLabel lblAutorEFi = new JLabel("Autor:");
        lblAutorEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblAutorEFi.setBounds(96, 254, 90, 50);
        EditaFisico.add(lblAutorEFi);
        
        textFieldAutorEFi = new JTextField();
        textFieldAutorEFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldAutorEFi.setColumns(10);
        textFieldAutorEFi.setBounds(188, 259, 516, 30);
        EditaFisico.add(textFieldAutorEFi);
        
        textFieldAutorEFi.addKeyListener(new KeyListener() {
            final int maxCharacters=80;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldAutorEFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        JScrollPane scrollPaneListaAutorEFi = new JScrollPane();
        scrollPaneListaAutorEFi.setBounds(108, 341, 602, 35);
        EditaFisico.add(scrollPaneListaAutorEFi);
        
        textAreaListaAutorEFi = new JTextArea();
        scrollPaneListaAutorEFi.setViewportView(textAreaListaAutorEFi);
        textAreaListaAutorEFi.setWrapStyleWord(true);
        textAreaListaAutorEFi.setText("Lista: ");
        textAreaListaAutorEFi.setLineWrap(true);
        textAreaListaAutorEFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textAreaListaAutorEFi.setEditable(false);
        
        autoresEFi=new ArrayList<>();      
        
        JButton btnAddAutorEFi = new JButton("Adicionar");
        btnAddAutorEFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nome=textFieldAutorEFi.getText();
        		if(!nome.isEmpty() && !autoresCFi.contains(nome)) {
        			autoresEFi.add(nome);
        			textAreaListaAutorEFi.setText(textAreaListaAutorEFi.getText()+nome+" - ");
        			textFieldAutorEFi.setText("");
        		}
        	}
        });
        btnAddAutorEFi.setForeground(Color.WHITE);
        btnAddAutorEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        btnAddAutorEFi.setBackground(new Color(217, 180, 190));
        btnAddAutorEFi.setBounds(249, 300, 196, 30);
        EditaFisico.add(btnAddAutorEFi);
        
        JButton btnRemAutorEFi = new JButton("Remover");
        btnRemAutorEFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nome=textFieldAutorEFi.getText();
        		if(!nome.isEmpty() && autoresEFi.contains(nome)) {
        			autoresEFi.remove(nome);
        			textAreaListaAutorEFi.setText("Lista: ");
        			for(String autor:autoresEFi) {
        				textAreaListaAutorEFi.setText(textAreaListaAutorEFi.getText()+autor+" - ");
        			}
        			textFieldAutorEFi.setText("");
        		}
        	}
        });
        btnRemAutorEFi.setForeground(Color.WHITE);
        btnRemAutorEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        btnRemAutorEFi.setBackground(new Color(217, 180, 190));
        btnRemAutorEFi.setBounds(455, 300, 196, 30);
        EditaFisico.add(btnRemAutorEFi);
        
        JLabel lblSinopseEFi = new JLabel("Sinopse:");
        lblSinopseEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblSinopseEFi.setBounds(96, 387, 116, 50);
        EditaFisico.add(lblSinopseEFi);

        JScrollPane scrollPaneSinopseEFi = new JScrollPane();
        scrollPaneSinopseEFi.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        scrollPaneSinopseEFi.setBounds(222, 398, 493, 81);
        EditaFisico.add(scrollPaneSinopseEFi);
        
                textAreaSinopseEFi = new JTextArea();
                scrollPaneSinopseEFi.setViewportView(textAreaSinopseEFi);
                textAreaSinopseEFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
                textAreaSinopseEFi.setLineWrap(true);
                textAreaSinopseEFi.setWrapStyleWord(true);
                
                textAreaSinopseEFi.addKeyListener(new KeyListener() {
                    final int maxCharacters = 500;
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (textAreaSinopseEFi.getText().length() >= maxCharacters) {
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        
        textFieldISBNEFi = new JTextField();
        EditaCliente.add(textFieldISBNEFi);
        
        JLabel lblEnderecoEC = new JLabel("Endereço:");
        lblEnderecoEC.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblEnderecoEC.setBounds(61, 254, 177, 50);
        EditaCliente.add(lblEnderecoEC);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_3.setBounds(0, 0, 798, 600);
        EditaCliente.add(lblNewLabel_3);
        textFieldISBNEFi.setVisible(false);
        
        JButton btnEditarFi = new JButton("Editar");
        btnEditarFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNEFi.getText();
        		String titulo=textFieldTituloLivroEFi.getText();
        		String valor=textFieldValorEFi.getText();
        		String sinopse=textAreaSinopseEFi.getText();
        		ArrayList<String> val=valParametrosFisico(ISBN, titulo, sinopse, valor, autoresEFi, gSelecionadoEFi.getGenerosSelecionados());
        		if(val.isEmpty()) {
        			Fisico fi=new Fisico(ISBN, titulo, sinopse, valor, autoresEFi, gSelecionadoEFi.getGenerosSelecionados(), numCopiasDisponiveisEFi);
            		LivroDAO lDAO=new LivroDAO();
            		int editouLivro=lDAO.editarFi(fi);
            		int editouAutorLivro=lDAO.editarAutorFi(fi);
            		int editouGeneroLivro=lDAO.editarGeneroFi(fi);
            		if(editouLivro==1){
	                	txtAreaMsgSucesso.setText("");
            			txtAreaMsgSucesso.append("Informações atualizadas com sucesso!" + "\n");
                		if(editouAutorLivro==1){
                			txtAreaMsgSucesso.append("Editou autores do livro físico!" + "\n");
                        }
                		if(editouGeneroLivro==1){
                			txtAreaMsgSucesso.append("Editou generos do livro físico!" + "\n");
                        }
                		cardLayout.show(contentPane, "MensagemSucesso");
                    	limparInfoEFi();
                    }else {
                    	System.out.println("Não editou livro físico!");
                    }
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="EditaFisico";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnEditarFi.setForeground(new Color(115, 38, 52));
        btnEditarFi.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnEditarFi.setBackground(new Color(217, 180, 190));
        btnEditarFi.setBounds(589, 548, 199, 41);
        EditaFisico.add(btnEditarFi);
        
        JLabel lblNewLabel_15 = new JLabel("New label");
        lblNewLabel_15.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_15.setBounds(0, 0, 798, 600);
        EditaFisico.add(lblNewLabel_15);

        //Busca edita fisico
        
        BuscaEditaFisico = new JPanel();
        BuscaEditaFisico.setBackground(new Color(255, 217, 220));
        contentPane.add(BuscaEditaFisico, "BuscaEditaFisico");
        BuscaEditaFisico.setLayout(null);
        
        JLabel lblBEFisico = new JLabel("Editar Livro Físico");
        lblBEFisico.setForeground(Color.WHITE);
        lblBEFisico.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblBEFisico.setBounds(252, 64, 320, 50);
        BuscaEditaFisico.add(lblBEFisico);
        
        JButton btnVoltarBEFi = new JButton("");
        btnVoltarBEFi.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarBEFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        		limparInfoBEFi();
        	}
        });
        btnVoltarBEFi.setForeground(new Color(163, 5, 65));
        btnVoltarBEFi.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarBEFi.setBackground(new Color(253, 181, 193));
        btnVoltarBEFi.setBounds(10, 11, 69, 30);
        BuscaEditaFisico.add(btnVoltarBEFi);
        
        JLabel lblISBNBEFi = new JLabel("ISBN do Livro:");
        lblISBNBEFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNBEFi.setBounds(173, 304, 207, 32);
        BuscaEditaFisico.add(lblISBNBEFi);
        
        textFieldISBNBEFi = new JTextField();
        textFieldISBNBEFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNBEFi.setColumns(10);
        textFieldISBNBEFi.setBounds(381, 300, 260, 30);
        BuscaEditaFisico.add(textFieldISBNBEFi);
        
        textFieldISBNBEFi.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNBEFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnBuscarEFi = new JButton("Buscar");
        btnBuscarEFi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNBEFi.getText();
        		if(ISBN.matches("\\d+") && ISBN.length()==13) {
        			FisicoDAO fDAO=new FisicoDAO();
            		Fisico fib=fDAO.buscaISBN(ISBN);
            		if(fib!=null) {
            			textFieldISBNEFi.setText(ISBN);
            			textFieldTituloLivroEFi.setText(fib.getTitulo());
            			textFieldValorEFi.setText(fib.getValor());
            			textAreaSinopseEFi.setText(fib.getSinopse());
            			ArrayList <String> generosBEFi=fib.getGenero();
            			for (String genero:generosBEFi) {
            	            if(!genero.isEmpty()) {
            	            	gSelecionadoEFi.addGenero(genero);
            	            }
            	        }
            			ArrayList <String> autoresBEFi = fib.getAutor();
            	        for(String autor:autoresBEFi) {
            	        	if(!autor.isEmpty()) {
            	        		autoresEFi.add(autor);
        	        			textAreaListaAutorEFi.setText(textAreaListaAutorEFi.getText()+autor+" - ");
        	        		}
            	        }
            	        numCopiasDisponiveisEFi=fib.getNum_copias_disponiveis();
            	        limparInfoBEFi();
            	        cardLayout.show(contentPane, "EditaFisico");
            		}else {
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não existe nenhum livro físico cadastrado com esse ISBN!" + "\n");
            			telaErro="BuscaEditaFisico";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			txtAreaMsgErro.setText("");
        			txtAreaMsgErro.append("ISBN inválido!" + "\n");
        			telaErro="BuscaEditaFisico";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnBuscarEFi.setForeground(new Color(115, 38, 52));
        btnBuscarEFi.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarEFi.setBackground(new Color(217, 180, 190));
        btnBuscarEFi.setBounds(326, 484, 147, 41);
        BuscaEditaFisico.add(btnBuscarEFi);
        
        JLabel lblNewLabel_16 = new JLabel("New label");
        lblNewLabel_16.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_16.setBounds(0, 0, 798, 600);
        BuscaEditaFisico.add(lblNewLabel_16);
        
        //Deleta fisico
        
        DeletaFisico = new JPanel();
        DeletaFisico.setBackground(new Color(255, 217, 220));
        contentPane.add(DeletaFisico, "DeletaFisico");
        DeletaFisico.setLayout(null);
        
        JLabel lblDFisico = new JLabel("Deletar Livro Físico");
        lblDFisico.setForeground(Color.WHITE);
        lblDFisico.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblDFisico.setBounds(247, 60, 335, 50);
        DeletaFisico.add(lblDFisico);
        
        JButton btnVoltarDFi = new JButton("");
        btnVoltarDFi.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarDFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarDFi.setForeground(new Color(163, 5, 65));
        btnVoltarDFi.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarDFi.setBackground(new Color(253, 181, 193));
        btnVoltarDFi.setBounds(10, 11, 69, 30);
        DeletaFisico.add(btnVoltarDFi);
        
        JLabel lblISBNDFi = new JLabel("ISBN do Livro:");
        lblISBNDFi.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNDFi.setBounds(174, 307, 207, 32);
        DeletaFisico.add(lblISBNDFi);
        
        textFieldISBNDFi = new JTextField();
        textFieldISBNDFi.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNDFi.setColumns(10);
        textFieldISBNDFi.setBounds(371, 303, 260, 30);
        DeletaFisico.add(textFieldISBNDFi);
        
        textFieldISBNDFi.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNDFi.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnDeletarFi = new JButton("Deletar");
        btnDeletarFi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNDFi.getText();
        		if(ISBN.matches("\\d+") && ISBN.length()==13) {
        			FisicoDAO fiDAO=new FisicoDAO();
        			Fisico fi=fiDAO.buscaISBN(ISBN);
        			if(fi!=null) {
        				LivroDAO lDAO=new LivroDAO();
        				
        				int removeuFisico=fiDAO.remover(fi);
        				int removeuAutorLivro=lDAO.removerAutorFi(fi);
        				int removeuGeneroLivro=lDAO.removerGeneroFi(fi);
        				int removeuLivro=lDAO.removerFi(fi);
        				
        				if((removeuFisico==1 && removeuLivro==1) || removeuAutorLivro==1 || removeuGeneroLivro==1) {
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Cadastro deletado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
        				}else {
                			txtAreaMsgErro.setText("");
                			txtAreaMsgErro.append("Não foi possível deletar o cadastro deste livro físico, houve algum erro!" + "\n");
                			telaErro="DeletaFisico";
                    		cardLayout.show(contentPane, "MensagemErro");
        				}
        			}else {
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não existe nenhum livro físico cadastrado com esse ISBN!" + "\n");
            			telaErro="DeletaFisico";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			txtAreaMsgErro.setText("");
        			txtAreaMsgErro.append("ISBN inválido!" + "\n");
        			telaErro="DeletaFisico";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnDeletarFi.setForeground(new Color(115, 38, 52));
        btnDeletarFi.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnDeletarFi.setBackground(new Color(217, 180, 190));
        btnDeletarFi.setBounds(318, 483, 167, 41);
        DeletaFisico.add(btnDeletarFi);
        
        JLabel lblNewLabel_17 = new JLabel("New label");
        lblNewLabel_17.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_17.setBounds(0, 0, 798, 600);
        DeletaFisico.add(lblNewLabel_17);
        
        //           <<<<<<<<<<<<EXEMPLAR>>>>>>>>>>>>
        
        //CadastroExemplar
        
        CadastroExemplar = new JPanel();
        CadastroExemplar.setBackground(new Color(255, 217, 220));
        contentPane.add(CadastroExemplar, "CadastroExemplar");
        CadastroExemplar.setLayout(null);
        
        JLabel lblCExemplar = new JLabel("Cadastrar Exemplar");
        lblCExemplar.setBounds(246, 61, 347, 50);
        lblCExemplar.setForeground(Color.WHITE);
        lblCExemplar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        CadastroExemplar.add(lblCExemplar);
        
        JButton btnVoltarCEx = new JButton("");
        btnVoltarCEx.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCEx.setBounds(10, 11, 69, 30);
        btnVoltarCEx.setForeground(new Color(163, 5, 65));
        btnVoltarCEx.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCEx.setBackground(new Color(253, 181, 193));
        CadastroExemplar.add(btnVoltarCEx);
        
        JLabel lblISBNCEx = new JLabel("ISBN do Livro:");
        lblISBNCEx.setBounds(149, 196, 208, 50);
        lblISBNCEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroExemplar.add(lblISBNCEx);
        
        textFieldISBNCEx = new JTextField();
        textFieldISBNCEx.setBounds(340, 201, 290, 30);
        textFieldISBNCEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNCEx.setColumns(10);
        CadastroExemplar.add(textFieldISBNCEx);
        
        textFieldISBNCEx.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNCEx.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumeroCEx = new JLabel("Número:");
        lblNumeroCEx.setBounds(149, 239, 177, 50);
        lblNumeroCEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroExemplar.add(lblNumeroCEx);
        
        textFieldNumeroCEx = new JTextField();
        textFieldNumeroCEx.setBounds(273, 244, 119, 30);
        textFieldNumeroCEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNumeroCEx.setColumns(10);
        CadastroExemplar.add(textFieldNumeroCEx);

        textFieldNumeroCEx.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblEdicaoCEx = new JLabel("Edição:");
        lblEdicaoCEx.setBounds(410, 242, 177, 50);
        lblEdicaoCEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroExemplar.add(lblEdicaoCEx);
        
        textFieldEdicaoCEx = new JTextField();
        textFieldEdicaoCEx.setBounds(514, 247, 94, 30);
        textFieldEdicaoCEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldEdicaoCEx.setColumns(10);
        CadastroExemplar.add(textFieldEdicaoCEx);
        
        textFieldEdicaoCEx.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblAnoPublicacaoCEx = new JLabel("Ano de publicação:");
        lblAnoPublicacaoCEx.setBounds(149, 285, 277, 50);
        lblAnoPublicacaoCEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroExemplar.add(lblAnoPublicacaoCEx);
        
        JYearChooser yearChooserAnoPublicacaoCEx = new JYearChooser();
        yearChooserAnoPublicacaoCEx.setBounds(398, 289, 77, 30);
        yearChooserAnoPublicacaoCEx.getSpinner().setFont(new Font("Century Gothic", Font.PLAIN, 20));
        CadastroExemplar.add(yearChooserAnoPublicacaoCEx);
        
        JLabel lblEstadoConservacaoCEx = new JLabel("Estado de conservação:");
        lblEstadoConservacaoCEx.setBounds(149, 330, 341, 50);
        lblEstadoConservacaoCEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        CadastroExemplar.add(lblEstadoConservacaoCEx);
        
        JRadioButton rdbtnNovoCEx = new JRadioButton("Novo");
        rdbtnNovoCEx.setBackground(new Color(217, 180, 190));
        rdbtnNovoCEx.setBounds(191, 376, 77, 35);
        rdbtnNovoCEx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CadastroExemplar.add(rdbtnNovoCEx);
        
        JRadioButton rdbtnSeminovoCEx = new JRadioButton("Seminovo");
        rdbtnSeminovoCEx.setBackground(new Color(217, 180, 190));
        rdbtnSeminovoCEx.setBounds(287, 376, 109, 35);
        rdbtnSeminovoCEx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CadastroExemplar.add(rdbtnSeminovoCEx);
        
        JRadioButton rdbtnAntigoCEx = new JRadioButton("Antigo");
        rdbtnAntigoCEx.setBackground(new Color(217, 180, 190));
        rdbtnAntigoCEx.setBounds(419, 376, 87, 35);
        rdbtnAntigoCEx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CadastroExemplar.add(rdbtnAntigoCEx);

        ButtonGroup btnGrpEstadoConservacaoCEx = new ButtonGroup();
        btnGrpEstadoConservacaoCEx.add(rdbtnNovoCEx);
        btnGrpEstadoConservacaoCEx.add(rdbtnSeminovoCEx);
        btnGrpEstadoConservacaoCEx.add(rdbtnAntigoCEx);
        ActionListener aLEstadoConservacaoCEx = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	estadoConservacaoCEx=((JRadioButton) e.getSource()).getText();
            }
        };
        rdbtnNovoCEx.addActionListener(aLEstadoConservacaoCEx);
        rdbtnSeminovoCEx.addActionListener(aLEstadoConservacaoCEx);
        rdbtnAntigoCEx.addActionListener(aLEstadoConservacaoCEx);
        
        JButton btnCadastrarEx = new JButton("Cadastrar");
        btnCadastrarEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNCEx.getText();
        		String numero=textFieldNumeroCEx.getText();
        		String edicao=textFieldEdicaoCEx.getText();
        		long ano_publicação=yearChooserAnoPublicacaoCEx.getYear();
        		ArrayList<String> val=valParametrosExemplar(ISBN, numero, edicao, estadoConservacaoCEx);
        		if(val.isEmpty()) {
        			FisicoDAO fDAO=new FisicoDAO();
        			Fisico fi=fDAO.buscaISBN(ISBN);
        			if(fi!=null) {
        				long numeroLong=Long.parseLong(textFieldNumeroCEx.getText());
            			long edicaoLong=Long.parseLong(textFieldEdicaoCEx.getText());
            			ExemplarDAO exDAO=new ExemplarDAO();
            			Exemplar exb=exDAO.buscaISBNNum(ISBN, numeroLong);
            			if(exb==null) {
            				Exemplar ex=new Exemplar(ISBN, numeroLong, edicaoLong, true, estadoConservacaoCEx, ano_publicação);
            				int inseriuEx=exDAO.inserir(ex);
            				if(inseriuEx>0) {
        	                	txtAreaMsgSucesso.setText("");
                    	        txtAreaMsgSucesso.append("Exemplar cadastrado com sucesso!" + "\n");
                        		cardLayout.show(contentPane, "MensagemSucesso");
            				}else {
                				txtAreaMsgErro.setText("");
                        		txtAreaMsgErro.append("Não inseriu, houve algum erro!" + "\n");
                    			telaErro="CadastroExemplar";
                        		cardLayout.show(contentPane, "MensagemErro");
            				}
            			}else {
            				txtAreaMsgErro.setText("");
                    		txtAreaMsgErro.append("Já existe um exemplar cadastrado com esse número e esse ISBN!" + "\n");
                			telaErro="CadastroExemplar";
                    		cardLayout.show(contentPane, "MensagemErro");
            			}
        			}else {
        				txtAreaMsgErro.setText("");
                		txtAreaMsgErro.append("Não existe nenhum livro fisico cadastrado com esse ISBN!" + "\n");
            			telaErro="CadastroExemplar";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
            			txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="CadastroExemplar";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnCadastrarEx.setBounds(589, 482, 199, 41);
        btnCadastrarEx.setForeground(new Color(115, 38, 52));
        btnCadastrarEx.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnCadastrarEx.setBackground(new Color(217, 180, 190));
        CadastroExemplar.add(btnCadastrarEx);
        
        JLabel lblNewLabel_18 = new JLabel("New label");
        lblNewLabel_18.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_18.setBounds(0, 0, 798, 600);
        CadastroExemplar.add(lblNewLabel_18);

        //ListaExemplar
        
        ListaExemplar = new JPanel();
        ListaExemplar.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaExemplar, "ListaExemplar");
        ListaExemplar.setLayout(null);
        
        JLabel lblListarExemplar = new JLabel("Listar Exemplar");
        lblListarExemplar.setForeground(Color.WHITE);
        lblListarExemplar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarExemplar.setBounds(277, 62, 270, 50);
        ListaExemplar.add(lblListarExemplar);
        
        JButton btnVoltarLEx = new JButton("");
        btnVoltarLEx.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLEx.setForeground(new Color(163, 5, 65));
        btnVoltarLEx.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLEx.setBackground(new Color(253, 181, 193));
        btnVoltarLEx.setBounds(10, 11, 69, 30);
        ListaExemplar.add(btnVoltarLEx);
        
        JLabel lblISBNLEx = new JLabel("ISBN do Livro:");
        lblISBNLEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNLEx.setBounds(161, 201, 207, 32);
        ListaExemplar.add(lblISBNLEx);
        
        textFieldISBNLEx = new JTextField();
        textFieldISBNLEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNLEx.setColumns(10);
        textFieldISBNLEx.setBounds(360, 197, 260, 30);
        ListaExemplar.add(textFieldISBNLEx);
        
        textFieldISBNLEx.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNLEx.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumeroLEx = new JLabel("Número do Exemplar:");
        lblNumeroLEx.setBounds(161, 233, 287, 50);
        lblNumeroLEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        ListaExemplar.add(lblNumeroLEx);
        
        textFieldNumeroLEx = new JTextField();
        textFieldNumeroLEx.setBounds(454, 238, 119, 30);
        textFieldNumeroLEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        ListaExemplar.add(textFieldNumeroLEx);

        textFieldNumeroLEx.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        table1LEx=new JTable();
        table1LEx.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        table1LEx.setModel(new DefaultTableModel(
        	new Object[][] {
        		{" ", " ", " "},
        	},
        	new String[] {
        		"ISBN", "Número", "Edição"
        	}
        ));
        table1LEx.getColumnModel().getColumn(0).setPreferredWidth(180);
        table1LEx.getColumnModel().getColumn(1).setPreferredWidth(70);
        table1LEx.getColumnModel().getColumn(2).setPreferredWidth(40);
        JTableHeader header1LEx=table1LEx.getTableHeader();
        header1LEx.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header1LEx.setForeground(Color.WHITE);
        header1LEx.setBackground(new Color(241, 180, 181));
        table1LEx.setFont(new Font("Century Gothic", Font.PLAIN, 17));
       
        JScrollPane scrollPane1LEx = new JScrollPane();
        scrollPane1LEx.getViewport().setOpaque(false);
        scrollPane1LEx.setOpaque(false);
        scrollPane1LEx.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane1LEx.setBounds(25, 323, 746, 71);
        scrollPane1LEx.setViewportView(table1LEx);
        ListaExemplar.add(scrollPane1LEx);
        
        table2LEx=new JTable();
        table2LEx.setModel(new DefaultTableModel(
        	new Object[][] {
          		{" ", " ", " "},
           	},
        	new String[] {
        		"Disponível", "Estado de conservação", "Ano de publicação"
        	}
        ));
        JTableHeader header2LEx=table2LEx.getTableHeader();
        header2LEx.setFont(new Font("Century Gothic", Font.BOLD, 20));
        header2LEx.setForeground(Color.WHITE);
        header2LEx.setBackground(new Color(241, 180, 181));
        table2LEx.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        
        JScrollPane scrollPane2LEx = new JScrollPane();
        scrollPane2LEx.getViewport().setOpaque(false);
        scrollPane2LEx.setOpaque(false);
        scrollPane2LEx.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane2LEx.setBounds(25, 412, 746, 71);
        scrollPane2LEx.setViewportView(table2LEx);
        ListaExemplar.add(scrollPane2LEx);
        
        JButton btnListarEx = new JButton("Listar");
        btnListarEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNLEx.getText();
        		String numero=textFieldNumeroLEx.getText();
        		if(ISBN.length()==13 && !numero.isEmpty()) {
        			long numeroLong=Long.parseLong(numero);
            		ExemplarDAO exDAO = new ExemplarDAO();
            		Exemplar exb = exDAO.buscaISBNNum(ISBN, numeroLong);
            		if(exb!=null) {
            			DefaultTableModel model1LEx=(DefaultTableModel) table1LEx.getModel();
            			model1LEx.setRowCount(0);
                        DefaultTableModel model2LEx=(DefaultTableModel) table2LEx.getModel();
                        model2LEx.setRowCount(0);
                        String disponibilidade="Não";
                        if(exb.getDisponibilidade()) {
                        	disponibilidade="Sim";
                        }
                        model1LEx.addRow(new Object[]{exb.getISBN_fisico(), exb.getNumero(), exb.getEdicao()});
                        model2LEx.addRow(new Object[]{disponibilidade, exb.getEstado_conservacao(), exb.getAno_publicacao()});
            		}else {
            			DefaultTableModel model1LEx=(DefaultTableModel) table1LEx.getModel();
            			model1LEx.setRowCount(0);
                        DefaultTableModel model2LEx=(DefaultTableModel) table2LEx.getModel();
                        model2LEx.setRowCount(0);
                        txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não existe nenhum exemplar cadastrado com esses ISBN e número!" + "\n");
            			telaErro="ListaExemplar";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			DefaultTableModel model1LEx=(DefaultTableModel) table1LEx.getModel();
        			model1LEx.setRowCount(0);
                    DefaultTableModel model2LEx=(DefaultTableModel) table2LEx.getModel();
                    model2LEx.setRowCount(0);
                    txtAreaMsgErro.setText("");
        			txtAreaMsgErro.append("ISBN e número inválidos!" + "\n");
        			telaErro="ListaExemplar";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnListarEx.setForeground(new Color(115, 38, 52));
        btnListarEx.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarEx.setBackground(new Color(217, 180, 190));
        btnListarEx.setBounds(331, 548, 147, 41);
        ListaExemplar.add(btnListarEx);
        
        JLabel lblNewLabel_19 = new JLabel("New label");
        lblNewLabel_19.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_19.setBounds(0, 0, 798, 600);
        ListaExemplar.add(lblNewLabel_19);
        
        //ListaTodosExemplar
        
        ListaTodosExemplar = new JPanel();
        ListaTodosExemplar.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaTodosExemplar, "ListaTodosExemplar");
        ListaTodosExemplar.setLayout(null);
        
        JLabel lblListarTodosExemplar = new JLabel("Listar Exemplar");
        lblListarTodosExemplar.setForeground(Color.WHITE);
        lblListarTodosExemplar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarTodosExemplar.setBounds(276, 62, 272, 50);
        ListaTodosExemplar.add(lblListarTodosExemplar);
        
        JButton btnVoltarLTEx = new JButton("");
        btnVoltarLTEx.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLTEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLTEx.setForeground(new Color(163, 5, 65));
        btnVoltarLTEx.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLTEx.setBackground(new Color(255, 217, 220));
        btnVoltarLTEx.setBounds(10, 11, 69, 30);
        ListaTodosExemplar.add(btnVoltarLTEx);
        
        tableLTEx = new JTable();
        tableLTEx.setFont(new Font("Century Gothic", Font.PLAIN, 18));

        DefaultTableModel tableModelLTEx = new DefaultTableModel(
            new Object[][]{},
            new String[] {
                "ISBN", "Número", "Edição", "Disponível", "Estado de conservação", "Ano de publicação"
            }
        );
        tableLTEx.setModel(tableModelLTEx);

        tableLTEx.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableLTEx.getColumnModel().getColumn(1).setPreferredWidth(20);
        tableLTEx.getColumnModel().getColumn(2).setPreferredWidth(20);
        tableLTEx.getColumnModel().getColumn(3).setPreferredWidth(60);

        JTableHeader headerLTEx = tableLTEx.getTableHeader();
        headerLTEx.setFont(new Font("Century Gothic", Font.BOLD, 20));
        headerLTEx.setForeground(Color.WHITE);
        headerLTEx.setBackground(new Color(241, 180, 181));
        tableLTEx.setFont(new Font("Century Gothic", Font.PLAIN, 17));

        JScrollPane scrollPaneLTEx = new JScrollPane(tableLTEx);
        scrollPaneLTEx.getViewport().setOpaque(false);
        scrollPaneLTEx.setOpaque(false);
        scrollPaneLTEx.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPaneLTEx.setBounds(25, 216, 746, 285);
        ListaTodosExemplar.add(scrollPaneLTEx);

        JButton btnListarTodosEx = new JButton("Listar");
        btnListarTodosEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExemplarDAO exDAO = new ExemplarDAO();
                ArrayList<Exemplar> listaTodosEx = exDAO.listarTodos();
                tableModelLTEx.setRowCount(0);
                for (Exemplar ex : listaTodosEx) {
                    String disponibilidade = "Não";
                    if (ex.getDisponibilidade()) {
                        disponibilidade = "Sim";
                    }
                    tableModelLTEx.addRow(new Object[]{ex.getISBN_fisico(), ex.getNumero(), ex.getEdicao(), disponibilidade, ex.getEstado_conservacao(), ex.getAno_publicacao()});
                }
            }
        });
        btnListarTodosEx.setForeground(new Color(115, 38, 52));
        btnListarTodosEx.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarTodosEx.setBackground(new Color(217, 180, 190));
        btnListarTodosEx.setBounds(320, 548, 147, 41);
        ListaTodosExemplar.add(btnListarTodosEx);
        
        JLabel lblNewLabel_20 = new JLabel("New label");
        lblNewLabel_20.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_20.setBounds(0, 0, 798, 600);
        ListaTodosExemplar.add(lblNewLabel_20);
        
        //EditaExemplar
        
        EditaExemplar = new JPanel();
        EditaExemplar.setBackground(new Color(255, 217, 220));
        contentPane.add(EditaExemplar, "EditaExemplar");
        EditaExemplar.setLayout(null);
        
        JLabel lblEExemplar = new JLabel("Editar Exemplar");
        lblEExemplar.setBounds(270, 64, 312, 50);
        lblEExemplar.setForeground(Color.WHITE);
        lblEExemplar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        EditaExemplar.add(lblEExemplar);
        
        JButton btnVoltarEEx = new JButton("");
        btnVoltarEEx.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarEEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarEEx.setBounds(10, 11, 69, 30);
        btnVoltarEEx.setForeground(new Color(163, 5, 65));
        btnVoltarEEx.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarEEx.setBackground(new Color(253, 181, 193));
        EditaExemplar.add(btnVoltarEEx);
        
        textFieldISBNEEx = new JTextField();
        textFieldISBNEEx.setVisible(false);
        EditaExemplar.add(textFieldISBNEEx);
        
        textFieldNumeroEEx = new JTextField();
        textFieldNumeroEEx.setVisible(false);
        EditaExemplar.add(textFieldNumeroEEx);
        
        JCheckBox chckbxDisponibilidadeEEx = new JCheckBox("Disponível");
        chckbxDisponibilidadeEEx.setBackground(new Color(217, 180, 190));
        chckbxDisponibilidadeEEx.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        chckbxDisponibilidadeEEx.setBounds(405, 242, 146, 42);
        EditaExemplar.add(chckbxDisponibilidadeEEx);
        
        JLabel lblEdicaoEEx = new JLabel("Edição:");
        lblEdicaoEEx.setBounds(188, 244, 122, 50);
        lblEdicaoEEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        EditaExemplar.add(lblEdicaoEEx);
        
        textFieldEdicaoEEx = new JTextField();
        textFieldEdicaoEEx.setBounds(292, 249, 94, 30);
        textFieldEdicaoEEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldEdicaoEEx.setColumns(10);
        EditaExemplar.add(textFieldEdicaoEEx);
        
        textFieldEdicaoEEx.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblAnoPublicacaoEEx = new JLabel("Ano de publicação:");
        lblAnoPublicacaoEEx.setBounds(188, 286, 277, 50);
        lblAnoPublicacaoEEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        EditaExemplar.add(lblAnoPublicacaoEEx);
        
        JYearChooser yearChooserAnoPublicacaoEEx = new JYearChooser();
        yearChooserAnoPublicacaoEEx.setBounds(500, 340, 77, 30);
        yearChooserAnoPublicacaoEEx.getSpinner().setFont(new Font("Century Gothic", Font.PLAIN, 20));
        EditaExemplar.add(yearChooserAnoPublicacaoEEx);
        
        JLabel lblEstadoConservacaoEEx = new JLabel("Estado de conservação:");
        lblEstadoConservacaoEEx.setBounds(188, 332, 341, 50);
        lblEstadoConservacaoEEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        EditaExemplar.add(lblEstadoConservacaoEEx);
        
        JRadioButton rdbtnNovoEEx = new JRadioButton("Novo");
        rdbtnNovoEEx.setBackground(new Color(217, 180, 190));
        rdbtnNovoEEx.setBounds(198, 377, 77, 35);
        rdbtnNovoEEx.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        EditaExemplar.add(rdbtnNovoEEx);
        
        JRadioButton rdbtnSeminovoEEx = new JRadioButton("Seminovo");
        rdbtnSeminovoEEx.setBackground(new Color(217, 180, 190));
        rdbtnSeminovoEEx.setBounds(292, 377, 122, 35);
        rdbtnSeminovoEEx.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        EditaExemplar.add(rdbtnSeminovoEEx);
        
        JRadioButton rdbtnAntigoEEx = new JRadioButton("Antigo");
        rdbtnAntigoEEx.setBackground(new Color(217, 180, 190));
        rdbtnAntigoEEx.setBounds(429, 377, 87, 35);
        rdbtnAntigoEEx.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        EditaExemplar.add(rdbtnAntigoEEx);

        ButtonGroup btnGrpEstadoConservacaoEEx = new ButtonGroup();
        btnGrpEstadoConservacaoEEx.add(rdbtnNovoEEx);
        btnGrpEstadoConservacaoEEx.add(rdbtnSeminovoEEx);
        btnGrpEstadoConservacaoEEx.add(rdbtnAntigoEEx);
        ActionListener aLEstadoConservacaoEEx = new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
            	estadoConservacaoEEx=((JRadioButton) e.getSource()).getText();
            }
        };
        rdbtnNovoEEx.addActionListener(aLEstadoConservacaoEEx);
        rdbtnSeminovoEEx.addActionListener(aLEstadoConservacaoEEx);
        rdbtnAntigoEEx.addActionListener(aLEstadoConservacaoEEx);
        
        JButton btnEditarEx = new JButton("Editar");
        btnEditarEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNEEx.getText();
        		String numero=textFieldNumeroEEx.getText();
        		String edicao=textFieldEdicaoEEx.getText();
        		long ano_publicação=yearChooserAnoPublicacaoEEx.getYear();
        		ArrayList<String> val=valParametrosExemplar(ISBN, numero, edicao, estadoConservacaoEEx);
        		if(val.isEmpty()) {
        			long numeroLong=Long.parseLong(textFieldNumeroEEx.getText());
        			long edicaoLong=Long.parseLong(textFieldEdicaoEEx.getText());
    				ExemplarDAO exDAO=new ExemplarDAO();
    				Exemplar ex=new Exemplar(ISBN, numeroLong, edicaoLong, chckbxDisponibilidadeEEx.isSelected(), estadoConservacaoEEx, ano_publicação);
        			int editouEx=exDAO.editar(ex);
    				if(editouEx>0) {
	                	txtAreaMsgSucesso.setText("");
            	        txtAreaMsgSucesso.append("Informações atualizadas com sucesso!" + "\n");
                		cardLayout.show(contentPane, "MensagemSucesso");
    				}else {
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não foi possível editar, houve algum erro!" + "\n");
            			telaErro="EditaExemplar";
                		cardLayout.show(contentPane, "MensagemErro");
    				}
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
            			txtAreaMsgErro.append(msg + "\n");
        			}
        			telaErro="EditaExemplar";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnEditarEx.setBounds(589, 479, 199, 41);
        btnEditarEx.setForeground(new Color(115, 38, 52));
        btnEditarEx.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnEditarEx.setBackground(new Color(217, 180, 190));
        EditaExemplar.add(btnEditarEx);
        
        JLabel lblNewLabel_21 = new JLabel("New label");
        lblNewLabel_21.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_21.setBounds(0, 0, 798, 600);
        EditaExemplar.add(lblNewLabel_21);
        
        //BuscaEditaExemplar
        
        BuscaEditaExemplar = new JPanel();
        BuscaEditaExemplar.setBackground(new Color(255, 217, 220));
        contentPane.add(BuscaEditaExemplar, "BuscaEditaExemplar");
        BuscaEditaExemplar.setLayout(null);
        
        JLabel lblBEExemplar = new JLabel("Editar Exemplar");
        lblBEExemplar.setBounds(266, 64, 287, 50);
        lblBEExemplar.setForeground(Color.WHITE);
        lblBEExemplar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        BuscaEditaExemplar.add(lblBEExemplar);
        
        JButton btnVoltarBEEx = new JButton("");
        btnVoltarBEEx.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarBEEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarBEEx.setBounds(10, 11, 69, 30);
        btnVoltarBEEx.setForeground(new Color(163, 5, 65));
        btnVoltarBEEx.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarBEEx.setBackground(new Color(255, 217, 220));
        BuscaEditaExemplar.add(btnVoltarBEEx);
        
        JLabel lblISBNBEEx = new JLabel("ISBN do Livro:");
        lblISBNBEEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNBEEx.setBounds(186, 257, 207, 32);
        BuscaEditaExemplar.add(lblISBNBEEx);
        
        textFieldISBNBEEx = new JTextField();
        textFieldISBNBEEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNBEEx.setColumns(10);
        textFieldISBNBEEx.setBounds(378, 253, 260, 30);
        BuscaEditaExemplar.add(textFieldISBNBEEx);
        
        textFieldISBNBEEx.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNBEEx.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumeroBEEx = new JLabel("Número do Exemplar:");
        lblNumeroBEEx.setBounds(186, 285, 287, 50);
        lblNumeroBEEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        BuscaEditaExemplar.add(lblNumeroBEEx);
        
        textFieldNumeroBEEx = new JTextField();
        textFieldNumeroBEEx.setBounds(472, 290, 119, 30);
        textFieldNumeroBEEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNumeroBEEx.setColumns(10);
        BuscaEditaExemplar.add(textFieldNumeroBEEx);

        textFieldNumeroBEEx.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnBuscarEEx = new JButton("Buscar");
        btnBuscarEEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNBEEx.getText();
        		String numero=textFieldNumeroBEEx.getText();
        		if(ISBN.length()==13 && !numero.isEmpty()) {
        			long numeroLong=Long.parseLong(numero);
        			ExemplarDAO exDAO=new ExemplarDAO();
            		Exemplar exb=exDAO.buscaISBNNum(ISBN, numeroLong);
            		if(exb!=null) {
            			textFieldISBNEEx.setText(ISBN);
            			textFieldNumeroEEx.setText(numero);
            			textFieldEdicaoEEx.setText(String.valueOf(exb.getEdicao()));
            			yearChooserAnoPublicacaoEEx.setYear((int)exb.getAno_publicacao());
            	        estadoConservacaoEEx=exb.getEstado_conservacao();
            	        if("Novo".equals(estadoConservacaoEEx)) {
            	        	rdbtnNovoEEx.setSelected(true);
            	        }else{
            	        	if("Seminovo".equals(estadoConservacaoEEx)) {
            	        		rdbtnSeminovoEEx.setSelected(true);
            	        	}else {
            	        		if("Antigo".equals(estadoConservacaoEEx)) {
                	        		rdbtnAntigoEEx.setSelected(true);
                	        	}
            	        	}
            	        }
            	        chckbxDisponibilidadeEEx.setSelected(exb.getDisponibilidade());
            	        cardLayout.show(contentPane, "EditaExemplar");
            		}else {
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não existe nenhum livro físico cadastrado com esse ISBN!" + "\n");
            			telaErro="BuscaEditaExemplar";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			txtAreaMsgErro.setText("");
        			txtAreaMsgErro.append("ISBN e número inválidos!" + "\n");
        			telaErro="BuscaEditaExemplar";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnBuscarEEx.setForeground(new Color(115, 38, 52));
        btnBuscarEEx.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarEEx.setBackground(new Color(217, 180, 190));
        btnBuscarEEx.setBounds(332, 482, 147, 41);
        BuscaEditaExemplar.add(btnBuscarEEx);
        
        JLabel lblNewLabel_22 = new JLabel("New label");
        lblNewLabel_22.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_22.setBounds(0, 0, 798, 600);
        BuscaEditaExemplar.add(lblNewLabel_22);
        
        //DeletaExemplar
        
        DeletaExemplar = new JPanel();
        DeletaExemplar.setBackground(new Color(255, 217, 220));
        contentPane.add(DeletaExemplar, "DeletaExemplar");
        DeletaExemplar.setLayout(null);
        
        JLabel lblDExemplar = new JLabel("Deletar Exemplar");
        lblDExemplar.setBounds(260, 63, 322, 50);
        lblDExemplar.setForeground(new Color(255, 255, 255));
        lblDExemplar.setFont(new Font("Sitka Small", Font.BOLD, 30));
        DeletaExemplar.add(lblDExemplar);
        
        JButton btnVoltarDEx = new JButton("");
        btnVoltarDEx.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarDEx.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarDEx.setBounds(10, 11, 69, 30);
        btnVoltarDEx.setForeground(new Color(163, 5, 65));
        btnVoltarDEx.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarDEx.setBackground(new Color(253, 181, 193));
        DeletaExemplar.add(btnVoltarDEx);
        
        JLabel lblISBNDEx = new JLabel("ISBN do Livro:");
        lblISBNDEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNDEx.setBounds(176, 268, 207, 32);
        DeletaExemplar.add(lblISBNDEx);
        
        textFieldISBNDEx = new JTextField();
        textFieldISBNDEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldISBNDEx.setColumns(10);
        textFieldISBNDEx.setBounds(372, 264, 260, 30);
        DeletaExemplar.add(textFieldISBNDEx);
        
        textFieldISBNDEx.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNDEx.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumeroDEx = new JLabel("Número do Exemplar:");
        lblNumeroDEx.setBounds(176, 298, 287, 50);
        lblNumeroDEx.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        DeletaExemplar.add(lblNumeroDEx);
        
        textFieldNumeroDEx = new JTextField();
        textFieldNumeroDEx.setBounds(463, 305, 119, 30);
        textFieldNumeroDEx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textFieldNumeroDEx.setColumns(10);
        DeletaExemplar.add(textFieldNumeroDEx);

        textFieldNumeroDEx.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnDeletarEx = new JButton("Deletar");
        btnDeletarEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String ISBN=textFieldISBNDEx.getText();
        		String numero=textFieldNumeroDEx.getText();
        		if(ISBN.length()==13 && !numero.isEmpty()) {
        			long numeroLong=Long.parseLong(numero);
        			ExemplarDAO exDAO=new ExemplarDAO();
            		Exemplar exb=exDAO.buscaISBNNum(ISBN, numeroLong);
            		if(exb!=null) {
            			int removeuEx=exDAO.remover(exb);
            			if(removeuEx>0) {
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Cadastro deletado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
            			}else {
                			txtAreaMsgErro.setText("");
                			txtAreaMsgErro.append("Não removeu!" + "\n");
                			telaErro="DeletaExemplar";
                    		cardLayout.show(contentPane, "MensagemErro");
            			}
            		}else {
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Não existe nenhum exemplar cadastrado com esses ISBN e número!" + "\n");
            			telaErro="DeletaExemplar";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
        		}else {
        			txtAreaMsgErro.setText("");
        			txtAreaMsgErro.append("ISBN e número inválidos!" + "\n");
        			telaErro="DeletaExemplar";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        btnDeletarEx.setForeground(new Color(115, 38, 52));
        btnDeletarEx.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnDeletarEx.setBackground(new Color(217, 180, 190));
        btnDeletarEx.setBounds(331, 486, 160, 41);
        DeletaExemplar.add(btnDeletarEx);
        
        JLabel lblNewLabel_23 = new JLabel("New label");
        lblNewLabel_23.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_23.setBounds(0, 0, 798, 600);
        DeletaExemplar.add(lblNewLabel_23);
        
        //            <<<<<<<<<<EMPRESTIMO>>>>>>>>>>
        
        // CadastraEmprestimo
        
        CadastroEmprestimo = new JPanel();
        CadastroEmprestimo.setBackground(new Color(255, 217, 220));
        contentPane.add(CadastroEmprestimo, "CadastroEmprestimo");
        CadastroEmprestimo.setLayout(null);
        
        JLabel lblCEmprestimo = new JLabel("Cadastrar Empréstimo");
        lblCEmprestimo.setForeground(Color.WHITE);
        lblCEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblCEmprestimo.setBounds(223, 58, 380, 50);
        CadastroEmprestimo.add(lblCEmprestimo);
        
        JButton btnVoltarCE = new JButton("");
        btnVoltarCE.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCE.setForeground(new Color(163, 5, 65));
        btnVoltarCE.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCE.setBackground(new Color(255, 217, 220));
        btnVoltarCE.setBounds(10, 11, 69, 30);
        CadastroEmprestimo.add(btnVoltarCE);
        
        JLabel lblCPFClienteE = new JLabel("CPF do Cliente:");
        lblCPFClienteE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFClienteE.setBounds(69, 180, 211, 50);
        CadastroEmprestimo.add(lblCPFClienteE);
        
        textFieldCPFClienteCE = new JTextField();
        textFieldCPFClienteCE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFClienteCE.setColumns(10);
        textFieldCPFClienteCE.setBounds(279, 185, 412, 30);
        CadastroEmprestimo.add(textFieldCPFClienteCE);
        
        textFieldCPFClienteCE.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFClienteCE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblISBNLivroCE = new JLabel("ISBN do Exemplar:");
        lblISBNLivroCE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNLivroCE.setBounds(69, 222, 261, 50);
        CadastroEmprestimo.add(lblISBNLivroCE);
        
        textFieldISBNLivroCE = new JTextField();
        textFieldISBNLivroCE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldISBNLivroCE.setColumns(10);
        textFieldISBNLivroCE.setBounds(318, 227, 353, 30);
        CadastroEmprestimo.add(textFieldISBNLivroCE);
        
        textFieldISBNLivroCE.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNLivroCE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblNumExemplarCE = new JLabel("Número do Exemplar:");
        lblNumExemplarCE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumExemplarCE.setBounds(69, 265, 312, 50);
        CadastroEmprestimo.add(lblNumExemplarCE);
        
        textFieldNumExemplarCE = new JTextField();
        textFieldNumExemplarCE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldNumExemplarCE.setColumns(10);
        textFieldNumExemplarCE.setBounds(357, 270, 134, 30);
        CadastroEmprestimo.add(textFieldNumExemplarCE);
        
        textFieldNumExemplarCE.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblCPFFuncionarioCE = new JLabel("CPF do Funcionário:");
        lblCPFFuncionarioCE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFFuncionarioCE.setBounds(69, 311, 261, 50);
        CadastroEmprestimo.add(lblCPFFuncionarioCE);
        
        textFieldCPFFuncionarioCE = new JTextField();
        textFieldCPFFuncionarioCE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFFuncionarioCE.setColumns(10);
        textFieldCPFFuncionarioCE.setBounds(333, 316, 358, 30);
        CadastroEmprestimo.add(textFieldCPFFuncionarioCE);
        
        textFieldCPFFuncionarioCE.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFFuncionarioCE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataFimCE = new JLabel("Data da entrega máxima:");
        lblDataFimCE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataFimCE.setBounds(69, 357, 353, 50);
        CadastroEmprestimo.add(lblDataFimCE);
        
        dateChooserDataFimCE = new JDateChooser();
        dateChooserDataFimCE.setBounds(399, 357, 211, 35);
        CadastroEmprestimo.add(dateChooserDataFimCE);
        
        JLabel lblTermoCompromissoCE= new JLabel("Termo de Compromisso:");
        lblTermoCompromissoCE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblTermoCompromissoCE.setBounds(69, 403, 353, 50);
        CadastroEmprestimo.add(lblTermoCompromissoCE);  

        JScrollPane scrollPaneTermoCompromissoCE = new JScrollPane();
        scrollPaneTermoCompromissoCE.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        scrollPaneTermoCompromissoCE.setBounds(69, 447, 493, 57);
        CadastroEmprestimo.add(scrollPaneTermoCompromissoCE);
        
        JTextArea textAreaTermoCompromissoCE = new JTextArea();
        scrollPaneTermoCompromissoCE.setViewportView(textAreaTermoCompromissoCE);
        
        textAreaTermoCompromissoCE.addKeyListener(new KeyListener() {
            final int maxCharacters=500;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textAreaTermoCompromissoCE.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnCadastrarE = new JButton("Cadastrar");
        
        btnCadastrarE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpfCliente = textFieldCPFClienteCE.getText();
        		String isbn = textFieldISBNLivroCE.getText();
        		String numeroString=textFieldNumExemplarCE.getText();
        		Date data=new Date();
    			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    			String horaString = sdf.format(new java.util.Date());
    			Time hora = Time.valueOf(horaString);
        		String cpfFuncionario = textFieldCPFFuncionarioCE.getText();
        		java.util.Date dataFim=dateChooserDataFimCE.getDate();
                String termoCompromisso = textAreaTermoCompromissoCE.getText();
        		ArrayList<String> val=valParametrosEmprestimo(cpfCliente, isbn, numeroString, data, hora, cpfFuncionario, dataFim, termoCompromisso);
        		if(val.isEmpty()){
        			long numero=Long.parseLong(numeroString);
        			ArrayList<String> val2=valParametrosEmprestimo2(cpfCliente, isbn, numero, cpfFuncionario);
        			if(val2.isEmpty()) {
        				EmprestimoDAO eDAO = new EmprestimoDAO();
        				Emprestimo eb = eDAO.buscaCPFISBNNumDataHora(cpfCliente, isbn, numero, data, hora);
        				if(eb == null) {
        					Emprestimo em = new Emprestimo(cpfCliente, isbn, numero, data, hora, cpfFuncionario, dataFim, termoCompromisso);
        	                
        	                int inseriuEmprestimo = eDAO.inserir(em);
        	                
        	                if(inseriuEmprestimo == 1){
        	                	txtAreaMsgSucesso.setText("");
                    	        txtAreaMsgSucesso.append("Empréstimo cadastrado com sucesso!" + "\n");
                        		cardLayout.show(contentPane, "MensagemSucesso");
        	                	ExemplarDAO exDAO=new ExemplarDAO();
        	                	int mudou=exDAO.mudarDisponibilidade(isbn, numero);
        	                	if(mudou==1) {
        	                		System.out.println("Este exemplar não está mais disponível agora!");
        	                	}
        	                }else {
                    			txtAreaMsgErro.setText("");
                    			txtAreaMsgErro.append("Não inseriu!" + "\n");
                    			telaErro="CadastroEmprestimo";
                        		cardLayout.show(contentPane, "MensagemErro");
        	                }
        				}else {
                			txtAreaMsgErro.setText("");
                			txtAreaMsgErro.append("Empréstimo existente!" + "\n");
                			telaErro="CadastroEmprestimo";
                    		cardLayout.show(contentPane, "MensagemErro");
        				}
        			}else {
        				txtAreaMsgErro.setText("");
            			for(String msg:val2) {
            				txtAreaMsgErro.append(msg + "\n");  
            			}
            			telaErro="CadastroEmprestimo";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
        		}else {
        			txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");  
        			}
        			telaErro="CadastroEmprestimo";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        
        btnCadastrarE.setForeground(new Color(115, 38, 52));
        btnCadastrarE.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnCadastrarE.setBackground(new Color(217, 180, 190));
        btnCadastrarE.setBounds(591, 476, 197, 50);
        CadastroEmprestimo.add(btnCadastrarE);
        
        JLabel lblNewLabel_24 = new JLabel("New label");
        lblNewLabel_24.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_24.setBounds(0, 0, 798, 600);
        CadastroEmprestimo.add(lblNewLabel_24);

        // ListaEmprestimo
        
        ListaEmprestimo = new JPanel();
        ListaEmprestimo.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaEmprestimo, "ListaEmprestimo");
        ListaEmprestimo.setLayout(null);
        
        JLabel lblListarEmprestimo = new JLabel("Listar Empréstimo");
        lblListarEmprestimo.setForeground(Color.WHITE);
        lblListarEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarEmprestimo.setBounds(251, 59, 319, 50);
        ListaEmprestimo.add(lblListarEmprestimo);
        
        JButton btnVoltarLE = new JButton("");
        btnVoltarLE.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLE.setForeground(new Color(163, 5, 65));
        btnVoltarLE.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLE.setBackground(new Color(253, 181, 193));
        btnVoltarLE.setBounds(10, 11, 69, 30);
        ListaEmprestimo.add(btnVoltarLE);
        
        JLabel lblCPFClienteLE = new JLabel("CPF do Cliente:");
        lblCPFClienteLE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFClienteLE.setBounds(167, 182, 211, 32);
        ListaEmprestimo.add(lblCPFClienteLE);
        
        textFieldCPFClienteLE = new JTextField();
        textFieldCPFClienteLE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFClienteLE.setColumns(10);
        textFieldCPFClienteLE.setBounds(366, 178, 235, 30);
        ListaEmprestimo.add(textFieldCPFClienteLE);
        
        textFieldCPFClienteLE.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFClienteLE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblISBNLivroLE = new JLabel("ISBN do Exemplar:");
        lblISBNLivroLE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNLivroLE.setBounds(167, 219, 274, 32);
        ListaEmprestimo.add(lblISBNLivroLE);
        
        textFieldISBNLivroLE = new JTextField();
        textFieldISBNLivroLE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldISBNLivroLE.setColumns(10);
        textFieldISBNLivroLE.setBounds(417, 215, 206, 30);
        ListaEmprestimo.add(textFieldISBNLivroLE);
        
        textFieldISBNLivroLE.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNLivroLE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        JLabel lblNumeroExemplarLE = new JLabel("Número do Exemplar:");
        lblNumeroExemplarLE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumeroExemplarLE.setBounds(167, 258, 289, 32);
        ListaEmprestimo.add(lblNumeroExemplarLE);
        
        textFieldNumeroExemplarLE = new JTextField();
        textFieldNumeroExemplarLE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldNumeroExemplarLE.setColumns(10);
        textFieldNumeroExemplarLE.setBounds(451, 254, 178, 30);
        ListaEmprestimo.add(textFieldNumeroExemplarLE);
        
        textFieldNumeroExemplarLE.addKeyListener(new KeyListener() {
        	@Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataLE = new JLabel("Data:");
        lblDataLE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataLE.setBounds(167, 293, 188, 32);
        ListaEmprestimo.add(lblDataLE);
        
        JDateChooser dateChooserDataLE = new JDateChooser();
        dateChooserDataLE.setBounds(244, 290, 211, 35);
        ListaEmprestimo.add(dateChooserDataLE);
        
        JLabel lblHoraLE = new JLabel("Hora:");
        lblHoraLE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblHoraLE.setBounds(167, 335, 188, 32);
        ListaEmprestimo.add(lblHoraLE);
        
        try {
            MaskFormatter mascaraHora = new MaskFormatter("##:##:##");
            textFieldHoraLE = new JFormattedTextField(mascaraHora);
        } catch (ParseException e) {
            e.printStackTrace();
            textFieldHoraLE = new JFormattedTextField();
        }
        
        textFieldHoraLE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldHoraLE.setColumns(10);
        textFieldHoraLE.setBounds(244, 331, 235, 30);
        ListaEmprestimo.add(textFieldHoraLE);

        tableLE = new JTable();
        DefaultTableModel tableModelLE = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "CPF Funcionário", "Data de fim", "Termo de compromisso"
                }
        );
        tableLE.setModel(tableModelLE);
        JTableHeader headerLE = tableLE.getTableHeader();
        headerLE.setFont(new Font("Century Gothic", Font.BOLD, 20));
        headerLE.setForeground(Color.WHITE);
        headerLE.setBackground(new Color( 241, 180, 181));

        JScrollPane scrollPaneLE = new JScrollPane(tableLE);
        scrollPaneLE.getViewport().setOpaque(false);
        scrollPaneLE.setOpaque(false);
        scrollPaneLE.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPaneLE.setBounds(66, 429, 664, 85);
        ListaEmprestimo.add(scrollPaneLE);

        JButton btnListarE = new JButton("Listar");
        btnListarE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpfCliente = textFieldCPFClienteLE.getText();
        		String isbn = textFieldISBNLivroLE.getText();
        		String numeroString=textFieldNumeroExemplarLE.getText();
        		Date data = dateChooserDataLE.getDate();
                String horaString = textFieldHoraLE.getText();
                ArrayList<String> val=valParametrosBuscaEditaE(cpfCliente, isbn, numeroString, data, horaString);
                if(val.isEmpty()) {
                	SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                    java.util.Date utilDate = null;
    				try {
    					utilDate = formatoHora.parse(horaString);
    				} catch (ParseException e1) {
    					e1.printStackTrace();
    				}
                    Time hora = new Time(utilDate.getTime());
                    long numero=Long.parseLong(numeroString);
        			EmprestimoDAO eDAO = new EmprestimoDAO();
    				Emprestimo eb = eDAO.buscaCPFISBNNumDataHora(cpfCliente, isbn, numero, data, hora);
            		if(eb != null) {
            			DefaultTableModel modelLE=(DefaultTableModel) tableLE.getModel();
            			modelLE.setRowCount(0);
            			modelLE.addRow(new Object[]{eb.getCPF_Funcionario(), eb.toStringDataFim(), eb.getTermoCompromisso()});
            		}else {
            			DefaultTableModel modelLE=(DefaultTableModel) tableLE.getModel();
            			modelLE.setRowCount(0);
            			txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Empréstimo inexistente!" + "\n");
            			telaErro="ListaEmprestimo";
                		cardLayout.show(contentPane, "MensagemErro");
            		}
                }else {
        			DefaultTableModel modelLE=(DefaultTableModel) tableLE.getModel();
        			modelLE.setRowCount(0);
    				txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");  
        			}
        			telaErro="ListaEmprestimo";
            		cardLayout.show(contentPane, "MensagemErro");
                }
        	}
        });
        
        btnListarE.setForeground(new Color(115, 38, 52));
        btnListarE.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarE.setBackground(new Color(217, 180, 190));
        btnListarE.setBounds(336, 548, 147, 41);
        ListaEmprestimo.add(btnListarE);
        
        JLabel lblNewLabel_25 = new JLabel("New label");
        lblNewLabel_25.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_25.setBounds(0, 0, 798, 600);
        ListaEmprestimo.add(lblNewLabel_25);
        
        //ListaTodosEmprestimo
        
        ListaTodosEmprestimo = new JPanel();
        ListaTodosEmprestimo.setBackground(new Color(255, 217, 220));
        contentPane.add(ListaTodosEmprestimo, "ListaTodosEmprestimo");
        ListaTodosEmprestimo.setLayout(null);
        
        JLabel lblListarTodosEmprestimo = new JLabel("Listar Empréstimo");
        lblListarTodosEmprestimo.setForeground(Color.WHITE);
        lblListarTodosEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblListarTodosEmprestimo.setBounds(257, 60, 322, 50);
        ListaTodosEmprestimo.add(lblListarTodosEmprestimo);
        
        JButton btnVoltarLTE = new JButton("");
        btnVoltarLTE.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarLTE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarLTE.setForeground(new Color(163, 5, 65));
        btnVoltarLTE.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarLTE.setBackground(new Color(253, 181, 193));
        btnVoltarLTE.setBounds(10, 11, 69, 30);
        ListaTodosEmprestimo.add(btnVoltarLTE);
        
        tableLTE=new JTable();
        tableLTE.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        DefaultTableModel tableModelLTE=new DefaultTableModel(
        	new Object[][]{},
        	new String[] {
        		"CPF Cliente", "ISBN", "Data", "Hora", "CPF Funcionário", "Data de fim"
        	}
        );
        tableLTE.setModel(tableModelLTE);
        
        JTableHeader headerLTE=tableLTE.getTableHeader();
        headerLTE.setFont(new Font("Century Gothic", Font.BOLD, 20));
        headerLTE.setForeground(Color.WHITE);
        headerLTE.setBackground(new Color( 241, 180, 181));
        tableLTE.setFont(new Font("Century Gothic", Font.PLAIN, 17));
       
        JScrollPane scrollPaneLTE = new JScrollPane();
        scrollPaneLTE.getViewport().setOpaque(false);
        scrollPaneLTE.setOpaque(false);
        scrollPaneLTE.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPaneLTE.setBounds(25, 216, 746, 285);
        scrollPaneLTE.setViewportView(tableLTE);
        ListaTodosEmprestimo.add(scrollPaneLTE);
        
        JButton btnListarTodosE = new JButton("Listar");
        btnListarTodosE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EmprestimoDAO eDAO = new EmprestimoDAO();
                ArrayList<Emprestimo> listaTodosE = eDAO.listarTodos();
                tableModelLTE.setRowCount(0);
                for (Emprestimo em : listaTodosE) {
                    tableModelLTE.addRow(new Object[]{em.getCPF_Cliente(), em.getISBN_Livro(), em.getData(), em.getHora(), em.getCPF_Funcionario(), em.toStringDataFim()});
                }
        	}
        });
        btnListarTodosE.setForeground(new Color(115, 38, 52));
        btnListarTodosE.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnListarTodosE.setBackground(new Color(217, 180, 190));
        btnListarTodosE.setBounds(312, 548, 147, 41);
        ListaTodosEmprestimo.add(btnListarTodosE);
        
        JLabel lblNewLabel_26 = new JLabel("New label");
        lblNewLabel_26.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_26.setBounds(0, 0, 798, 600);
        ListaTodosEmprestimo.add(lblNewLabel_26);
        
        // Edita Emprestimo
        
        EditaEmprestimo = new JPanel();
        EditaEmprestimo.setBackground(new Color(255, 217, 220));
        contentPane.add(EditaEmprestimo, "EditaEmprestimo");
        EditaEmprestimo.setLayout(null);
        
        JLabel lblEEmprestimo = new JLabel("Editar Empréstimo");
        lblEEmprestimo.setForeground(Color.WHITE);
        lblEEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblEEmprestimo.setBounds(249, 61, 327, 50);
        EditaEmprestimo.add(lblEEmprestimo);
        
        JButton btnVoltarEE = new JButton("");
        btnVoltarEE.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarEE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarEE.setForeground(new Color(163, 5, 65));
        btnVoltarEE.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarEE.setBackground(new Color(253, 181, 193));
        btnVoltarEE.setBounds(10, 11, 69, 30);
        EditaEmprestimo.add(btnVoltarEE);
        
        JLabel lblCPFFuncionarioEE = new JLabel("CPF do Funcionário:");
        lblCPFFuncionarioEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFFuncionarioEE.setBounds(73, 203, 296, 50);
        EditaEmprestimo.add(lblCPFFuncionarioEE);
        
        textFieldCPFFuncEE = new JTextField();
        textFieldCPFFuncEE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFFuncEE.setColumns(10);
        textFieldCPFFuncEE.setBounds(336, 208, 367, 30);
        EditaEmprestimo.add(textFieldCPFFuncEE);
        
        textFieldCPFFuncEE.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFFuncEE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataFimEE = new JLabel("Data da entrega máxima:");
        lblDataFimEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataFimEE.setBounds(73, 251, 348, 50);
        EditaEmprestimo.add(lblDataFimEE);
        
        dateChooserDataFimEE = new JDateChooser();
        dateChooserDataFimEE.setBounds(402, 254, 211, 35);
        EditaEmprestimo.add(dateChooserDataFimEE);
        
        JLabel lblTermoCompromissoEE = new JLabel("Termo de Compromisso:");
        lblTermoCompromissoEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblTermoCompromissoEE.setBounds(73, 300, 386, 50);
        EditaEmprestimo.add(lblTermoCompromissoEE);
        
        JScrollPane scrollPaneTermoCompromissoEE = new JScrollPane();
        scrollPaneTermoCompromissoEE.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        scrollPaneTermoCompromissoEE.setBounds(73, 340, 493, 81);
        EditaEmprestimo.add(scrollPaneTermoCompromissoEE);
        
        JTextArea textAreaTermoCompromissoEE = new JTextArea();
        scrollPaneTermoCompromissoEE.setViewportView(textAreaTermoCompromissoEE);
        
        textAreaTermoCompromissoEE.addKeyListener(new KeyListener() {
            final int maxCharacters=500;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textAreaTermoCompromissoEE.getText().length() >= maxCharacters) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JButton btnEditarE = new JButton("Editar");
        
        btnEditarE.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		String cpfCliente = textFieldCPFClienteBEE.getText();
    			String isbn = textFieldISBNLivroBEE.getText();
    			String numeroString=textFieldNumeroExemplarBEE.getText();
    			Date data=dateChooserDataBEE.getDate();
    			String horaString=textFieldHoraBEE.getText();
    			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    		    java.util.Date utilDate = null;
				try {
					utilDate = formatoHora.parse(horaString);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Time hora = new Time(utilDate.getTime());
    			Date dataFim=dateChooserDataFimEE.getDate();
    			String cpfFunc = textFieldCPFFuncEE.getText();
    	        String termoCompromisso = textAreaTermoCompromissoEE.getText();
    			ArrayList<String> val=valParametrosEmprestimo(cpfCliente, isbn, numeroString, data, hora, cpfFunc, dataFim, termoCompromisso);
        		if(val.isEmpty()) {
        			long numero=Long.parseLong(numeroString);
        			ArrayList<String> val2=valParametrosEE2(cpfFunc);
        			if(val2.isEmpty()) {
        				Emprestimo em = new Emprestimo(cpfCliente, isbn, numero, data, hora, cpfFunc, dataFim, termoCompromisso);
                	    EmprestimoDAO eDAO = new EmprestimoDAO();
                	    int editouEmprestimo = eDAO.editar(em);
                	    if(editouEmprestimo > 0){
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Informações atualizadas com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
               	        }else {
            				txtAreaMsgErro.setText("");
                			txtAreaMsgErro.append("Não editou, houve algum erro!" + "\n");
                			telaErro="EditaEmprestimo";
                    		cardLayout.show(contentPane, "MensagemErro");
               	        }
        			}else {
        				txtAreaMsgErro.setText("");
            			for(String msg:val2) {
            				txtAreaMsgErro.append(msg + "\n");  
            			}
            			telaErro="EditaEmprestimo";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
        		}else {
    				txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");  
        			}
        			telaErro="EditaEmprestimo";
            		cardLayout.show(contentPane, "MensagemErro");
        		}
        	}
        });
        
        btnEditarE.setForeground(new Color(115, 38, 52));
        btnEditarE.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnEditarE.setBackground(new Color(217, 180, 190));
        btnEditarE.setBounds(631, 474, 157, 50);
        EditaEmprestimo.add(btnEditarE);        
        
        JLabel lblNewLabel_27 = new JLabel("New label");
        lblNewLabel_27.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_27.setBounds(0, 0, 798, 600);
        EditaEmprestimo.add(lblNewLabel_27);
        
        // Busca Edita Emprestimo
        
        BuscaEditaEmprestimo = new JPanel();
        BuscaEditaEmprestimo.setBackground(new Color(255, 217, 220));
        contentPane.add(BuscaEditaEmprestimo, "BuscaEditaEmprestimo");
        BuscaEditaEmprestimo.setLayout(null);
        
        JLabel lblBEEmprestimo = new JLabel("Editar Empréstimo");
        lblBEEmprestimo.setForeground(Color.WHITE);
        lblBEEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblBEEmprestimo.setBounds(254, 61, 352, 50);
        BuscaEditaEmprestimo.add(lblBEEmprestimo);
        
        JButton btnVoltarBEE = new JButton("");
        btnVoltarBEE.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarBEE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarBEE.setForeground(new Color(163, 5, 65));
        btnVoltarBEE.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarBEE.setBackground(new Color(255, 217, 220));
        btnVoltarBEE.setBounds(10, 11, 69, 30);
        BuscaEditaEmprestimo.add(btnVoltarBEE);
        
        JLabel lblCPFClienteBEE = new JLabel("CPF do Cliente:");
        lblCPFClienteBEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFClienteBEE.setBounds(144, 208, 211, 32);
        BuscaEditaEmprestimo.add(lblCPFClienteBEE);
        
        textFieldCPFClienteBEE = new JTextField();
        textFieldCPFClienteBEE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFClienteBEE.setColumns(10);
        textFieldCPFClienteBEE.setBounds(342, 204, 275, 30);
        BuscaEditaEmprestimo.add(textFieldCPFClienteBEE);
        
        textFieldCPFClienteBEE.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFClienteBEE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblISBNLivroBEE = new JLabel("ISBN do Exemplar:");
        lblISBNLivroBEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNLivroBEE.setBounds(144, 245, 264, 32);
        BuscaEditaEmprestimo.add(lblISBNLivroBEE);
        
        textFieldISBNLivroBEE = new JTextField();
        textFieldISBNLivroBEE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldISBNLivroBEE.setColumns(10);
        textFieldISBNLivroBEE.setBounds(392, 241, 225, 30);
        BuscaEditaEmprestimo.add(textFieldISBNLivroBEE);
        
        textFieldISBNLivroBEE.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNLivroBEE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        JLabel lblNumeroExemplarBEE = new JLabel("Número do Exemplar:");
        lblNumeroExemplarBEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumeroExemplarBEE.setBounds(144, 282, 328, 32);
        BuscaEditaEmprestimo.add(lblNumeroExemplarBEE);
        
        textFieldNumeroExemplarBEE = new JTextField();
        textFieldNumeroExemplarBEE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldNumeroExemplarBEE.setColumns(10);
        textFieldNumeroExemplarBEE.setBounds(429, 278, 200, 30);
        BuscaEditaEmprestimo.add(textFieldNumeroExemplarBEE);
        
        textFieldNumeroExemplarBEE.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataBEE = new JLabel("Data:");
        lblDataBEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataBEE.setBounds(144, 325, 91, 32);
        BuscaEditaEmprestimo.add(lblDataBEE);
        
        dateChooserDataBEE = new JDateChooser();
        dateChooserDataBEE.setBounds(223, 319, 211, 35);
        BuscaEditaEmprestimo.add(dateChooserDataBEE);
        
        JLabel lblHoraBEE = new JLabel("Hora:");
        lblHoraBEE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblHoraBEE.setBounds(144, 361, 188, 32);
        BuscaEditaEmprestimo.add(lblHoraBEE);

        try {
            MaskFormatter mascaraHora = new MaskFormatter("##:##:##");
            textFieldHoraBEE = new JFormattedTextField(mascaraHora);
        } catch (ParseException e) {
            e.printStackTrace();
            textFieldHoraBEE = new JFormattedTextField();
        }

        textFieldHoraBEE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldHoraBEE.setColumns(10);
        textFieldHoraBEE.setBounds(227, 361, 235, 30);
        BuscaEditaEmprestimo.add(textFieldHoraBEE);
        
        JButton btnBuscarEE = new JButton("Buscar");
        btnBuscarEE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpfCliente = textFieldCPFClienteBEE.getText();
        		String isbn = textFieldISBNLivroBEE.getText();
        		String numeroString=textFieldNumeroExemplarBEE.getText();
        		Date data=dateChooserDataBEE.getDate();
    			String horaString = textFieldHoraBEE.getText();
    			ArrayList<String> val=valParametrosBuscaEditaE(cpfCliente, isbn, numeroString, data, horaString);
    			if(val.isEmpty()) {
    				SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        		    java.util.Date utilDate = null;
    				try {
    					utilDate = formatoHora.parse(horaString);
    				} catch (ParseException e1) {
    					e1.printStackTrace();
    				}
    				Time hora = new Time(utilDate.getTime());
    				long numero=Long.parseLong(numeroString);
        			EmprestimoDAO eDAO = new EmprestimoDAO();
        			Emprestimo eb = eDAO.buscaCPFISBNNumDataHora(cpfCliente, isbn, numero, data, hora);
        			if(eb != null) {
        				textFieldCPFFuncEE.setText(eb.getCPF_Funcionario());
        				dateChooserDataFimEE.setDate(data);
        				textAreaTermoCompromissoEE.setText(eb.getTermoCompromisso());
        				cardLayout.show(contentPane, "EditaEmprestimo");
        			}else {
        				txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Empréstimo inexistente!" + "\n"); 
            			telaErro="BuscaEditaEmprestimo";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
    			}else {
    				txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");  
        			}
        			telaErro="BuscaEditaEmprestimo";
            		cardLayout.show(contentPane, "MensagemErro");
    			}
        	}
        });
        
        btnBuscarEE.setForeground(new Color(115, 38, 52));
        btnBuscarEE.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarEE.setBackground(new Color(217, 180, 190));
        btnBuscarEE.setBounds(349, 482, 147, 41);
        BuscaEditaEmprestimo.add(btnBuscarEE);
        
        JLabel lblNewLabel_28 = new JLabel("New label");
        lblNewLabel_28.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_28.setBounds(0, 0, 798, 600);
        BuscaEditaEmprestimo.add(lblNewLabel_28);
        
        // Deleta Emprestimo
        
        DeletaEmprestimo = new JPanel();
        DeletaEmprestimo.setBackground(new Color(255, 217, 220));
        contentPane.add(DeletaEmprestimo, "DeletaEmprestimo");
        DeletaEmprestimo.setLayout(null);
        
        JLabel lblDEmprestimo = new JLabel("Deletar Empréstimo");
        lblDEmprestimo.setForeground(Color.WHITE);
        lblDEmprestimo.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblDEmprestimo.setBounds(243, 57, 361, 50);
        DeletaEmprestimo.add(lblDEmprestimo);
        
        JButton btnVoltarDE = new JButton("");
        btnVoltarDE.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarDE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarDE.setForeground(new Color(163, 5, 65));
        btnVoltarDE.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarDE.setBackground(new Color(255, 217, 220));
        btnVoltarDE.setBounds(10, 11, 69, 30);
        DeletaEmprestimo.add(btnVoltarDE);
        
        JLabel lblCPFClienteDE = new JLabel("CPF do Cliente:");
        lblCPFClienteDE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblCPFClienteDE.setBounds(180, 213, 227, 32);
        DeletaEmprestimo.add(lblCPFClienteDE);
        
        textFieldCPFClienteDE = new JTextField();
        textFieldCPFClienteDE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldCPFClienteDE.setColumns(10);
        textFieldCPFClienteDE.setBounds(380, 209, 235, 30);
        DeletaEmprestimo.add(textFieldCPFClienteDE);
        
        textFieldCPFClienteDE.addKeyListener(new KeyListener() {
            final int maxCharacters=11;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldCPFClienteDE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblISBNLivroDE = new JLabel("ISBN do Exemplar:");
        lblISBNLivroDE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblISBNLivroDE.setBounds(180, 250, 269, 32);
        DeletaEmprestimo.add(lblISBNLivroDE);
        
        textFieldISBNLivroDE = new JTextField();
        textFieldISBNLivroDE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldISBNLivroDE.setColumns(10);
        textFieldISBNLivroDE.setBounds(428, 250, 211, 30);
        DeletaEmprestimo.add(textFieldISBNLivroDE);
        
        textFieldISBNLivroDE.addKeyListener(new KeyListener() {
            final int maxCharacters=13;
            @Override
            public void keyTyped(KeyEvent e) {
                if (textFieldISBNLivroDE.getText().length() >= maxCharacters) {
                    e.consume();
                }
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        JLabel lblNumeroExemplarDE = new JLabel("Número do Exemplar:");
        lblNumeroExemplarDE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblNumeroExemplarDE.setBounds(180, 293, 314, 32);
        DeletaEmprestimo.add(lblNumeroExemplarDE);
        
        textFieldNumeroExemplarDE = new JTextField();
        textFieldNumeroExemplarDE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldNumeroExemplarDE.setColumns(10);
        textFieldNumeroExemplarDE.setBounds(469, 289, 180, 30);
        DeletaEmprestimo.add(textFieldNumeroExemplarDE);
        
        textFieldNumeroExemplarDE.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caractere = e.getKeyChar();
                if (!Character.isDigit(caractere)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JLabel lblDataDE = new JLabel("Data:");
        lblDataDE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblDataDE.setBounds(180, 336, 93, 32);
        DeletaEmprestimo.add(lblDataDE);
        
        dateChooserDataDE = new JDateChooser();
        dateChooserDataDE.setBounds(253, 333, 211, 35);
        DeletaEmprestimo.add(dateChooserDataDE);
        
        JLabel lblHoraDE = new JLabel("Hora:");
        lblHoraDE.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblHoraDE.setBounds(180, 379, 188, 32);
        DeletaEmprestimo.add(lblHoraDE);

        try {
            MaskFormatter mascaraHora = new MaskFormatter("##:##:##");
            textFieldHoraDE = new JFormattedTextField(mascaraHora);
        } catch (ParseException e) {
            e.printStackTrace();
            textFieldHoraDE = new JFormattedTextField();
        }

        textFieldHoraDE.setFont(new Font("Dialog", Font.PLAIN, 20));
        textFieldHoraDE.setColumns(10);
        textFieldHoraDE.setBounds(259, 375, 235, 30);
        DeletaEmprestimo.add(textFieldHoraDE);

        JButton btnDeletarE = new JButton("Deletar");
        
        btnDeletarE.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpfCliente = textFieldCPFClienteDE.getText();
        		String isbn = textFieldISBNLivroDE.getText();
        		String numeroString=textFieldNumeroExemplarDE.getText();
        		Date data = dateChooserDataDE.getDate();
                String horaString = textFieldHoraDE.getText();
                ArrayList<String> val=valParametrosBuscaEditaE(cpfCliente, isbn, numeroString, data, horaString);
                if(val.isEmpty()) {
                	SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                    java.util.Date utilDate = null;
					try {
						utilDate = formatoHora.parse(horaString);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
                    Time hora = new Time(utilDate.getTime());
        			long numero=Long.parseLong(numeroString);
        			EmprestimoDAO eDAO = new EmprestimoDAO();
    				Emprestimo em = eDAO.buscaCPFISBNNumDataHora(cpfCliente, isbn, numero, data, hora);
    				if(em != null) {
    					int removeuEmprestimo = eDAO.remover(em);
    					if(removeuEmprestimo == 1) {
    	                	txtAreaMsgSucesso.setText("");
                	        txtAreaMsgSucesso.append("Cadastro deletado com sucesso!" + "\n");
                    		cardLayout.show(contentPane, "MensagemSucesso");
    					} else {
            				txtAreaMsgErro.setText("");
                			txtAreaMsgErro.append("Não removeu o cadastro deste empréstimo, houve algum erro!" + "\n"); 
                			telaErro="DeletaEmprestimo";
                    		cardLayout.show(contentPane, "MensagemErro");
    					}
    				} else {
        				txtAreaMsgErro.setText("");
            			txtAreaMsgErro.append("Empréstimo inexistente!" + "\n"); 
            			telaErro="DeletaEmprestimo";
                		cardLayout.show(contentPane, "MensagemErro");
        			}
    			}else {
    				txtAreaMsgErro.setText("");
        			for(String msg:val) {
        				txtAreaMsgErro.append(msg + "\n");  
        			}
        			telaErro="DeletaEmprestimo";
            		cardLayout.show(contentPane, "MensagemErro");
    			}
        	}
        });
        
        btnDeletarE.setForeground(new Color(115, 38, 52));
        btnDeletarE.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnDeletarE.setBackground(new Color(217, 180, 190));
        btnDeletarE.setBounds(328, 482, 166, 41);
        DeletaEmprestimo.add(btnDeletarE);   
        
        JLabel lblNewLabel_29 = new JLabel("New label");
        lblNewLabel_29.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas CRUD.png")));
        lblNewLabel_29.setBounds(0, 0, 798, 600);
        DeletaEmprestimo.add(lblNewLabel_29);
        
        //         <<<<<<<<<<<<CONSULTAS>>>>>>>>>>>>
        
        //ConsultaEF
        
        ConsultaEF = new JPanel();
        ConsultaEF.setBackground(new Color(255, 221, 222));
        contentPane.add(ConsultaEF, "ConsultaEF");
        ConsultaEF.setLayout(null);
        
        JLabel lblConsultaEF = new JLabel("Empréstimos por Funcionário");
        lblConsultaEF.setForeground(new Color(255, 255, 255));
        lblConsultaEF.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblConsultaEF.setBounds(170, 59, 503, 50);
        ConsultaEF.add(lblConsultaEF);
        
        JButton btnVoltarCEF = new JButton("");
        btnVoltarCEF.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCEF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCEF.setBackground(new Color(241, 180, 181));
        btnVoltarCEF.setForeground(new Color(145, 6, 79));
        btnVoltarCEF.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCEF.setBounds(10, 11, 69, 30);
        ConsultaEF.add(btnVoltarCEF);
        
        tableCEF=new JTable();
        tableCEF.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        DefaultTableModel tableModelCEF=new DefaultTableModel(
        	new Object[][]{},
        	new String[] {
        		"CPF", "Nome", "Data de admissão", "Total de empréstimos"
        	}
        );
        tableCEF.setModel(tableModelCEF);
        
        JTableHeader headerCEF=tableCEF.getTableHeader();
        headerCEF.setFont(new Font("Century Gothic", Font.BOLD, 20));
        headerCEF.setForeground(Color.WHITE);
        headerCEF.setBackground(new Color(241, 180, 181));
        tableCEF.setFont(new Font("Century Gothic", Font.PLAIN, 17));
       
        JScrollPane scrollPaneCEF= new JScrollPane();
        scrollPaneCEF.getViewport().setOpaque(false);
        scrollPaneCEF.setOpaque(false);
        scrollPaneCEF.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPaneCEF.setBounds(25, 216, 746, 285);
        scrollPaneCEF.setViewportView(tableCEF);
        ConsultaEF.add(scrollPaneCEF);
        
        JButton btnBuscarCEF = new JButton("Buscar");
        btnBuscarCEF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		listaCEF.clear();
        		ConsultaDAO csDAO=new ConsultaDAO();
        		listaCEF=csDAO.totalEmprestimosF();
        		tableModelCEF.setRowCount(0);
        		for(ArrayList<Object> rs:listaCEF) {
        			Date data_admissao=(Date)rs.get(2);
        			String data_admissao_String="";
        			if(data_admissao!=null) {
        				SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        			    data_admissao_String=format.format(data_admissao);
        			}
                    tableModelCEF.addRow(new Object[]{rs.get(0), rs.get(1),data_admissao_String, rs.get(3)});
        		}
        	}
        });
        btnBuscarCEF.setForeground(new Color(115, 38, 52));
        btnBuscarCEF.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarCEF.setBackground(new Color(217, 180, 190));
        btnBuscarCEF.setBounds(324, 548, 147, 41);
        ConsultaEF.add(btnBuscarCEF);
        
        JLabel lblNewLabel_30 = new JLabel("New label");
        lblNewLabel_30.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas Consultas.png")));
        lblNewLabel_30.setBounds(0, 0, 798, 600);
        ConsultaEF.add(lblNewLabel_30);
        
        //ConsultaEC
        
        ConsultaEC = new JPanel();
        ConsultaEC.setBackground(new Color(255, 221, 222));
        contentPane.add(ConsultaEC, "ConsultaEC");
        ConsultaEC.setLayout(null);
        
        JLabel lblConsultaEC = new JLabel("Empréstimos por Cliente");
        lblConsultaEC.setForeground(new Color(255, 255, 255));
        lblConsultaEC.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblConsultaEC.setBounds(208, 56, 430, 50);
        ConsultaEC.add(lblConsultaEC);
        
        JButton btnVoltarCEC = new JButton("");
        btnVoltarCEC.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCEC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCEC.setBackground(new Color(241, 180, 181));
        btnVoltarCEC.setForeground(new Color(145, 6, 79));
        btnVoltarCEC.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCEC.setBounds(10, 11, 69, 30);
        ConsultaEC.add(btnVoltarCEC);

        tableCEC=new JTable();
        tableCEC.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        DefaultTableModel tableModelCEC=new DefaultTableModel(
        	new Object[][]{},
        	new String[] {
        		"CPF", "Nome", "Data de cadastro", "Total de empréstimos"
        	}
        );
        tableCEC.setModel(tableModelCEC);
        
        JTableHeader headerCEC=tableCEC.getTableHeader();
        headerCEC.setFont(new Font("Century Gothic", Font.BOLD, 20));
        headerCEC.setForeground(Color.WHITE);
        headerCEC.setBackground(new Color(241, 180, 181));
        tableCEC.setFont(new Font("Century Gothic", Font.PLAIN, 17));

        JScrollPane scrollPaneCEC = new JScrollPane();
        scrollPaneCEC.getViewport().setOpaque(false);
        scrollPaneCEC.setOpaque(false);
        scrollPaneCEC.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPaneCEC.setBounds(24, 189, 746, 285);
        scrollPaneCEC.setViewportView(tableCEC);
        ConsultaEC.add(scrollPaneCEC);
        
        JButton btnBuscarCEC = new JButton("Buscar");
        btnBuscarCEC.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		listaCEC.clear();
        		ConsultaDAO csDAO=new ConsultaDAO();
        		listaCEC=csDAO.totalEmprestimosC();
        		tableModelCEC.setRowCount(0);
        		for(ArrayList<Object> rs:listaCEC) {
        			Date data_cadastro=(Date)rs.get(2);
        			String data_cadastro_String="-";
        			if(data_cadastro!=null) {
        				SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        			    data_cadastro_String=format.format(data_cadastro);
        			}
                    tableModelCEC.addRow(new Object[]{rs.get(0), rs.get(1), data_cadastro_String, rs.get(3)});
        		}
        	}
        });
        btnBuscarCEC.setForeground(new Color(115, 38, 52));
        btnBuscarCEC.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarCEC.setBackground(new Color(217, 180, 190));
        btnBuscarCEC.setBounds(325, 548, 147, 41);
        ConsultaEC.add(btnBuscarCEC);
        
        JLabel lblNewLabel_31 = new JLabel("New label");
        lblNewLabel_31.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas Consultas.png")));
        lblNewLabel_31.setBounds(0, 0, 798, 600);
        ConsultaEC.add(lblNewLabel_31);
        
        //ConsultaLG
        
        ConsultaLG = new JPanel();
        ConsultaLG.setBackground(new Color(255, 221, 222));
        contentPane.add(ConsultaLG, "ConsultaLG");
        ConsultaLG.setLayout(null);
        
        JLabel lblConsultaLG = new JLabel("Livros por Gênero");
        lblConsultaLG.setForeground(new Color(255, 255, 255));
        lblConsultaLG.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblConsultaLG.setBounds(256, 57, 317, 50);
        ConsultaLG.add(lblConsultaLG);
        
        JButton btnVoltarCLG = new JButton("");
        btnVoltarCLG.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCLG.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCLG.setBackground(new Color(241, 180, 181));
        btnVoltarCLG.setForeground(new Color(145, 6, 79));
        btnVoltarCLG.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCLG.setBounds(10, 11, 69, 30);
        ConsultaLG.add(btnVoltarCLG);
        
        tableCLG=new JTable();
        tableCLG.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        DefaultTableModel tableModelCLG=new DefaultTableModel(
        	new Object[][]{},
        	new String[] {
        		"Gênero", "Total de exemplares"
        	}
        );
        tableCLG.setModel(tableModelCLG);
        
        JTableHeader headerCLG=tableCLG.getTableHeader();
        headerCLG.setFont(new Font("Century Gothic", Font.BOLD, 20));
        headerCLG.setForeground(Color.WHITE);
        headerCLG.setBackground(new Color(241, 180, 181));
        tableCLG.setFont(new Font("Century Gothic", Font.PLAIN, 17));

        JScrollPane scrollPaneCLG = new JScrollPane();
        scrollPaneCLG.getViewport().setOpaque(false);
        scrollPaneCLG.setOpaque(false);
        scrollPaneCLG.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPaneCLG.setBounds(24, 189, 746, 285);
        scrollPaneCLG.setViewportView(tableCLG);
        ConsultaLG.add(scrollPaneCLG);
        
        JButton btnBuscarCLG = new JButton("Buscar");
        btnBuscarCLG.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		listaCLG.clear();
        		ConsultaDAO csDAO=new ConsultaDAO();
        		listaCLG=csDAO.totalLivrosFG();
        		tableModelCLG.setRowCount(0);
        		for(ArrayList<Object> rs:listaCLG) {
                    tableModelCLG.addRow(new Object[]{rs.get(0), rs.get(1)});
				}
        	}
        });
        btnBuscarCLG.setForeground(new Color(115, 38, 52));
        btnBuscarCLG.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarCLG.setBackground(new Color(217, 180, 190));
        btnBuscarCLG.setBounds(335, 548, 147, 41);
        ConsultaLG.add(btnBuscarCLG);
        
        JLabel lblNewLabel_32 = new JLabel("New label");
        lblNewLabel_32.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas Consultas.png")));
        lblNewLabel_32.setBounds(0, 0, 798, 600);
        ConsultaLG.add(lblNewLabel_32);
        
        //ConsultaEH
        
        ConsultaEH = new JPanel();
        ConsultaEH.setBackground(new Color(255, 221, 222));
        contentPane.add(ConsultaEH, "ConsultaEH");
        ConsultaEH.setLayout(null);
        
        JLabel lblConsultaEH = new JLabel("Empréstimos de hoje");
        lblConsultaEH.setForeground(new Color(255, 255, 255));
        lblConsultaEH.setFont(new Font("Sitka Small", Font.BOLD, 30));
        lblConsultaEH.setBounds(230, 56, 369, 50);
        ConsultaEH.add(lblConsultaEH);
        
        JButton btnVoltarCEH = new JButton("");
        btnVoltarCEH.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - BtnVoltar.png")));
        btnVoltarCEH.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "Menu");
        	}
        });
        btnVoltarCEH.setBackground(new Color(241, 180, 181));
        btnVoltarCEH.setForeground(new Color(145, 6, 79));
        btnVoltarCEH.setFont(new Font("Sitka Small", Font.BOLD, 20));
        btnVoltarCEH.setBounds(10, 11, 69, 30);
        ConsultaEH.add(btnVoltarCEH);

        JLabel lblTotalEH = new JLabel("Total de empréstimos:");
        lblTotalEH.setFont(new Font("Sitka Small", Font.PLAIN, 25));
        lblTotalEH.setBounds(205, 266, 394, 41);
        ConsultaEH.add(lblTotalEH);
        
        JButton btnBuscarCEH = new JButton("Buscar");
        btnBuscarCEH.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				ConsultaDAO csDAO=new ConsultaDAO();
				totalEH=csDAO.totalEmprestimosHoje();
				lblTotalEH.setText("Total de empréstimos: "+totalEH);
        	}
        });
        btnBuscarCEH.setForeground(new Color(115, 38, 52));
        btnBuscarCEH.setFont(new Font("Sitka Small", Font.BOLD, 30));
        btnBuscarCEH.setBackground(new Color(217, 180, 190));
        btnBuscarCEH.setBounds(330, 548, 147, 41);
        ConsultaEH.add(btnBuscarCEH);
        
        JLabel lblNewLabel_33 = new JLabel("New label");
        lblNewLabel_33.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/img/PM Desing - Paginas Consultas.png")));
        lblNewLabel_33.setBounds(0, 0, 798, 600);
        ConsultaEH.add(lblNewLabel_33);
        
    }
    
    public ArrayList<String> valParametrosCliente(String cpf, String nome, Date data_nasc, String logradouro, String numero, String cep,String cidade, String pais) {
    	ArrayList<String> msg=new ArrayList<String>();
    	if(!(cpf.matches("\\d+") && cpf.length()==11)) {
    		msg.add("O CPF é inválido!");
    	}
    	if(nome.isEmpty()) {
    		msg.add("O nome precisa ser preenchido!");
    	}
    	if(data_nasc==null) {
    		msg.add("A data de nascimento precisa ser preenchida!");
    	}
    	if(logradouro.isEmpty()) {
    		msg.add("O logradouro precisa ser preenchido!");
    	}
    	if(!(numero.matches("\\d+") && numero.isEmpty()!=true)) {
    		msg.add("O número é inválido!");
    	}
    	if(!(cep.matches("\\d+") && cep.isEmpty()!=true)) {
    		msg.add("O CEP é inválido!");
    	}
    	if(cidade.isEmpty()) {
    		msg.add("A cidade precisa ser preenchida!");
    	}
    	if(pais.isEmpty()) {
    		msg.add("O país precisa ser preenchido!");
    	}
    	return msg;
    }
    
    public ArrayList<String> valParametrosFuncionario(String cpf, String nome, Date data_nasc, String logradouro, String numero, String cep,String cidade, String pais, String salario) {
    	ArrayList<String> msg=new ArrayList<String>();
    	if(!(cpf.matches("\\d+") && cpf.length()==11)) {
    		msg.add("O CPF é inválido!");
    	}
    	if(nome.isEmpty()) {
    		msg.add("O nome precisa ser preenchido!");
    	}
    	if(data_nasc==null) {
    		msg.add("A data de nascimento precisa ser preenchida!");
    	}
    	if(logradouro.isEmpty()) {
    		msg.add("O logradouro precisa ser preenchido!");
    	}
    	if(!(numero.matches("\\d+") && numero.isEmpty()!=true)) {
    		msg.add("O número é inválido!");
    	}
    	if(!(cep.matches("\\d+") && cep.isEmpty()!=true)) {
    		msg.add("O CEP é inválido!");
    	}
    	if(cidade.isEmpty()) {
    		msg.add("A cidade precisa ser preenchida!");
    	}
    	if(pais.isEmpty()) {
    		msg.add("O país precisa ser preenchido!");
    	}
    	try {
            @SuppressWarnings("unused")
			float salarioFloat = Float.parseFloat(salario);
        } catch (NumberFormatException ex) {
        	msg.add("O salário é inválido!");
        }
    	return msg;
    }
    
    public ArrayList<String> valParametrosFisico(String ISBN, String titulo, String sinopse, String valor, ArrayList<String> autores, ArrayList<String> generos) {
    	ArrayList<String> msg=new ArrayList<String>();
    	if(!(ISBN.matches("\\d+") && ISBN.length()==13)) {
    		msg.add("O ISBN é inválido!");
    	}
    	if(titulo.isEmpty()) {
    		msg.add("O titulo precisa ser preenchido!");
    	}
    	if(sinopse.isEmpty()) {
    		msg.add("A sinopse precisa ser preenchida!");
    	}
    	try {
            @SuppressWarnings("unused")
			float valorFloat = Float.parseFloat(valor);
        } catch (NumberFormatException ex) {
        	msg.add("O valor é inválido!");
        }
    	if(autores.isEmpty()) {
    		msg.add("O autor precisa ser preenchido!");
    	}
    	if(generos.isEmpty()) {
    		msg.add("O gênero precisa ser selecionado!");
    	}
    	return msg;
    }
    
    public ArrayList<String> valParametrosExemplar(String ISBN, String numero, String edicao, String estado_conservacao) {
    	ArrayList<String> msg=new ArrayList<String>();
    	if(!(ISBN.matches("\\d+") && ISBN.length()==13)) {
    		msg.add("O ISBN é inválido!");
    	}
    	if(!(numero.matches("\\d+") && numero.isEmpty()==false)) {
    		msg.add("O número precisa ser preenchido!");
    	}
    	if(!(edicao.matches("\\d+") && edicao.isEmpty()==false)) {
    		msg.add("A edição precisa ser preenchida!");
    	}
    	if(estado_conservacao.isEmpty()) {
    		msg.add("O estado de conservação precisa ser selecionado!");
    	}
    	return msg;
    }
    
    public ArrayList<String> valParametrosEmprestimo(String CPFC, String ISBN, String numero, Date data, Time hora, String CPFF, Date dataFim, String termoCompromisso) {
    	ArrayList<String> msg=new ArrayList<String>();
    	if(!(ISBN.matches("\\d+") && ISBN.length()==13)) {
    		msg.add("O ISBN é inválido!");
    	}
    	if(!(numero.matches("\\d+") && numero.isEmpty()==false)) {
    		msg.add("O número precisa ser preenchido!");
    	}
    	if(!(CPFC.matches("\\d+") && CPFC.length()==11)) {
    		msg.add("O CPF do cliente é inválido!");
    	}
    	if(data==null) {
    		msg.add("A data precisa ser preenchida!");
    	}
    	if(hora==null) {
    		msg.add("A hora precisa ser preenchida!");
    	}
    	if(!(CPFF.matches("\\d+") && CPFF.length()==11)) {
    		msg.add("O CPF do funcionário é inválido!");
    	}
    	if(dataFim==null) {
    		msg.add("A data de fim precisa ser preenchida!");
    	}
    	if(termoCompromisso.isEmpty()) {
    		System.out.println("O termo de compromisso precisa ser preenchido!");
    	}
    	return msg;
    }
    
    public ArrayList<String> valParametrosEmprestimo2(String cpfCliente, String isbn, long numero, String cpfFuncionario) {
    	ArrayList<String> msg=new ArrayList<String>();
        ClienteDAO cDAO=new ClienteDAO();
    	Cliente c=cDAO.buscaCPF(cpfCliente);
    	FuncionarioDAO fDAO=new FuncionarioDAO();
    	Funcionario f=fDAO.buscaCPF(cpfFuncionario);
    	ExemplarDAO exDAO=new ExemplarDAO();
    	Exemplar ex=exDAO.buscaISBNNum(isbn, numero);
    	boolean disponivel=exDAO.disponibilidade(isbn, numero);
    	if(c==null) {
    		msg.add("Não existe nenhum cliente cadastrado com esse CPF!");
    	}
    	if(f==null) {
    		msg.add("Não existe nenhum funcionário cadastrado com esse CPF!");
    	}
    	if(ex==null) {
    		msg.add("Não existe nenhum exemplar cadastrado com esse ISBN e número!");
    	}else {
    		if(disponivel==false) {
    			msg.add("Este exemplar não está disponível para empréstimo!");
    		}
    	}
    	return msg;
    }
    
    public ArrayList<String> valParametrosEE2(String cpfFuncionario) {
    	ArrayList<String> msg=new ArrayList<String>();
    	FuncionarioDAO fDAO=new FuncionarioDAO();
    	Funcionario f=fDAO.buscaCPF(cpfFuncionario);
    	if(f==null) {
    		msg.add("Não existe nenhum funcionário cadastrado com esse CPF!");
    	}
    	return msg;
    }
    
    public ArrayList<String> valParametrosBuscaEditaE(String CPFC, String ISBN, String numero, Date data, String hora) {
    	ArrayList<String> msg=new ArrayList<String>();
    	if(!(ISBN.matches("\\d+") && ISBN.length()==13)) {
    		msg.add("O ISBN é inválido!");
    	}
    	if(!(numero.matches("\\d+") && numero.isEmpty()==false)) {
    		msg.add("O número precisa ser preenchido!");
    	}
    	if(!(CPFC.matches("\\d+") && CPFC.length()==11)) {
    		msg.add("O CPF do cliente é inválido!");
    	}
    	if(data==null) {
    		msg.add("A data precisa ser preenchida!");
    	}
    	if (!hora.matches("\\d{2}:\\d{2}:\\d{2}")) {
    	    msg.add("A hora precisa ser preenchida!");
    	}
    	return msg;
    }
    
    public void limparInfoCC() {
		textFieldNomeCC.setText("");
		textFieldCPFCC.setText("");
		dateChooserDataNascCC.setDate(null);
		textFieldLogradouroCC.setText("");
		textFieldNumCC.setText("");
		textFieldCEPCC.setText("");
		textFieldCidadeCC.setText("");
		textFieldPaisCC.setText("");
	}
    
    public void limparInfoEFi() {
		textFieldTituloLivroEFi.setText("");
		textFieldValorEFi.setText("");
		textFieldAutorEFi.setText("");
		textAreaListaAutorEFi.setText("Lista: ");
		autoresEFi.clear();
		textAreaSinopseEFi.setText("");
		textFieldISBNEFi.setText("");
		gSelecionadoEFi.setGenerosSelecionados(new ArrayList<String>());
	}
    
    public void limparInfoBEFi() {
		textFieldISBNBEFi.setText("");
	}

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }
}
