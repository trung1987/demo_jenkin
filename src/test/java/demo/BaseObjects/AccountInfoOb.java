package demo.BaseObjects;

public class AccountInfoOb {

	public static String AccountInfoHeaderXpath = "//h2[contains(text(),'Access details')]";
	public static String userInfo ="//td[contains(.,'ID')]/following-sibling::td";
	public static String passInfo ="//td[contains(.,'Password ')]/following-sibling::td";
}
