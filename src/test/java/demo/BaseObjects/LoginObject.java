package demo.BaseObjects;

public class LoginObject {

	/*public WebDriver Localdriver;
	public BaseActions actions;
	public String url ="http://demo.guru99.com/v4/";
	@FindBy(xpath="//input[@name='uid']")
	public WebElement txtUserID;
	

	@FindBy(xpath="//input[@name='password']")
	public WebElement txtPassword;

	
	@FindBy(xpath="//input[@name='btnLogin']")
	public WebElement btnLogin;

	@FindBy(xpath="//input[@name='btnReset']")
	public WebElement btnReset;*/
	//==
	
	//khai bao element error mess??
	
	//==
	
	/*//contrustor
	public LoginObject(WebDriver globalDriver) {
		Localdriver = globalDriver; //noi ro khi qua phan testcase
		actions = new BaseActions(); 
		//
		PageFactory.initElements(Localdriver, this); //init het toan bo
	}
	*/
	
	public static String xpathUserID = "//input[@name='uid']";
	public static String xpathPassWord = "//input[@name='password']";
	public static String xpathbtnLogin = "//input[@name='btnLogin']";
	public static String xpathbtnReset = "//input[@name='btnReset']";
	public static String URL ="http://demo.guru99.com/v4/";
	public static String hereLink = "//a[contains(text(),'here')]";
	
}
