package com.tzl.example.view;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.EditText;

/**
 * author: tangzenglei
 * created on: 2018/7/13 上午11:29
 * description: 限制前几个自定义字符加粗并不能编辑
 * such as:
 * 备注：****
 */
public class ServralIntialTextWatcher implements TextWatcher {

    private String head = "";
    private EditText mEditText;

    public ServralIntialTextWatcher(String head, EditText editText) {
        this.head = head;
        mEditText = editText;

        setUpEditText();
    }

    private void setUpEditText() {
        //加粗字体
        SpannableString spannableString = new SpannableString(head);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,head.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mEditText.setText(spannableString);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //如果当前光标在 EditText 标题之前
        Log.e("EditTextActivity","s字符串为："+s+"开始处："+start+"，替换体的长度："+count+"后替换体长度"+after);
        if (head.length()>= (start+1)&&count>after) {//删除(count>after)时，若光标位置在前几个字符则删除无效
            mEditText.setText(s);
            mEditText.setSelection(head.length());
            return;
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
