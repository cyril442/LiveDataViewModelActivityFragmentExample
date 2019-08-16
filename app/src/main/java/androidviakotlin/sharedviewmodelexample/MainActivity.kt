package androidviakotlin.sharedviewmodelexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.layout_top_fragment_entryWord, InputFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.layout_bottom_fragment_ResultWord, OutputFragment()).commit()

        val messageMainActivity = resources.getString(R.string.show_input)

        val wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        wordViewModel.inputWord.observe(this, Observer {
            it?.let {
                textView_IntoMainActivity.text = "$messageMainActivity : $it"
            }
        })
    }
}
