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
        iframe=new JFrame("存款");  
  
        ip0=new JPanel();  
        ip0.add(new JLabel("账户id:"+Test.currentAccount.id));  
        
        ip1=new JPanel();  
        yue=new JLabel("账户余额:"+Test.currentAccount.money);  
        ip1.add(yue);  
  
        ip2=new JPanel();  
        ip2.add(new JLabel("存款金额:"));  
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
        confirm.addActionListener(this);//绑定监听器  
  
        cancel.addActionListener(this);  
  
    }  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("确定"))//按下确定按钮  
        {  
            try { 
            	int money1=Integer.parseInt(money.getText());
            	if(money1%100==0) {
            		Test.currentAccount.inMoney(Integer.parseInt(money.getText()));//调用当前登陆账户的存钱函数          
                    JOptionPane.showMessageDialog(null, "存款成功");//弹窗  
                    yue.setText("账户余额:"+Test.currentAccount.money);
            	}else {
            		JOptionPane.showMessageDialog(null, "系统不支持非100元整钞存款\n 请重新输入存款款金额 ！ ");//弹窗 
            		money.setText("");
            	}
                  
            }  
            catch (ClassCastException e1)//捕获当前登录账户中inmoney函数中的异常。类型转换异常  
            {  
  
                JOptionPane.showMessageDialog(null, "输入数据类型错误，请输入整数");  
  
            }  
            catch (Exception e1)//  
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
