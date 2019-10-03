package com.tanjiajun.kotlindsldemo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by TanJiaJun on 2019-10-01.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvCommonCallbackContent = findViewById<TextView>(R.id.tv_common_callback_content)
        val tvDSLCallbackContent = findViewById<TextView>(R.id.tv_dsl_callback_content)

        findViewById<EditText>(R.id.et_common_callback_content).addTextChangedListener(object :
                TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // no implementation
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // no implementation
            }

            override fun afterTextChanged(s: Editable?) {
                tvCommonCallbackContent.text = s
            }
        })

        findViewById<EditText>(R.id.et_dsl_callback_content).addTextChangedListener(
                registerTextWatcher {
                    afterTextChanged { tvDSLCallbackContent.text = it }
                })
    }

}