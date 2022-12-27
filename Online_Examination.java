import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.Timer;
import java.util.TimerTask; 
class login extends JFrame implements ActionListener  
{  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
    login()  
    {     
        userLabel = new JLabel();  
        userLabel.setText("    Username :");      
        textField1 = new JTextField(15);      
        passLabel = new JLabel();  
        passLabel.setText("    Password :");        
        textField2 = new JPasswordField(8);     
        b1 = new JButton("   SUBMIT   ");  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);     
        newPanel.add(textField1);  
        newPanel.add(passLabel);    
        newPanel.add(textField2);   
        newPanel.add(b1);          
        add(newPanel, BorderLayout.CENTER);  
        b1.addActionListener(this);    
        setTitle("Login Form ");         
    }   
    public void actionPerformed(ActionEvent ae)     
    {  
        String userValue = textField1.getText();        
        String passValue = textField2.getText();       
        if(!passValue.equals(""))
            new OnlineTestBegin(userValue); 
        else{
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }     
}  
class OnlineTestBegin extends JFrame implements ActionListener  
{  
    JLabel l;  
    JLabel l1;  
    JRadioButton jrb[]=new JRadioButton[6];  
    JButton b1,b2,log;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int z[]=new int[10];  
    Timer timer = new Timer();  
    OnlineTestBegin(String s)  
    {      
        super(s); 
        l=new JLabel();
        l1 = new JLabel();  
        add(l);
        add(l1);  
        bg=new ButtonGroup();  
        for(int k=0;k<5;k++)  
        {  
            jrb[k]=new JRadioButton();     
            add(jrb[k]);  
            bg.add(jrb[k]);  
        }  
        b1=new JButton("Save and Next");  
        b2=new JButton("Save for later");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jrb[0].setBounds(50,80,100,20);  
        jrb[1].setBounds(50,110,100,20);  
        jrb[2].setBounds(50,140,100,20);  
        jrb[3].setBounds(50,170,100,20);  
        b1.setBounds(95,240,140,30);  
        b2.setBounds(270,240,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);     
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 59;
            int j=9;
            public void run() {
                l1.setText("Time left : " +j+" min : "+i+" sec");
                i--;
                if(i==-1){
                    i=59;
                    j--;
                }
                if (j==0 && i==0) {
                    timer.cancel();
                    l1.setText("Time Out");                     
                } 
            }
        }, 0, 1000);        
    }  
    public void actionPerformed(ActionEvent e)  
    {          
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Save for later"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            z[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=z[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;
            if(count==10){
            
            JOptionPane.showMessageDialog(this,"Congratulations! Score ="+count);
            }
            else{
            JOptionPane.showMessageDialog(this,"Score ="+count); 
            } 
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jrb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Who is known as father of java programming language?");  
            jrb[0].setText("charles Babbage");jrb[1].setText("James Gosling");jrb[2].setText("M.P.Java");jrb[3].setText("Blais Pascal");   
        }  
        if(current==1)  
        {  
            l.setText("Que2:  Which of the following is not an OOPS concept in java?");  
            jrb[0].setText("Polymorphism");jrb[1].setText("Inheritance");jrb[2].setText("Compilation");jrb[3].setText("Encapsulation");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: To which of the following does the class string belong to.");  
            jrb[0].setText("java.string.package");jrb[1].setText("java.awt.package ");jrb[2].setText("java.applet.package");jrb[3].setText("java.lang.package");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Expected created by try block is caaught in which block.?");  
            jrb[0].setText("catch");jrb[1].setText("throw");jrb[2].setText("final");jrb[3].setText("thrown");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Number of primitive data types in java are?");  
            jrb[0].setText("6");jrb[1].setText("7");jrb[2].setText("8");jrb[3].setText("9");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Identify the modifier which cannot be used for constructor.");  
            jrb[0].setText("static");jrb[1].setText("public");jrb[2].setText("protected");jrb[3].setText("private");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: When is the finalize()method called ");  
            jrb[0].setText("Before garbage collection");jrb[1].setText("Before an object goes out of scope");jrb[2].setText("Before a variable goes out of scope");  
                        jrb[3].setText("None");  
        }  
        if(current==7)  
        {  
            l.setText("Que8:  Which of the following is a superclass of every class in Java?");  
            jrb[0].setText("ArrayList");jrb[1].setText("Abstract class");jrb[2].setText("Object class");  
                        jrb[3].setText("String");         
        }  
        if(current==8)  
        {  
            l.setText("Que9:  Which one of the following is not a Java feature");  
            jrb[0].setText("Object-oriented");jrb[1].setText("Use of pointers");jrb[2].setText("Portable");jrb[3].setText("Dynamic and Extensible");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which provides runtime enviroment for java byte code to be executed?");  
            jrb[0].setText("JDK");jrb[1].setText("JVM");jrb[2].setText("JRE");  
                        jrb[3].setText("JAVAC");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jrb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jrb[1].isSelected());  
        if(current==1)  
            return(jrb[2].isSelected());  
        if(current==2)  
            return(jrb[3].isSelected());  
        if(current==3)  
            return(jrb[0].isSelected());  
        if(current==4)  
            return(jrb[1].isSelected());  
        if(current==5)  
            return(jrb[0].isSelected());  
        if(current==6)  
            return(jrb[1].isSelected());  
        if(current==7)  
            return(jrb[2].isSelected());  
        if(current==8)  
            return(jrb[1].isSelected());  
        if(current==9)  
            return(jrb[2].isSelected());  
        return false;  
    }    
} 
class Online_Examination 
{  
    public static void main(String args[])  
    {  
        try  
        {  
            login form = new login();  
            form.setSize(500,150);  
            form.setVisible(true);  
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 