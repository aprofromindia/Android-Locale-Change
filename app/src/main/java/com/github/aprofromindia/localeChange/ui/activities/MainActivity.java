package com.github.aprofromindia.localeChange.ui.activities;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.github.aprofromindia.localeChange.R;
import com.github.aprofromindia.localeChange.ui.activities.base.BaseActivity;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String ENG_LABEL = "English";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.locale_btn)
    void sampleBtnClicked(Button button) {
        if (button.getText().equals(ENG_LABEL)) {
            setLocale(Locale.GERMAN);
        } else {
            setLocale(Locale.ENGLISH);
        }
        recreate();
    }

    private void setLocale(final Locale locale) {
        Configuration config = new Configuration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        } else {
            //noinspection deprecation
            config.locale = locale;
        }
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}
