package com.company.date;

public enum Position {
    CEO(4.0, "ceo"),
    CTO(3.7, "cto"),
    TEAM_LEADER(3.0, "team"),
    TECH_LEADER(3.0, "tech"),
    SENIOR_DEVELOPER(2.0, "senior"),
    DEVELOPER(1.5, "middle"),
    JUNIOR_DEVELOPER(1.0, "junior");

    private Double salaryMultiplier;
    private String code;

    Position(Double salaryMultiplier, String code) {
        this.salaryMultiplier = salaryMultiplier;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Double getSalaryMultiplier() {
        return salaryMultiplier;
    }

    public static Position getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (Position position : values()) {
            if (position.getCode().equals(code)) {
                return position;
            }
        }

        return null;
    }
}
