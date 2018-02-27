package com.snb.repeater.app.ui.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.domain.model.DB;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataAdapter extends Adapter<ViewHolder> {

    private List<DB> dbList;

    public DataAdapter(final List<DB> dbList) {
        this.dbList = dbList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new NewsViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final NewsViewHolder viewHolder = (NewsViewHolder) holder;
        viewHolder.lexeme.setText(dbList.get(position).getQuestion());
        viewHolder.definition.setText(dbList.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    class NewsViewHolder extends ViewHolder {

        @BindView(R.id.lexeme)
        protected TextView lexeme;
        @BindView(R.id.definition)
        protected TextView definition;

        NewsViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
