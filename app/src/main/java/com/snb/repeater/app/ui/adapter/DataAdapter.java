package com.snb.repeater.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.domain.model.DB;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by
 * Gorkavik_O
 * 18.02.2018.
 */
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DB> dbList = new ArrayList<>();
    private Context context;

    public DataAdapter(Context context, List<DB> dbList) {
        this.context = context;
        this.dbList = dbList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final NewsViewHolder viewHolder = (NewsViewHolder) holder;
        viewHolder.lexeme.setText(dbList.get(position).getQuestion());
        viewHolder.definition.setText(dbList.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.lexeme)
        public TextView lexeme;
        @BindView(R.id.definition)
        public TextView definition;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
