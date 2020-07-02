package com.developers.superdemo01;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.developers.superdemo01.smooth.SmoothInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_expression;
    private SmoothInputLayout smoothInputLayout;
    private RecyclerView recyclerView;
    private ExpressionAdapter expressionAdapter;

    private static final Integer[] expressionId = new Integer[]{R.drawable.brow_nh, R.drawable.brow_xh, R.drawable.brow_gx,
            R.drawable.brow_sx, R.drawable.brow_fn, R.drawable.brow_wl
            , R.drawable.brow_lh, R.drawable.brow_yw, R.drawable.brow_bs
            , R.drawable.brow_xh, R.drawable.brow_dx, R.drawable.brow_lw
            , R.drawable.brow_tkl, R.drawable.brow_tml, R.drawable.brow_zt
            , R.drawable.brow_fd, R.drawable.brow_gz, R.drawable.brow_zdsk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        iv_expression = findViewById(R.id.iv_expression);
        smoothInputLayout = findViewById(R.id.smooth_layout);
        recyclerView = findViewById(R.id.recycler_emoji);
        //表情
        recyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        iv_expression.setOnClickListener(this);

        List<Integer> ints =  Arrays.asList(expressionId);

        expressionAdapter = new ExpressionAdapter(ints);

        recyclerView.setAdapter(expressionAdapter);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_expression:
                smoothInputLayout.showInputPane(true);
                break;
        }
    }

    public class ExpressionAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

        public ExpressionAdapter(@Nullable List<Integer> data) {
            super(R.layout.adapter_expression, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Integer item) {
            ImageView view = helper.getView(R.id.iv_icon);
            view.setImageResource(item);
        }
    }

    public class ExpressionBean {
        public String name;
        public int id;
    }

}
