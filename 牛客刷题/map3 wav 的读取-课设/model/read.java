package model;

import java.io.File;

/**
 * 写一个扩展性强的 目前实现的功能就是只读取
 * 磁盘下的文件 之后还可以读取网络上的
 *
 * String str 参数是文件的路径
 */
public class read {

    public String[] readFile(String str) throws Exception {

        String[] files = null;
        //文读取
        File file = new File(str); // 获取str路径下的文件目录对象
        if (file.exists()) { // 如果文件或目录存在
            File[] subFiles = file.listFiles();// 获取目录下的文件带路径名称
             files = new String[subFiles.length];
            for(int i = 0 ;i < subFiles.length;i++) {
                     files[i]= subFiles[i].getName();
            }
            //System.out.println(Arrays.toString(files));
        }else {
            throw new  Exception("There is no files and dirs!");
        }

        //返回一个字符串数组
        return files;

    }
}
