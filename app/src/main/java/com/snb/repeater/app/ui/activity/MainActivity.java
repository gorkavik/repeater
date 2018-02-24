package com.snb.repeater.app.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.App;
import com.snb.repeater.app.domain.db.DBAbstract;
import com.snb.repeater.app.domain.model.DB;
import com.snb.repeater.app.ui.task.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.snb.repeater.app.App.getInstance;

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

    public void onSubmitClick(View v) {
        new Task<>(() -> {

            final DB db = new DB();
            db.setId(1);
            db.setQuestion("first_question");
            db.setAnswer("first_answer");

            final DBAbstract dbabstract = getInstance().getDBInstance();
            dbabstract.getDBDao().insert(db);
            return dbabstract.getDBDao().getAllData();

        }, (data) -> {
            lexeme.setText(data.get(0).getQuestion());
            definition.setText(data.get(0).getAnswer());
        }).execute();
    }
}

