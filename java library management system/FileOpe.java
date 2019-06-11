package Library;

/**
* 执行打开、写入、关闭用户信息文件操作
 * 346763079@qq.com
*  感谢@author hwt1070359898指导
**/

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class FileOpe {

	// 存放用户信息的文件
	private static String fileName = "User1.txt";
	// Properties类表示一个属性集
	private static Properties pps;

	// 下面的内容，写入后就是固定的，所以用一个static模块把它保存起来
	// 将用户文件内容按行输入属性集
	static {
		// new一个Properties的属性集对象
		pps = new Properties();
		// 定义读取文本文件对象
		FileReader reader = null;
		try {
			// 读取用户信息的文件
			reader = new FileReader(fileName);
			// 将文件内容按行输入属性集
			pps.load(reader);
		} catch (Exception ex) {
			// 用户信息的文件不存在
			JOptionPane.showMessageDialog(null, "您需要存入信息的文件不存在！");
			System.exit(0);
		} finally {
			try {
				reader.close();// 关闭文件
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 将属性集里的信息打印到用户文件
	private static void listInfo() {
		// 定义打印对象
		PrintStream ps = null;
		// 为其他输出流添加了功能，使它们能够方便的打印各种数据值的表示形式
		try {
			// 创建新的打印流，打印输入到文件里
			ps = new PrintStream(fileName);
			pps.list(ps);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "文件操作异常！");
			System.exit(0);
		} finally {
			try {
				ps.close();// 关闭文件
			} catch (Exception ex) {
			}
		}
	}

	// 获取信息账户
	public static void getInfoByAccount(String num) {
		// 用指定的键，在此属性下标中搜索属性
		String cusInfo = pps.getProperty(num);
		if (cusInfo != null) {
			// 将搜索到的属性以“#”分割开来
			String[] infos = cusInfo.split("#");
			// 将每段赋值输出
			User.num = num;
			User.name = infos[0];
			User.username = infos[1];
			User.pwd = infos[2];
			User.sex = infos[3];
			User.age = infos[4];
			User.clas = infos[5];
		}
	}

	public static void updateCustomer(String num, String name, String username, String pwd, String sex, String age,
			String clas) {// 修改信息
		pps.setProperty(num, name + "#" + username + "#" + pwd + "#" + sex + "#" + age + "#" + clas);// 默认分隔符“=“
		listInfo();
	}
}