package Library;

/**
* 管理员界面
 * 346763079@qq.com
*  感谢@author hwt1070359898指导
**/

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminFunction extends Frame implements ActionListener {
	// 存储图书编号的文件
	private static String fileName = "BooksNum.txt";
	// 定义各个控件
	private JButton btLookSelf = new JButton("查看个人资料");
	private JButton btModify = new JButton("修改个人资料");
	private JButton btShowBook = new JButton("查看书本信息");
	private JButton btModifyBook = new JButton("修改书本信息");
	private JButton btDeleteBook = new JButton("删除书本信息");
	private JButton btAddBook = new JButton("增添书本信息");
	private JButton btExit = new JButton("退出系统");

	public AdminFunction() {
		// 串口标题
		super("管理员：" + User.num);
		// 设置为手工设置各个组件的位置和大小
		this.setLayout(null);

		btLookSelf.setBounds(new Rectangle(50, 80, 300, 50));// 修改个人资料
		btModify.setBounds(new Rectangle(50, 150, 300, 50));// 修改个人资料
		btShowBook.setBounds(new Rectangle(50, 220, 300, 50));// 查看书本信息
		btModifyBook.setBounds(new Rectangle(50, 290, 300, 50));// 修改书本信息
		btDeleteBook.setBounds(new Rectangle(50, 360, 300, 50));// 删除书本信息
		btAddBook.setBounds(new Rectangle(50, 430, 300, 50));// 增添书本信息
		btExit.setBounds(new Rectangle(50, 500, 300, 50));// 退出系统
		btExit.setBackground(Color.RED);// 退出键颜色

		btLookSelf.setFont(new Font("楷体", 1, 24));
		btModify.setFont(new Font("楷体", 1, 24));
		btShowBook.setFont(new Font("楷体", 1, 24));
		btModifyBook.setFont(new Font("楷体", 1, 24));
		btDeleteBook.setFont(new Font("楷体", 1, 24));
		btAddBook.setFont(new Font("楷体", 1, 24));
		btExit.setFont(new Font("楷体", 1, 24));

		// 增加用户监听者
		btLookSelf.addActionListener(this);
		btModify.addActionListener(this);
		btShowBook.addActionListener(this);
		btModifyBook.addActionListener(this);
		btDeleteBook.addActionListener(this);
		btAddBook.addActionListener(this);
		btExit.addActionListener(this);

		// 将按钮添加到界面
		this.add(btLookSelf);
		this.add(btModify);
		this.add(btShowBook);
		this.add(btModifyBook);
		this.add(btDeleteBook);
		this.add(btAddBook);
		this.add(btExit);

		this.setSize(400, 570);// 界面大小
		this.setBackground(Color.yellow);// 界面颜色
		GUIUtil.toCenter(this);// 使窗口居中
		this.setVisible(true);// 可视化
		this.setResizable(false);// 关闭放大窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置错误关闭操作

		// 用于关闭窗体事件
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		// 查看个人资料
		if (e.getSource() == btLookSelf) {
			String message = "您的详细资料为:\n";
			message += "学号：" + User.num + "\n";
			message += "姓名：" + User.name + "\n";
			message += "用户名：" + User.username + "\n";
			message += "性别：" + User.sex + "\n";
			message += "年龄：" + User.age + "\n";
			message += "班级：" + User.clas + "\n";
			JOptionPane.showMessageDialog(this, message);
		}
		// 修改个人资料
		else if (e.getSource() == btModify) {
			this.dispose();
			new ModifyDialog("固定学号：" + User.num);
		}
		// 查看书本信息
		else if (e.getSource() == btShowBook) {
			this.dispose();
			new ShowBook();
		}
		// 修改书本信息
		else if (e.getSource() == btModifyBook) {
			this.dispose();
			String ModifyBookNum = JOptionPane.showInputDialog("请输入您要修改的书本编号：");
			if (BooksFileOpe.findBook(ModifyBookNum)) {
				new ModifyBook(ModifyBookNum);
				return;
			}
			JOptionPane.showMessageDialog(this, "抱歉，系统中没有您要修改的书本信息！");
			new AdminFunction();
		}
		// 删除书本信息
		else if (e.getSource() == btDeleteBook) {
			this.dispose();
			String deleteBook = JOptionPane.showInputDialog("请输入您要删除的书本编号：");
			if (BooksFileOpe.findBook(deleteBook)) {
				BooksFileOpe.deleteBookNum(deleteBook);
				JOptionPane.showMessageDialog(this, "删除成功！");
				new AdminFunction();
				return;
			}
			JOptionPane.showMessageDialog(this, "抱歉，系统中没有您要删除的书本信息！");
			new AdminFunction();
		}
		// 增添书本信息
		else if (e.getSource() == btAddBook) {
			this.dispose();
			String ModifyBookNum = JOptionPane.showInputDialog("请输入您要添加的书本编号：");
			if (!BooksFileOpe.findBook(ModifyBookNum)) {
				new AddBook(ModifyBookNum);
				return;
			}
			JOptionPane.showMessageDialog(this, "抱歉，系统中已有您要添加的书本信息！");
			new AdminFunction();
		}
		// 退出系统
		else if (e.getSource() == btExit) {
			JOptionPane.showMessageDialog(this, "谢谢光临，欢迎下次继续使用本系统！");
			System.exit(0);
		}
	}
}
