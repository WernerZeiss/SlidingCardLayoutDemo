package com.cwq.slidingcardlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5 0005.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mDataList;

    public TestAdapter(Context context, List<String> dataList) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.item_iv);
            tv = itemView.findViewById(R.id.item_tv);
        }
    }
}
