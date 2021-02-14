package domain

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CarTest : ShouldSpec({
    should("이름과 현재 위치가 같은 경우 같은 객체") {
        Car("mirmir", 0) shouldBe Car("mirmir", 0)
    }
})