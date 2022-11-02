import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

import javax.swing.JFrame;

public class Form extends JFrame{

	private Container c;
	private JTextField txtVal;
	private JTextField txtAns;
	private JButton btnConvert;
	private JButton btnClear;
	private JButton btnExit;
	private JComboBox<String> com1;
	private JComboBox<String> com2;
	private JLabel title;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
		
	private String comVal1="Celsius",comVal2="Fahrenheit";
		
	private String tem1[]= {"Celsius","Fahrenheit"};
	private String tem2[]= {"Fahrenheit","Celsius"};
	
	private double temp;
	
	public String getComVal2() {
		return comVal2;
	}

	public void setComVal2(String comVal2) {
		this.comVal2 = comVal2;
	}

	public String getComVal1() {
		return comVal1;
	}

	public void setComVal1(String comVal1) {
		this.comVal1 = comVal1;
	}
	
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp)
	{
		this.temp=temp;
	}
	
	public Form()
	{
		setTitle("Temperature Converter");
		setBounds(500, 150, 520, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		c=getContentPane();
		c.setLayout(null);
		
		title=new JLabel("Temperature Converter");
		title.setFont(new Font("Arial",Font.PLAIN,20));
		title.setSize(300,30);
		title.setLocation(150, 30);
		c.add(title);
		
		lbl1=new JLabel("From");
		lbl1.setFont(new Font("Arial",Font.PLAIN,14));
		lbl1.setSize(100,30);
		lbl1.setLocation(60, 100);
		c.add(lbl1);
		
		lbl2=new JLabel("To");
		lbl2.setFont(new Font("Arial",Font.PLAIN,14));
		lbl2.setSize(100,30);
		lbl2.setLocation(260, 100);
		c.add(lbl2);
		
		lbl3=new JLabel("Value To Convert");
		lbl3.setFont(new Font("Arial",Font.PLAIN,14));
		lbl3.setSize(200,30);
		lbl3.setLocation(60, 160);
		c.add(lbl3);
		
		lbl4=new JLabel("Answer");
		lbl4.setFont(new Font("Arial",Font.PLAIN,14));
		lbl4.setSize(100,30);
		lbl4.setLocation(60, 225);
		c.add(lbl4);
		
		com1=new JComboBox(tem1);
		com1.setFont(new Font("Arial",Font.PLAIN,14));
		com1.setSize(100,30);
		com1.setLocation(100, 100);
		c.add(com1);
		
		com2=new JComboBox(tem2);
		com2.setFont(new Font("Arial",Font.PLAIN,14));
		com2.setSize(100,30);
		com2.setLocation(300, 100);
		c.add(com2);
		
		txtVal=new JTextField();
		txtVal.setFont(new Font("Arial",Font.PLAIN,14));
		txtVal.setSize(150,30);
		txtVal.setLocation(260, 160);
		c.add(txtVal);
		
		txtAns=new JTextField();
		txtAns.setFont(new Font("Arial",Font.PLAIN,14));
		txtAns.setSize(150,30);
		txtAns.setLocation(260, 225);
		txtAns.setEditable(false);
		c.add(txtAns);
		
		btnConvert=new JButton("Convert");
		btnConvert.setFont(new Font("Arial",Font.PLAIN,14));
		btnConvert.setSize(100,30);
		btnConvert.setLocation(50, 300);
		c.add(btnConvert);
		
		btnClear=new JButton("Clear");
		btnClear.setFont(new Font("Arial",Font.PLAIN,14));
		btnClear.setSize(100,30);
		btnClear.setLocation(200, 300);
		c.add(btnClear);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("Arial",Font.PLAIN,14));
		btnExit.setSize(100,30);
		btnExit.setLocation(350, 300);
		c.add(btnExit);
		
		setVisible(true);
		
		com1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comVal1=com1.getSelectedItem().toString();
				if(comVal1.equals(comVal2) && comVal1.equals(tem1[0]))
				{
					com2.setSelectedItem(tem2[0]);
				}
				
				else if(comVal1.equals(comVal2) && comVal1.equals(tem1[1]))
				{
					com2.setSelectedItem(tem2[1]);
				}
				
			}
		});
		
		com2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comVal2=com2.getSelectedItem().toString();
				if(comVal1.equals(comVal2) && comVal1.equals(tem1[0]))
				{
					com1.setSelectedItem(tem2[0]);
				}
				
				else if(comVal1.equals(comVal2) && comVal1.equals(tem1[1]))
				{
					com1.setSelectedItem(tem2[1]);
				}
			}
		});
		
		btnConvert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isDouble=true;
				double ans = 0;
				String unit="";
				if(txtVal.getText().equals(""))
				{
						JOptionPane.showMessageDialog(c,"Please fill value to convert!");
				}
				else
				{	
					try {
						setTemp(Double.parseDouble(txtVal.getText()));
					}catch(NumberFormatException ne){
						JOptionPane.showMessageDialog(c,"Please fill number value!");
						isDouble=false;
					}
					if(isDouble)
					{
						if(comVal1.equals("Celsius") && comVal2.equals("Fahrenheit"))
						{
							
							ans = (getTemp()*9/5)+32;
							unit="°F";
						}
						else if(comVal1.equals("Fahrenheit") && comVal2.equals("Celsius"))
						{
							ans = (getTemp()-32)*5/9;
							unit="°C";
						}
						txtAns.setEditable(true);
						txtAns.setText(String.format("%.2f", ans));
					}
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtVal.setText("");
				txtAns.setText("");
				txtAns.setEditable(false);
				
			}
		} );
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	

}
