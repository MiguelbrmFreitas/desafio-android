package com.picpay.desafio.android.ui.main.activity

import com.picpay.desafio.android.R
import com.picpay.desafio.android.ui.base.BaseActivity
import com.picpay.desafio.android.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.picpay.desafio.android.BR

class MainActivity() : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel(owner = this)

    override fun layoutId() = R.layout.activity_main

    override fun bindingVariable() = BR.viewModel

    override fun onResume() {
        super.onResume()

        viewModel.startView()
    }
}
