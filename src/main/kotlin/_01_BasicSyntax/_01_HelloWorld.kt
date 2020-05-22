//@file:JvmName("Escolha_um_nome")              //TODO: java interop = use essa anotação para definir o nome da classe java que será gerada

package _01_BasicSyntax                         //TODO: package == java

import java.time.LocalDateTime                  //TODO: import == java



/**
 * Uma função pode existir por si só, sem pertencer a uma classe.
 */
fun main(args: Array<String>) {                                  //TODO: Array<String> == String[]
    val hello = "Hello World"                                    //TODO: val ~= final var
    var now = LocalDateTime.now()                   //TODO: var == java, ';' não é necessário

    print("$hello at ${now.hour}h com uma $CONSTANTE_QUALQUER.") //TODO: interpolação com $ ou ${}
}


const val CONSTANTE_QUALQUER = "CONSTANTE QUALQUER"             //TODO constantes em tempo de compilação

