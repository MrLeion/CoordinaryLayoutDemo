package com.tzl.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kyleduo.alipayhome.R;
import com.tzl.example.holder.HomeHolder;

/**
 * author: tangzenglei
 * created on: 2018/7/12 下午2:26
 * description:
 */
public class HomeFragment extends Fragment {



    public HomeFragment newInstance(Bundle bundle) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(this.getContext()).inflate(R.layout.fragment_home, null);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setAdapter(new Adapter());
        return view;


    }




    class Adapter extends BaseQuickAdapter<String,HomeHolder> {

        public Adapter() {
            super(R.layout.item_home);
        }

        @Override
        protected void convert(HomeHolder helper, String item) {

//            helper.textView.setText(item);

        }
    }
}

