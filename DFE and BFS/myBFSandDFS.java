//为统一1号节点和a[1],将所有a[0]空出
package li.lingzhi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*//辅助队列类
class SqQueue {
	private int[] elements;
	private int base = 1;// 指向队列第一个空格
	private int top = 1;// 指向队列最后一个位置上方
	public static final int CAPY = 16;
	Scanner input = new Scanner(System.in);

	// 构造函数
	public SqQueue() {
		this(CAPY);
	}

	// 构造函数
	public SqQueue(int capy) {
		elements = new int[capy + 1];
		top = 1;
	}

	// 入队
	public void push(int value) {
		// int value = input.nextInt();手动入队模式
		if (top >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			// 若复制的为数值，操作新数组不会影响旧数组；若复制的是二维数组，复制的是一位数组的引用，操作会影响原来的数组
			elements = temp;// 使用新数组做栈
		}
		elements[top] = value;
		top++;
	}

	// 出队
	public int pop() {
		if (empty()) {
			System.out.println("是空队");
			return 0;
		} else {
			int a = elements[base];// a为对象，可以把数值带出
			for (int i = 1; i < top; i++) {
				elements[i] = elements[i + 1];
			}
			elements[top] = 0;
			top--;
			return a;
		}
	}

	// 检查是否为空队
	public boolean empty() {
		return top == 1;
	}
}*/

//节点类
class mVertex1 {
	// 节点名称
	String name;
	// 指向下一个顶点的引用
	mVertex1 next;

	// 构造函数
	public mVertex1() {
	}

	// 构建函数
	public void createVertex1(int a, mVertex1 b) {
		name = 'V' + "" + a;// (使用""+int,可以把int转换为显示相同的String）
		next = b;
	}
}

//邻接表类
class mGraph1 {
	private Scanner input = new Scanner(System.in);
	// 节点组
	mVertex1[] vertexArray;
	// 图的当前顶点数和边数
	int verNum;
	int edgeNum;

	// 构造函数
	public mGraph1() {
	}

	// 前插法构建函数
	public void createGraph1(int num, Graph2 adj) {
		vertexArray = new mVertex1[adj.s + 1];
		verNum = num;
		edgeNum = num - 1;
		for (int i = 1; i < num + 1; i++) {

			// 对头结点进行操作
			vertexArray[i] = new mVertex1();
			vertexArray[i].createVertex1(i, null);

			for (int j = 1; j <= edgeNum + 1; j++) {
				// 因为在邻接矩阵中自己连自己为0，所以可以用下列内容
				// 前插法构建邻接表
				if (adj.adjMatrix[i][j] == 1 && vertexArray[i].next == null) {
					mVertex1 s = new mVertex1();
					s.name = 'V' + "" + (j);
					s.next = null;
					vertexArray[i].next = s;
				} else if (adj.adjMatrix[i][j] == 1 && vertexArray[i].next != null) {
					mVertex1 s = new mVertex1();
					s.name = 'V' + "" + (j);
					s.next = vertexArray[i].next;
					vertexArray[i].next = s;
				}
			}
		}
	}

	// 后插法构建函数
	public void createGraph2(int num, Graph2 adj) {
		vertexArray = new mVertex1[adj.s + 1];
		verNum = num;
		edgeNum = num - 1;
		for (int i = 1; i < num + 1; i++) {

			// 对头结点进行操作
			vertexArray[i] = new mVertex1();
			vertexArray[i].createVertex1(i, null);

			// 在遍历中确定位置的中间节点
			mVertex1 key = vertexArray[i];
			for (int j = 1; j <= edgeNum + 1; j++) {
				// 因为在邻接矩阵中自己连自己为0，所以可以用下列内容
				// 后插法构建邻接表
				if (adj.adjMatrix[i][j] == 1 && key != null) {
					mVertex1 s = new mVertex1();
					s.name = 'V' + "" + (j);
					s.next = key.next;
					key.next = s;
					key = s;
				}
			}
		}
	}

	// 展示函数
	public void playGraph1() {
		System.out.println("该邻接表为：");
		for (int i = 1; i < verNum + 1; i++) {
			System.out.print(vertexArray[i].name);
			mVertex1 mynext = vertexArray[i];
			for (int j = 1; j < edgeNum + 1; j++) {
				if (mynext != null) {
					mynext = mynext.next;
					if (mynext != null) {
						System.out.print(" ----> ");
						System.out.print(mynext.name);
					}
				}
			}
			System.out.println();
		}
	}

