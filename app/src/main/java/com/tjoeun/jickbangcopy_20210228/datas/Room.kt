package com.tjoeun.jickbangcopy_20210228.datas

import android.icu.number.NumberRangeFormatterSettings
import java.io.Serializable
import java.text.NumberFormat
import java.util.*

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String) : Serializable {

    constructor(price: Int) : this(price,  "주소 미정",  1,  "가격만 넣은방")

//    가격 값에 따라 => 억단위 표시 여부 가공 기능 => 함수로

    fun getFormattedPrice() : String {

    if (this.price < 10000) {
//        8,500 등 컴마처리

        return NumberFormat.getNumberInstance(Locale.US).format(this.price)
    }
    else{
//        1억 이상, ?억4,500등 억단위 + 컴마처리 둘다

//        억? 몇억인지 => 가격을 10000으로 나문 몫임
        val uk = this.price / 10000

//        억 밑은 얼마인지:\?
        val rest = this.price%10000
//        rest => 컴마 처리
        val commaRest= NumberFormat.getNumberInstance(Locale.US).format(rest)
        return "${uk}억 ${commaRest}"

    }
    }


//    층수 값에 따라 => 5층, 반지하, 지하 2층 등으로 가공해주는 기능 => 함수 (function)

    fun getFormattedFloor() : String {
        
//        층수 값에 따라 다른 값을 return
        if (this.floor >= 1) {
//            1층, 5층 등등... => floor층
            return "${this.floor}층"
        }
        else if (this.floor == 0){
//            0층 : 반지하
            return "반지하"
        }
        else {
//            -1층, -2층.. => 지하 1층, 지하 2층 등으로 가공.
            return "지하 ${-this.floor}층"
        }
    }

}