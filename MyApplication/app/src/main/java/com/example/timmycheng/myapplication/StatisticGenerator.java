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
    String[] pronouns = new String[11];
    boolean filledDictionary = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_generator);
        factOfTheDay = (TextView) findViewById(R.id.get_stat);
        start = (Button) findViewById(R.id.button);

        //percentage = new String[2];
        percentage[0] = "%";
        percentage[1] = " of ";

        //pronouns = new String[1];
        pronouns[0] = "mathematicians";
        pronouns[1] = "statisticians";
        pronouns[2] = "lawyers";
        pronouns[3] = "politician";
        pronouns[4] = "professors";
        pronouns[5] = "teaching assistants";
        pronouns[6] = "nurses";
        pronouns[7] = "doctors";
        pronouns[8] = "dentists";
        pronouns[9] = "police officers";
        pronouns[10] = "Computer Science Majors";
//        pronouns[11] = "Psychology Majors";
//        pronouns[12] = "Philosophy Majors";
//        pronouns[13] = "males";
//        pronouns[14] = "females";
//        pronouns[15] = "university students";
//        pronouns[16] = "otakus";
//        pronouns[17] = "LoL players";
//        pronouns[18] = "DoTA players";
//        pronouns[19] = "airplane pilots";
//        pronouns[20] = "Science Majors";
//        pronouns[21] = "iPhone users";
//        pronouns[22] = "Android users";
//        pronouns[23] = "people over the age of 65";
//        pronouns[24] = "people under the age of 18";


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
        //System.out.println("HELLO" + listofJokes[0]);
        dictionary.put(pronouns[0], new String[] {"become high schoolteachers", "wish they were engineers", "have no sense of humour"});
        dictionary.put(pronouns[1], new String[] {"make up their numbers", "hate their profession", "are mean"});
        dictionary.put(pronouns[2], new String[] {"work only 4 months a year", "hate teenage clients", "end up on the news"});
        dictionary.put(pronouns[3], new String[] {"are involved in scandals", "do not follow through with their promises", "know their speeches are about nothing"});
        dictionary.put(pronouns[4], new String[] {"love teaching", "hate teaching", "enjoy giving out pop quizzes", "love it when students ask for a mark boost"});
        dictionary.put(pronouns[5], new String[] {"lower the grade of a paper if there is too much writing", "do not actually help at tutorials", "enjoy marking the same question hundreds of times"});
        dictionary.put(pronouns[6], new String[] {"enjoy scooping human poop", "get less than 1 hour of sleep per night", "talk to their patients about their feelings"});
        dictionary.put(pronouns[7], new String[] {"enjoy touching their patients", "enjoy the scream of pain when giving vaccinations", "do not actually wash their hands"});
        dictionary.put(pronouns[8], new String[] {"love mocking you about your bleeding gums", "try to make conversation while instruments are in your mouth"});
        dictionary.put(pronouns[9], new String[] {"ride bikes instead of cars", "have racial biases", "are out of control"});
        dictionary.put(pronouns[10], new String[] {"get enough sleep", "finish their homework", "cry themselves to sleep at night", "enjoy running into bugs"});

    }

    private String generateX() {
        Random randomGenerator = new Random();
        String chance = "x";
        int temp = randomGenerator.nextInt(2);

        if (temp == 0) {
            chance = (randomGenerator.nextInt(101)) + percentage[temp];
        }
        else if (temp == 1) {
            int max = randomGenerator.nextInt(200) + 1;
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