	// 邻接表的BFS
	public void Graph1BFS() {
		
		int[] visited = new int[verNum + 1];// 判断是否访问
		System.out.println("想要从哪个节点开始遍历：");
		int v =0;
		do {
			try {
				v = input.nextInt();
				if(v <= 0 || v > verNum)
					throw new Exception("范围不对");
			}
			catch (InputMismatchException ex) {
				System.out.println("类型不符合，请重新输入:");
				String cString =input.nextLine();
				cString.length();
			}
			catch (Exception ex) {
				System.out.println("范围不符合，请重新输入:");
			}
		}while(v <= 0 || v > verNum);//异常处理
		ArrayList<Integer> Q = new ArrayList<>();// 辅助队列初始化
		Q.add(v);// 开始节点入队
		System.out.print("V" + v);
		visited[v] = 1;
		String ssss;
		mVertex1 key;
		while (!Q.isEmpty()) {
			v=Q.get(0);
			Q.remove(0);
			key = vertexArray[v];
			while (key.next != null) {
				key = key.next;
				ssss = key.name.substring(1);
				if (visited[Integer.parseInt(ssss)] == 1)
					continue;
				Q.add(Integer.parseInt(ssss));// 该节点入队
				System.out.print("---> " + key.name);
				visited[Integer.parseInt(ssss)] = 1;
			}
		}
		System.out.println();
	}

	// 因为深度优先遍历要采用递归算法，所以设置输入函数
	public void inputGraph1DFS() {
		int[] visited = new int[verNum + 1];// 判断是否访问
		System.out.println("想要从哪个节点开始遍历：");
		int v =0;
		do {
			try {
				v = input.nextInt();
				if(v <= 0 || v > verNum)
					throw new Exception("范围不对");
			}
			catch (InputMismatchException ex) {
				System.out.println("类型不符合，请重新输入:");
				String cString =input.nextLine();
				cString.length();
			}
			catch (Exception ex) {
				System.out.println("范围不符合，请重新输入:");
			}
		}while(v <= 0 || v > verNum);//异常处理
		System.out.print("V" + v);
		visited[v] = 1;
		Graph1DFS(v, visited);// 调用递归函数
		System.out.println();
	}

	// 邻接表的DFS
	public void Graph1DFS(int v, int[] visited) {
		mVertex1 key = vertexArray[v];
		String ssss;
		while (key != null) {
			key = key.next;
			if (key != null) {
				ssss = key.name.substring(1);
				v = Integer.parseInt(ssss);
				if (visited[v] == 0) {
					visited[v] = 1;
					System.out.print("---> " + key.name);
					Graph1DFS(v, visited);
				}
			}
		}
	}

}

//邻接矩阵
class Graph2 {
	int[][] adjMatrix;
	int s;
	private Scanner input = new Scanner(System.in);

	// 构造函数
	public Graph2() {
		// TODO Auto-generated constructor stub
	}

	// 构建函数
	public void createGraph2() {
		System.out.println("请输入节点数:");
		s = 0;
		int iii=0;
		do {
			try {
				iii=1;
				s = input.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("类型不符合，请重新输入:");
				String cString =input.nextLine();
				cString.length();
				iii=0;
				}
			}while(iii==0);//异常处理
		adjMatrix = new int[s + 1][s + 1];
		String sss;
		char cc;
		int a, b;
		while (true) {
			System.out.println("请输入相连接的节点");
			a=0;
			do {
				try {
					a = input.nextInt();
					if(a <= 0 || a > s)
						throw new Exception("范围不对");
				}
				catch (InputMismatchException ex) {
					System.out.println("类型不符合，请重新输入:");
					String cString =input.nextLine();
					cString.length();
				}
				catch (Exception ex) {
					System.out.println("范围不符合，请重新输入:");
				}
			}while(a <= 0 || a > s);//异常处理
			b=0;
			do {
				try {
					b = input.nextInt();
					if(b <= 0 || b > s)
						throw new Exception("范围不对");
				}
				catch (InputMismatchException ex) {
					System.out.println("类型不符合，请重新输入:");
					String cString =input.nextLine();
					cString.length();
				}
				catch (Exception ex) {
					System.out.println("范围不符合，请重新输入:");
				}
			}while(b <= 0 || b > s);//异常处理
			adjMatrix[a][b] = 1;
			adjMatrix[b][a] = 1;
			System.out.println("是(A)否(B)继续:");
			sss = input.nextLine();// 吞掉回车
			cc=0;
			do {
				try {
					sss = input.nextLine();
					cc = sss.charAt(0);
					if(cc != 'A' && cc != 'B')
						throw new Exception("范围不对");
				}
			
				catch (Exception ex) {
					System.out.println("范围不对，请重新输入（A）或者（B）：");
				}
			}while(cc != 'A' && cc != 'B');//异常处理
			if (cc == 'B')
				break;
		}
	}

