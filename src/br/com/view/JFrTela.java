package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controller.ControllerCalculadora;
import br.com.enuma.EnumOperacao;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class JFrTela extends JFrame {
	
	private ControllerCalculadora calculadoraController = new ControllerCalculadora();
	
	private EnumOperacao ultimaOperacao;
	private JPanel contentPane;
	private JTextField tfValor;

	public JFrTela() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfValor = new JTextField();
		tfValor.setFont(new Font("Tahoma", Font.BOLD, 36));
		tfValor.setText("0,00");
		tfValor.setBounds(10, 11, 358, 74);
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(tfValor);
		tfValor.setColumns(25);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 358, 300);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 4, 0, 0));
		
		JButton btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpa();
			}
		});
		panel.add(btnAc);
		
		JButton btnMiasouMenos = new JButton("+/-");
		panel.add(btnMiasouMenos);
		
		JButton btnPorc = new JButton("%");
		panel.add(btnPorc);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizaOperacao(EnumOperacao.DIVISAO, stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.DIVISAO;
				limpa();
			}
		});
		panel.add(btnDiv);
		
		JButton btnNove = new JButton("9");
		btnNove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("9");
			}
		});
		panel.add(btnNove);
		
		JButton btnOito = new JButton("8");
		btnOito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("8");
			}
		});
	
		panel.add(btnOito);
		
		JButton btnSete = new JButton("7");
		btnSete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("7");
			}
		});
		panel.add(btnSete);
		
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizaOperacao(EnumOperacao.MULTIPLICACAO, stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.MULTIPLICACAO;

				limpa();
			}
		});
		panel.add(btnMult);
		
		JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("6");
			}
		});
		panel.add(btnSeis);
		
		JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("5");
			}
		});
		panel.add(btnCinco);
		
		JButton btnQuatro = new JButton("4");
		btnQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("4");
			}
		});
		panel.add(btnQuatro);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizaOperacao(EnumOperacao.SUBTRACAO, stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.SUBTRACAO;

				limpa();
			}
		});
		panel.add(btnMenos);
		
		JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("3");
			}
		});
		panel.add(btnTres);
		
		JButton btnDois = new JButton("2");
		btnDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("2");
			}
		});
		panel.add(btnDois);
		
		JButton btnOne = new JButton("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("1");
			}
		});
		panel.add(btnOne);
		
		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizaOperacao(EnumOperacao.SOMA, stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.SOMA;

				limpa();
			}
		});
		panel.add(btnSoma);
		
		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("0");
			}
		});
		panel.add(btnZero);
		
		JButton btnPonto = new JButton(".");
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita(",");
			}
		});
		panel.add(btnPonto);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnExit);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizaOperacao(EnumOperacao.SOMA, stringToDouble(tfValor.getText()));
				tfValor.setText(doubleToString(calculadoraController.getTotal()));
			}
		});
		panel.add(btnIgual);
		
	}
	
	private void limpa() {
		tfValor.setText("0,00");
		calculadoraController.zerar();
	}
	
	private String doubleToString(Double n) {
		if(n != null) {
			DecimalFormat f = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
			f.setParseBigDecimal(true);
			return f.format(n);
			
		}
		return "";
	}

	
	private Double stringToDouble(String n) {
		NumberFormat nf = NumberFormat.getInstance();
		Double dv = null;
		try {
			dv = nf.parse(n).doubleValue();
			
		} catch (ParseException ex) {
			ex.getMessage();
		}
		return dv;
	}
	
	
	private void digita(String carc) {
		if(tfValor.getText().equals("0,00")) {
			tfValor.setText(carc);
		}else{
			if(carc.equals(",") && tfValor.getText().contains(",")) {
				
			}else {
				tfValor.setText(tfValor.getText().concat(carc));
			}
		}
	}
	
}
