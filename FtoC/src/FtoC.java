//�����¶�ת�����¶ȼ��㹫ʽ��C=5/9*(F-32)

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class FtoC implements ActionListener { 
	private JFrame jFrame; 
	private JLabel l1;
	private JLabel l3;
	private JLabel lResult;
	private JPanel jPanel; 
	private JPanel p1;
	private JPanel p2;
	private JTextField tNum1;

	private JButton btCal;

	

	public static void main(String[] args) { 
		FtoC c = new FtoC(); 	
		c.go(); 
	} 
	
	public void go() { 
		jFrame 	= new JFrame("������"); 
		l1 		= new JLabel("          �����뻪���¶ȣ�");
		l3 		= new JLabel("          �����¶ȣ�");
		lResult = new JLabel("          ");  
		tNum1 	= new JTextField("",15);
		
		btCal   = new JButton("����");
		p1 		= new JPanel(); 
		p2 		= new JPanel();	

		
		btCal.addActionListener(this); 

		
		// Set up pane. 
		// Give it a border around the edges. 
		jPanel = new JPanel(); 	
		jPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30)); 
		
		// ���񲼾� 
		jPanel.setLayout(new GridLayout(0, 2)); 
		
		//������Ϸ������
		jPanel.add(l1); 
		jPanel.add(tNum1); 
		p1.add(btCal);

		jPanel.add(p1); 
		jPanel.add(p2);

		jPanel.add(l3);
		
		lResult.setForeground(Color.red);
		jPanel.add(lResult);
		
		jFrame.setContentPane(jPanel); 
		
		// ʹ�رհ�ť��Ч 
		jFrame.addWindowListener( new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				System.exit(0); 
			} 
		}); 
		jFrame.setLocation(500,350);
		jFrame.pack(); 
		jFrame.setVisible(true); 
	} 
	// ��ť�¼� 
	public void actionPerformed(ActionEvent e) { 
	double num1,num2,result=0;
	//��ȡ�����¶�
	try{
		num1 = Double.parseDouble(tNum1.getText());
	}
	catch(Exception ex)
	{
			JOptionPane.showMessageDialog(null, "Input Error!");
			tNum1.setText("");
			return;
	}

     // ����
		result = Math.rint(5.0/9*(num1-32)*1000)/1000;
	
		lResult.setText(""+result);
	
	
	} 
}
