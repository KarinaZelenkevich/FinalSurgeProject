package models;

public class ReportsFactory{
    public static Reports getReportInform() {
        return Reports.builder()
                .startDate("02/01/2022")
                .endDate("02/26/2022")
                .activityType("Run")
                .build();
    }
}
