package com.ijays.gomvvm.di

import com.ijays.gomvvm.repo.ArticleListRepository
import org.koin.dsl.module

/**
 * Created by ijays on 2020/4/4.
 */
val repositoryModule = module {
    single {
        ArticleListRepository()
    }
}