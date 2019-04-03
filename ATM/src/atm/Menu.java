package atm;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
public class Menu implements ActionListener{
	public JFrame mframe;  
	private JPanel mp0,mp1,mp2,mp3,mp4;//p4是确认密码；点击register按钮石出现  


	private JTextField passWord,passwordCheck;  
	private JButton inqury;  
	private JButton outmoney;  
	private JButton transfer;  
	private JButton inmoney;  
	private JButton changepassword;  


	public Menu()  
	{  
		mframe=new JFrame();  
		mframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		JButton inqury=new JButton("查询");  
		JButton outmoney=new JButton("取款");  
		JButton transfer=new JButton("转账");  
		JButton inmoney=new JButton("存款");  
		JButton changepassword=new JButton("更改密码");  
		JButton exit=new JButton("退卡");  
		inqury.setPreferredSize(new Dimension(200,40));
		outmoney.setPreferredSize(new Dimension(200,40));
		transfer.setPreferredSize(new Dimension(200,40));
		inmoney.setPreferredSize(new Dimension(200,40));
		changepassword.setPreferredSize(new Dimension(200,40));
		exit.setPreferredSize(new Dimension(200,40));
		inqury.setFont(new Font("宋体",Font.BOLD,16));
		outmoney.setFont(new Font("宋体",Font.BOLD,16));
		transfer.setFont(new Font("宋体",Font.BOLD,16));
		inmoney.setFont(new Font("宋体",Font.BOLD,16));
		changepassword.setFont(new Font("宋体",Font.BOLD,16));
		exit.setFont(new Font("宋体",Font.BOLD,16));
		//	        mp0=new JPanel();  
		//	        mp0.add(new JLabel("选择项目"));  
		//	        mframe.add(mp0);  
		mp1=new JPanel(); 
		JLabel jlb1=new JLabel("ATM业务选择");
		jlb1.setFont(new java.awt.Font("Dialog",  1, 30));
		jlb1.setForeground(Color.blue);
		mp1.add(jlb1);  

		mp1.add(inmoney);  
		mp1.add(inqury);  
		mp1.add(outmoney);  
		mp1.add(transfer);  
		mp1.add(changepassword);  
		mp1.add(exit);  

		mp1.setLayout(new GridLayout(7,1));  
		mframe.add(mp1);  
		mframe.pack();  
		mframe.setVisible(true);  
		mframe.setLayout(new FlowLayout());  
//		mframe.setBounds(800,800,450,300);  
		mframe.setSize(600, 400);//窗体大小 
		mframe.setLocationRelativeTo(null);
		mframe.setTitle("中国建设银行ATM系统"); 
		inqury.addActionListener(this);//绑定监听器  
		inmoney.addActionListener(this);  
		outmoney.addActionListener(this);  
		transfer.addActionListener(this);  
		changepassword.addActionListener(this);  
		exit.addActionListener(this);  

	}  

	@Override  
	public void actionPerformed(ActionEvent e) {  
		String cmd=e.getActionCommand();//cmd赋值为点击的按钮的值  
		if(cmd.equals("查询"))  
		{  
			Inqury inquryGui=new Inqury();  
		}  
		else if(cmd.equals("取款"))  
		{  
			OutMoney outMoneyGui=new OutMoney();  
		}  
		else if(cmd.equals("存款"))  
		{  
			InMoney inMoney=new InMoney();  
		}else if(cmd.equals("转账"))  
		{  
			Transfer transfer=new Transfer();  
		}else if(cmd.equals("更改密码"))  
		{  
			ChangePassword changePassword=new ChangePassword();  
		}  
		else if(cmd.equals("退卡")){  

			mframe.setVisible(false);//隐藏  
			LoginGui loginGui=new LoginGui();  
			JOptionPane.showMessageDialog(null,"请记得取走你的银行卡");  
		}  

	}  
}
