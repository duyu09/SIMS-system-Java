import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class InputFrame extends JFrame
{
    public static JPanel ifpan01;
    String inputString;
    public String getInputString()
    {
        return inputString;
    }
    public InputFrame(String messageText,int commandCode)
    {
        setSize(300,150);
        setResizable(false);
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocation((width - this.getWidth()) / 2, (height - this.getHeight()) / 2);
        setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container fcon = this.getContentPane();
        ifpan01=new JPanel(new GridLayout(3,1));ifpan01.setBackground(Color.BLACK);
        fcon.add(ifpan01);
        JPanel ifpan02=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel ifpan03=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel ifpan04=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ifpan01.add(ifpan02);ifpan01.add(ifpan03);ifpan01.add(ifpan04);
        JLabel iflab01=new JLabel(messageText);
        JTextField iftext01=new JTextField(15);iftext01.setHorizontalAlignment(JTextField.CENTER);
        JButton ifok01=new JButton("确定");
        ifpan02.add(iflab01);ifpan02.setBackground(Color.BLACK);
        ifpan03.add(iftext01);ifpan03.setBackground(Color.BLACK);
        ifpan04.add(ifok01);ifpan04.setBackground(Color.BLACK);
        iflab01.setFont(Login.stdfont);
        iftext01.setFont(Login.stdfont);
        ifok01.setFont(Login.stdfont);
        iflab01.setBackground(Color.BLACK);iflab01.setForeground(Color.WHITE);
        iftext01.setBackground(new Color(40,40,40));iftext01.setForeground(Color.WHITE);
        ifok01.setBackground(Color.BLACK);ifok01.setForeground(Color.WHITE);

        fcon.validate();
        setVisible(true);
        ActionListener ifal01=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(commandCode==0) //0=修改学生信息
                {
                    try
                    {
                        ChangeInfo chf=new ChangeInfo(Integer.parseInt(iftext01.getText()));
                    }
                    catch (Exception e02)
                    {
                        JOptionPane.showMessageDialog(null,"错误:您的输入为空或包含非数字字符。","Duyu-SIMS 系统警告",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    dispose();
                }
                else if(commandCode==1)
                {
                    try
                    {
                        DeleteInfo deleteInfo=new DeleteInfo(Integer.parseInt(iftext01.getText()));
                    }
                    catch (Exception e02)
                    {
                        JOptionPane.showMessageDialog(null,"错误:您的输入为空或包含非数字字符。","Duyu-SIMS 系统警告",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    dispose();
                }
            }
        };ifok01.addActionListener(ifal01);
        iftext01.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyChar()=='\n')
                {
                    ifal01.actionPerformed(null);
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });

    }
}

/*
 *End of source code of InputFrame.java
 * 2022/06/11 00:37
 * 2022/06/13 09:38
 */