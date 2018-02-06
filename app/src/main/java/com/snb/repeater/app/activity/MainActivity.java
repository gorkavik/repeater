package com.snb.repeater.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.App;
import com.snb.repeater.app.domain.db.DBAbstract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cancel)
    protected Button cancel;
    @BindView(R.id.submit)
    protected Button submit;
    @BindView(R.id.lexeme)
    protected TextView lexeme;

    private DBAbstract dbabstract;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dbabstract = App.getDBInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                lexeme.setText(dbabstract.getDBDao().getAllData());
            }
        });
    }
}
