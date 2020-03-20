package com.zhangxx.java8;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class updateCode {

    //从update.txt去重
    public static void main(String[] args) throws IOException {
String outPath ="C:/Users/布口袋/Desktop/Code/Dev/server/BRANCH-BENEFIT";
        //读取文件
        File file = new File("./src/main/resources/update.txt");
        System.out.println(file.exists());


        FileInputStream fis=new FileInputStream(file);
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(fis));


        String s = bufferedReader.readLine();
        HashSet<String> fileList =new HashSet<>();
        while (s!=null){


            if (s.startsWith("Modified :")){
                fileList.add(s.replace("Modified :", " ").replace("/Code/Dev/server/BRANCH-BENEFIT/"," ").trim());
            }else if(s.startsWith("Added :")) {
                fileList.add(s.replace("Added :", " ").replace("/Code/Dev/server/BRANCH-BENEFIT/"," ").trim());

            }

            s=bufferedReader.readLine();
        }

        bufferedReader.close();

        HashMap<String, HashSet<String>> outList =new HashMap<>();


        fileList.forEach(name -> {
            String[] split = name.split("/", 3);
            String key=split[0]+":"+split[1];
            HashSet<String> listSet = outList.get(key);
            if (listSet == null) {
                listSet=new HashSet<>();
            }
            listSet.add(name);
            outList.put(key,listSet);
        });
        outList.forEach((key, listSet) -> {

            System.out.println(key);
            listSet.forEach(System.out::println);

        });
        String ss="D:/development_tools/svn_temp/zhanhong/server/BRANCH-BENEFIT/";
        //copy(outPath, fileList, ss);


    }

    private static void copy(String outPath, HashSet<String> fileList, String ss) throws IOException {
        //复制文件
        for (String s1 : fileList) {
            copyFileUsingFileStreams(new File(ss+s1),new File(outPath+s1));
        }
    }

    private static boolean copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {

            if (source.isDirectory()) {
                if (!dest.exists()) {
                    dest.mkdirs();
                }

                return true;
            }
            if (!dest.exists()) {
                dest.getParentFile().mkdirs();
            }
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
            System.out.println(source.getName()+"成功");

        } catch (Exception io){
            System.out.println(source.getName()+"失败");
            return false;
        } finally{
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
        return true;
    }
}
