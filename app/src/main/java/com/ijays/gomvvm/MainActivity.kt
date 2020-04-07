package com.ijays.gomvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ijays.gomvvm.ui.viewmodel.ArticleListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val articleListViewModel: ArticleListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("SONGJIE", "articleListViewModel is null==>${articleListViewModel == null}")

        if (articleListViewModel != null) {
            articleListViewModel.getArticleLivaData().observe(this, Observer {
                Log.e("SONGJIE", "RESULT==>$it")
            })
        }
    }


}
