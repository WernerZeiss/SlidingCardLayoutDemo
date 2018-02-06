# SlidingCardLayout

## 效果

![](https://github.com/WernerZeiss/SlidingCardLayoutDemo/blob/master/images/slidingcard.gif)

## 特点

* 可自定义每个卡片标题文字内容、文字颜色、大小、背景颜色。
* 卡片列表使用RecycleView，可单独设置Adapter以及LayoutManager,列表样式完全自定义。
* 卡片数量灵活，可添加多个卡片。

## 使用

**注意：卡片控件SlidingCardLayout必须直接添加在CoordinatorLayout内使用。**

* 示例：

```
  <android.support.design.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.cwq.slidingcardlayoutlibrary.SlidingCardLayout
            android:id="@+id/main_card1"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:sliding_card_head_background="@android:color/holo_green_light"
            app:sliding_card_head_text_color="#ffffff" />

        <com.cwq.slidingcardlayoutlibrary.SlidingCardLayout
            android:id="@+id/main_card2"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:sliding_card_head_background="@android:color/holo_red_light"
            app:sliding_card_head_text_color="#ffffff" />

        <com.cwq.slidingcardlayoutlibrary.SlidingCardLayout
            android:id="@+id/main_card3"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:sliding_card_head_background="@android:color/holo_orange_light"
            app:sliding_card_head_text_color="#ffffff" />

        <com.cwq.slidingcardlayoutlibrary.SlidingCardLayout
            android:id="@+id/main_card4"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:sliding_card_head_text_color="#ffffff" />
    </android.support.design.widget.CoordinatorLayout>

```

* XML属性

sliding_card_head_text  -->设置标题文字
sliding_card_head_text_color  -->设置标题文字颜色
sliding_card_head_text_size -->设置标题文字大小
sliding_card_head_background  -->设置标题文字背景颜色

* 方法属性

方法名 | 说明
----|------
setHeadHeight(int height) | 设置标题高度
setTitleString(String title) | 设置标题文本
setTitleSize(float size) | 设置标题文字大小
setTitleColor(int color) | 设置标题文字颜色
setTitleBackgroud(int color) | 设置标题背景颜色
setAdapter(RecyclerView.Adapter adapter) | 设置列表适配器
setRecycleLayoutManager(RecyclerView.LayoutManager layoutManager) | 设置布局管理器(默认LinearLayoutManager)


