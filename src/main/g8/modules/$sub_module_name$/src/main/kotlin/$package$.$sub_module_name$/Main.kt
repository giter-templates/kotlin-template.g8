package $package$.$sub_module_name$

import com.sksamuel.hoplite.ConfigFailure
import com.sksamuel.hoplite.ConfigLoader
import com.sksamuel.hoplite.fp.Validated

fun main(args: Array<String>): Unit {
    val configuration: Validated<ConfigFailure, Configuration> = ConfigLoader().loadConfig("/application.conf")

    when (configuration) {
        is Validated.Invalid ->
            println(configuration.error.description())
        is Validated.Valid ->
            println(configuration.value)
    }
}
