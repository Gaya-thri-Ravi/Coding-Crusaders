import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class relief extends JFrame implements ActionListener
{
Connection con;
JTextField name,email,phno;
JLabel orgname,eid,cno,heading,rf;
JButton submit;

relief() 
{
try
{
 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/relief");
}
catch(Exception e)
{
System.out.println(e);
}

submit=new JButton("SUBMIT");
heading= new JLabel("Do You wish to join us?");
rf=new JLabel("Relief+");
orgname=new JLabel("NAME Of organization:");
eid=new JLabel("Email ID:");
cno=new JLabel("Contact Number:");
name=new JTextField();
email=new JTextField();
phno=new JTextField();

setLayout(null);

add(submit);
add(heading);
add(rf);
add(orgname);
add(eid);
add(cno);
add(name);
add(email);
add(phno);

rf.setBounds(60,10,1000,40);
heading.setBounds(50,60,1000,40);
orgname.setBounds(10,120,200,40);
name.setBounds(300,120,130,40);
eid.setBounds(10,180,130,40);
email.setBounds(190,180,130,40);
cno.setBounds(10,240,130,40);
phno.setBounds(180,240,130,40);
submit.setBounds(50,300,100,20);


setSize(1500,1500);
setVisible(true);

submit.addActionListener(this);

}


public void actionPerformed(ActionEvent ae) 
{
Object source=ae.getSource();
String oname=name.getText();
String emailid=email.getText();
String number=phno.getText();

try
{
Class.forName("com.mysql.jdbc.Driver");
Statement stm = con.createStatement();
String qry1="insert into organisation "+ "values('"+oname+"','"+emailid+"','"+number+"')";
ResultSet rs = stm.executeQuery(qry1);
while(rs.next())
{

rs.close();
stm.close();
con.close();
}
}
catch(Exception e)
{
System.out.println(e);
}
System.out.println("Database has been displayed");

}

/*else if(source==edit)
{
System.out.println("Database has been updated");
}

else if(source==addcart)
{
/*Class.forName("com.mysql.jdbc.Driver");

Statement stm = con.createStatement();*/
//String item=addcart2.getText();
//String qry1= "select * from supermarket where ITEM_NO=item";
//String qty=stock2.getText();
//String qry1="insert into bill(ITEM_NAME,PRICE,QTY) values((select ITEM_NAME, PRICE from supermarket where ITEM_NO="+addcart2.getText()+"),"+stock2.getText()+")";
//String qry2="insert into bill(QTY) value("+stock2.getText()+")";
//ResultSet rs = stm.executeQuery(qry1);
/*while(rs.next())
{
String name = rs.getString(1);
Double price = rs.getDouble(2);
int quantity = rs.getInt(3);
System.out.println(name+" "+price+" "+quantity);
}
rs.close();
stm.close();
con.close();
System.out.println("items have been added");
}

else if(source==total)
{
System.out.println("Bill has been generated");
}

else if(source==clrcart)
{
System.out.println("Cart is cleared");
}*/


public static void main(String args[]) throws ClassNotFoundException,SQLException
{
relief obj=new relief();

}
}

