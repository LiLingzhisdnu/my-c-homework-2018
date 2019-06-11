package Library;

/**
* 显示书库
 * 346763079@qq.com
*  感谢@author hwt1070359898指导
**/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowBook extends Frame implements ActionListener {

	// 定义各个控件
	private JButton btExit = new JButton("返回");
	// 屏幕空间
	JFrame frame = new JFrame("书库");

	public ShowBook() {
		final Object[] columnNames = { "图书编号", "图书类型", "书名", "作者", "出版社", "价格", "是否借出" };// 表头

		// 用一个可变数组存储所有的图书编号
		ArrayList allbookNum = new ArrayList();
		allbookNum = BooksFileOpe.getAllbookNum(allbookNum);

		Object[][] rowData = new Object[allbookNum.size()][7];
		for (int i = 1; i < allbookNum.size(); i++) {
			BooksFileOpe.getInfoByAccount((String) allbookNum.get(i));
			rowData[i][0] = allbookNum.get(i);
			rowData[i][1] = Books.bookType;
			rowData[i][2] = Books.bookName;
			rowData[i][3] = Books.bookAuthor;
			rowData[i][4] = Books.bookLoan;
			rowData[i][5] = Books.bookPrice;
			rowData[i][6] = Books.bookPress;
		}

		JTable friends = new JTable(rowData, columnNames);

		friends.setPreferredScrollableViewportSize(new Dimension(900, 800));// 设置表格的大小

		friends.setRowHeight(30);// 设置每行的高度为30
		friends.setRowMargin(5);// 设置相邻两行单元格的距离
		friends.setRowSelectionAllowed(false);// 设置可否被选择，默认为false

		friends.setSelectionBackground(Color.white);// 设置所选行的背景色

		friends.setSelectionForeground(Color.red);// 设置所选行的前景色

		friends.setGridColor(Color.black);// 设置网格线的颜色
		// friends.selectAll();//选择所有行
		// friends.setRowSelectionInterval(0,2);//设置初始的选择行

		// friends.clearSelection();//取消选择
		// friends.setDragEnabled(false);

		friends.setShowGrid(true);// 是否显示网格线
		friends.setShowHorizontalLines(true);// 是否显示水平的网格线
		friends.setShowVerticalLines(true);// 是否显示垂直的网格线

		friends.doLayout();
		friends.setBackground(Color.white);

		friends.setEnabled(false);// 设置表格为不可编辑
		friends.getTableHeader().setReorderingAllowed(false);// 设置表头不可移动

		// JScrollPane pane1 = new JScrollPane(example1);
		// JScrollPane pane2 = new JScrollPane(example2);
		JScrollPane pane3 = new JScrollPane(friends);

		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.setPreferredSize(new Dimension(900, 500));

		panel.setBackground(Color.black);
		// panel.add(pane1);
		// panel.add(pane2);

		panel.add(pane3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		GUIUtil.toCenter(frame);// 使窗口居中
		frame.setSize(900, 600);
		frame.show();
		frame.setBackground(Color.orange);

		btExit.setBackground(Color.RED);// 退出键颜色
		btExit.setFont(new Font("楷体", 1, 24));// 设置文字大小
		// 监听器
		btExit.addActionListener(this);
		// 容器
		JPanel pnrSouth = new JPanel();
		pnrSouth.add(btExit);
		frame.add(pnrSouth, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btExit) {
			frame.dispose();
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
