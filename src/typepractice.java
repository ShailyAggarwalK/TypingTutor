import javax.swing.*;

import java.awt.*;

import javax.swing.text.*;

import java.awt.event.*;

import java.io.*;

public class typepractice extends JFrame

{

JFrame jfrm;

File f1,f;

int ch,ch1,flag,flag1;

float speed, acc;

JLabel jl;

long t1,t2,noc,count,noc1;

JTextPane jt1,jt2;

JTextField x;

Style c1;

FileReader ins,ins1;

FileWriter outs=null;

Font s;

ImageIcon ii;

JButton jb;

Document d,d1;

Color o;

typepractice()

{

o=new Color(125,0,0);

noc=0;

ins=null;

ins1=null;

f=new File("t1");

jfrm=new JFrame("TYPING PRACTICE");

jfrm.setLayout(null);
jfrm.setSize(950,700);

jfrm.setVisible(true);

jfrm.getContentPane().setBackground(Color.yellow);

jfrm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

ii=new ImageIcon("type art.jpg");

jt1=new JTextPane();

d=jt1.getDocument();

c1=jt1.addStyle("new Style",null);

/*StyleConstants.setFontFamily(c1,"Arial Narrow");
StyleConstants.setFontSize(c1,12);*/

s=new Font("Century Schoolbook L",Font.BOLD,18);

jl=new JLabel("THE ART OF TYPING.........");

jl.setFont(s);

jl.setForeground(Color.blue);

jl.setBounds(5,20,250,20);

jfrm.add(jl);

s=new Font("Times New Roman",Font.BOLD,12);

jt1.setBounds(300,20,600,200);

jt1.setBackground(Color.green);

try

{

ins=new FileReader(f);

while((ch=ins.read())!=-1)

{

noc++;

d.insertString(d.getLength(),Character.toString((char)ch),c1);

}

ins.close();

jt1.setEditable(false);

f1=new File("t2");

outs=new FileWriter(f1);

jt2=new JTextPane();

jt2.setBounds(300,300,600,200);

jl=new JLabel("TYPE THE ABOVE TEXT BELOW");

s=new Font("Times New Roman",Font.BOLD,20);

jl.setFont(s);

jl.setForeground(o);

jl.setBounds(300,245,370,30);

jfrm.add(jt1);

jfrm.add(jl);

jfrm.add(jt2);

jb=new JButton("ANALYSIS");

jb.setBounds(750,550,150,40);

jfrm.add(jb);

jl=new JLabel(ii);

jl.setBounds(0,0,280,700);

jfrm.add(jl);

ii=new ImageIcon("ct1.jpeg");

jl=new JLabel(ii);

jl.setBounds(290,510,400,150);

jfrm.add(jl);

jb.addActionListener(new ActionListener()

{

public void actionPerformed(ActionEvent e)

{

count=0;

noc1=0;

jfrm.setSize(1200,700);

t2=System.currentTimeMillis();

d1=jt2.getDocument();

try
{

f=new File("t3");

f1=new File("t2");

outs.write(jt2.getText());

outs.close();

ins=new FileReader(f);

jt2.setText("");

jt1.setText("");

ins1=new FileReader(f1);

while(ins1.read()!=-1)

noc1++;

ins1.close();

ins1=new FileReader(f1);

StyleConstants.setBold(c1,true);

while((ch=ins.read())!=-1) //|| (ch1=ins1.read())!=-1)

{

ch1=ins1.read();

if(ch!=ch1)

{

count++;

StyleConstants.setForeground(c1,Color.red);

d.insertString(d.getLength(),Character.toString((char)ch),c1);

d1.insertString(d1.getLength(),Character.toString((char)ch1),c1);

if(ch==32 || ch==46) 

{

flag=1;

if(ch==46)

flag=2;

if(ch==32 && (ch=ins.read())==ch1)

{

flag=0;

d.insertString(d.getLength(),Character.toString((char)ch),c1);

}

else

{

ch1=ins1.read();

d1.insertString(d1.getLength(),Character.toString((char)ch1),c1);

if(flag==1)

ch1=ins1.read();

}

}

else if(ch1==32 || ch1==46)

{

flag1=1;

if(ch1==46)

flag1=2;

if(ch1==32 && (ch1=ins1.read())==ch)

{

flag1=0;

d1.insertString(d1.getLength(),Character.toString((char)ch1),c1);

}

else

{

ch=ins.read();

d.insertString(d.getLength(),Character.toString((char)ch),c1);

if(flag1==1)

ch=ins.read();

}

}

}

else

{

StyleConstants.setForeground(c1,Color.black);

d.insertString(d.getLength(),Character.toString((char)ch),c1);

d1.insertString(d1.getLength(),Character.toString((char)ch1),c1);

}

}

ii=new ImageIcon("practice.jpeg");

jl=new JLabel(ii);

jl.setBounds(940,325,210,185);

jfrm.add(jl);

o=new Color(0,100,100);

speed=(noc1*12*1000)/(t2-t1);

s=new Font("Monotype Corsiva",Font.BOLD,20);

jl=new JLabel("YOUR TYPING SPEED ");

jl.setFont(s);

jl.setForeground(o);

jl.setBounds(930,80,250,20);

jfrm.add(jl);

x=new JTextField(Float.toString(speed));

x.setFont(s);

x.setBounds(960,140,150,40);

jfrm.add(x);

x.setEditable(false);

s=new Font("Monotype Corsive",Font.BOLD,16);

jl=new JLabel("(words per minute)");

jl.setFont(s);

jl.setForeground(o);

jl.setBounds(957,100,200,40);

jfrm.add(jl);

s=new Font("Monotype Corsiva",Font.BOLD,20);

o=new Color(200,0,100);

jl=new JLabel("ACCURACY ");

jl.setFont(s);

jl.setForeground(o);

jl.setBounds(970,215,250,20);

jfrm.add(jl);

acc=((float)(noc-count+1)/(float)noc)*100;

x=new JTextField(Float.toString(acc));

x.setFont(s);

x.setBounds(960,255,150,40);

jfrm.add(x);

x.setEditable(false);

jb=new JButton("CLOSE");

s=new Font("Times New Roman",Font.PLAIN,18);

jb.setFont(s);

jb.setBounds(970,550,130,39);

jfrm.add(jb);

//int n=JOptionPane.showConfirmDialog(jfrm,"Practice Again?","Typing Practice",JOptionPane.YES_NO_OPTION);
jb.addActionListener(new ActionListener()

{

public void actionPerformed(ActionEvent e)

{

int n=JOptionPane.showConfirmDialog(jfrm,"Practice Again?","Typing Practice",JOptionPane.YES_NO_OPTION);
if(n==0) //yes
{
jfrm.dispose();
new typepractice();
}
else
jfrm.dispose();
}

});

ins.close();

ins1.close();

}catch(Exception z)

{

System.out.println("outs exception "+z);

}

}

});

jt2.requestFocus();

t1=System.currentTimeMillis();

}catch(Exception e)

{
System.out.println("FATAL Exception " +e);

}

}

public static void main(String args[]) throws Exception

{

SwingUtilities.invokeLater(new Runnable()

{

public void run()

{

new typepractice();

}

});

}

}

