package work.nbcc.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    private var questionIndex = 0

    private lateinit var  questionView : TextView

    private lateinit var nextButton : Button

    private lateinit var previousButton : Button

    private lateinit var falseButton : Button

    private lateinit var trueButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.question_view)
        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)

        questionView.setText(questionBank[questionIndex].textResId)
        nextButton.setOnClickListener{
            questionIndex = (questionIndex + 1) % 20
            questionView.setText(questionBank[questionIndex].textResId)
        }

        previousButton.setOnClickListener{
            if(questionIndex > 0){
                questionIndex = (questionIndex - 1) % 20
                questionView.setText(questionBank[questionIndex].textResId)
            }
        }

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        trueButton.setOnClickListener { answer(true) }
        falseButton.setOnClickListener{answer(false)}
    }

    private fun answer(ans: Boolean) {
        if (ans && ans == questionBank[questionIndex].answer) {
            Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT).show()
        } else if (!ans && ans == questionBank[questionIndex].answer) {
            Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "WRONG", Toast.LENGTH_SHORT).show()
        }
    }
}
