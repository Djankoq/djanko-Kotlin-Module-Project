class Notes(private val archive: Archive): Menu(){
    private val notes = archive.notes

    override fun showPointMenu() {
        println("0. Создать заметку")
        println("Заметки в архиве ${archive.name}:")
        notes.forEachIndexed{ index, note ->
            println("${index + 1}. ${note.title}")
        }
        println("${notes.size + 1}. Выход")
    }

    override fun addInput(input: Int) {
        when(input){
            0 -> {
                println("Введите название заметки:")
                val title = readLine()?.trim() ?: ""
                println("Введите текст заметки:")
                val text = readLine()?.trim() ?: ""
                if(title.isNotEmpty() && text.isNotEmpty()){
                    notes.add(Note(title, text))
                }
            }
            in 1 .. notes.size -> {
                println("Текст Заметки:")
                val note = notes[input-1]
                println(note.text)
            }
            notes.size + 1 -> {
                val archives = Archives()
                archives.start()
            }

            else -> println("Что-то не так. Попробуйте еще раз")
        }
    }

}

data class Note(val title: String, val text: String)