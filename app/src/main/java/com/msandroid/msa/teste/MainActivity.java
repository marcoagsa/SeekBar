package com.msandroid.msa.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbar1,sbar2;
    private TextView yourcoins, yourbet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarr();
    }

    private void seekBarr () {
        final int[] progress_value = new int[1];
        final int[] progress_value2 = {0};
        sbar1 = (SeekBar)findViewById(R.id.seekBar);
        sbar2 = (SeekBar)findViewById(R.id.seekBar2);

        yourcoins = (TextView)findViewById(R.id.YourCoins);
        yourcoins.setText("Your Coins = " + sbar1.getProgress() +" / " + sbar1.getMax() );

        yourbet = (TextView)findViewById(R.id.YourBet);
        yourbet.setText("Your Bet = " + sbar2.getProgress() + " / " + sbar2.getMax());

        sbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //public int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value[0] = progress;
                yourcoins.setText("Your Coins = " + progress_value[0] + " / " + sbar1.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                yourcoins.setText("Your Coins = " + progress_value[0] + " / " + sbar1.getMax());
            }
        });

        if (progress_value[0] == 0){
            sbar2.setMax(6);
        }else if (progress_value[0]==1){
            sbar2.setMax(5);
        }else if (progress_value[0]==2){
            sbar2.setMax(5);
        }else if (progress_value[0]==3){
            sbar2.setMax(4);
        }

        sbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value2[0] = progress_value[0] + progress;

                yourbet.setText("Your Bet = " + progress_value2[0] + " / " + sbar2.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                yourbet.setText("Your Bet = " + progress_value2[0] + " / " + sbar2.getMax());
            }
        });


    }
}
