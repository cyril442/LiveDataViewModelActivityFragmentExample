package androidviakotlin.sharedviewmodelexample

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_input.*


class InputFragment : Fragment() {

    private var wordViewModel: WordViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.let {
            /**
             *  create view model in activity scope
             */
            wordViewModel = ViewModelProviders.of(it).get(WordViewModel::class.java)
        }

        EditText_InputWordByTheUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(txt: CharSequence?, p1: Int, p2: Int, p3: Int) {
                txt?.let {
                    var inputWord = "your word"
                    if (txt.toString().isNotEmpty()) {
                        inputWord = txt.toString()
                    }

                    wordViewModel?.inputWord?.postValue(inputWord)
                }
            }
        })
    }
}



