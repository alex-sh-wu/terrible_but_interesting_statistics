package com.example.timmycheng.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;


public class StatisticGenerator extends ActionBarActivity {


    TextView factOfTheDay;
    Button start;
    private Map<String, String[]> dictionary = new HashMap<String, String[]>();
    String[] percentage = new String[2];
    String[] pronouns = new String[1];
    String[] listofJokes = new String[5];
    boolean filledDictionary = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_generator);
        factOfTheDay = (TextView) findViewById(R.id.get_stat);
        start = (Button) findViewById(R.id.button);

        //percentage = new String[2];
        percentage[0] = "%";
        percentage[1] = "of ";

        //pronouns = new String[1];
        pronouns[0] = "mathematicians";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistic_generator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void fillDictionary() {
        //listofJokes = new String[5];
        listofJokes[0] = "punchline1";
        listofJokes[1] = "punchline2";
        listofJokes[2] = "punchline3";
        listofJokes[3] = "punchline4";
        listofJokes[4] = "punchline5";
        //System.out.println("HELLO" + listofJokes[0]);
        dictionary.put(pronouns[0], new String[] {"punchline1", "punchline2", "punchline3", "punchline4", "punchline5"});
    }

    private String generateX() {
        Random randomGenerator = new Random();
        String chance = "x";
        int temp = randomGenerator.nextInt(2);

        if (temp == 0) {
            chance = (randomGenerator.nextInt(101)) + percentage[temp];
        }
        else if (temp == 1) {
            int max = randomGenerator.nextInt() + 1;
            chance = randomGenerator.nextInt(max) + percentage[temp] + randomGenerator.nextInt(max) + " ";
        }

        return chance;
    }

    private String generateYandZ() {
        Random randomGenerator = new Random();
        String chance = "y and z ";
        int sizeofY = pronouns.length;
        String noun = pronouns[randomGenerator.nextInt(sizeofY)];
        int sizeofZ = dictionary.get(noun).length;

        chance = noun + " " + dictionary.get(noun)[randomGenerator.nextInt(sizeofZ)];

        return chance;
    }

    public void onClickGenerateStat(View view) {
        if (!filledDictionary) {
            filledDictionary = true;
            fillDictionary();
        }
        fillDictionary();
        factOfTheDay.setText(generateX() + " " + generateYandZ());
        start.setText("NEXT");
    }
}