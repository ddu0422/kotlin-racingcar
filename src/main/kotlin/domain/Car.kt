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

    public fun move(value: Int): Car {
        return if (value >= 4) {
            Car(this.name, this.position + 1)
        } else {
            this
        }
    }
}
