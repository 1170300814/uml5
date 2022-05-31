package com.yanzhao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GUI {


    public static void main(String[] args) throws ClassNotFoundException {
        // 建立连接

        JFrame jf = new JFrame();
        jf.getContentPane().setBackground(new Color(32, 178, 170));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭即退出
        jf.setSize(1000, 1000);
        jf.setTitle("Movie System");
        jf.setLayout(null);// 设置jf里的控件的排版方式为自定义

        JTextField jt1 = new JTextField();
        JButton bu1 = new JButton("查询"); // 查找

        bu1.setBounds(20, 20, 100, 50);
        jt1.setBounds(320, 20, 500, 50);
        jf.add(bu1);
        jf.add(jt1);
        TextArea ta = new TextArea();
        ta.setBounds(50, 500, 900, 400);
        ta.setFont(new Font("黑体", Font.BOLD, 20));
        ta.append("使用查询：展示用户借书信息\n"
                + "使用借书: 获取框中书籍信息并且从数据库中搜索并且在用户信息中添加书的信息\n"
                + "使用还书：还掉指定的书籍\n"
                );
        jf.add(ta);
        bu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // 获取文本框的值
                try {
                    String name = jt1.getText();

                    ta.append("用户张三借书 红楼梦 等书");
                    // ta.append("查询成功！\n");
                    // 获取光标
                    jt1.requestFocus();
                } catch (IndexOutOfBoundsException e2) {
                    // TODO: handle exception
                    ta.append("查询失败\n");
                }

                //
                // Object name = JOptionPane.showInputDialog(null, "search:\n", "title",
                // JOptionPane.PLAIN_MESSAGE, null, null, "输入");
                // String result = select(name.toString());
                // ta.append(result);
                // jt1.requestFocus();

            }
        });



        JTextField jt2 = new JTextField();
        JButton bu2 = new JButton("借书"); // 插入

        bu2.setBounds(20, 120, 100, 50);
        jt2.setBounds(320, 120, 500, 50);

        jf.add(bu2);
        jf.add(jt2);

        bu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // 获取文本框的值
                String text = jt2.getText();
                text = text.trim();
                String[] name = text.split(" ");

                boolean flag = true;
                if (flag) {
                    ta.append("借书成功！\n");
                } else {
                    ta.append("插入失败\n");
                }

                // 获取光标
                jt2.requestFocus();
            }
        });

        JTextField jt4 = new JTextField();
        JButton bu4 = new JButton("还书"); // 删除

        bu4.setBounds(20, 220, 100, 50);

        jt4.setBounds(320, 220, 500, 50);

        jf.add(bu4);
        jf.add(jt4);

        bu4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // 获取文本框的值
                String str = jt4.getText();
                boolean flag = true;
                if (flag) {
                    ta.append("还书成功\n");
                } else {
                    ta.append("删除失败\n");
                }
                // 获取光标
                jt4.requestFocus();
            }
        });

        JButton bu5 = new JButton("清空"); // 清除界面

        bu5.setBounds(20, 420, 100, 50);
        bu5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // 获取文本框的值
                ta.setText("");
                ta.append("使用查询：展示用户借书信息\n"
                        + "使用借书: 获取框中书籍信息并且从数据库中搜索并且在用户信息中添加书的信息\n"
                        + "使用还书：还掉指定的书籍\n");
            }
        });
        jf.add(bu5);
        jf.setVisible(true);
    }
}


