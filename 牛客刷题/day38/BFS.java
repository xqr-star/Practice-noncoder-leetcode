package day38;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 图的广度优先遍历
 * 二叉树的广度优先遍历时借助的队列的方式 一个拖动一个来实现的、
 * 所有这里图的广度优先遍历也是需要借助队列来拖动
 * 刚开始先把图的期起点拖动进来，然后依次拖动图可以到达的位置
 *
 * 刷一下二叉树的广度优先遍历
 */
public class BFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();//把当前行的所有内容解决掉

            //构建一个状态的数组
            //用来存放当前位置的内容
            Character[][] map = new Character[m][n];
            Node start = null;
            //完成整个图形的绘制工作
            for(int i =0; i< m;i++){
                //获取一行的内容
                String s = sc.nextLine();
                for(int j = 0;j<n;j++){
                    map[i][j] = s.charAt(j);
                    if(s.charAt(j) == '@'){
                        //找到开始的结点
                        start = new Node(i,j);
                    }
                }
            }
            //设置状态
            //为什么要用这个记录状态
            //代表哦只有四种状态可以选择就是上下左右
            int[] [] direction = {{0,1},{0,-1},{1,0},{-1,0}};
            bfs(map,direction,start);
        }
    }


    //广度优先遍历借助的是队列的方式实现
    //采用的是一拖二 的方式
    private static void bfs(Character[][] map, int[][] direction, Node start) {
        Queue<Node> queue = new LinkedList<>();
        //用一个数组记录这个位置是否被访问过
        boolean[][] visited = new boolean[map.length][map[0].length];
        queue.add(start);
        //一旦被添加到队列里面来，就表示这个元素是被访问过的
        visited[start.i][start.j] = true;
        int count =1;
        //然后循环遍历队列
        while (!queue.isEmpty()){
            Node cur = queue.poll();//拿出队首元素
            //然后把它的可以走的地方拖动进来
            for(int i = 0;i<4;i++){
                Node next = new Node(cur.i+direction[i][0],cur.j+direction[i][1]);
                //这个结点的下标必须是不越界 并且当前没有被访问过 并且还必是黑色的才可以
                if(next.i >=0 && next.i<map.length && next.j >= 0&& next.j < map[0].length &&
                map[next.i][next.j] != '#' && !visited[next.i][next.j]){
                    count ++;
                    queue.add(next);
                    visited[next.i][next.j] = true;
                }
            }
        }
        System.out.println(count);
    }

    static class Node{
        public int i =0 ;
        public int j =0;
        public Node(int i,int j){
           this.i = i;
            this.j = j;
        }

    }
}
