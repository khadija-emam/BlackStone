
fun main(){
    val w1="nory"
    val w2="rony"

    if (checkAnagrams(w1,w2)){
        println("equal")
    }else{
        println("error")
    }

    println( generateFibonacci(9))
    println( getFibonacci(9))
    println(calculate())


}
    fun checkAnagrams(word1:String,word2:String):Boolean{
        // check the length
        if (word1.length!=word2.length){
            return false
        }

        // convert the two strings to two arrays and sort them
        val ara1=word1.toCharArray()
        val ara2=word2.toCharArray()

        ara1.sort()
        ara2.sort()


        val com1= String(ara1)
        val com2= String(ara2)

        // return true if the two words are equal
        return com1==com2
    }
 // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
    fun generateFibonacci(num:Int):Int{
        if (num<=1){
            return num
        }
       return generateFibonacci(num-1)+generateFibonacci(num-2)
    }
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 fun getFibonacci(n: Int):Int{
     // make an array of the size n+2 to handle the case of n=0
  val ara= IntArray(n+2)
      // store 0,1 to the first two elements in the array
      ara[0]=0
      ara[1]=1

      var i=2
      // make i=2 to start the array from 2
      while (i <=n){
          ara[i]=ara[i-1]+ara[i-2]
          i++
      }

      return ara[n]

  }

fun calculate(): Double {
    return (2.25.plus(4.5).div(1.25.div(5)))
}


