package modskins.docxreader.abhishek.pdftodocx.basicdocx.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class dice extends AppCompatActivity {

    public int userOverallScore = 0, userTurnScore = 0;
    public int computerOverallScore = 0, computerTurnScore = 0;


    TextView label ;
    Button rollButton ;
    Button holdButton;
    Button resetButton;
    ImageView diceimg;

    String userScoreLabel = "<b><i>Your Score : </i></b>";
    String compScoreLabel = "<b><i>Comp Score : </i></b>";
    String userTurnScoreLabel = "<b><i>Your Turn Score : </i></b>";
    String compTurnScoreLabel = "\n<b><i>Comp Turn Score : </i></b>";

    Timer myTimer;


    String labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore;

    int [] drawables = {R.drawable.dice1,
                        R.drawable.dice2,
                        R.drawable.dice3,
                        R.drawable.dice4,
                        R.drawable.dice5,
                        R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        label = (TextView) findViewById(R.id.label);
        rollButton = (Button) findViewById(R.id.rollButton);
        holdButton = (Button) findViewById(R.id.holdButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        diceimg = (ImageView) findViewById(R.id.diceimg);

        label.setText(Html.fromHtml(labelText));




    }




    private int rollDice()
    {

        Random random = new Random();
        int randomNumber = random.nextInt(6);
       // Log.d("TAG","rollBtClick: " + randomNumber);
        return randomNumber;
    }

    private void enableButtons(boolean isEnabled)
    {
        rollButton.setEnabled(isEnabled);
        holdButton.setEnabled(isEnabled);

    }

    public void rollButtonClick(View view)
    {
        int rolledNumber = rollDice();
        diceimg.setImageResource(drawables[rolledNumber]);
        rolledNumber++;
        if(rolledNumber == 1){

            userTurnScore = 0;
            labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + userTurnScoreLabel + userTurnScore;
            computerTurn();
        }
        else
        {
            userTurnScore += rolledNumber;
            labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore;
        }


    }
    public void holdButtonClick(View view)
    {

        userOverallScore += userTurnScore;
        userTurnScore = 0;
        labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + userTurnScoreLabel + userTurnScore;
        //labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore;
        label.setText(Html.fromHtml(labelText));
        computerTurn();

    }

    public void resetButtonClick(View view) {

        userOverallScore = 0;
        userTurnScore = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;

        labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + userTurnScoreLabel + userTurnScore;
        label.setText(Html.fromHtml(labelText));

        enableButtons(true);

    }

    public void computerTurn() {


        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {


                //disable the buttons while computer is playing
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        holdButton.setEnabled(false);
                        rollButton.setEnabled(false);
                    }
                });


                int computerRolledNumber = rollDice();


                final int finalComputerRolledNumber = computerRolledNumber;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        diceimg.setImageResource(drawables[finalComputerRolledNumber]);
                    }
                });
                computerRolledNumber++;

                //if computer looses, set turnSCore to 0 and enable buttons for user's turn
                if (computerRolledNumber == 1) {
                    computerTurnScore = 0;
                    labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + compTurnScoreLabel + userTurnScore +
                            "\n computer rolled a one and lost it's chance";


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            holdButton.setEnabled(true);
                            rollButton.setEnabled(true);

                        }
                    });

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            label.setText(Html.fromHtml(labelText));
                        }
                    });

                    //cancel the timer
                    myTimer.cancel();

                }
                //if not 1, add the score to turn score
                else {
                    computerTurnScore += computerRolledNumber;

                    labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + userTurnScoreLabel + userTurnScore
                            + "\nComputer rolled a " + computerRolledNumber;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            label.setText(Html.fromHtml(labelText));
                        }
                    });

                    //if the turn score is greater than 20 stop rolling and hold(update the comp score and cancel timer)
                    if (computerTurnScore  > 20) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                holdButton.setEnabled(true);
                                rollButton.setEnabled(true);
                            }
                        });

                        computerOverallScore += computerTurnScore;
                        computerTurnScore = 0;
                        labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + "\n" +
                                "Computer holds";
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                label.setText(Html.fromHtml(labelText));
                            }
                        });


                        myTimer.cancel();


                    }

                }

            }

        }, 0, 2000);


    }

}



        /*

  enableButtons(false);

        while (true) {

            int computerRolledNumber = rollDice();
            diceimg.setImageResource(drawables[computerRolledNumber]);
            computerRolledNumber++;

            // if computer get's a 1
            if (computerRolledNumber == 1) {
                computerTurnScore = 0;
                labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + userTurnScoreLabel + userTurnScore
                        + "\n computer rolled a one and lost it's chance";
                enableButtons(true);
                label.setText(Html.fromHtml(labelText));
                return;
            }

            // otherwise
            else {
                computerTurnScore += computerRolledNumber;
                labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + userTurnScoreLabel + userTurnScore
                        + "\nComputer rolled a " + computerRolledNumber;
                label.setText(Html.fromHtml(labelText));
            }

            //holding strategy
            if (computerTurnScore > 20) {
                computerOverallScore += computerTurnScore;
                computerTurnScore = 0;
                labelText = userScoreLabel + userOverallScore + compScoreLabel + computerOverallScore + "\n" +
                        "Computer holds";
                //updates the label everytime
                label.setText(Html.fromHtml(labelText));
                enableButtons(true);
                return;
            }

        }
    */

