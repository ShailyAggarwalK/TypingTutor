import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ttips extends JFrame
{
JFrame jfrm;
JLabel jl;
Font f;
ImageIcon i;
JButton jb;
ttips()
{
jfrm=new JFrame("TYPING TIPS");
jfrm.setLayout(null);
jfrm.setSize(1000,700);
jfrm.setVisible(true);
jfrm.setDefaultCloseOperation(EXIT_ON_CLOSE);
jfrm.getContentPane().setBackground(Color.white);
f=new Font("Century Schoolbook L",Font.BOLD,30);
jl=new JLabel("TYPING TIPS");
jl.setFont(f);
jl.setForeground(Color.blue);
jl.setBounds(300,20,1000,30);
jfrm.add(jl);
f=new Font("Century Schoolbook L",Font.PLAIN,20);
jl=new JLabel("CORRECT SITTING POSITION");
jl.setFont(f);
jl.setBounds(10,70,700,20);
jl.setForeground(Color.magenta);
jfrm.add(jl);
f=new Font("Verdana",Font.PLAIN,14);
jl=new JLabel("1. Put your feet on the floor flat if you can.");
jl.setFont(f);
jl.setBounds(10,100,700,20);
jfrm.add(jl);
jl=new JLabel("2. Make your back straight.");
jl.setFont(f);
jl.setBounds(10,125,700,20);
jfrm.add(jl);
jl=new JLabel("3. Put your arms comfortably at your sides with your hands in your lap. Your hands should be relaxed.");
jl.setFont(f);
jl.setBounds(10,150,1000,20);
jfrm.add(jl);
jl=new JLabel("4. Lift your hands to the keyboard, if your arms are no longer at your sides, you are sitting too far away. Bring your chair closer if you can.");
jl.setFont(f);
jl.setBounds(10,175,1000,20);
jfrm.add(jl);
f=new Font("Century Schoolbook L",Font.PLAIN,20);
jl=new JLabel("CORRECT FINGER POSITION");
jl.setFont(f);
jl.setBounds(10,210,1000,20);
jl.setForeground(Color.magenta);
jfrm.add(jl);
f=new Font("Verdana",Font.PLAIN,14);
jl=new JLabel("1. Your thumb should be on spacebar.");
jl.setFont(f);
jl.setBounds(10,240,1000,20);
jfrm.add(jl);
jl=new JLabel("2. Your left hand's fingers should be on “ASDF” and your right hand fingers on “JKL”.");
jl.setFont(f);
jl.setBounds(10,265,1000,20);
jfrm.add(jl);
jl=new JLabel("3. Your hands should be relaxed and your fingers just a little curved.");
jl.setFont(f);
jl.setBounds(10,290,1000,20);
jfrm.add(jl);
jl=new JLabel("4. Keep your elbows at your sides and your wrist straight.");
jl.setFont(f);
jl.setBounds(10,315,1000,20);
jfrm.add(jl);
jl=new JLabel("5. The keyboard should be centered on your body.");
jl.setFont(f);
jl.setBounds(10,340,1000,20);
jfrm.add(jl);
f=new Font("FreeSans",Font.BOLD,30);
jl=new JLabel("Remember, speed only comes after lots of practice.....");
jl.setFont(f);
jl.setBounds(10,375,1000,50);
jl.setForeground(Color.green);
jfrm.add(jl);
i=new ImageIcon("tt1.jpeg");
jl=new JLabel(i);
jl.setBounds(10,430,250,200);
jfrm.add(jl);
i=new ImageIcon("tt2.jpeg");
jl=new JLabel(i);
jl.setBounds(350,430,250,200);
jfrm.add(jl);
jb=new JButton("CLOSE");
jb.setBounds(850,20,100,30);
jb.setBackground(Color.orange);
jfrm.add(jb);
jb.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
jfrm.dispose();
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
new ttips();
}
});
}catch(Exception e)
{
System.out.println("can't create because of "+e);
}
}
}

