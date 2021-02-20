package domain.exception

public object InvalidCarNameException : RuntimeException("자동차 이름은 5자 이상이여야합니다.")
public object InvalidCarPositionException : RuntimeException("자동차 위치는 0보다 작을 수 없습니다.")