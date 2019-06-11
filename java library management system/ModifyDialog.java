package Library;

/**
*  修改个人信息界面
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
import javax.xml.crypto.KeySelector.Purpose;

public class ModifyDialog extends JFrame implements ActionListener {
	// 按钮
	private JButton btnModify, btnReset, btnCancel;
	// 标签
	private JLabel jtNum, jLabelName, UserName, jLabelUserName, jLabelPwd, jLabelSurePwd, jLabelSex, jLabelAge,
			jLabelClass;// 学号，姓名，用户名，密码，确认密码，性别，年龄，所属班级
	// 用户名文本框
	private JTextField jtName, jtUserName, jtAge;
	// 密码文本框
	private JPasswordField jtPwd, jtSurePwd;
	// 性别选项
	private JRadioButton man, woman;
	// 班级下拉菜单
	private JComboBox jtClass;

	// 创建窗口
	public ModifyDialog(String string) {
		this.setTitle(string);
		this.setLayout(new FlowLayout());

		UserName = new JLabel("         修改个人资料        ", JLabel.CENTER);
		UserName.setFont(new Font("楷体", 1, 36));
		this.add(UserName);

		// 设置字体大小
		Font font = new Font("黑体", 1, 20);

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
		jtAge = new JTextField(6);

		jLabelClass = new JLabel("所属班级：");
		jLabelClass.setFont(font);
		String[] str = { "计本1701班", "计师本1701班", "计工本1701班", "计工本1702班", "计工本1703班", "计工本1703班", "计工本1704班", "计信本1701班",
				"老师" };
		jtClass = new JComboBox(str);
		jtClass.setFont(font);

		// 按钮
		btnModify = new JButton("修改");
		btnModify.setFont(new Font("楷体", 1, 24));
		btnModify.addActionListener(this);
		btnReset = new JButton("重置");
		btnReset.setFont(new Font("楷体", 1, 24));
		btnReset.addActionListener(this);
		btnCancel = new JButton("取消");
		btnCancel.setFont(new Font("楷体", 1, 24));
		btnCancel.addActionListener(this);

		JPanel pnrSouth = new JPanel();

		// 将按钮加到一个专门放按钮的容器中
		pnrSouth.add(btnModify);
		pnrSouth.add(btnReset);
		pnrSouth.add(btnCancel);

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
		pnrSouth.setBackground(Color.orange);
		this.add(pnrSouth, BorderLayout.SOUTH);// 将放按钮的容器加到主容器中

		this.setSize(400, 340);
		GUIUtil.toCenter(this);// 使窗口居中
		this.setVisible(true);// 可视化
		this.setResizable(false);// 关闭放大窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置错误关闭操作

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		// 重置按钮
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
		// 修改按钮
		else if (jb == btnModify) {

			String name = jtName.getText().trim();
			String username = jtUserName.getText().trim();
			String pwd = new String(jtPwd.getPassword());
			String surepwd = new String(jtSurePwd.getPassword());
			String sex = man.isSelected() ? "男" : "女";
			String age = jtAge.getText().trim();
			String clas = (String) jtClass.getSelectedItem();

			if (name.equals("") || username.equals("") || pwd.equals("") || surepwd.equals("") || age.equals("")) {// 判断资料是否填写完整
				JOptionPane.showMessageDialog(null, "请完整填写所有的信息！", "提示", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!pwd.equals(surepwd)) {// 判断两次输入密码是否相同
				JOptionPane.showMessageDialog(this, "两次输入的密码不同，请您重新输入！");
				return;
			}

			// 将新的值存入静态变量
			User.name = name;
			User.username = username;
			User.pwd = pwd;
			User.sex = sex;
			User.age = age;
			User.clas = clas;

			FileOpe.updateCustomer(User.num, name, username, pwd, sex, age, clas);
			JOptionPane.showMessageDialog(this, "恭喜您，修改成功！");
			this.dispose();
			new Login("用户登录！");
		}
		// 取消
		else {
			this.dispose();
			// 退回管理员界面
			if (User.num.equals("201711010326")) {
				new AdminFunction();
				return;
			} else if (User.num.equals("201711010333")) {
				new AdminFunction();
				return;
			}
			new UserFunction();
		}
	}
}