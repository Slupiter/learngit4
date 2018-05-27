import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class Calculator implements ActionListener { 
	private JFrame jFrame; 
	private JLabel l1;
	private JLabel l2; 
	private JLabel l3;
	private JLabel lResult;
	private JPanel jPanel; 
	private JPanel p1;
	private JPanel p2;
	private JTextField tNum1;
	private JTextField tNum2;
	private JButton  btCal; 
	private JButton  btClear;
	private JRadioButton rAdd;
	private JRadioButton rSub;
	private JRadioButton rMul;
	private JRadioButton rDiv;
	private ButtonGroup bg;
	

	public static void main(String[] args) { 
		Calculator helloSwing = new Calculator(); 	
		helloSwing.go(); 
	} 
	
	public void go() { 
		jFrame 	= new JFrame("������"); 
		l1 		= new JLabel("          ��������1��");
		l2 		= new JLabel("          ��������2��");
		l3 		= new JLabel("          ��������");
		lResult = new JLabel("          ");  
		tNum1 	= new JTextField("",15);
		tNum2	= new JTextField("",15);
		
		bg 		= new ButtonGroup();
		rAdd 	= new JRadioButton("  +            ");
		rSub 	= new JRadioButton("  -            ");
		rMul 	= new JRadioButton("  *            ");
		rDiv 	= new JRadioButton("  /            ");
		p1 		= new JPanel(); 
		p2 		= new JPanel();	
		bg.add(rAdd);
		bg.add(rSub);
		bg.add(rMul);
		bg.add(rDiv);
		
		
		
		
		btCal	 = new JButton("����"); 
		btClear	 = new JButton("���");
		
		btCal.addActionListener(this); 
		btClear.addActionListener(this); 
		
		// Set up pane. 
		// Give it a border around the edges. 
		jPanel = new JPanel(); 	
		jPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30)); 
		
		// ���񲼾� 
		jPanel.setLayout(new GridLayout(0, 2)); 
		
		//������Ϸ������
		jPanel.add(l1); 
		jPanel.add(tNum1); 
		jPanel.add(l2); 
		jPanel.add(tNum2);
		p1.add(rAdd);
		p1.add(rSub);
		p2.add(rMul);
		p2.add(rDiv); 
		jPanel.add(p1); 
		jPanel.add(p2);
		jPanel.add(btCal); 
		jPanel.add(btClear);
		jPanel.add(l3);
		
		lResult.setForeground(Color.red);
		jPanel.add(lResult);
		
		jFrame.setContentPane(jPanel); 
		
		
		// ʹ�رհ�ť��Ч 
		WindowListener wl = new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				System.exit(0); 
			} 
		}; 
		
		jFrame.addWindowListener(wl); 
		jFrame.setLocation(500,400);
		jFrame.pack(); 
		jFrame.setVisible(true); 
	} 
	
	// ��ť�¼� 
	public void actionPerformed(ActionEvent e) { 
	double num1,num2,result;
	
	//��ȡ������
	try{
		num1 = Double.parseDouble(tNum1.getText());
		num2 = Double.parseDouble(tNum2.getText());
	}
	catch(Exception ex)
	{
			JOptionPane.showMessageDialog(null, "Input Error!","Error", JOptionPane.WARNING_MESSAGE);
			tNum1.setText("");
			tNum2.setText("");
			return;
	}

     // ����
		if(e.getSource()==btCal)
		{
			if(rAdd.isSelected())
				result = num1 + num2;
			else if(rSub.isSelected())
				result = num1 - num2;
			else if(rMul.isSelected())
				result = num1 * num2;
			else if(rDiv.isSelected())
			    {
			    	if (num2 < 1e-10)
			    	    {
			    	    	JOptionPane.showMessageDialog(null, "����������Ϊ0��","Error", JOptionPane.WARNING_MESSAGE);
			    	    	return;
			    	    }
			    	else
			    	    result = num1 / num2;
			    }
			else
				{
					JOptionPane.showMessageDialog(null, "��ѡ�������","Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
			lResult.setText(""+result);
		}
		//���
		else
		{
			tNum1.setText("");
			tNum2.setText("");
			lResult.setText("");
		}
	} 
}
