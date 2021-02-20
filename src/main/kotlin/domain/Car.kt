package domain

import domain.exception.InvalidCarNameException
import domain.exception.InvalidCarPositionException

public data class Car(
    val name: String,
    val position: Int,
) {

    private companion object {
        const val CAR_NAME_LENGTH_CONDITION = 5
        const val CAR_POSITION_LIMIT = 0
        const val MOVE_CONDITION = 4
        const val MOVE_POSITION = 1
    }

    init {
        validName(name)
        validPosition(position)
    }

    private fun validName(name: String) {
        if (name.length < CAR_NAME_LENGTH_CONDITION) {
            throw InvalidCarNameException
        }
    }

    private fun validPosition(position: Int) {
        if (position < CAR_POSITION_LIMIT) {
            throw InvalidCarPositionException
        }
    }

    public fun move(value: Int): Car {
        return if (value >= MOVE_CONDITION) {
            Car(this.name, this.position + MOVE_POSITION)
        } else {
            this
        }
    }
}
