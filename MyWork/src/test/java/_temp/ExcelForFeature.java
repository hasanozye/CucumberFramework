package _temp;

import utils.Utils;

public class ExcelForFeature {
    public static void main(String[] args) {
        String fileExcel = "MyWork/src/test/resources/datafiles/testCase.xlsx";
        String fileFeature = "MyWork/src/test/resources/features/testCaseFromExcel.feature";
        Utils.createFeatureFileFromExcel(fileExcel,fileFeature);
    }
}
