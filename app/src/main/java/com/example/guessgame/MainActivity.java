package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView titleText;
    EditText userInput;
    Button guessButton;
    int guessNumber;
    int userNumber;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleText = findViewById(R.id.title_text);
        userInput = findViewById(R.id.user_input);
        guessButton = findViewById(R.id.guess_button);
        Random rnd = new Random();
        guessNumber = rnd.nextInt(10);
        gameFinished = false;
    }

    public void tryNumber(View view) {

        userNumber = Integer.parseInt(userInput.getText().toString());
        if(!gameFinished){

            if(guessNumber==userNumber){
                titleText.setText("Ура!!! Ты угадал!!!");
                gameFinished = true;
                guessButton.setText("Сыграть еще раз");

            }
            else{
                titleText.setText("Неверно. Попробуй еще...");

            }
        }else
        {
            Random rnd = new Random();
            guessNumber = rnd.nextInt(10);
            gameFinished=false;
            guessButton.setText("Угадать");
        }


    }
}