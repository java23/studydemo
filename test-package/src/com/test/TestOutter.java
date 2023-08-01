package com.test;

public class TestOutter {
    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.show();
        Outter.Inner inter = new Outter().new Inner();
        inter.show();
    }
}
class Outter{
    private  int num =10;
    public void show(){
        System.out.println(num);
    }
    public void showInner(){
        Inner inner = new Inner();
        inner.show();
    }
    class Inner{
        private  int  num =20;
        public void show(){
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outter.this.num);
        }
    }
}

