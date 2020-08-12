package br.com.irrconsultoria.economizofertas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    ProgressBar mProgressBar;
    int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initProgress();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), ConsultarOfertas.class));
                finish();
                exibirProgress(false);
            }
        }, SPLASH_TIME_OUT);

    }

    private void exibirProgress(boolean exibir) {
        mProgressBar.setVisibility(exibir ? View.VISIBLE : View.GONE);
    }

    private void initProgress() {
        mProgressBar = findViewById(R.id.mProgressBar);
        exibirProgress(true);
    }
}
