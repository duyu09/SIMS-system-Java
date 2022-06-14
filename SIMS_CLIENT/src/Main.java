import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main
{
    public static JFrame form1;
    public static void main(String[] args)//约定args方法的参数String[0]为数据库连接字符串。
    {
        form1=new JFrame("Duyu-SIMS 学生信息管理系统 v2.0");
        form1.setVisible(true);
        form1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form1.setLocationRelativeTo(null);
        form1.setSize(450, 400);
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        form1.setLocation((width - form1.getWidth()) / 2, (height - form1.getHeight()) / 2);
        form1.setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container con=form1.getContentPane();con.setLayout(new GridLayout(2,1));
        JPanel bpan02=new JPanel();
        BackgroundPanel bpan03 = new BackgroundPanel(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Head.png"))).getImage());
        bpan02.setVisible(true);bpan02.setBackground(Color.BLACK);
        con.add(bpan03);con.add(bpan02);form1.validate();
        bpan02.setLayout(new FlowLayout(FlowLayout.CENTER));
        Font tempf002=new Font("微软雅黑",Font.BOLD,18);
        JButton btn0101=new JButton("查询学生信息");btn0101.setFont(tempf002);
        JButton btn0102=new JButton("增添学生信息");btn0102.setFont(tempf002);
        JButton btn0103=new JButton("修改学生信息");btn0103.setFont(tempf002);
        JButton btn0104=new JButton("删除学生信息");btn0104.setFont(tempf002);
        JButton btn0105=new JButton("安全退出系统");btn0105.setFont(tempf002);
        bpan02.add(btn0101);
        bpan02.add(btn0102);
        bpan02.add(btn0103);
        bpan02.add(btn0104);
        bpan02.add(btn0105);


        form1.validate();
        btn0101.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    new QueryInfo("",0,0,-1,-1);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"信息获取失败或您尚未登录。","Duyu-SIMS 系统警告",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btn0105.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int dialogButton;
                dialogButton=JOptionPane.showConfirmDialog(null,"您确定退出DuyuSIMS学生信息管理系统吗","Duyu-SIMS 系统提示",JOptionPane.YES_NO_OPTION);
                if(dialogButton==JOptionPane.YES_OPTION)
                {
                    try
                    {Login.databasecon.close();}
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
        });

        btn0103.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    InputFrame if01=new InputFrame("请输入学号：",0);
                    if01.setTitle("DuyuSIMS - 请输入学号");
                    //String strnum=if01.getInputString();

                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn0102.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    new AddInfo();

                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn0104.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    InputFrame if01=new InputFrame("请输入学号：",1);
                    if01.setTitle("DuyuSIMS - 请输入学号");
                    //String strnum=if01.getInputString();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

}


/*
 *End of source code of Main.java
 * 2022/06/11 00:37
 * 2022/06/13 09:38
 */