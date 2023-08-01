package com.price;

public class   Test1 {
   /* # 练习一：飞机票
    需求:
          机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。

            按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。*/
    public static void main(String[] args) {
        System.out.println(getTicketPrice(1000,4,1));
    }
    //1.我要干嘛？  决定了方法体
//2.我干这件事情，需要什么才能完成？ 决定了形参
//3.我干完这件事情，看调用处是否需要使用方法的结果。  决定了返回值
    public static double getTicketPrice(double price,int month,int cangwei){
        double discount = 1;
       // 旺季（5-10月）头等舱9折，经济舱8.5折
        if(month>=5 && month<=7){
            if(cangwei==1){
                discount =0.9;
            }else {
                discount=0.85;
            }
        }else {
            if (cangwei==1){
                discount=0.7;
            }else {
                discount =0.65;
            }
        }


        return price * discount;
    }
}
