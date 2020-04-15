package com.ijays.gomvvm.model

/**
 * Created by ijays on 2020/4/15.
 */
//"desc": "享学~",
//"id": 29,
//"imagePath": "https://wanandroid.com/blogimgs/6f9c0f25-e02d-48a5-bbfa-ed199416009a.png",
//"isVisible": 1,
//"order": 0,
//"title": "产品上线，突发bug&hellip;",
//"type": 0,
//"url": "https://mp.weixin.qq.com/s/TcF4w0Bz-k5dZdPKq3HIGA"

data class BannerModel(
    val id: Int,
    val desc: String,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)