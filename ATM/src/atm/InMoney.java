package atm;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.FileWriter;  
public class InMoney implements ActionListener{
	public JTextField money;  
    public JFrame iframe;  
    public JPanel ip0,ip1,ip2,ip3;  
    public JButton confirm,cancel,exit;  
    public JLabel yue; 
    public InMoney() {  
        iframe=new JFrame("���");  
  
        ip0=new JPanel();  
        ip0.add(new JLabel("�˻�id:"+Test.currentAccount.id));  
        
        ip1=new JPanel();  
        yue=new JLabel("�˻����:"+Test.currentAccount.money);  
        ip1.add(yue);  
  
        ip2=new JPanel();  
        ip2.add(new JLabel("�����:"));  
        money=new JTextField(20);  
        ip2.add(money);  
  
        ip3=new JPanel();  
        confirm=new JButton("ȷ��");  
        ip3.add(confirm);  
        cancel=new JButton("����");  
        ip3.add(cancel);  
        
        
        
        iframe.add(ip0);  
        iframe.add(ip1);  
        iframe.add(ip2);  
        iframe.add(confirm);  
        iframe.add(cancel);  
        iframe.setLayout(new FlowLayout());  
        iframe.setVisible(true);  
        iframe.setSize(350, 300);//�����С 
        iframe.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)    
        confirm.addActionListener(this);//�󶨼�����  
  
        cancel.addActionListener(this);  
  
    }  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("ȷ��"))//����ȷ����ť  
        {  
            try { 
            	int money1=Integer.parseInt(money.getText());
            	if(money1%100==0) {
            		Test.currentAccount.inMoney(Integer.parseInt(money.getText()));//���õ�ǰ��½�˻��Ĵ�Ǯ����          
                    JOptionPane.showMessageDialog(null, "���ɹ�");//����  
                    yue.setText("�˻����:"+Test.currentAccount.money);
            	}else {
            		JOptionPane.showMessageDialog(null, "ϵͳ��֧�ַ�100Ԫ�������\n ��������������� �� ");//���� 
            		money.setText("");
            	}
                  
            }  
            catch (ClassCastException e1)//����ǰ��¼�˻���inmoney�����е��쳣������ת���쳣  
            {  
  
                JOptionPane.showMessageDialog(null, "�����������ʹ�������������");  
  
            }  
            catch (Exception e1)//  
            {  
                JOptionPane.showMessageDialog(null, e1.getMessage());  
            }  
        }  
        else  
        {  
        iframe.setVisible(false);//����  
  
        }  
    }  
}
