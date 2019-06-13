package Library;

/**
*  用户功能界面
*  346763079@qq.com
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserFunction extends Frame implements ActionListener {
	// 定义各个控件
	private JButton btLookSelf = new JButton("查看个人资料");
	private JButton btModify = new JButton("修改个人资料");
	private JButton btLookBooks = new JButton("查看书库信息");
	private JButton btExit = new JButton("退出系统");
	private JButton btTake = new JButton("图书借还");

	public UserFunction() {

		super("用户：" + User.num);// 串口标题
		this.setLayout(null);// 设置为手工设置各个组件的位置和大小

		btLookSelf.setBounds(new Rectangle(50, 80, 300, 50));// 修改个人资料
		btModify.setBounds(new Rectangle(50, 150, 300, 50));// 修改个人资料
		btLookBooks.setBounds(new Rectangle(50, 220, 300, 50));// 查看书库信息
		btTake.setBounds(new Rectangle(50, 290, 300, 50));// 图书借还
		btExit.setBounds(new Rectangle(50, 360, 300, 50));// 退出系统

		btExit.setBackground(Color.RED);// 退出键颜色

		btLookSelf.setFont(new Font("楷体", 1, 24));
		btModify.setFont(new Font("楷体", 1, 24));
		btLookBooks.setFont(new Font("楷体", 1, 24));
		btExit.setFont(new Font("楷体", 1, 24));
		btTake.setFont(new Font("楷体", 1, 24));
		
		//监听者
		btLookSelf.addActionListener(this);
		btModify.addActionListener(this);
		btLookBooks.addActionListener(this);
		btExit.addActionListener(this);
		btTake.addActionListener(this);

		this.add(btLookSelf);
		this.add(btModify);
		this.add(btLookBooks);
		this.add(btTake);
		this.add(btExit);

		this.setSize(400, 450);

		GUIUtil.toCenter(this);// 使窗口居中
		this.setVisible(true);// 可视化
		this.setBackground(Color.yellow);
		this.setResizable(false);// 关闭放大窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置错误关闭操作

		// 用于关闭窗体事件
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//查看资料
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
		//修改个人信息
		else if (e.getSource() == btModify) {
			new ModifyDialog("固定学号：" + User.num);
			this.dispose();
		} 
		//查看书库
		else if (e.getSource() == btLookBooks) {
			this.dispose();
			new ShowBook();
		}
		//借还
		else if (e.getSource() == btTake) {
			this.dispose();
			String ModifyBookNum = JOptionPane.showInputDialog("请输入您要借还的书本编号：");
			if (BooksFileOpe.findBook(ModifyBookNum)) {
				new Takebook(ModifyBookNum,User.num);
				return;
			}
			JOptionPane.showMessageDialog(this, "抱歉，系统中没有您要借还的书本信息！");
			new UserFunction();
			} 
		//退出
		else if (e.getSource() == btExit) {
			JOptionPane.showMessageDialog(this, "谢谢光临，欢迎下次继续使用本系统！");
			System.exit(0);
		}
	}
}
