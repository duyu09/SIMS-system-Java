/*
 *SOURCE CODE OF DUYU SIMS(Student Information Management System) SOFTWARE
 *COPYRIGHT STATEMENT:
 *Duyu-SIMS学生信息管理系统软件 著作权声明：

  Copyright (c) 2022 Qilu University of Technology, School of Computer Science and Technology, Software Engineer(Software Development), Grade 21, Class 1st, Duyu, No.202103180009
  齐鲁工业大学 计算机科学与技术学院 软件工程（软件开发）21 级 01 班 杜宇 （学号:202103180009） 保留所有权利
  All rights reserved.

  Any organization or individual can use or distribute the software free of charge, but may not change part or all of the software without written authorization.
  任何组织或自然人均可无偿使用或发布本软件，但在未经书面授权的情况下不得擅自更改本软件的部分或全部。

  Copyright Owner's Authorization: Shandong ShiChuang Software Training Institute of Ambo Education Group has the right to consult, modify, and release part or all of the source code of this software product on the premise of informing the right holder for the purpose of the Java course training of Qilu University of Technology Grade 21.
  版权方授权：安博教育集团 山东师创软件实训学院 以齐鲁工业大学21级Java课程实训为用途的 查阅，修改，并在告知权利人的前提下发布本软件产品的部分或全部源代码的权利。
 */

