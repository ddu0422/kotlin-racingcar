package domain.exception

public class InvalidCarNameException : RuntimeException(MESSAGE) {
    private companion object {
        const val MESSAGE = "자동차 이름은 5자 이상이여야합니다."
    }
}
