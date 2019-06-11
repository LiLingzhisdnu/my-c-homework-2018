package Library;

/**
* 借阅书籍
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

public class Takebook extends JFrame implements ActionListener {

	//标签
	JLabel jLBookAuthor,jLBookLoan;
	// 按钮
	private JButton btnModify, btnReset, btnCancel;
	// 是否借出
	private JRadioButton Yes, No;
	private String bookNum;

	// 创建窗口
	public Takebook(String bN) {
		bookNum = bN;

		this.setTitle("图书编号：" + bookNum);

		this.setLayout(new FlowLayout());

		jLBookAuthor = new JLabel("         图书借还        ", JLabel.CENTER);
		jLBookAuthor.setFont(new Font("楷体", 1, 36));
		this.add(jLBookAuthor);

		// 设置字体大小
		Font font = new Font("黑体", 1, 20);
		jLBookLoan = new JLabel("是 否 借 还：");
		jLBookLoan.setFont(font);

		Yes = new JRadioButton("借书");
		Yes.setFont(font);
		No = new JRadioButton("还书");
		No.setSelected(true);// 默认选还书
		No.setFont(font);
		ButtonGroup group = new ButtonGroup();
		group.add(Yes);
		group.add(No);

		// 按钮
		btnModify = new JButton("确定");
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

		this.add(jLBookAuthor);
		this.add(jLBookLoan);
		this.add(Yes);
		this.add(No);

		pnrSouth.setBackground(Color.orange);
		this.add(pnrSouth, BorderLayout.SOUTH);// 将放按钮的容器加到主容器中

		this.setSize(400, 220);
		GUIUtil.toCenter(this);// 使窗口居中
		this.setVisible(true);// 可视化
		this.setResizable(false);// 关闭放大窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置错误关闭操作
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		// 重置按钮/
		if (jb == btnReset) {
			// readInfo();
			No.setSelected(true);
		} 
		//修改按钮
		else if (jb == btnModify) {

			String loan = Yes.isSelected() ? "已借出" : "未借出";
			BooksFileOpe.getInfoByAccount(bookNum);
			BooksFileOpe.getInfoByAccount(bookNum);
			BooksFileOpe.updateCustomer(bookNum, Books.bookType, Books.bookName, Books.bookAuthor, Books.bookPress, Books.bookPrice, loan);
			JOptionPane.showMessageDialog(this, "恭喜您，书本借还成功！");
			this.dispose();
			new UserFunction();
		} 
		//取消按钮
		else if (jb == btnCancel) {
			this.dispose();
			new UserFunction();
		}
	}

}
