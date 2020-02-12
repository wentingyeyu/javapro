package com.neuedu.simpleLibrary;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public Boolean isSave(File file){
        if(file.exists()){
            return false;
        }else {
            return true;
        }
    }
    public List<MyBook> read(File file){
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        List list = new ArrayList();
        try {
            inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);
            list = (List < MyBook>)  objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(inputStream!=null)
                        inputStream.close();
                    if(objectInputStream!=null)
                        objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return list;
        }
    }
    public void save(File file,List<MyBook> list){
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (outputStream!=null)
                        outputStream.close();
                    if(objectOutputStream!=null)
                        objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
