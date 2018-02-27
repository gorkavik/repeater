package com.snb.repeater.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.domain.dao.DAOFactory;
import com.snb.repeater.app.ui.task.Task;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cancel)
    protected Button cancel;
    @BindView(R.id.submit)
    protected Button submit;
    @BindView(R.id.lexeme)
    protected TextView lexeme;
    @BindView(R.id.definition)
    protected TextView definition;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onSubmitClick(final View v) {
        new Task<>(() -> DAOFactory.getInstance().getAllData(),
                (data) -> {
                    lexeme.setText(data.get(0).getQuestion());
                    definition.setText(data.get(0).getAnswer());
                }).execute();
    }

    public void onCancelClick(final View v) {
        startActivity(new Intent(this, StartActivity.class));
    }
}

