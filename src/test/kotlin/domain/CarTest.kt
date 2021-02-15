package domain

import domain.exception.InvalidCarNameException
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : StringSpec({
    "이름과 현재 위치가 같은 경우 같은 객체" {
        Car("mirmir", 0) shouldBe Car("mirmir", 0)
    }

    "이름 길이가 5자 미만인 경우 자동차 객체를 생성 불가" {
        listOf("", "a", "ab", "abc", "abcd", "abcd").forAll {
            shouldThrow<InvalidCarNameException> {
                Car(it, 0)
            }.message shouldBe "자동차 이름은 5자 이상이여야합니다."
        }
    }

    "이름 길이자 5자 이상인 경우 자동차 객체를 생성 가능" {
        val car = shouldNotThrowAny {
            Car("mirmir", 0)
        }
        car.name shouldBe "mirmir"
        car.position shouldBe 0
    }
})