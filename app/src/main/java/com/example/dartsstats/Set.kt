package com.example.dartsstats

import android.annotation.SuppressLint
import androidx.core.text.isDigitsOnly


class Game(
    var name1: String = "Player1", var name2: String = "Player2", var maxSet: Int = 6,
    var maxLeg: Int = 3, firstPlayer: Boolean = true){

    var currentSet = 0
    var currentLeg = 0
    var n180s = mutableListOf(0,0)
    //TODO: fai questo
    //quando servono ce il metodo get nine darts
    var sets = mutableListOf<Set>(Set(1,firstPlayer, maxLeg))
    var totScores = mutableListOf(0,0)
    var totDarts = mutableListOf(0,0)
    //penso si possa togliere
    var Scores =mutableListOf (mutableListOf(0,0,501), mutableListOf(0,0,501))
    //penso si possa togliere
    //todo: aggiungi checkout summary
    var closureStats = mutableMapOf("100+" to mutableListOf(0,0), "140+" to mutableListOf(0,0), "180" to mutableListOf(0,0), "Highest checkout" to mutableListOf(0,0), "100+ checkout" to mutableListOf(0,0), "Nine Darts" to mutableListOf(0,0))
    var avgs: MutableList<MutableList<Double>> = mutableListOf(mutableListOf(0.0,0.0), mutableListOf(0.0,0.0))


    var setsRecords: MutableList<String> = mutableListOf()
    var winner = -1



    //trova un nome migliore ti prego
    fun updateScore(points: List<Int?>, player: Boolean){
        sets.last().updateScore(player, points)
        //getNineDarts()
        setCurrent()

        val sum = getSum(points)
        val numDarts = getNumDarts(points)

        if(player){
            totScores[0]+=sum
            totDarts[0]+=numDarts
            if(sum==180){
                n180s[0]+=1
            }
        }else{
            totScores[1]+=sum
            totDarts[1]+=numDarts
            if(sum==180){
                n180s[1]+=1
            }
        }



        //updateAvg()




        getGameScore()

        if (sets.last().winner!=-1){
            updateRecords()
            var c1 = 0
            var c2 = 0
            for (s in sets){
                if (s.getWinner1()==1){
                    c1+=1
                }else{
                    c2+=1
                }
            }
            if(sets.size>=this.maxSet || c1>this.maxSet/2 || c2>this.maxSet/2){
                setWinner()
            }else {
                sets.add(Set(sets.last().num, sets.last().firstPlayer.not(), this.maxLeg))
                getGameScore()
            }
        }
        getClosure()
        updateAvg()


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


    fun getGameScore(){
        val scoreSet = mutableListOf(0,0)
        val scoreLeg = sets.last().getLegsScores()
        for (s in sets){
            //se winner==-1 allora non e finita e non fa niente
            //winner puo dare anchhe 0 se tipo pareggiano, non penso che sia possa pareggiarfe un set ma bo controlla e sistema
            if(s.winner==1){
               scoreSet[0]+=1
            }else if (s.winner==2){
                scoreSet[1]+=1
            }
        }



        this.Scores[0][0] = scoreSet[0]

        this.Scores[0][1] = scoreLeg[0]

        this.Scores[0][2] = this.sets.last().legs.last().score[0]

        this.Scores[1][0] = scoreSet[1]

        this.Scores[1][1] = scoreLeg[1]

        this.Scores[1][2] = this.sets.last().legs.last().score[1]



        //return Pair(listOf(scoreSet.first, scoreLeg.first, this.sets.last().legs.last().score.first), listOf(scoreSet.second, scoreLeg.second, this.sets.last().legs.last().score.second))

    }

    fun getClosure(): MutableMap<String, MutableList<Int>> {
//        this.closureStats["100+"] = mutableListOf(0, 0)
//        this.closureStats["140+"] =mutableListOf(0, 0)
//        this.closureStats["180"] = mutableListOf(0, 0)
//        this.closureStats["Highest checkout"] =mutableListOf(0, 0)
//        this.closureStats["100+ checkout"] = mutableListOf(0, 0)

        val n100 = mutableListOf(0, 0)
        val n140 =mutableListOf(0, 0)
        val n180 = mutableListOf(0, 0)
        val highest_checkout = mutableListOf(0, 0)
        val n100checkout = mutableListOf(0, 0)
        val nineDarts = mutableListOf(0,0)

        for (s in sets){
            n100[0] += s.n100[0]
            n140[0] += s.n140[0]
            n180[0] += s.n180s[0]
            n100checkout[0] += s.n100checkout[0]
            nineDarts[0] += s.nineDarts[0]

            n100[1] += s.n100[1]
            n140[1] += s.n140[1]
            n180[1] += s.n180s[1]
            n100checkout[1] += s.n100checkout[1]
            nineDarts[1] += s.nineDarts[1]

            if (s.highersCheckout[0] > highest_checkout[0]){
                highest_checkout[0] = s.highersCheckout[0]
            }
            if (s.highersCheckout[1] > highest_checkout[1]){
                highest_checkout[1] = s.highersCheckout[1]
            }

        }

        this.closureStats["100+"] = n100
        this.closureStats["140+"] = n140
        this.closureStats["180"] = n180
        this.closureStats["Highest checkout"] = highest_checkout
        this.closureStats["100+ checkout"] = n100checkout
        this.closureStats["Nine Darts"] = nineDarts


        return this.closureStats
    }



//    fun updateAvg(){
//        this.avgs["All"][0]=
//
//        this.avgs["All"]?.second?.let { this.avgs["All"]?.second? -= it) ?: 0 }
//
//        this.avgs[sets.last().num.toString()] = sets.last().getAvg()
//    }

    fun updateRecords(){
        this.setsRecords += this.Scores[0][0].toString()+"-"+this.Scores[1][0].toString()
    }

    @SuppressLint("DefaultLocale")
    fun updateAvg(){
        if(this.totDarts[0]==0) {
            this.avgs[0][0] = 0.0
        }else {
            this.avgs[0][0] = String.format("%.2f", this.totScores[0].toDouble() / this.totDarts[0].toDouble()*3).toDouble()
        }

        if(this.totDarts[1]==0) {
            this.avgs[0][1] = 0.0
        }else{
            this.avgs[0][1] =  String.format("%.2f", this.totScores[1].toDouble() / this.totDarts[1].toDouble()*3).toDouble()
        }

        for (i in 1 .. this.sets.size){
            if (this.avgs.size<=i){
                this.avgs.add(i,this.sets.last().getAvg())
            }else{
                this.avgs[i] =  this.sets[i-1].getAvg()
            }
        }
    }

    fun start(name1:String, name2: String, sets:String, legs: String){
        this.name1=name1
        this.name2=name2
        if(sets!="" && sets.isDigitsOnly()){
            this.maxSet=sets.toInt()
        }
        if(legs!="" && legs.isDigitsOnly()){
            this.maxLeg=legs.toInt()
            this.sets.last().maxLeg =legs.toInt()

        }

    }

    fun setWinner(){
        var c1 = 0
        var c2 = 0
        for (s in sets){
            if (s.getWinner1()==1){
                c1+=1
            }else{
                c2+=1
            }
        }
        if (c1>c2){
            this.winner =  1
        }else{
            this.winner=2
        }

    }






}

class Set(val num: Int, var firstPlayer: Boolean, var maxLeg: Int) {
    //firstPlayer: true -> player1 goes first, false-> player2
    var legs: MutableList<Leg> = mutableListOf(Leg(1,firstPlayer))
    var n180s: MutableList<Int> = mutableListOf(0,0)
    var winner = -1
    var totScores = mutableListOf(0,0)
    var totDarts = mutableListOf(0,0)
    var nineDarts = mutableListOf(0,0)


    var n100= mutableListOf(0,0)
    var n140 = mutableListOf(0,0)
    var highersCheckout = mutableListOf(0,0)
    var n100checkout = mutableListOf(0,0)

    //TODO: LE ROBE SUCCESSI
    var  checkoutSummary = mutableListOf(0,0)






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

        for (p in points) {
            if (p != null) {
                if (p == 180) {
                    if (player) {
                        n180s[0] += 1
                    } else {
                        n180s[1] += 1
                    }
                } else if (p >= 140) {
                    if (player) {
                        n140[0] += 1
                    } else {
                        n140[1] += 1
                    }
                } else if (p >= 100) {
                    if (player) {
                        n100[0] += 1
                    } else {
                        n100[1] += 1
                    }
                }
            }
        }


        if(player){
            totScores[0] += sum
            totDarts[0] += numDarts
        }else{
            totScores[1] += sum
            totDarts[1] += numDarts
        }

        legs.last().updateScore(player, points)
        //se il leg e finito
        if(legs.last().closure[0]!=0 || legs.last().closure[1]!=0){

            //guarda highest checkout
            if(legs.last().closure[0]>this.highersCheckout[0]){
                this.highersCheckout[0] = legs.last().closure[0]
            }
            if(legs.last().closure[1]>this.highersCheckout[1]){
                this.highersCheckout[1]= legs.last().closure[1]
            }

            //guarda +100checkout
            if(legs.last().closure[0]>100){
                this.n100checkout[0] += 1
            }
            if(legs.last().closure[1]>100){
                this.n100checkout[1] += 1
            }


            //guarda nine darts
            if(legs.last().numDarts[0] == 9){
                nineDarts[0] += 1
            }else if(legs.last().numDarts[0] == 9){
                nineDarts[1] += 1
            }


            var c1 = 0
            var c2 = 0
            for(l in legs){
                if(l.closure[0] != 0){
                    c1+=1
                }else{
                    c2+=1
                }
            }


            //se si sono raggiunti i leg per set il set e concluso
            if(legs.size>=maxLeg || c1>maxLeg/2 || c2>maxLeg/2){
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
            if(l.closure[0] != 0){
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


    @SuppressLint("DefaultLocale")
    fun getAvg():MutableList<Double>{
        val avg1: Double
        val avg2: Double
        if (this.totDarts[0] == 0){
            avg1 = 0.0
        }else {
            avg1 = String.format("%.2f", (this.totScores[0].toDouble()) / this.totDarts[0].toDouble() *3 ).toDouble()
        }

        if (this.totDarts[1] == 0){
            avg2 = 0.0
        }else {
            avg2 = String.format("%.2f", (this.totScores[1].toDouble()) / this.totDarts[1].toDouble() *3 ).toDouble()
        }

        return mutableListOf(avg1,avg2)

    }

    fun getLegsScores(): MutableList<Int> {
        val scoreLeg = mutableListOf(0,0)
        for (l in this.legs){
            //se winner==-1 allora non e finita e non fa niente
            //winner puo dare anchhe 0 se tipo pareggiano, non penso che sia possa pareggiarfe un set ma bo controlla e sistema
            if(l.closure[0]!=0){
                scoreLeg[0] += 1
            }else if (l.closure[1]!=0){
                scoreLeg[1] += 1
            }
        }
        return scoreLeg
    }
}




class Leg(val num: Int, val firstPlayer: Boolean){

    var score: MutableList<Int> = mutableListOf(501,501)
    var numDarts: MutableList<Int> = mutableListOf(0,0)
    var closure:  MutableList<Int> = mutableListOf(0, 0)
    var nineDarts: MutableList<Boolean> = mutableListOf(false, false)



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
            val firstScore = score[0]
            numDarts[0]+=nd
            if (firstScore-sum<0){
                //todo: cosa fare quando sballi
                numDarts[0]+=3
            }else if(firstScore-sum>0) {
                numDarts[0]+=3
                score[0] -= sum
            }else{
                score[0] -= sum
                closure[0]+=firstScore
                if(numDarts[0] == 9){
                    nineDarts[0]=true
                }
            }

        }else{
            val firstScore = score[1]
            numDarts[1]+=nd
            if (firstScore-sum<0){
                //todo: cosa fare quando sballi
                numDarts[1]+=3
            }else if(firstScore-sum>0) {
                numDarts[1]+=3
                score[1] -= sum
            }else{
                score[1] -= sum
                closure[1]+=firstScore
                if(numDarts[1] == 9){
                    nineDarts[1]=true
                }
            }
        }
    }

}