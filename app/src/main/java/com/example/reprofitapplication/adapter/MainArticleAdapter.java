package com.example.reprofitapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.reprofitapplication.MainActivity;
import com.example.reprofitapplication.R;
import com.example.reprofitapplication.model.Article;
import com.example.reprofitapplication.utils.OnRecyclerViewItemClickListener;

import java.util.List;

public class MainArticleAdapter extends RecyclerView.Adapter<MainArticleAdapter.VievHolder>{


    private List<Article> articleArrayList;
    private Context context;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;


    public MainArticleAdapter(List<Article> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public VievHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_main_article_adapter, viewGroup, false);
        return new MainArticleAdapter.VievHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VievHolder vievHolder, int i) {

        final Article articleModel = articleArrayList.get(i);
        if(!TextUtils.isEmpty(articleModel.getTitle())) {
            vievHolder.tvTitle.setText(articleModel.getTitle());
        }

        if(!TextUtils.isEmpty(articleModel.getDescription())) {
            vievHolder.tvDescription.setText(articleModel.getDescription());
        }

        vievHolder.articleAdapterParentLinear.setTag(articleModel);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }



    class VievHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle,tvDescription;
        private LinearLayout articleAdapterParentLinear;


        public VievHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            articleAdapterParentLinear=itemView.findViewById(R.id.article_adapter_ll_parent);
            articleAdapterParentLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(onRecyclerViewItemClickListener !=null){
                        //
                    }
                }
            });
        }
    }


    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
