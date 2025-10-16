public class BigNumber {
    private String number;

    public BigNumber(String n) {
        this.number = n;
    }

    public boolean equals(BigNumber n) {
        return this.number.equals(n.number);
    }

    public String toString() {
        return this.number;
    }

    public BigNumber add(BigNumber n) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = this.number.length() - 1;
        int j = n.number.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += this.number.charAt(i--) - '0';
            if (j >= 0) sum += n.number.charAt(j--) - '0';
            sb.insert(0, sum % 10); // units digit
            carry = sum / 10;
        }
        if (carry != 0) sb.insert(0, carry);
        return new BigNumber(sb.toString());
    }

    public BigNumber multiply(BigNumber n) {
        if (this.number.equals("0") || n.number.equals("0")) {
            return new BigNumber("0");
        }
        BigNumber result = new BigNumber("0");
        int i = this.number.length() - 1;
        int j = 0;

        while (i >= 0) {
            int digit = this.number.charAt(i--) - '0';
            BigNumber digitMult = n.multiplyDigit(digit);
            StringBuilder shifted = new StringBuilder(digitMult.number);
            for (int k = 0; k < j; k++) {
                shifted.append("0");
            }
            j++;
            digitMult.number = shifted.toString();
            result = result.add(digitMult);
        }
        return result;
    }

    private BigNumber multiplyDigit(int digit) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = this.number.length() - 1;
        while (i >= 0) {
            int mult = carry + digit * (this.number.charAt(i--) - '0');
            sb.insert(0, mult % 10);
            carry = mult / 10;
        }
        if (carry != 0) sb.insert(0, carry);
        return new BigNumber(sb.toString());
    }
}
