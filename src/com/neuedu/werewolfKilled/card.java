package com.neuedu.werewolfKilled;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class card {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("请输入游戏人数（输入0退出系统）：");
            int p = scanner.nextInt();
            init(p);
        }
    }
    /*
     初始化发牌
     */
    public static void init(int p){
        List<String> cards = new ArrayList<String>();//初始化牌堆
        List<String> players = new ArrayList<String>();//初始化玩家手中的牌
        int wereWolf; //狼人数
        int farmer;     //村民数
        /*
        创建牌堆
         */
        cards.add("预言家");
        cards.add("女巫");
        cards.add("丘比特");
        cards.add("守卫");
        cards.add("猎人");
        cards.add("村长");
        cards.add("盗贼");
        cards.add("替罪羊");
        cards.add("吹笛者");
        switch (p){
            case 0:
                System.exit(0);
            case 12:
                wereWolf = 4;
                farmer = 4;
                cards.remove("吹笛者");
                cards.remove("替罪羊");
                break;
            case 13:
                wereWolf = 4;
                farmer = 5;
                cards.remove("吹笛者");
                cards.remove("替罪羊");
                break;
            case 14:
                wereWolf = 4;
                farmer = 5;
                cards.remove("吹笛者");
                break;
            case 15:
                wereWolf = 5;
                farmer = 5;
                cards.remove("吹笛者");
                break;
            case 16:
                wereWolf = 5;
                farmer = 6;
                cards.remove("吹笛者");
                break;
            case 17:
                wereWolf = 5;
                farmer = 7;
                cards.remove("吹笛者");
                break;
            case 18:
                wereWolf = 5;
                farmer = 7;
                break;
            default:
                System.out.println("请重新输入游戏人数（12人到18人）");
                return;
        }
        for(int i=0;i<wereWolf;i++){
            cards.add("狼人");
        }
        for (int i=0;i<farmer;i++){
            cards.add("村民");
        }
        /*
        发牌
         */
        List<String> thieves=thieve(cards,wereWolf);//确定盗贼的三张牌
        //去除盗贼的三张牌后，为每个人发牌
        for(int i=0;i<p;i++){
            int card = (int)(Math.random()*(cards.size()-1));
            System.out.println(card+"__"+cards.size());
            players.add(cards.get(card));
            cards.remove(card);
        }
        /*
        输出发牌信息
         */
        System.out.println("玩家手牌为：");
        System.out.print("{");
        for(int i=0;i<players.size();i++){
            if(i<10){
                System.out.print("0"+(i+1)+":"+players.get(i)+",");
            }else if(i==players.size()-1){
                System.out.println((i+1)+":"+players.get(i)+"}");
            }else {
                System.out.print((i+1)+":"+players.get(i)+",");
            }
        }
        System.out.println("盗贼底牌为：");
        System.out.println("{01:"+thieves.get(0)+","+"02:"+thieves.get(1)+","+"03:"+thieves.get(2)+"}");
    }
    /*
    盗贼的三张牌
     */
    public static List thieve(List<String> cards,int wereWolf){
        cards.remove("盗贼");//去除盗贼牌
        int w = wereWolf;
        List<String> thieves = new ArrayList<String>();
        for(int i =0;i<3;i++){
            int choose = (int)(Math.random()*(cards.size()-1));//从牌堆随机选择牌
            if(cards.get(choose).equals("狼人")){
                //当出现第一张狼人牌时，放进盗贼数组，并去除牌堆中的狼人牌
                thieves.add("狼人");
                wereWolf--;
                for(int j=0;j<=wereWolf;j++){
                    cards.remove("狼人");
                }
                for(String a:cards){
                    System.out.println(a+"asdasd");
                }
                continue;
            }else{
                thieves.add(cards.get(choose));
                cards.remove(choose);
                continue;
            }
        }
        if(w!=wereWolf){//如果盗贼3张牌中有狼人牌，把去除的狼人牌插入到牌堆的随机位置
            for(int j=0;j<wereWolf;j++){
                int a=(int)(Math.random()*(cards.size()-1));
                cards.add(a,"狼人");
            }
        }
        //将盗贼牌插入牌堆
        int x=(int)(Math.random()*(cards.size()-1));
        cards.add(x,"盗贼");
        return thieves;
    }
}
