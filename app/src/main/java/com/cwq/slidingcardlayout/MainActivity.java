package com.cwq.slidingcardlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.cwq.slidingcardlayoutlibrary.SlidingCardLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    SlidingCardLayout slidingCardLayout1;
    SlidingCardLayout slidingCardLayout2;
    SlidingCardLayout slidingCardLayout3;
    SlidingCardLayout slidingCardLayout4;

    private String[] data = {"测试一", "测试二", "测试三", "测试四", "测试五", "测试六", "测试七", "测试八", "测试九", "测试十"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingCardLayout1 = findViewById(R.id.main_card1);
        slidingCardLayout2 = findViewById(R.id.main_card2);
        slidingCardLayout3 = findViewById(R.id.main_card3);
        slidingCardLayout4 = findViewById(R.id.main_card4);


        TestAdapter adapter = new TestAdapter(this, Arrays.asList(data));

        slidingCardLayout1.setTitleString("卡片一");
        slidingCardLayout1.setAdapter(adapter);//默认是LinearLayoutManager

        slidingCardLayout2.setTitleBackgroud(Color.BLACK);
        slidingCardLayout2.setHeadHeight(80);
        slidingCardLayout2.setAdapter(adapter);

        slidingCardLayout3.setTitleSize(18);
        slidingCardLayout3.setTitleColor(Color.GRAY);
        slidingCardLayout3.setAdapter(adapter);

        slidingCardLayout4.setRecycleLayoutManager(new GridLayoutManager(this, 2));
        slidingCardLayout4.setAdapter(adapter);
    }
}
