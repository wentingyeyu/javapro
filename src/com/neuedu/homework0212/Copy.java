package com.neuedu.homework0212;

import java.io.*;
import java.util.stream.Stream;

public class Copy {
    public static void main(String[] args) {
        /*
         熟悉file的方法
        System.out.println(file.getName()); //获取名称
        System.out.println(file.exists());  //判断文件是否存在
        System.out.println(file.getPath()); //获取文件路径
        System.out.println(file.isDirectory()); //判断是不是目录
        System.out.println(file.isFile());  //判断是不是文件
        System.out.println(file.length());  //获取文件大小（字节）
         *
        /*
        字节流复制

         */
        File startFile = new File("D:/2 File类.wmv");
        File endFile = new File("D:/delte/"+startFile.getName());
        byte [] b = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(startFile);
            outputStream = new FileOutputStream(endFile);
            int size = inputStream.read(b);
            while (size!=-1){
                outputStream.write(b,0,size);//写入输出流
                outputStream.flush();   //从输出流压入到文件夹
                size = inputStream.read(b);
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
        /*
        字符流输出，读取 路径，文件不存在就创建
        File path = new File("D:/delte");
        File file = new File("D:/delte/delte");
        try {
            System.out.println(path.mkdirs());
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writer writer = null;
        String str = null;
        try {
             writer = new FileWriter(file,true);
             str="asdasdasd";
             writer.write(str);
             writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Reader reader = null;
        BufferedReader bufferedReader = null;
        String a = null;
        try {
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            a = bufferedReader.readLine();
            while (a!=null){
                System.out.println(a);
                a=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader!=null)
                    bufferedReader.close();
                if(reader!=null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         */
    }
}
