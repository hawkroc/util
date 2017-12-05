package attact.attact;

public class Info {
	

	public static final String latipayUrl="https://merchant.latipay.co.nz/api/pay.action";
	public static final String tmd="http://www.tmdshop.co.nz/user.php?act=register";

	//public static final String latipayUrl="https://merchant.latipay.co.nz/api/pay.action";

	public	final static String url = "https://merchant.latipay.co.nz/api/pay.action";

	public static String currency = "NZD";
	// static String amount = "28.33";//random
	public static String merchantCode ="M00000782";//"M00000777";
	public static String frontUrl = "http://www.post2u.co.nz/pay/latipay_callback.php";//"http://www.ailulv.com/latipay/payment/response/";
	public static String key = "AMZdacxz0123456789";//"246810";//"0123456789AMZdacxz";
	// static String quantity="2";//random
	public static String backUrl ="";// "http://www.post2u.co.nz/pay/latipay_notify.php";
	public static String itemName = "邮购宝";
	public static String version = "1.0";
	public static String date = Util.getDays(null);
	public static String gatewayCode = "1";

	// private String [] mailList=;
	

	// post('/api/user/register', data, function (resp) { chode
	public static long getN() {
		return n;
	}

	public synchronized static void setN() {

		n++;

	}

	private static long n = 0;

	public static long getErrorTimes() {
		return errorTimes;
	}

	public synchronized static void setErrorTimes() {
		errorTimes++;
	}

	private static long errorTimes = 0;

	public static long getException() {
		return exception;
	}

	public synchronized static void setException() {
		exception++;
	}

	private static long exception = 0;
	
	
	public static String   chode_austgo ="http://austgo.com.au/api/user/register";
	public static String   chode_vipugg ="http://www.vipugg.com/api/user/register";
	
	//public static RequestBody requestBody=
	
	
	
	

	public static String toMemoryInfo() {

		Runtime currRuntime = Runtime.getRuntime();
		int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
		int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
		float precent = (float) nFreeMemory / (float) nTotalMemory;
		return nFreeMemory + "M/" + nTotalMemory + "M(free/total)" + precent;
	}

}
