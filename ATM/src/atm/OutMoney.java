package atm;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.FileWriter;
public class OutMoney implements ActionListener{
	public JTextField money;  
    public JFrame iframe;  
    public JPanel ip0,ip1,ip2,ip3;  
    public JButton confirm,cancel,exit;  
    public JLabel yue;//余额  
    boolean flag1 =false;
    boolean flag2 =false;
    public OutMoney() {  
        iframe=new JFrame("取款");  
  
        ip0=new JPanel();  
        ip0.add(new JLabel("账户id:"+Test.currentAccount.id));  
  
        ip1=new JPanel();  
        yue=new JLabel("账户余额:"+Test.currentAccount.money);  
        ip1.add(yue);  
  
        ip2=new JPanel();  
        ip2.add(new JLabel("取款金额:"));  
        money=new JTextField(20);  
        ip2.add(money);  
  
        ip3=new JPanel();  
        confirm=new JButton("确定");  
        ip3.add(confirm);  
        cancel=new JButton("返回");  
        ip3.add(cancel);  
  
        iframe.add(ip0);  
        iframe.add(ip1);  
        iframe.add(ip2);  
        iframe.add(confirm);  
        iframe.add(cancel);  
        iframe.setLayout(new FlowLayout());  
        iframe.setVisible(true);  
        iframe.setSize(350, 300);//窗体大小 
        iframe.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        
//        iframe.setBounds(500,500,350,300);  
        confirm.addActionListener(this);  
  
        cancel.addActionListener(this);  
  
    }  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("确定"))//点击确定按钮  
        {  
        	flag1=false;
        	flag2=false;
            try { 
            	int money1=Integer.parseInt(money.getText());
            	if(money1%100==0) {
            		flag1=true;
            	}
            	if(money1<=5000) {
            		flag2=true;
            	}
            	if(flag1&&flag2) {            		
            		Test.currentAccount.outMoney(Integer.parseInt(money.getText()));  	
            		JOptionPane.showMessageDialog(null, "取款成功");//弹窗  
            		yue.setText("账户余额:"+Test.currentAccount.money);//更新余额显示  
            	}
            	if(!flag1) {
            		JOptionPane.showMessageDialog(null, "系统不支持非100元整钞取款\n 请重新输入取款金额 ！ ");//弹窗 
            		money.setText("");
            	}
            	if(!flag2){
            		JOptionPane.showMessageDialog(null, "系统不支持存款超过5000元\n 请重新输入存款款金额 ！ ");//弹窗 
            		money.setText("");
            	}
            }  
            catch (ClassCastException e1)  
            {  
  
                JOptionPane.showMessageDialog(null, "输入数据类型错误，请输入整数");//捕获Test类中outmoney方法的异常  
  
            }  
            catch (Exception e1)  
            {  
                JOptionPane.showMessageDialog(null, e1.getMessage());  
            }  
        }  
        else  
        {  
            iframe.setVisible(false);//隐藏  
  
        }  
    }  
}