	// 展示函数
	public void playGraph2() {
		System.out.println("该邻接矩阵为：");
		System.out.print("   ");
		for (int i = 1; i < s + 1; i++)
			System.out.print("V" + (i) + " ");
		System.out.println();
		for (int i = 1; i < s + 1; i++) {
			System.out.print("V" + (i) + " ");
			for (int j = 1; j < s + 1; j++) {
				System.out.print(" " + adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 邻接矩阵的BFS
	public void Graph2BFS() {
		int[] visited = new int[s + 1];// 判断是否访问
		System.out.println("想要从哪个节点开始遍历：");
		int v =0;
		do {
			try {
				v = input.nextInt();
				if(v <= 0 || v > s)
					throw new Exception("范围不对");
			}
			catch (InputMismatchException ex) {
				System.out.println("类型不符合，请重新输入:");
				String cString =input.nextLine();
				cString.length();
			}
			catch (Exception ex) {
				System.out.println("范围不符合，请重新输入:");
			}
		}while(v <= 0 || v > s);//异常处理
		//
		ArrayList<Integer> Q= new ArrayList<>();// 辅助队列初始化
		Q.add(v);// 开始节点入队
		System.out.print("V" + v);
		visited[v] = 1;
		while (!Q.isEmpty()) {
			v=Q.get(0);
			Q.remove(0);
			// 当队列非空时
			for (int i = 1; i < s + 1; i++) {
				if (adjMatrix[v][i] == 1 && visited[i] == 0) {
					Q.add(i);// 该节点入队
					System.out.print("---> V" + (i));
					visited[i] = 1;
				}
			}
		}
		System.out.println();
	}

	// 因为深度优先遍历要采用递归算法，所以设置输入函数
	public void inputGraph2DFS() {
		int[] visited = new int[s + 1];// 判断是否访问
		System.out.println("想要从哪个节点开始遍历：");
		int v =0;
		do {
			try {
				v = input.nextInt();
				if(v <= 0 || v > s)
					throw new Exception("范围不对");
			}
			catch (InputMismatchException ex) {
				System.out.println("类型不符合，请重新输入:");
				String cString =input.nextLine();
				cString.length();
			}
			catch (Exception ex) {
				System.out.println("范围不符合，请重新输入:");
			}
		}while(v <= 0 || v > s);//异常处理
		System.out.print("V" + v);
		visited[v] = 1;
		Graph2DFS(v, visited);// 调用递归函数
		System.out.println();
	}

	// 邻接矩阵的DFS
	public void Graph2DFS(int v, int[] visited) {
		for (int w = 1; w < adjMatrix.length; w++) {
			if (adjMatrix[v][w] == 1 && visited[w] != 1) {
				System.out.print("---> V" + w);
				visited[w] = 1;
				Graph2DFS(w, visited);
			}
		}
	}
}

//主类
public class myBFSandDFS {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 原邻接矩阵
		Graph2 adjMatrix = new Graph2();
		adjMatrix.createGraph2();
		adjMatrix.playGraph2();
		// 原顶点数
		int oNum = adjMatrix.s;
		// 初始化邻接表
		mGraph1 myGraph = new mGraph1();
		// 选择构建方法
		char a=0;
		System.out.println("请选择前插法（A）或者后插法（B)创建邻接表：");
		String s=null;
		do {
			try {
				s = input.nextLine();
				a = s.charAt(0);
				if(a != 'A' && a != 'B')
					throw new Exception("范围不对");
			}
		
			catch (Exception ex) {
				System.out.println("范围不对，请重新选择前插法（A）或者后插法（B)创建邻接表：");
			}
		}while(a != 'A' && a != 'B');//异常处理
		// 构建邻接表
		if (a == 'A')
			myGraph.createGraph1(oNum, adjMatrix);
		else if (a == 'B')
			myGraph.createGraph2(oNum, adjMatrix);
		// 展示邻接表
		myGraph.playGraph1();
		// 邻接矩阵的广度遍历
		System.out.println("邻接矩阵的广度遍历：");
		adjMatrix.Graph2BFS();
		// 邻接表的广度遍历
		System.out.println("邻接表的广度遍历：");
		myGraph.Graph1BFS();
		// 邻接矩阵的深度遍历
		System.out.println("邻接矩阵的深度度遍历：");
		adjMatrix.inputGraph2DFS();
		// 邻接表的深度遍历
		System.out.println("邻接表的深度度遍历：");
		myGraph.inputGraph1DFS();
		input.close();
	}
}