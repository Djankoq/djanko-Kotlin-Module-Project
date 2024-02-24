abstract class Menu{
    abstract fun showPointMenu()
    abstract fun addInput(input: Int)

    fun start(){
        while(true){
            showPointMenu()
            val input = readln()?.toIntOrNull()?: -1
            addInput(input)
        }
    }
}
fun main(){
    val archives = Archives()
    archives.start()
}