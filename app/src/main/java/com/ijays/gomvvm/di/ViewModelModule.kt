package com.ijays.gomvvm.di

import com.ijays.gomvvm.ui.viewmodel.ArticleListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by ijays on 2020/4/7.
 */
val viewModelModule = module {
    viewModel {
        ArticleListViewModel(get())
    }
}