// Source code of Login.java//

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Login
{
    //public static String IMAGEPATH = "";
    public static String DATABASENAME="book";
    public static String DATABASELOCATION="47.93.121.147";
    public static String DATABASEPORT="3306";
    public static JFrame form2;
    public static String BOOKNAME="studentinfo02";
    //public static JPanel pannull=new JPanel();//临时与储备使用
    public static Font stdfont=new Font("微软雅黑",Font.PLAIN,14);
    public static JLabel labtime =new JLabel();
    public static JTextField text01;
    public static JPasswordField text02;
    public static JTextField text03;
    public static JTextField text04;
    public static SimpleDateFormat sdf01 = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdf02=new SimpleDateFormat("HH:mm:ss");
    public static Connection databasecon;
    //public static PreparedStatement prepment;
    public static final int REACHABLE_TIME_OUT=5000;
    public static final String TEST_WEBSITE="www.baidu.com";

    public static boolean isReachable(String remoteInetAddr)
    {
        boolean reachable = false;
        try
        {
            InetAddress address = InetAddress.getByName(remoteInetAddr);
            reachable = address.isReachable(REACHABLE_TIME_OUT);
        } catch (Exception e) {
            System.err.println("WEB CONNECTION ERROR!");
        }
        return reachable;
    }
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//注册JDBC驱动
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"错误:无法加载数据库驱动","Duyu-SIMS 系统警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        form2=new JFrame("Duyu-SIMS 学生信息管理系统v2.0 - 用户登录");
        form2.setVisible(true);
        form2.setResizable(false);
        form2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        form2.setLocationRelativeTo(null);
        form2.setSize(450, 500);
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        form2.setLocation((width - form2.getWidth()) / 2, (height - form2.getHeight()) / 2);
        form2.setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container con = form2.getContentPane();
        con.setBackground(Color.BLACK);
        con.setLayout(new GridLayout(3,1));
        BackgroundPanel bpan01 = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Head.png"))).getImage());
        bpan01.setVisible(true);
        con.add(bpan01);

        JPanel pan02=new JPanel();
        JPanel pan03=new JPanel(new FlowLayout());
        JPanel pan04=new JPanel(new FlowLayout());
        JPanel pan05=new JPanel(new FlowLayout());
        pan02.setLayout(new GridLayout(3,1));
        JLabel lab01=new JLabel("输入用户");
        JLabel lab02=new JLabel("输入密码");
        JButton btn01=new JButton("登录");
        btn01.setBackground(Color.BLACK);btn01.setForeground(Color.WHITE);
        JButton btn02=new JButton("安全退出");
        btn02.setBackground(Color.BLACK);btn02.setForeground(Color.WHITE);
        text01=new JTextField(15);
        text02=new JPasswordField(15);
        text01.setBackground(new Color(40,40,40));text01.setForeground(Color.WHITE);
        text02.setBackground(new Color(40,40,40));text02.setForeground(Color.WHITE);
        lab01.setForeground(Color.WHITE);
        lab02.setForeground(Color.WHITE);
        pan03.add(lab01);pan03.add(text01);
        pan04.add(lab02);pan04.add(text02);
        pan05.add(btn01);pan05.add(btn02);
        pan02.add(pan03);pan02.add(pan04);pan02.add(pan05);
        con.add(pan02);
        pan03.setBackground(Color.BLACK);
        pan04.setBackground(Color.BLACK);
        pan05.setBackground(Color.BLACK);
        pan02.setBackground(Color.BLACK);
        con.setFont(stdfont);
        lab01.setFont(stdfont);
        lab02.setFont(stdfont);
        btn01.setFont(stdfont);
        btn02.setFont(stdfont);
        text01.setFont(stdfont);
        text02.setFont(stdfont);text02.setEchoChar('●');

        JPanel pan06=new JPanel(new GridLayout(6,1));
        JPanel pan07=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan08=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel tmppan01=new JPanel();tmppan01.setBackground(Color.BLACK);
        JPanel tmppan02=new JPanel();tmppan02.setBackground(Color.BLACK);
        JPanel tmppan03=new JPanel();tmppan03.setBackground(Color.BLACK);
        JPanel pan09=new JPanel(new FlowLayout(FlowLayout.LEFT));pan09.setBackground(Color.BLACK);
        pan06.setBackground(Color.BLACK);
        pan06.add(tmppan01);
        pan06.add(tmppan02);
        pan06.add(tmppan03);
        pan06.add(pan09);pan06.add(pan07);pan06.add(pan08);
        JLabel lab03=new JLabel("服务器网址:");
        JLabel lab04=new JLabel("端口号:");
        text03=new JTextField(DATABASELOCATION,16);text03.setHorizontalAlignment(JTextField.CENTER);
        text04=new JTextField(DATABASEPORT,5);text04.setHorizontalAlignment(JTextField.CENTER);
        text03.setBackground(Color.BLACK);text03.setForeground(Color.WHITE);
        text04.setBackground(Color.BLACK);text04.setForeground(Color.WHITE);
        stdfont =new Font("微软雅黑",Font.PLAIN,12);
        text03.setFont(stdfont);text04.setFont(stdfont);
        lab03.setFont(stdfont);lab04.setFont(stdfont);
        lab03.setForeground(Color.WHITE);lab04.setForeground(Color.WHITE);
        pan07.setBackground(Color.BLACK);
        pan08.setBackground(Color.BLACK);
        pan07.add(lab03);pan07.add(text03);
        pan07.add(lab04);pan07.add(text04);
        con.add(pan06);
        JLabel lab05=new JLabel("Copyright (c) 齐鲁工业大学 计算机学院 软工(开发)21-1班 杜宇09");
        lab05.setForeground(Color.WHITE);
        lab05.setFont(stdfont);
        pan08.add(lab05);
        labtime.setForeground(Color.WHITE);
        labtime.setFont(stdfont);
        pan09.add(labtime);
        Thread mutime=new AutoTime();
        mutime.start();
        CloseLoginForm listener01=new CloseLoginForm();
        form2.addWindowListener(listener01);
        btn01.addActionListener(new C01Listener01());
        btn02.addActionListener(new C02Listener02());
        form2.validate();
        lab05.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                new CopyrightWindow();
            }
        });
        text01.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyChar()=='\n')
                {
                    C01Listener01 tempC=new C01Listener01();
                    tempC.actionPerformed(null);
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        text02.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyChar()=='\n')
                {
                    C01Listener01 tempC=new C01Listener01();
                    tempC.actionPerformed(null);
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });

    }


}
class BackgroundPanel extends JPanel
{
    Image image;
    BackgroundPanel(Image image)
    {
        this.image = image;
        setLocation(0,0);
    }
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
class AutoTime extends Thread
{
    @Override
    public void run()
    {
        while(true)
        {
            Login.labtime.setText("当前时间:" + Login.sdf01.format(new Date(System.currentTimeMillis())) + " " + Login.sdf02.format(new Date(System.currentTimeMillis())));
            try
            {
                Thread.sleep(250);
            } catch (Exception e)
            {
                //e.printStackTrace();
            }
            Login.form2.validate();
        }
    }
}
class CloseLoginForm implements WindowListener
{
    @Override
    public void windowOpened(WindowEvent e)
    {
        //代码待定
    }
    @Override
    public void windowClosing(WindowEvent e)
    {
        if(Main.form1==null || !Main.form1.isShowing())
        {
            int dialogButton;
            dialogButton=JOptionPane.showConfirmDialog(null,"您确定退出DuyuSIMS学生信息管理系统吗","Duyu-SIMS 系统提示",JOptionPane.YES_NO_OPTION);
            if(dialogButton==JOptionPane.YES_OPTION)
            {
                try
                {
                    Login.databasecon.close();
                }
                catch (Exception e02)
                {
                    //代码待定
                }
                System.exit(0);
            }
            else
            {
                //代码待定
            }
        }
        else
        {
            Login.form2.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        //代码待定
    }
    @Override
    public void windowIconified(WindowEvent e)
    {
//代码待定
    }
    @Override
    public void windowDeiconified(WindowEvent e)
    {
//代码待定
    }
    @Override
    public void windowActivated(WindowEvent e)
    {
//代码待定
    }
    @Override
    public void windowDeactivated(WindowEvent e)
    {
//代码待定
    }
}
class C01Listener01 implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(Login.text01.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"错误:用户名不能为空。","Duyu-SIMS 系统警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!Login.isReachable(Login.TEST_WEBSITE) && !Login.text03.getText().equalsIgnoreCase("localhost"))
        {
            JOptionPane.showMessageDialog(null,"错误:经过测试，无法连接到"+Login.TEST_WEBSITE+"请检查网络连接。","Duyu-SIMS 系统警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        new FLogining();
        String conurl="jdbc:mysql://"+Login.text03.getText()+":"+Login.text04.getText()+"/"+Login.DATABASENAME;
        String conuser=Login.text01.getText();
        String conpass= String.valueOf(Login.text02.getPassword());
        try
        {
            Login.databasecon= DriverManager.getConnection(conurl,conuser,conpass);
            Login.form2.dispose();
            Main.main(null);
        }
        catch (Exception exc)
        {
            JOptionPane.showMessageDialog(null,"错误:"+exc.getMessage(),"Duyu-SIMS 系统警告",JOptionPane.WARNING_MESSAGE);
            //return;
        }

    }
}
class C02Listener02 implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int dialogButton;
        dialogButton=JOptionPane.showConfirmDialog(null,"您确定退出DuyuSIMS学生信息管理系统吗","Duyu-SIMS 系统提示",JOptionPane.YES_NO_OPTION);
        if(dialogButton==JOptionPane.YES_OPTION)
        {
            try
            {
                Login.databasecon.close();
            }
            catch (Exception e02)
            {
                //代码待定
            }
            System.exit(0);
        }
        else {}
            //return;
    }
}
class FLogining extends JFrame
{
    public FLogining()
    {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,120);
        setTitle("正在登录...");
        setResizable(false);
        setLocation((width - this.getWidth()) / 2, (height - this.getHeight()) / 2);
        setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container fcon = this.getContentPane();
        BackgroundPanel bpan01 = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/logining.png"))).getImage());
        fcon.add(bpan01);
        this.validate();fcon.validate();
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        long mtime=System.currentTimeMillis();
        Thread tl=new Thread()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    if(System.currentTimeMillis()-mtime>3200) {break;}
                }
                dispose();
            }
        };tl.start();
    }
}
class CopyrightWindow extends JFrame
{
    public CopyrightWindow()
    {
        setSize(450,268);
        setTitle("DuyuSIMS - 学生信息管理系统 著作权声明");
        setResizable(false);
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocation((width - this.getWidth()) / 2, (height - this.getHeight()) / 2);
        setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container fcon = this.getContentPane();
        BackgroundPanel bpan01 = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/copyright.png"))).getImage());
        fcon.add(bpan01);
        fcon.validate();
        setVisible(true);
    }
}

/*
 *End of source code of Login.java
 * 2022/06/11 00:37
 * 2022/06/13 09:38
 */