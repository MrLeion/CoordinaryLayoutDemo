package com.tzl.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kyleduo.alipayhome.R;
import com.tzl.example.AlipayWidgets.APHeaderView;
import com.tzl.example.AlipayWidgets.CommonListDecoration;

import java.util.ArrayList;
import java.util.List;

import tzl.com.shimmerlibrary.ShimmerRecyclerView;

/**
 * author: tangzenglei
 * created on: 2018/7/5 上午10:29
 * description: 支付宝首页
 */
public class MainFragment extends Fragment {


    ShimmerRecyclerView mRecyclerView;
    //    SwipeRefreshLayout mRefreshLayout;
    APHeaderView        mHeaderView;
    AlipayAdapter       mAdapter;
    private TextView tv_more;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tv_more = (TextView) view.findViewById(R.id.tv_more);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (ShimmerRecyclerView) view.findViewById(R.id.alipay_rv);
        mHeaderView = (APHeaderView) view.findViewById(R.id.alipay_header);
        final LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {

            @Override
            public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
                int scrolled = super.scrollVerticallyBy(dy, recycler, state);
                if (dy < 0 && scrolled != dy) {
                    // 有剩余
                    APHeaderView.Behavior behavior = mHeaderView.getBehavior();
                    if (behavior != null) {
                        int unconsumed = dy - scrolled;
                        int consumed = behavior.scroll((CoordinatorLayout) mHeaderView.getParent(), mHeaderView, unconsumed, -mHeaderView.getScrollRange(), 0);
                        scrolled += consumed;
                    }
                }
                return scrolled;
            }
        };

        //头部
        mHeaderView.setOnHeaderFlingUnConsumedListener(new APHeaderView.OnHeaderFlingUnConsumedListener() {
            @Override
            public int onFlingUnConsumed(APHeaderView header, int targetOffset, int unconsumed) {
                APHeaderView.Behavior behavior = mHeaderView.getBehavior();
                int dy = -unconsumed;
                if (behavior != null) {
                    mRecyclerView.scrollBy(0, dy);
                }
                return dy;
            }
        });

        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            titles.add("item " + i);
        }

        View header = View.inflate(this.getContext(), R.layout.alipay_header, null);
        mRecyclerView.setLayoutManager(lm);
        mAdapter = new AlipayAdapter(titles);
        mAdapter.addHeaderView(header);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.addItemDecoration(new CommonListDecoration());
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    APHeaderView.Behavior behavior = mHeaderView.getBehavior();
                    if (behavior != null) {
                        behavior.checkSnap((CoordinatorLayout) mHeaderView.getParent(), mHeaderView);
                    }
                }
            }
        });

        mRecyclerView.showShimmerAdapter();
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.hideShimmerAdapter();
            }
        }, 3000);

        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(this,));
            }
        });
    }


    /**
     * 纵向 LayoutManager
     * @param recyclerView
     */
    private void setLinearLayoutManager(RecyclerView recyclerView,  int orientation) {
        LinearLayoutManager mLinearLayoutManager = null;
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            mLinearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        } else {
            mLinearLayoutManager = new LinearLayoutManager(getActivity()){
                @Override
                public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
                    int scrolled = super.scrollVerticallyBy(dy, recycler, state);
                    if (dy < 0 && scrolled != dy) {
                        // 有剩余
                        APHeaderView.Behavior behavior = mHeaderView.getBehavior();
                        if (behavior != null) {
                            int unconsumed = dy - scrolled;
                            int consumed = behavior.scroll((CoordinatorLayout)  mHeaderView.getParent(),  mHeaderView, unconsumed, - mHeaderView.getScrollRange(), 0);
                            scrolled += consumed;
                        }
                    }
                    return scrolled;
                }
            };
        }
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        mHeaderView.setOnHeaderFlingUnConsumedListener(new APHeaderView.OnHeaderFlingUnConsumedListener() {
            @Override
            public int onFlingUnConsumed(APHeaderView header, int targetOffset, int unconsumed) {
                APHeaderView.Behavior behavior =  mHeaderView.getBehavior();
                int dy = -unconsumed;
                if (behavior != null) {
                   mRecyclerView.scrollBy(0, dy);
                }
                return dy;
            }
        });



    }








    public static class AlipayAdapter extends BaseQuickAdapter<String,BaseViewHolder> {



        public AlipayAdapter(List<String> titles) {
            super(R.layout.item_content, titles);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv,item);
        }


    }


}

