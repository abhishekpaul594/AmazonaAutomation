package methods;

public class Constants {

    public static final String CONFIGPATH="src/main/resources/cucumber.properties";
    public static final String HEADLESS="headless";
    public static final String ENVIRONMENT="src/test/resources/inputdata/Environments.yaml";
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public static final String DRIVERPATH = System.getProperty("user.dir") + FILE_SEPARATOR + "webdrivers";
    public static final String CHROMEDRIVER_PATH_WIN = DRIVERPATH + FILE_SEPARATOR + "chromedriver_win32/chromedriver.exe";
    public static final String CHROMEDRIVER_PATH_MAC = DRIVERPATH + FILE_SEPARATOR + "chromedriver_mac64/chromedriver";
    public static final String CHROMEDRIVER_PATH_LIN = DRIVERPATH + FILE_SEPARATOR + "chromedriver_linux64/chromedriver";

    public static final String PAGEOBJECT_PATH="src/test/resources/pageobject";

    public static final String INPUTDATA_PATH="src/test/resources/inputdata";

}
