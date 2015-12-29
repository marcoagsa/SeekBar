package com.msandroid.msa.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbar1, sbar2;
    private TextView yourcoins, yourbet, soma;
    private int Haposta, Hmoedas, total ;
    private Button bjogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarr();

        soma = (TextView)findViewById(R.id.soma);
        bjogar = (Button) findViewById(R.id.button);
        bjogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = (Haposta + sbar1.getProgress());
                soma.setText("Tua Aposta = " + total);
            }
        });



    }

    public int seekBarr() {

        final int[] progress_value = new int[1];
        final int[] progress_value2 = new int[1];
        final int[] progress_value3 = new int[1];


        sbar1 = (SeekBar) findViewById(R.id.seekBar);
        sbar2 = (SeekBar) findViewById(R.id.seekBar2);

        yourcoins = (TextView) findViewById(R.id.YourCoins);
        yourcoins.setText("Your Coins = " + sbar1.getProgress() + " / " + sbar1.getMax());

        yourbet = (TextView) findViewById(R.id.YourBet);
        yourbet.setText("Your Bet = " + sbar2.getProgress() + " / 6 ");

        sbar2.setEnabled(false);

        sbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                                             @Override
                                             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                 progress_value[0] = progress;
                                                 yourcoins.setText("Your Coins = " + progress_value[0] + " / " + sbar1.getMax());

                                                 if (progress_value[0] == 0) {
                                                     sbar2.setMax(6);
                                                     sbar2.setProgress(0);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 0;
                                                 } else if (progress_value[0] == 1) {
                                                     sbar2.setMax(5);
                                                     sbar2.setProgress(1);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 1;
                                                 } else if (progress_value[0] == 2) {
                                                     sbar2.setMax(4);
                                                     sbar2.setProgress(1);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 2;
                                                 } else if (progress_value[0] == 3) {
                                                     sbar2.setMax(3);
                                                     sbar2.setProgress(1);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 3;
                                                 }
                                                 yourbet.setText("Your Bet = " + progress_value[0] + " / 6 ");
                                                 Hmoedas = (progress_value[0]);
                                             }

                                             @Override
                                             public void onStartTrackingTouch(SeekBar seekBar) {
                                                 if (progress_value[0] == 0) {
                                                     sbar2.setMax(6);
                                                     sbar2.setProgress(0);
                                                     progress_value2[0] = 0;
                                                     sbar2.setEnabled(true);
                                                 } else if (progress_value[0] == 1) {
                                                     sbar2.setMax(5);
                                                     sbar2.setProgress(1);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 1;
                                                 } else if (progress_value[0] == 2) {
                                                     sbar2.setMax(4);
                                                     sbar2.setProgress(1);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 2;
                                                 } else if (progress_value[0] == 3) {
                                                     sbar2.setMax(3);
                                                     sbar2.setProgress(1);
                                                     sbar2.setEnabled(true);
                                                     progress_value2[0] = 3;
                                                 }
                                                 Hmoedas = (progress_value[0]);
                                             }

                                             @Override
                                             public void onStopTrackingTouch(SeekBar seekBar) {
                                                 yourcoins.setText("Your Coins = " + progress_value[0] + " / " + sbar1.getMax());
                                                 yourbet.setText("Your Bet = " + progress_value2[0] + " / 6 ");
                                                 Hmoedas = (progress_value[0]);

                                             }
                                         }

        );


        sbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                                             @Override
                                             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                                                 progress_value3[0] = progress_value2[0] + progress;
                                                 yourbet.setText("Your Bet = " + progress_value3[0] + " / 6 ");
                                                 Haposta = (progress_value3[0]);
                                             }

                                             @Override
                                             public void onStartTrackingTouch(SeekBar seekBar) {

                                             }

                                             @Override
                                             public void onStopTrackingTouch(SeekBar seekBar) {
                                                 yourbet.setText("Your Bet = " + progress_value3[0] + " / 6 ");
                                                 Haposta = (progress_value3[0]);
                                             }
                                         }

        );

        return Haposta;
        }
    }