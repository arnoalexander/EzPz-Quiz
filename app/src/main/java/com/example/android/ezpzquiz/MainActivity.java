package com.example.android.ezpzquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean isRadioTrue (int radioGroupId, int correctId) {
        RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupId);
        return (radioGroup.getCheckedRadioButtonId() == correctId);
    }

    private boolean isCheckboxTrue (int checkboxGroupId, ArrayList<Integer> correctIds) {
        ViewGroup viewGroup = (ViewGroup) findViewById(checkboxGroupId);
        int totalChecked = 0;
        for (int i=0; i<viewGroup.getChildCount(); i++) {
            if (((CheckBox)(viewGroup.getChildAt(i))).isChecked()) {
                totalChecked++;
            }
            if (totalChecked > correctIds.size()) {
                break;
            }
        }
        if (totalChecked == correctIds.size()) {
            for (int i=0; i<correctIds.size(); i++) {
                if (!((CheckBox)(findViewById(correctIds.get(i)))).isChecked()) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isEditTextTrue (int editTextId, String correctAnswer) {
        EditText editText = (EditText) findViewById(editTextId);
        return (editText.getText().toString().equals(correctAnswer));
    }

    public void submit(View view) {
        /*Variables*/
        int correctRadioId; //id of correct radio button choice
        ArrayList<Integer> correctCheckId; //ids of correct checkbox choices
        String correctAnswer; //correct string to answer question with editable text field
        int totalQuestions; //number of questions
        int score; //number of right-answered questions
        /*Init values*/
        score = 0;
        totalQuestions=0;
        correctCheckId = new ArrayList<>();
        /*Question 1*/
        correctRadioId = R.id.question1_choice2;
        if (isRadioTrue(R.id.question1_choices, correctRadioId)) {
            score++;
        }
        totalQuestions++;
        /*Question 2*/
        correctCheckId.clear();
        correctCheckId.add(R.id.question2_choice1);
        correctCheckId.add(R.id.question2_choice2);
        if (isCheckboxTrue(R.id.question2_choices, correctCheckId)) {
            score++;
        }
        totalQuestions++;
        /*Question 3*/
        correctRadioId = R.id.question3_choice3;
        if (isRadioTrue(R.id.question3_choices, correctRadioId)) {
            score++;
        }
        totalQuestions++;
        /*Question 4*/
        correctAnswer = "16";
        if (isEditTextTrue(R.id.question4_answer, correctAnswer)) {
            score++;
        }
        totalQuestions++;
        /*Question 5*/
        correctCheckId.clear();
        correctCheckId.add(R.id.question5_choice1);
        correctCheckId.add(R.id.question5_choice2);
        correctCheckId.add(R.id.question5_choice3);
        if (isCheckboxTrue(R.id.question5_choices, correctCheckId)) {
            score++;
        }
        totalQuestions++;
        /*Question 6*/
        correctAnswer = "challenger deep";
        if (isEditTextTrue(R.id.question6_answer, correctAnswer)) {
            score++;
        }
        totalQuestions++;
        /*Question 7*/
        correctRadioId = R.id.question7_choice4;
        if (isRadioTrue(R.id.question7_choices, correctRadioId)) {
            score++;
        }
        totalQuestions++;
        /*Question 8*/
        correctCheckId.clear();
        correctCheckId.add(R.id.question8_choice3);
        correctCheckId.add(R.id.question8_choice4);
        if (isCheckboxTrue(R.id.question8_choices, correctCheckId)) {
            score++;
        }
        totalQuestions++;
        /*Display result with toast*/
        Toast toast = Toast.makeText(getApplicationContext(), "Your answers are " + score + "/"
                + totalQuestions + " correct.", Toast.LENGTH_LONG);
        toast.show();
    }
}
