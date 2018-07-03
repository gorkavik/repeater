package com.snb.repeater.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.snb.repeater.R;
import com.snb.repeater.app.domain.conccurent.executor.AppExecutorModule;
import com.snb.repeater.app.domain.dao.DAOModule;
import com.snb.repeater.app.domain.dao.entity.AnswerDAO;
import com.snb.repeater.app.domain.dao.entity.QuestionDAO;
import com.snb.repeater.app.domain.conccurent.executor.AppExecutor;
import com.snb.repeater.app.ui.dagger.AppComponent;
import com.snb.repeater.app.ui.dagger.DaggerAppComponent;

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

    private QuestionDAO questionDao;
    private AnswerDAO answerDao;
    private AppExecutor executor;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final AppComponent component = DaggerAppComponent
                .builder()
                .dAOModule(new DAOModule(this))
                .appExecutorModule(new AppExecutorModule())
                .build();

        this.executor = component.getAppExecutor();
        this.answerDao = component.getAnswerDao();
        this.questionDao = component.getQuestionDao();
    }

    public void onSubmitClick(final View v) {
        executor.submitTask(
                () -> questionDao.getAll(),
                (data) -> lexeme.setText(data.get(0).getQuestion()));

        executor.submitTask(() -> answerDao.getAll(),
                (data) -> definition.setText(data.get(0).getAnswer()));
    }

    public void onCancelClick(final View v) {
        startActivity(new Intent(this, StartActivity.class));
    }
}

