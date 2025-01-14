package com.example.dartsstats

import kotlin.math.max

class Game(name1: String, name2: String, private val maxSet: Int, maxLeg: Int, firstPlayer: Boolean){

    var currentSet = 0
    var currentLeg = 0
    var n180s: Pair<Int, Int> = Pair(0,0)
    //TODO: fai questo
    var nineDarts = Pair(0,0)
    var name1 = name1
    var sets = mutableListOf<Set>(Set(1,firstPlayer, maxLeg))
    var totScores = Pair(0,0)
    var totDarts = Pair(0,0)
    var Scores: Pair<List<Int>,List<Int>> = Pair (listOf(0,0,501), listOf(0,0,501))

    //trova un nome migliore ti prego
    fun updateScore(points: List<Int?>, player: Boolean){
        sets.last().updateScore(player, points)
        getNineDarts()
        setCurrent()
        var sum = getSum(points)
        var numDarts = getNumDarts(points)

        if(player){
            totScores.first.plus(sum)
            totDarts.first.plus(numDarts)
            if(sum==180){
                n180s.first.inc()
            }

        }






    }

    fun getSum(points: List<Int?>): Int {
        var sum = 0
        for(i in 0..2){
            if(points[i]!=null){
                sum += points[i]!!
            }else{
                break
            }
        }
        return sum
    }

    fun getNumDarts(points: List<Int?>): Int {
        var numDarts = 0
        for(i in 0..2){
            if(points[i]!=null){
                numDarts += 1
            }else{
                break
            }
        }
        return numDarts
    }

    fun setCurrent(){
        this.currentSet=this.sets.last().num
        this.currentLeg=this.sets.last().legs.last().num
    }

    fun getNineDarts(){
        this.nineDarts.first.minus(this.nineDarts.first)
        this.nineDarts.second.minus(this.nineDarts.second)

        for(i in 0..sets.size){
            this.nineDarts.first.plus(sets[i].nineDarts.first)
            this.nineDarts.second.plus(sets[i].nineDarts.second)
        }
    }

//    fun getGameScores(): Pair<List<Int>,List<Int>>{
//    }







}

class Set(num: Int, firstPlayer: Boolean, maxLeg: Int) {
    //firstPlayer: true -> player1 goes first, false-> player2
    var legs: MutableList<Leg> = mutableListOf()
    var n180s: Pair<Int, Int> = Pair(0,0)
    var firstPlayer = firstPlayer
    val maxLeg = maxLeg
    private var winner = -1
    var totScores = Pair(0,0)
    var totDarts = Pair(0,0)
    val num = num
    var nineDarts = Pair(0,0)



    fun updateScore(player: Boolean, points: List<Int?>){
        //player: true-> first player
        var numDarts = 0
        var sum = 0
        for(i in 0..2){
            if(points[i]!=null){
                sum += points[i]!!
                numDarts+=1
            }else{
                break
            }
        }

        if (sum==180){
            if(player) {
                n180s.first.inc()
            }else{
                n180s.second.inc()
            }
        }

        if(player){
            totScores.first.plus(sum)
            totDarts.first.plus(numDarts)
        }else{
            totScores.second.plus(sum)
            totDarts.second.plus(numDarts)
        }

        legs.last().updateScore(player, points)
        //se il leg e finito
        if(legs.last().closure.first!=0 || legs.last().closure.second!=0){
            if(legs.last().numDarts.first == 9){
                nineDarts.first.inc()
            }else if(legs.last().numDarts.first == 9){
                nineDarts.second.inc()
            }
            //se si sono raggiunti i leg per set il set e concluso
            if(legs.size==maxLeg){
                winner=getWinner1()
            }else{
                //altrimenti aggiungi un altro leg
                legs.add(Leg(num = legs.last().num + 1, firstPlayer = legs.last().firstPlayer.not()))
            }
        }
    }

    fun getWinner1(): Int{
        var c1 = 0
        var c2 = 0
        for(l in legs){
            if(l.closure.first != 0){
                c1+=1
            }else{
                c2+=1
            }
        }
        if(c1>c2){
            return 1
        }else if(c2>c1){
            return 2
        }else{
            return 0
        }
    }


    fun getAvg():Pair<Double, Double>{
        return Pair(
            (501-this.totScores.first.toDouble())/this.totDarts.first.toDouble()*3,
            (501-this.totScores.second.toDouble())/this.totDarts.second.toDouble()*3
        )
    }
}




class Leg(num: Int, firstPlayer: Boolean){
    val num = num
    val firstPlayer = firstPlayer

    var score: Pair<Int, Int> = Pair(501,501)
    var numDarts: Pair<Int, Int> = Pair(0,0)
    var closure:  Pair<Int, Int> = Pair(0, 0)
    var nineDarts: Pair<Boolean, Boolean> = Pair(false, false)


    fun updateScore(firstPlayer: Boolean, points: List<Int?>){

        var nd = 0
        var sum = 0

        for(i in 0..2){
            if(points[i]!=null){
                sum += points[i]!!
                nd=1
            }else{
                break
            }
        }

        if (firstPlayer){
            val firstScore = score.first
            numDarts.first.plus(nd)
            if (firstScore-sum<0){
                //todo: cosa fare quando sballi
                numDarts.first.plus(3)
            }else if(firstScore-sum>0) {
                numDarts.first.plus(3)
                score.first.minus(sum)
            }else{
                score.first.minus(sum)
                closure.first.plus(firstScore)
                if(numDarts.first == 9){
                    nineDarts.first.not()
                }
            }

        }else{
            val secondScore = score.second
            numDarts.second.plus(nd)
            if (secondScore-sum<0){
                numDarts.second.plus(3)
            }else if(secondScore-sum>0) {
                numDarts.second.plus(3)
                score.second.minus(sum)
            }else{
                score.second.minus(sum)
                closure.second.inc()
                if(numDarts.second == 9){
                    nineDarts.second.not()
                }
            }
        }
    }

    fun getAvg():Pair<Double, Double>{
        return Pair(
            (501-this.score.first.toDouble())/this.numDarts.first.toDouble()*3,
            (501-this.score.second.toDouble())/this.numDarts.second.toDouble()*3
        )
    }

}