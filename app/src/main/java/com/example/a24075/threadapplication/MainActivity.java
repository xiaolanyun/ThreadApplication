package com.example.a24075.threadapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //定义按钮，进行绑定
    TextView text1;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:text1.setText("数字111");break;
                case 2:text1.setText("数字2");break;
                case 3:text1.setText("数字3");break;
                case 4:text1.setText("数字4");break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        思路：1、写一个根据随机数变化按钮颜色的函数,函数实现Runnable接口，覆盖run方法
        2、主函数里面new线程对象实现，运行start
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //开启线程
        Log.d("yyj", "onCreate: ");
        ChangeColour co = new ChangeColour();
        text1 = findViewById(R.id.text1);
        Thread t1 = new Thread(co);
//        Thread t2 = new Thread(co);
//        Thread t3 = new Thread(co);
//        Thread t4 = new Thread(co);
        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

    }
    public class ChangeColour implements Runnable {
        @Override
        public void run() {
            //
            //1、定义数学随机数,0-1,乘以3，0-3，1-4
            //
            while(true)
            {

                    int num = (int)(Math.random()*3+1);
                Log.d("yyj", "run: "+num);
                    if(num==1)
                    {
                        handler.sendEmptyMessage(1);
                    }
                    else if(num==2)
                    {
                        handler.sendEmptyMessage(2);
                    }
                    else if(num==3)
                    {
                        handler.sendEmptyMessage(3);
                    }
                    else
                    {
                        handler.sendEmptyMessage(4);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }

        }
    }
}
