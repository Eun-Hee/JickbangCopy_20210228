package com.tjoeun.jickbangcopy_20210228.datas

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String) {
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
//            -1층, -2층
        }
    }

}