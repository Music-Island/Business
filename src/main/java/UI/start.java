package UI;

import Client.MapBaiduUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start extends JPanel{
    private MyFrame frame;
    private int w,h;
    private JButton shang,xiao,food,wear;
    MapBaiduUtil ma;
    public start(MyFrame frame){
        this.frame = frame;
        w = frame.getWidth();
        h = frame.getHeight();
        setVisible(true);
        setLayout(null);
        BackgroundPanel bg;
        bg = new BackgroundPanel((new ImageIcon("src/ys5.png")).getImage());
        bg.setBounds(0,0,w,h);
        bg.setVisible(true);

        shang = new JButton("商圈");
        xiao = new JButton("最高性价比");
        food = new JButton("美食");
        wear = new JButton("服饰");

        shang.setFont(new Font("华文行楷", Font.BOLD,30));
        xiao.setFont(new Font("华文行楷", Font.BOLD,30));
        food.setFont(new Font("华文行楷", Font.BOLD,30));
        wear.setFont(new Font("华文行楷", Font.BOLD,30));

        shang.setBounds(700,150,200,70);
        xiao.setBounds(700,270,200,70);
        food.setBounds(700,390,200,70);
        wear.setBounds(700,510,200,70);

        shang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                sh();
            }
        });
        xiao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                ma = new MapBaiduUtil();
                ma.get();
                xi();
            }
        });
        food.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                fo();
            }
        });
        wear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                we();
            }
        });

        bg.add(shang);
        bg.add(xiao);
        bg.add(food);
        bg.add(wear);
        add(bg);
    }

    public void sh(){
        JFrame s = new JFrame("商圈");
        s.setBounds(0,0,1500,800);
//        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setLocationRelativeTo(null);
        s.setResizable(false);
        s.setVisible(true);
        Container c = s.getContentPane();

        BackgroundPanel bgs;
        bgs = new BackgroundPanel((new ImageIcon("src/ys6.png")).getImage());
        bgs.setBounds(0,0,1500,800);
        c.add(bgs,-1);

        JTextArea ar = new JTextArea();
        ar.setFont(new Font("微软雅黑",Font.PLAIN,28));
        ar.append("最受欢迎的商圈：宝龙万象\n\n---------------------------------------------------------------------------------\n");

        JScrollPane js = new JScrollPane(ar);
        ar.setOpaque(false);
        js.setOpaque(false);
        js.getViewport().setOpaque(false);

        c.add(js,0);
//        JFrame s = new JFrame("商圈");
//        s.setBounds(0,0,1500,800);
////        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        s.setLocationRelativeTo(null);
//        s.setResizable(false);
//
//        Container c = s.getContentPane();
//
//        BackgroundPanel bgs;
//        bgs = new BackgroundPanel((new ImageIcon("src/ys5.png")).getImage());
//        bgs.setBounds(0,0,1500,800);
//
//        //JButton b = new JButton("返回");
//        //b.setBounds(100,100,100,50);
//        JPanel backpanel = new JPanel();
//        backpanel.setLayout(null);
//        backpanel.setBounds(50, 50, 500, 500);
//        backpanel.setBackground(new Color(96, 96, 96, 120));
//
//        JButton button = new JButton();
//        button.setText("确认");
//        button.setBackground(Color.WHITE);
//        button.setFont(new Font("微软雅黑", 1, 30));
//        button.setBounds(50, 50, 200, 200);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        JTextArea ar = new JTextArea();
//        ar.setFont(new Font("微软雅黑",Font.PLAIN,21));
//        ar.setText("hey");
//        JScrollPane js = new JScrollPane(ar);
//        ar.setOpaque(false);
//        js.setOpaque(false);
//        js.getViewport().setOpaque(false);
//
//        c.add(bgs,-1);
//        //c.add(js,0);
//        c.add(backpanel);
//        backpanel.add(js);
//        backpanel.add(button);
//        s.setVisible(true);
        //c.add(b,1);
    }
    public void xi(){
        JFrame s = new JFrame("最高性价比");
        s.setBounds(0,0,1500,800);
//        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setLocationRelativeTo(null);
        s.setResizable(false);
        s.setVisible(true);
        Container c = s.getContentPane();

        BackgroundPanel bgs;
        bgs = new BackgroundPanel((new ImageIcon("src/ys6.png")).getImage());
        bgs.setBounds(0,0,1500,800);
        c.add(bgs,-1);

        JTextArea ar = new JTextArea();
        ar.setFont(new Font("微软雅黑",Font.PLAIN,28));
        ar.append("价格低于50：\n\n");
        for (Integer i = 0; i < 5; i ++){
            ar.append("商店名：");
            ar.append(ma.sorted_sj.get(0).get(i).name);
            ar.append("\n");
            ar.append("价格：");
            ar.append(String.valueOf(ma.sorted_sj.get(0).get(i).price));
            ar.append("\n");
            ar.append("排名：");
            ar.append(String.valueOf(ma.sorted_sj.get(0).get(i).rating));
            ar.append("\n");
            ar.append("地址：");
            ar.append(ma.sorted_sj.get(0).get(i).address);
            ar.append("\n\n");
        }
        ar.append("---------------------------------------------------------------------------------\n");
        ar.append("价格位于50-100：\n\n");
        for (Integer i = 0; i < 5; i ++){
            ar.append("商店名：");
            ar.append(ma.sorted_sj.get(1).get(i).name);
            ar.append("\n");
            ar.append("价格：");
            ar.append(String.valueOf(ma.sorted_sj.get(1).get(i).price));
            ar.append("\n");
            ar.append("排名：");
            ar.append(String.valueOf(ma.sorted_sj.get(1).get(i).rating));
            ar.append("\n");
            ar.append("地址：");
            ar.append(ma.sorted_sj.get(1).get(i).address);
            ar.append("\n\n");
        }
        ar.append("---------------------------------------------------------------------------------\n");
        ar.append("价格位于100-200：\n\n");
        for (Integer i = 0; i < 5; i ++){
            ar.append("商店名：");
            ar.append(ma.sorted_sj.get(2).get(i).name);
            ar.append("\n");
            ar.append("价格：");
            ar.append(String.valueOf(ma.sorted_sj.get(2).get(i).price));
            ar.append("\n");
            ar.append("排名：");
            ar.append(String.valueOf(ma.sorted_sj.get(2).get(i).rating));
            ar.append("\n");
            ar.append("地址：");
            ar.append(ma.sorted_sj.get(2).get(i).address);
            ar.append("\n\n");
        }
        ar.append("---------------------------------------------------------------------------------\n");
        ar.append("价格高于200：\n\n");
        for (Integer i = 0; i < 5; i ++){
            ar.append("商店名：");
            ar.append(ma.sorted_sj.get(3).get(i).name);
            ar.append("\n");
            ar.append("价格：");
            ar.append(String.valueOf(ma.sorted_sj.get(3).get(i).price));
            ar.append("\n");
            ar.append("排名：");
            ar.append(String.valueOf(ma.sorted_sj.get(3).get(i).rating));
            ar.append("\n");
            ar.append("地址：");
            ar.append(ma.sorted_sj.get(3).get(i).address);
            ar.append("\n\n");
        }
        ar.append("---------------------------------------------------------------------------------\n");
        JScrollPane js = new JScrollPane(ar);
        ar.setOpaque(false);
        js.setOpaque(false);
        js.getViewport().setOpaque(false);

        c.add(js,0);
    }
    public void fo(){
        JFrame s = new JFrame("美食");
        s.setBounds(0,0,1500,800);
//        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setLocationRelativeTo(null);
        s.setResizable(false);
        s.setVisible(true);
        Container c = s.getContentPane();

        BackgroundPanel bgs;
        bgs = new BackgroundPanel((new ImageIcon("src/ys6.png")).getImage());
        bgs.setBounds(0,0,1500,800);
        c.add(bgs,-1);

        JTextArea ar = new JTextArea();
        ar.setFont(new Font("微软雅黑",Font.PLAIN,28));
        ar.append("最佳美食聚集地：宝龙万象\n\n---------------------------------------------------------------------------------\n");
        JScrollPane js = new JScrollPane(ar);
        ar.setOpaque(false);
        js.setOpaque(false);
        js.getViewport().setOpaque(false);

        c.add(js,0);
    }
    public void we(){
        JFrame s = new JFrame("服饰");
        s.setBounds(0,0,1500,800);
//        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setLocationRelativeTo(null);
        s.setResizable(false);
        s.setVisible(true);
        Container c = s.getContentPane();

        BackgroundPanel bgs;
        bgs = new BackgroundPanel((new ImageIcon("src/ys6.png")).getImage());
        bgs.setBounds(0,0,1500,800);
        c.add(bgs,-1);

        JTextArea ar = new JTextArea();
        ar.setFont(new Font("微软雅黑",Font.PLAIN,28));
        ar.append("服饰类综合评分最高：仓山万达\n\n---------------------------------------------------------------------------------\n");
        JScrollPane js = new JScrollPane(ar);
        ar.setOpaque(false);
        js.setOpaque(false);
        js.getViewport().setOpaque(false);

        c.add(js,0);
    }

    class BackgroundPanel extends JPanel
    {
        Image im;
        public BackgroundPanel(Image im)
        {
            this.setLayout(null);
            this.im=im;
            this.setOpaque(true);
        }
        //Draw the back ground.
        public void paintComponent(Graphics g)
        {
            super.paintComponents(g);
            g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

        }
    }

}
