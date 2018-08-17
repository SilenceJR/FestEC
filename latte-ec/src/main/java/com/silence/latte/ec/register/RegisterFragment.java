package com.silence.latte.ec.register;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.silence.latte.ec.R;
import com.silence.latte.ec.bean.SingUpInfo;
import com.silence.latte.ec.databinding.FragmentRegisterBinding;
import com.silence.latte.ec.login.LoginFragment;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends SwipeBackFragment {


    private FragmentRegisterBinding mBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SingUpInfo signUpInfo = new SingUpInfo("123", "12", "134567452345", "123@123.com");
        mBinding.setSignUpInfo(signUpInfo);
    }

    public static RegisterFragment newInstance() {

        Bundle args = new Bundle();

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private boolean checkForm() {
        String name = mBinding.editRegisterName.getText().toString();
        String age = mBinding.editRegisterAge.getText().toString();
        String phone = mBinding.editRegisterPhone.getText().toString();
        String email = mBinding.editRegisterEmail.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mBinding.editRegisterName.setError("请输入姓名");
            isPass = false;
        } else {
            mBinding.editRegisterName.setError(null);
        }

        if (age.isEmpty() || Integer.valueOf(age) < 0 || Integer.valueOf(age) > 100) {
            mBinding.editRegisterAge.setError("请输入正确的年龄");
            isPass = false;
        } else {
            mBinding.editRegisterAge.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mBinding.editRegisterEmail.setError("请输入正确的邮箱");
            isPass = false;
        } else {
            mBinding.editRegisterEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            mBinding.editRegisterPhone.setError("请输入正确的手机号码");
            isPass = false;
        } else {
            mBinding.editRegisterPhone.setError(null);
        }

        return isPass;
    }

    public class Presenter {
        public void onClick(View view) {
            start(new LoginFragment());
        }

        public void onViewClicked(View view) {
            if (checkForm()) {
                Toast.makeText(getContext(), "恭喜你， 注册成功了", Toast.LENGTH_LONG).show();
            }
        }
    }

}
