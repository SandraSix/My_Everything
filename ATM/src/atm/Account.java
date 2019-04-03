package atm;
//import com.sun.deploy.util.SyncFileAccess;  
//import com.sun.org.apache.regexp.internal.RE;  
  
import javax.swing.*;  
import  java.io.*;  
import java.text.SimpleDateFormat;  
import  java.util.*;
public class Account {
	  int money;  
	    String id;//�˺���  
	  
	    String password;  
	    Date now=new Date();  
	    Date currentTime;  
	    SimpleDateFormat formatter;  
	    Reader fr;  
	    ;  
	    public Account(String id, String password, String money) {//���췽��  
	        this.id = id;  
	  
	        this.password = password;  
	        this.money=Integer.parseInt(money);  
	    }  
	  
	  
	  
	  
	  
	  
	  
	    public void outMoney (int money)throws Exception {//�׳��쳣������صĽ����൯�������쳣,���漸������ͬ��  
	        //����ȡǮ����ȡǮ�������ô˺���������try/catch�����������������쳣������˵���쳣  
	        if (money > this.money) {  
	            throw new Exception("����");  
	        }
	        if(money<0)  
	        {  
	            throw new Exception("����ȡ������");  
	        }  
	        formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");//ʱ���ʽ  
	        currentTime = new Date();//��ǰʱ��  
	        String dateString = formatter.format(currentTime);//����ǰʱ���ʽ  
	        Writer fw = new FileWriter(Test.file);  
	        fw.write(Test.recordString.append(dateString + "\t" + Test.currentAccount.id + "\tȡ��" + money + "Ԫ\r\n").toString());//����ε�ȡǮ��Ϊ��ӵ���¼�ļ���  
	        fw.flush();//д���ļ�  
	        fw.close();  
	        this.money -= money;  
	        Test.usersListUpdate();//�����û��ĵ�����Ϣ��  
	    }  
	  
	    public void inMoney(int money)throws Exception  
	    {  
	        try {  
	            Writer fw = new FileWriter(Test.file);  
	           // System.out.println(Test.file);  
	            formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
	            currentTime=new Date();  
	            String dateString=formatter.format(currentTime);  
	            fw.write(Test.recordString.append(dateString+"\t"+Test.currentAccount.id+"\t����" + money + "Ԫ\r\n").toString());  
	            fw.flush();//д���ļ�  
	            fw.close();  
	  
	            this.money+=money;  
	  
	            Test.usersListUpdate();//���µ�ǰ�û���Ϣ  
	  
	        }  
	        catch (Exception e1)  
	        {  
	            throw new Exception("д���¼ʧ��");  
	        }  
	  
	    }  
	  
	    public void transfer(int money,String id)throws Exception//ת��  
	    {  
	        if(id.equals(Test.currentAccount.id))  
	        {  
	            throw new Exception("����ת���Լ�");  
	        }  
	        if(money>this.money)  
	        {  
	            throw new Exception("����");  
	        }  
	        if(money<0) {  
	            throw new Exception("����ת�븺��");  
	        }  
	  
	  
	        for(int i=0;i<Test.usersList.size();i++)  
	        {  
	            if(Test.usersList.get(i).id.equals(id))//�ҵ�Ҫת�ʵ��û�  
	            {  
	                Test.usersList.get(i).money+=money;//ת��  
	                this.money-=money;//��Ǯ  
	  
	                FileWriter fw=new FileWriter(Test.file);  
	                formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");//����ʱ���ʽ  
	                currentTime=new Date();//��ȡ��ǰʱ��  
	                String dateString=formatter.format(currentTime);//ת��ʱ���ʽ  
	                fw.write(Test.recordString.append(dateString+"\t��"+id+"\tת��"+money+"Ԫ\r\n").toString());//Test���еľ�̬�ַ���ƴ��������ַ�������д�뵱ǰ�û��ĵ�  
	                fw.close();  
	  
	                /********************��ת��Ŀ��д��ת����Ϣ*************************/  
	                try {  
	                fr = new FileReader(id+".txt");//�ַ���  
	                 }  
	                 catch (Exception e)  
	                 {  
	                System.out.println("�ַ�������ʧ��");  
	                }  
	  
	                BufferedReader bfr = new BufferedReader(fr);  
	  
	                String temp="";  
	                String temp1;  
	  
	                while ((temp1 = bfr.readLine()) != null)  
	                {  
	                    temp+=temp1;  
	                }  
	                temp=temp.replace("Ԫ","Ԫ\n\r")+dateString+"\t��"+Test.currentAccount.id+"\tת��"+money+"Ԫ\r\n";  
	                System.out.println(temp);  
	                fw=new FileWriter(id+".txt");  
	                fw.write(temp);  
	                fw.close();  
	  
	  
	                JOptionPane.showMessageDialog(null,"ת�˳ɹ�");  
	                Test.usersListUpdate();//�����û��ĵ�  
	  
	                return;  
	            }  
	        }  
	        throw new Exception("Ŀ���û�������");  
	    }  
	  
	    public void ChangePassword(String newPassword)throws Exception  
	    {  
	     if(newPassword.equals(this.password))  
	     {  
	         throw new Exception("ԭ����������벻��һ��");  
	     }  
	  
	     else  
	     {  
	         if(newPassword.equals(""))  
	         {  
	             throw new Exception("���벻��Ϊ��");  
	         }  
	  
	     }  
	     password=newPassword;  
	        Test.usersListUpdate();  
	  
	  
	    }  
	  
	  
	  
}
