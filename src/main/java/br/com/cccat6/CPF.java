package br.com.cccat6;

import lombok.Getter;

public class CPF {
    private static int SIZE_DEFAULT = 11;
    private static int START_MULTIPLY = 2;
    private static int DIVISOR = 11;
    private static int MINIMUN_REST = 2;

    @Getter
    private String digits;

    public CPF(String digits){
        if(!validate(digits)){
            throw new RuntimeException("CPF inválido!");
        }
        this.digits = digits;
    }

    private boolean validate(String documment) {
        documment = clearInvalidDigits(documment);
        if (isValid(documment)) {
            String nineCharacters = documment.substring(0,9);
            int firstVerifierDigit = calculate(nineCharacters);
            int secondVerifierDigit = calculate(nineCharacters + firstVerifierDigit);
            String docummentVerifierDigit = extractVerifierDigit(documment);
            String calculatedVerifierDigit = firstVerifierDigit+""+secondVerifierDigit;
            return calculatedVerifierDigit.equals(docummentVerifierDigit);
        }
        return false;
    }

    private String extractVerifierDigit(String documment){
        return documment.substring(documment.length()-2,documment.length());
    }

    private boolean isValid(String documment){
        if(documment == null || documment.equals("")) return false;
        if(isIdenticalDigits(documment)) return false;
        if(!isValidSize(documment)) return false;
        return true;
    }

    private boolean isValidSize(String documment){
        return documment.length() == SIZE_DEFAULT;
    }

    private boolean isIdenticalDigits(String documment){
        for(int idx = 0; idx < documment.length(); idx++){
            if(documment.charAt(idx) != documment.charAt(0))
                return false;
        }
        return true;
    }

    private String clearInvalidDigits(String documment){
        return documment.replace(".", "")
                .replace("-", "")
                .replace(" ", "")
                .trim();
    }

    private int calculate(String documment){
        int digit = documment.length()-1;
        int multply = START_MULTIPLY;
        int sum = 0;
        while(digit >= 0){
            sum += Integer.parseInt(documment.charAt(digit)+"") * multply;
            digit--;
            multply++;
        }
        int rest = sum % DIVISOR;
        int result = (rest < MINIMUN_REST) ?  0 : DIVISOR - rest;
        return  result;
    }
}
