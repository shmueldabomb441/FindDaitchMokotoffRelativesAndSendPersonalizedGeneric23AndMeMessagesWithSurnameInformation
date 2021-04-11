import org.apache.commons.codec.language.DaitchMokotoffSoundex

fun main() {
    val encoder= DaitchMokotoffSoundex()
    println(encoder.soundex("adelstein") +"+"+ encoder.soundex("eidelstein"))
}