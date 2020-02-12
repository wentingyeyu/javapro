package com.neuedu.homework0212;

import java.io.*;

public class Copy {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        字节流复制
         */
        File startFile = new File("D:/照片验证.zip");
        File endFile = new File("D:/a/照片验证.zip");
        /*
         熟悉file的方法
        System.out.println(file.getName()); //获取名称
        System.out.println(file.exists());  //判断文件是否存在
        System.out.println(file.getPath()); //获取文件路径
        System.out.println(file.isDirectory()); //判断是不是目录
        System.out.println(file.isFile());  //判断是不是文件
        System.out.println(file.length());  //获取文件大小（字节）
         */
        byte [] read = new byte[10];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(startFile);
            outputStream = new FileOutputStream(endFile);
            int size = inputStream.read(read);
            while (size!=-1){
                outputStream.write(read);//写入输出流
                outputStream.flush();   //从输出流压入到文件夹
                size = inputStream.read(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(inputStream!=null)
                    inputStream.close();
                    if(outputStream!=null)
                        outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }


}
