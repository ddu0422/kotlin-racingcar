package domain

import domain.exception.InvalidCarNameException
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    val correctName = "mirmir"
    val initialPosition = 0

    "이름과 현재 위치가 같은 경우 같은 객체" {
        Car(correctName, initialPosition) shouldBe Car(correctName, initialPosition)
    }

    "이름 길이가 5자 미만인 경우 자동차 객체를 생성 불가" {
        listOf("", "a", "ab", "abc", "abcd", "abcd").forAll {
            shouldThrow<InvalidCarNameException> {
                Car(it, initialPosition)
            }.message shouldBe "자동차 이름은 5자 이상이여야합니다."
        }
    }

    "이름 길이자 5자 이상인 경우 자동차 객체를 생성 가능" {
        val car = shouldNotThrowAny {
            Car(correctName, initialPosition)
        }
        car.name shouldBe correctName
        car.position shouldBe initialPosition
    }

    "4 이상인 경우 자동차 이동 가능" {
        val car = Car(correctName, initialPosition)
        car.move(4) shouldBe Car(correctName, initialPosition + 1)
    }

    "3 이하인 경우 자동차 이동 불가" {
        val car = Car(correctName, initialPosition)
        car.move(3) shouldBe Car(correctName, initialPosition)
    }
})