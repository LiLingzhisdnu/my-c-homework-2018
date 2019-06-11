package Library;

/**
* 修改书本信息
 * 346763079@qq.com
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

public class ModifyBook extends JFrame implements ActionListener {

	// 按钮
	private JButton btnModify, btnReset, btnCancel;
	// 标签
	private JLabel jLBookNum, jLBookType, jLBookName, jLBookAuthor, jLBookPress, jLBookPrice, jLBookLoan;
	// 用户名文本框
	private JTextField jtBookNum, jtBookName, jtBookAuthor, jtBookPress, jtBookPrice, jtBookLoan;
	// 是否借出
	private JRadioButton Yes, No;
	// 班级下拉菜单
	private JComboBox jtBookType;

	private String bookNum;

	// 创建窗口
	public ModifyBook(String bN) {
		bookNum = bN;

		this.setTitle("图书编号：" + bookNum);

		this.setLayout(new FlowLayout());

		jLBookAuthor = new JLabel("         修改书本信息        ", JLabel.CENTER);
		jLBookAuthor.setFont(new Font("楷体", 1, 36));
		this.add(jLBookAuthor);

		// 设置字体大小
		Font font = new Font("黑体", 1, 20);

		jLBookType = new JLabel(" 图书类型：");
		jLBookType.setFont(font);
		String[] str = { "现代文类", "古代文学", "外国文学", "教学辅导", "科普常识", "小说", "娱乐", "报纸", "社科知识", "工学知识", "理学知识", "文献论文" };
		jtBookType = new JComboBox(str);
		jtBookType.setFont(font);
		jLBookName = new JLabel("书    名：");
		jLBookName.setFont(font);
		jtBookName = new JTextField(20);
		jLBookAuthor = new JLabel("作    者：");
		jLBookAuthor.setFont(font);
		jtBookAuthor = new JTextField(20);
		jLBookPress = new JLabel("出 版 社：");
		jLBookPress.setFont(font);
		jtBookPress = new JTextField(20);
		jLBookPrice = new JLabel("价    格：");
		jLBookPrice.setFont(font);
		jtBookPrice = new JTextField(20);
		jLBookLoan = new JLabel("是 否 借 出：");
		jLBookLoan.setFont(font);

		Yes = new JRadioButton("已借出");
		Yes.setFont(font);
		No = new JRadioButton("未借出");
		No.setSelected(true);// 默认选未借出
		No.setFont(font);
		ButtonGroup group = new ButtonGroup();
		group.add(Yes);
		group.add(No);

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

//		this.add(jLBookNum);
//		this.add(jtBookNum);

		this.add(jLBookName);
		this.add(jtBookName);
		this.add(jLBookAuthor);
		this.add(jtBookAuthor);
		this.add(jLBookPress);
		this.add(jtBookPress);
		this.add(jLBookPrice);
		this.add(jtBookPrice);

		this.add(jLBookLoan);
		this.add(Yes);
		this.add(No);
		this.add(jLBookType);
		this.add(jtBookType);

		pnrSouth.setBackground(Color.orange);
		this.add(pnrSouth, BorderLayout.SOUTH);// 将放按钮的容器加到主容器中

		this.setSize(400, 380);
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
			jtBookName.setText("");
			jtBookAuthor.setText("");
			jtBookPress.setText("");
			jtBookPrice.setText("");
			No.setSelected(true);
			jtBookType.setSelectedIndex(0);// 选中第一个班级（计算机科学与技术一班）

		}
		// 修改按钮
		else if (jb == btnModify) {

			String type = (String) jtBookType.getSelectedItem();
			String name = jtBookName.getText().trim();
			String author = jtBookAuthor.getText().trim();
			String press = jtBookPress.getText().trim();
			String price = jtBookPrice.getText().trim();
			String loan = Yes.isSelected() ? "已借出" : "未借出";

			if (name.equals("") || author.equals("") || press.equals("") || price.equals("")) {// 判断资料是否填写完整
				JOptionPane.showMessageDialog(null, "请完整填写所有的信息！", "提示", JOptionPane.WARNING_MESSAGE);
				return;
			}

			BooksFileOpe.getInfoByAccount(bookNum);
			BooksFileOpe.updateCustomer(bookNum, type, name, author, press, price, loan);
			JOptionPane.showMessageDialog(this, "恭喜您，书本信息修改成功！");
			this.dispose();
			new AdminFunction();
		}
		// 取消
		else if (jb == btnCancel) {
			this.dispose();
			new AdminFunction();
		}
	}

}
