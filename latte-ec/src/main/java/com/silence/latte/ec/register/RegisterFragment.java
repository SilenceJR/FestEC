package com.silence.latte.ec.register;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.silence.latte.delegates.LatteFragment;
import com.silence.latte.ec.R;
import com.silence.latte.ec.R2;
import com.silence.latte.ec.login.LoginFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends LatteFragment {


    @BindView(R2.id.edit_register_name)
    TextInputEditText mEditRegisterName;
    @BindView(R2.id.edit_register_age)
    TextInputEditText mEditRegisterAge;
    @BindView(R2.id.edit_register_phone)
    TextInputEditText mEditRegisterPhone;
    @BindView(R2.id.edit_register_email)
    TextInputEditText mEditRegisterEmail;

    @Override
    public Object setLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    public static RegisterFragment newInstance() {

        Bundle args = new Bundle();

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private boolean checkForm() {
        String name = mEditRegisterName.getText().toString();
        String age = mEditRegisterAge.getText().toString();
        String phone = mEditRegisterPhone.getText().toString();
        String email = mEditRegisterEmail.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mEditRegisterName.setError("请输入姓名");
            isPass = false;
        } else {
            mEditRegisterName.setError(null);
        }

        if (age.isEmpty() || Integer.valueOf(age) < 0 || Integer.valueOf(age) > 100) {
            mEditRegisterAge.setError("请输入正确的年龄");
            isPass = false;
        } else {
            mEditRegisterAge.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEditRegisterEmail.setError("请输入正确的邮箱");
            isPass = false;
        } else {
            mEditRegisterEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            mEditRegisterPhone.setError("请输入正确的手机号码");
            isPass = false;
        } else {
            mEditRegisterPhone.setError(null);
        }

        return isPass;
    }

    @OnClick(R2.id.icon_register_in_wechat)
    public void onClickWechat() {
        start(new LoginFragment());
    }

    @OnClick(R2.id.btn_register)
    public void onViewClicked() {
        if (checkForm()) {
            Toast.makeText(getContext(), "恭喜你， 注册成功了", Toast.LENGTH_LONG).show();
        }
    }

}
