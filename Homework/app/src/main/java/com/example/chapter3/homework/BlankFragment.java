package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class BlankFragment extends Fragment {
    Context mcontext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件


        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final LottieAnimationView ldingview = getView().findViewById(R.id.lodaing_view);
        ldingview.playAnimation();

        final ObjectAnimator ffAnimator = ObjectAnimator.ofFloat(ldingview,"Alpha",1.0f,0.0f);
        ffAnimator.setInterpolator(new LinearInterpolator());
        ffAnimator.setDuration(2000);


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                AnimatorSet animators = new AnimatorSet();
                animators.playTogether(ffAnimator);
                animators.start();
            }
        }, 5000);
    }



}