import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
//import java.util.*;
public class typetest extends JFrame
{
Timer t;
//JOptionPane pane;
JFrame jfrm;
JTextPane jt1,jt2;
File f,f1;
JButton jb;
JLabel jl,jl1;
FileReader ins,ins1;
FileWriter outs;
Color c;
int i,j,k;
float speed,acc;
long t1,t2,noc,count,noc1;
int ch,ch1,flag,flag1;
Font s;
ImageIcon ii;
Document d,d1;
Style y;
Object msg;
typetest()
{
noc=0;
i=j=k=0;
flag=0;
flag1=0;
speed=0.0f;
acc=0.0f;
c=new Color(200,150,240);
jfrm=new JFrame("TYPE TEST");
jfrm.setSize(1280,730);
jfrm.setDefaultCloseOperation(EXIT_ON_CLOSE);
jfrm.setVisible(true);
jfrm.setLayout(null);
jfrm.getContentPane().setBackground(c);
ii=new ImageIcon("pencil.png");
jl=new JLabel(ii);
jl.setBounds(0,0,95,700);
jfrm.add(jl);
ii=new ImageIcon("type.jpg");
jl=new JLabel(ii);
jl.setBounds(100,555,400,150);
jfrm.add(jl);
ii=new ImageIcon("goodluck.gif");
jl=new JLabel(ii);
jl.setBounds(760,555,300,160);
jfrm.add(jl);
jl=new JLabel("TYPING TEST");
s=new Font("Verdana",Font.BOLD,36);
jl.setFont(s);
jl.setForeground(Color.red);
jl.setBounds(500,5,300,40);
jfrm.add(jl);
s=new Font("Times New Roman",Font.BOLD,36);
jl1=new JLabel(""+i+":"+j+":"+k);
jl1.setBounds(825,20,250,40);
jl1.setFont(s);
jfrm.add(jl1);
jt1=new JTextPane();
jt2=new JTextPane();
t=new Timer(1000,new TimerListener());
t.setInitialDelay(0);
f=new File("test1");
f1=new File("test2");
d=jt1.getDocument();
d1=jt2.getDocument();
y=jt1.addStyle("new style",null);
StyleConstants.setBold(y,true);
StyleConstants.setFontSize(y,18);
c=new Color(125,0,0);
StyleConstants.setForeground(y,c);
try
{
ins=new FileReader(f);
outs=new FileWriter(f1);
while((ch=ins.read())!=-1)
{
noc++;
d.insertString(d.getLength(),Character.toString((char)ch),y);
}
ins.close();
}catch(Exception e)
{
System.out.println("ERROR "+ e);
}
jt1.setEditable(false);
jt2.setEditable(false);
jt2.setBackground(Color.lightGray);
jt1.setBounds(100,150,550,400);
jfrm.add(jt1);
jt2.setBounds(680,150,550,400);
jfrm.add(jt2);
jb=new JButton("START TEST");
jb.setBounds(1025,50,200,40);
jfrm.add(jb); 
jb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
flag=1;
jt2.setBackground(Color.white);
jt2.setEditable(true);
jt2.requestFocus();
jl.setText("And your time starts now");
t.start();
t1=System.currentTimeMillis();
//System.out.println(t1);
}
});
//pane=new JOptionPane();
ii=new ImageIcon("test.jpeg");
jl=new JLabel(ii);
jl.setBounds(40,5,400,130);
jfrm.add(jl); 
StyleConstants.setForeground(y,Color.red);
jt2.setCharacterAttributes(y,true);
jb=new JButton("Get Results");
jb.setBounds(560,600,200,40);
jfrm.add(jb);
jb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
t.stop();
try
{
flag=0;
flag1=1;
count=0;
noc1=0;
t2=System.currentTimeMillis();
outs.write(jt2.getText());
outs.close();
ins=new FileReader(f);
ins1=new FileReader(f1);
jt2.setText("");
while((ch1=ins1.read())!=-1)
noc1++;
ins1.close();
jt2.setEditable(false);
ins1=new FileReader(f1);
while((ch=ins.read())!=-1)
{
ch1=ins1.read();
if(ch1!=ch)
{
count++;
StyleConstants.setForeground(y,Color.red);
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
if(ch==32||ch==46||ch==44||ch==63)
{
if(ch!=32)
{
if((ch=ins.read())==ch1)
{
if(ch1==46||ch1==44||ch1==63)
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
continue;
}
else
{
ch1=ins1.read();
if(ch1==ch)
StyleConstants.setForeground(y,Color.black);
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
}
}
else if(ch==32&&(ch=ins.read())==ch1)
continue;
else
{
ch1=ins1.read();
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
ch1=ins1.read();
if(ch1==ch)
StyleConstants.setForeground(y,Color.black);
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
}
}
else if(ch1==32||ch1==46||ch1==44||ch1==63)
{
if(ch1!=32)
{
if((ch1=ins1.read())==ch)
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
else
ch=ins.read();
}
else if(ch1==32&&(ch1=ins1.read())==ch)
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
else
{
StyleConstants.setForeground(y,Color.black);
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
ch=ins.read();
ch=ins.read();
}
}
}
else
{
StyleConstants.setForeground(y,Color.black);
d1.insertString(d1.getLength(),Character.toString((char)ch1),y);
}
}
acc=((float)(noc-count+1)/(float)noc)*100;
//System.out.println("Accuracy is= "+acc);
speed=(noc1*12*1000)/(t2-t1);
//System.out.println("Speed is= "+speed);
msg="Your speed= "+Float.toString(speed)+"\n"+"Your Accuracy: "+Float.toString(acc);
JOptionPane.showMessageDialog(jfrm,msg,"Your Results",JOptionPane.INFORMATION_MESSAGE); 
ins.close();
ins1.close();
}catch(Exception z)
{
System.out.println("GET RESULTS "+z);
}
}
});
jb=new JButton("CLOSE");
jb.setBounds(1025,600,200,40);
jfrm.add(jb);
jb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
if(speed<=10.0)
msg="COME ON.... Atleast give it a try";
else if(speed<=37)
msg="Practice harder...You have the typing potential";
else if(speed<=200)
msg="Whoa...Keep it up..Excellent typing";
else
msg="UNBELIEVABLE.....You are the fastest typer in the world";
JOptionPane.showMessageDialog(jfrm,msg,"Your Results",JOptionPane.PLAIN_MESSAGE); 
jfrm.dispose();
if(flag1==0)
System.exit(1);
}
});

s=new Font("Monotype Corsiva",Font.PLAIN,30);
jl=new JLabel();
jl.setFont(s);
jl.setForeground(Color.blue);
jl.setBounds(450,60,400,60);
jfrm.add(jl);
}
class TimerListener implements ActionListener
{
public void actionPerformed(ActionEvent ae)
{
k++;
if(k==60)
{
k=0;
j++;
}
if(j==60)
{
j=0;
i++;
}
jl1.setText(""+i+":"+j+":"+k);
}
};
public static void main(String args[]) throws Exception
{
SwingUtilities.invokeLater(new Runnable()
{
public void run()
{
new typetest();
}
});
}
}


