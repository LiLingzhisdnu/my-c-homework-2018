package Library;

/**
*  注册界面
*  346763079@qq.com
*  感谢@author hwt1070359898指导
**/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener {

	// 按钮
	private JButton btnRegister, btnReset, btnCancel;
	// 标签
	private JLabel jLabelNum, jLabelName, UserName, jLabelUserName, jLabelPwd, jLabelSurePwd, jLabelSex, jLabelAge,
			jLabelClass;// 学号，姓名，用户名，密码，确认密码，性别，年龄，所属班级
	// 用户信息文本框
	private JTextField jtNum, jtName, jtUserName, jtAge;
	// 密码文本框
	private JPasswordField jtPwd, jtSurePwd;
	// 性别选项
	private JRadioButton man, woman;
	// 班级下拉菜单
	private JComboBox jtClass;
	// 下拉框
	private JComboBox jcb;

	// 构造函数，创建窗口
	public Register(String string) {
		this.setTitle("用户注册");
		this.setLayout(new FlowLayout());

		// 标题
		UserName = new JLabel("     用户注册     ", JLabel.CENTER);
		UserName.setFont(new Font("楷体", 1, 36));
		this.add(UserName);

		// 设置字体大小
		Font font = new Font("黑体", 1, 20);
		// 标签、文本框
		jLabelNum = new JLabel("学    号：");
		jLabelNum.setFont(font);
		jtNum = new JTextField(20);
		jLabelName = new JLabel("姓    名：");
		jLabelName.setFont(font);
		jtName = new JTextField(20);
		jLabelUserName = new JLabel("用 户 名：");
		jLabelUserName.setFont(font);
		jtUserName = new JTextField(20);
		jLabelPwd = new JLabel("密    码：");
		jLabelPwd.setFont(font);
		jtPwd = new JPasswordField(20);
		jLabelSurePwd = new JLabel("确认密码：");
		jLabelSurePwd.setFont(font);
		jtSurePwd = new JPasswordField(20);
		jLabelSex = new JLabel("性    别：");
		jLabelSex.setFont(font);
		man = new JRadioButton("男");
		man.setSelected(true);// 默认选男性
		man.setFont(font);
		woman = new JRadioButton("女");
		woman.setFont(font);
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
		jLabelAge = new JLabel("年龄：");
		jLabelAge.setFont(font);
		jtAge = new JTextField(4);
		jLabelClass = new JLabel("所属班级：");
		jLabelClass.setFont(font);
		String[] str = { "计本1701班", "计师本1701班", "计工本1701班", "计工本1702班", "计工本1703班", "计工本1703班", "计工本1704班", "计信本1701班",
				"老师" };
		jtClass = new JComboBox(str);
		jtClass.setFont(font);

		// 按钮
		btnRegister = new JButton("注册");
		btnRegister.setFont(new Font("楷体", 1, 24));
		btnRegister.addActionListener(this);
		btnReset = new JButton("重置");
		btnReset.setFont(new Font("楷体", 1, 24));
		btnReset.addActionListener(this);
		btnCancel = new JButton("取消");
		btnCancel.setFont(new Font("楷体", 1, 24));
		btnCancel.setBackground(Color.RED);
		btnCancel.addActionListener(this);

		// 将按钮加到一个专门放按钮的容器中
		JPanel pnrSouth = new JPanel();
		pnrSouth.add(btnRegister);
		pnrSouth.add(btnReset);
		pnrSouth.add(btnCancel);
		pnrSouth.setBackground(Color.orange);

		// 将标签文本框加入图形界面
		this.add(jLabelNum);
		this.add(jtNum);
		this.add(jLabelName);
		this.add(jtName);
		this.add(jLabelUserName);
		this.add(jtUserName);
		this.add(jLabelPwd);
		this.add(jtPwd);
		this.add(jLabelSurePwd);
		this.add(jtSurePwd);
		this.add(jLabelSex);
		this.add(man);
		this.add(woman);
		this.add(jLabelAge);
		this.add(jtAge);
		this.add(jLabelClass);
		this.add(jtClass);

		// 将放按钮的容器加到界面中
		this.add(pnrSouth, BorderLayout.SOUTH);

		this.setSize(400, 380);// 界面大小
		GUIUtil.toCenter(this);// 使窗口居中
		this.setVisible(true);// 可视化
		this.setResizable(false);// 关闭放大窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置错误关闭操作
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		// 重置
		if (jb == btnReset) {
			// readInfo();
			jtNum.setText("");
			jtName.setText("");
			jtUserName.setText("");
			jtPwd.setText("");
			jtSurePwd.setText("");
			man.setSelected(true);
			jtAge.setText("");
			jtClass.setSelectedIndex(0);// 选中第一个班级
		}
		// 注册
		else if (jb == btnRegister) {
			String num = jtNum.getText().trim();
			String name = jtName.getText().trim();
			String username = jtUserName.getText().trim();
			String pwd = new String(jtPwd.getPassword());
			String surepwd = new String(jtSurePwd.getPassword());
			String sex = man.isSelected() ? "男" : "女";
			String age = jtAge.getText().trim();
			String clas = (String) jtClass.getSelectedItem();

			if (num.equals("") || name.equals("") || username.equals("") || pwd.equals("") || surepwd.equals("")
					|| age.equals("")) {// 判断资料是否填写完整
				JOptionPane.showMessageDialog(null, "请完整填写所有的信息！", "提示", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!pwd.equals(surepwd)) {// 判断两次输入密码是否相同
				JOptionPane.showMessageDialog(this, "两次输入的密码不同，请您重新输入！");
				return;
			}
			FileOpe.getInfoByAccount(num);
			if (User.num != "#") {// 判断用户是否已经注册过
				JOptionPane.showMessageDialog(this, "该用户已经注册，请您直接登录或者重新注册！");
				this.dispose();
				new Login("用户登录！");
				return;
			}
			// 写入记录文件
			FileOpe.updateCustomer(num, name, username, pwd, sex, age, clas);
			JOptionPane.showMessageDialog(this, "恭喜您，注册成功！");
			this.dispose();
			new Login("用户登录！");
		}
		// 取消
		else if (jb == btnCancel) {
			this.dispose();
			new Login("用户登录！");
		}
	}
}
