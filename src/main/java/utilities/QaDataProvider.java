package utilities;

public class QaDataProvider {
	public static QaExcelRead reader;

	/**
	 * 
	 * @param excelFileName
	 * @param Sheetname
	 * @return
	 * @throws Exception
	 */
	public static Object[][] getTestdata(String excelFileName, String Sheetname) throws Exception {
		String excelFilePath = System.getProperty("user.dir") + "\\data\\excel\\" + excelFileName + ".xlsx";
		
		return getExceldata(excelFilePath, Sheetname);
		
	}

	/**
	 * excel reading common method
	 * 
	 * @param excelFilePath
	 * @param Sheetname
	 * @return
	 * @throws Exception
	 */
	private static Object[][] getExceldata(String excelFilePath, String Sheetname) throws Exception {
		reader = new QaExcelRead(excelFilePath);
		int row = reader.getrowCount(Sheetname);
		int column = reader.getColumnCount(Sheetname);
		Object[][] data = new Object[row][column];
		for (int i = 0; i <row; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = reader.getData(Sheetname, i+1 , j);
			}
		}
		return data;
	}
	
}
