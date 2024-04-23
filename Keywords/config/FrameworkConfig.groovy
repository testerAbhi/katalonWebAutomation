package config

import utils.FileOperations

public class FrameworkConfig {
	public static String webUseremail = FileOperations.getValueFromDataFile(Constant.USERDATA, "WebUserEmail")
	public static String webUserPassword = FileOperations.getValueFromDataFile(Constant.USERDATA, "WebUserPassword")
	
}
