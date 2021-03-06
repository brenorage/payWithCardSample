package com.example.brenorage.paymentwithcreditcardsample.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.brenorage.paymentwithcreditcardsample.R;
import com.example.brenorage.paymentwithcreditcardsample.Util.adapters.HistoryAdapterRecyclerView;
import com.example.brenorage.paymentwithcreditcardsample.presenter.HistoryPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.historyListRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.listEmpty)
    TextView listEmpty;

    HistoryPresenter historyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        historyPresenter = new HistoryPresenter();
        try {
            HistoryAdapterRecyclerView adapter = historyPresenter.getAdapter();

            if(adapter == null) {
                setListEmptyLayout();
            }
            else {
                recyclerView.setAdapter(adapter);
            }
        }
        catch (Exception e) {
            setListEmptyLayout();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setListEmptyLayout() {
        recyclerView.setVisibility(View.GONE);
        listEmpty.setVisibility(View.VISIBLE);
    }
}
