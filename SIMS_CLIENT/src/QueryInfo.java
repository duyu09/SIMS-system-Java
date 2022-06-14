import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class QueryInfo extends JFrame
{
    public static JTable jt01;
    public static Object[] columnTitle ={"学号","姓名","性别","身份证号码","电话号码","籍贯"};
    public static JScrollPane jsp01;
    public QueryInfo(String mainstr,int wid,int hei,int location_x,int location_y) throws SQLException
    {
        int width=-1;int height=-1;
        if(location_x<=-1||location_y<=-1)
        {
            width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            setLocationRelativeTo(null);
            setSize(520,385);
            setLocation((width - this.getWidth()) / 2, (height - this.getHeight()) / 2);
        }
        else
        {
            width=wid;
            height=hei;
            setSize(width,height);
            setLocation(location_x,location_y);
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("DuyuSIMS - 学生信息查询");
        setResizable(true);
        setIconImage(new ImageIcon(Objects.requireNonNull(Login.class.getResource("img/Duyu_Logo.png"))).getImage());
        Container fcon = this.getContentPane();

        JPanel bpan01 = new JPanel();
        fcon.add(bpan01);
        bpan01.setLayout(new BorderLayout());bpan01.setBackground(Color.BLACK);

        JPanel ntJP=new JPanel();ntJP.setBackground(Color.BLACK);
        ntJP.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labt01=new JLabel("请输入待查询学生的关键字");labt01.setFont(Login.stdfont);labt01.setForeground(Color.WHITE);
        JTextField text01=new JTextField(10);text01.setFont(Login.stdfont);

        text01.setText(mainstr);

        text01.setBackground(new Color(40,40,40));text01.setForeground(Color.WHITE);
        JButton btnok=new JButton("确定/刷新");btnok.setFont(Login.stdfont);
        ntJP.add(labt01);ntJP.add(text01);ntJP.add(btnok);
        bpan01.add(ntJP,BorderLayout.NORTH);

        Object[][] tabdata=null;
        ArrayList<Object[]>dataArr=new ArrayList<>();
        Statement datasta;
        ResultSet rs=null;
        try
        {
            datasta=Login.databasecon.createStatement();
            rs=datasta.executeQuery("SELECT * FROM "+Login.BOOKNAME);
        }
        catch (Exception e03) { System.out.println(e03.getMessage());}
        while(rs.next())
        {
            Object[] tempOBJ=new Object[]
            {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
            if(!mainstr.equals(""))
            {

                StringBuilder str= new StringBuilder();
                for(Object obj : tempOBJ)
                {
                    str.append(obj);
                }
                if(str.toString().contains(mainstr)) dataArr.add(tempOBJ);
            }
            else dataArr.add(tempOBJ);
        }
        tabdata= dataArr.toArray(new Object[0][]);
        jt01=new JTable(tabdata,columnTitle)
        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt01.setBackground(Color.BLACK);
        jt01.setForeground(Color.WHITE);
        jt01.setFont(new Font("微软雅黑",Font.PLAIN,12));
        JTableHeader jth01=jt01.getTableHeader();
        jth01.setBackground(Color.BLACK);
        jth01.setForeground(Color.WHITE);
        jth01.setFont(new Font("微软雅黑",Font.BOLD,12));

        jsp01=new JScrollPane(jt01);jsp01.setBackground(Color.BLACK);
        JPanel temppan03=new JPanel(new BorderLayout());temppan03.add(jsp01);
        bpan01.add(jsp01,BorderLayout.CENTER);temppan03.setBackground(Color.BLACK);


        setVisible(true);
        fcon.validate();

        ActionListener okla=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String questr=text01.getText();
                try
                {
                    QueryInfo FTemp=new QueryInfo(questr,getWidth(),getHeight(),getLocation().x,getLocation().y);
                    FTemp.validate();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                dispose();
            }
        };btnok.addActionListener(okla);

        text01.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyChar()=='\n')
                {
                    okla.actionPerformed(null);
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
 *End of source code of QueryInfo.java
 * 2022/06/11 00:37
 * 2022/06/13 09:38
 */