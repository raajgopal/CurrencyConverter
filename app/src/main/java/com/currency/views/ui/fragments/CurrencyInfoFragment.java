package com.currency.views.ui.fragments;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.currency.R;
import com.currency.entities.CountryCurrencyInfo;
import com.currency.presenter.CurrencyInfoPresenter;
import com.currency.views.ui.adapters.CurrencyRecyclerViewAdapter;
import com.currency.views.ui.contract.CurrencyViewContract;
import com.currency.views.ui.listeners.OnCurrencyValueChangedListener;
import dagger.android.support.AndroidSupportInjection;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;

public class CurrencyInfoFragment extends Fragment implements CurrencyViewContract {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    CurrencyRecyclerViewAdapter recyclerViewAdapter;
    @Inject
    CurrencyInfoPresenter currencyInfoPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        currencyInfoPresenter.onActivityCreated();
        recyclerViewAdapter = new CurrencyRecyclerViewAdapter(new OnCurrencyValueChangedListener() {
            @Override
            public void onCurrencyAmountChanged(@NotNull String symbol, float amount) {
                currencyInfoPresenter.evaluateRates(symbol, amount);
            }
        });

        initView();
    }

    private void initView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        currencyInfoPresenter.currencyView = this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        currencyInfoPresenter.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.currency_info_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerCurrencies);
        progressBar = view.findViewById(R.id.progressView);
        return view;
    }


    @Override
    public void updateCurrencyRatesList(@NotNull ArrayList<CountryCurrencyInfo> rates) {
        recyclerViewAdapter.updateRates(rates);
    }

    @Override
    public void showLoading(final boolean isLoading) {
        Context context = getContext();
        Resources resources = context != null ? context.getResources() : null;
        if (resources != null) {
            int shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime);

            handleRecyclerVisibility(isLoading);

            recyclerView.animate().setDuration(shortAnimTime).alpha(
                    (isLoading ? 0
                            : 1)).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    handleRecyclerVisibility(isLoading);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
            progressBar.animate().setDuration(shortAnimTime).alpha(
                    (isLoading ? 1
                            : 0)).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    if (isLoading) {
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        progressBar.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

    }

    private void handleRecyclerVisibility(boolean isLoading) {
        if (isLoading) {
            recyclerView.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), R.string.error_unknown, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateCurrencyAmount(float amount) {
        recyclerViewAdapter.updateAmount(amount);
    }
}
