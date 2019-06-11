package Library;

/**
 *  执行打开、写入、关闭书本信息文件操作
 *  346763079@qq.com
 *  感谢@author hwt1070359898指导
 **/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

public class BooksFileOpe {
	// 存放用户信息的文件
	private static String filebook = "Books.txt";
	// 存储图书编号的文件
	private static String filebookNum = "BooksNum.txt";
	// Properties类表示一个属性集
	private static Properties pps;
	// 下面的内容，写入后就是固定的，所以用一个static模块把它保存起来
	static {
		// new一个Properties的属性集对象
		pps = new Properties();
		// 读取文本文件
		FileReader reader = null;
		try {
			// 读取文本文件
			reader = new FileReader(filebook);
			// 按行放入属性列表
			pps.load(reader);
		} catch (Exception ex) {
			// 存入的文件不存在
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

	private static void listInfo() {
		// 写入文件
		PrintStream ps = null;
		// 为其他输出流添加了功能，使它们能够方便的打印各种数据值的表示形式
		try {
			// 创建新的打印流
			ps = new PrintStream(filebook);
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

	// 查找当前图书是否在列表中
	public static boolean findBook(String findbook) {
		try {
			FileReader file = new FileReader(filebookNum);
			BufferedReader buff = new BufferedReader(file);
			String line = null;

			while ((line = buff.readLine()) != null) {
				if (line.equals(findbook)) {
					return true;
				}
			}
			file.close();
			buff.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	// 将图书编码写入num表
	public static void saveBookNum(String bookNum) {

		FileWriter fw = null;
		try {
			File file = new File(filebookNum);
			fw = new FileWriter(file, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(bookNum);
		pw.flush();
		try {
			fw.close();
			pw.close();
			fw.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	// 刪除
	public static void deleteBookNum(String deletebookNum) {
		// 删除num表信息
		File file = new File(filebookNum);
		Long fileLength = file.length();
		byte[] fileContext = new byte[fileLength.intValue()];
		FileInputStream in = null;
		PrintWriter out = null;
		try {
			in = new FileInputStream(filebookNum);
			in.read(fileContext);
			// 避免出现中文乱码
			String str = new String(fileContext, "utf-8");
			str = str.replace(deletebookNum + "\r\n", "");
			out = new PrintWriter(filebookNum);
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 删除book表信息
		File file2 = new File(filebook);
		Long fileLength2 = file2.length();
		byte[] fileContext2 = new byte[fileLength2.intValue()];
		FileInputStream in2 = null;
		PrintWriter out2 = null;
		try {
			in2 = new FileInputStream(filebook);
			in2.read(fileContext2);
			// 避免出现中文乱码
			String str2 = new String(fileContext2, "utf-8");
			str2 = str2.replace(deletebookNum + "=" + pps.getProperty(deletebookNum) + "\r\n", "");
			out2 = new PrintWriter(filebook);
			out2.write(str2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out2.flush();
				out2.close();
				in2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 获取文件中所有已注册的图书编号，以数组返回
	public static ArrayList getAllbookNum(ArrayList allbookNum) {
		try {
			FileReader file = new FileReader(filebookNum);
			BufferedReader buff = new BufferedReader(file);
			String line = null;

			while ((line = buff.readLine()) != null) {
				allbookNum.add(line);
			}
			file.close();
			buff.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return allbookNum;
	}

	// 获取信息账户
	public static void getInfoByAccount(String bookNum) {
		String cusInfo = pps.getProperty(bookNum);// 用指定的键，在此属性中搜索属性
		if (cusInfo != null) {
			String[] infos = cusInfo.split("#");// 将搜索到的属性以“#”分割开来
			Books.bookNum = bookNum;
			Books.bookType = infos[0];
			Books.bookName = infos[1];
			Books.bookAuthor = infos[2];
			Books.bookLoan = infos[3];
			Books.bookPrice = infos[4];
			Books.bookPress = infos[5];
		}
	}

	// 修改信息
	public static void updateCustomer(String bookNum, String bookType, String bookName, String bookAuthor,
			String bookLoan, String bookPrice, String bookPress) {
		pps.setProperty(bookNum,
				bookType + "#" + bookName + "#" + bookAuthor + "#" + bookLoan + "#" + bookPrice + "#" + bookPress);
		listInfo();
		// writeBookNum(bookNumFile,bookNum);
	}
}