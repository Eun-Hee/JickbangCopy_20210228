package com.tjoeun.jickbangcopy_20210228

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tjoeun.jickbangcopy_20210228.adapters.RoomAdapter
import com.tjoeun.jickbangcopy_20210228.datas.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<Room>()

    lateinit var mAdapter : RoomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomList.add(Room(8000, "서울시 종로구", 4, "종로의 4층 방."))
        mRoomList.add(Room(25600, "경기도 고양시", -1, "고양시의 지하1층 방."))
        mRoomList.add(Room(17000, "서울시 동작구", 0, "종로의 4층 방."))
        mRoomList.add(Room(4000, "충청시 천안시", 5, "종로의 4층 방."))
        mRoomList.add(Room(5000, "서울시 은평구", 8, "종로의 4층 방."))
        mRoomList.add(Room(35000, "서울시 동대문구", -2, "종로의 4층 방."))
        mRoomList.add(Room(8000, "서울시 강북구", 3, "종로의 4층 방."))
        mRoomList.add(Room(2500, "경기도 과천시", 1, "종로의 4층 방."))
        mRoomList.add(Room(78000, "경기도 고양시", 0, "종로의 4층 방."))
        mRoomList.add(Room(160000, "서울시 종로구", -4, "종로의 4층 방."))
        mRoomList.add(Room(9900, "서울시 은평구", 8, "종로의 4층 방."))


        mAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mAdapter

        roomListView.setOnItemClickListener { parent, view, position, id ->

//            클릭 된 방이 어떤 방인지?
            val clickedRoom = mRoomList[position]

//             이 방 정보를 들고 => 상세화면으로 이동. Intent 사용

            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)

            myIntent.putExtra("roomInfo", clickedRoom)

            startActivity(myIntent)
        }

    }
}

