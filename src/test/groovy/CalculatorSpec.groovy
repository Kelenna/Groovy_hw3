import spock.lang.Unroll

class CalculatorSpec extends BaseSpec {
    def setupSpec() {
        c_calc.open()
    }

    @Unroll
    def "Button-value test #button = #value"() {
        given:
        c_calc.clear()

        expect:
        calc.check_value (button) == value

        where:
        button          | value
        "0"             |"0"
        "1"             |"1"
        "2"             |"2"
        "3"             |"3"
        "4"             |"4"
        "5"             |"5"
        "6"             |"6"
        "7"             |"7"
        "8"             |"8"
        "9"             |"9"

    }

    @Unroll
    def "Zero div-mult test #expression = #result"() {
        given:
        calc.clear()

        expect:
        calc.calculate(expression) == result

        where:
        expression          | result
        "1/0"               | "Infinity"
        "0/0"               | "NaN"
        "-1/0"              | "-Infinity"
        "0/1"               | "0"
        "0/-1"              | "0"
        "0.1/0"             | "Infinity"
        "-0.1/0"            | "-Infinity"
        "1x0"               | "0"
        "0x0"               | "0"
        "-1x0"              | "0"
        "0.1x0"             | "0"
        "-0.1x0"            | "0"
        "1."                | "1"
        "1.."               | "1"
        "0."                | "0"
        "-1."               | "1"
        ".1"                | "1"
        "..1"               | "1"
        "-.1"               | "-1"
        "-..1"              | "-1"
        "0..1"              | "0.1"
        "-0..1"             | "-0.1"
        "99999999999999999x99999999999999999" | "1e+34"
        "0.000000000000000x0.000000000000000" | "0"

    }


}
