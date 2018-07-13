package com.tzl.example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kyleduo.alipayhome.R;
import com.tzl.example.utils.EditSwitch;
import com.tzl.example.view.ServralIntialTextWatcher;

public class EditTextActivity extends AppCompatActivity {

    public static final String str = "特别备注：";
    private TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        final EditText editText = (EditText) findViewById(R.id.editText);
        btn = (TextView) findViewById(R.id.saveOrEdit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = btn.getText().toString();
                if ("保存".equals(text)) {
                    //当前处于编辑状态
                    //TODO: 隐藏光标，显示为编辑
                    EditSwitch.editOn(editText,false,EditTextActivity.this);
                    btn.setText("编辑");
                }else{//当前处于保存状态
                    //TODO: 显示光标，显示为保存，控制前 n 个字符不能显示光标
                    EditSwitch.editOn(editText,true,EditTextActivity.this);
                    btn.setText("保存");
                }
            }
        });
        editText.addTextChangedListener(new ServralIntialTextWatcher(str,editText));
    }


}

