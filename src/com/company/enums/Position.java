package com.company.enums;

public enum Position {
    CEO(3.0, "Chief Executive Officer", "ceo"),
    CTO(2.5, "Chief Technical Officer", "cto"),
    SENIOR_DEVELOPER(2.0, "Senior Developer", "sd"),
    MIDDLE_DEVELOPER(1.5, "Middle Developer", "md"),
    JUNIOR_DEVELOPER(1.0, "Junior Developer", "jd");

    private final Double multiplier;
    private final String name;
    private final String codeName;

    Position(Double multiplier, String name, String codeName) {
        this.multiplier = multiplier;
        this.name = name;
        this.codeName = codeName;
    }

    public String getCodeName() {
        return codeName;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public String getName() {
        return name;
    }

    public String getTotalSalary(Double initialSalary) {
        return String.format("Salary of %s is %s",
                this.name,
                initialSalary * this.multiplier);
    }

    public static Position getByCodeName(String codeName) {
        if (codeName == null) {
            return null;
        }

        for (Position position : values()) {
            if (position.getCodeName().equals(codeName)) {
                return position;
            }
        }

        return null;
    }
}
