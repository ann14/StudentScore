package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[] arr = new double[10];
        int num=1;
        InputScore(arr,num);
        System.out.println("=============");
        OutputScore(arr);
        System.out.println();
        System.out.println(MaxScore(arr));
        System.out.println(MinScore(arr));
        System.out.println(nnnScore(arr));
        System.out.println(DistributedScore(arr));

    }
    //輸出使用者之輸入
    public static void OutputScore(double[] score){
        for(int i=0;i<=score.length-1;i++){
            System.out.printf("第%d位: %f\n",i+1,score[i]);
        }
    }
    //使使者可輸入分數
    public static void InputScore(double[] score,int number){
        System.out.println("請輸入10位同學的成績：");
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.printf("第%d位：",number);
            score[number-1]=scanner.nextInt();

            number++;
        }while(number<=10);

    }
    //找最大值
    public static String MaxScore(double[] score){
        double max=score[0];
        for(int i=1;i<=score.length-1;i++){
            if(score[i]>max){
                max=score[i];
            }
        }
       return "最高分: "+max;
    }
    //找最小值
    public static String MinScore(double[] score){
        double min=score[0];
        for(int i=1;i<=score.length-1;i++){
            if(score[i]<min){
                min=score[i];
            }
        }
        return "最高分: "+min;
    }

    //計算平均、變異數、標準差
    public static String nnnScore(double[] score){
        double nScore[]=new double[3];
        double totalScore1=0;
        double totalScore2=0;
        for(int i=0;i<=score.length-1;i++){
            totalScore1 +=score[i];
        }
        nScore[0]=totalScore1/score.length;

        for(int i=0;i<=score.length-1;i++){
            totalScore2 +=(score[i]-nScore[0])*(score[i]-nScore[0]);
        }
        nScore[1]=totalScore2/score.length;
        nScore[2]=Math.pow(nScore[1],0.5);

        return "平均: "+nScore[0]+"\n變異數: "+nScore[1]+"\n標準差: "+nScore[2];
    }
    //計算成績分布
    public static String DistributedScore(double[] score){
        int num1=0,num2=0,num3=0;
        for(int i=0;i<=score.length-1;i++){
            if(score[i]>80){
                num1++;
            }
            else if(score[i]>60&&score[i]<=80){
                num2++;
            }
            else if(score[i]<=60){
                num3++;
            }
        }
        return "分數介於81~100人數: "+num1+"\n分數介於61~80人數: "+num2+"\n分數介於0~60人數: "+num3;
    }
}
