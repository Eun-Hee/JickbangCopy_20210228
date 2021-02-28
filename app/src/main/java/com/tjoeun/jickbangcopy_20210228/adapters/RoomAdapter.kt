package com.tjoeun.jickbangcopy_20210228.adapters

import android.content.Context
import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tjoeun.jickbangcopy_20210228.R
import com.tjoeun.jickbangcopy_20210228.datas.Room

class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Room>) : ArrayAdapter<Room>(mContext, resId, mList) {


    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

//        row의 내용물을 변경하고 나서 => return

        val data = mList[position]

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

//        설명 문구 : 있는 그대로
        descriptionTxt.text = data.description

//        주소/층수 => ~~시 ~~구, 5층 => String 가공

//        층수 : 1이상, 0, -1 이하냐에 따라 다르게 가공되어야 함
//        상황에 따라 다르게 층수를 가공하는 기능을 => Room의 기능으로 추가해보자

        addressAndFloorTxt.text = "${data.address}, ${data.getFormattedFloor()}"

//        가격 표시 : price가 1만 이상, 아니냐에 따라 다르게 가공
//        1만 미만 : 8500등 컴마만. 1만 이상 : 5억 4,500 등으로 억단위를 별도 표기
//        해당 기능도 Room의 기능으로 추가해두고 => 가져다쓰자.
        priceTxt.text =
        return row
    }


}