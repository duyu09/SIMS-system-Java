import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class AddInfo extends JFrame
{
    public AddInfo()
    {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(520,385);
        setTitle("DuyuSIMS - 添加学生信息");
        setResizable(true);
        setLocation((width - this.getWidth()) / 2, (height - this.getHeight()) / 2);
        setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container fcon = this.getContentPane();
        fcon.setLayout(new GridLayout(8,1));
        JPanel temppan01=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(temppan01);temppan01.setBackground(Color.BLACK);
        JPanel cpan01=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(cpan01);
        JPanel cpan02=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(cpan02);
        JPanel cpan03=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(cpan03);
        JPanel cpan04=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(cpan04);
        JPanel cpan05=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(cpan05);
        JPanel cpan06=new JPanel(new FlowLayout(FlowLayout.CENTER));fcon.add(cpan06);
        JPanel temppan02=new JPanel(new FlowLayout(FlowLayout.RIGHT));fcon.add(temppan02);temppan02.setBackground(Color.BLACK);
        cpan01.setBackground(Color.BLACK);
        cpan02.setBackground(Color.BLACK);
        cpan03.setBackground(Color.BLACK);
        cpan04.setBackground(Color.BLACK);
        cpan05.setBackground(Color.BLACK);
        cpan06.setBackground(Color.BLACK);
        JLabel clab01=new JLabel("学生学号:");clab01.setBackground(Color.BLACK);clab01.setForeground(Color.WHITE);
        JLabel clab02=new JLabel("学生姓名:");clab02.setBackground(Color.BLACK);clab02.setForeground(Color.WHITE);
        JLabel clab03=new JLabel("学生性别:");clab03.setBackground(Color.BLACK);clab03.setForeground(Color.WHITE);
        JLabel clab04=new JLabel("身份证号:");clab04.setBackground(Color.BLACK);clab04.setForeground(Color.WHITE);
        JLabel clab05=new JLabel("电话号码:");clab05.setBackground(Color.BLACK);clab05.setForeground(Color.WHITE);
        JLabel clab06=new JLabel("学生籍贯:");clab06.setBackground(Color.BLACK);clab06.setForeground(Color.WHITE);
        JTextField ctext01=new JTextField(16);ctext01.setBackground(new Color(40,40,40));ctext01.setForeground(Color.WHITE);
        JTextField ctext02=new JTextField(16);ctext02.setBackground(new Color(40,40,40));ctext02.setForeground(Color.WHITE);
        JTextField ctext03=new JTextField(16);ctext03.setBackground(new Color(40,40,40));ctext03.setForeground(Color.WHITE);
        JTextField ctext04=new JTextField(16);ctext04.setBackground(new Color(40,40,40));ctext04.setForeground(Color.WHITE);
        JTextField ctext05=new JTextField(16);ctext05.setBackground(new Color(40,40,40));ctext05.setForeground(Color.WHITE);
        JTextField ctext06=new JTextField(16);ctext06.setBackground(new Color(40,40,40));ctext06.setForeground(Color.WHITE);
        ctext01.setHorizontalAlignment(JTextField.CENTER);
        ctext02.setHorizontalAlignment(JTextField.CENTER);
        ctext03.setHorizontalAlignment(JTextField.CENTER);
        ctext04.setHorizontalAlignment(JTextField.CENTER);
        ctext05.setHorizontalAlignment(JTextField.CENTER);
        ctext06.setHorizontalAlignment(JTextField.CENTER);
        cpan01.add(clab01);cpan01.add(ctext01);
        cpan02.add(clab02);cpan02.add(ctext02);
        cpan03.add(clab03);cpan03.add(ctext03);
        cpan04.add(clab04);cpan04.add(ctext04);
        cpan05.add(clab05);cpan05.add(ctext05);
        cpan06.add(clab06);cpan06.add(ctext06);


        JButton cbtn01=new JButton("确定添加");
        JButton cbtn02=new JButton("取消添加");
        JLabel clab07=new JLabel("---添加学生信息---");
        clab07.setBackground(Color.BLACK);
        clab07.setForeground(Color.WHITE);
        cbtn01.setBackground(Color.BLACK);
        cbtn02.setBackground(Color.BLACK);
        cbtn01.setForeground(Color.WHITE);
        cbtn02.setForeground(Color.WHITE);
        temppan02.add(cbtn01);temppan02.add(cbtn02);
        temppan01.add(clab07);

        clab07.setFont(new Font("微软雅黑",Font.BOLD,21));
        clab01.setFont(Login.stdfont);
        cbtn02.setFont(Login.stdfont);
        clab03.setFont(Login.stdfont);
        clab04.setFont(Login.stdfont);
        clab05.setFont(Login.stdfont);
        clab06.setFont(Login.stdfont);
        ctext01.setFont(Login.stdfont);
        ctext02.setFont(Login.stdfont);
        ctext03.setFont(Login.stdfont);
        ctext04.setFont(Login.stdfont);
        ctext05.setFont(Login.stdfont);
        ctext06.setFont(Login.stdfont);
        cbtn01.setFont(Login.stdfont);
        cbtn02.setFont(Login.stdfont);

        ActionListener a002=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        };cbtn02.addActionListener(a002);

        ActionListener a001=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(ctext01.getText().equals("")||ctext02.getText().equals("")||ctext03.getText().equals("")||ctext04.getText().equals("")||ctext05.getText().equals("")||ctext06.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Duyu-SIMS系统警告：学生信息项目不可以为空值。","Duyu-SIMS 系统警告",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int addNum=Integer.parseInt(ctext01.getText());
                    boolean flag01=false;
                    Statement tempState=Login.databasecon.createStatement();
                    ResultSet resultSet=tempState.executeQuery("SELECT * FROM "+Login.BOOKNAME);
                    while(resultSet.next())
                    {
                        if(addNum==resultSet.getInt(1))
                        {
                            flag01=true;break;
                        }
                    }
                    if(flag01)
                    {
                        JOptionPane.showMessageDialog(null,"错误:数据库中存在相同学号！","Duyu-SIMS 系统警告",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        int dialogButton;
                        dialogButton=JOptionPane.showConfirmDialog(null,"您确定要添加该学生的信息吗","Duyu-SIMS 系统提示",JOptionPane.YES_NO_OPTION);
                        if(dialogButton==JOptionPane.YES_OPTION)
                        {
                            String SQLStr="INSERT INTO "+Login.BOOKNAME+" VALUES("+ctext01.getText()+" ,'"+ctext02.getText()
                                    +"' ,'"+ctext03.getText() +"' ,'"+ctext04.getText() +"' ,'"+ctext05.getText() +"' ,'"+ctext06.getText() +"');";
                            PreparedStatement preparedStatement01=Login.databasecon.prepareStatement(SQLStr);
                            preparedStatement01.execute();
                            JOptionPane.showMessageDialog(null,"Duyu-SIMS系统提示，添加学生信息成功！","Duyu-SIMS系统",JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        }
                    }

                }
                catch (Exception e01)
                {
                    JOptionPane.showMessageDialog(null,"错误:"+e01.getMessage(),"Duyu-SIMS 系统警告",JOptionPane.WARNING_MESSAGE);
                }
            }
        };cbtn01.addActionListener(a001);

        setVisible(true);
        validate();
    }
}


/*
 *End of source code of AddInfo.java
 * 2022/06/11 00:37
 * 2022/06/13 09:38
 */