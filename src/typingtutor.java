import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class typingtutor extends JFrame 
{
JFrame jfrm;
JLabel l1,l2,l3,l4,l5,l6,l7;
Font f;
JButton jb;
ImageIcon img;
int i;
//JList c;
JComboBox<String> c;
String ch[]={"1","2","3","4"};
//JScrollPane sp;
typingtutor()
{
jfrm=new JFrame("TYPING TUTOR");
jfrm.setSize(500,700);
jfrm.setVisible(true);
jfrm.setLayout(null);
i=jfrm.getWidth();
img=new ImageIcon("type1.jpeg");
l7=new JLabel(img);
l7.setBounds(10,5,i,100);
jfrm.getContentPane().setBackground(Color.cyan);
l1=new JLabel("TYPING TUTOR");
f=new Font("Monotype Corsiva",Font.BOLD,36);
l1.setFont(f);
l1.setForeground(Color.red);
l1.setBounds(50,100,400,100);
jfrm.setDefaultCloseOperation(EXIT_ON_CLOSE);
f=new Font("Times New Roman",Font.PLAIN,20);
l2=new JLabel("1. Typing Tips");
l2.setFont(f);
l2.setForeground(Color.blue);
l2.setBounds(50,200,200,50);
l3=new JLabel("2. Typing Practice");
l3.setBounds(50,250,200,50);
l3.setFont(f);
l3.setForeground(Color.blue);
l4=new JLabel("3. Typing Test");
l4.setBounds(50,300,200,50);
l4.setFont(f);
l4.setForeground(Color.blue);
l5=new JLabel("4. Exit");
l5.setBounds(50,350,200,50);
l5.setFont(f);
l5.setForeground(Color.blue);
f=new Font("Verdana",Font.PLAIN,16);
l6=new JLabel("Please select your choice");
l6.setFont(f);
l6.setBounds(50,400,300,50);
jb=new JButton("DONE");
jb.setBounds(180,465,100,30);
c=new JComboBox<String>(ch);
//c.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//sp=new JScrollPane(c);
//sp.setPreferredSize(new Dimension(70,80));
c.setBounds(270,415,70,20);
jfrm.add(l7);
jfrm.add(l1);
jfrm.add(l2);
jfrm.add(l3);
jfrm.add(l4);
jfrm.add(l5);
jfrm.add(l6);
jfrm.add(c);
jfrm.add(jb);
jb.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae)
{
String s=(String)c.getSelectedItem();
switch(s)
{
case "1":
new ttips();
break;
case "2":
new typepractice();
break;
case "3":
new typetest();
break;
case "4":
System.exit(1);
}
}
});
}
public static void main(String args[])
{
try
{
SwingUtilities.invokeLater(new Runnable()
{
public void run()
{
new typingtutor();
}
});
}catch(Exception e)
{
System.out.println("Can't create because of "+ e);
}
}
}

