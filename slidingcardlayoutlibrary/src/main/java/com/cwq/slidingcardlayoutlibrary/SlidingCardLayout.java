package com.cwq.slidingcardlayoutlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/14 0014.
 * 滑动卡片
 */

@CoordinatorLayout.DefaultBehavior(SlidingCardBehavior.class)
public class SlidingCardLayout extends FrameLayout {

    private int headBackgroundColor = Color.BLUE;
    private int headTextColor = Color.GREEN;
    private float headTextSize = 15;
    private String mTitleData;

    private TextView mTextView;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int headHeight;


    public SlidingCardLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlidingCardLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.slidingcardlayout, this);

        TypedArray attribute = getContext().obtainStyledAttributes(attrs, R.styleable.SlidingCardLayout);
        headBackgroundColor = attribute.getColor(R.styleable.SlidingCardLayout_sliding_card_head_background, Color.BLUE);
        headTextColor = attribute.getColor(R.styleable.SlidingCardLayout_sliding_card_head_text_color, Color.GREEN);
        headTextSize = attribute.getFloat(R.styleable.SlidingCardLayout_sliding_card_head_text_size, 15f);
        mTitleData = attribute.getString(R.styleable.SlidingCardLayout_sliding_card_head_text);

        mTextView = (TextView) findViewById(R.id.slidingcard_tv_title);
        mTextView.setBackgroundColor(headBackgroundColor);
        mTextView.setTextColor(headTextColor);
        mTextView.setTextSize(headTextSize);
        if (!TextUtils.isEmpty(mTitleData))
            mTextView.setText(mTitleData);
        else
            mTextView.setText("DefaultTitle");


        mRecycleView = (RecyclerView) findViewById(R.id.slidingcard_recycleview);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecycleView.setLayoutManager(mLayoutManager);
        attribute.recycle();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        headHeight = findViewById(R.id.slidingcard_tv_title).getMeasuredHeight();
    }


    /**
     * 获取头部高度
     *
     * @return
     */
    public int getHeadHeight() {
        return headHeight;
    }


    /**
     * 能否继续向下滑动，true能滚动，false已经滚动到顶部
     *
     * @return
     */
    public boolean listCanScrollTop() {
        return mRecycleView.canScrollVertically(-1);
    }


    /**
     * 能否继续向上滑动，true能滚动，false已经滚到底部
     *
     * @return
     */
    public boolean listCanScrollBottom() {
        return mRecycleView.canScrollVertically(1);
    }


    /**
     * 设置标题高度
     *
     * @param height
     */
    public void setHeadHeight(int height) {
        if (height <= 0)
            return;
        headHeight = DpUtils.dip2px(getContext(), height);
        mTextView.setHeight(headHeight);
        mTextView.getLayoutParams().height = headHeight;
        mRecycleView.setPadding(0, headHeight, 0, 0);
    }


    /**
     * 设置卡片标题文本
     *
     * @param title
     */
    public void setTitleString(String title) {
        mTextView.setText(title);
    }


    /**
     * 设置标题文字大小
     *
     * @param size
     */
    public void setTitleSize(float size) {
        mTextView.setTextSize(size);
    }

    /**
     * 设置标题文字颜色
     *
     * @param color
     */
    public void setTitleColor(int color) {
        mTextView.setTextColor(color);
    }

    /**
     * 设置标题背景颜色
     *
     * @param color
     */
    public void setTitleBackgroud(int color) {
        mTextView.setBackgroundColor(color);
    }


    /**
     * 设置适配器
     *
     * @param adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (null != adapter) {
            mAdapter = adapter;
            mRecycleView.setAdapter(adapter);
        }
    }


    /**
     * 获取列表适配器
     *
     * @return
     */
    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }


    public void setRecycleLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (null != layoutManager) {
            mLayoutManager = layoutManager;
            mRecycleView.setLayoutManager(mLayoutManager);
        }
    }
}
