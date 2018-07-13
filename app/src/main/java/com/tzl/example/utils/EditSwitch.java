package com.tzl.example.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * author: tangzenglei
 * created on: 2018/7/12 下午4:21
 * description:
 */
public class EditSwitch {



    public static void editOn(EditText editText, boolean canEdit,Activity activity) {
        editText.setCursorVisible(canEdit);
        editText.setLongClickable(canEdit);
        editText.setFocusableInTouchMode(canEdit);
        editText.setFocusable(canEdit);
//        editText.setTextIsSelectable(canEdit);
        editText.setCustomSelectionActionModeCallback(new ActionModeCallbackInterceptor());
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            editText.setCustomInsertionActionModeCallback(new ActionModeCallbackInterceptor());
        }

        if (canEdit) {
            hideKeyBoard(editText,activity);
        }else{
            showKeyBoard(editText,activity);
        }

    }

    private static void hideKeyBoard(EditText editText ,Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //隐藏软键盘 //
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        //切换软键盘的显示与隐藏
        imm.toggleSoftInputFromWindow(editText.getWindowToken(), 0, InputMethodManager.HIDE_NOT_ALWAYS);

    }
    private static void showKeyBoard(EditText editText ,Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //显示软键盘
        imm.showSoftInputFromInputMethod(editText.getWindowToken(), 0);
        //切换软键盘的显示与隐藏
        imm.toggleSoftInputFromWindow(editText.getWindowToken(), 0, InputMethodManager.HIDE_NOT_ALWAYS);

    }


    /**
     * 粘贴板过滤
     */
    private static class ActionModeCallbackInterceptor implements ActionMode.Callback {


        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }


        public void onDestroyActionMode(ActionMode mode) {
        }
    }

}
