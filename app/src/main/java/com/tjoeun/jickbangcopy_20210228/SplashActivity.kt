package com.tjoeun.jickbangcopy_20210228

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        너무 빨리 메인으로 넘어간다. => 3초정도 후에 넘어가게 하고 싶다.

//        핸들러 변수 생성
        val myHandler = Handler(Looper.getMainLooper())

//        핸들러를 이용 => 3초 후에 Intent로 넘어가게

        myHandler.postDelayed({

            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)

//            화면 이동후에는 로딩화면 종료
            finish()


        }, 3000)
    }
}