package domain

import domain.exception.InvalidCarNameException

public data class Car(
    val name: String,
    val position: Int,
) {

    private companion object {
        const val CAR_NAME_LENGTH_CONDITION = 5
    }

    init {
        validName(name)
    }

    private fun validName(name: String) {
        if (name.length < CAR_NAME_LENGTH_CONDITION) {
            throw InvalidCarNameException()
        }
    }
}
