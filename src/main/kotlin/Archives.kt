val archives = mutableListOf<Archive>()
class Archives: Menu() {


    override fun showPointMenu() {
        println("0. Создать архив")
        println("Список архивов: ")
        archives.forEachIndexed{ index, archive ->
            println("${index + 1}. ${archive.name}")
        }
        println("${archives.size + 1}. Выход")
    }

    override fun addInput(input: Int) {
        when(input){
            0 -> {
                println("Введите название архива:")
                val name = readLine()?.trim() ?: ""
                if(name.isNotEmpty()){
                    archives.add(Archive(name))
                }
            }
            in 1 ..  archives.size -> {
                val archive = archives[input - 1]
                val noteMenu = Notes(archive)
                noteMenu.start()
            }
            archives.size + 1 -> {
                println("Пока-пока!")
                System.exit(0)}
            else -> println("Что-то не так. Попробуйте еще раз")

        }
    }
}

data class Archive(val name: String){
    val notes = mutableListOf<Note>()
}