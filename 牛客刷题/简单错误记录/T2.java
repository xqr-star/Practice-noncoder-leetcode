package day31;

import java.util.*;


//读到文件路径，先用substring截取文件名。
//自定义一个实现类，类里面存放文件名和出现的次数

//用Map来区分是否为新纪录,这要求Entry重新equals和hashCode。--这里一个都不能少
//真正使用的是LinkedHashMap，使得遍历key时可以按照插入顺序遍历，满足了题目要求。
//排序的时候，使用重写comparator ，最后使得list是一个有序的list
//最后对list的前8个输出
////对文件名长度的判定在Entry的toString中，这样写不好，因为是刷题无所谓了。

public class T2 {
    static class FileError  {
        public String str;
        public Integer line;

        public FileError(String str, Integer line) {
            this.str = str;
            this.line = line;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FileError fileError = (FileError) o;
            return Objects.equals(str, fileError.str) &&
                    Objects.equals(line, fileError.line);
        }

        @Override
        public int hashCode() {
            return str.hashCode() +line;
        }

    }
    public static void main(String[] args) {

        //大概就是new 一个类 然后map《类》，key
        //类里面存放两个东西 一个是

        //处理输入
        Scanner sc = new Scanner(System.in);

        //把所有的错误记录添加到map里面，统计个数
        Map<FileError,Integer> map = new LinkedHashMap<>();
        FileError e = null;
        while(sc.hasNext()){
            String[] arr = sc.nextLine().split(" ");
            //处理文件名的方法
            arr[0] = solveName(arr[0]);//文件路径转换为文件名
            e = new FileError(arr[0],(Integer.valueOf(arr[1]))) ;
            //注意这里放进去的是一个对象，put进去会把他们当成不同的，如果没有重写方法
            map.put(e,map.getOrDefault(e,0)+1 );

        }

        //对他进行排序--让map可以实现按照value 排序 --相同的还得是按照输入的顺序
        //结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

        List<Map.Entry<FileError,Integer>>list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<FileError, Integer>>() {
            @Override
            public int compare(Map.Entry<FileError, Integer> o1, Map.Entry<FileError, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });



        //需要对文件的名字处理--要先获取文件名和行号
        //然后对文件名大于16个的，支取后16位
        //而且需要控制输出前8条数据
        int count = 0;
        for(Map.Entry<FileError,Integer> mapping : list){
           if(count <8) {
               e = mapping.getKey();
               String str = e.str;
               str = str.length()> 16? str.substring(str.length()-16): str;
               System.out.println(str + " " + e.line +" "+ mapping.getValue());
               count++;
           }else{
               break;
            }

        }
    }

    private static String solveName(String s) {
        //将文件路径转换为文件名
        int index = s.lastIndexOf('\\');//找到最后一个\的位置
        //然后从这个位置开始提取文件名
        String name = s.substring(index+1);//到结束的位置
        return  name;
    }

}

//测试用例：

//e:\1\aa3.txt 3
//e:\3\aa1.txt 2
//e:\2\aa2.txt 3
//e:\3\aa1.txt 1
//e:\1\aa1.txt 3
//e:\3\aa1.txt 2
//e:\1\aa3.txt 3
//e:\2\aa3.txt 2
//e:\1\aa1.txt 2
//e:\3\aa3.txt 2
//e:\1\aa2.txt 2
//e:\1\aa3.txt 1
//e:\1\aa3.txt 1
//e:\2\aa3.txt 2
//e:\1\aa2.txt 1
//e:\3\aa1.txt 2
//e:\1\aa1.txt 3
//e:\2\aa1.txt 1
//e:\3\aa3.txt 2
//e:\1\aa1.txt 1
//e:\2\aa2.txt 2
//e:\3\aa3.txt 2
//e:\1\aa2.txt 1
//e:\1\aa3.txt 2
//e:\1\aa3.txt 3
//e:\1\aa2.txt 3
//e:\3\aa1.txt 3
//e:\2\aa2.txt 2
//e:\1\aa1.txt 1

