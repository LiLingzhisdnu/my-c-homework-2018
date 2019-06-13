package Library;

/**
*  登录界面
*  346763079@qq.com
*  感谢@author hwt1070359898指导
**/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	// 按钮
	JButton btnLogin, btnRegister, btnCancel;
	// 创建中间容器
	JPanel pnlSouth, pnlNorth, pnlCenter, pnlCenter1, pnlCenter2;
	// 标签
	JLabel loginTiltle, loginNum, loginPassword, bg1;
	// 用户名文本框
	JTextField tfNum;
	// 密码文本框
	JPasswordField tfPwd;

	// 构造函数，创建窗口
	Login(String title) {
		super(title);

		// north
		pnlNorth = new JPanel();
		// 生成标签
		loginTiltle = new JLabel("欢迎进入老李家的图书管理系统！");
		loginTiltle.setFont(new Font("楷体", 1, 36));
		// 标签放入北部容器
		pnlNorth.add(loginTiltle);
		pnlNorth.setBackground(Color.pink);
		// 将容器添加到图形界面北部
		this.add(pnlNorth, BorderLayout.NORTH);
		// center
		pnlCenter = new JPanel();// 一级母容器
		pnlCenter1 = new JPanel();// 二级子容器
		pnlCenter2 = new JPanel();// 二级子容器
		// 一级母容器界面化
		pnlCenter.setLayout(new BorderLayout());
		// 生成标签
		loginNum = new JLabel("学   号：");
		loginNum.setFont(new Font("黑体", 1, 20));
		loginPassword = new JLabel("密   码：");
		loginPassword.setFont(new Font("黑体", 1, 20));
		// 生成文本框
		tfNum = new JTextField(15);
		tfPwd = new JPasswordField(15);
		// 放入二级中间容器
		pnlCenter1.add(loginNum);
		pnlCenter1.add(tfNum);
		pnlCenter2.add(loginPassword);
		pnlCenter2.add(tfPwd);
		pnlCenter1.setBackground(Color.orange);
		pnlCenter2.setBackground(Color.orange);
		// 二级容器添加到一级容器界面
		pnlCenter.add(pnlCenter1, BorderLayout.NORTH);
		pnlCenter.add(pnlCenter2, BorderLayout.SOUTH);
		pnlCenter.setBackground(Color.orange);
		// 一级容器添加到图形界面
		this.add(pnlCenter, BorderLayout.CENTER);

		// south
		pnlSouth = new JPanel();
		// 生成按钮
		btnLogin = new JButton("登录");
		btnLogin.setFont(new Font("楷体", 1, 24));
		btnLogin.addActionListener(this);
		btnRegister = new JButton("注册");
		btnRegister.setFont(new Font("楷体", 1, 24));
		btnRegister.addActionListener(this);
		btnCancel = new JButton("退出");
		btnCancel.setFont(new Font("楷体", 1, 24));
		btnCancel.setBackground(Color.RED);
		btnCancel.addActionListener(this);
		// 将三个按钮放在一个中间容器中
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnRegister);
		pnlSouth.add(btnCancel);
		pnlSouth.setBackground(Color.green);
		// 将按钮添加到图形界面
		this.add(pnlSouth, BorderLayout.SOUTH);

		this.setSize(650, 230);// 确定图形界面大小
		GUIUtil.toCenter(this);// 使窗口居中
		this.setVisible(true);// 可视化
		this.setResizable(false);// 关闭放大窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置错误关闭操作

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			String num = tfNum.getText();
			String pwd = tfPwd.getText();
			FileOpe.getInfoByAccount(num);

			/************************** 设置管理员账号密码 *********************************/
			if (User.num.equals("201711010326") && User.pwd.equals(pwd)) {
				JOptionPane.showMessageDialog(this, "恭喜您，登陆成功！");
				this.dispose();// 关闭界面，释放资源，转跳
				// 登录管理员界面，调用管理员类
				new AdminFunction();
			} else if (User.num.equals("201711010333") && User.pwd.equals(pwd)) {
				JOptionPane.showMessageDialog(this, "恭喜您，登陆成功！");
				this.dispose();// 关闭界面，释放资源，转跳
				// 登录管理员界面，调用管理员类
				new AdminFunction();
			}
			// 可以添加新的管理员账户…………
			/******************************************************************************/

			else if (!User.num.equals(num)) {
				JOptionPane.showMessageDialog(this, "您输入的账号不存在，请重新输入！");
				return;
			} else if (!User.pwd.equals(pwd)) {
				JOptionPane.showMessageDialog(this, "您输入的密码错误，请重新输入！");
				return;
			} else {
				JOptionPane.showMessageDialog(this, "恭喜您，登陆成功！");
				this.dispose();// 关闭界面，释放资源，转跳
				// 登录用户界面，调用用户类
				new UserFunction();
			}
		}
		// 注册
		else if (e.getSource() == btnRegister) {
			dispose();//// 关闭界面，释放资源，转跳
			// 登录注册界面，调用注册类
			new Register("用户注册");
		}
		// 退出
		else {
			JOptionPane.showMessageDialog(this, "谢谢使用，欢迎下次再次使用本系统！");
			System.exit(0);// 结束运行
		}

	}
}
