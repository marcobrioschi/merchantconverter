package biz.brioschi.merchantconverter.intergalacticmoney;

import java.util.Objects;

public class Money {

    final int money;

    Money(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public Money add(Money secondOperator) {
        return new Money(this.money + secondOperator.money);
    }

    public Money minus(Money secondOperator) {
        return new Money(this.money - secondOperator.money);
    }

    public Money mult(Money secondOperator) {
        return new Money(this.money * secondOperator.money);
    }

    public Money div(Money secondOperator) {
        return new Money(this.money / secondOperator.money);
    }

}
