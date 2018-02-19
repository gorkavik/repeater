package com.snb.repeater.app.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.App;
import com.snb.repeater.app.domain.db.DB;
import com.snb.repeater.app.domain.db.DBAbstract;

import java.util.ArrayList;
import java.util.List;

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

    public void onSubmitClick (View v) {

        AsyncBase insertbase = new AsyncBase();
        insertbase.execute();

    }

    class AsyncBase extends AsyncTask<Void, Void, Void> {

        DBAbstract dbabstract = App.getInstance().getDBInstance();
        @Override
        protected Void doInBackground(Void... params) {

            DB db = new DB();
            db.setId(1);
            db.setQuestion("first_question");
            db.setAnswer("first_answer");
            dbabstract.getDBDao().insert(db);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            lexeme.setText("straus");
            //List<DB> list = new ArrayList();
            //list = dbabstract.getDBDao().getAllData();

            definition.setText("popugai");
        }
    }
}

